/**
 * Created by colorfulcat on 2017/11/12.
 */
define({ //险类
    "classCode1":[
        {
            "codeCode": "31",
            "codeCName": "31种植保险类"
        },
        {
            "codeCode": "32",
            "codeCName": "32养殖保险类"
        }
    ],
    //政策/商业标志
    "businessType1":[
        {
            "codeCode": "00",
            "codeCName": "商业险"
        },
        {
            "codeCode": "01",
            "codeCName": "中央政策性"
        },
        {
            "codeCode": "02",
            "codeCName": "地方政策性"
        }
    ],
    //短期费率方式
    "shortRateFlag":[
        {
            "codeCode": "00",
            "codeCName": "按短期费率表"
        },
        {
            "codeCode": "01",
            "codeCName": "日比例"
        },
        {
            "codeCode": "02",
            "codeCName": "月比例"
        }
    ],
    //批改方式
    "endorseType":[
        {
            "codeCode": "00",
            "codeCName": "客户申请"
        },
        {
            "codeCode": "01",
            "codeCName": "录入错误"
        },
        {
            "codeCode": "02",
            "codeCName": "其他"
        }
    ],
    //投保状态0初始值,1通过,2不通过,3无需核保,9待核保
    "underWriteFlag":[
        {
            "codeCode": "0",
            "codeCName": "初始值"
        },
        {
            "codeCode": "1",
            "codeCName": "人工核保"
        },
        {
            "codeCode": "2",
            "codeCName": "不通过"
        },
        {
            "codeCode": "3",
            "codeCName": "自动核保"
        },
        {
            "codeCode": "4",
            "codeCName": "见费出单没收费"
        },
        {
            "codeCode": "9",
            "codeCName": "待核保"
        }
    ],
    //是否
    "whether":[
        {
            "codeCode": "1",
            "codeCName": "是"
        },
        {
            "codeCode": "2",
            "codeCName": "否"
        }
    ],
    //同投保人
    "samePolicyHolder":[
        {
            "codeCode": "1",
            "codeCName": "同投保人"
        }
    ],
    //客户信息
    "client":[
        {
            "codeCode": "1",
            "codeCName": "同投保人"
        },
        {
            "codeCode": "2",
            "codeCName": "同被保险人"
        }
    ],
    //主共保手续费
    "coinAgentFee":[
        {
            "codeCode":"1",
            "codeCName":"份额计入"
        },
        {
            "codeCode":"2",
            "codeCName":"全额计入"
        },
        {
            "codeCode":"3",
            "codeCName":"全额承担"
        }
    ],
    //主共保特殊因子费
    "coinMiddleCostFee":[
        {
            "codeCode":"1",
            "codeCName":"份额计入"
        },
        {
            "codeCode":"2",
            "codeCName":"全额计入"
        }
    ],
    //险种
    //"riskCode":[
    //    {
    //        "codeCode":"3101",
    //        "codeCName":"310-水稻种植保险"
    //    },
    //    {
    //        "codeCode":'3151',
    //        "codeCName":"315-小麦种植保险"
    //    }
    //],
    //编辑类型
    //"editType":[
    //    {
    //        "codeCode": "NEW",
    //        "codeName": "新保"
    //    },
    //    {
    //        "codeCode": "2",
    //        "codeName": "复制投保单"
    //    },
    //    {
    //        "codeCode": "3",
    //        "codeName": "复制保单"
    //    },
    //    {
    //        "codeCode": "4",
    //        "codeName": "续保"
    //    }
    //],
});