package com.sinosoft.framework.agri.core.service.impl;

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
     * 拼接条件sql 语句，自动关联或去掉 and or连接符
     * @param conditionList
     * @return String 拼接后的sql条件语句
     */
    public String joinCondition(List<String> conditionList){
        //拼接条件
        int i=0;
        StringBuilder sb=new StringBuilder();
        for(String str:conditionList){
            //如果是第一个查询条件，去掉and or 逻辑连接符
            if(i==0){
                str=str.replaceFirst("(?i)and|or "," ");
            }
            sb.append(" ").append(str);
            i++;
        }
        sb.append(" ");
        return sb.toString();
    }

    /**
     *  jpql设置统一返回类型
     * @param list
     * @param pageNo
     * @param totalSize
     * @param dtoClass
     * @param <T>
     * @return
     */
    public <T> PageInfo<T> setPageInfo(List<?> list, int pageNo,long totalSize, Class<T> dtoClass){
        List<T> listDto=new ArrayList<T>(list.size());
        //生成response pageinfo格式
        PageInfo<T> pageInfo=new PageInfo<>();

        convertCollection(list,listDto,dtoClass);
        pageInfo.setContent(listDto);
        pageInfo.setPages(pageNo);
        pageInfo.setTotalCount(totalSize);
        return  pageInfo;
    }

}
