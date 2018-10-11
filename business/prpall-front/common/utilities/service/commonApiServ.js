/**
 * DESC       : 国元农险理赔报案 全局共用的API方法在此定义
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017/11/23
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([],function () {
    function commonApiServ() {
    }

commonApiServ.prototype={
    //费率类的数字的校验 保留4位小数
    rateNum:function (data,type) {
        if(!data)return
        var str = data.toString() || '',
            falg;
        var a=str.slice(-1)

        if(!/\d/.test(a)){
            if(a!='.')str=str.slice(0,-1)
        }
        if(type=='2') {
            str.replace(/^\d{1,9}(.\d{0,4})?/, function (a) {
                falg = true;
                data = a;

            });
        }
        if(type=='1'){
            str.replace(/^\d{1,3}(.\d{0,4})?/, function (a) {
                falg = true;
                data = a;
            if (data >100) {
                data = Math.floor(data / 10).toString()
            }else if(data ==100) {
                data = Math.floor(data).toString()
            }
            });
        }
        if (!falg) {
            data = ''
        }
        return data
    },
    //货币类数字输入校验
    billNum:function(data){
        if(!data)return;
        var str = data.toString() || '',
            falg;
        str.replace(/^\d+(.\d{0,2})?/, function (a) {
            falg = true;
            data = a;
            if (Number(data) >= 10000000000) {
                data = Math.floor(data / 10).toString()
            }
        });
        if (!falg) {
            data = ''
        }
        return data
    },
    //防止把小数冲掉
    billNum1:function(data){
        if(!data)return;
        var str = data.toString() || '',
            falg;
        str.replace(/^\d+(.\d{0,4})?/, function (a) {
            falg = true;
            data = a;
            if (Number(data) >= 10000000000) {
                data = Math.floor(data / 10).toString()
            }
        });
        if (!falg) {
            data = ''
        }
        return data
    },
    //得到下n天
    getNextDateFullDate:function(strDate, intCount) {
        var strValue = strDate.split("-");
        var tempDate = new Date(strValue[0], parseInt(strValue[1]) - 1, parseInt(strValue[2]));
        if(intCount == null) {
            intCount = 1;
        }
        var nextDateInMS = tempDate.getTime() + (intCount * 24 * 60 * 60 * 1000);
        var tempDate = new Date(nextDateInMS);
        var year = tempDate.getFullYear();
        var month = tempDate.getMonth() + 1;
        var day = tempDate.getDate();
        if(month < 10){
            month = "0" + month;
        }
        if(day < 10){
            day = "0" + day;
        }
        var strReturn = year + "-" + month + "-" + day;
        console.log(strReturn)
        return strReturn;
    },
    //获取指定年后的日期
    getNextYearFullDate:function(strDate, intCount,type){
        var tempDate = new Date(strDate);
        tempDate.setFullYear(tempDate.getFullYear()+1);
        tempDate.setDate(tempDate.getDate()-1)
        var year=tempDate.getFullYear();
        var month=tempDate.getMonth()+1;
        if(type ==1){
            var day = new Date(tempDate).getDate() - 1;//这里减一，用来配合缴费结算，算出的时间差是365天
        } else {
            var day = new Date(tempDate).getDate();
        }
        if(month < 10){
            month = "0" + month;
        }
        if(day < 10){
            day = "0" + day;
        }
        var strReturn = year + "-" + month + "-" + day;
        return strReturn;
    },
    //俩个日期比较大小
    compareFullDate:function(date1, date2) {
        var strValue1 = date1.split("-");
        var date1Temp = new Date(strValue1[0], parseInt(strValue1[1], 10) - 1, parseInt(strValue1[2], 10));
        var strValue2 = date2.split("-");
        var date2Temp = new Date(strValue2[0], parseInt(strValue2[1], 10) - 1, parseInt(strValue2[2], 10));
        if(date1Temp.getTime() == date2Temp.getTime())
            return 0;
        else if(date1Temp.getTime() > date2Temp.getTime())
            return 1;
        else
            return -1;
    },
    //设置默认时间
    setDateTime:function(){
        //获取时间
        var date = new Date();
        var month = date.getMonth()+1;
        var day = date.getDate();
        var dataNum=function(x){
            return x<10?'0'+x:x
        }
        var getdate={
            year:date.getFullYear(),
            month:dataNum(month),
            day:dataNum(day),
            yearDate:date.getFullYear() + "-" + dataNum(month)
        }
        return getdate;
    },
    //保留两位小数的四舍五入
    roundToFixed2:function(num){
        num=num*1||0
        if(!num)return '0.00'
        return (Math.round(num*100)/100).toFixed(2).toString()
    },
    //保留4位小数的四舍五入
    roundToFixed4:function(num){
        num=num*1||0
        if(!num)return '0.0000'
        return (Math.round(num*10000)/10000).toFixed(4).toString()
    },
    //身份证号码校验-------------------------------开始-------------------------------
    /**
     * 验证18位数身份证号码中的生日是否是有效生日
     * @param idCard 18位书身份证字符串
     * @return
     */
    isValidityBrithBy18IdCard:function(idCard18){
    var year =  idCard18.substring(6,10);
    var month = idCard18.substring(10,12);
    var day = idCard18.substring(12,14);
    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
    // 这里用getFullYear()获取年份，避免千年虫问题
    if(temp_date.getFullYear()!=parseFloat(year)
        ||temp_date.getMonth()!=parseFloat(month)-1
        ||temp_date.getDate()!=parseFloat(day)){
        return false;
    }else{
        return true;
    }
},
    /**
     * 判断身份证号码为18位时最后的验证位是否正确
     * @param a_idCard 身份证号码数组
     * @return
     */
    isTrueValidateCodeBy18IdCard:function (a_idCard) {
        var valCodePosition;
        var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];// 身份证验证位值.10代表X
        var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];    // 加权因子
        var sum = 0; // 声明加权求和变量
        if (a_idCard[17].toLowerCase() == 'x') {
            a_idCard[17] = 10;                    // 将最后位为x的验证码替换为10方便后续操作
        }
        for ( var i = 0; i < 17; i++) {
            sum += Wi[i] * a_idCard[i];            // 加权求和
        }
        valCodePosition = sum % 11;                // 得到验证码所位置
        if (a_idCard[17] == ValideCode[valCodePosition]) {
            return true;
        } else {
            return false;
        }
    },
   IdCardValidate:function (idCard) {
        idCard = this.trim(idCard.replace(/ /g, "")); //去掉字符串头尾空格
        if (idCard.length == 15) {
            return this.isValidityBrithBy15IdCard(idCard); //进行15位身份证的验证
        } else if (idCard.length == 18) {
            var a_idCard = idCard.split(""); // 得到身份证数组
            if(this.isValidityBrithBy18IdCard(idCard) && this.isTrueValidateCodeBy18IdCard(a_idCard)){//进行18位身份证的基本验证和第18位的验证
                return true;
            }else {
                return false;
            }
        } else {
            return false;
        }
    },
    /**
     * 验证15位数身份证号码中的生日是否是有效生日
     * @param idCard15 15位书身份证字符串
     * @return
     */
    isValidityBrithBy15IdCard:function(idCard15){
        var year =  idCard15.substring(6,8);
        var month = idCard15.substring(8,10);
        var day = idCard15.substring(10,12);
        var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
        // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
        if(temp_date.getYear()!=parseFloat(year)
            ||temp_date.getMonth()!=parseFloat(month)-1
            ||temp_date.getDate()!=parseFloat(day)){
            return false;
        }else{
            return true;
        }
    },
    //去掉字符串头尾空格
    trim:function (str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    },
    //身份证号码校验-------------------------------结束-------------------------------
    //-------------------避免精度损失 开始-------------------------------------
    //加法
    accAdd: function (arg1, arg2) {
        var r1, r2, m;
        try {
            r1 = arg1.toString().split(".")[1].length
        } catch (e) {
            r1 = 0
        }
        try {
            r2 = arg2.toString().split(".")[1].length
        } catch (e) {
            r2 = 0
        }
        m = Math.pow(10, Math.max(r1, r2))
        return (arg1 * m + arg2 * m) / m
    },
    //乘法
    accMul : function (arg1,arg2) {
        var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
        try {
            m += s1.split(".")[1].length
        } catch (e) {
        }
        try {
            m += s2.split(".")[1].length
        } catch (e) {
        }
        return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
    },
    //减法
    Subtr: function (arg1, arg2) {
        var r1, r2, m, n;
        try {
            r1 = arg1.toString().split(".")[1].length
        } catch (e) {
            r1 = 0
        }
        try {
            r2 = arg2.toString().split(".")[1].length
        } catch (e) {
            r2 = 0
        }
        m = Math.pow(10, Math.max(r1, r2));
        n = (r1 >= r2) ? r1 : r2;
        return ((arg1 * m - arg2 * m) / m).toFixed(n);
    },
    //除法
    accDiv: function (arg1, arg2) {
        var t1 = 0, t2 = 0, r1, r2;
        try {
            t1 = arg1.toString().split(".")[1].length
        } catch (e) {
        }
        try {
            t2 = arg2.toString().split(".")[1].length
        } catch (e) {
        }
        with (Math) {
            r1 = Number(arg1.toString().replace(".", ""))
            r2 = Number(arg2.toString().replace(".", ""))
            return accMul((r1 / r2), pow(10, t2 - t1));
        }
    },
    //-------------------避免精度损失 开始-------------------------------------
    //获取当前日期
    getCurrentDate:function(){
        //当前日期
        var year=new Date().getFullYear();
        var month=new Date().getMonth()+1;
        var day=new Date().getDate();
        if(month<10){
            month = "0" + month;
        }
        if(day < 10){
            day = "0" + day;
        }
        return year+'-'+month+'-'+day;
    }
}
    return commonApiServ
});