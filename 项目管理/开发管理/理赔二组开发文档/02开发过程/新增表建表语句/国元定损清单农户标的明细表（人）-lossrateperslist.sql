-- Create table
create table TXNLIST.LOSSRATEPERSLIST
(
  losslistcode VARCHAR2(25) not null,
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
  add constraint PK_LOSSRATEPERSLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE, LOSSSERIALNO, IDCARD);
