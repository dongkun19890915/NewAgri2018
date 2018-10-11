/**
 * Created by Guoxianglian on 2016/9/19.
 * 首页入口控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var indexCtrl = function($scope,$state,indexServ) {

        //$scope.config = {width: "100%",items:["image", "multiimage"]};
        $scope.info = {};
        $scope.info.content = "12d1";

        $scope.showMainNagiv = false;
        $scope.insuredOnlyOneLayer = true;
        $scope.fileDto = {};
        $scope.indexApplication = function(){
            var proposalDto = {};
            proposalDto.riskCode = 'EQ01';// 此参数 无意思。只为后台校验权限
            indexServ.newProposalMenu(proposalDto).then(
                function(answer){
                    if(!$scope.fileDto.riskCode == ''){
                        $state.go("main.application",{"riskCode":$scope.fileDto.riskCode})
                    }else{
                        $scope.msg = "请先选择需要投保的产品";
                        $scope.insuredOnlyOneLayer = false;
                    }
                },function(error){
                }
            );
        };
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
        $scope.indexSupendProposal = function(){
            var proposalDto = {};
            proposalDto.riskCode = 'EQ01';// 此参数 无意思。只为后台校验权限
            indexServ.suspendProposalMenu(proposalDto).then(
                function(answer){
                    $state.go("main.suspendProposal")
                },function(error){
                }
            );
         };

        $scope.indexSupendEndorse = function(){
            var proposalDto = {};
            proposalDto.riskCode = 'EQ01';// 此参数 无意思。只为后台校验权限
            indexServ.suspendEndorseMenu(proposalDto).then(
                function(answer){
                    $state.go("main.suspendEndorse");
                },function(error){
                }
            );

        };
     //header部位调取服务
    $scope.RiskQueryConditionDto={};
    var condition=$scope.RiskQueryConditionDto;
     indexServ.insuranceProductsInit(condition).then(
          function(answer){
                $scope.riskList = answer.data;
          },function(error){
          }
      );   
     //待处理投保单
   var proposalDto={};
     //todo 临时注释掉因为后台网管层暂时没提供此方法
        /*indexServ.disposalPolicyInit(proposalDto).then(
          function(answer){
                $scope.policyNum= answer.data;
                if($scope.policyNum.quantity>= 100){
                    $scope.policyNum.quantity="99+"
                }

          },function(error){
          }
      ); */
     //待处理批改
    var endorseDto={};
        //todo 临时注释掉因为后台网管层暂时没提供此方法
        /*
        indexServ.pendingCorrectionInit(endorseDto).then(
         function(answer){
                $scope.endorseNum= answer.data;
                if($scope.endorseNum.quantity>= 100){
                    $scope.endorseNum.quantity="99+"
                }
          },function(error){
          }
      );
         */
     $scope.mapConfig = {
                theme:'catastrophe',
                itemStyle:{
                    normal:{
                        areaStyle:{color:'#0b7cc3'}
                    }
                },
                tooltip : {
                    show: false
                },
                debug: true,
                showLegend: true,
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: ['']
                },
                showLegendSymbol: true,
                showXAxis: true,
                showYAxis: true,
                stack: false,
                dataRange: {
                    min: 0,
                    max: 100,
                    color: ['#0b7cc3', '#d3e5ef'],
                    x: 'left',
                    y: 'top',
                    text: ['高', '低'],           // 文本，默认为数值文本
                    calculable: true,
                     textStyle: {
                        padding:["10px","0"],
                        fontWeight: 'bold',
                        color: '#666',
                        fontFamily: 'Microsoft YaHei',
                        fontSize: "10"
                    },
                    precision:0,
                    formatter:function(v1){
                       return parseInt(v1)+" 单";
                    }

                },
                roamController: {
                    show:true ,
                    x: 'right',
                    y: 'bottom',
                    mapTypeControl: {
                        'china': true
                    }
                },
                series: [
                    {
                        name: '全国',
                        type: 'area',
                        mapType: 'china',
                        label: {
                            normal: {
                                show: true
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        itemStyle: {
                            normal: {
                                label: {
                                    show:true,
                                    textStyle:{
                                        color: '#333',
                                        fontFamily:'Microsoft YaHei',
                                        fontSize:"12",
                                        fontStyle:'normal'
                                    }
                                }
                            },
                            emphasis: {
                                color: '#f27318',
                                label: {
                                    show: true,
                                    textStyle: {
                                        fontWeight: 'bold',
                                        color: '#fff',
                                        fontFamily:'Microsoft YaHei',
                                        fontSize:"12",
                                        fontStyle:'normal'
                                    }
                                }
                            }
                        },
                        showLegendSymbol:true,
                        dataRangeHoverLink:true
                    }]
            };

     //地图数据读取
            var provinceList=[{"areaCode":"110000","areaName":"北京"},{"areaCode":"120000","areaName":"天津"},
            {"areaCode":"130000","areaName":"河北"},
            {"areaCode":"140000","areaName":"山西"}, {"areaCode":"150000","areaName":"内蒙古"},
            {"areaCode":"210000","areaName":"辽宁"},{"areaCode":"220000","areaName":"吉林"},
            {"areaCode":"230000","areaName":"黑龙江"}, {"areaCode":"310000","areaName":"上海"},
            {"areaCode":"320000","areaName":"江苏"},{"areaCode":"330000","areaName":"浙江"},
            {"areaCode":"340000","areaName":"安徽"}, {"areaCode":"350000","areaName":"福建"},
            {"areaCode":"360000","areaName":"江西"},{"areaCode":"370000","areaName":"山东"},
            {"areaCode":"410000","areaName":"河南"}, {"areaCode":"420000","areaName":"湖北"},
            {"areaCode":"430000","areaName":"湖南"},{"areaCode":"440000","areaName":"广东"},
            {"areaCode":"450000","areaName":"广西"}, {"areaCode":"460000","areaName":"海南"},
            {"areaCode":"500000","areaName":"重庆"},{"areaCode":"510000","areaName":"四川"},
            {"areaCode":"520000","areaName":"贵州"}, {"areaCode":"530000","areaName":"云南"},
            {"areaCode":"540000","areaName":"西藏"},{"areaCode":"610000","areaName":"陕西"},
            {"areaCode":"620000","areaName":"甘肃"}, {"areaCode":"630000","areaName":"青海"},
            {"areaCode":"640000","areaName":"宁夏"},{"areaCode":"650000","areaName":"新疆"},
            {"areaCode":"710000","areaName":"台湾"}, {"areaCode":"810000","areaName":"香港"},
            {"areaCode":"820000","areaName":"澳门"}];
            var mapDto={ };
            mapDto.statCode="itemCount";
             var datapoints=[ ];
             var policySort=[ ];
             indexServ.mapDataGet(mapDto).then(
                  function(answer){
                        var mapData= answer.data;
                        for(var i=0;i<provinceList.length;i++){
                            datapoints[i]={x:provinceList[i].areaName,y:0,areaCode:provinceList[i].areaCode}
                        }
                        for(var m=0;m< datapoints.length;m++){
                            for(var n=0;n<mapData.prpDstatList.length;n++){
                                if(mapData.prpDstatList[n].statSubject ==datapoints[m].areaCode){
                                    policySort.push(Number(mapData.prpDstatList[n].sumItem));
                                    datapoints[m].y=mapData.prpDstatList[n].sumItem
                                }
                            }
                        }
                        //数组排序
                        function evlSort(a){
                               var i=0;
                               var j=0;
                                for(var i=0;i<=a.length;i++){
                                    for(var j = i + 1;j<a.length;j++){
                                        if(a[i]>a[j]){
                                            var tmp = a[i];
                                            a[i] = a[j];
                                             a[j] = tmp;
                                }
                            }
                        }
                            return a;
                        }
                        evlSort(policySort);
                         var groundInfo={};
                         $scope.mapMultiple=[];
                        groundInfo.name="map";
                        groundInfo.datapoints=datapoints;
                        $scope.mapMultiple.push(groundInfo);
                        var maxNum;
                        if(policySort[policySort.length-1]<100 || policySort[policySort.length-1]==undefined){
                            maxNum=100
                        }else{
                            maxNum=policySort[policySort.length-1];
                        }
                        console.log(maxNum);
                        $scope.mapConfig.dataRange.max=maxNum;
                   },function(error){
                    }
              );  
               //折线图数据读取
            var lineDto={ };
            lineDto.statCode="statPolicy";
             //var datapoints=[ ];
             indexServ.mapDataGet(lineDto).then(
                  function(answer){
                        var lineData= answer.data;
                        var linePremium={};
                        var linePolicy={};
                        linePremium.name="保费";
                        linePolicy.name="保单";
                        var premiumdatapoints=[];
                        var policydatapoints=[];
                        for(var i=0;i<lineData.prpDstatList.length;i++){
                            premiumdatapoints[i]={x:lineData.prpDstatList[i].statSubject,y:lineData.prpDstatList[i].sumPremium}
                            policydatapoints[i]={x:lineData.prpDstatList[i].statSubject,y:lineData.prpDstatList[i].sumItem}
                        }
                        var nullNum={x:"",y:0};
                        premiumdatapoints.unshift(nullNum);
                        premiumdatapoints.push(nullNum);
                        policydatapoints.unshift(nullNum);
                        policydatapoints.push(nullNum);
                        linePremium.datapoints=premiumdatapoints;
                        linePolicy.datapoints=policydatapoints;
                        $scope.lineMultiple=[];
                        $scope.lineMultiple.push(linePremium);
                        $scope.lineMultiple.push(linePolicy);
                   },function(error){
                    }
              );  
    
        //折线图数据读取
        $scope.lineConfig = {
            theme:'catastrophe',
            tooltip : {
                trigger: 'axis',
                formatter: function(params) {
                    return '当月总'+params[0].seriesName + ' : ' + params[0].value + ' 元<br/>'
                        + '当月总'+params[1].seriesName + ' : ' + params[1].value + ' 单';
                }
            },
            debug: true,
            showLegend: true,
            legend: {
                data:['保费','保单'],
                textStyle:{
                    fontSize:'12',
                    symbol:'emptyCircle',
                    symbolSize:['4','4'],
                    fontFamily:'Microsoft YaHei',
                    color:'#333'
                },
                x:'right'
            },
            grid:{
                borderWidth:'0',
                borderColor:'#dbebf6',
                backgroundColor:'#fff',
                x:'-14%',
                x2:'-14%',
                y:'30',
                y2:'49'
            },
            calculable : true,
            showXAxis: true,
            showYAxis: true,
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['','2016.04', '2016.05', '2016.06', '2016.07','2016.08','2016.09',''],
                    axisTick:{
                        show:false
                    },
                    axisLabel:{
                        textStyle: {
                            fontSize: '20',
                            color: '#666',
                            fontFamily:'Microsoft YaHei'
                        }
                    },
                    axisLine:{
                        show:true,
                        lineStyle:{
                            color:'#d5d5d5',
                            width:'2',
                            type:'solid'
                        }
                    },
                    splitLine:{
                        show:true,
                        lineStyle:{
                            color:'#dbebf6',
                            width:1,
                            type:'solid'
                        }
                    }
                }
            ],
            /*yAxis : [
                       {
                           type : 'value',
                           show : true,
                           boundaryGap:[0,0.01],
                           splitLine:{
                               show:true,
                               lineStyle:{
                                   color:'#dbebf6',
                                   width:1,
                                   type:'solid'
                               }
                           }
                       },
                       {
                           type : 'value',
                           show : true,
                           boundaryGap:[0,0.01],
                           max:'600',
                           splitLine:{
                               show:true,
                               lineStyle:{
                                   color:'#dbebf6',
                                   width:1,
                                   type:'solid'
                               }
                           }
                       }
                   ],*/
            yAxis : [
                {
                    name:'保费',
                    type : 'value',
                    show : true,
                    boundaryGap:[0,0.01],
                    splitLine:{
                        show:true,
                        lineStyle:{
                            color:'#dbebf6',
                            width:1,
                            type:'solid'
                        }
                    }
                },
                {
                    name:'保单',
                    type : 'value',
                    show : true,
                    boundaryGap:[0,0.01],
                    splitLine:{
                        show:true,
                        lineStyle:{
                            color:'#dbebf6',
                            width:1,
                            type:'solid'
                        }
                    }
                }
            ],
            series : [
                {
                    name:'保费',
                    type:'line',
                    symbol:'emptyCircle',
                    symbolSize:['4','4'],
                    smooth: true,
                    itemStyle:{
                        normal:{
                            lineStyle:{
                                color:'#f27318'
                            }
                        }
                    }
                },
                {
                    name:'保单',
                    type:'line',
                    yAxisIndex:1,
                    symbol:'emptyCircle',
                    symbolSize:['4','4'],
                    smooth: true,
                    itemStyle:{
                        normal:{
                            lineStyle:{
                                color:'#0b7cc3'
                            }
                        }
                    }
                }
            ]
        };
            
        };

    moduleApp.controller('indexCtrl',['$scope','$state','indexServ',indexCtrl]);
});