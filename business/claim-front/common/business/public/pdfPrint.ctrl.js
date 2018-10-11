/**
 * DESC       : 国元农险理赔打印页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017/12/23
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define(['app','config'], function (app, config) {

    app.registerController('pdfPrintCtrl', ['$rootScope', '$scope', '$compile', '$location', '$$code', '$stateParams','$window',
        function ($rootScope, $scope, $compile, $location, $$code, $stateParams,$window) {
            console.log(JSON.parse($stateParams.data)[0].flag);
            $scope.flag=JSON.parse($stateParams.data)[0].flag;

            var dataList;
            var url;
            if($stateParams.data){
                var switchURl = function () {
                    console.log($location)
                    url=$location.$$protocol + "://" + $location.$$host +":"+ $location.$$port + config.backend.ip;
                    angular.forEach(dataList, function (item) {
                        if(item.codecname == $scope.curNo.curType){
                            if( item.url.indexOf("compensateNo")>0){
                                url += item.url+$scope.curNo.compensateNo
                            } else if( item.url.indexOf("claimNo")>0){
                                url += item.url+$scope.curNo.claimNo
                            } else if( item.url.indexOf("registNo")>0){
                                url += item.url+$scope.curNo.registNo
                            } else {
                                url += item.url
                            }

                        }
                    });
                };
                $scope.printList = JSON.parse($stateParams.data);
                $$code.getCodes("code-type","printType").then(function (data) {
                    dataList = data
                    angular.forEach($scope.printList, function (item) {
                            for (var i=0;i<item.allowedPrintType.length; i++){
                                for(var j = 0; j<data.length; j++){
                                    if(item.allowedPrintType[i]===data[j].id){
                                        item.allowedPrintType[i] = data[j].codecname;
                                        break
                                    }

                                }

                            }
                        }
                    );
                    // /api/agriclaim/print/siteSurveyPrintprint/endCasePrint?claimNo=505063400002009000022
                    $scope.curNo = $scope.printList[0];
                    angular.forEach($scope.printList, function (item) {
                        item.curType = item.allowedPrintType[0];
                    });
                    switchURl();
                    //classid="clsid:CA8A9780-280D-11CF-A24D-444553540000"
                    var pdfDom = '<object id="PDFViewObject"  name="DFG" type="application/pdf" width="100%" height="500" data="' + url + '">' +
                        '<div id="PDFNotKnown">你需要先安装pdf阅读器(Acrobat Reader)才能正常浏览文件，请点击<a href="https://get.adobe.com/cn/reader/" target="_blank">这里</a>下载.</div>' +
                        '</object>';
                    var ele = $compile(pdfDom)($scope);
                    $('#PDFBODY').append(ele);

                });  // 打印类型数据

                // 号切换
                $scope.checkNoTab = function (item) {
                    $scope.curNo = item;
                    $scope.curNo.curType= $scope.curNo.curType || $scope.curNo.allowedPrintType[0]
                    switchURl();
                    $('#PDFViewObject').attr("data",url )

                };

                // 打印类型切换
                $scope.checkPrintTab = function (type) {
                    $scope.curNo.curType = type;
                    switchURl();
                    $('#PDFViewObject').attr("data",url )

                };
                // 删除单号
                $scope.delPolicyNo = function (index, event) {
                    if($scope.printList.length===1){
                        layerMsg("至少有一条");
                        return
                    }
                    if ($scope.curNo == $scope.printList[index]){ // 删除当前项
                        $scope.printList.splice(index,1);
                        $scope.curNo = $scope.printList[0];
                        switchURl();
                        $('#PDFViewObject').attr("data",url )
                    }
                };

                // 删除打印类型
                $scope.delPrintType = function (index) {
                    if($scope.curNo.allowedPrintType.length === 1){ // 如果删除最后一项 将当前号码删除
                        $scope.curNo
                        angular.forEach($scope.printList, function (item, index) {
                            if ($scope.curNo == item) { // 删除当前项
                                delPolicyNo(index)
                            }
                        })
                    }

                    if($scope.curNo.allowedPrintType[index] === $scope.curNo.curType){// 删除当前type 回调至第一条type
                        $scope.curNo.curType = $scope.curNo.allowedPrintType[0];
                    }
                    $scope.curNo.allowedPrintType.splice(index,1);
                    switchURl();
                    $('#PDFViewObject').attr("data", url)

                };
                $scope.subPrint = function () {
                    var path = $location.$$protocol + "://" + $location.$$host +":"+ $location.$$port + config.backend.ip + 'agriclaim/print/multipleMorePrint?';


                    angular.forEach($scope.printList, function (item, index) {
                        path += "compensateNos=" + item.compensateNo;
                        path += "&claimNos="+ item.claimNo;

                        // 把汉字转成code
                        var ary = [];
                        angular.forEach(item.allowedPrintType,function (ty) {
                            angular.forEach(dataList, function (obj) {
                                if(obj.codecname === ty){
                                    ary.push(obj.codecode)
                                }
                            });
                        });
                        // 把汉字转成code

                        path += "&printTypes="+ ary.join("_");
                        if(index!== $scope.printList.length-1){
                            path +="&"
                        }
                    });
                    // DFG.printWithDialog()
                    // window.print(path)
                    $window.open(path)
                }
                // 下载插件；批量打印跳转另一个页面在进行点击打印按钮 兼容好
                // pdf,objectPDf；基于html5 不兼容ie8 解析速度较慢；控制性强
                // 页面放到前端 ；控制性强 兼容好
            }
        }])
});