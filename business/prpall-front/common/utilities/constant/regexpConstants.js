/**
 * DESC       : 国元农险理赔 共用表单验证正则
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017/11/23
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define(function () {
    var regexpConstants = {
        hour: /^(\d|1\d|2[1-4])$/, // 校验只能输入 1 - 24 （包含）数字
        number: /^[0-9]*$/, // 校验只能输入数字
        email: /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/, // 电子邮箱
        Chinese: /^[\u2E80-\u9FFF]+$/, // 汉字
        telPhoneNumber:/^0{0,1}(1[3-9])[0-9]{9}$/,//移动电话,不加86
        phoneNumber:/(\d{2,5}-\d{7,8}?)/,//固定电话的校验格式为010-67312122
        postCode:/^[0-9]{6}$/,   //邮编号
        bankId:/\d{16,19}/,//银行卡号
        cardId:/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,//身份证校验
        checkUsername:/^[A-Za-z0-9\u4e00-\u9fa5]+$/,//用户名称
        code:/^[A-Za-z0-9]+$/,//代码校验；只能输入字母与数字
        //utilNoticeModelRegex:/^[\u2E80-\u9FFF]{1,}[省市区][\u2E80-\u9FFF]{1,}[市县区][\u2E80-\u9FFF]{1,}[市县区]\S+$/,
        utilNoticeModelRegex:/^[\u2E80-\u9FFF]{1,}[省市]{0,1}[\u2E80-\u9FFF]{1,}[县区][\u4E00-\u9FA50-9]+$/
    };
    return regexpConstants
});