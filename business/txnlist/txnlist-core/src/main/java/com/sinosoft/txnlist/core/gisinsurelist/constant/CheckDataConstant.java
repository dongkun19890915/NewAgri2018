package com.sinosoft.txnlist.core.gisinsurelist.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * gis数据校验常量类
 *
 * 1.需要新增非空校验时，只需要在对应表的数组中增加需要校验的字段名称即可
 *
 * 2.需要新增字段的可选值校验时，需要在数据初始化代码块中初始化对应表的map
 *   其中key为要校验的字段名称，value是该字段的可选值
 *
 * 3.字段名均区分大小写
 *
 * @date: 2018/2/2 14:31
 * @author: 何伟东
 */
public class CheckDataConstant {

    /**
     * 投保预确认清单主信息，不为空字段名称
     */
    private static String[] MAIN_NOT_EMPTY = {
            "insureListCode", "listAlias", "fProvinceCode",
            "fProvinceName", "fCityCode", "fCityName",
            "fCountyCode", "fCountyName", "pProvinceCode",
            "pProvinceName", "pCityCode", "pCityName",
            "pCountyCode", "pCountyName", "fCount",
            "gisFlag", "listCreateTime", "opCode",
            "opName", "listAffrimTime", "affrimopCode", "affrimopName"
    };

    /**
     * 投保预确认清单标的信息，不能为空的字段
     */
    private static String[] ITEM_NOT_EMPTY = {
            "itemNo", "itemCode", "itemType",
            "itemName", "itemFullName", "itemListCode"
    };

    /**
     * 投保预确认清单农户信息，不能为空字段
     */
    private static String[] FARMER_NOT_EMPTY = {
            "fCode", "fName", "landArea",
            "realArea", "insureArea", "tinsurEarea",
    };

    /**
     * 投保预确认清单农户标的关联信息，不能为空字段
     */
    private static String[] FARMER_ITEM_NOT_EMPTY = {
            "itemCode", "insureCount"
    };


    /**
     * 投保预确认清单农户田块信息，不能为空字段
     */
    private static String[] FARMER_FIELD_NOT_EMPTY = {
            "fieldCode", "fieldArea", "validArea"
    };

    /**
     * 投保预确认清单农户标的清单明细（物），不能为空字段
     */
    private static String[] FARMER_ITEM_HERD_NOT_EMPTY = {
            "earLabel", "animalAge"
    };

    /**
     * 投保预确认清单农户标的清单明细（人），不能为空字段
     */
    private static String[] FARMER_ITEM_MAN_NOT_EMPTY = {
            "idType", "idCard", "name", "sex",
            // 针对草莓种植保险新增字段非空校验
            "industryCategory"
    };

    /**
     * 投保预确认清单主信息,需要校验的字段信息
     */
    public static Map<String, String[]> MAIN_FIELD = new HashMap<>();

    /**
     * 投保预确认清单标的信息,需要校验的字段信息
     */
    public static Map<String, String[]> ITEM_FIELD = new HashMap<>();

    /**
     * 投保预确认清单农户信息,需要校验的字段信息
     */
    public static Map<String, String[]> FARMER_FIELD = new HashMap<>();

    /**
     * 投保预确认清单农户标的关联信息,需要校验的字段信息
     */
    public static Map<String, String[]> FARMER_ITEM_FIELD = new HashMap<>();

    /**
     * 投保预确认清单农户田块信息,需要校验的字段信息
     */
    public static Map<String, String[]> FARMER_FIELD_FIELD = new HashMap<>();

    /**
     * 投保预确认清单农户标的清单明细（物）,需要校验的字段信息
     */
    public static Map<String, String[]> FARMER_ITEM_HERD_FIELD = new HashMap<>();

    /**
     * 投保预确认清单农户标的清单明细（人）,需要校验的字段信息
     */
    public static Map<String, String[]> FARMER_ITEM_MAN_FIELD = new HashMap<>();

    /**
     * 数据初始化
     */
    static {
        getFieldRangeMap(MAIN_FIELD, MAIN_NOT_EMPTY);
        MAIN_FIELD.put("listType", new String[]{"D", "S"});
        MAIN_FIELD.put("newFlag", new String[]{"Y", "N"});
        getFieldRangeMap(ITEM_FIELD, ITEM_NOT_EMPTY);
        getFieldRangeMap(FARMER_FIELD, FARMER_NOT_EMPTY);
        getFieldRangeMap(FARMER_ITEM_FIELD, FARMER_ITEM_NOT_EMPTY);
        getFieldRangeMap(FARMER_FIELD_FIELD, FARMER_FIELD_NOT_EMPTY);
        getFieldRangeMap(FARMER_ITEM_HERD_FIELD, FARMER_ITEM_HERD_NOT_EMPTY);
        getFieldRangeMap(FARMER_ITEM_MAN_FIELD, FARMER_ITEM_MAN_NOT_EMPTY);
        FARMER_ITEM_MAN_FIELD.put("relation", new String[]{"配偶", "子女", "父母", "其他"});
    }

    /**
     * 将数组放到指定Map的key中，value为null
     *
     * @param fieldNames 指定的map
     * @param fieldArr   待转换的数组
     * @date: 2018/2/2 14:59
     * @author: 何伟东
     */
    private static void getFieldRangeMap(Map<String, String[]> fieldNames, String[] fieldArr) {
        for (int i = 0; i < fieldArr.length; i++) {
            fieldNames.put(fieldArr[i], null);
        }
    }

}
