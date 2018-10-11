/**
 * DESC       : 国元农险理赔报案 全局共用的API方法在此定义
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017/11/23
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define(['jquery'],function () {
    function checkApiServ() {
    }
    checkApiServ.prototype={
        //PerformanceRate跟绩效有关，maxCommissionRate这个是佣金率
        setRefreshMaxPerformanceFlagZeror:function () {
            console.log("--------------")
            return 0;
        }

       /* billNum:function(data){
            if(!data)return;
            var str = data.toString() || '',
                falg;
            str.replace(/^\d+(.\d{0,2})?/, function (a) {
                falg = true;
                data = a;
                if (data >= 10000000000) {
                    data = Math.floor(data / 10).toString()
                }
            });
            if (!falg) {
                data = ''
            }
            return data
        }*/
    }
    return checkApiServ
});