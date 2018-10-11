/**
 * DESC       : 阳光车险api-功能插件指令封装
 * AUTHOR     : 阳光项目组
 * CREATEDATE : 2016-10-28
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              yanglei       2016-10-28     api规划
 */

define(['angular','constants'], function (angular,constants) {

    angular.module('mc.validator', [])
        .factory('FormFocus',function() {
            var checkIsIE = function () {
                if ((navigator.userAgent.indexOf('MSIE') >= 0)
                    && (navigator.userAgent.indexOf('Opera') < 0)) {
                    return true;
                } else {
                    return false;
                }
            };
            return {
                focusEle:function(formName) {
                    var express = "[name="+formName+"] .ng-invalid:not(ng-form)";
                    var Ele = $(express);
                    $.each(Ele, function (index, ele) {
                        $(ele).addClass('ng-dirty');
                        if($(ele).next().length>0){
                            if($(ele).next()[0].className.indexOf('fake_pass') > -1){
                                $(ele).next().addClass('ng-dirty');
                            }
                        }
                    });

                    if (angular.isDefined(Ele[0])) {
                        if(Ele[0].nodeName.toUpperCase() == "CODE-TYPE"){ //匹配下拉框
                            if( (Ele[0].attributes["is-fuzzy"] == undefined) || (Ele[0].attributes["is-fuzzy"].nodeValue == "false") ) {
                                if ((navigator.userAgent.indexOf('MSIE 8.0') >= 0)|| (navigator.userAgent.indexOf('MSIE 11.0') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){
                                    Ele[0].children[3].children[0].children[0].focus();
                                    // scroll(0,-267);
                                }else{
                                    Ele[0].children[0].children[0].children[0].focus();
                                }
                            } else {
                                if ((navigator.userAgent.indexOf('MSIE 8.0') >= 0)|| (navigator.userAgent.indexOf('MSIE 11.0') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){
                                    Ele[0].children[1].children[0].children[0].focus();
                                }else{
                                    Ele[0].children[0].children[0].children[0].focus();
                                }
                            }
                        }else if(Ele[0].nodeName == "DIV" && $(Ele[0]).hasClass('ui-select-container')) { //div匹配ui-select
                            if ((navigator.userAgent.indexOf('MSIE 8.0') >= 0)|| (navigator.userAgent.indexOf('MSIE 11.0') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){
                                Ele[0].children[0].children[0].focus();
                            }else{
                                Ele[0].children[5].focus();
                            }
                        } else {
                            //Ele[0].focus();
                            if($(Ele[0]).next().length>0 && $(Ele[0]).next()[0].className.indexOf('fake_pass') > -1&&
                                ($(Ele[0]).next().css("display")=="block"||$(Ele[0]).next().css("display")=="inline-block")){
                                $(Ele[0]).next().addClass('ng-dirty');
                                $(Ele[0]).next()[0].focus();
                            }else{
                                Ele[0].focus();
                                $(document).scrollTop(300);
                            }
                        }
                    }
                },
                // focusEle: function (formName) {
                //     var express = "[name=" + formName + "] .ng-invalid:not(ng-form)";
                //     var Ele = $(express);
                //     $.each(Ele, function (index, ele) {
                //         $(ele).addClass('ng-dirty');
                //         if ($(ele).next().length > 0) {
                //             if ($(ele).next()[0].className.indexOf('fake_pass') > -1) {
                //                 $(ele).next().addClass('ng-dirty');
                //             }
                //         }
                //     });
                //
                //     if (angular.isDefined(Ele[0])) {
                //         if (Ele[0].nodeName == "CODE-TYPE" || Ele[0].nodeName == "code-type") { //匹配下拉框
                //             if ((Ele[0].attributes["is-fuzzy"] == undefined) || (Ele[0].attributes["is-fuzzy"].nodeValue == "false")) {
                //                 if ((navigator.userAgent.indexOf('MSIE 8.0') >= 0) || (navigator.userAgent.indexOf('MSIE 11.0') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)) {
                //                     Ele[0].children[3].children[0].children[0].focus();
                //                     // scroll(0,-267);
                //                 } else {
                //                     Ele[0].children[0].children[0].children[0].focus();
                //                 }
                //             } else {
                //                 if ((navigator.userAgent.indexOf('MSIE 8.0') >= 0) || (navigator.userAgent.indexOf('MSIE 11.0') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)) {
                //                     Ele[0].children[1].children[0].children[0].focus();
                //                 } else {
                //                     Ele[0].children[0].children[0].children[0].focus();
                //                 }
                //             }
                //         } else if (Ele[0].nodeName == "DIV" && $(Ele[0]).hasClass('ui-select-container')) { //div匹配ui-select
                //             Ele[0].children[4].focus();
                //         } else {
                //             //Ele[0].focus();
                //             if ($(Ele[0]).next().length > 0 && $(Ele[0]).next()[0].className.indexOf('fake_pass') > -1 &&
                //                 ($(Ele[0]).next().css("display") == "block" || $(Ele[0]).next().css("display") == "inline-block")) {
                //                 $(Ele[0]).next().addClass('ng-dirty');
                //                 $(Ele[0]).next()[0].focus();
                //             } else {
                //                 Ele[0].focus();
                //             }
                //         }
                //     }
                // }
                /**
                 * 必填校验
                 * 必填元素的name 以 required 结尾,warnText:要显示的错误信息
                 * 返回 Boolean 通过：true 否则：false
                 * @param fatherId 父级id
                 */
                requiredVerify:function (fatherId) {
                    var verifyElement = $(fatherId).find('.ng-invalid[name $= "required"]');//必填空元素
                    if(verifyElement.length == 0){
                        return true;
                    }
                    verifyElement.each(function (index) {
                        $(this).addClass('ng-dirty');
                    });
                    verifyElement[0].focus();
                    layerMsg(verifyElement[0].getAttribute('showText'));
                    return false;
                }
            }
        })
        .directive('rangeValue',['$parse',function($parse){
            return{
                require: 'ngModel',
                restrict: 'A',
                scope:{
                    maxValue:'=',
                    minValue:'='
                },
                compile:function(tElement, tAttrs){
                    return function(scope, element, attrs, ctrl){
                        element.on('blur',function(){
                            if(parseFloat(ctrl.$viewValue)>parseFloat(scope.maxValue)){
                                ctrl.$setViewValue(scope.maxValue);
                                alert('不能大于'+scope.maxValue);
                                scope.$parent.$apply();
                                ctrl.$render();
                            }
                            if(parseFloat(ctrl.$viewValue)<parseFloat(scope.minValue)){
                                ctrl.$setViewValue(scope.minValue);
                                alert('不能小于'+scope.minValue);
                                scope.$parent.$apply();
                                ctrl.$render();
                            }
                        });
                        if(attrs.rangeValue!=''){
                            if(attrs.rangeValue.indexOf('lt')>-1){
                                scope.$watch('maxValue', function (newValue) {
                                    if(!newValue||newValue===''){
                                        return;
                                    }
                                    if(ctrl.$viewValue-scope.maxValue<=0)
                                        return false;
                                    ctrl.$setViewValue(scope.maxValue);
                                    ctrl.$render();
                                });
                            }
                            if(attrs.rangeValue.indexOf('init')>-1){
                                scope.$watch('default', function (newValue) {
                                    ctrl.$setViewValue(newValue);
                                    ctrl.$render();
                                });
                            }
                        }
                        scope.$on('$destroy',function () {
                            element.off();
                        })
                    }
                }
            }
        }])

        /**
         * @ngdoc directive
         * @name $$cherry.directive:uppercase
         * @description
         * 强制转化大写
         * @restrict A
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <input type="text"
         uppercase
         ng-model="proposal.BC.prpTitemCar.vinNo">
         </file>
         </example>
         */
        .directive('uppercase', [function () {
            return {
                require: 'ngModel',
                restrict: 'A',
                link: function ($scope, element, attrs, ctrl) {

                    var capitalize = function (inputValue) {
                        inputValue = inputValue || '';

                        var capitalized = inputValue.toUpperCase();

                        if(capitalized !== inputValue) {
                            ctrl.$setViewValue(capitalized);
                            ctrl.$render();
                        }
                        return capitalized;
                    };

                    ctrl.$parsers.unshift (capitalize);

                    capitalize($scope[attrs.ngModel]);
                }
            };
        }])

        /**
         * @ngdoc directive
         * @name $$cherry.directive:warnText
         * @description
         * warnText指令,表单验证
         * @restrict A
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <input type="text"
         ng-model="proposal.BC.prpTitemCar.vinNo"
         ng-pattern=/^[A-Z*0-9]{0,18}$/
         warn-text="车架号"
         maxlength="18"
         required>
         </file>
         </example>
         */
        //warnText指令
        .directive('warnText', ['$parse', function ($parse) {
            return {
                require: 'ngModel',
                restrict: 'A',
                scope:true,
                controllerAs: "warnTextCtrl",
                controller:function ($scope, $element, $attrs, $transclude, $log) {
                    this.tip = function ($scope, element, attrs, ctrl) {
                        var ele = $(element); // 当前需要校验节点 jQuery对象
                        var errorTextEle; // 错误提示元素 jQuery对象
                        //判断
                        if (ctrl.$invalid&&ctrl.$dirty) {
                            if (!ele.attr('errorText')) {
                                ele.after('<div class="validation-errorText"></div>');
                                ele.attr('errorText', true);
                                element.on('focus', function () {
                                    errorTextEle.hide();
                                });
                            }
                            errorTextEle = ele.next('.validation-errorText');
                            var warnObj = '';
                            try{
                                warnObj = new Function("return "+attrs.warnText)();
                            }catch(e){
                            }
                            // itemName 为表单名字
                            // ErrPattern ：为正则校验错误时提示语句
                            // myIllegalWord : 为非法字符校验错误时提示语句
                            warnObj = warnObj || {'ErrPattern':'',itemName:'',myIllegalWord:''};
                            // 支持直接传入表单名字
                            if(attrs.warnText.indexOf("itemName") === -1&&attrs.warnText.indexOf("{") === -1){
                                warnObj.itemName = attrs.warnText;
                            } else if(!attrs.warnText) {
                                warnObj.itemName = ''
                            }
                            if (ctrl.$error.required) {
                                errorTextEle.text('该项为必填项')
                            } else if (ctrl.$error.minlength) {
                                errorTextEle.text(warnObj.itemName + '需至少输入' + attrs.ngMinlength+'位数!')
                            } else if (ctrl.$error.maxlength) {
                                errorTextEle.text(warnObj.itemName + '需至多输入' + attrs.ngMaxlength+'位数!')
                            } else if (ctrl.$error.email) {
                                errorTextEle.text('请输入正确的邮箱格式')
                            } else if (ctrl.$error.pattern) {
                                warnObj.ErrPattern = warnObj.ErrPattern || warnObj.itemName+'格式错误，请修改！';
                                errorTextEle.text(warnObj.ErrPattern);
                            } else if (ctrl.$error.myMaxLength){ // 字符长度校验
                                errorTextEle.text(warnObj.itemName + "最大长度为"+attrs.myMaxLength+"个英文字符");
                            } else if (ctrl.$error.myIllegalWord){ // 非法字符校验
                                warnObj.myIllegalWord = warnObj.myIllegalWord || attrs.myIllegalWord.replace(/\|/g,"或")+"为系统保留字符，不允许输入";
                                errorTextEle.text(warnObj.myIllegalWord);
                            } else if(ctrl.$error.myMaxnumber){
                                warnObj.myMaxnumber = warnObj.myMaxnumber || warnObj.itemName + '最大为'+attrs.myMaxnumber;
                                errorTextEle.text(warnObj.myMaxnumber);
                            } else if(ctrl.$error.customValidator){
                                warnObj.customValidator = warnObj.customValidator || warnObj.itemName+'录入不符合规则';
                                errorTextEle.text(warnObj.customValidator);
                            } else if(ctrl.$error.svCredit){
                                warnObj.svCredit = warnObj.svCredit || warnObj.itemName+'录入不符合规则';
                                errorTextEle.text(warnObj.svCredit);
                            }
                            errorTextEle.show()
                        } else {
                            errorTextEle = ele.next('.validation-errorText');
                            if(errorTextEle){
                                errorTextEle.hide()
                            }
                        }
                    }
                },
                compile: function () {
                    return function ($scope, element, attrs, ctrl) {
                        if(angular.isDefined(attrs.jedate)){ // 日期选择不在此做校验提示
                            return
                        }
                        element.on('blur', function () {
                            setTimeout(function(){
                                $scope.warnTextCtrl.tip($scope, element, attrs, ctrl)
                            },100)
                        });
                        $scope.$on('$destroy',function () {
                            element.off();
                        })
                    }
                }
            }

        }])
        // .directive('illegalWord', ['$parse', '$$util', function ($parse, $$util) {
        //     return {
        //         require: 'ngModel',
        //         restrict: 'A',
        //         compile: function () {
        //             return function ($scope, element, attrs, ctrl) {
        //
        //                 element.on('blur', function () {
        //                     //判断
        //                     if ($scope.proposal.BC.prpTitemCar.carOwner.indexOf("\'")>-1 || $scope.proposal.BC.prpTitemCar.carOwner.indexOf("\"")>-1) {
        //                         layer.open({
        //                             content: '请正确填写' + attrs.warnText + '！有非法字符！',
        //                             cancel: function (index) {
        //                                 layer.closeAll();
        //                                 element[0].focus();
        //                             },
        //                             yes: function (index) {
        //                                 layer.closeAll();
        //                                 element[0].focus();
        //                             }
        //                         });
        //                     }
        //                 });
        //                 $scope.$on('$destroy',function () {
        //                     element.off();
        //                 })
        //             }
        //         }
        //     }
        //
        // }])
        // 动态非法字符校验
        .directive('myIllegalWord', function () {
            return {
                require: 'ngModel',
                restrict: 'A',
                link: function (scope, element, attrs, ctrl) {
                    var myIllegalWordValidator = function (val) {
                        if(val){
                            var str= val.trim();
                            var ary = attrs.myIllegalWord.split("|");
                            for(var i= 0;i<ary.length;i++){
                                if(str.indexOf(ary[i])>-1){
                                    ctrl.$setValidity("myIllegalWord",false);
                                    return
                                }else {
                                    ctrl.$setValidity("myIllegalWord",true);
                                    break
                                }
                            }
                        }
                        return val
                    };
                    ctrl.$parsers.push(myIllegalWordValidator);
                }
            }
        })
    // 校验字符长度
    .directive('myMaxLength',function () {
        return {
            require: 'ngModel',
            restrict: 'A',
            link: function (scope, element, attrs, ctrl) {
                var myMaxLengthValidator = function (val) {
                    if(val){
                        var str= val.trim();
                        var chineseLen = str.length - str.replace( /[\u4e00-\u9fa5]/g,'').length;
                        var len = chineseLen + str.length;
                        if (len > attrs.myMaxLength){
                            ctrl.$setValidity("myMaxLength",false)
                        }else {
                            ctrl.$setValidity("myMaxLength",true)
                        }
                    }
                    return val
                };
                ctrl.$parsers.push(myMaxLengthValidator);
            }
        }
    })
    // 校验数字不能大于某个值
        .directive('myMaxnumber', function () {
            return {
                require: 'ngModel',
                restrict: 'A',
                link: function (scope, element, attrs, ctrl) {
                    var maxnumberValidator = function (val) {
                        if(val){
                            var str= val.trim();
                            var num = Number(val);
                            var maxNum = Number(attrs.myMaxnumber);
                            if(!isNaN(num)&&!isNaN(maxNum)){
                                if (num > maxNum){
                                    ctrl.$setValidity("myMaxnumber",false)
                                }else {
                                    ctrl.$setValidity("myMaxnumber",true)

                                }
                            }
                        }
                        return val
                    };
                    ctrl.$parsers.push(maxnumberValidator);
                }
            }

        })
    // 自定义校验函数
    .directive('customValidator', ["$timeout", function ($timeout) {
        return {
            require: ['ngModel','warnText'],
            restrict: 'A',
            link: function (scope, element, attrs, ctrlAry) {
                var warnTextCtrl = ctrlAry[1];  // warnText指令的控制器函数
                var ctrl = ctrlAry[0]; // ngModel 控制器
                var valitor; // 传入的校验规则
                var blurAry = []; // blur 时触发的校验池
                var changeAry = []; // 输入 时触发的校验池
                // var state = true;
                var setwarnText = function (text) {
                    var reg = /((?:\s|\S)*customValidator\s*:\s*\')((?:\s|\S)*)(\'(?:\s|\S)*)/;
                    var str;
                    if(attrs.warnText===""){
                        str  = "{customValidator:'"+ text+"'}"
                    } else if(attrs.warnText.indexOf("{")===-1&&attrs.warnText) {
                        str  = "{itemName:'"+attrs.warnText + "',"+ "customValidator:'"+ text+"'}";
                    } else {
                        str = attrs.warnText.replace(reg,function(a,b,c,d){
                            return b + text + d
                        })
                    }
                    attrs.warnText = str;
                };
                var callback = function (text,sync) {
                    if(text){
                        ctrl.$setValidity("customValidator",false);
                        setwarnText(text);
                    }else {
                        ctrl.$setValidity("customValidator",true)
                    }
                    if(sync){
                        warnTextCtrl.tip(scope, element, attrs,ctrl)
                    }
                };
                $timeout(function () {
                    try{
                        valitor =  JSON.parse(attrs.customValidator)
                    }catch (e){
                        valitor =  scope.$eval(attrs.customValidator)
                    }
                    var bindFn = function (valitorObj) {
                        if (valitorObj.trigger === "change") {
                            changeAry.push(valitorObj.validator);
                        } else {
                            blurAry.push(valitorObj.validator);
                        }
                    };
                    if(angular.isArray(valitor)) {
                        for (var i =0 ;i<valitor.length;i++){
                            bindFn(valitor[i])
                        }
                    } else if(angular.isObject(valitor)){
                        bindFn(valitor)
                    }
                    if(blurAry.length>0){
                        element.on("blur",function () {
                            for (var j= 0;j<blurAry.length;j++){
                                blurAry[j](ctrl.$viewValue,callback)
                            }
                            // state = false;
                        })
                    }
                    if(changeAry.length>0){
                        element.on("input",function () {
                            for (var k= 0;k<changeAry.length;k++){
                                changeAry[k](ctrl.$viewValue,callback)
                            }
                        })
                    }
                    // element.on("focus",function () {
                    //     state = true;
                    // });
                    scope.$on('$destroy',function () {
                        element.off();
                    })
                },200);
            }
        }
    }])
    /**
     * @ngdoc directive
     * @name $$cherry.directive:checkBoxs
     * @description
     * checkBoxs指令,多个复习选框赋值
     * @restrict A
     * @example
     <example module="cherry.directive">
     <file name="index.html">
     </example>
     */
    // .directive('checkBoxs', ['$parse', '$$util','$timeout', function ($parse, $$util,$timeout) {
    //     return {
    //         require: 'ngModel',
    //         restrict: 'A',
    //         scope: {
    //             ngModel: '=',
    //             checkValue: '='
    //         },
    //         compile: function () {
    //             return function ($scope, element, attrs, ctrl) {
    //
    //                 element.on('change', function () {
    //                     var reason=document.getElementsByName(attrs.name);
    //                     var getReason=[];
    //                     angular.forEach(reason,function(data){
    //                         if(data.checked){
    //                             getReason.push(data.value);
    //                         }
    //                     });
    //                     $timeout(function () {
    //                         $scope.checkValue=getReason;
    //                     },1);
    //                     // console.log($scope.lifetable.statueFlag);
    //                 });
    //                 $scope.$on('$destroy',function () {
    //                     element.off();
    //                 })
    //             }
    //         }
    //     }
    // }]);
    /**
     * $element//调用这个指令的元素？
     * $attrs//获取当前元素的属性
     * $ctrl//当前元素所在的控制器
     * svCredit// 联动校验
     */
    .directive('svCredit', [function () {
        return {
            require: "^ngModel",
            restrict:'A',
            controllerAs: 'svCreditCtrl',
            controller:function ($scope, $element, $attrs, $transclude, $log) {

                /**
                 * 判断证件号是否为空
                 * @param cardNo
                 * @returns {boolean}
                 */
                cardNoisEmpty = function(cardNo){
                    if(!angular.isDefined(cardNo) || cardNo == null || cardNo == ""){
                        return true;
                    }
                    return false;
                };
                /**
                 *01.校验身份证
                 **/
                this.validateIDCard = function(card){
                    var vcity={ 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
                        21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
                        33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
                        42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
                        51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
                        63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"
                    };

                    var checkIDCard = function(card)
                    {
                        //是否为空
                        if(card === '')
                        {
                            return false;
                        }
                        //校验长度，类型
                        if(isCardNo(card) === false)
                        {
                            return false;
                        }
                        //检查省份
                        if(checkProvince(card) === false)
                        {
                            return false;
                        }
                        //校验生日
                        if(checkBirthday(card) === false)
                        {
                            return false;
                        }
                        //检验位的检测
                        if(checkParity(card) === false)
                        {
                            return false;
                        }
                        return true;
                    };


                    //检查号码是否符合规范，包括长度，类型
                    var isCardNo = function(card)
                    {
                        //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
                        var reg = /(^\d{15}$)|(^\d{17}(\d|X)$)/;
                        if(reg.test(card) === false)
                        {
                            return false;
                        }

                        return true;
                    };

                    //取身份证前两位,校验省份
                    var checkProvince = function(card)
                    {
                        var province = card.substr(0,2);
                        if(vcity[province] == undefined)
                        {
                            return false;
                        }
                        return true;
                    };

                    //检查生日是否正确
                    var checkBirthday = function(card)
                    {
                        var len = card.length;
                        //身份证15位时，次序为省（3位）市（3位）年（2位）月（2位）日（2位）校验位（3位），皆为数字
                        if(len == '15')
                        {
                            var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;
                            var arr_data = card.match(re_fifteen);
                            var year = arr_data[2];
                            var month = arr_data[3];
                            var day = arr_data[4];
                            var birthday = new Date('19'+year+'/'+month+'/'+day);
                            return verifyBirthday('19'+year,month,day,birthday);
                        }
                        //身份证18位时，次序为省（3位）市（3位）年（4位）月（2位）日（2位）校验位（4位），校验位末尾可能为X
                        if(len == '18')
                        {
                            var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
                            var arr_data = card.match(re_eighteen);
                            var year = arr_data[2];
                            var month = arr_data[3];
                            var day = arr_data[4];
                            var birthday = new Date(year+'/'+month+'/'+day);
                            return verifyBirthday(year,month,day,birthday);
                        }
                        return false;
                    };

                    //校验日期
                    var verifyBirthday =function(year,month,day,birthday)
                    {
                        var now = new Date();
                        var now_year = now.getFullYear();
                        //年月日是否合理
                        if(birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day)
                        {
                            //判断年份的范围（0岁到100岁之间)
                            var time = now_year - year;
                            if(time >= 0 && time <= 100)
                            {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    };

                    //校验位的检测
                    var checkParity =function(card)
                    {
                        //15位转18位
                        card = changeFivteenToEighteen(card);
                        var len = card.length;
                        if(len == '18')
                        {
                            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
                            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
                            var cardTemp = 0, i, valnum;
                            for(i = 0; i < 17; i ++)
                            {
                                cardTemp += card.substr(i, 1) * arrInt[i];
                            }
                            valnum = arrCh[cardTemp % 11];
                            if (valnum == card.substr(17, 1))
                            {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    };

                    //15位转18位身份证号
                    var changeFivteenToEighteen =function(card)
                    {
                        if(card.length == '15')
                        {
                            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
                            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
                            var cardTemp = 0, i;
                            card = card.substr(0, 6) + '19' + card.substr(6, card.length - 6);
                            for(i = 0; i < 17; i ++)
                            {
                                cardTemp += card.substr(i, 1) * arrInt[i];
                            }
                            card += arrCh[cardTemp % 11];
                            return card;
                        }
                        return card;
                    };

                    return checkIDCard(card);
                };
                /*
                *71.组织机构代码 //
                **/
                this.validateOrganization = function(card){
                    var creditNoRegexp = /^[a-zA-Z0-9]{8}-[a-zA-Z0-9]$/;
                    var validity = cardNoisEmpty(card) || creditNoRegexp.test(card);
                    return validity
                };
                /*
                *02.户口本
                */
                this.validateHouseholdRegister = function(card){
                    var creditNoRegexp = /^[a-zA-Z0-9]{3,21}$/;
                    var validity = cardNoisEmpty(card) || creditNoRegexp.test(card);
                    return validity
                };
                /*
                 *03.护照
                 */
                this.validatePassport = function(card){
                    var creditNoRegexp = /^[a-zA-Z0-9]{3,21}$/;
                    var validity = cardNoisEmpty(card) || creditNoRegexp.test(card);
                    return validity
                };
                /*
                 *04.军官证
                 */
                this.validateCertificateOfOfficers = function(card){
                    var creditNoRegexp = /^[a-zA-Z0-9]{7,21}$/;
                    var validity = cardNoisEmpty(card) || creditNoRegexp.test(card);
                    return validity
                };
                /*
                *99.校验其他证件类型,不允许输入汉字
                **/
                this.validateOther = function(card){
                    var creditNoRegexp = /^[^\u4e00-\u9fa5]{0,}$/;
                    var validity = cardNoisEmpty(card) || creditNoRegexp.test(card);
                    return validity ? card : undefined;
                };

                /**
                 *证件类型校验函数表
                 * key：证件类型
                 * value：对应的校验方法
                 **/
                this.validateFuns = {
                    "01": this.validateIDCard,
                    "02": this.validateHouseholdRegister,
                    "03": this.validatePassport,
                    "04": this.validateCertificateOfOfficers,
                    "05": this.validateIDCard,
                    "71": this.validateOrganization
                };
            },
            link: function (scope, element, attr, ctrl, svCreditCtrl) {
                svCreditCtrl = scope.svCreditCtrl;
                /**
                 *全局校验方法变量
                 */
                var validateFun;

                /**
                 * 用于根据证件类型更新校验方法
                 * @param type
                 */
                var refreshValidateFun = function(type){
                    validateFun = angular.isDefined(svCreditCtrl.validateFuns[type])?svCreditCtrl.validateFuns[type]:svCreditCtrl.validateOther;
                };


                /**
                 * 证件类型变化响应方法
                 * @param newValue
                 * @param oldValue
                 * @param scope
                 */
                var onCreditTypeChange = function(newValue, oldValue, scope){
                    if(newValue == oldValue){
                        return;
                    }

                    //更新校验方法体
                    refreshValidateFun(newValue);

                    if(!angular.isDefined(oldValue) || oldValue == ""){
                        //console.log("oldValue is empty");
                        return;
                    }

                    var creditCode = !ctrl.$modelValue?ctrl.$viewValue:ctrl.$modelValue;

                    if(!creditCode){
                        //console.log("credit no is empty");
                        return;
                    }

                    //触发ctrl的$parses，重新校验
                    //ctrl.$setValidity("svCredit", true);
                    //ctrl.$error = {};
                    //ctrl.$invalid = false;
                    //console.log("creditCode="+creditCode);
                    ctrl.$setViewValue(creditCode);
                    ctrl.$render();

                    //customValidator(creditCode);

                    //焦点到证件号码，触发校验提示
                    if(!ctrl.$invalid){
                        $(element).next().css('display','none');
                    }else{
                        $(element).next().css('display','inline');
                        $(element).focus();
                    }

                };

                /**
                 * 监控证件类型变化
                 */
                scope.$watch(attr.svCredit,onCreditTypeChange);

                /**
                 * 设置默认的校验方法
                 */
                var svCredit = scope.$eval(attr.svCredit);
                refreshValidateFun(svCredit);

                /**
                 * 自定义校验
                 * @param value
                 * @returns {undefined}
                 */
                var customValidator = function (value) {
                    //console.log("证件号码："+value+",validfun="+validateFun.name);
                    var validity = ctrl.$isEmpty(value) || validateFun(value);
                    ctrl.$setValidity("svCredit", validity);
                    return validity ? value : undefined;
                };

                ctrl.$formatters.push(customValidator);
                ctrl.$parsers.push(customValidator);

                //ctrl.$setViewValue = function(value){};

            }
        };
    }])
});