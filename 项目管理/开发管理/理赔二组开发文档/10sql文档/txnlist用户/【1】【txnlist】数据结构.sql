--�����嵥ũ�������ϸ��
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
  is '�����嵥ũ�������ϸ��-������ֳ�գ���,����/�Ż��ţ�';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEHERDLIST.losslistcode
  is '�嵥���';
comment on column TXNLIST.LOSSRATEHERDLIST.serialno
  is '���к�	����ͬһ�嵥�ж�����ĵ��嵥�Ų����������������кż�������';
comment on column TXNLIST.LOSSRATEHERDLIST.fcode
  is 'ũ������';
comment on column TXNLIST.LOSSRATEHERDLIST.itemcode
  is '��Ĵ���';
comment on column TXNLIST.LOSSRATEHERDLIST.lossserialno
  is '��ʧ���к�';
comment on column TXNLIST.LOSSRATEHERDLIST.earlabel
  is '�����';
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

--�����嵥����
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
  is '�����嵥����';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEMAINLIST.losslistcode
  is '������ʧ�嵥���';
comment on column TXNLIST.LOSSRATEMAINLIST.serialno
  is '���к� ����ͬһ�嵥�ж���޸ĵ��嵥�Ų����������������кż�������';
comment on column TXNLIST.LOSSRATEMAINLIST.bizno
  is 'ҵ�񵥺�  ������/������/������';
comment on column TXNLIST.LOSSRATEMAINLIST.policyno
  is '������ ������';
comment on column TXNLIST.LOSSRATEMAINLIST.listcreatetime
  is '�嵥����ʱ��';
comment on column TXNLIST.LOSSRATEMAINLIST.opcode
  is '�嵥�����˹���';
comment on column TXNLIST.LOSSRATEMAINLIST.opname
  is '�嵥����������';
comment on column TXNLIST.LOSSRATEMAINLIST.listaffirmtime
  is '�嵥����ȷ��ʱ��';
comment on column TXNLIST.LOSSRATEMAINLIST.affirmopcode
  is '�嵥����ȷ���˴���';
comment on column TXNLIST.LOSSRATEMAINLIST.affirmopname
  is '�嵥����ȷ��������';
comment on column TXNLIST.LOSSRATEMAINLIST.remark
  is '��ע';
comment on column TXNLIST.LOSSRATEMAINLIST.origin
  is '������Դ��0 ��̵��룬1 �ֹ�����';
comment on column TXNLIST.LOSSRATEMAINLIST.nodeorigin
  is '������Դ�ڵ�';
comment on column TXNLIST.LOSSRATEMAINLIST.checkid
  is '�鿱���';
comment on column TXNLIST.LOSSRATEMAINLIST.disasterarea
  is '�������';
comment on column TXNLIST.LOSSRATEMAINLIST.affectedarea
  is '�������';
comment on column TXNLIST.LOSSRATEMAINLIST.noproductionarea
  is '�������';
comment on column TXNLIST.LOSSRATEMAINLIST.deathquantity
  is '��������';
comment on column TXNLIST.LOSSRATEMAINLIST.killquantity
  is '��ɱ����';
comment on column TXNLIST.LOSSRATEMAINLIST.checkcontext
  is '�鿱����';
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

--�����嵥��ı�
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
  is '�����嵥��ı�';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEITEMLIST.losslistcode
  is '������ʧ�嵥���';
comment on column TXNLIST.LOSSRATEITEMLIST.serialno
  is '���к� ����ͬһ�嵥�ж���޸ĵ��嵥�Ų����������������кż�������';
comment on column TXNLIST.LOSSRATEITEMLIST.fcode
  is 'ũ������';
comment on column TXNLIST.LOSSRATEITEMLIST.fname
  is 'ũ������';
comment on column TXNLIST.LOSSRATEITEMLIST.fidtype
  is '֤������';
comment on column TXNLIST.LOSSRATEITEMLIST.fidcard
  is '֤������';
comment on column TXNLIST.LOSSRATEITEMLIST.itemcode
  is '��Ĵ���';
comment on column TXNLIST.LOSSRATEITEMLIST.itemtype
  is '�������';
comment on column TXNLIST.LOSSRATEITEMLIST.itemname
  is '�������';
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

--�����嵥ũ������嵥��
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
  is '�����嵥ũ������嵥��';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATELOSSLIST.losslistcode
  is '������ʧ�嵥���';
comment on column TXNLIST.LOSSRATELOSSLIST.serialno
  is '���к� ����ͬһ�嵥�ж���޸ĵ��嵥�Ų����������������кż�������';
comment on column TXNLIST.LOSSRATELOSSLIST.fcode
  is 'ũ������';
comment on column TXNLIST.LOSSRATELOSSLIST.itemcode
  is '��Ĵ���';
comment on column TXNLIST.LOSSRATELOSSLIST.lossserialno
  is '��ʧ���к�';
