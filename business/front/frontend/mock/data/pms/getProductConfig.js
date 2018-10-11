define([], function () {
      return [{
    "name":"baseInfo",
    "disName":"保单基本信息",
    "type":"F",
    "bizType":"baseInfo",
    "url" : "fixed/baseInfo.html",
    "item":{
      "prpTmain":{
        "businessNature":"12312312",
        "comCode":"",
        "cityCode":"",
        "makeCom":"",
        "handlerCode":"",
        "handlerName":"",
        "handler1Code":"123123",
        "handler1Name":"123123",
        "operatorCode":"",
        "OperatorName":""
      },
      "class":{
        "businessNature":"form-control",
        "comCode":"form-control",
        "cityCode":"fl",
        "makeCom":"fl",
        "handlerCode":"fl",
        "handlerName":"fl",
        "handler1Code":"fl",
        "handler1Name":"fl",
        "operatorCode":"fl",
        "OperatorName":"fl"
      }
    },
    "index":1
  },
  {
    "name":"applyInfo",
    "disName":"投保人信息",
    "type":"S",
    "bizType":"baseInfo",
    "url" : "fixed/applyInfo.html",
    "item":{
      "prpTmain":{
        "arguesolution":""
      },
      "class":{
        "taxAmount":"hide",
        "sumPremium":"hide"
      }
    },
    "index":4
  },
  {
    "name":"testDy",
    "disName":"业务相关信息",
    "type":"D",
    "url" : "",
    "item":{
      "proposalNo":"009",
      "proposalNoIsRuquired":"false",
      "proposalNoMinLength":"6",
      "proposalNoMaxLength":"8",
      "proposalNoIsDisplay":"false",
      "proposalNoLabelStyle":"col-sm-2 control-label",
      "proposalNoDivStyle":"col-sm-4",
      "proposalNoInputStyle":"form-control",
      "proposalNoWarnText":"投保单号",
      "proposalNoPlaceholder":"投保单号",
      "startDate":"",
      "startDateIsRuquired":"true",
      "startDateFormat":"YYYY-MM-DD",

      "startDateLabelStyle":"col-sm-2 control-label",
      "startDateDivStyle":"col-sm-4",
      "startDateIsDisplay":"true",
      "startDateInputStyle":"form-control",
      "startDateWarnText":"保单生效日期",
      "startDatePlaceholder":"保单生效日期",

      "proposalNo2":"009",
      "proposalNo2IsRuquired":"false",
      "proposalNo2MinLength":"6",
      "proposalNo2MaxLength":"8",
      "proposalNo2IsDisplay":"false",
      "proposalNo2LabelStyle":"col-sm-2 control-label",
      "proposalNo2DivStyle":"col-sm-4",
      "proposalNo2InputStyle":"form-control",
      "proposalNo2WarnText":"业务员姓名",
      "proposalNo2Placeholder":"业务员姓名",
      "startDate2":"",
      "startDate2IsRuquired":"true",
      "startDate2Format":"YYYY-MM-DD",

      "startDate2LabelStyle":"col-sm-2 control-label",
      "startDate2DivStyle":"col-sm-4",
      "startDate2IsDisplay":"false",
      "startDate2InputStyle":"form-control",
      "startDate2WarnText":"保单终止日期",
      "startDate2Placeholder":"保单终止日期"
    },
    "index":3
  },
  {
    "name":"feeInfo",
    "disName":"保额/保费信息",
    "type":"S",
    "url" : "static/feeInfo.html",
    "bizType":"baseInfo",
    "item":{
      "prpTinsured":{
        "insuredType":"",
        "insuredName":"",
        "identifyNumber":"",
        "phoneNumber":"",
        "applayName":"",
        "linkerName":"",
        "aaa":"",
        "mobile":"",
        "email":""
      },
      "class":{
        "insuredType":"hide",
        "insuredName":"fl",
        "identifyNumber":"fl",
        "phoneNumber":"fl",
        "applayName":"fl",
        "linkerName":"fl",
        "aaa":"fl",
        "mobile":"fl",
        "email":"fl"
      }
    },
    "index":2
  }
]
    }
);