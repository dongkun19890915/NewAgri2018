/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('message',
        ['$rootScope', '$scope', '$http', '$anchorScroll', '$location', '$$cherry', '$$finder', '$stateParams',
            function ($rootScope, $scope, $http, $anchorScroll, $location, $$cherry, $$finder, $stateParams) {
                console.log($stateParams.message);
                $scope.message = $stateParams.message;
            }]);
})