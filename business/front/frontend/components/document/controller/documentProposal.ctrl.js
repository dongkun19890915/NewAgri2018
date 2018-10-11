/**
documentEndorse.ctrl.js * Created by zhoujianlong on 2016/9/28.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var documentProposalCtrl = function($scope,$state,$filter,documentProposalServ,FormFocus){
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
        var checkSearchCondition=function(){
            var cod=$scope.EpolicyQueryConditionDto;
            if((!cod)||!(cod.policyNo||cod.applyName||cod.startDateBegin||cod.startDateEnd||cod.operatorCode||cod.handler1Code))
            {

                angular.alert("请输入至少一项搜索条件!");
                return false;

            }
            // var d1=parseDate(cod.startDateBegin);
            // var d2=parseDate(cod.startDateEnd);

            if(cod.startDateBegin == undefined ||cod.startDateEnd == undefined ){
                cod.startDateBegin = '';
                cod.startDateEnd = '';
            }
            var beginTime=cod.startDateBegin.replace(/\-/g,"/");
            var endTime=cod.startDateEnd.replace(/\-/g,"/");
            var d1=new Date(beginTime);
            var d2=new Date(endTime);

            if(cod.startDateBegin&&!d1){
                angular.alert("保单生效日（开始）不是有效的日期，请重新录入！");
                return false;
            }
            if(cod.startDateEnd&&!d2){
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
                    angular.alert("保单生效日（结束）不能晚于保单生效日（开始）之后6个月!");
                    return false;
                }
            }



            return true;
        };

        /*保险起期监听*/
        $scope.$watch("EpolicyQueryConditionDto.startDateBegin",function(){
            if(!$scope.EpolicyQueryConditionDto.startDateBegin){
                $scope.EpolicyQueryConditionDto.startDateEnd = '';
            }else{
                //生效日期改变，止期自动加1年
                var startdate = $scope.EpolicyQueryConditionDto.startDateBegin;
                var startDate = new Date(startdate);
                var ensDate = new Date(startDate);
                ensDate.setMonth(ensDate.getMonth()+6);
                //ensDate.setDate(ensDate.getDate()-1);
                $scope.EpolicyQueryConditionDto.startDateEnd =  $filter("date")(ensDate, "yyyy-MM-dd");
            }
        });

        //$scope.insuredOnlyOneLayer = true;
        $scope.dowloadFile=function(policyNo,  idType){
            var data = {};
            data.certiNo = policyNo;
            data.idType = idType;
            documentProposalServ.getFileId(data).then(
                function(answer){
                    var shortLinkId = answer.data.shortLinkId;
                    if(shortLinkId){
                        documentProposalServ.downloadFile(shortLinkId);
                    }else{
                        angular.alert("正在生成电子保单，请稍后再试");
                    }
                        
                },function(error){
                    //$scope.insuredOnlyOneLayer = false;
                }
            );
        };
        /*电子保单查询*/
        $scope.documentQuery = function(){
            searchFlalg = true;
            getDocumentProposalList();
        };
        /*重置*/
        $scope.resetForm = function(){
            $scope.EpolicyQueryConditionDto={}
        };
        /*退出首页*/
        $scope.editClick = function(){
            $state.go("main.index")
        };

        /*分页调用fun*/
        var getDocumentProposalList = function(){
            if(!searchFlalg){
                return;
            }
            if(!$scope.documentProposalForm.$valid){
                FormFocus.focusEle("documentProposalForm");
                return;
            }
            if(!checkSearchCondition())
            {
                return;
            }

            $scope.EpolicyQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.EpolicyQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            var EpolicyQueryConditionDto = $scope.EpolicyQueryConditionDto;
            documentProposalServ.documentSearch(EpolicyQueryConditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.documentData=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        //初始化界面
        var initFunc = function(){
            $scope.EpolicyQueryConditionDto={};

            //电子保单默认值
            var now=new Date();
            $scope.EpolicyQueryConditionDto.startDateEnd=formatDate(now,'yyyy-MM-dd');
            now.setMonth(now.getMonth()-6);
            $scope.EpolicyQueryConditionDto.startDateBegin=formatDate(now,'yyyy-MM-dd');

            //电子保单分页
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 10,   //每页展示的数据条数
                pagesLength: 10,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20,30,40,50]   // 可选择显示条数的数组
            };
            $scope.proposalInfoDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};

            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getDocumentProposalList)

        };
        initFunc();


        $scope.sendToEmail=function(d){
            $scope.NoticePrpinsConditionDto={
                policyNo: d.policyNo,
                noticeCode:"policyemail",
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
            //this.emailForm.$setPristine();
            $("[name=proposalEmailForm] .ng-invalid:not(ng-form)").removeClass("ng-dirty");
            $(".validation-errorText").css('display','none');
        };
        //发送邮件弹层关闭方法
        $scope.receiptOpenShow = function(){
            $scope.onDocumentEmailLayer = false;
        };
        $scope.publicConfirmPass = function(){
            $scope.sendEmail();
        };

        $scope.onSubmits=function(){
            if(!this.proposalEmailForm.$valid){
                FormFocus.focusEle("proposalEmailForm");
                return;
            }
            // 检验是否有附件
            var NoticePrpinsConditionDto=$scope.NoticePrpinsConditionDto;
            var data = {};
            var shortLinkId;
            data.certiNo = NoticePrpinsConditionDto.policyNo;
            data.idType = NoticePrpinsConditionDto.idType;
            documentProposalServ.getFileId(data).then(
                function(answer){
                    var shortLinkId = answer.data.shortLinkId;
                    if (!shortLinkId) {
                        angular.alert("正在生成电子保单，请稍后再试");
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
            documentProposalServ.sendToEmail(NoticePrpinsConditionDto).then(
                function(answer){
                    angular.alert("发送成功");
                    $scope.receiptOpenClose();
                    $scope.NoticePrpinsConditionDto = {};
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
    };

    moduleApp.controller('documentProposalCtrl',['$scope','$state','$filter','documentProposalServ','FormFocus',documentProposalCtrl]);
});
