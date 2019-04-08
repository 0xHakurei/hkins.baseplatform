package hkins.baseplatform.jdbc.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import hkins.baseplatform.jdbc.dao.BaseDao;
import hkins.baseplatform.jdbc.entity.BaseEntity;
import hkins.baseplatform.jdbc.paging.Paging;
import hkins.baseplatform.jdbc.paging.TotalCountHandler;
import hkins.baseplatform.util.StringUtil;

public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T>{
    
	protected static final Log LOG = LogFactory.getLog(BaseDaoImpl.class);
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public static final String SQL_INSERT = "insert";
	public static final String SQL_BATCH_INSERT = "batchInsert";    
	public static final String SQL_BATCH_UPDATE = "batchUpdate";
	public static final String SQL_BATCH_DELETE = "batchDel";
	public static final String SQL_UPDATE_BY_ID = "update";
	
	private void statementCheck(String statement) {
		if(StringUtil.isEmpty(statement)) {
			throw new IllegalArgumentException("argument [statement] is empty, check your sql statement");
		}
	}
	
	private void parameterCheck(Object parameterObj) {
		if (parameterObj == null) {
			throw new IllegalArgumentException("argument [parameterObj] is null, chech your query function implementation");
		}
	}
	
	private void pageSizeCheck(int pageSize) {
		if (pageSize < 1) {
			throw new IllegalArgumentException("Pagesize illegal! Check your paging implementation");
		}
	}
	
	private void pageNumberCheck(int pageNumber) {
		if (pageNumber < 1) {
			throw new IllegalArgumentException("Pagenumber illegal! Check your paging implementation");
		}
	}
	
	private void mapKeyCheck(String key) {
		if (StringUtil.isEmpty(key)) {
			throw new IllegalArgumentException("There is a empty key in your Map dataset, check your query function implementation ");
		}
	}
	
	private RowBounds createRowBounds(int pageNumber, int pageSize) {
		int offset = (pageNumber - 1) * pageSize;
		return new RowBounds(offset, pageSize);
	}
	
	private Paging<T> executeSelectPaging(String paramString, Object paramObject, int pageNumber, int pageSize){
		RowBounds rowBounds  = createRowBounds(pageNumber, pageSize);
		List<T> list = this.sqlSessionTemplate.selectList(getStatement(paramString), paramObject, rowBounds);
		try {
			int totalCount = TotalCountHandler.get();
			return new Paging<T>(pageNumber, pageSize, totalCount, list);
		} finally {
			TotalCountHandler.remove();
		}
	}
	
	public String getStatement(String sqlStatement) {
		String name = getClass().getName();
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(name).append(".").append(sqlStatement);
		return strBuilder.toString();
	}
	
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	
    public T selectOne(String paramString) {
        statementCheck(paramString);
        return this.sqlSessionTemplate.selectOne(getStatement(paramString));
    }

    
    public T selectOne(String paramString, Object paramObject) {
        statementCheck(paramString);
        parameterCheck(paramObject);
        return this.sqlSessionTemplate.selectOne(getStatement(paramString), paramObject);
    }

    
    public List<T> selectList(String paramString) {
        statementCheck(paramString);
        return this.sqlSessionTemplate.selectOne(getStatement(paramString));
    }

    
    public List<T> selectList(String paramString, Object paramObject) {
        statementCheck(paramString);
        return this.sqlSessionTemplate.selectList(getStatement(paramString), paramObject);
    }

    
    public <K, V> Map<K, V> selectMap(String paramString, String mapKey) {
    	statementCheck(paramString);
    	mapKeyCheck(mapKey);
        return this.sqlSessionTemplate.selectMap(paramString, mapKey);
    }

    
    public <K, V> Map<K, V> selectMap(String paramString, Object paramObject, String mapKey) {
    	statementCheck(paramString);
    	mapKeyCheck(mapKey);
    	parameterCheck(paramObject);
        return this.sqlSessionTemplate.selectMap(paramString, paramObject, mapKey);
    }

    
    public Paging<T> selectPaging(String paramString, int pageNumber, int pageSize) {
    	statementCheck(paramString);
    	pageNumberCheck(pageNumber);
    	pageSizeCheck(pageSize);
        return executeSelectPaging(paramString, null, pageNumber, pageSize);
    }

    
    public Paging<T> selectPaging(String paramString, Object paramObject, int pageNumber, int pageSize) {
    	statementCheck(paramString);
    	parameterCheck(paramObject);
    	pageNumberCheck(pageNumber);
    	pageSizeCheck(pageSize);
        return executeSelectPaging(paramString, paramObject, pageNumber, pageSize);
    }

    
    public int insert(String paramString) {
    	statementCheck(paramString);
        return this.sqlSessionTemplate.insert(paramString);
    }

    
    public int insert(String paramString, Object paramObject) {
    	statementCheck(paramString);
    	parameterCheck(paramObject);
        return this.sqlSessionTemplate.insert(paramString, paramObject);
    }

    
    public int insert(T paramT) {
    	parameterCheck(paramT);
        return this.sqlSessionTemplate.insert(getStatement(SQL_INSERT), paramT);
    }

    
    public int insert(List<T> paramList) {
        parameterCheck(paramList);
        return this.sqlSessionTemplate.insert(getStatement(SQL_BATCH_INSERT), paramList);
    }

    
    public int update(String paramString) {
    	statementCheck(paramString);
        return this.sqlSessionTemplate.update(paramString);
    }

    
    public int update(String paramString, Object paramObject) {
    	statementCheck(paramString);
    	parameterCheck(paramObject);
        return this.sqlSessionTemplate.update(paramString, paramObject);
    }

    
    public int update(T paramT) {
        parameterCheck(paramT);
        return this.sqlSessionTemplate.update(SQL_UPDATE_BY_ID, paramT);
    }

    
    public int update(List<T> paramList) {
        parameterCheck(paramList);
        return this.sqlSessionTemplate.update(getStatement(SQL_BATCH_UPDATE), paramList);
    }

    
    public int delete(String paramString) {
    	statementCheck(paramString);
        return this.sqlSessionTemplate.delete(paramString);
    }

    
    public int delete(String paramString, Object paramObject) {
    	statementCheck(paramString);
    	parameterCheck(paramObject);
        return this.sqlSessionTemplate.delete(paramString, paramObject);
    }

    
    public int delete(List<T> paramList) {
        parameterCheck(paramList);
        return this.sqlSessionTemplate.delete(getStatement(SQL_BATCH_DELETE), paramList);
    }

    
    public int delete(String paramString, List<Object> paramList) {
    	statementCheck(paramString);
    	parameterCheck(paramList);
        return this.sqlSessionTemplate.delete(getStatement(paramString), paramList);
    }

   
}
