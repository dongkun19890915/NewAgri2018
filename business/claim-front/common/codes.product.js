/**
 * Created by colorfulcat on 2017/11/12.
 */
define({
    "remark_flag": [

        {
            codecode: "1",
            codecname: "是"
        }, {
            codecode: "0",
            codecname: "否"
        }
    ],
    "Currency":  [
        {
            "codecode": "CNY",
            "codeename": "Yuan Renminbi",
            "codecname": "人民币"
        },
        {
            "codecode": "HKD",
            "codeename": "Hong Kong Dollar",
            "codecname": "港元"
        },
        {
            "codecode": "DEM",
            "codeename": "Deutsche Mark",
            "codecname": "德国马克"
        },
        {
            "codecode": "DKK",
            "codeename": "Danish Krone",
            "codecname": "丹麦克朗"
        },
        {
            "codecode": "ECU",
            "codeename": "European Currency Unit",
            "codecname": "欧洲通用货币"
        },
        {
            "codecode": "ESP",
            "codeename": "Spanish Peseta",
            "codecname": "西班牙比塞塔"
        },
        {
            "codecode": "EUR",
            "codeename": "EURO DOLLARS",
            "codecname": "欧元"
        },
        {
            "codecode": "FIM",
            "codeename": "Mark",
            "codecname": "芬兰马克"
        },
        {
            "codecode": "FRF",
            "codeename": "French Franc",
            "codecname": "法国法郎"
        },
        {
            "codecode": "GBP",
            "codeename": "Pound Sterling",
            "codecname": "英镑"
        },
        {
            "codecode": "USD",
            "codeename": "US Dollars",
            "codecname": "美元"
        },
        {
            "codecode": "ITL",
            "codeename": "Italian Lira",
            "codecname": "意大利里拉"
        },
        {
            "codecode": "JPY",
            "codeename": "Yen",
            "codecname": "日元"
        },
        {
            "codecode": "MOP",
            "codeename": "Pataca",
            "codecname": "澳门元"
        },
        {
            "codecode": "MYR",
            "codeename": "Malaysian Riggit",
            "codecname": "马来西亚林吉特"
        },
        {
            "codecode": "NLG",
            "codeename": "Netherlands Guider",
            "codecname": "荷兰盾"
        },
        {
            "codecode": "NOK",
            "codeename": "Norwegian Krone",
            "codecname": "挪威克朗"
        },
        {
            "codecode": "NTD",
            "codeename": "NEW TAIWAN DOLLARS",
            "codecname": "新台币"
        },
        {
            "codecode": "NZD",
            "codeename": "New Zealand Dollar",
            "codecname": "新西兰元"
        },
        {
            "codecode": "PHP",
            "codeename": "Philippine Peso",
            "codecname": "菲律宾比索"
        },
        {
            "codecode": "SDR",
            "codeename": "Special Drawing Right",
            "codecname": "特别提款权"
        },
        {
            "codecode": "SEK",
            "codeename": "Swedish Krone",
            "codecname": "瑞典克朗"
        },
        {
            "codecode": "SGD",
            "codeename": "Singapore Dollar",
            "codecname": "新加坡元"
        },
        {
            "codecode": "THB",
            "codeename": "Thailand Baht",
            "codecname": "泰国铢"
        },
        {
            "codecode": "AUD",
            "codeename": "Australian Dollar",
            "codecname": "澳大利亚元"
        },
        {
            "codecode": "BEF",
            "codeename": "Belgium Franc",
            "codecname": "比利时法郎"
        },
        {
            "codecode": "ATS",
            "codeename": "Austria Schilling",
            "codecname": "奥地利先令"
        },
        {
            "codecode": "ASF",
            "codeename": "Swiss Franc",
            "codecname": "清算瑞士法郎"
        },
        {
            "codecode": "CAD",
            "codeename": "Canadian Dollar",
            "codecname": "加拿大元"
        },
        {
            "codecode": "CHF",
            "codeename": "Swiss Franc",
            "codecname": "瑞士法郎"
        }
    ], //  币别
    "recaseRiskType": [
        {
            codecode: "0",
            codecname: "全部"
        },
        {
            codecode: "31",
            codecname: "种植险"
        }, {
            codecode: "32",
            codecname: "养殖险"
        }], // 保险大类 因为后端不统一所以写两次保险大类
    "riskType": [
        {
            codecode: "H",
            codecname: "种植险"
        },
        {
            codecode: "I",
            codecname: "养殖险"

        },
        {
            codecode: "all",
            codecname: "全险种"
        }
    ],
    "caseTypePrint": [
        {
            codecode: "0",
            codecname: "所有案件"
        },
        {
            codecode: "1",
            codecname: "未结案"
        }, {
            codecode: "2",
            codecname: "已结案"
        }
    ]
});