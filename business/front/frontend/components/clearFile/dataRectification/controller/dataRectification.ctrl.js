/**
 * 
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var dataRectificationCtrl = function($scope,$timeout,$filter,$state,dataRectificationServ,FormFocus) {
        $scope.liError=false;
        $scope.canClick=false;
        /*监听日期变化，不符合条件清空*/
        $scope.$watch('clearDate',function(){
            if($scope.clearDate !="" && $scope.clearDate !=undefined){
                var chooseTime=$scope.clearDate.replace(/\-/g,"/");
                var a1=new Date(chooseTime).getTime();
                var a2=new Date().getTime();
                if(a1>a2){
                    $scope.clearDate="";
                }
            }
        });
        //日期校验
        var today=new Date();
        $scope.maxDate = $filter('date')(today, 'yyyy-MM-dd');
        $scope.dataRectificationClick=function(){
            //校验日期是否输入
            if($scope.dataRectificationForm.$valid){
                //console.log('通过验证可以提交表单');
            }else{
                FormFocus.focusEle("dataRectificationForm");
                return;
            }
            //保单号数据校验
            if($scope.policyAll){
                 var policyNoList=null;
            }else{
                 var policyNoList=$scope.policyNoList+" ";
                 policyNoList=policyNoList.replace(/\s/ig,'');
                if(policyNoList=="undefined" || policyNoList == ""){
                    policyNoList=null;
                }else{
                    var policyArray = policyNoList.split(/[，,]/);
                    for(var i=0;i<policyArray.length;i++){
                        if(policyArray[i].length<16 || policyArray[i].length>26){
                            angular.alert("保单号"+policyArray[i]+"存在异常，请检查！");
                            return;
                        }
                    }
                 }   
            }
            //批单号数据校验
            if($scope.endorseAll){
                 var endorseNoList=null;
            }else{
                var endorseNoList=$scope.endorseNoList+" ";
                endorseNoList=endorseNoList.replace(/\s/ig,'');
                if(endorseNoList == "undefined" || endorseNoList == ""){
                    endorseNoList=null;
                }else{
                    var endorseArray = endorseNoList.split(/[，,]/);
                    for(var i=0;i<endorseArray.length;i++){
                        if(endorseArray[i].length<16 || endorseArray[i].length>26){
                            angular.alert("批单号"+endorseArray[i]+"存在异常，请检查！");
                            return;
                        }
                    }
                }
             }   
            //理赔报案号数据校验
            if($scope.claimsAll){
                 var claimsNum=null;
            }else{
                var claimsNum=$scope.claimsNum+" ";
                 claimsNum=claimsNum.replace(/\s/ig,'');
                if(claimsNum == "undefined" || claimsNum == ""){
                    claimsNum=null;
                }else{
                    var claimsArray = claimsNum.split(/[，,]/);
                    for(var i=0;i<claimsArray.length;i++){
                        if(claimsArray[i].length<16 || claimsArray[i].length>26){
                            angular.alert("理赔报案号"+claimsArray[i]+"存在异常，请检查！");
                            return;
                        }
                    }
                 }   
            }
            var policyAll;
            var endorseAll;
            var claimsAll;
            if( $scope.policyAll == undefined || $scope.policyAll == false)  {
                     policyAll=0;
            }else{
                    policyAll=1;
             }
             if( $scope.endorseAll == undefined || $scope.endorseAll  == false)  {
                     endorseAll=0;
            }else{
                     endorseAll=1;
             }
             if( $scope.claimsAll == undefined || $scope.claimsAll == false)  {
                     claimsAll=0;
            }else{
                     claimsAll=1;
             }
             var conditionDto={};
             conditionDto.clearDate=$scope.clearDate;
             conditionDto.policyNoList=policyNoList;
             conditionDto.endorseNoList=endorseNoList;
             conditionDto.registNoList=claimsNum;
             conditionDto.policyFlag=policyAll;
             conditionDto.endorseFlag=endorseAll;
             conditionDto.claimFlag=claimsAll;
             dataRectificationServ.dataCheck(conditionDto).then(
                function(answer){
                    var responseData=answer.data;
                    if(responseData==null || responseData.length==0){
                        var conditionDto1={};
                        conditionDto1.clearDate=$scope.clearDate;
                        conditionDto1.policyNoList=policyNoList;
                        conditionDto1.endorseNoList=endorseNoList;
                        conditionDto1.registNoList=claimsNum;
                        conditionDto1.policyFlag=policyAll;
                        conditionDto1.endorseFlag=endorseAll;
                        conditionDto1.claimFlag=claimsAll;
                        dataRectificationServ.dataPost(conditionDto1);
                        angular.alert("异常处理已启动，完成后会上传到sftp，并生成OK.txt文件。可关闭此信息，进行其他操作。");
                        $scope.successTipLayer=false;
                        $scope.liError=false;
                        //$state.reload("main.dataRectification");
                        $scope.canClick=true;
                        $timeout(function(){
                            $scope.canClick=false;
                        },60000)

                    }else{
                        $scope.liError=true;
                        angular.alert("存在错误单号，请查看错误单号文本框！");
                        $scope.errorInfo=responseData;
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
    };
    moduleApp.controller('dataRectificationCtrl',['$scope','$timeout','$filter','$state','dataRectificationServ','FormFocus',dataRectificationCtrl]);
});
