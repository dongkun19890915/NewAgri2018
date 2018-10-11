prompt Importing table swfnode...
set feedback off
set define off
insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 46, '车物补勘', 'patch', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 47, '补勘复核', 'pview', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 48, '车物查勘', 'cview', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 49, '查勘复核', 'fview', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 3, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 4, '计算书', 'compp', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 5, '核赔', 'veric', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 6, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 7, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 8, '理算', 'compe', 0, '0', null, 4, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 9, '特殊赔案', 'speci', 0, '0', null, 3, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 10, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 11, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 13, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 14, '调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 15, '定损调度', 'schel', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 16, '核损', 'verif', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (60, '老理赔立案注销审批模板', 1, '立案注销申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (60, '老理赔立案注销审批模板', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (60, '老理赔立案注销审批模板', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (60, '老理赔立案注销审批模板', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (60, '老理赔立案注销审批模板', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (60, '老理赔立案注销审批模板', 6, '审批通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 13, '重开赔案', 'rcase', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (12, '意健险理赔模板', 17, '重开赔案', 'rcase', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 14, '重开赔案', 'rcase', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (62, '老理赔重开赔案审批模版', 1, '重开赔案申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (62, '老理赔重开赔案审批模版', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (62, '老理赔重开赔案审批模版', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (62, '老理赔重开赔案审批模版', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (62, '老理赔重开赔案审批模版', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (62, '老理赔重开赔案审批模版', 6, '审批通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 1, '出单员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 2, '支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 3, '支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 4, '支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 5, '中支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 6, '中支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 7, '中支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 8, '省分公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 9, '省分公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 10, '省分公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 11, '总公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 12, '总公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 13, '总公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 14, '总公司首席核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (307, '健康险统一核保模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 1, '理算员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 2, '支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 3, '支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 4, '支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 5, '中支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 6, '中支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 7, '中支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 8, '省分公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 9, '省分公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 10, '省分公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 11, '总公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 12, '总公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 13, '总公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 14, '总公司首席核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (308, '健康险统一核赔模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 3, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 4, '计算书', 'compp', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 5, '核赔', 'veric', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 6, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 7, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 8, '理算', 'compe', 0, '0', null, 4, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 9, '特殊赔案', 'speci', 0, '0', null, 3, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 10, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 11, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 13, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 14, '调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 15, '定损调度', 'schel', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 16, '核损', 'verif', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (14, '健康险理赔模板', 17, '重开赔案', 'rcase', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (63, '健康险立案注销审批模板', 1, '立案注销申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (63, '健康险立案注销审批模板', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (63, '健康险立案注销审批模板', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (63, '健康险立案注销审批模板', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (63, '健康险立案注销审批模板', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (63, '健康险立案注销审批模板', 6, '审批通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (64, '健康险重开赔案审批模版', 1, '重开赔案申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (64, '健康险重开赔案审批模版', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (64, '健康险重开赔案审批模版', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (64, '健康险重开赔案审批模版', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (64, '健康险重开赔案审批模版', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (64, '健康险重开赔案审批模版', 6, '审批通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 2, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 3, '财产定损', 'propc', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 4, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 5, '预赔', 'prepa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 6, '理算', 'compe', 0, '0', null, 8, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 7, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 8, '计算书', 'compp', 0, '0', null, 6, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 9, '调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 10, '特殊赔案', 'speci', 0, '0', null, 4, 'T', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 11, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 12, '核赔', 'veric', 0, '0', null, 6, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 13, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 14, '人伤', 'wound', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 15, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 16, '重开赔案', 'rcase', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 17, '财产核损', 'propv', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (87, '类财产险理赔流程模版(含核价核损)', 18, '核价', 'verip', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 12, '总公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 13, '总公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 14, '总公司首席核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 1, '理算员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 2, '支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 3, '支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 4, '支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 5, '中支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 6, '中支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 7, '中支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 8, '省分公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 9, '省分公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 10, '省分公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 11, '总公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 12, '总公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 13, '总公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 14, '总公司首席核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (303, '农业险统一核赔模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 1, '出单员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 2, '支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 3, '支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 4, '支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 5, '中支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 6, '中支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 7, '中支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 8, '省分公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 9, '省分公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 10, '省分公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 11, '总公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 12, '总公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 13, '总公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 14, '总公司首席核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (300, '财产险统一核保模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 11, '总公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (54, '支付信息审批模板', 1, '支付信息申请', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (54, '支付信息审批模板', 2, '分公司一级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (54, '支付信息审批模板', 3, '分公司二级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (54, '支付信息审批模板', 4, '总公司一级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (54, '支付信息审批模板', 5, '总公司二级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (54, '支付信息审批模板', 6, '审核通过', 'vpay', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 37, '支付信息审批申请', 'apay', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 38, '支付信息审批', 'vpay', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 39, '复勘处理', 'rchk', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 41, '追偿立案', 'recov', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 42, '追偿理算', 'recco', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 43, '追偿审批', 'reccp', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (55, '追偿理算审批模板', 1, '追偿理算申请', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (55, '追偿理算审批模板', 2, '分公司一级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (55, '追偿理算审批模板', 3, '分公司二级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (55, '追偿理算审批模板', 4, '总公司一级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (55, '追偿理算审批模板', 5, '总公司二级审批人', 'vpay', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (55, '追偿理算审批模板', 6, '审核通过', 'vpay', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 2, '查勘调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 3, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 4, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 5, '核损', 'verif', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 6, '计算书', 'compp', 0, '0', null, 12, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 7, '暂未使用', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 8, '暂未使用', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 9, '暂未使用', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 10, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 12, '理算', 'compe', 0, '0', null, 6, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 13, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 14, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 15, '人伤定损', 'wound', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 16, '人伤核损', 'veriw', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 18, '预赔处理', 'speci', 0, '0', null, 14, 'T', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 19, '财产定损', 'propc', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 20, '财产核损', 'propv', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 21, '复勘', 'backc', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 22, '定损调度', 'schel', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 23, '核赔', 'veric', 0, '0', null, 12, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 24, '回访', 'backv', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 25, '核赔', 'veric', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 26, '回访', 'backv', 0, '0', '和查勘连接的', 3, 'T', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 1, '出单员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 2, '支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 3, '支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 4, '支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 5, '中支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 6, '中支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 7, '中支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 8, '省分公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 9, '省分公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 10, '省分公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 11, '总公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 12, '总公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 13, '总公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 14, '总公司首席核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (305, '车险统一核保模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 1, '理算员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 2, '支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 3, '支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 4, '支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 5, '中支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 6, '中支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 7, '中支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 8, '省分公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 9, '省分公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 10, '省分公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 11, '总公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 12, '总公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 13, '总公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 14, '总公司首席核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (306, '车险统一核赔模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 32, '报案注销审批', 'rcanc', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 33, '立案估损申请', 'revis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 34, '立案估损调整审批', 'cjust', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 35, '重开赔案', 'rcase', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 36, '立案注销', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 27, '分公司核价', 'verip', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 28, '总公司核价', 'verpo', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 29, '人伤查勘', 'surve', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 31, '人伤复核', 'rview', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (50, '报案注销审批模板', 1, '报案注销申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (50, '报案注销审批模板', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (50, '报案注销审批模板', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (50, '报案注销审批模板', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (50, '报案注销审批模板', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (50, '报案注销审批模板', 6, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (52, '重开赔案审批模板', 1, '重开赔案申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (52, '重开赔案审批模板', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (52, '重开赔案审批模板', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (52, '重开赔案审批模板', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (52, '重开赔案审批模板', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (52, '重开赔案审批模板', 6, '审批通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (53, '估损调整审批模板', 1, '估损调整申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (53, '估损调整审批模板', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (53, '估损调整审批模板', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (53, '估损调整审批模板', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (53, '估损调整审批模板', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (53, '估损调整审批模板', 6, '审批通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (51, '立案注销审批模板', 1, '立案注销申请', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (51, '立案注销审批模板', 2, '分公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (51, '立案注销审批模板', 3, '分公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (51, '立案注销审批模板', 4, '总公司一级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (51, '立案注销审批模板', 5, '总公司二级审批人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (51, '立案注销审批模板', 6, '审批通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 2, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 3, '计算书', 'compp', 0, '0', null, 7, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 4, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 5, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 6, '核赔', 'veric', 0, '0', null, 7, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 7, '理算', 'compe', 0, '0', null, 3, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 9, '特殊赔案', 'speci', 0, '0', null, 2, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 10, '单证收集', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 2, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (13, '理赔货运险流程', 13, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 4, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 6, '理算', 'compe', 0, '0', null, 8, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 7, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 8, '计算书', 'compp', 0, '0', null, 6, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 9, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 10, '核赔', 'veric', 0, '0', null, 6, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 11, '特殊赔案', 'speci', 0, '0', null, 4, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (7, '责任险理赔流程', 12, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (99, '英大车险核保模板', 1, '出单员', 'regis', 0, '0', null, 0, null, null, null, null, null, 30, 30, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (99, '英大车险核保模板', 2, '3级核保', 'regis', 0, '0', null, 0, null, null, null, null, null, 110, 140, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (99, '英大车险核保模板', 3, '2级核保', 'regis', 0, '0', null, 0, null, null, null, null, null, 200, 220, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (99, '英大车险核保模板', 4, '1级核保', 'regis', 0, '0', null, 0, null, null, null, null, null, 330, 260, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (99, '英大车险核保模板', 5, '首席核保', 'regis', 0, '0', null, 0, null, null, null, null, null, 670, 150, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (99, '英大车险核保模板', 6, '审核通过', 'regis', 0, '1', null, 0, null, null, null, null, null, 450, 20, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 45, '财产复勘', 'prchk', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (5, '车险理赔流程', 50, '支付', 'epay', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 1, '出单员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 2, '支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 3, '支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 4, '支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 5, '中支公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 6, '中支公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 2, '支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 3, '支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 4, '支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 5, '中支公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 6, '中支公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 7, '中支公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 8, '省分公司初级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 9, '省分公司中级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (91, '再保报表流程', 1, '条件配置', 'confg', 0, '0', null, 0, 'N', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (91, '再保报表流程', 2, '数据提取', 'extra', 0, '0', null, 0, 'N', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (91, '再保报表流程', 3, '报表生成', 'gener', 0, '0', null, 0, 'N', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (91, '再保报表流程', 4, '报表Excel导出', 'expxl', 0, '0', null, 0, 'N', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 3, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 4, '计算书', 'compp', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 5, '核赔', 'veric', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 6, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 7, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 8, '理算', 'compe', 0, '0', null, 4, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 9, '特殊赔案', 'speci', 0, '0', null, 3, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 10, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 11, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 13, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 14, '调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 15, '定损调度', 'schel', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 16, '核损', 'verif', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 7, '中支公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 8, '省分公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 9, '省分公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 10, '省分公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 11, '总公司初级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 12, '总公司中级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 13, '总公司高级核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 14, '总公司首席核保人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 15, '总公司总裁室', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (301, '农业险统一核保模板', 16, '审核通过', 'regis', 0, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 10, '省分公司高级核赔人', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (302, '财产险统一核赔模板', 1, '理算员', 'regis', 0, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (15, '健康险(大病)理赔模板', 17, '重开赔案', 'rcase', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 2, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 3, '财产定损', 'propc', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 4, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 5, '预赔', 'prepa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 6, '理算', 'compe', 0, '0', null, 8, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 7, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 8, '计算书', 'compp', 0, '0', null, 6, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 9, '调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 10, '特殊赔案', 'speci', 0, '0', null, 4, 'T', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 11, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 12, '核赔', 'veric', 0, '0', null, 6, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 13, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 14, '人伤', 'wound', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 15, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (1, '财产险理赔流程模版', 16, '重开赔案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 2, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 3, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 4, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 5, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 6, '计算书', 'compp', 0, '0', null, 7, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 7, '理算', 'compe', 0, '0', null, 6, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 8, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 9, '核赔', 'veric', 0, '0', null, 7, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 10, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 11, '特殊赔案', 'speci', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 12, '调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 13, '定损调度', 'schel', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 14, '核损', 'verif', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (2, '养殖险理赔模版', 15, '重开赔案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 1, '报案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 3, '立案', 'claim', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 4, '计算书', 'compp', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 5, '核赔', 'veric', 0, '0', null, 8, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 6, '结案', 'endca', 0, '1', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 7, '注销/拒赔', 'cance', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 8, '理算', 'compe', 0, '0', null, 4, 'M', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 9, '特殊赔案', 'speci', 0, '0', null, 3, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 10, '单证', 'certi', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 11, '查勘', 'check', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 13, '定损', 'certa', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 14, '调度', 'sched', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 15, '定损调度', 'schel', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 16, '核损', 'verif', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (4, '种植险理赔模版', 17, '重开赔案', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

insert into swfnode (MODELNO, MODELNAME, NODENO, NODENAME, NODETYPE, TIMELIMIT, ENDFLAG, CRITERION, TASKNO, TASKTYPE, UNITCODE, UNITNAME, HANDLERCODE, HANDLERNAME, POSX, POSY, FLAG, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values (309, '12', 1, '12', 'regis', 0, '0', null, 0, 'S', null, null, null, null, 0, 0, null, null, null, null, null);

prompt Done.
