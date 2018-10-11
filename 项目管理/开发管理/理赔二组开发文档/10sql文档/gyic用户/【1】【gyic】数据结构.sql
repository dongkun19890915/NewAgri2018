--生长期表
-- Create table
create table GYIC.PRPLGROWTH
(
  riskcode    VARCHAR2(8) not null,
  clausecode  VARCHAR2(20) not null,
  itemcode    VARCHAR2(8) not null,
  kindcode    VARCHAR2(20) not null,
  growthname  VARCHAR2(60),
  growthcode  VARCHAR2(20) not null,
  flag        VARCHAR2(2) not null,
  paystandard VARCHAR2(30),
  createdby   VARCHAR2(20),
  createdtime DATE,
  updatedby   VARCHAR2(20),
  updatedtime DATE
);

-- Add comments to the table 
comment on table GYIC.PRPLGROWTH
  is '生长期表';
-- Add comments to the columns 
comment on column GYIC.PRPLGROWTH.riskcode
  is '险种代码';
comment on column GYIC.PRPLGROWTH.clausecode
  is '条款代码';
comment on column GYIC.PRPLGROWTH.itemcode
  is '标的代码';
comment on column GYIC.PRPLGROWTH.kindcode
  is '险别代码';
comment on column GYIC.PRPLGROWTH.growthname
  is '生长期名称';
comment on column GYIC.PRPLGROWTH.growthcode
  is '生长期代码';
comment on column GYIC.PRPLGROWTH.flag
  is '有效标识';
comment on column GYIC.PRPLGROWTH.paystandard
  is '赔偿标准';
comment on column GYIC.PRPLGROWTH.createdby
  is '创建人';
comment on column GYIC.PRPLGROWTH.createdtime
  is '创建时间';
comment on column GYIC.PRPLGROWTH.updatedby
  is '更新人';
comment on column GYIC.PRPLGROWTH.updatedtime
  is '更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.PRPLGROWTH
  add constraint PK_PRPLGROWTH primary key (RISKCODE, CLAUSECODE, ITEMCODE, KINDCODE, GROWTHCODE, FLAG)

--工作流程表
-- Create table
create table GYIC.WORKPROCESS
(
  id               NUMBER not null,
  registno         VARCHAR2(22) not null,
  policyno         VARCHAR2(22) not null,
  claimno          VARCHAR2(22),
  compensateno     VARCHAR2(25),
  caseno           VARCHAR2(22),
  flowid           VARCHAR2(22),
  precompensateno  VARCHAR2(22),
  nodetype         VARCHAR2(5),
  nodename         VARCHAR2(100),
  nextnodetype     VARCHAR2(100),
  classcode        VARCHAR2(3),
  riskcode         VARCHAR2(4),
  nodestatus       VARCHAR2(2),
  casetype         VARCHAR2(22),
  registflowintime VARCHAR2(19),
  flowintime       VARCHAR2(19),
  operator         VARCHAR2(100),
  operatedate      DATE,
  createdby        VARCHAR2(20),
  createdtime      DATE,
  updatedby        VARCHAR2(20),
  updatedtime      DATE
);

-- Add comments to the table 
comment on table GYIC.WORKPROCESS
  is '工作流程表';
-- Add comments to the columns 
comment on column GYIC.WORKPROCESS.registno
  is '报案号';
comment on column GYIC.WORKPROCESS.policyno
  is '保单号';
comment on column GYIC.WORKPROCESS.claimno
  is '立案号';
comment on column GYIC.WORKPROCESS.compensateno
  is '赔款计算书号';
comment on column GYIC.WORKPROCESS.caseno
  is '结案号';
comment on column GYIC.WORKPROCESS.flowid
  is '流程号';
comment on column GYIC.WORKPROCESS.precompensateno
  is '预赔号';
comment on column GYIC.WORKPROCESS.nodetype
  is '当前节点代码';
comment on column GYIC.WORKPROCESS.nodename
  is '当前节点';
