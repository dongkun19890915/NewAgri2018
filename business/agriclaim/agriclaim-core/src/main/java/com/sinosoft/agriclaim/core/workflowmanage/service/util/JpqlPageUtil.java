package com.sinosoft.agriclaim.core.workflowmanage.service.util;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;

import javax.persistence.Query;
import java.util.Map;

public class JpqlPageUtil {

    private static BaseServiceImpl baseService;

    static {
        baseService=new BaseServiceImpl();
    }

    /**
     * @description jpql查询参数、分页参数设置
     * @param dataQuery
     * @param pageNo
     * @param pageSize
     * @param paraMap
     */
    public static void querySetParam(Query dataQuery, Integer pageNo, Integer pageSize, Map<String,Object> paraMap){
        //1、设置参数
        for (String key : paraMap.keySet()) {
            dataQuery.setParameter(key,paraMap.get(key));
        }

        //2、设置分页
        if(pageNo!=null) {
            dataQuery.setFirstResult((pageNo - 1) * pageSize);
        }
        if(pageSize!=null) {
            dataQuery.setMaxResults(pageNo * pageSize);
        }
    }



//    public <T> PageInfo<T> setPageInfo(List<?> list, int pageNo, Class<T> dtoClass){
//
//        List<T> listDto=new ArrayList<T>(list.size());
//
//        //生成response pageinfo格式
//        PageInfo<T> pageInfo=new PageInfo<>();
//
//
//        convertCollection(list,listDto,dtoClass);
//
//        pageInfo.setContent(listDto);
//        pageInfo.setPages(pageNo);
//        pageInfo.setTotalCount(list.size());
//        return  pageInfo;
//    }
}