comment on column TXNLIST.LOSSRATELOSSLIST.lossrate
  is '��ʧ��';
comment on column TXNLIST.LOSSRATELOSSLIST.lossamount
  is '��ʧ����';
comment on column TXNLIST.LOSSRATELOSSLIST.lossmoney
  is '��ʧ���';
comment on column TXNLIST.LOSSRATELOSSLIST.fieldcode
  is '������';
comment on column TXNLIST.LOSSRATELOSSLIST.versionno
  is '�����ͬ���';
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

--�����嵥ũ�������ϸ��-��
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
  is '�����嵥ũ�������ϸ��-�ˣ������ֲ����գ�����������������˵����⡢������';
-- Add comments to the columns 
comment on column TXNLIST.LOSSRATEPERSLIST.losslistcode
  is '�嵥���';
comment on column TXNLIST.LOSSRATEPERSLIST.serialno
  is '���к�  ����ͬһ�嵥�ж�����ĵ��嵥�Ų����������������кż�������';
comment on column TXNLIST.LOSSRATEPERSLIST.fcode
  is 'ũ������';
comment on column TXNLIST.LOSSRATEPERSLIST.itemcode
  is '��Ĵ���';
comment on column TXNLIST.LOSSRATEPERSLIST.lossserialno
  is '��ʧ���к�';
comment on column TXNLIST.LOSSRATEPERSLIST.idtype
  is '֤������ �����������˵�֤������';
comment on column TXNLIST.LOSSRATEPERSLIST.idcard
  is '֤������ �����������˵�֤������';
comment on column TXNLIST.LOSSRATEPERSLIST.name
  is '���� �����������˵�����';
comment on column TXNLIST.LOSSRATEPERSLIST.sex
  is '�Ա� �����������˵��Ա�';
comment on column TXNLIST.LOSSRATEPERSLIST.relation
  is '��ũ����ϵ  ��������������ũ���Ĺ�ϵ����ż����Ů����ĸ��������';
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

--��ֲ�������嵥��
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
  is '�����嵥��';
-- Add comments to the columns 
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.listno
  is '�����嵥��';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.serialno
  is '���';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.policyno
  is '������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.registno
  is '������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.compensateno
  is '�������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fcode
  is 'ũ������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fname
  is 'ũ������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fidcard
  is '���֤����';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.phonenumber
  is '��ϵ�绰';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.remainingarea
  is 'ʣ�����';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.claimriskcode
  is '�⸶�ձ����';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.fieldsource
  is '������Դ';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.claimrate
  is '�⸶����';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.lossarea
  is '�������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.lossrate
  is '��ʧ��';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.settleamount
  is '�⳥���';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.bankaccount
  is '�����˺�';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.paytype
  is '�⸶���� 01-Ԥ��';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.remainingamount
  is 'ʣ�ౣ��';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.itemcode
  is '��ĺ���';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.nodetype
  is '�ڵ�����';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.deductionamount
  is '�۳����';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.claimno
  is '������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.name
  is '����������������';
comment on column TXNLIST.NYXPLANTINGCLAIMLIST.no
  is '��ͬ���';
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

--��ֳ�������嵥��
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
  is '�����嵥��';
-- Add comments to the columns 
comment on column TXNLIST.NYXBREEDCLAIMLIST.listno
  is '�����嵥��';
comment on column TXNLIST.NYXBREEDCLAIMLIST.serialno
  is '���';
comment on column TXNLIST.NYXBREEDCLAIMLIST.policyno
  is '������';
comment on column TXNLIST.NYXBREEDCLAIMLIST.registno
  is '������';
comment on column TXNLIST.NYXBREEDCLAIMLIST.compensateno
  is '�������';
comment on column TXNLIST.NYXBREEDCLAIMLIST.fcode
  is 'ũ������';
comment on column TXNLIST.NYXBREEDCLAIMLIST.fname
  is 'ũ������';
comment on column TXNLIST.NYXBREEDCLAIMLIST.fidcard
  is '���֤����';
comment on column TXNLIST.NYXBREEDCLAIMLIST.phonenumber
  is '��ϵ�绰';
comment on column TXNLIST.NYXBREEDCLAIMLIST.bankaccount
  is '�����˺�';
comment on column TXNLIST.NYXBREEDCLAIMLIST.paytype
  is '�⸶���� Y-Ԥ��;C-ʵ��';
comment on column TXNLIST.NYXBREEDCLAIMLIST.itemcode
  is '��ĺ���';
comment on column TXNLIST.NYXBREEDCLAIMLIST.nodetype
  is '�ڵ�����';
comment on column TXNLIST.NYXBREEDCLAIMLIST.formula
  is '���㹫ʽ';
comment on column TXNLIST.NYXBREEDCLAIMLIST.deductionamount
  is '�۳����';
comment on column TXNLIST.NYXBREEDCLAIMLIST.claimriskcode
  is '�⸶�ձ�';
comment on column TXNLIST.NYXBREEDCLAIMLIST.claimno
  is '������';
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

