/**
 * DESC       : 国元农险理赔流程查询 查看页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              zhaowenjie     2017.12.7    流程查询 查看页面控制器
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriFlowSeeCtrl', ['$rootScope', '$scope', '$location', '$$finder', 'regexpConstants', '$stateParams','$state','$filter',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $stateParams,$state,$filter) {
            $("html,body").css({overflow:"auto"});
        var registNo = {
                "registNo": $stateParams.registNo
            };
            $scope.goPrpLMessageShow=function(){
                $$finder.post("queryPrpLMessageByRegistNo", registNo).then(
                    function (data) {
                        //时间初始化
                        angular.forEach(data, function(obj){
                            obj.inputDate=$filter("date")(obj.inputDate, "yyyy-MM-dd");
                        });
                        $scope.prpLMessageList=data;
                        $scope.queryPrpLMessage=true;
                    })
            }
            debugger;
            if($rootScope.systemFlag=='claim' || $rootScope.systemFlag=='undwrt'){
                $scope.flowseeflag=true;
            }
            $$finder.post("querySwfLogAndSwfLogStoreByConditions", registNo).then(
                function (data) {
                    // var data = data.content[0]
                    console.log(data);
                    $scope.flowTreeList = data;
                    $scope.pathLogList = data.swfPathLogList;
                    $scope.swfLogDtoTreeList = data.swfLogDtoTreeList;
                    // $scope.flowTreeList = data.content;
                    // $scope.pathLogList = data.content[0].swfPathLogList;
                    // $scope.swfLogDtoTreeList = data.content[0].swfLogDtoTreeList;
                    var cur = null; // 当前状态
                    var pathList = []; // 组装后的关系数据数组
                    var nodeLogList = []; // 组装后的每条关系数据
                    // console.log(pathList);
                    for (var i = 0; i < $scope.pathLogList.length; i++) {
                        for (var j = 0; j < $scope.swfLogDtoTreeList.length; j++) { // 将数据塞进对应的节点
                            if ($scope.pathLogList[i].startNodeNo === $scope.swfLogDtoTreeList[j].logNo) {
                                if (!angular.isArray($scope.swfLogDtoTreeList[j].conext)) {
                                    $scope.swfLogDtoTreeList[j].conext = [];
                                }
                                $scope.swfLogDtoTreeList[j].conext.push($scope.pathLogList[i]);
                            }
                        }
                    }
                    console.log($scope.swfLogDtoTreeList)
                    var X = null;
                    var treeList = [];
                    var treeNodeList = [];
                    for (var m = 0; m < $scope.swfLogDtoTreeList.length; m++) {
                        /******** new ********/
                        $scope.swfLogDtoTreeList[m].x1=$scope.swfLogDtoTreeList[m].nodePosLayer*249-173;
                        $scope.swfLogDtoTreeList[m].y1=$scope.swfLogDtoTreeList[m].treeLayer*137-58;
                        $scope.swfLogDtoTreeList[m].y2=$scope.swfLogDtoTreeList[m].treeLayer*137-140;
                        $scope.swfLogDtoTreeList[m].x3=$scope.swfLogDtoTreeList[m].nodePosLayer*249-95;
                        $scope.swfLogDtoTreeList[m].y3=$scope.swfLogDtoTreeList[m].treeLayer*137-97;
                        $scope.swfLogDtoTreeList[m].x4=$scope.swfLogDtoTreeList[m].nodePosLayer*249-250;
                        /******** new ********/
                        if (X === null) {
                            X = $scope.swfLogDtoTreeList[m].treeLayer;
                        }
                        if (X === $scope.swfLogDtoTreeList[m].treeLayer) {
                            treeNodeList.push($scope.swfLogDtoTreeList[m]);
                        } else {
                            X = $scope.swfLogDtoTreeList[m].treeLayer;
                            treeList.push(treeNodeList);
                            treeNodeList = [];
                            treeNodeList.push($scope.swfLogDtoTreeList[m]);
                        }
                        if (m === $scope.swfLogDtoTreeList.length - 1) {
                            treeList.push(treeNodeList);
                        }
                    }

                    // console.log(treeList);
                    var checkConext = function (start, end, conext) {
                        for (var p = 0; p < conext.length; p++) {
                            if (!end) {
                                debugger
                            }
                            if (conext[p].startNodeNo === start.logNo && conext[p].endNodeNo === end.logNo) {
                                return true
                            }
                        }
                        return false
                    };


                    /***************** new start ******************/
                    function svgPath() {
                        var paper = F("items");
                        var x1,y1,x2,y2;
                        var radFun = function (deg) {
                            return deg % 360 * Math.PI / 180;
                        };
                        var treeLengthList = [];
                        for (var n = 0; n < treeList.length; n++) {  // 节点树所在的层
                            var treeChildList = treeList[n];
                            treeLengthList.push(treeChildList.length);
                            for (var k = 0; k < treeChildList.length; k++) { // 每层的节点
                                var conext = treeChildList[k].conext;
                                if (conext) {
                                    if (treeChildList[k].nodeNo) {
                                        if (k + 1 < treeChildList.length) { // 判断同层相邻下一个节点有无
                                            if (checkConext(treeChildList[k], treeChildList[k + 1], conext)) { //同层相邻节点关系比较
                                                x1=treeChildList[k].x3;
                                                y1=treeChildList[k].y3;
                                                x2=treeChildList[k+1].x4;
                                                y2=treeChildList[k+1].y3;
                                                var angle=(180 + Math.atan2(y2-y1, x2-x1) * 180 / Math.PI + 360) % 360;
                                                var a45 = radFun(angle - 45); //角度转换成弧度
                                                var a45m = radFun(angle + 45);
                                                var x2a = parseInt(x2 + Math.cos(a45) * 8);
                                                var y2a = parseInt(y2 + Math.sin(a45) * 8);
                                                var x2b = parseInt(x2 + Math.cos(a45m) * 8);
                                                var y2b = parseInt(y2 + Math.sin(a45m) * 8);
                                                var path = paper.Path('M'+x1+','+y1+'L'+x2+','+y2+'L'+x2a+','+y2a+'M'+x2+','+y2+'L'+x2b+','+y2b);
                                            }
                                        }
                                        for(var zz=0;zz<treeList.length-n;zz++){
                                            var nextTreeChildList = treeList[n + zz]; // 下一层
                                            if (nextTreeChildList) { // 判断有无下一层节点
                                                for (var m = 0; m < nextTreeChildList.length; m++) {
                                                    if (nextTreeChildList[m].nodeNo) {
                                                        if (checkConext(treeChildList[k], nextTreeChildList[m], conext)) {
                                                            x1=treeChildList[k].x1;
                                                            y1=treeChildList[k].y1;
                                                            x2=nextTreeChildList[m].x1;
                                                            y2=nextTreeChildList[m].y2;
                                                            var angle=(180 + Math.atan2(y2-y1, x2-x1) * 180 / Math.PI + 360) % 360;
                                                            var a45 = radFun(angle - 45); //角度转换成弧度
                                                            var a45m = radFun(angle + 45);
                                                            var x2a = parseInt(x2 + Math.cos(a45) * 8);
                                                            var y2a = parseInt(y2 + Math.sin(a45) * 8);
                                                            var x2b = parseInt(x2 + Math.cos(a45m) * 8);
                                                            var y2b = parseInt(y2 + Math.sin(a45m) * 8);
                                                            var path = paper.Path('M'+x1+','+y1+'L'+x2+','+y2+'L'+x2a+','+y2a+'M'+x2+','+y2+'L'+x2b+','+y2b);
                                                        }
                                                    }
                                                }
                                            }
                                        }


                                    }

                                }

                            }
                        }
                        treeLengthList.sort(sortNumber)
                        function sortNumber(a,b)
                        {
                            return a - b
                        }
                        var max = treeLengthList[treeLengthList.length-1];
                        $("#items").css('width',250*(max+1))
                    }
                    /************* new end *************/

                    function isEmptyObject(obj){
                        for(var name in obj){
                            return false;
                        }
                        return true;
                    }
                    function F (id) {
                        return new F.prototype.init(id);
                    }
                    F.fn = F.prototype = {
                        init : function(id){
                            this.c = document.getElementById(id);
                            this.r = this.initC();
                            return this;
                        },
                        version : '0.1',
                        _NS : 'http://www.w3.org/2000/svg',
                        _ISSVG : true,
                        _CNAME : 'fan'
                    }
                    F.fn.initC = function(){
                        if(document.createElementNS){
                            var r = document.createElementNS(this._NS,'svg');
                            r.setAttribute('vesion','1.1');
                            r.setAttribute('xmlns',this._NS);
                            r.setAttribute('style','width:100%;height:100%;');
                        }else{
                            var head = document.getElementsByTagName("head")[0];
                            var style = document.createElement("style");
                            var r = document.createElement("div");
                            this._ISSVG = false;
                            document.namespaces.add("v", "urn:schemas-microsoft-com:vml");//添加命名空间
                            var cssStr = '.fan {behavior:url(#default#VML);} v\:*{behavior:url(#default#VML);}';    //添加元素和vml的关系
                            style.type = 'text/css';
                            style.styleSheet.cssText = cssStr;
                            head.appendChild(style);//添加到head里面
                            r.setAttribute('style','position:absolute;width:100%;height:100%;left:0;top:0');
                        }
                        this.c.appendChild(r);
                        return r;
                    }
                    F.fn.Path = function(path){
                        return new E.prototype.initPath(this,path);
                    }
                    F.fn.init.prototype = F.fn;
                    function E(){}
                    E.fn = E.prototype = {
                        _VML : {'attr':{'stroke-width':'strokeweight','stroke':'strokecolor','opacity':'opacity','dashstyle':'dashstyle','joinstyle':'joinstyle','fill':'fillcolor','src':'src'}},
                        _SVG : {'attr':{'stroke-width':'stroke-width','stroke':'stroke','opacity':'fill-opacity','dashstyle':'stroke-dasharray','joinstyle':'stroke-linecap','fill':'fill','src':'href'}}
                    }
                    E.fn.svgFormatDashstyle = function (val) {
                        var strokew = this.dom.getAttribute('stroke-width');

                        switch (val) {
                            case 'Dash':
                                return strokew*4+','+strokew*5;
                                break;
                            case 'Dot':
                                return strokew*1+','+strokew*4;
                                break;
                            default:
                                return 'none';
                        }
                    }
                    E.fn.initAttr = function(el,attrs){
                        var attrs = attrs || {};
                        if(!this.F._ISSVG){
                            var stroke = document.createElement("stroke");
                            stroke.className = this.F._CNAME;
                            el.appendChild(stroke);
                            var fill = document.createElement("fill");
                            fill.className = this.F._CNAME;
                            el.appendChild(fill);
                            fill.setAttribute('opacity','0');
                        }else{
                            el.setAttribute('stroke','#000');//默认
                            el.setAttribute('fill','none');//默认 兼容vml
                        }
                        if(el.nodeName === 'path'){
                            el.setAttribute('stroke','#000');//默认
                            el.setAttribute('fill','none');//默认 兼容vml
                        }
                        return el;
                    }
                    E.fn.initPath_VML = function(F){
                        var dom = document.createElement("shape");
                        dom.style.position = 'absolute';
                        dom.style.width = '1px';
                        dom.style.height= '1px';
                        dom.setAttribute('coordsize','1,1');
                        dom.className = F._CNAME;
                        return dom;
                    }
                    E.fn.initPath_SVG = function(F){
                        var dom = document.createElementNS(F._NS,"path");
                        return dom;
                    }
                    E.fn.initPath = function(F,path){
                        path = path.toUpperCase();
                        if(F._ISSVG){
                            var dom = E.fn.initPath_SVG(F);
                            dom.setAttribute('d',path);
                        }else{
                            var dom = E.fn.initPath_VML(F);
                            var path = path.replace('Z','X');
                            dom.path = path;
                        }
                        this.F = F;
                        this.dom = dom;
                        dom = this.initAttr(dom);
                        F.r.appendChild(dom);
                        return this;
                    }
                    E.fn.initPath.prototype = E.fn;

                    $scope.treeList = treeList;
                    svgPath();
                    // $scope.treeList = [[{}],[{},{},{}],[{}]];
                    console.log(treeList);

                }
            );

            /**
             * 返回
             */
            $scope.goBack = function () {
                window.history.back();
            };
            $scope.goBack1 = function () {
                window.close();
            };
            /**
             * 点击节点跳转
             */
            $scope.goRegist = function (result,index) {
                debugger
                var i=index-1;
                if(result[i].nodeType=='compe'||result[i].nodeStatus=='0'||result[i].nodeStatus=='1'||result[i].nodeStatus==undefined||result[i].nodeStatus=='5'){
                    layerMsg("该节点目前没有信息!");
                    return
                }
                if(result[i].nodeType=='veric'){
                    layerMsg("请查看具体的计算书信息!");
                    return
                }
                //立案注销也不显示任何信息
                if(result[i].nodeType=='6'&&(result[i].nodeType=='check'||result[i].nodeType=='claim')){
                    layerMsg("该节点目前已被撤消，没有信息!");
                    return
                }
                var editType="";
                if(result[i].nodeStatus=='4'){
                    editType="SHOW";
                }else if(result[i].nodeStatus=='2'||result[i].nodeStatus=='3'){
                    editType="EDIT";
                }else{
                    return;
                }
                //报案
                if(result[i].nodeType=='regis'){
                    $state.go('UIAgriRegist', {
                        editType: editType,
                        policyNo: result[i].policyNo,
                        registNo: result[i].registNo,
                        riskCode: result[i].riskCode
                    })
                }else if(result[i].nodeType=='sched'){
                    //调度
                    $state.go("UIAgriDispatchEdit",
                        {
                            editType: editType,
                            riskCode: result[i].riskCode,
                            registNo: result[i].registNo,
                            scheduleID: result[i].scheduleId,
                            policyNo: result[i].policyNo,
                            nodeType: result[i].nodeType,
                            modelNo: result[i].modelNo,
                            nodeNo: result[i].nodeNo,
                            swflogFlowId: result[i].flowId,
                            swflogLogNo: result[i].logNo
                        }
                    )
                }else if(result[i].nodeType=='check'){
                        //查勘定损
                    $state.go("UIAgriCheck",
                        {
                            editType: editType,
                            riskCode: result[i].riskCode,
                            registNo:result[i].registNo,
                            flowId: result[i].flowId,
                            logNo: result[i].logNo,
                            checkNo: result[i].businessNo
                        }
                    )
                }else if(result[i].nodeType=='claim'){
                   //立案
                    $state.go("UIAgriClaimSee",
                        {
                            editType: editType,
                            claimNo:result[i].businessNo,
                            riskCode:result[i].riskCode,
                            policyNo:result[i].policyNo,
                            flowId:result[i].flowId,
                            registNo:result[i].registNo
                        }
                    )
                }else if(result[i].nodeType=='compp'){
                    //计算书
                    var riskType="";
                    if(result[i].riskCode.indexOf("31")){
                        riskType="H";
                    }else if(result[i].riskCode.indexOf("32")){
                        riskType="I";
                    }
                    $state.go('UIAgriCompenstate',{
                        editType: editType,
                        riskType: riskType,
                        compensateNo: result[i].businessNo||null,
                        claimNo: result[i].keyIn,
                        flowId: result[i].flowId,
                        logNo: result[i].logNo,
                        checkFlag:false
                    })
                }else if(result[i].nodeType=='endca'){
                    //结案
                    var target = {
                        registNo:result[i].registNo,
                        policyNo:result[i].policyNo ,
                        claimNo:result[i].claimNo,
                        edit:editType
                    };
                    $state.go('UIAgriEndcaseSee',{endcaseSee:JSON.stringify(target)});
                }else if(result[i].nodeType=='speci'){
                    $state.go(
                        'UIAgriPrepayHandle',{
                            editType: editType,
                            claimNo: result[i].keyIn,
                            prepayNo: result[i].businessNo,
                            flowID: result[i].flowId,
                            logNo: result[i].logNo,
                            modelNo: result[i].modelNo,
                            nodeNo: result[i].nodeNo
                        }
                    )
                }
            };

        }]);
});