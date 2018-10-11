--�����ڱ�
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
  is '�����ڱ�';
-- Add comments to the columns 
comment on column GYIC.PRPLGROWTH.riskcode
  is '���ִ���';
comment on column GYIC.PRPLGROWTH.clausecode
  is '�������';
comment on column GYIC.PRPLGROWTH.itemcode
  is '��Ĵ���';
comment on column GYIC.PRPLGROWTH.kindcode
  is '�ձ����';
comment on column GYIC.PRPLGROWTH.growthname
  is '����������';
comment on column GYIC.PRPLGROWTH.growthcode
  is '�����ڴ���';
comment on column GYIC.PRPLGROWTH.flag
  is '��Ч��ʶ';
comment on column GYIC.PRPLGROWTH.paystandard
  is '�⳥��׼';
comment on column GYIC.PRPLGROWTH.createdby
  is '������';
comment on column GYIC.PRPLGROWTH.createdtime
  is '����ʱ��';
comment on column GYIC.PRPLGROWTH.updatedby
  is '������';
comment on column GYIC.PRPLGROWTH.updatedtime
  is '����ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.PRPLGROWTH
  add constraint PK_PRPLGROWTH primary key (RISKCODE, CLAUSECODE, ITEMCODE, KINDCODE, GROWTHCODE, FLAG)

--�������̱�
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
  is '�������̱�';
-- Add comments to the columns 
comment on column GYIC.WORKPROCESS.registno
  is '������';
comment on column GYIC.WORKPROCESS.policyno
  is '������';
comment on column GYIC.WORKPROCESS.claimno
  is '������';
comment on column GYIC.WORKPROCESS.compensateno
  is '���������';
comment on column GYIC.WORKPROCESS.caseno
  is '�᰸��';
comment on column GYIC.WORKPROCESS.flowid
  is '���̺�';
comment on column GYIC.WORKPROCESS.precompensateno
  is 'Ԥ���';
comment on column GYIC.WORKPROCESS.nodetype
  is '��ǰ�ڵ����';
comment on column GYIC.WORKPROCESS.nodename
  is '��ǰ�ڵ�';
comment on column GYIC.WORKPROCESS.nextnodetype
  is '��һ�ڵ����';
comment on column GYIC.WORKPROCESS.classcode
  is '���ִ���';
comment on column GYIC.WORKPROCESS.riskcode
  is '����';
comment on column GYIC.WORKPROCESS.nodestatus
  is '��ǰ״̬';
comment on column GYIC.WORKPROCESS.casetype
  is '����״̬';
comment on column GYIC.WORKPROCESS.registflowintime
  is '��������ʱ��';
comment on column GYIC.WORKPROCESS.flowintime
  is '���½ڵ�����ʱ��';
comment on column GYIC.WORKPROCESS.operator
  is '������';
comment on column GYIC.WORKPROCESS.operatedate
  is '����ʱ��';
comment on column GYIC.WORKPROCESS.createdby
  is '������';
comment on column GYIC.WORKPROCESS.createdtime
  is '����ʱ��';
comment on column GYIC.WORKPROCESS.updatedby
  is '������';
comment on column GYIC.WORKPROCESS.updatedtime
  is '����ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.WORKPROCESS
  add constraint PK_WORKPROCESS primary key (ID, REGISTNO)

--���ʽ���ñ�
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
  is '���ʽ���ñ�';
-- Add comments to the columns 
comment on column GYIC.PRPLCONFIGURATION.id
  is '��ţ�Ψһ��ʶ';
comment on column GYIC.PRPLCONFIGURATION.classcode
  is '����';
comment on column GYIC.PRPLCONFIGURATION.riskcode
  is '����';
comment on column GYIC.PRPLCONFIGURATION.clausenumber
  is '������';
comment on column GYIC.PRPLCONFIGURATION.formuladescribing
  is '��ʽ��������';
comment on column GYIC.PRPLCONFIGURATION.formula
  is '���㹫ʽ';
comment on column GYIC.PRPLCONFIGURATION.reserve1
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve2
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve3
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve4
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve5
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve6
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve7
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.kindcode
  is '�ձ����';
comment on column GYIC.PRPLCONFIGURATION.itemcode
  is '��Ĵ���';
comment on column GYIC.PRPLCONFIGURATION.calculationmethod
  is '���㷽ʽ��ʶ 01ȫ����ʧ/02������ʧ';
-- Create/Recreate indexes 
create unique index GYIC.PK_PRPLFORMULA on GYIC.PRPLCONFIGURATION (ID)

--���ʽ���������ñ�
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
  is '���ʽ���������ñ�';
-- Add comments to the columns 
comment on column GYIC.PRPLFORMULACONFIG.id
  is '��ţ�Ψһ��ʶ';
comment on column GYIC.PRPLFORMULACONFIG.classcode
  is '����';
