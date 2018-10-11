/**
 * DESC       : 国元农险理赔工作台---调度任务处理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app,constants,layer) {
    'use strict';
    app.registerController('dashboardDiapatchCtrl', ['$rootScope', '$scope','$$finder',
        function ($rootScope, $scope, $$finder){
            $$finder.post("dispatchList",{}).then(
                function (data) {
                    $scope.dispatchList = data;
                }
            )



        }]);
});