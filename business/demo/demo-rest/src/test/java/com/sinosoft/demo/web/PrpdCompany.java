package com.sinosoft.demo.web;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2017-12-27 10:30
 */
public class PrpdCompany {

    @JSONField(ordinal = 1)
    private String comcode;
    @JSONField(ordinal = 2)
    private String comcname;
    @JSONField(ordinal = 3)
    private String uppercomcode;
    @JSONField(ordinal = 4)
    private String comlevel;
    @JSONField(ordinal = 5)
    private List<PrpdCompany> childs;


    public PrpdCompany(String comcode, String comcname, String uppercomcode) {
        this.comcode = comcode;
        this.comcname = comcname;
        this.uppercomcode = uppercomcode;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }

    public String getComcname() {
        return comcname;
    }

    public void setComcname(String comcname) {
        this.comcname = comcname;
    }

    public String getUppercomcode() {
        return uppercomcode;
    }

    public void setUppercomcode(String uppercomcode) {
        this.uppercomcode = uppercomcode;
    }

    public String getComlevel() {
        return comlevel;
    }

    public void setComlevel(String comlevel) {
        this.comlevel = comlevel;
    }

    public List<PrpdCompany> getChilds() {
        return childs;
    }

    public void setChilds(List<PrpdCompany> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "PrpdCompany{" +
                "comcode='" + comcode + '\'' +
                ", comcname='" + comcname + '\'' +
                ", uppercomcode='" + uppercomcode + '\'' +
                ", comlevel='" + comlevel + '\'' +
                '}';
    }
}
