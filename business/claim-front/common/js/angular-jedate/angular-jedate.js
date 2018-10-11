define([
    'jedate',
    'angular'
],function(jeDate){

    angular.module("angular-jedate", [])
    /**
     * @ngdoc directive
     * @name $$cherry.directive:jedate
     * @description
     * jedate日期控件及日期处理
     * @restrict A
     * @scope
     * @param {string} ngModel ngModel绑定值
     * @example
     <example module="cherry.directive">
     <file name="index.html">
     <input type="text"
     ng-model="proposal.CI.prpTmain.startDate"
     id="date1" name="date" jedate format="YYYY-MM-DD">
     </file>
     </example>
     */
        .directive('jedate', ['$timeout', '$parse', function ($timeout, $parse) {

            /**
             * 对外放出一个接口,触发指令函数
             * @param waitEvent
             * @param scope
             */
            var validation = function (waitEvent, scope) {
                if (waitEvent) {
                    $timeout(function () {
                        waitEvent(scope.$parent);
                    }, 100)
                }
            };

            return {
                restrict: "A",
                require:"ngModel",
                scope:{
                    'ngModel':'='
                },
                link: function (scope, element, attrs, ctrl) {
                    var id = attrs.id;
                    var oldModel = scope.ngModel||'';
                    var errorTextEle; // 错误校验提示元素
                    // 正则校验集合
                    var  regObj = {
                        // 校验年 只校验四位数字；范围限制在代码里
                        "DATE-YYYY":  /^\d{4}$/,
                        // 校验年月
                        "DATE-YYYY-MM": /^[0-9]{4}-(0[1-9]|1[1,2])/,
                        // 校验年月日
                        "DATE-YYYY-MM-DD1": /^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-8])))$/,
                        "DATE-YYYY-MM-DD2": /^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-9])))$/,
                        "DATE-hh:mm:ss": /^([0,1]\d|2[0-4]):[0-5]\d:[0-5]\d$/,
                        "DATE-hh:mm": /^([0,1]\d|2[0-4]):[0-5]\d$/
                    };
                    var reMatch = function (str) {
                        return str.match(/\w+|d+/g);
                    };
                    var options = {
                        dateCell:"#" + id
                    };
                    if(attrs.myBlur){
                        var blurCallBack=$parse(attrs.myBlur);
                    }

                    var changeCallBack = $parse(attrs.ngChange);
                    var _changeCallBack = $parse(attrs.waitChange);

                    /**
                     * 日期格式校验
                     * @param regex 正则
                     * @param data  当前日期
                     * @param attrs attrs
                     * @param oldModel 之前日期
                     * @returns {*}
                     */
                    var valid = function (date,attrs) { //校验最大最小日期范围
                        if (attrs.minDate && date < attrs.minDate) {
                            return {date:undefined, minDate: false};
                        } else if (attrs.maxDate && date > attrs.maxDate) {
                            return {date:undefined, maxDate: false};
                        } else {
                            return {date:date, flag:true};
                        }
                    };
                    var getRegByYear = function (date) { // 获取闰年 闰月的正则
                        if(date.substring(0,4)%4==0) {
                            return regObj["DATE-"+ options.format.substr(0,10)+"2"]
                        } else {
                            return regObj["DATE-"+ options.format.substr(0,10)+"1"]
                        }
                    };
                    var validationData=function(date,attrs){
                        var regex;
                        if(options.format == "YYYY-MM-DD"){
                            regex = getRegByYear(date);
                            if(regex.test(date)){
                                return valid(date, attrs)
                            } else {  // 校验格式不通过
                                return {date:undefined, flag:false};
                            }
                        } else if ( options.format == "YYYY-MM") {
                            regex = regObj["DATE-"+ options.format];
                            if(!regex.test(date)){
                                return valid(date, attrs)
                            } else {  // 校验格式不通过
                                return {date:undefined, flag:false};
                            }
                        } else if (options.format == "YYYY") {
                            regex = regObj["DATE-"+ options.format];
                            if(regex.test(date)){
                                return valid(date, attrs)
                            } else { // 校验格式不通过
                                return {date:undefined, flag:false};
                            }
                        }else if (options.format == "YYYY-MM-DD hh:mm:ss") {
                            var dateAry = date.split(/\s/g);
                            regex = regObj["DATE-hh:mm:ss"];

                            if(dateAry.length === 2 && getRegByYear(date).test(dateAry[0]) && regex.test(dateAry[1])) {
                                return valid(date, attrs)
                            }else { // 校验格式不通过
                                return {date:undefined, flag:false};
                            }
                            // regex = regObj["DATE-"+ options.format]
                        } else if (options.format == "hh:mm:ss") {
                            regex = regObj["DATE-"+ options.format];
                            if(regex.test(date)){
                                return valid(date, attrs)
                            } else { // 校验格式不通过
                                return {date:undefined, flag:false};
                            }
                        } else {
                            // regex = /^\d$/;   // 其他类型不做校验  不支持手动输入
                            return valid(date, attrs)
                        }
                    };

                    element.after('<div class="validation-errorText"></div>');
                    errorTextEle = $(element).next(".validation-errorText");
                    element.on('focus', function () {
                        errorTextEle.hide();
                    });

                   /* options.minDate = attrs.minDate ?attrs.minDate:undefined;//最小日期
                    options.maxDate = attrs.maxDate ?attrs.maxDate:undefined;//最大日期*/
                    //options.isClear = false;//默认不展示清空按钮
                    options.isTime = attrs.isTime;//默认关闭时间选择
                    options.festival = false;//默认显示节日
                    options.skinCell = 'jedateblue';//风格调用，CSS中增加了3种风格（红、绿、蓝）
                    options.format =  attrs.format ? attrs.format : 'YYYY-MM-DD';//日期格式设置( YYYY-MM-DD hh:mm:ss 设置 年-月-日 时:分:秒; YYYY-MM-DD 设置 年-月-日)
                    options.clearRestore = false; //清空输入框，返回预设日期，输入框非空的情况下有效
                    options.onClose = false; //是否为选中日期后关闭弹层，为false时选中日期后关闭弹层
                    options.clearfun = function (obj) { //清空回调
                        console.log("清空回调：",obj);
                        ctrl.$setValidity("validDate", true); // 规则校验标志置为通过
                        if (ctrl.$error.required!==undefined) { // 有必填校验
                            errorTextEle.text("该项为必填项");
                            errorTextEle.show();
                        } else {
                            errorTextEle.hide();
                        }
                        scope.$apply(function(){
                            scope.ngModel="";
                            // ctrl.$setViewValue("");
                            // scope.$parent.infoToView.jedateChange = true;
                            validation(changeCallBack, scope);
                            validation(_changeCallBack, scope);
                        })
                    };

                    options.okfun =function(obj){ //确定回调
                        console.log("确定回调：",obj);
                        // ctrl.$setValidity("$validDate", true);
                        var data = valid(obj.val, attrs); //只对日期是否符合范围进行校验
                        // console.log(ctrl)
                        // 第一次手动选择一个日期赋值后将表单置为脏的状态
                        if(!element.hasClass("ng-dirty")){
                            element.addClass("ng-dirty").removeClass("ng-pristine");
                            ctrl.$dirty = true;
                            ctrl.$pristine = false;
                        }
                        if(data.date){
                            ctrl.$setValidity("validDate", true);
                            errorTextEle.hide()
                        } else if(data.minDate === false && attrs.value=='4'){
                            ctrl.$setValidity("validDate", false);
                            errorTextEle.text(attrs.name+'的结束日期不能小于'+attrs.name+'的开始日期!')
                            errorTextEle.show()
                        }else if  ( data.maxDate === false&& attrs.value=='3' ) { // 当日期 大于最大日期时
                            ctrl.$setValidity("validDate", false);
                            errorTextEle.text(attrs.name+'的开始日期不能大于'+attrs.name+'的结束日期！')
                            errorTextEle.show()
                        } else if (data.minDate === false && attrs.value!='4'){
                            ctrl.$setValidity("validDate", false);
                            // errorTextEle.text("不能选择小于最小日期");
                            errorTextEle.text(attrs.name+"止期不能小于"+attrs.name+"起期");
                            errorTextEle.show()
                        }else if (data.maxDate === false && attrs.value!='3'){
                            ctrl.$setValidity("validDate", false);
                            // errorTextEle.text("不能选择大于最最大日期");
                            errorTextEle.text(attrs.name+"起期不能大于"+attrs.name+"止期");
                            errorTextEle.show()
                        }
                        if(data.date){
                            element.attr("invalid_Date",false); // invalid_Date当格式正确时将此值设置为false
                            scope.$apply(function(){
                                scope.ngModel=data.date;
                                // scope.$parent.infoToView.jedateChange = true;
                                validation(changeCallBack, scope);
                                validation(_changeCallBack, scope);
                            })
                        } else {

                        }

                    };

                    element.on('blur',function(event){
                        $timeout(function () { // 当选择日期会有异步问题 blur 先触发；此时未选中任何值时不做提示
                            // 三种情况：blur 先触发时 clear或者选中后触发；选中先触发 blur后触发 只触发onblur
                            if(ctrl.$invalid&&ctrl.$error.validDate === true){ //先判断有没有格式错误
                                errorTextEle.show()
                            } else if (ctrl.$error.required!==undefined&&ctrl.$invalid&&!ctrl.$viewValue&&ctrl.$dirty === true) { // 有必填项校验并且校验不通过并且当前视图的值为空并且表单已经填写过的情况
                                // 有必填校验
                                errorTextEle.text("该项为必填项");
                                errorTextEle.show();
                            } else {  //校验通过隐藏提示信息
                                errorTextEle.hide();
                            }
                        },100)
                    });
                    var setView = function (val) {
                        var timer = $timeout(function () {
                            element[0].value= scope.ngModel
                        });
                        clearTimeout(timer);
                    };
                    var customValidator = function (value) {
                        if(!value){
                            ctrl.$setValidity("validDate", true);
                            return undefined;
                        }
                        // 手动输入进行格式统一转换
                        if(options.format === 'YYYY-MM-DD'){
                            var date =value.replace(/-|\s|\.|:|\//g,'');
                            date = date.substring(0,4) + '-' + date.substring(4,6) +'-'+ date.substring(6,8)+ date.substring(8)
                        }else {
                            var date =value.replace(/-|\s|:|\/\./g,'-');
                            if (date.length>10){ //带时分秒
                                date= date.substring(0, 10) + ' ' + (date.substring(11).replace(/-/g,':'));
                            }
                        }
                        // 进行校验
                        var data = validationData(date, attrs);
                        // 根据校验结果更改校验状态；设置提示语
                        if(data.flag === true) {
                            // 日期正确
                            ctrl.$setValidity("validDate", true);
                            errorTextEle.text('');

                            element.attr("invalid_Date",false); // invalid_Date 手动输入格式不正确的时候设置一个标志 让日期控件内部做判断不以此日期设置当前选中 （在手动输入格式正确 或者 选择正确后应当置为false ）
                            if(element.value!=date){
                                setView();
                            }
                        } else if (data.flag === false) { // 当日期格式校验不正确的时候
                            ctrl.$setValidity("validDate", false);
                            if(attrs.value=='1'){
                                errorTextEle.text(attrs.name+"止期格式输入错误，请修改！");
                            }else if(attrs.value=='2'){
                                errorTextEle.text(attrs.name+"格式错误，请修改！");
                            }else if(attrs.value=='3'){
                                errorTextEle.text(attrs.name+"的开始日期格式错误，请修改！");
                            }else if(attrs.value=='4'){
                                errorTextEle.text(attrs.name+"的结束日期格式错误，请修改！");
                            } else{
                                errorTextEle.text(attrs.name+"起期格式输入错误，请修改！");
                            }
                            element.attr("invalid_Date",true); // invalid_Date当格式正确时将此值设置为false
                        } else if(data.minDate === false && attrs.value=='4'){
                            ctrl.$setValidity("validDate", false);
                            errorTextEle.text(attrs.name+'的结束日期不能小于'+attrs.name+'的开始日期!')
                        }else if  ( data.maxDate === false&& attrs.value=='3' ) { // 当日期 大于最大日期时
                            ctrl.$setValidity("validDate", false);
                            errorTextEle.text(attrs.name+'的开始日期不能大于'+attrs.name+'的结束日期！')
                        } else if (data.minDate === false ) {  // 当日期 小于最小日期时
                            ctrl.$setValidity("validDate", false);
                            errorTextEle.text(attrs.name+'止期不能小于'+attrs.name+'起期!')
                        } else if ( data.maxDate === false ) { // 当日期 大于最大日期时
                            ctrl.$setValidity("validDate", false);
                            errorTextEle.text(attrs.name+'起期不能大于'+attrs.name+'止期！')
                        }
                        validation(changeCallBack, scope);
                        validation(_changeCallBack, scope);
                        return  data.date
                    };
                    ctrl.$parsers.push(customValidator);
                    // ctrl.$render = function () {
                    //     // if(scope.ngModel) {
                    //     //     element.html(scope.ngModel)
                    //     // }
                    //     console.log("我就想问问我执行了没")
                    // };
                    // element.on('change',function(){
                    //     // scope.$parent.infoToView.jedateChange = true;
                    // });
                    $timeout(function(){
                        $(options.dateCell).jeDate(options);
                    },1);
                    scope.$on('$destroy',function () {
                        element.off();
                    })
                }
            }
        }]);

});