package hkins.baseplatform.interceptor;

import org.aspectj.lang.JoinPoint;

import hkins.baseplatform.jdbc.datasource.DataSourceContextHolder;

public class DataSourceInterceptor {
	
	public void setBaseDataSource(JoinPoint jp) {
		DataSourceContextHolder.setDbType("dataSource_Base");
	}
	
	public void setDcDataSource(JoinPoint jp) {
		DataSourceContextHolder.setDbType("dataSource_DC");
	}
}
