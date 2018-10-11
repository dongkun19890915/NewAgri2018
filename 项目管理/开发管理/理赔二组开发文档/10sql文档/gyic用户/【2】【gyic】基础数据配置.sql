insert into utisystem (SYSTEMCODE, SYSTEMNAME, REMARK, FLAG)
values ('newagriclaim', '新农险理赔系统', null, null);


insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000038', '0', 1, 'newagriclaim', '工作流管理', null, 'UIAgriWorkFlowQuery', 'fraInterface', 13, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.workflow', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000034', '0', 1, 'newagriclaim', '流程查询', null, 'UIAgriFlowQuery', 'fraInterface', 10, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.workflowquery', '31,32', null, null, '3101 ', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000035', '0', 1, 'newagriclaim', '理赔打印', null, 'UIAgriPrintQuery', 'fraInterface', 11, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.allprint', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000039', '0', 1, 'newagriclaim', '并案管理', null, '---------', 'fraInterface', 14, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.unitemanage', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000041', '0', 1, 'newagriclaim', '报案任务处理', null, '---------', 'fraInterface', 2, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.regist', 'YA,01,02,03,04,05,07,08,09,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,00,001,31,32,33,ZH,28,29', '2717,0402,0403', null, '3101 ', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000042', '0', 1, 'newagriclaim', '调度任务处理', null, 'UIAgriDispatch', 'fraInterface', 3, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.schedule', '31,27,01,15,32,03,08,04,09,26,YA,22,11,10,ZH,21,28,29', '3121,2728,2604,YAB0,3102,3147,0310,3128,3102,26H1,2210,3154,0312,2207,3108,3155,3156,3197,2901', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000043', '0', 1, 'newagriclaim', '查勘定损任务处理', null, 'UIAgriCheckQuery', 'fraInterface', 4, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.check', 'YA,01,02,03,04,05,07,08,09,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,00,001,31,32,33,ZH,28,29', '2717', null, '3101 ', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000044', '0', 1, 'newagriclaim', '立案任务处理', null, 'UIAgriClaimQuery', 'fraInterface', 5, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.claim', 'YA,01,02,03,04,05,07,08,09,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,00,001,31,32,33,ZH,28,29', '2717', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000045', '0', 1, 'newagriclaim', '特殊赔案任务处理', null, '---------', 'fraInterface', 6, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.specialcase', 'YA,01,02,03,04,05,07,08,09,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,00,001,31,32,33,ZH,28,29', '2717', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000046', '0', 1, 'newagriclaim', '理算任务处理', null, 'UIAgriCompenstateQuery', 'fraInterface', 7, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.compensate', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000047', '0', 1, 'newagriclaim', '结案任务处理', null, 'UIAgriEndcaseQuery', 'fraInterface', 8, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.endcase', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000048', '0', 1, 'newagriclaim', '重开赔案任务处理', null, 'UIAgriRecase', 'fraInterface', 9, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.recase', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000049', 'A100000000000000036', 2, 'newagriclaim', '支付信息管理', null, 'UIAgriPaymentQuery', 'fraInterface', 18, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.paymentmanage.msgmanage', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000050', 'A100000000000000036', 2, 'newagriclaim', '支付情况统计表', null, 'UIAgriPaymentStatisticsList', 'fraInterface', 19, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.paymentmanage.tongji', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000051', 'A100000000000000037', 2, 'newagriclaim', '班表维护', null, 'UIAgriSchedule', 'fraInterface', 20, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.job.maintain', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000052', 'A100000000000000037', 2, 'newagriclaim', '区域设置', null, 'regionalSetting', 'fraInterface', 21, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.job.area', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000053', 'A100000000000000039', 2, 'newagriclaim', '合并案件', null, 'UIAgriCombineBeforeQuery', 'fraInterface', 22, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.unitemanage.unite', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000054', 'A100000000000000039', 2, 'newagriclaim', '并案查勘定损任务', null, 'UIAgriCombineCheckQuery', 'fraInterface', 23, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.unitemanage.check', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000055', 'A100000000000000039', 2, 'newagriclaim', '立案任务处理', null, 'UIAgriCombineTaskHandleQuery', 'fraInterface', 24, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.unitemanage.claim', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000056', 'A100000000000000040', 2, 'newagriclaim', '定损清单导入', null, 'UIAgriInventoryUpload', 'fraInterface', 25, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.listmanage.insert', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000057', 'A100000000000000041', 3, 'newagriclaim', '报案登记', null, 'UIAgriRegistBeforeQuery', 'fraInterface', 26, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.regist.insert', '31,27,01,15,32,03,08,04,09,26,YA,22,11,10,ZH,21,28,29', '3121,2728,2604,YAB0,3102,3147,0310,3128,3102,26H1,2210,3154,0312,2207,3108,3155,3156,3197,2901', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000032', '0', 1, 'newagriclaim', '工作台', null, 'dashboard', 'fraInterface', 1, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.console', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000058', 'A100000000000000041', 3, 'newagriclaim', '报案任务查询', null, 'UIAgriRegistQuery', 'fraInterface', 27, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.regist.query', '31,27,01,15,32,03,08,04,09,26,YA,22,11,10,ZH,21,28,29', '3121,2728,2604,YAB0,3102,3147,0310,3128,3102,26H1,2210,3154,0312,2207,3108,3155,3156,3197,2901', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000059', 'A100000000000000045', 3, 'newagriclaim', '特殊赔案申请', null, 'UIAgriPrepayApplyQuery', 'fraInterface', 28, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.specialcase.apply', 'YA,01,02,03,04,05,07,08,09,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,00,001,31,32,33,ZH,28,29', '2717', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000060', 'A100000000000000045', 3, 'newagriclaim', '特殊赔案处理', null, 'UIAgriPrepayHandleQuery', 'fraInterface', 29, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.taskmanage.specialcase.handle', 'YA,01,02,03,04,05,07,08,09,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,00,001,31,32,33,ZH,28,29', '2717', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000061', 'A100000000000000040', 2, 'newagriclaim', '定损清单查询', null, 'UIAgriInventoryQuery', 'fraInterface', 30, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.listmanage.query', 'YA,01,02,03,04,05,07,08,09,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,00,001,31,32,33,ZH,28,29', '2717', null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000036', '0', 1, 'newagriclaim', '支付管理', null, '---------', 'fraInterface', 12, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.paymentmanage', '31,32', null, null, '3101', null, null, null, null, null);

