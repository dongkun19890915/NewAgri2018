package com.sinosoft.demo.elasticsearch.dto;

import com.sinosoft.esClient.core.annotation.ESId;

import java.io.Serializable;
/**
* @Description: 搜索引擎ElasticSearch结构化对象
* @Author: 周家伟
* @Date: 2017/10/19 15:30
*/
public class PrpDuserDto implements Serializable {
    @ESId
    private String id ;
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
