package hkins.baseplatform.jdbc.dao;

import java.util.List;
import java.util.Map;

import hkins.baseplatform.jdbc.paging.Paging;

public abstract interface BaseDao<T> {
    public abstract T selectOne(String paramString);
    
    public abstract T selectOne(String paramString, Object paramObject);
    
    public abstract List<T> selectList(String paramString);
    
    public abstract List<T> selectList(String paramString, Object paramObject);
    
    public abstract <K, V> Map<K, V> selectMap(String paramString, String mapKey);
    
    public abstract <K, V> Map<K, V> selectMap(String paramString, Object paramObject, String mapKey);
    
    public abstract Paging<T> selectPaging(String paramString, int pageNumber, int pageSize);
    
    public abstract Paging<T> selectPaging(String paramString, Object paramObject, int pageNumber, int pageSize);
    
    public abstract int insert(String paramString);
    
    public abstract int insert(String paramString, Object paramObject);
    
    public abstract int insert(T paramT);
    
    public abstract int insert(List<T> paramList);
    
    public abstract int update(String paramString);
    
    public abstract int update(String paramString, Object paramObject);
    
    public abstract int update(T paramT);
    
    public abstract int update(List<T> paramList);
    
    public abstract int delete(String paramString);
    
    public abstract int delete(String paramString, Object paramObject);
    
    public abstract int delete(List<T> paramList);
    
    public abstract int delete(String paramString, List<Object> paramList);
}
