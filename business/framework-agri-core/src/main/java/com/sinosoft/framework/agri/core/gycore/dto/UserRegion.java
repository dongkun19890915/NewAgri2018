package com.sinosoft.framework.agri.core.gycore.dto;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-04-26 08:46
 */
public class UserRegion {

    private List<String> fProvinceCodes;
    private List<String> fCityCodes;
    private List<String> fCountyCodes;
    private List<String> fTownCodes;
    private List<String> fVillageCodes;

    public List<String> getfProvinceCodes() {
        return fProvinceCodes;
    }

    public void setfProvinceCodes(List<String> fProvinceCodes) {
        this.fProvinceCodes = fProvinceCodes;
    }

    public List<String> getfCityCodes() {
        return fCityCodes;
    }

    public void setfCityCodes(List<String> fCityCodes) {
        this.fCityCodes = fCityCodes;
    }

    public List<String> getfCountyCodes() {
        return fCountyCodes;
    }

    public void setfCountyCodes(List<String> fCountyCodes) {
        this.fCountyCodes = fCountyCodes;
    }

    public List<String> getfTownCodes() {
        return fTownCodes;
    }

    public void setfTownCodes(List<String> fTownCodes) {
        this.fTownCodes = fTownCodes;
    }

    public List<String> getfVillageCodes() {
        return fVillageCodes;
    }

    public void setfVillageCodes(List<String> fVillageCodes) {
        this.fVillageCodes = fVillageCodes;
    }
}
