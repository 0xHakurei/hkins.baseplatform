package hkins.baseplatfrom.jdbc.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import hkins.baseplatfrom.jdbc.dao.BaseDao;
import hkins.baseplatfrom.jdbc.entity.BaseEntity;
import hkins.baseplatfrom.jdbc.paging.Paging;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T>{
    
    
    @Override
    public T selectOne(String paramString) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T selectOne(String paramString, Object paramObject) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> selectList(String paramString) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> selectList(String paramString, Object paramObject) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <K, V> Map<K, V> selectMap(String paramString1, String paramString2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <K, V> Map<K, V> selectMap(String paramString1, Object paramObject, String paramString2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paging<T> selectPaging(String paramString, int paramInt1, int paramInt2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paging<T> selectPaging(String paramString, Object paramObject, int paramInt1, int paramInt2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(String paramString) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(String paramString, Object paramObject) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(T paramT) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(List<T> paramList) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(String paramString) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(String paramString, Object paramObject) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(T paramT) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(List<T> paramList) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(String paramString) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(String paramString, Object paramObject) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(List<T> paramList) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(String paramString, List<Object> paramList) {
        // TODO Auto-generated method stub
        return 0;
    }

   
}
