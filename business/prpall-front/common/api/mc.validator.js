/**
 * DESC       : 阳光车险api-功能插件指令封装
 * AUTHOR     : 阳光项目组
 * CREATEDATE : 2016-10-28
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              yanglei       2016-10-28     api规划
 */

define(['angular','constants','layer'], function (angular,constants) {

    angular.module('mc.validator', [])

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
         * $scope//调用这个指令的作用域
         * $element//调用这个指令的元素？
         * $attrs//获取当前元素的属性
         * $ctrl//当前元素所在的控制器
         * reVal.test(ctrl.$viewValue)//用当前的视图值去校验正则，如果用$scope.ngModel去校验，如果校验不通过，会把ngModel值覆盖掉，所以这里用的是ctrl.$viewValue
         * $setValidity//设置校验
         */
        .directive('customerName', [function () {
            return {
                require: 'ngModel',
                restrict: 'A',
                link: function ($scope, element, attrs, ctrl) {
                    element.on('blur',function() {
                        var reVal1 = /[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）\、\.\&\s]/;//errorMessage("\"客户名称\"只允许录入中文、英文字母、阿拉伯数字、中英文的小括号、中文的\“、\”号、英文\“.\”和\“&\”号!" + errMsg);
                        var reVal2 = /^\d*$/;//errorMessage("\"客户名称\"不允许全为阿拉伯数字!" + errMsg);
                        var reVal3 = /(([\u4E00-\u9FA5]))\1\1/;//"\"客户名称\"中存在重复汉字数大于2个，请确认!
                        if (reVal1.test(ctrl.$viewValue)) {
                            ctrl.$setValidity("customerName", false);
                        }else if(reVal2.test(ctrl.$viewValue)){
                            ctrl.$setValidity("customerName", false);
                        }else if((/^[\u4E00-\u9FA5].*$/.test(ctrl.$viewValue)) && (/^[\u4E00-\u9FA5][^\u4E00-\u9FA5]/.test(ctrl.$viewValue))) {
                            ctrl.$setValidity("customerName",false);
                        }else  if(reVal3.test(ctrl.$viewValue)){
                            ctrl.$setValidity("customerName",false);
                        }else {
                            ctrl.$setValidity("customerName",true);
                        }
                    });
                }
            };
        }])
        /**
         * $scope//调用这个指令的作用域
         * $element//调用这个指令的元素？
         * $attrs//获取当前元素的属性
         * $ctrl//当前元素所在的控制器
         */
        .directive('checkTerrorist', ['$$finder',function ($$finder) {
            return {
                require: 'ngModel',
                restrict: 'A',
                link: function ($scope, element, attrs, ctrl) {
                    var ele = $(element);
                    element.on('blur',function() {
                        var AppliInsuredInsuredName=ele.attr('insuredName');
                        $$finder.find('checkTerrorist',{}, {
                            success: function (data) {
                                var xmlText = data.xmlText;
                                if(xmlText&&xmlText=="1"){//如果返回的结果是一，说明他是恐怖分子
                                    ctrl.$setValidity("checkTerrorist",false);
                                }else {
                                    ctrl.$setValidity("checkTerrorist",true);
                                }
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    });
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
        .directive('warnText', ['$parse','$timeout', function ($parse,$timeout) {
            return {
                require: 'ngModel',
                restrict: 'A',
                compile: function () {
                    return function ($scope, element, attrs, ctrl) {
                        if(angular.isDefined(attrs.jedate)){ // 日期选择不在此做校验提示
                            return
                        }
                        var ele = $(element); // 当前需要校验节点 jQuery对象
                        var errorTextEle; // 错误提示元素 jQuery对象
                        element.on('blur', function () {
                            $timeout(function (){
                                //判断
                                if (!ele.attr('errorText')) {
                                    ele.after('<div class="validation-errorText"></div>');
                                    ele.attr('errorText', true);
                                    errorTextEle = ele.next();
                                    element.on('focus', function () {
                                        errorTextEle.hide();
                                    });
                                }
                                if (ctrl.$invalid) {
                                    if (ctrl.$error.required) {
                                        errorTextEle.text('该项为必填项')
                                    } else if (ctrl.$error.minlength) {
                                        errorTextEle.text(attrs.warnText + '最小长度为' + attrs.ngMinlength)
                                    } else if (ctrl.$error.maxlength) {
                                        errorTextEle.text(attrs.warnText + '最大长度为' + attrs.ngMaxlength)
                                    } else if (ctrl.$error.email) {
                                        errorTextEle.text('请输入正确的邮箱格式')
                                    } else if (ctrl.$error.pattern) {
                                        errorTextEle.text(attrs.warnText + '格式错误，请修改！');
                                    } else if(ctrl.$error.customerName){
                                        errorTextEle.text(attrs.warnText + '格式错误，请修改！');
                                    } else if(ctrl.$error.checkTerrorist){
                                        errorTextEle.text('该客户可能为恐怖分子，请确认！');
                                    } else if(ctrl.$error.svCredit){
                                        errorTextEle.text('证件号码录入不符合规则');
                                    }
                                    errorTextEle.show()
                                } else {
                                    errorTextEle.hide()
                                }
                            },100)
                        });
                        $scope.$on('$destroy',function () {
                            element.off();
                        })
                    }
                }
            }
        }])
        /**
         * @ngdoc directive
         * @name $$cherry.directive:warnText
         * @description
         * warnLayer指令,表单验证
         * @restrict A
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <input type="text"
         ng-model="proposal.BC.prpTitemCar.vinNo"
         ng-pattern=/^[A-Z*0-9]{0,18}$/
         warn-layer="车架号"
         maxlength="18"
         required>
         </file>
         </example>
         */
        //warnLayer指令
        .directive('warnLayer', ['$parse','$timeout', function ($parse,$timeout) {
            return {
                require: 'ngModel',
                restrict: 'A',
                compile: function () {
                    return function ($scope, element, attrs, ctrl) {
                        if(angular.isDefined(attrs.jedate)){ // 日期选择不在此做校验提示
                            return
                        }
                        var errorTextEle;
                        element.on('blur', function () {
                            $timeout(function (){
                                //判断
                                if (ctrl.$invalid) {
                                    if (ctrl.$error.required) {
                                        errorTextEle ='该项为必填项';
                                    } else if (ctrl.$error.minlength) {
                                        errorTextEle = attrs.warnLayer + '最小长度为' + attrs.ngMinlength;
                                    } else if (ctrl.$error.maxlength) {
                                        errorTextEle = attrs.warnLayer + '最大长度为' + attrs.ngMaxlength;
                                    } else if (ctrl.$error.email) {
                                        errorTextEle = '请输入正确的邮箱格式';
                                    } else if (ctrl.$error.pattern) {
                                        errorTextEle = attrs.warnLayer + '格式错误，请修改！';
                                    } else if(ctrl.$error.customerName){
                                        errorTextEle = attrs.warnLayer + '格式错误，请修改！';
                                    } else if(ctrl.$error.checkTerrorist){
                                        errorTextEle = '该客户可能为恐怖分子，请确认！';
                                    }
                                    layer.open({
                                        offset: ['35%', '40%'],
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: errorTextEle,
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        }
                                    });
                                }
                            },100)
                        });
                    }
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
        .directive('checkBoxs', ['$parse','$timeout', function ($parse,$timeout) {
            return {
                require: 'ngModel',
                restrict: 'A',
                scope: {
                    ngModel: '=',
                    checkValue: '='
                },
                compile: function () {
                    return function ($scope, element, attrs, ctrl) {
                        element.on('change', function () {
                            var reason=document.getElementsByName(attrs.name);
                            var getReason=[];
                            angular.forEach(reason,function(data){
                                if(data.checked){
                                    getReason.push(data.value);
                                }
                            });
                            $timeout(function () {
                                $scope.checkValue=getReason;
                            },1);
                            // console.log($scope.lifetable.statueFlag);
                        });
                        $scope.$on('$destroy',function () {
                            element.off();
                        })
                    }
                }
            }
        }])
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
                        console.log("证件类型："+type);
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
                            console.log("oldValue is empty");
                            return;
                        }

                        var creditCode = !ctrl.$modelValue?ctrl.$viewValue:ctrl.$modelValue;

                        if(!creditCode){
                            console.log("credit no is empty");
                            return;
                        }

                        //触发ctrl的$parses，重新校验
                        //ctrl.$setValidity("svCredit", true);
                        //ctrl.$error = {};
                        //ctrl.$invalid = false;
                        console.log("creditCode="+creditCode);
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
                        console.log("证件号码："+value+",validfun="+validateFun.name);
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