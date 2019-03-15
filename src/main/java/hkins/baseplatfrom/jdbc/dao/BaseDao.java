package hkins.baseplatfrom.jdbc.dao;

import java.util.List;
import java.util.Map;
import hkins.baseplatfrom.jdbc.paging.Paging;

public abstract interface BaseDao<T> {
    public abstract T selectOne(String paramString);
    
    public abstract T selectOne(String paramString, Object paramObject);
    
    public abstract List<T> selectList(String paramString);
    
    public abstract List<T> selectList(String paramString, Object paramObject);
    
    public abstract <K, V> Map<K, V> selectMap(String paramString1, String paramString2);
    
    public abstract <K, V> Map<K, V> selectMap(String paramString1, Object paramObject, String paramString2);
    
    public abstract Paging<T> selectPaging(String paramString, int paramInt1, int paramInt2);
    
    public abstract Paging<T> selectPaging(String paramString, Object paramObject, int paramInt1, int paramInt2);
    
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
