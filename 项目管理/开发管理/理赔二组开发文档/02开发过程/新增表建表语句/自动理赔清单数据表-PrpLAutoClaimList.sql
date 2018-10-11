create table PrpLAutoClaimList(
	policyNo  VARCHAR2(22)   ,
	registNo  VARCHAR2(22)   ,
	claimNo VARCHAR2(22)     ,
	flowId  VARCHAR2(22)     ,
	nodeNo  NUMBER           ,
	nodeName  VARCHAR2(100)  ,
	nodeStartFlag VARCHAR2(1),
	billNo  VARCHAR2(25)     ,
	autoFlag  VARCHAR2(1)    ,
	finishFlag  VARCHAR2(1)  ,
	falseReason VARCHAR2(100),
	remark1 VARCHAR2(50)     ,
	remark2 VARCHAR2(50)     ,
	riskCode  VARCHAR2(4)    ,
	createdBy VARCHAR2(20)   ,
	createdTime DATE         ,
	updatedBy VARCHAR2(20)   ,
	updatedTime DATE
);
comment on table PrpLAutoClaimList is '自动理赔清单数据表';  
comment on column PrpLAutoClaimList.policyNo		is '保单号        ';
comment on column PrpLAutoClaimList.registNo		is '报案号        ';
comment on column PrpLAutoClaimList.claimNo			is '立案号        ';
comment on column PrpLAutoClaimList.flowId			is '流程编号      ';
comment on column PrpLAutoClaimList.nodeNo			is '流入节点号    ';
comment on column PrpLAutoClaimList.nodeName		is '流入节点名称  ';
comment on column PrpLAutoClaimList.nodeStartFlag	is '节点开始标志  ';
comment on column PrpLAutoClaimList.billNo			is '定损清单清单号';
comment on column PrpLAutoClaimList.autoFlag		is '是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能）';
comment on column PrpLAutoClaimList.finishFlag		is '自动理赔是否完成(1完成,0失败)';
comment on column PrpLAutoClaimList.falseReason		is '自动理赔失败原因';
comment on column PrpLAutoClaimList.remark1			is '预留字段1     ';
comment on column PrpLAutoClaimList.remark2			is '预留字段2     ';
comment on column PrpLAutoClaimList.riskCode		is '险种代码      ';
comment on column PrpLAutoClaimList.createdBy		is '创建人        ';
comment on column PrpLAutoClaimList.createdTime		is '创建时间      ';
comment on column PrpLAutoClaimList.updatedBy		is '更新人        ';
comment on column PrpLAutoClaimList.updatedTime		is '更新时间      ';

alter table PrpLAutoClaimList add constraint PK_LAUTO primary key (registNo);