insert into utimenu (MENUID, UPPERMENUID, MENULEVEL, SYSTEMCODE, MENUCNAME, MENUENAME, URL, TARGET, DISPLAYNO, IMAGE, IMAGEEXPAND, IMAGECOLLAPSE, ICONEXPAND, ICONCOLLAPSE, VALIDSTATUS, REMARK, FLAG, TASKCODE, PERMITRISKCLASS, EXCEPTRISKCODE, EXCEPTRISKCLASS, PERMITRISKCODE, CHECKCLASS, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('A100000000000000037', '0', 1, 'newagriclaim', '班表管理', null, '---------', 'fraInterface', 15, '&#xe62a;', null, null, null, null, '1', null, null, 'newagriclaim.job', '31,32', null, null, '3101', null, null, null, null, null);


insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.console', 'newagriclaim', '工作台', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.job', 'newagriclaim', '班表管理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.allprint', 'newagriclaim', '理赔打印', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.job.area', 'newagriclaim.job', '区域设置', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.job.maintain', 'newagriclaim.job', '班表维护', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.listmanage', 'newagriclaim', '清单处理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.listmanage.insert', 'newagriclaim.listmanage', '定损清单导入', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.paymentmanage', 'newagriclaim', '支付管理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.paymentmanage.msgmanage', 'newagriclaim.paymentmanage', '支付信息管理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.paymentmanage.tongji', 'newagriclaim.paymentmanage', '支付情况统计表', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage', 'newagriclaim', '任务处理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.check', 'newagriclaim.taskmanage', '查勘定损任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.claim', 'newagriclaim.taskmanage', '立案任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.compensate', 'newagriclaim.taskmanage', '理算任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.endcase', 'newagriclaim.taskmanage', '结案任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.recase', 'newagriclaim.taskmanage', '重开赔案任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.regist', 'newagriclaim.taskmanage', '报案任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.regist.insert', 'newagriclaim.taskmanage.regist', '报案登记', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.regist.query', 'newagriclaim.taskmanage.regist', '报案任务查询', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.schedule', 'newagriclaim.taskmanage', '调度任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.specialcase', 'newagriclaim.taskmanage', '特殊赔案任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.specialcase.apply', 'newagriclaim.taskmanage.specialcase', '特殊赔案申请', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.taskmanage.specialcase.handle', 'newagriclaim.taskmanage.specialcase', '特殊赔案处理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.unitemanage', 'newagriclaim', '并案管理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.unitemanage.check', 'newagriclaim.unitemanage', '并案查勘定损任务', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.unitemanage.claim', 'newagriclaim.unitemanage', '立案任务处理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.unitemanage.unite', 'newagriclaim.unitemanage', '合并案件', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.workflow', 'newagriclaim', '工作流管理', null, null);