--Ԥ���嵥�������ⰸ��
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
  is '�����ⰸ�嵥��';
-- Add comments to the columns 
comment on column TXNLIST.SPECCASELIST.serialno
  is '���';
comment on column TXNLIST.SPECCASELIST.policyno
  is '������';
comment on column TXNLIST.SPECCASELIST.registno
  is '������';
comment on column TXNLIST.SPECCASELIST.claimno
  is '������';
comment on column TXNLIST.SPECCASELIST.precompensateno
  is 'Ԥ�ⵥ��';
comment on column TXNLIST.SPECCASELIST.fcode
  is 'ũ������';
comment on column TXNLIST.SPECCASELIST.fname
  is 'ũ������';
comment on column TXNLIST.SPECCASELIST.receivertype
  is '���������';
comment on column TXNLIST.SPECCASELIST.receivername
  is '���������(�����˻�����)';
comment on column TXNLIST.SPECCASELIST.identifytype
  is '�����֤������';
comment on column TXNLIST.SPECCASELIST.identifynumber
  is '�����֤����';
comment on column TXNLIST.SPECCASELIST.banktype
  is '�������д���';
comment on column TXNLIST.SPECCASELIST.provincename
  is '������������ʡ������';
comment on column TXNLIST.SPECCASELIST.cityname
  is '�����������ڳ�������';
comment on column TXNLIST.SPECCASELIST.bankname
  is '������������';
comment on column TXNLIST.SPECCASELIST.bankaccount
  is '�����˺�';
comment on column TXNLIST.SPECCASELIST.accountflag
  is '�˺�����01-��˽�˺ţ�02-�Թ��˺�';
comment on column TXNLIST.SPECCASELIST.accounttype
  is '�˺�����01-���п���02-����';
comment on column TXNLIST.SPECCASELIST.phonenumber
  is '������ֻ���';
comment on column TXNLIST.SPECCASELIST.settletype
  is '�������';
comment on column TXNLIST.SPECCASELIST.settleamount
  is '�����(Ԫ)';
comment on column TXNLIST.SPECCASELIST.createdby
  is '������';
comment on column TXNLIST.SPECCASELIST.createdtime
  is '����ʱ��';
comment on column TXNLIST.SPECCASELIST.updatedby
  is '������';
comment on column TXNLIST.SPECCASELIST.updatedtime
  is '����ʱ��';
comment on column TXNLIST.SPECCASELIST.listno
  is '�嵥��';
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
--֧���嵥
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
  is '����֧���嵥��';
-- Add comments to the columns 
comment on column TXNLIST.NYXCLAIMPAYLIST.listno
  is '����֧���嵥��';
comment on column TXNLIST.NYXCLAIMPAYLIST.policyno
  is '������';
comment on column TXNLIST.NYXCLAIMPAYLIST.registno
  is '������';
comment on column TXNLIST.NYXCLAIMPAYLIST.claimno
  is '������';
comment on column TXNLIST.NYXCLAIMPAYLIST.compensateno
  is '�������';
comment on column TXNLIST.NYXCLAIMPAYLIST.receivertype
  is '���������';
comment on column TXNLIST.NYXCLAIMPAYLIST.receivername
  is '���������';
comment on column TXNLIST.NYXCLAIMPAYLIST.identifytype
  is '�����֤������';
comment on column TXNLIST.NYXCLAIMPAYLIST.identifynumber
  is '�����֤����';
comment on column TXNLIST.NYXCLAIMPAYLIST.banktype
  is '�������д���';
comment on column TXNLIST.NYXCLAIMPAYLIST.provincename
  is '������������ʡ������';
comment on column TXNLIST.NYXCLAIMPAYLIST.cityname
  is '�����������ڳ�������';
comment on column TXNLIST.NYXCLAIMPAYLIST.bankname
  is '������������';
comment on column TXNLIST.NYXCLAIMPAYLIST.bankaccount
  is '�����˺�';
comment on column TXNLIST.NYXCLAIMPAYLIST.accountflag
  is '�˺�����00-���п���01-����;03-�Թ��˻�';
comment on column TXNLIST.NYXCLAIMPAYLIST.accounttype
  is '�˺�����1-��˽�˺ţ�2-�Թ��˺�';
comment on column TXNLIST.NYXCLAIMPAYLIST.phonenumber
  is '������ֻ���';
comment on column TXNLIST.NYXCLAIMPAYLIST.settleamount
  is '�����';
comment on column TXNLIST.NYXCLAIMPAYLIST.fcode
  is 'ũ������';
comment on column TXNLIST.NYXCLAIMPAYLIST.fname
  is 'ũ������';
comment on column TXNLIST.NYXCLAIMPAYLIST.settletype
  is '�������';
comment on column TXNLIST.NYXCLAIMPAYLIST.serialno
  is '���';
comment on column TXNLIST.NYXCLAIMPAYLIST.paymentno
  is '�ո����';
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