/**
 * Created by colorfulcat on 2017/11/12.
 */
define([],function () {
    var PRPALLIP = ""; //http://192.168.0.5
    var XYD = ""; //http://220.178.31.50:9200
    var GISIP="";//调查报告金禾 IP http://36.32.160.60:8888
    //var UATIP="http://9.0.2.33";//uat环境地址
    var UATIP="";//测试环境地址 http://192.168.0.5
    var constans = {
        HEADERS:{ // 头信息
            AUTH_URL_NAME:'AuthLocation', // 登录地址（响应头）
                AUTH_OUT_URL_NAME:'RedirectLocation', // 重新登录地址（响应头）
                COOKIE: 'sinosoftSSO' // (cookie头)
        },
        EVENTS: {
            LOGIN_SUCCESS: 'event:login-success',//新系统登录成功
                BACKEND_EXCEPTION: 'event:backend-exception',//接口没有返回数据
                LOGIN_READY: 'event:login-ready'//新系统登录
        },
        STOREUSER:{ // store存储的名字
            USER: 'user'
        },
        SYSTEMAGRI:{ // 系统名称
            systemCode:"newagriclaim"
        },
        AUTH: {
            OK: 200,                //正常
                UNAUTHORIZED: 401,      //没有登录
                FORBIDDEN: 403          //没有权限
        },

        ROLE: {
            NB: '001'               //投保
        },
        EXTERNALSYSTEMURL:{ // 外部系统路径
                POLICYSHOW: UATIP + '/prpall/#/UIPolicy3107show?authSystemFlag=claim&policyNo=',
                PRINTURL: '',
                url:XYD+'/SunECM/servlet/RouterServlet',
            plantingSurveyurl:GISIP+'/CallPage/surveyShow/plantingSurvey?registNo=',//调查报告调用金禾路径（种植险）
            cultivationSurveyurl:GISIP+'/CallPage/surveyShow/cultivationSurvey?registNo =',//调查报告调用金禾路径（养殖险）
        },
        STATUS: {
            DELETED: 'delete'       //批改类型删除
        },
        TARGET: {},
        BizType:{},                 //单子类型
        TYPE: {},
        SYSTEM:{
            SYSTEMCODE: 'claim'
        },
        NAVIGATION:{},
        //本地缓存
        localstorage: {
            nowDate: "nowDate"       //当前系统时间
        },
        CLAIMLIST:{
            listNo:""
        }
    }
    return constans
});
