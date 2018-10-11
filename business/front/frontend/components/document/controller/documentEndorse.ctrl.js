/**
documentEndorse.ctrl.js * Created by zhoujianlong on 2016/9/28.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var documentEndorseCtrl = function($scope,$state,$filter,documentEndorseServ,FormFocus) {
        /*查询被保人清单*/
        var searchFlalg=false;
        var formatDate=function(now,mask)
        {
            var d = now;
            var zeroize = function (value, length)
            {
                if (!length) length = 2;
                value = String(value);
                for (var i = 0, zeros = ''; i < (length - value.length); i++)
                {
                    zeros += '0';
                }
                return zeros + value;
            };

            return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
            {
                switch ($0)
                {
                    case 'd': return d.getDate();
                    case 'dd': return zeroize(d.getDate());
                    case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
                    case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
                    case 'M': return d.getMonth() + 1;
                    case 'MM': return zeroize(d.getMonth() + 1);
                    case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
                    case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
                    case 'yy': return String(d.getFullYear()).substr(2);
                    case 'yyyy': return d.getFullYear();
                    case 'h': return d.getHours() % 12 || 12;
                    case 'hh': return zeroize(d.getHours() % 12 || 12);
                    case 'H': return d.getHours();
                    case 'HH': return zeroize(d.getHours());
                    case 'm': return d.getMinutes();
                    case 'mm': return zeroize(d.getMinutes());
                    case 's': return d.getSeconds();
                    case 'ss': return zeroize(d.getSeconds());
                    case 'l': return zeroize(d.getMilliseconds(), 3);
                    case 'L': var m = d.getMilliseconds();
                        if (m > 99) m = Math.round(m / 10);
                        return zeroize(m);
                    case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
                    case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
                    case 'Z': return d.toUTCString().match(/[A-Z]+$/);
                    // Return quoted strings with the surrounding quotes removed
                    default: return $0.substr(1, $0.length - 2)
                }
            })
        };
        var parseDate=function(str){
            if(typeof str == 'string'){
                var results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) *$/);
                if(results && results.length>3)
                    return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]));
                results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2}) *$/);
                if(results && results.length>6)
                    return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]));
                results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2})\.(\d{1,9}) *$/);
                if(results && results.length>7)
                    return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]),parseInt(results[7]));
            }
            return null;
        };
        var convertTimestampToDateStr=function(timestamp){
            var d=new Date().setTime(timestamp);
            return formatDate(d,'yyyy-MM-dd');
        };
        var checkSearchCondition2=function(){
            var cod=$scope.EendorseQueryConditionDto;
            if((!cod)||!(cod.policyNo||cod.endorseNo||cod.applyName||cod.validDateEnd||cod.operatorCode||cod.validDateBegin))
            {

                angular.alert("请输入至少一项搜索条件!");
                return false;

            }
            //var d1=parseDate(cod.validDateBegin);
           // var d2=parseDate(cod.validDateEnd);

            if(cod.validDateBegin == undefined || cod.validDateEnd == undefined ){
                cod.validDateBegin = '';
                cod.validDateEnd = '';
            }
            
            var beginTime=cod.validDateBegin.replace(/\-/g,"/");
            var endTime=cod.validDateEnd.replace(/\-/g,"/");
            var d1=new Date(beginTime);
            var d2=new Date(endTime);

            if(cod.validDateStart&&!d1){
                angular.alert("保单生效日（开始）不是有效的日期，请重新录入！");
                return false;
            }
            if(cod.validDateEnd&&!d2){
                angular.alert("保单生效日（结束）不是有效的日期，请重新录入！");
                return false;
            }
            if(d1&&d2){
                if(d1.getTime()>d2.getTime()){
                    angular.alert("日期开始时间不能大于结束时间！");
                    return false;
                }
            }
            if(d1.getTime()&&d2.getTime()){
                d1.setMonth(d1.getMonth()+6);
                if(d2>d1)
                {
                    angular.alert("批单生效日（结束）不能晚于保单生效日（开始）之后6个月!");
                    return false;
                }
            }
            return true;
        };

            
        //$scope.insuredOnlyOneLayer = true;
        $scope.dowloadFile=function(applyNo,  idType){
            var data = {};
            data.certiNo = applyNo;
            data.idType = idType;
            documentEndorseServ.getFileId(data).then(
                function(answer){
                    var shortLinkId = answer.data.shortLinkId;
                    if(shortLinkId){
                        documentEndorseServ.downloadFile(shortLinkId);
                    }else{
                        angular.alert("正在生成电子批单，请稍后再试");
                    }

                },function(error){
                    //$scope.insuredOnlyOneLayer = false;
                }
            );
        };


        var getDocumentEndorseList = function(){
            if(!searchFlalg){
                return;
            }
            if(!checkSearchCondition2())
            {
                return;
            }
            if(!$scope.documentEndorseForm.$valid){
                FormFocus.focusEle("documentEndorseForm");
                return;
            }


            $scope.EendorseQueryConditionDto.pageNo=$scope.paginationConf2.currentPage;
            $scope.EendorseQueryConditionDto.pageSize=$scope.paginationConf2.itemsPerPage;
            var EendorseQueryConditionDto = $scope.EendorseQueryConditionDto;
            documentEndorseServ.documentEndorseSearch(EendorseQueryConditionDto).then(
                function(answer){
                    $scope.paginationConf2.totalItems = answer.data.totalCount;
                    $scope.documentEndorseData=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        //初始化界面
        var initFunc = function(){
            //电子批单默认值
            $scope.EendorseQueryConditionDto={};

            //电子保单默认值
            var now=new Date();
            $scope.EendorseQueryConditionDto.validDateEnd=formatDate(now,'yyyy-MM-dd');
            now.setMonth(now.getMonth()-6);
            $scope.EendorseQueryConditionDto.validDateBegin=formatDate(now,'yyyy-MM-dd');

            //电子批单分页
            $scope.paginationConf2 = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 10,   //每页展示的数据条数
                pagesLength: 10,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20,30,40,50]   // 可选择显示条数的数组
            };
            $scope.proposalInfoDto = {pageNo:$scope.paginationConf2.currentPage,
                pageSize:$scope.paginationConf2.itemsPerPage};

            $scope.$watch('paginationConf2.currentPage + paginationConf2.itemsPerPage', getDocumentEndorseList);
        };

        initFunc();
        /*电子批单查询*/
        $scope.documentEndorseQuery = function(){
            searchFlalg = true;
            getDocumentEndorseList();
        };
        $scope.reseteEndorseForm = function(){
            $scope.EendorseQueryConditionDto={}
        };
        /*退出首页*/
        $scope.editClick = function(){
            $state.go("main.index")
        };
        $scope.sendToEmail=function(d){
            $scope.NoticePrpinsConditionDto={
                applyNo: d.applyNo,
                noticeCode:"endoremail",
                noticeType:"2"
            };
            $scope.bdradio1=true;
            $scope.bdradio2=true;
            $scope.receiptOpenShow();
        };
        $scope.bdradioClick1=function(){
            $scope.bdradio1=true;
            $scope.bdradio2=true;
            $scope.NoticePrpinsConditionDto.idType="sign"
        };
        $scope.bdradioClick2=function(){
            $scope.bdradio1=false;
            $scope.bdradio2=false;
            $scope.NoticePrpinsConditionDto.idType="noSign"
        };
        $scope.onDocumentEmailLayer = true;
        //发送邮件弹层关闭方法
        $scope.receiptOpenClose = function(){
            $scope.onDocumentEmailLayer = true;
            //this.NoticePrpinsConditionDto = {};
            $("[name=endorseEmailForm] .ng-invalid:not(ng-form)").removeClass("ng-dirty");
            $(".validation-errorText").css('display','none');
        };
        //发送邮件弹层关闭方法
        $scope.receiptOpenShow = function(){
            $scope.onDocumentEmailLayer = false;
        };

        /*保险起期监听*/
        $scope.$watch("EendorseQueryConditionDto.validDateBegin",function(){
            if(!$scope.EendorseQueryConditionDto.validDateBegin){
                $scope.EendorseQueryConditionDto.validDateEnd = '';
            }else{
                //生效日期改变，止期自动加1年
                var startdate = $scope.EendorseQueryConditionDto.validDateBegin;
                var startDate = new Date(startdate);
                var ensDate = new Date(startDate);
                ensDate.setMonth(ensDate.getMonth()+6);
                //ensDate.setDate(ensDate.getDate()-1);
                $scope.EendorseQueryConditionDto.validDateEnd=  $filter("date")(ensDate, "yyyy-MM-dd");
            }
        });

        $scope.onSubmits=function(){
            if(!this.endorseEmailForm.$valid){
                FormFocus.focusEle("endorseEmailForm");
                return;
            }
            // 检验是否有附件
            var NoticePrpinsConditionDto=$scope.NoticePrpinsConditionDto;
            var data = {};
            var shortLinkId;
            data.certiNo = NoticePrpinsConditionDto.applyNo;
            data.idType = NoticePrpinsConditionDto.idType;
            documentEndorseServ.getFileId(data).then(
                function(answer){
                    var shortLinkId = answer.data.shortLinkId;
                    if (!shortLinkId) {
                        angular.alert("正在生成电子批单，请稍后再试");
                    } else {
                        $scope.sendEmail();
                    }
                },function(error){
                }
            );
        };
        $scope.sendEmail = function(){
            var NoticePrpinsConditionDto=$scope.NoticePrpinsConditionDto;
            NoticePrpinsConditionDto.certiType="";
            documentEndorseServ.sendToEmail(NoticePrpinsConditionDto).then(
                function(answer){
                    angular.alert("发送成功");
                    $scope.receiptOpenClose();
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

    };

    moduleApp.controller('documentEndorseCtrl',['$scope','$state','$filter','documentEndorseServ','FormFocus',documentEndorseCtrl]);
});
