--定损清单农户标的明细表
create table TXNLIST.LOSSRATEHERDLIST
(
  losslistcode VARCHAR2(29) not null,
  serialno     NUMBER not null,
  fcode        VARCHAR2(25) not null,
  itemcode     VARCHAR2(20) not null,
  lossserialno NUMBER not null,
  earlabel     VARCHAR2(20) not null,
  createdby    VARCHAR2(20),
  createdtime  DATE,
  updatedby    VARCHAR2(20),
  updatedtime  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.LOSSRATEHERDLIST
  is '定损清单农户标的明细表-物（针对养殖险：物,耳标/脚环号）';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEHERDLIST.losslistcode
  is '清单编号';
comment on column TXNLIST.LOSSRATEHERDLIST.serialno
  is '序列号	考虑同一清单有多次批改但清单号不变的情况，增加序列号加以区分';
comment on column TXNLIST.LOSSRATEHERDLIST.fcode
  is '农户代码';
comment on column TXNLIST.LOSSRATEHERDLIST.itemcode
  is '标的代码';
comment on column TXNLIST.LOSSRATEHERDLIST.lossserialno
  is '损失序列号';
comment on column TXNLIST.LOSSRATEHERDLIST.earlabel
  is '耳标号';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.LOSSRATEHERDLIST
  add constraint PK_LOSSRATEHERDLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE, LOSSSERIALNO, EARLABEL)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--定损清单主表