comment on column GYIC.PRPLFORMULACONFIG.riskcode
  is '����';
comment on column GYIC.PRPLFORMULACONFIG.configcode
  is '���������';
comment on column GYIC.PRPLFORMULACONFIG.configdescribing
  is '������˵��';
comment on column GYIC.PRPLFORMULACONFIG.configurationrange
  is '���÷�Χ  H���ܼ���  F�ֿ�����';
comment on column GYIC.PRPLFORMULACONFIG.configurationtype
  is 'ȡֵ��ʽ  0ֱ��ȡֵ  1ͨ��SQLȡֵ';
comment on column GYIC.PRPLFORMULACONFIG.configurationcontent
  is 'ȡֵ����';
comment on column GYIC.PRPLFORMULACONFIG.reserve1
  is '�����ֶ� ';
comment on column GYIC.PRPLFORMULACONFIG.reserve2
  is '�����ֶ� ';
comment on column GYIC.PRPLFORMULACONFIG.reserve3
  is '�����ֶ� ';
comment on column GYIC.PRPLFORMULACONFIG.reserve4
  is '�����ֶ� ';
comment on column GYIC.PRPLFORMULACONFIG.reserve5
  is '�����ֶ� ';
comment on column GYIC.PRPLFORMULACONFIG.reserve6
  is '�����ֶ� ';
comment on column GYIC.PRPLFORMULACONFIG.reserve7
  is '�����ֶ� ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.PRPLFORMULACONFIG
  add constraint PK_PRPLFORMULACONFIG22 primary key (ID)
 
--�����ֶο�ʼ
--prplrecase
alter table prplrecase add (nodeno number);

alter table prplrecase add (COMPENSATENO varchar2(25));
--swflog      systemflag  ����ϵͳ��ʶ��dataflag��־
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
comment on column prplclaim.damageWay is '���շ�ʽ';
comment on column prplclaim.damageDegree is '�����̶�/����ʱ��';
alter table prplclaim add growthperiod  varchar2(2);
--prplcompensate
ALTER TABLE prplcompensate ADD(
      damageWay VARCHAR2(10),
      damageDegree VARCHAR2(10));
comment on column prplcompensate.damageWay is '���շ�ʽ';
comment on column prplcompensate.damageDegree is '�����̶�/����ʱ��';
ALTER TABLE prpLCompensate ADD(registno VARCHAR2(22));
comment on column prpLCompensate.registno is '������';  

alter table prplpaymain add (cancelFlag varchar2(2));
--�����ֶν���

--�ֶγ��ȼӳ���ʼ
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
--�ֶγ��ȼӳ�����

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
  is '�Զ������嵥���ݱ�';
-- Add comments to the columns 
comment on column  PRPLAUTOCLAIMLIST.policyno
  is '������        ';
comment on column  PRPLAUTOCLAIMLIST.registno
  is '������        ';
comment on column  PRPLAUTOCLAIMLIST.claimno
  is '������        ';
comment on column  PRPLAUTOCLAIMLIST.flowid
  is '���̱��      ';
comment on column  PRPLAUTOCLAIMLIST.nodeno
  is '����ڵ��    ';
comment on column  PRPLAUTOCLAIMLIST.nodename
  is '����ڵ�����  ';
comment on column  PRPLAUTOCLAIMLIST.nodestartflag
  is '�ڵ㿪ʼ��־  ';
comment on column  PRPLAUTOCLAIMLIST.billno
  is '�����嵥�嵥��';
comment on column  PRPLAUTOCLAIMLIST.autoflag
  is '�Ƿ��Զ�����,0Ϊ�������Զ����⣨Ԥ�������Բ������Զ����⹦�ܣ�';
comment on column  PRPLAUTOCLAIMLIST.finishflag
  is '�Զ������Ƿ����(1���,0ʧ��)';
comment on column  PRPLAUTOCLAIMLIST.falsereason
  is '�Զ�����ʧ��ԭ��';
comment on column  PRPLAUTOCLAIMLIST.remark1
  is 'Ԥ���ֶ�1     ';
comment on column  PRPLAUTOCLAIMLIST.remark2
  is 'Ԥ���ֶ�2     ';
comment on column  PRPLAUTOCLAIMLIST.riskcode
  is '���ִ���      ';
comment on column  PRPLAUTOCLAIMLIST.createdby
  is '������        ';
comment on column  PRPLAUTOCLAIMLIST.createdtime
  is '����ʱ��      ';
comment on column  PRPLAUTOCLAIMLIST.updatedby
  is '������        ';
comment on column  PRPLAUTOCLAIMLIST.updatedtime
  is '����ʱ��      ';
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
  --PrpLregist �¼��ֶδ��Ĵ���
  alter table PrpLregist add losscode varchar2(10);
   comment on column PrpLregist.losscode
  is '��Ĵ���';
 


