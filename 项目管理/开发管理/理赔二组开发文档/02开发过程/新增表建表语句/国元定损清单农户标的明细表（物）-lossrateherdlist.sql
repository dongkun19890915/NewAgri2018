-- Create table
create table TXNLIST.LOSSRATEHERDLIST
(
  losslistcode VARCHAR2(28) not null,
  serialno     NUMBER not null,
  fcode        VARCHAR2(25) not null,
  itemcode     VARCHAR2(20) not null,
  lossserialno NUMBER not null,
  earlabel     VARCHAR2(20) not null,
  createdby    VARCHAR2(20),
  createdtime  DATE,
  updatedby    VARCHAR2(20),
  updatedtime  DATE
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
  add constraint PK_LOSSRATEHERDLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE, LOSSSERIALNO, EARLABEL);