comment on column GYIC.WORKPROCESS.nextnodetype
  is '下一节点代码';
comment on column GYIC.WORKPROCESS.classcode
  is '险种大类';
comment on column GYIC.WORKPROCESS.riskcode
  is '险种';
comment on column GYIC.WORKPROCESS.nodestatus
  is '当前状态';
comment on column GYIC.WORKPROCESS.casetype
  is '案件状态';
comment on column GYIC.WORKPROCESS.registflowintime
  is '报案流入时间';
comment on column GYIC.WORKPROCESS.flowintime
  is '最新节点流入时间';
comment on column GYIC.WORKPROCESS.operator
  is '操作人';
comment on column GYIC.WORKPROCESS.operatedate
  is '操作时间';
comment on column GYIC.WORKPROCESS.createdby
  is '创建人';
comment on column GYIC.WORKPROCESS.createdtime
  is '创建时间';
comment on column GYIC.WORKPROCESS.updatedby
  is '更新人';
comment on column GYIC.WORKPROCESS.updatedtime
  is '更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.WORKPROCESS
  add constraint PK_WORKPROCESS primary key (ID, REGISTNO)

--条款公式配置表
-- Create table
create table GYIC.PRPLCONFIGURATION
(
  id                VARCHAR2(10) not null,
  classcode         VARCHAR2(3),
  riskcode          VARCHAR2(4),
  clausenumber      VARCHAR2(30),
  formuladescribing VARCHAR2(200),
  formula           VARCHAR2(100),
  reserve1          VARCHAR2(10),
  reserve2          VARCHAR2(10),
  reserve3          VARCHAR2(10),
  reserve4          VARCHAR2(10),
  reserve5          VARCHAR2(10),
  reserve6          VARCHAR2(10),
  reserve7          VARCHAR2(10),
  updatedtime       DATE,
  updatedby         VARCHAR2(20),
  createdtime       DATE,
  createdby         VARCHAR2(20),
  kindcode          VARCHAR2(20),
  itemcode          VARCHAR2(20),
  calculationmethod VARCHAR2(2)
);

-- Add comments to the table 
comment on table GYIC.PRPLCONFIGURATION
  is '条款公式配置表';
-- Add comments to the columns 
comment on column GYIC.PRPLCONFIGURATION.id
  is '序号，唯一标识';
comment on column GYIC.PRPLCONFIGURATION.classcode
  is '险种';
comment on column GYIC.PRPLCONFIGURATION.riskcode
  is '险类';
comment on column GYIC.PRPLCONFIGURATION.clausenumber
  is '条款编号';
comment on column GYIC.PRPLCONFIGURATION.formuladescribing
  is '赔款公式文字描述';
comment on column GYIC.PRPLCONFIGURATION.formula
  is '计算公式';
comment on column GYIC.PRPLCONFIGURATION.reserve1
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve2
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve3
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve4
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve5
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve6
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve7
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.kindcode
  is '险别代码';
comment on column GYIC.PRPLCONFIGURATION.itemcode
  is '标的代码';
comment on column GYIC.PRPLCONFIGURATION.calculationmethod
  is '计算方式标识 01全部损失/02部分损失';
-- Create/Recreate indexes 
create unique index GYIC.PK_PRPLFORMULA on GYIC.PRPLCONFIGURATION (ID)

--条款公式配置项配置表
-- Create table
create table GYIC.PRPLFORMULACONFIG
(
  id                   VARCHAR2(10) not null,
  classcode            VARCHAR2(3),
  riskcode             VARCHAR2(4),
  configcode           VARCHAR2(20),
  configdescribing     VARCHAR2(200),
  configurationrange   VARCHAR2(1),
  configurationtype    VARCHAR2(1),
  configurationcontent VARCHAR2(2000),
  reserve1             VARCHAR2(10),
  reserve2             VARCHAR2(10),
  reserve3             VARCHAR2(10),
  reserve4             VARCHAR2(10),
  reserve5             VARCHAR2(10),
  reserve6             VARCHAR2(10),
  reserve7             VARCHAR2(10),
  updatedtime          DATE,
  updatedby            VARCHAR2(20),
  createdtime          DATE,
  createdby            VARCHAR2(20)
);

