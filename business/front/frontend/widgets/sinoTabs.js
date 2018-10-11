/**
 * The angular tabs module
 * @author: nerv
 * @version: 0.2.5, 2012-08-25
 */
define(['angular'], function(angular) {
    'use strict';

    angular.module( 'sino.tabs', [])
        .directive( 'sinoTabs', function() {
            return {
                scope: true,
                restrict: 'EAC',
                controller: function( $scope ) {
                    $scope.tabs = {
                        index: 0,
                        count: 0
                    };

                    this.headIndex = 0;
                    this.bodyIndex = 0;

                    this.getTabHeadIndex = function() {
                        console.log("getTabHeadIndex="+$scope.tabs.count);
                        return $scope.tabs.count = ++this.headIndex;
                    };

                    this.getTabBodyIndex = function() {
                        console.log("getTabBodyIndex="+this.bodyIndex);
                        return ++this.bodyIndex;
                    };
                }
            };
        })
        .directive( 'sinoTabHead', function() {
            return {
                scope: false,
                restrict: 'EAC',
                require: '^sinoTabs',
                link: function( scope, element, attributes, controller ) {
                    var index = controller.getTabHeadIndex();
                    var value = attributes.sinoTabHead;
                    var active = /[-*\/%^=!<>&|]/.test( value ) ? scope.$eval( value ) : !!value;

                    scope.tabs.index = scope.tabs.index || ( active ? index : null );

                    element.bind( 'click', function() {
                        console.log("click head");
                        scope.tabs.index = index;
                        scope.$$phase || scope.$apply();
                    });

                    scope.$watch( 'tabs.index', function() {
                        element.toggleClass( 'active', scope.tabs.index === index );
                    });
                }
            };
        })
        .directive( 'sinoTabBody', function() {
            return {
                scope: false,
                restrict: 'EAC',
                require: '^sinoTabs',
                link: function( scope, element, attributes, controller ) {
                    var index = controller.getTabBodyIndex();

                    scope.$watch( 'tabs.index', function() {
                        console.log(" head is clicked");
                        element.toggleClass( attributes.sinoTabBody + ' ng-show', scope.tabs.index === index );
                    });
                }
            };
        });

    });