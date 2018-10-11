/**
 * Created by colorfulcat on 2017/11/12.
 */

define({
    "TypeFlag":[
        {
            codecode:"5",
            codecname: "预赔"
        }
    ],
    "LossFeeType":[
        {
            codecode:"P",
            codecname: "赔款"
        },
        {
            codecode: "Z",
            codecname: "费用"
        }
    ],
    "StaffType":[
        {
            codecode: 0,
            codecname: "对接人"
        },
        {
            codecode: 1,
            codecname: "转接报案人"
        }
    ],
    "StaffPosition":[
        {
            codecode: 0,
            codecname: "非机构人员"
        },
        {
            codecode: 1,
            codecname: "本机构人员"
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
    ], // 后台未根据险种做限制
    "remark_flag":[
        {
            codecode: "1",
            codecname: "是"
        },
        {
            codecode: "0",
            codecname: "否"
        }
    ],
    "zeroLoss":[
        {
            codecode: '1',
            codecname: "注销"
        },
        {
            codecode: '2',
            codecname: "拒赔"
        },
        {
            codecode: '3',
            codecname: "正常"
        },
        {
            codecode: '4',
            codecname: "业务员操作错误"
        }],
    "charge_name":[
        {
            codecode: '03',
            codecname: "03-施救费"
        },
        {
            codecode: '04',
            codecname: "04-查勘费"
        },
        {
            codecode: '05',
            codecname: "05-诉讼费"
        },
        {
            codecode: '07',
            codecname: "07-检验鉴定费"
        },
        {
            codecode: '14',
            codecname: "14-系统内代查勘"
        },
        {
            codecode: '15',
            codecname: "15-律师费"
        },
        {
            codecode: '99',
            codecname: "99-其他"
        }],
    "payType":[
        {
            codecode: 0,
            codecname: "对内"
        },
        {
            codecode: 1,
            codecname: "对外"
        }
    ],
    "deptname":[
        {
            codecode: '0',
            codecname: "总公司直属营业部财务会计部"
        },
        {
            codecode: '1',
            codecname: "总公司直属营业部市场开发部"
        }
     ],
    "modelStatus":[
        {
            codecode: '0',
            codecname: "未使用"
        },
        {
            codecode: '1',
            codecname: "正在使用"
        },
        {
            codecode: '2',
            codecname: "已停用"
        },
        {
            codecode: '3',
            codecname: "已作废"
        },
        {
            codecode: '4',
            codecname: "已注销"
        }
    ],
    "nodeType":[
        {
            codecode: 0,
            codecname: "报案"
        },
        {
            codecode: 1,
            codecname: "调度"
        },
        {
            codecode: 2,
            codecname: "查勘定损"
        },
        {
            codecode: 3,
            codecname: "立案"
        },
        {
            codecode: 4,
            codecname: "计算书"
        },
        {
            codecode: 5,
            codecname: "注销/拒赔"
        },
        {
            codecode: 6,
            codecname: "特殊赔案"
        },
        {
            codecode: 7,
            codecname: "核赔"
        }
     ],
    "riskType":[
        {
            codecode: "H",
            codecname: "种植保险类"
        },
        {
            codecode:"I",
            codecname: "养殖保险类"

        }
    ], // 保险大类
    "status":[
        {
            codecode: 0,
            codecname: "已撤销"
        },
        {
            codecode: 2,
            codecname: "正在处理"
        },
        {
            codecode: 4,
            codecname: "已处理"
        },
        {
            codecode:"all",
            codecname: "全部"
        }
    ], // 案件状态
    "caseEmergency":[
        {
            codecode: "0",
            codecname: "一般"
        },
        {
            codecode: "1",
            codecname: "紧急"
        }
  ],//案件紧急状态
    "risk_Category":[
        {
            codecode: 0,
            codecname: "全部险类"
        },
        {
            codecode: 1,
            codecname: "种植保险类"
        },
        {
            codecode: 2,
            codecname: "养殖保险类"
        }
    ],
    "risk_status":[
        {
            codecode: 0,
            codecname: "全部"
        },
        {
            codecode: 1,
            codecname: "未处理"
        },
        {
            codecode: 2,
            codecname: "正在处理"
        },
        {
            codecode: 3,
            codecname: "已处理"
        },
        {
            codecode: 4,
            codecname: "核赔退回"
        }
    ],
    "checkNodeStatus":[
        {
            codecode: 0,
            codecname: "未处理"
        },
        {
            codecode: 2,
            codecname: "正在处理"
        },
        {
            codecode: 4,
            codecname: "已处理"
        },
        {
            codecode:"all",
            codecname: "全部"
        }
    ],//查勘定损案件状态
    "caseType":[
        {
            codecode: 0,
            codecname: "注销"
        },
        {
            codecode: 2,
            codecname: "拒赔"
        }
    ], // 注销/拒赔
    "prpCancel":[
        {
            codecode: 1,
            codecname: "客户报错案"
        },
        {
            codecode: 2,
            codecname: "客户重复报案"
        },{
            codecode: 3,
            codecname: "不属于投保险别出险"
        },
        {
            codecode: 4,
            codecname: "不属于投保险种出险"
        },
        {
            codecode: 5,
            codecname: "业务员操作错误"
        }
    ], // 注销/拒赔原因
    "undwrtFlag":[
        {
            codecode: null,
            codecname: "所有案件"
        },
        {
            codecode: 1,
            codecname: "审核通过"
        },
        {
            codecode: 3,
            codecname: "审核回退"
        }],//重开赔案案件状态
    "recaseRiskType":[
        {
            codecode: "0",
            codecname: "全部险类"
        },
        {
            codecode: "31",
            codecname: "种植保险类"
        },{
            codecode: "32",
            codecname: "养殖保险类"
        }],//重开赔案保险大类
    "compeNodeStatus":[
        {
            codecode:"all",
            codecname: "全部"
        },
        {
            codecode: 0,
            codecname: "未处理"
        },
        {
            codecode: 2,
            codecname: "正在处理"
        },
        {
            codecode: 4,
            codecname: "已处理"
        },
        {
            codecode: 3,
            codecname: "核赔退回"
        }
    ],
    "prePayNodeStatus":[
        {
            codecode: 0,
            codecname: "未处理"
        },
        {
            codecode: 2,
            codecname: "正在处理"
        },
        {
            codecode: 3,
            codecname: "核赔退回"
        },
        {
            codecode: 4,
            codecname: "已处理"
        },
        {
            codecode:"all",
            codecname: "全部"
        }
    ], // 重开赔案---案件状态
    "compeNodeStatus":[
        {
            codecode:"all",
            codecname: "全部"
        },
        {
            codecode: 0,
            codecname: "未处理"
        },
        {
            codecode: 4,
            codecname: "已处理"
        },
        {
            codecode: 2,
            codecname: "正在处理"
        },
        {
            codecode: 3,
            codecname: "核赔退回"
        },
        {
            codecode: 8,
            codecname: "已注销"
        },
        {
            codecode: 9,
            codecname: "已拒赔"
        }
    ],
    // 工作流管理---查询---模板状态
    "modelStatuss":[
        {
            codecode: 0,
            codecname: "未使用"
        },
        {
            codecode: 1,
            codecname: "正在使用"
        }
    ],
    // 工作流管理---新建工作流模板---模板类型
    "modelType":[
           {
               codecode: "02",
               codecname: "新理赔模板"
           }
    ],
    // 工作流管理---新建工作流模板---节点类型
    "nodeTypes":[
        /*{
            codecode: "regis",
            codecname: "报案"
        },
        {
            codecode: "sched",
            codecname: "调度"
        },
        {
            codecode: "check",
            codecname: "查勘定损"
        },
        {
            codecode: "claim",
            codecname: "立案"
        },
        {
            codecode: "compp",
            codecname: "计算书"
        },
        {
            codecode: "cance",
            codecname: "注销/拒赔"
        },
        {
            codecode: "speci",
            codecname: "特殊赔案"
        },
        {
            codecode: "veric",
            codecname: "核赔"
        }*/
        {    codecode:"cance",codecname:"注销/拒赔"},
        {    codecode:"certa",codecname:"定损"},
        {    codecode:"certi",codecname:"单证"},
        {    codecode:"check",codecname:"查勘定损"},
        {    codecode:"claim",codecname:"立案"},
        {    codecode:"compe",codecname:"实赔"},
        {    codecode:"compp",codecname:"赔款计算书"},
        {    codecode:"endca",codecname:"结案"},
        {    codecode:"prepa",codecname:"预赔"},
        {    codecode:"regis",codecname:"报案"},
        {    codecode:"sched",codecname:"调度"},
        {    codecode:"schel",codecname:"定损调度"},
        {    codecode:"speci",codecname:"特殊赔案"},
        {    codecode:"veric",codecname:"核赔"},
        {    codecode:"rcase",codecname:"重开赔案"}
    ],
    // 工作流管理---新建工作流模板---任务类型
    "taskType":[
        {
            codecode: "S",
            codecname: "单任务"
        },
        {
            codecode: "M",
            codecname: "多任务"
        },
        {
            codecode: "T",
            codecname: "特殊任务"
        }
    ],
    // 工作流管理---新建工作流模板---结束标志
    "endFlag":[
        {
            codecode: "1",
            codecname: "是"
        },
        {
            codecode: "0",
            codecname: "否"
        }
    ],
    "defaultFlag":[
        {
            codecode: "1",
            codecname: "是"
        },
        {
            codecode: "0",
            codecname: "否"
        }
    ],
    // 工作流管理---工作流模板路径编辑---起始节点/终止节点
    "startNodeNo":[
        {
            codecode: 1,
            codecname: "报案"
        },{
            codecode: 2,
            codecname: "调度"
        },{
            codecode: 3,
            codecname: "查勘定损"
        },{
            codecode: 4,
            codecname: "立案"
        },{
            codecode: 5,
            codecname: "计算书"
        },{
            codecode: 6,
            codecname: "注销/拒赔"
        },{
            codecode: 7,
            codecname: "特殊赔案"
        },{
            codecode: 8,
            codecname: "核赔"
        }
    ],
     // 流程查询---案件状态
    "caseTypes":[
        {
            codecode: 0,
            codecname: "未结案"
        },{
            codecode: 1,
            codecname: "已结案"
        }
    ],
    "certainloss": [  // 查勘人员
        {
            "codecode": "100284",
            "codeename": "",
            "codecname": "测试账号1226"
        },
        {
            "codecode": "100350",
            "codeename": "",
            "codecname": "测试账号1315"
        },
        {
            "codecode": "100362",
            "codeename": "",
            "codecname": "测试账号1316"
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

    ],
    "printType" :[
        {
            "codecode": 'CoverPrint',
            "codecname": "农险卷宗",
            "url" : "agriclaim/print/agriPrint?claimNo=",
            "width" : 120,
            "id": 1
        },{
            "codecode": 'LocalCheck',
            "codecname": "查勘报告",
            "url" : "agriclaim/print/siteSurveyPrint",
            "width" : 120,
            "id": 2
        },{
            "codecode": 'EndCase',
            "codecname": "结案报告",
            "url" : "agriclaim/print/endCasePrint?claimNo=",
            "width" : 120,
            "id": 3
        },{
            "codecode": 'Cancel',
            "codecname": "拒赔/注销",
            "url" : "agriclaim/print/cancelNoticePrint?claimNo=",
            "width" : 120,
            "id": 4
        },{
            "codecode": 'CopyPrint',
            "codecname": "保单抄件",
            "url" : "agriclaim/print/copyPrint?registNo=",
            "width" : 120,
            "id": 5
        },{
            "codecode": 'Compensate',
            "codecname": "赔款理算书",
            "url" :"agriclaim/print/compensatePrint?compensateNo=",
            "width" : 120,
            "id": 6
        },{
            "codecode": 'IndemnityNotice',
            "codecname": "赔款收据",
            "url" :"agriclaim/print/indemnityNoticePrint?compensateNo=",
            "width" : 120,
            "id": 7
        }
    ],
    // 流程查询---险种大类
    "classCode":[
        {
            codecode: 31,
            codecname: "种植险"
        },{
            codecode: 32,
            codecname: "养殖险"
        }
        ],
    //多选
    "checkBox": [
                {
                    "codecode": 1,
                    "codecname": "是",
                    "checked": false,
                    "class": "w85",
                    "disabled": true
                }, {
                    "codecode": 2,
                    "codecname": "否",
                    "checked": false,
                    "class": "w85"
                }, {
                    "codecode": 3,
                    "codecname": "不确定",
                    "checked": false,
                    "class": "w85"
                }
            ],
    //调度---案件状态
    "statusDispatch":[
        {
            codecode: 0,
            codecname: "未处理"
        },
        {
            codecode: 4,
            codecname: "已处理"
        },
        {
            codecode:"all",
            codecname: "全部"
        }
    ],
// 结案查询---案件状态
    "endCaseStatus":[
        {
            codecode: "",
            codecname: "全部"
        },{
            codecode: "1",
            codecname: "已处理"
        },
        {
            codecode: "0",
            codecname: "未处理"
        }
    ],
    // 立案查询---案件状态
    "claimStatus":[
        {
            codecode: "all",
            codecname: "全部"
        },{
            codecode: "4",
            codecname: "已处理"
        },
        {
            codecode: "0",
            codecname: "未处理"
        },
        {
            codecode: "8",
            codecname: "已注销"
        },
        {
            codecode: "9",
            codecname: "已拒赔"
        }
    ],
    // 结案查询---险种大类
    "endCaseRiskType":[
        {
            codecode: "H",
            codecname: "种植保险类"
        },
        {
            codecode: "I",
            codecname: "养殖保险类"
        }
    ],

    //报案登记---险种大类
    "riskTypeRegist":[
        {
            codecode: "H",
            codecname: "种植保险类"
        },
        {
            codecode:"I",
            codecname: "养殖保险类"

        }
    ],
    //标的
    "target":[
        {
            codecode: "1",
            codecname: "标的"
        }
    ],
    "printCaseType":[
        {
            codecode: 0,
            codecname: "已结案"
        },
        {
            codecode: 2,
            codecname: "未结案"
        },
        {
            codecode: 'all',
            codecname: "所有案件"
        }
    ],
    "certifTypes":[
        {codecode:"",  codecname:"请选择"},
        {codecode:"01",codecname:"居民身份证"},
        {codecode:"02",codecname:"居民户口簿"},
        {codecode:"03",codecname:"驾驶证"},
        {codecode:"04",codecname:"军官证"},
        {codecode:"05",codecname:"士兵证"},
        {codecode:"06",codecname:"军官离退休证"},
        {codecode:"07",codecname:"中国护照"},
        {codecode:"08",codecname:"异常身份证"},
        {codecode:"41",codecname:"港澳通行证"},
        {codecode:"42",codecname:"台湾通行证"},
        {codecode:"43",codecname:"回乡证"},
        {codecode:"51",codecname:"外国护照"},
        {codecode:"52",codecname:"旅行证"},
        {codecode:"53",codecname:"居留证件"},
        {codecode:"71",codecname:"组织机构代码证"},
        {codecode:"72",codecname:"税务登记证"},
        {codecode:"73",codecname:"营业执照"},
        {codecode:"99",codecname:"其他证件"}
    ],
    "receiverTypeOthers":[
        {codecode:"",codecname:"请选择"},
        {codecode:"t02",codecname:"被保险人"},
        {codecode:"t01",codecname:"投保人"},
        {codecode:"t03",codecname:"收益人"},
        {codecode:"t04",codecname:"其他个人"},
        {codecode:"t05",codecname:"其他单位"}
    ],
    "urgentTypes":[
        {codecode:"0.5",codecname:"30分钟"},
        {codecode:"1",codecname:"1小时"},
        {codecode:"2",codecname:"2小时"},
        {codecode:"3",codecname:"3小时"},
        {codecode:"4",codecname:"4小时"},
        {codecode:"8",codecname:"8小时"},
        {codecode:"24",codecname:"24小时"},
        {codecode:"48",codecname:"48小时"}
    ]

});