-- Add comments to the table 
comment on table GYIC.PRPLFORMULACONFIG
  is '条款公式配置项配置表';
-- Add comments to the columns 
comment on column GYIC.PRPLFORMULACONFIG.id
  is '序号，唯一标识';
comment on column GYIC.PRPLFORMULACONFIG.classcode
  is '险种';
comment on column GYIC.PRPLFORMULACONFIG.riskcode
  is '险类';
comment on column GYIC.PRPLFORMULACONFIG.configcode
  is '配置项代码';
comment on column GYIC.PRPLFORMULACONFIG.configdescribing
  is '配置项说明';
comment on column GYIC.PRPLFORMULACONFIG.configurationrange
  is '配置范围  H汇总计算  F分开计算';
comment on column GYIC.PRPLFORMULACONFIG.configurationtype
  is '取值方式  0直接取值  1通过SQL取值';
comment on column GYIC.PRPLFORMULACONFIG.configurationcontent
  is '取值内容';
comment on column GYIC.PRPLFORMULACONFIG.reserve1
  is '备用字段 ';
comment on column GYIC.PRPLFORMULACONFIG.reserve2
  is '备用字段 ';
comment on column GYIC.PRPLFORMULACONFIG.reserve3
  is '备用字段 ';
comment on column GYIC.PRPLFORMULACONFIG.reserve4
  is '备用字段 ';
comment on column GYIC.PRPLFORMULACONFIG.reserve5
  is '备用字段 ';
comment on column GYIC.PRPLFORMULACONFIG.reserve6
  is '备用字段 ';
comment on column GYIC.PRPLFORMULACONFIG.reserve7
  is '备用字段 ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.PRPLFORMULACONFIG
  add constraint PK_PRPLFORMULACONFIG22 primary key (ID)
 
--新增字段开始
--prplrecase
alter table prplrecase add (nodeno number);

alter table prplrecase add (COMPENSATENO varchar2(25));
--swflog      systemflag  新老系统标识，dataflag标志
alter table swflog add (claimNo varchar2(25));
alter table swflog add (systemflag VARCHAR2(4));
--swflogStore
alter TABLe swflogStore add (claimNo varchar2(25));
alter table swflogstore add (systemflag varchar2(4));
--SwfModelUse  
--alter table SwfModelUse ADD (systemflag varchar2(4));

--prplclaim
ALTER TABLE prplclaim ADD(
      damageWay VARCHAR2(10),
      damageDegree VARCHAR2(10));
comment on column prplclaim.damageWay is '出险方式';
comment on column prplclaim.damageDegree is '溃塘程度/漫塘时间';
alter table prplclaim add growthperiod  varchar2(2);
--prplcompensate
ALTER TABLE prplcompensate ADD(
      damageWay VARCHAR2(10),
      damageDegree VARCHAR2(10));
comment on column prplcompensate.damageWay is '出险方式';
comment on column prplcompensate.damageDegree is '溃塘程度/漫塘时间';
ALTER TABLE prpLCompensate ADD(registno VARCHAR2(22));
comment on column prpLCompensate.registno is '报案号';  

alter table prplpaymain add (cancelFlag varchar2(2));
--新增字段结束

--字段长度加长开始
--PRPLAUTOCLAIMLIST
alter table PRPLAUTOCLAIMLIST modify (billno varchar2(29));
--prplclaimloss
alter table prplclaimloss modify (kindcode varchar2(20));
alter table prplclaimloss modify (itemcode varchar2(20));
--PRPLCTEXT 
ALTER TABLE PRPLCTEXT modify(context VARCHAR2(200));
--PRPLLTEXT 
ALTER TABLE PRPLLTEXT modify(context VARCHAR2(200));
--prpldangeritem 
alter table prpldangeritem modify (kindcode varchar2(8));
--prpldangerunit 
ALTER TABLE prpldangerunit modify(businesstown VARCHAR2(20));
--字段长度加长结束

