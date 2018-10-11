package com.sinosoft.demo.core.util;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseCustomServiceImpl extends BaseServiceImpl {

    /**
     * @description jpql查询参数、分页参数设置
     * @param dataQuery
     * @param pageNo
     * @param pageSize
     * @param paraMap
     */
    public void setQueryParam(Query dataQuery, Integer pageNo, Integer pageSize, Map<String,Object> paraMap){
        //1、设置参数
        for (String key : paraMap.keySet()) {
            dataQuery.setParameter(key,paraMap.get(key));
        }
        //2、设置分页

        if(pageNo!=null) {
            dataQuery.setFirstResult((pageNo - 1) * pageSize);
        }
        if(pageSize!=null) {
            dataQuery.setMaxResults(pageSize);
        }
    }


    /**
     * @description jpql查询参数、无分页参数设置
     * @param dataQuery
     * @param paraMap
     */
    public void setQueryParam(Query dataQuery, Map<String,Object> paraMap){
        setQueryParam(dataQuery,null,null,paraMap);
    }

    /**
     * @description jpql设置统一返回类型
     * @param list
     * @param pageNo
     * @param dtoClass
     * @param <T>
     * @return
     */
    public <T> PageInfo<T> setPageInfo(List<?> list, int pageNo, Class<T> dtoClass){
        List<T> listDto=new ArrayList<T>(list.size());
        //生成response pageinfo格式
        PageInfo<T> pageInfo=new PageInfo<>();

        convertCollection(list,listDto,dtoClass);
        pageInfo.setContent(listDto);
        pageInfo.setPages(pageNo);
        pageInfo.setTotalCount(list.size());
        return  pageInfo;
    }

}
