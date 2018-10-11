package com.sinosoft.demo.elasticsearch.dto;

import com.sinosoft.esClient.core.annotation.*;

import java.io.Serializable;

/**
* @Description: 搜索引擎ElasticSearch结构化对象 使用注解方式
* @Author: 周家伟
* @Date: 2017/10/19 15:30
*/
@ESIndex(indexName = "agri",indexType = "prpduser") //indexname、typename如何设置
@ESShowLog //打印交互信息及报文
@ESPagination(_itemsPerPage = 10) //_itemsPerPage表示每页条数
public class PrpDuser2Dto implements Serializable {
    @ESId
    private String id ;
    @ESSortAsc //排序
    private String usercode;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