create table TXNLIST.LOSSRATEMAINLIST
(
  losslistcode     VARCHAR2(29) not null,
  serialno         NUMBER not null,
  bizno            VARCHAR2(29),
  policyno         VARCHAR2(22),
  listcreatetime   DATE,
  opcode           VARCHAR2(10),
  opname           VARCHAR2(20),
  listaffirmtime   DATE,
  affirmopcode     VARCHAR2(10),
  affirmopname     VARCHAR2(20),
  createdby        VARCHAR2(20),
  createdtime      DATE,
  updatedby        VARCHAR2(20),
  updatedtime      DATE,
  explorearea      VARCHAR2(50),
  exploretime      DATE,
  remark           VARCHAR2(100),
  checkboxflag     VARCHAR2(1),
  origin           VARCHAR2(1),
  nodeorigin       VARCHAR2(5),
  checkid          VARCHAR2(30),
  disasterarea     NUMBER(10,2),
  affectedarea     NUMBER(10,2),
  noproductionarea NUMBER(10,2),
  deathquantity    NUMBER(10,2),
  killquantity     NUMBER(10,2),
  checkcontext     VARCHAR2(1100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.LOSSRATEMAINLIST
  is '定损清单主表';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEMAINLIST.losslistcode
  is '理赔损失清单编号';
comment on column TXNLIST.LOSSRATEMAINLIST.serialno
  is '序列号 考虑同一清单有多次修改但清单号不变的情况，增加序列号加以区分';
comment on column TXNLIST.LOSSRATEMAINLIST.bizno
  is '业务单号  保单号/报案号/立案号';
comment on column TXNLIST.LOSSRATEMAINLIST.policyno
  is '保单号 保单号';
comment on column TXNLIST.LOSSRATEMAINLIST.listcreatetime
  is '清单缮制时间';
comment on column TXNLIST.LOSSRATEMAINLIST.opcode
  is '清单缮制人工号';
comment on column TXNLIST.LOSSRATEMAINLIST.opname
  is '清单缮制人姓名';
comment on column TXNLIST.LOSSRATEMAINLIST.listaffirmtime
  is '清单最终确认时间';
comment on column TXNLIST.LOSSRATEMAINLIST.affirmopcode
  is '清单最终确认人代码';
comment on column TXNLIST.LOSSRATEMAINLIST.affirmopname
  is '清单最终确认人姓名';
comment on column TXNLIST.LOSSRATEMAINLIST.remark
  is '备注';
comment on column TXNLIST.LOSSRATEMAINLIST.origin
  is '数据来源：0 金禾导入，1 手工导入';
comment on column TXNLIST.LOSSRATEMAINLIST.nodeorigin
  is '导入来源节点';
comment on column TXNLIST.LOSSRATEMAINLIST.checkid
  is '查勘编号';
comment on column TXNLIST.LOSSRATEMAINLIST.disasterarea
  is '受灾面积';
comment on column TXNLIST.LOSSRATEMAINLIST.affectedarea
  is '成灾面积';
comment on column TXNLIST.LOSSRATEMAINLIST.noproductionarea
  is '绝产面积';
comment on column TXNLIST.LOSSRATEMAINLIST.deathquantity
  is '死亡数量';
comment on column TXNLIST.LOSSRATEMAINLIST.killquantity
  is '扑杀数量';
comment on column TXNLIST.LOSSRATEMAINLIST.checkcontext
  is '查勘报告';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.LOSSRATEMAINLIST
  add constraint PK_LOSSRATEMAINLIST primary key (LOSSLISTCODE, SERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--定损清单标的表
create table TXNLIST.LOSSRATEITEMLIST
(
  losslistcode VARCHAR2(29) not null,
  serialno     NUMBER not null,
  fcode        VARCHAR2(25) not null,
  fname        VARCHAR2(50),
  fidtype      VARCHAR2(2),
  fidcard      VARCHAR2(20),
  itemcode     VARCHAR2(20) not null,
  itemtype     VARCHAR2(10),
  itemname     VARCHAR2(100),
  createdby    VARCHAR2(20),
  createdtime  DATE,
  updatedby    VARCHAR2(20),
  updatedtime  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.LOSSRATEITEMLIST
  is '定损清单标的表';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEITEMLIST.losslistcode
  is '理赔损失清单编号';
comment on column TXNLIST.LOSSRATEITEMLIST.serialno
  is '序列号 考虑同一清单有多次修改但清单号不变的情况，增加序列号加以区分';
comment on column TXNLIST.LOSSRATEITEMLIST.fcode
  is '农户代码';
comment on column TXNLIST.LOSSRATEITEMLIST.fname
  is '农户姓名';
comment on column TXNLIST.LOSSRATEITEMLIST.fidtype
  is '证件类型';
comment on column TXNLIST.LOSSRATEITEMLIST.fidcard
  is '证件号码';
comment on column TXNLIST.LOSSRATEITEMLIST.itemcode
  is '标的代码';
comment on column TXNLIST.LOSSRATEITEMLIST.itemtype
  is '标的类型';
comment on column TXNLIST.LOSSRATEITEMLIST.itemname
  is '标的名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.LOSSRATEITEMLIST
  add constraint PK_LOSSRATEITEMLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--定损清单农户标的清单表
create table TXNLIST.LOSSRATELOSSLIST
(
  losslistcode VARCHAR2(29) not null,
  serialno     NUMBER not null,
  fcode        VARCHAR2(25) not null,
  itemcode     VARCHAR2(20) not null,
  lossserialno NUMBER not null,
  lossrate     NUMBER(10,4),
  lossamount   NUMBER(10,4),
  lossmoney    NUMBER(10,2),
  createdby    VARCHAR2(20),
  createdtime  DATE,
  updatedby    VARCHAR2(20),
  updatedtime  DATE,
  fieldcode    VARCHAR2(19),
  versionno    VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.LOSSRATELOSSLIST
  is '定损清单农户标的清单表';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATELOSSLIST.losslistcode
  is '理赔损失清单编号';
comment on column TXNLIST.LOSSRATELOSSLIST.serialno
  is '序列号 考虑同一清单有多次修改但清单号不变的情况，增加序列号加以区分';
comment on column TXNLIST.LOSSRATELOSSLIST.fcode
  is '农户代码';
comment on column TXNLIST.LOSSRATELOSSLIST.itemcode
  is '标的代码';
comment on column TXNLIST.LOSSRATELOSSLIST.lossserialno
  is '损失序列号';
comment on column TXNLIST.LOSSRATELOSSLIST.lossrate
  is '损失率';
comment on column TXNLIST.LOSSRATELOSSLIST.lossamount
  is '损失数量';
comment on column TXNLIST.LOSSRATELOSSLIST.lossmoney
  is '损失金额';
comment on column TXNLIST.LOSSRATELOSSLIST.fieldcode
  is '田块代码';
comment on column TXNLIST.LOSSRATELOSSLIST.versionno
  is '贷款合同编号';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.LOSSRATELOSSLIST
  add constraint PK_LOSSRATELOSSLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE, LOSSSERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--定损清单农户标的明细表-人
create table TXNLIST.LOSSRATEPERSLIST
(
  losslistcode VARCHAR2(29) not null,
  serialno     NUMBER not null,
  fcode        VARCHAR2(25) not null,
  itemcode     VARCHAR2(20) not null,
  lossserialno NUMBER not null,
  idtype       VARCHAR2(2),
  idcard       VARCHAR2(20) not null,
  name         VARCHAR2(50),
  sex          VARCHAR2(10),
  relation     VARCHAR2(50),
  createdby    VARCHAR2(20),
  createdtime  DATE,
  updatedby    VARCHAR2(20),
  updatedtime  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.LOSSRATEPERSLIST
  is '定损清单农户标的明细表-人（针对种植组合险：标的是连带被保险人的意外、健康）';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEPERSLIST.losslistcode
  is '清单编号';
comment on column TXNLIST.LOSSRATEPERSLIST.serialno
  is '序列号  考虑同一清单有多次批改但清单号不变的情况，增加序列号加以区分';
comment on column TXNLIST.LOSSRATEPERSLIST.fcode
  is '农户代码';
comment on column TXNLIST.LOSSRATEPERSLIST.itemcode
  is '标的代码';
comment on column TXNLIST.LOSSRATEPERSLIST.lossserialno
  is '损失序列号';
comment on column TXNLIST.LOSSRATEPERSLIST.idtype
  is '证件类型 连带被保险人的证件类型';
comment on column TXNLIST.LOSSRATEPERSLIST.idcard
  is '证件号码 连带被保险人的证件号码';
comment on column TXNLIST.LOSSRATEPERSLIST.name
  is '姓名 连带被保险人的姓名';
comment on column TXNLIST.LOSSRATEPERSLIST.sex
  is '性别 连带被保险人的性别';
comment on column TXNLIST.LOSSRATEPERSLIST.relation
  is '与农户关系  连带被保险人与农户的关系：配偶；子女；父母；其他等';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.LOSSRATEPERSLIST
  add constraint PK_LOSSRATEPERSLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE, LOSSSERIALNO, IDCARD)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--种植险理赔清单表
create table TXNLIST.NYXPLANTINGCLAIMLIST
(
  listno          VARCHAR2(31) not null,
  serialno        VARCHAR2(21) not null,
  policyno        VARCHAR2(21) not null,
  registno        VARCHAR2(22) not null,
  compensateno    VARCHAR2(25),
  fcode           VARCHAR2(25) not null,
  fname           VARCHAR2(50),
  fidcard         VARCHAR2(20),
  phonenumber     VARCHAR2(21),
  remainingarea   NUMBER(10,4),
  claimriskcode   VARCHAR2(10),
  fieldsource     VARCHAR2(6),
  claimrate       NUMBER(10,4),
  lossarea        NUMBER(10,4),
  lossrate        NUMBER(10,4),
  settleamount    NUMBER(14,2),
  bankaccount     VARCHAR2(20),
  paytype         VARCHAR2(2),
  createdby       VARCHAR2(20),
  createdtime     DATE,
  updatedby       VARCHAR2(20),
  updatedtime     DATE,
  remainingamount NUMBER(10,4),
  itemcode        VARCHAR2(7),
  formula         VARCHAR2(500),
  nodetype        VARCHAR2(5),
  deductionamount VARCHAR2(20),
  claimno         VARCHAR2(22),
  name            VARCHAR2(30),
  no              VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.NYXPLANTINGCLAIMLIST
  is '理赔清单表';
-- Add comments to the columns 
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.listno
  is '理赔清单号';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.serialno
  is '序号';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.policyno
  is '保单号';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.registno
  is '报案号';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.compensateno
  is '计算书号';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fcode
  is '农户代码';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fname
  is '农户姓名';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fidcard
  is '身份证号码';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.phonenumber
  is '联系电话';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.remainingarea
  is '剩余面积';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.claimriskcode
  is '赔付险别代码';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fieldsource
  is '土地来源';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.claimrate
  is '赔付比例';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.lossarea
  is '受损面积';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.lossrate
  is '损失率';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.settleamount
  is '赔偿金额';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.bankaccount
  is '银行账号';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.paytype
  is '赔付类型 01-预赔';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.remainingamount
  is '剩余保额';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.itemcode
  is '标的号码';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.nodetype
  is '节点类型';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.deductionamount
  is '扣除金额';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.claimno
  is '立案号';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.name
  is '连带被保险人姓名';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.no
  is '合同编号';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.NYXPLANTINGCLAIMLIST
  add constraint PK_NYXPLANTINGCLAIMLIST primary key (LISTNO, SERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--养殖险理赔清单表
create table TXNLIST.NYXBREEDCLAIMLIST
(
  listno          VARCHAR2(31) not null,
  serialno        VARCHAR2(21) not null,
  policyno        VARCHAR2(21) not null,
  registno        VARCHAR2(22) not null,
  compensateno    VARCHAR2(25),
  fcode           VARCHAR2(25) not null,
  fname           VARCHAR2(50),
  fidcard         VARCHAR2(20),
  phonenumber     VARCHAR2(21),
  bankaccount     VARCHAR2(20),
  earconno        VARCHAR2(50),
  payamount       NUMBER(10,4),
  paytype         VARCHAR2(2),
  createdby       VARCHAR2(20),
  createdtime     DATE,
  updatedby       VARCHAR2(20),
  updatedtime     DATE,
  itemcode        VARCHAR2(7),
  nodetype        VARCHAR2(5),
  formula         VARCHAR2(500),
  deductionamount VARCHAR2(20),
  claimriskcode   VARCHAR2(20),
  claimno         VARCHAR2(22)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.NYXBREEDCLAIMLIST
  is '理赔清单表';
-- Add comments to the columns 
comment on column TXNLIST.NYXBREEDCLAIMLIST.listno
  is '理赔清单号';
comment on column TXNLIST.NYXBREEDCLAIMLIST.serialno
  is '序号';
comment on column TXNLIST.NYXBREEDCLAIMLIST.policyno
  is '保单号';
comment on column TXNLIST.NYXBREEDCLAIMLIST.registno
  is '报案号';
comment on column TXNLIST.NYXBREEDCLAIMLIST.compensateno
  is '计算书号';
comment on column TXNLIST.NYXBREEDCLAIMLIST.fcode
  is '农户代码';
comment on column TXNLIST.NYXBREEDCLAIMLIST.fname
  is '农户姓名';
comment on column TXNLIST.NYXBREEDCLAIMLIST.fidcard
  is '身份证号码';
comment on column TXNLIST.NYXBREEDCLAIMLIST.phonenumber
  is '联系电话';
comment on column TXNLIST.NYXBREEDCLAIMLIST.bankaccount
  is '银行账号';
comment on column TXNLIST.NYXBREEDCLAIMLIST.paytype
  is '赔付类型 Y-预赔;C-实赔';
comment on column TXNLIST.NYXBREEDCLAIMLIST.itemcode
  is '标的号码';
comment on column TXNLIST.NYXBREEDCLAIMLIST.nodetype
  is '节点类型';
comment on column TXNLIST.NYXBREEDCLAIMLIST.formula
  is '计算公式';
comment on column TXNLIST.NYXBREEDCLAIMLIST.deductionamount
  is '扣除金额';
comment on column TXNLIST.NYXBREEDCLAIMLIST.claimriskcode
  is '赔付险别';
comment on column TXNLIST.NYXBREEDCLAIMLIST.claimno
  is '立案号';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.NYXBREEDCLAIMLIST
  add constraint PK_NYXBREEDCLAIMLIST primary key (LISTNO, SERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--预赔清单（特殊赔案）
create table TXNLIST.SPECCASELIST
(
  serialno        VARCHAR2(22) not null,
  policyno        VARCHAR2(22),
  registno        VARCHAR2(22),
  claimno         VARCHAR2(22),
  precompensateno VARCHAR2(25),
  fcode           VARCHAR2(25),
  fname           VARCHAR2(50),
  receivertype    VARCHAR2(30),
  receivername    VARCHAR2(100),
  identifytype    VARCHAR2(30),
  identifynumber  VARCHAR2(30) not null,
  banktype        VARCHAR2(50),
  provincename    VARCHAR2(50),
  cityname        VARCHAR2(50),
  bankname        VARCHAR2(50),
  bankaccount     VARCHAR2(20),
  accountflag     VARCHAR2(5),
  accounttype     VARCHAR2(5),
  phonenumber     VARCHAR2(21),
  settletype      VARCHAR2(5),
  settleamount    NUMBER(14,2),
  createdby       VARCHAR2(20),
  createdtime     DATE,
  updatedby       VARCHAR2(20),
  updatedtime     DATE,
  listno          VARCHAR2(31) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.SPECCASELIST
  is '特殊赔案清单表';
-- Add comments to the columns 
comment on column TXNLIST.SPECCASELIST.serialno
  is '序号';
comment on column TXNLIST.SPECCASELIST.policyno
  is '保单号';
comment on column TXNLIST.SPECCASELIST.registno
  is '报案号';
comment on column TXNLIST.SPECCASELIST.claimno
  is '立案号';
comment on column TXNLIST.SPECCASELIST.precompensateno
  is '预赔单号';
comment on column TXNLIST.SPECCASELIST.fcode
  is '农户代码';
comment on column TXNLIST.SPECCASELIST.fname
  is '农户姓名';
comment on column TXNLIST.SPECCASELIST.receivertype
  is '领款人类型';
comment on column TXNLIST.SPECCASELIST.receivername
  is '领款人名称(银行账户名称)';
comment on column TXNLIST.SPECCASELIST.identifytype
  is '领款人证件类型';
comment on column TXNLIST.SPECCASELIST.identifynumber
  is '领款人证件号';
comment on column TXNLIST.SPECCASELIST.banktype
  is '开户银行大类';
comment on column TXNLIST.SPECCASELIST.provincename
  is '开户银行所在省份名称';
comment on column TXNLIST.SPECCASELIST.cityname
  is '开户银行所在城市名称';
comment on column TXNLIST.SPECCASELIST.bankname
  is '开户银行名称';
comment on column TXNLIST.SPECCASELIST.bankaccount
  is '银行账号';
comment on column TXNLIST.SPECCASELIST.accountflag
  is '账号属性01-对私账号；02-对公账号';
comment on column TXNLIST.SPECCASELIST.accounttype
  is '账号类型01-银行卡；02-存折';
comment on column TXNLIST.SPECCASELIST.phonenumber
  is '领款人手机号';
comment on column TXNLIST.SPECCASELIST.settletype
  is '赔款类型';
comment on column TXNLIST.SPECCASELIST.settleamount
  is '赔款金额(元)';
comment on column TXNLIST.SPECCASELIST.createdby
  is '创建人';
comment on column TXNLIST.SPECCASELIST.createdtime
  is '创建时间';
comment on column TXNLIST.SPECCASELIST.updatedby
  is '更新人';
comment on column TXNLIST.SPECCASELIST.updatedtime
  is '更新时间';
comment on column TXNLIST.SPECCASELIST.listno
  is '清单号';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.SPECCASELIST
  add constraint PK_PRELISTNO_SERIALNO primary key (SERIALNO, LISTNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
--支付清单
create table TXNLIST.NYXCLAIMPAYLIST
(
  listno         VARCHAR2(31) not null,
  policyno       VARCHAR2(21) not null,
  registno       VARCHAR2(22) not null,
  claimno        VARCHAR2(22) not null,
  compensateno   VARCHAR2(25),
  receivertype   VARCHAR2(30),
  receivername   VARCHAR2(100),
  identifytype   VARCHAR2(30),
  identifynumber VARCHAR2(30) not null,
  banktype       VARCHAR2(50),
  provincename   VARCHAR2(50),
  cityname       VARCHAR2(50),
  bankname       VARCHAR2(50),
  bankaccount    VARCHAR2(20),
  accountflag    VARCHAR2(5),
  accounttype    VARCHAR2(5),
  phonenumber    VARCHAR2(21),
  settleamount   NUMBER(14,2),
  fcode          VARCHAR2(25),
  fname          VARCHAR2(50),
  createdby      VARCHAR2(20),
  createdtime    DATE,
  updatedby      VARCHAR2(20),
  updatedtime    DATE,
  settletype     VARCHAR2(5),
  serialno       VARCHAR2(25) not null,
  paymentno      VARCHAR2(25)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TXNLIST.NYXCLAIMPAYLIST
  is '理赔支付清单表';
-- Add comments to the columns 
comment on column TXNLIST.NYXCLAIMPAYLIST.listno
  is '理赔支付清单号';
comment on column TXNLIST.NYXCLAIMPAYLIST.policyno
  is '保单号';
comment on column TXNLIST.NYXCLAIMPAYLIST.registno
  is '报案号';
comment on column TXNLIST.NYXCLAIMPAYLIST.claimno
  is '立案号';
comment on column TXNLIST.NYXCLAIMPAYLIST.compensateno
  is '计算书号';
comment on column TXNLIST.NYXCLAIMPAYLIST.receivertype
  is '领款人类型';
comment on column TXNLIST.NYXCLAIMPAYLIST.receivername
  is '领款人名称';
comment on column TXNLIST.NYXCLAIMPAYLIST.identifytype
  is '领款人证件类型';
comment on column TXNLIST.NYXCLAIMPAYLIST.identifynumber
  is '领款人证件号';
comment on column TXNLIST.NYXCLAIMPAYLIST.banktype
  is '开户银行大类';
comment on column TXNLIST.NYXCLAIMPAYLIST.provincename
  is '开户银行所在省份名称';
comment on column TXNLIST.NYXCLAIMPAYLIST.cityname
  is '开户银行所在城市名称';
comment on column TXNLIST.NYXCLAIMPAYLIST.bankname
  is '开户银行名称';
comment on column TXNLIST.NYXCLAIMPAYLIST.bankaccount
  is '银行账号';
comment on column TXNLIST.NYXCLAIMPAYLIST.accountflag
  is '账号类型00-银行卡；01-存折;03-对公账户';
comment on column TXNLIST.NYXCLAIMPAYLIST.accounttype
  is '账号属性1-对私账号；2-对公账号';
comment on column TXNLIST.NYXCLAIMPAYLIST.phonenumber
  is '领款人手机号';
comment on column TXNLIST.NYXCLAIMPAYLIST.settleamount
  is '赔款金额';
comment on column TXNLIST.NYXCLAIMPAYLIST.fcode
  is '农户代码';
comment on column TXNLIST.NYXCLAIMPAYLIST.fname
  is '农户姓名';
comment on column TXNLIST.NYXCLAIMPAYLIST.settletype
  is '赔款类型';
comment on column TXNLIST.NYXCLAIMPAYLIST.serialno
  is '序号';
comment on column TXNLIST.NYXCLAIMPAYLIST.paymentno
  is '收付编号';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TXNLIST.NYXCLAIMPAYLIST
  add constraint PK_LISTNO_SERIALNO primary key (LISTNO, SERIALNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );