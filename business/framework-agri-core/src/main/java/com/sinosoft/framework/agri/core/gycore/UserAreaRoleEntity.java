package com.sinosoft.framework.agri.core.gycore;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-07 12:11
 */
@XStreamAlias("Region")
public class UserAreaRoleEntity {

    //区域id
    @XStreamAlias("REGIONID")
    private String regionid;

    @XStreamAlias("PARENTID")
    private String parentid;

    //区域名称
    @XStreamAlias("REGIONNAME")
    private String regionname;

    //区域二调代码
    @XStreamAlias("GBBH")
    private String gbbh;

    //区域二调对应平台代码
    @XStreamAlias("PLATREGIONCODE")
    private String platregioncode;


    @XStreamAlias("REGIONLEVEL")
    private String regionlevel;


    public UserAreaRoleEntity() {
    }

    public UserAreaRoleEntity(String regionid, String parentid, String regionname, String gbbh, String platregioncode) {
        this.regionid = regionid;
        this.parentid = parentid;
        this.regionname = regionname;
        this.gbbh = gbbh;
        this.platregioncode = platregioncode;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getGbbh() {
        return gbbh;
    }

    public void setGbbh(String gbbh) {
        this.gbbh = gbbh;
    }

    public String getPlatregioncode() {
        return platregioncode;
    }

    public void setPlatregioncode(String platregioncode) {
        this.platregioncode = platregioncode;
    }

    public String getRegionlevel() {
        return regionlevel;
    }

    public void setRegionlevel(String regionlevel) {
        this.regionlevel = regionlevel;
    }
}