-- Create table
create table PRPLAUTOCLAIMLIST
(
  policyno      VARCHAR2(22),
  registno      VARCHAR2(22) not null,
  claimno       VARCHAR2(22),
  flowid        VARCHAR2(22),
  nodeno        NUMBER,
  nodename      VARCHAR2(100),
  nodestartflag VARCHAR2(1),
  billno        VARCHAR2(29),
  autoflag      VARCHAR2(1),
  finishflag    VARCHAR2(1),
  falsereason   VARCHAR2(100),
  remark1       VARCHAR2(50),
  remark2       VARCHAR2(50),
  riskcode      VARCHAR2(4),
  createdby     VARCHAR2(20),
  createdtime   DATE,
  updatedby     VARCHAR2(20),
  updatedtime   DATE
);
-- Add comments to the table 
comment on table PRPLAUTOCLAIMLIST
  is '自动理赔清单数据表';
-- Add comments to the columns 
comment on column  PRPLAUTOCLAIMLIST.policyno
  is '保单号        ';
comment on column  PRPLAUTOCLAIMLIST.registno
  is '报案号        ';
comment on column  PRPLAUTOCLAIMLIST.claimno
  is '立案号        ';
comment on column  PRPLAUTOCLAIMLIST.flowid
  is '流程编号      ';
comment on column  PRPLAUTOCLAIMLIST.nodeno
  is '流入节点号    ';
comment on column  PRPLAUTOCLAIMLIST.nodename
  is '流入节点名称  ';
comment on column  PRPLAUTOCLAIMLIST.nodestartflag
  is '节点开始标志  ';
comment on column  PRPLAUTOCLAIMLIST.billno
  is '定损清单清单号';
comment on column  PRPLAUTOCLAIMLIST.autoflag
  is '是否自动理赔,0为不进行自动理赔（预留给可以不进行自动理赔功能）';
comment on column  PRPLAUTOCLAIMLIST.finishflag
  is '自动理赔是否完成(1完成,0失败)';
comment on column  PRPLAUTOCLAIMLIST.falsereason
  is '自动理赔失败原因';
comment on column  PRPLAUTOCLAIMLIST.remark1
  is '预留字段1     ';
comment on column  PRPLAUTOCLAIMLIST.remark2
  is '预留字段2     ';
comment on column  PRPLAUTOCLAIMLIST.riskcode
  is '险种代码      ';
comment on column  PRPLAUTOCLAIMLIST.createdby
  is '创建人        ';
comment on column  PRPLAUTOCLAIMLIST.createdtime
  is '创建时间      ';
comment on column  PRPLAUTOCLAIMLIST.updatedby
  is '更新人        ';
comment on column  PRPLAUTOCLAIMLIST.updatedtime
  is '更新时间      ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table  PRPLAUTOCLAIMLIST
  add constraint PK_LAUTO primary key (REGISTNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

create table GYIC.PRPDRISKCONFIGAGRI
(
  comcode         VARCHAR2(10) not null,
  riskcode        VARCHAR2(4) not null,
  configcode      VARCHAR2(60) not null,
  configname      VARCHAR2(120) not null,
  configvalue     VARCHAR2(60) not null,
  configvaluedesc VARCHAR2(255),
  createdby       VARCHAR2(20),
  createdtime     DATE,
  updatedby       VARCHAR2(20),
  updatedtime     DATE
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.PRPDRISKCONFIGAGRI
  add constraint PK_PRPDRISKCONFIGAGRI primary key (COMCODE, RISKCODE, CONFIGCODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 576K
    next 1M
    minextents 1
    maxextents unlimited
  );
  --PrpLregist 新加字段存标的代码
  alter table PrpLregist add losscode varchar2(10);
   comment on column PrpLregist.losscode
  is '标的代码';
 


