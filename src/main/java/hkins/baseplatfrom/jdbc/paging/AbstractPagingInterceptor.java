package hkins.baseplatfrom.jdbc.paging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.RowBounds;


public abstract class AbstractPagingInterceptor implements Interceptor {
    private static final String PROP_PAGING = "paging";
    private static final String PROP_PAGING_DEFAULT = "Paging";
    private String paging;
    
    public void setProperties(Properties properties) {
        this.paging = properties.getProperty(PROP_PAGING, PROP_PAGING_DEFAULT);
    }
    
    public Object plugin(Object targetObject) {
        if((targetObject instanceof StatementHandler)) {
            return Plugin.wrap(targetObject, this);
        }
        return targetObject;
    }
    
    public Object intercept(Invocation invocation) throws Throwable{
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
        String statementId = mappedStatement.getId();
        if(!statementId.endsWith(this.paging)) {
            return invocation.proceed();
        }
        RowBounds rowBounds = (RowBounds)metaObject.getValue("delegate.rowBounds");
        String pagingSql = getPagingSql(sql ,rowBounds);
        
        metaObject.setValue("delegate.boundSql.sql", pagingSql);
        metaObject.setValue("delegate.rowBounds.offset", Integer.valueOf(0));
        metaObject.setValue("delegate.rowBounds.limit", Integer.valueOf(Integer.MAX_VALUE));
        
        Connection connection = (Connection)invocation.getArgs()[0];
        ParameterHandler parameterHandler = statementHandler.getParameterHandler();
        int totalCount = getTotalCount(connection, sql, parameterHandler);
        TotalCountHandler.set(totalCount);
        
        return invocation.proceed();
    }

    private int getTotalCount(Connection connection, String sql, ParameterHandler parameterHandler) throws SQLException {
        int result = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String countSql = getCountSql(sql);
            preparedStatement = connection.prepareStatement(countSql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } finally {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
        }
        return result;
    }

    protected abstract String getCountSql(String sql);

    public abstract String getPagingSql(String sql, RowBounds rowBounds);
    
}
