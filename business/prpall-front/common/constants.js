/**
 * Created by colorfulcat on 2017/11/12.
 */
define({
    HEADERS:{ // 头信息
        AUTH_URL_NAME:'AuthLocation', // 登录地址（响应头）
        AUTH_OUT_URL_NAME:'RedirectLocation', // 重新登录地址（响应头）
        COOKIE: 'sinosoftSSO' // (cookie头)
    },
    EVENTS: {
        LOGIN_SUCCESS: 'event:login-success',//新系统登录成功
        BACKEND_EXCEPTION: 'event:backend-exception',//接口没有返回数据
        LOGIN_READY: 'event:login-ready',//新系统登录
        ENDORSE_READY: 'event:endorse_ready' // 批改准备就绪 广播后开始监听数据变化更改颜色
    },
    STOREUSER:{ // store存储的名字
        USER: 'user'
    },
    SYSTEM:{ // 系统名称
        systemCode:"newagriprpall"
    },
    AUTH: {
        OK: 200,                //正常
        UNAUTHORIZED: 401,      //没有登录
        FORBIDDEN: 403          //没有权限
    },

    ROLE: {
        NB: '001'               //投保
    },

    STATUS: {
        DELETED: 'delete'       //批改类型删除
    },
    LOGIN:{},
    TARGET: {},
    BizType:{},                 //单子类型
    TYPE: {},

    //本地缓存
    localstorage: {
        nowDate: "nowDate"       //当前系统时间
    }
});