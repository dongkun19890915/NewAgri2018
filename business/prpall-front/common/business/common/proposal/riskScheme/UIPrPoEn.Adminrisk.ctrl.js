
define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnAdminRiskCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state','$timeout',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,$timeout) {
        //查询所有险种
            $$finder.find('queryAllClass',{
            },{
                success: function (data) {
                    console.log(11111)
                    console.log(data)
                    $scope.prpDclassList=data.content
                },
                error: function (e) {
                }
            });
            //险种方案弹层 编辑类型
           // $scope.place=[
           //     {
           //         "value":"2",
           //         "name":"请输入投保单号"
           //     },
           //     {
           //         "value":"3",
           //         "name":"请输入保单号"
           //     },
           //     {
           //         "value":"4",
           //         "name":"请输入保单号"
           //     },
           // ],
            $scope.showInp=false;
            $scope.selectedChange = function (value) {
                if(value=='NEW'){
                    $scope.showInp=false;
                }else if(value===null) {
                    $scope.showInp=false;
                }else {
                    $scope.showInp=true;
                }
            }
            //  请求数据
            //$$finder.find('riskScheme',{}, {
            //    success: function (data) {
            //        //console.log(data)
            //        //编辑类型
            //        //$scope.editType=data.data.editType;
            //        //险类
            //        //$scope.classCode=data.data.classCode;
            //        //险种
            //        //$scope.riskCode=data.data.riskCode;
            //        //条款
            //        $scope.clause=data.data.clause;
            //    },
            //    error: function (e) {
            //        options.error(e);
            //    }
            //});

            //  投保单模版页面险种方案弹层的隐藏与显示
            $scope.$on("openAdminRiskLayer",function (event) {
                $scope.showAdminRisk=true;
            })
            //确定按钮
            $scope.yesRiskScheme=function(){
                $scope.showAdminRisk=false;

            }
            // 重置按钮
            $scope.resetRiskScheme=function(){
                $scope.proposal.editType='';
                $scope.proposal.prpTmainDto=''
            }
            //根据条款获取政策/商业标志
            $scope.getBusinessType1=function(){
                if (!$scope.proposal.prpTmainDto.code){
                    $$finder.find('queryByPkAndTranslate',{
                        clauseCode:$scope.proposal.prpTmainDto.code//条款代码
                    },{
                        success:function (data){
                            if(data=="0000"){
                                $scope.proposal.prpTmainDto.businessType1=data.content.message;
                            }

                        },
                        error: function (e) {
                        }
                    });
                }

            }
            //$scope.getComCode=function(){
            //    var changeinit = $scope.changeinit();
            //}
            //获取险种
            $scope.$watch('proposal.prpTmainDto.classCode',function(newvalue){
                if(newvalue){
                    $$finder.find('riskCode',{
                        classCode:newvalue,//险类
                    }, {
                        success: function (data) {
                            $scope.riskCodeList=data.content;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    })
                }
            })

        }]);
});