insert into utitask (TASKCODE, PARENTCODE, TASKNAME, REMARK, FLAG)
values ('newagriclaim.workflowquery', 'newagriclaim', '流程查询', null, null);


insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3129', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3129', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3129', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3129', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3130', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3130', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3130', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3130', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3130', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3130', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3129', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3129', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3107', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3108', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3108', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3107', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3220', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3220', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3220', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3220', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3220', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3220', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'REQUIRED_REINS', '强制再保计算', '2', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'PAY_DAYS', '缴费起讫天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'MIN_STATQUANTITY', '最低承保数量', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3107', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3108', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3220', 'MIN_SUMINSURED', '最低参保农户户次', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3220', 'MIN_STATQUANTITY', '最低承保数量', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3220', 'MIN_SUMINSURED', '最低参保农户户次', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3107', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3107', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3107', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3107', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3108', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3108', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3108', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3108', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3134', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3134', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3134', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3134', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3134', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3134', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3147', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3147', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3147', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3147', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3147', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3147', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3107', 'ALLOW_SEEFEE_GENERATEPOLICY', '是否允许见费出单', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3108', 'ALLOW_SEEFEE_GENERATEPOLICY', '是否允许见费出单', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3155', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3155', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3155', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3155', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3155', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3155', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3155', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3141', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3141', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3141', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3141', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3141', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3141', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3141', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3141', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'REQUIRED_REINS', '强制再保计算', '2', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'PAY_DAYS', '缴费起讫天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'MIN_STATQUANTITY', '最低承保数量', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3147', 'MIN_SUMINSURED', '最低参保农户户次', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3147', 'MIN_STATQUANTITY', '最低承保数量', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3147', 'MIN_SUMINSURED', '最低参保农户户次', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'CLAIM_VERSIONDATEHN', '3107河南条款控制日期', '2015-03-29', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3224', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3224', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3224', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3224', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3224', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3224', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3107', 'CLAIM_VERSIONDATEHN3107', '3107安徽小麦条款控制日期', '2015-10-01', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3108', 'CLAIM_VERSIONDATEHN3108', '3108安徽油菜条款控制日期', '2015-10-01', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3233', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3233', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3233', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3233', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3233', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3233', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3233', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3233', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3198', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3198', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3198', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3198', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3198', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3198', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'REQUIRED_REINS', '强制再保计算', '2', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'PAY_DAYS', '缴费起讫天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'MIN_STATQUANTITY', '最低承保数量', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3198', 'MIN_SUMINSURED', '最低参保农户户次', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3198', 'MIN_STATQUANTITY', '最低承保数量', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3198', 'MIN_SUMINSURED', '最低参保农户户次', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3195', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3195', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3195', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3195', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3195', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3195', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'REQUIRED_REINS', '强制再保计算', '2', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'PAY_DAYS', '缴费起讫天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'MIN_STATQUANTITY', '最低承保数量', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3195', 'MIN_SUMINSURED', '最低参保农户户次', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3195', 'MIN_STATQUANTITY', '最低承保数量', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3195', 'MIN_SUMINSURED', '最低参保农户户次', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3155', 'CLAIM_VERSIONDATEAH3155', '3155安徽小麦补充条款控制日期', '2016-01-28', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3237', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3237', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3237', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3237', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3237', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3237', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3162', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3162', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3162', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3162', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3162', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3162', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3162', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3162', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3413230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341363000005', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000002', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3401230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000102', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3416000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '102341663000003', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3406000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340663000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3410000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131053010016', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000007', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3403000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340363000018', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3407000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340763000004', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3413000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341363000005', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3404000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340463000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3402000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340263000020', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000031', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3466000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000032', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000007', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3405000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340563000006', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3412000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341263000010', '131153010032', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3401210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000014', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3410220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341063000101', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000013', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415030000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000105', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3413220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341363000005', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3412250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341263000011', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3413020000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341363000005', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000006', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000007', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3416220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '102341663000003', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3414000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341463000014', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000004', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3417000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341763000108', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3416230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '102341663000003', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000010', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340463000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000010', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '0000', 'REPORT_DEFER_DAYS', '报案延期天数', '800', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000011', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3401220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000106', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3402230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340263000023', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3402210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340263000022', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3414210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341463000015', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3405210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340563000006', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3403230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340363000021', '130342010038', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3403210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340363000022', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3413210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341363000005', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411820000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000008', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000008', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3404210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340463000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3413240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341363000005', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3403220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340363000023', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3417230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341763000111', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3417210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341763000110', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3416020000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '102341663000003', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000011', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408280000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000014', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3412820000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341263000103', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3417020000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341763000109', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3412220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341263000105', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000101', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000015', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3416210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '102341663000003', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000011', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3404060000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340463000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3406210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340663000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000101', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3402220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340263000107', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0088000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '821340163004004', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3403110000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340363000018', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418020000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4266000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4101000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410163000221', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3414220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340263000104', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000019', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898411763000114', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4113000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898411363000161', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415020000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000118', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4115000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898411563000159', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3412010000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341263000010', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3415090000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341563000117', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898411663000219', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000101', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418220001', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010804', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3410030000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131053010016', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3410210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131053010016', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898411463000095', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3412210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341263000115', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4120000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410163000255', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3411030000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341163000111', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4107000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410763000222', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4105000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410563000135', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3412260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341263000108', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3418240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131742010116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3401020000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000116', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3404010000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340463000009', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4103000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410363000325', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3417220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341763000107', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3401110000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000031', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4210830000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4208210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3413010000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898341363000005', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('5205000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898520163000183', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('5202000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898520163000183', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4208220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4105230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410563000135', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4107210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000195', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000201', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4103280000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000200', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4103230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000200', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4103270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000200', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4103810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000200', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4115210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000196', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4113210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000192', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4113220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000192', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4113260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000192', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4103290000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000200', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4103220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000200', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4113280000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000192', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4113240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000192', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4113810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000192', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4115280000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000196', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4115250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000196', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4115260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000196', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4115220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000196', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4115270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000196', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000201', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000201', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000201', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4120810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410163000255', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('5223000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898520163000183', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4101850000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410163000255', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('5203000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898520163000183', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '0000', 'JJLPFY_YBT', '医保通理赔案件是否参与间接理赔费用', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3405220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340563000006', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3410230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131053010016', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3410240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '131053010016', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('5266000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898520163000183', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4290060000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4208810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4203240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4211270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4201170000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898420163000399', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3405010000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340563000006', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3408660000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340863000004', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3405230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340563000006', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4105270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410563000135', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4105260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410563000135', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4107250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000195', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4107260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000195', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4107810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000195', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3401010000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000031', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3410040000', '0000', 'COMECODE_BUSINESSCODE', '?￠?¨éì??o?', '131053010016', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4101830000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898410163000255', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4107270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000195', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4107280000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000195', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3402030000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340263000107', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000201', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114030000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000201', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4105810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000194', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4114210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000201', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4117280000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000198', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116220000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116230000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116260000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116270000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116240000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116280000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116210000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116250000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('4116810000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', '898340163000203', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3100000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', 'A01', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3166000000', '0000', 'COMECODE_BUSINESSCODE', '刷卡商务号', 'A01', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3102', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3102', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3102', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3122', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3161', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3161', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3161', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3161', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3161', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3161', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3161', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3161', 'ALLOW_SEEFEE_GENERATEPOLICY', '是否允许见费出单', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'CLAIM_VERSIONDATEHN', '3161河南条款控制日期', '2015-03-29', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3161', 'CLAIM_VERSIONDATEHN3161', '3161安徽水稻大灾条款控制日期', '2015-10-01', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3122', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3122', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3122', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3122', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3122', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3122', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3122', 'ALLOW_SEEFEE_GENERATEPOLICY', '是否允许见费出单', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'CLAIM_VERSIONDATEHN', '3122河南条款控制日期', '2015-03-29', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3122', 'CLAIM_VERSIONDATEHN3122', '3122安徽棉花条款控制日期', '2015-10-01', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3126', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3126', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3126', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3126', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3126', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3126', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3101', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3101', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3101', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3101', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3101', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3101', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3101', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3101', 'ALLOW_SEEFEE_GENERATEPOLICY', '是否允许见费出单', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'CLAIM_VERSIONDATEHN', '3101河南条款控制日期', '2015-03-29', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3101', 'CLAIM_VERSIONDATEHN3101', '3101安徽小麦条款控制日期', '2015-10-01', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'ALLOW_UNPAYED_CLAIM', '保费未实收是否允许立案', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'ALLOW_UNPAYED_COMPENSATE', '保费未实收是否允许理算', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'ALLOW_UNPAYED_ENDCASE', '保费未实收是否允许结案', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'ALLOW_UNPAYED_PREPAY', '保费未实收是否允许预赔', '2', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'CLAIM_DAYS', '立案天数', '30', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'REPORT_DEFER_DAYS', '报案延期天数', '10000', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'REQUIRED_REINS', '强制再保计算', '1', '1 允许 2 不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'PAY_DAYS', '缴费起讫天数', '15', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3114', 'HESITATE_BACK_DAYS', '犹豫期退保（契撤）天数', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'ALLOW_SPECIALPREMIUM_POLICY', '输入中间成本', '1', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'MIN_GROUP_PROPORTION', '团单投保最低比例', '0.75', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3114', 'RISK_UNIT_FLAG', '拆分风险单位标志', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3114', 'REINS_OFFLINE_RISK', '配置险种为离线计算险种还是在线计算险种', '1', 'configvalue 字段的值： 1/在线计算  2/离线计算', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3114', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3114', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3114', 'MIN_STATQUANTITY', '最低承保数量', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3114', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3114', 'ALLOW_SEEFEE_GENERATEPOLICY', '是否允许见费出单', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'CLAIM_VERSIONDATEHN', '3114河南条款控制日期', '2015-03-29', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3114', 'CLAIM_VERSIONDATEHN3114', '3114安徽玉米条款控制日期', '2015-10-01', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('3400000000', '3126', 'MIN_SUMINSURED', '最低参保农户户次', '0', null, null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('0000000000', '3126', 'ALLOW_SEEFEE_GENERATEPOLICY', '是否允许见费出单', '1', '1-允许,2-不允许', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'CLAIM_VERSIONDATEHN', '3126河南条款控制日期', '2015-03-29', '版本上线日期,走不同计算公式', null, null, null, null);

insert into prpdriskconfigagri (COMCODE, RISKCODE, CONFIGCODE, CONFIGNAME, CONFIGVALUE, CONFIGVALUEDESC, CREATEDBY, CREATEDTIME, UPDATEDBY, UPDATEDTIME)
values ('00000000', '3126', 'CLAIM_VERSIONDATEHN3126', '3126安徽大豆条款控制日期', '2015-10-01', '版本上线日期,走不同计算公式', null, null, null, null);

