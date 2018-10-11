-- Create table
create table LOSSRATELOSSLIST
(
  losslistcode VARCHAR2(25) not null,
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
  updatedtime  DATE
);
-- Add comments to the table 
comment on table LOSSRATELOSSLIST
  is '定损清单农户标的清单表';
-- Add comments to the columns 
comment on column LOSSRATELOSSLIST.losslistcode
  is '理赔损失清单编号';
comment on column LOSSRATELOSSLIST.serialno
  is '序列号 考虑同一清单有多次修改但清单号不变的情况，增加序列号加以区分';
comment on column LOSSRATELOSSLIST.fcode
  is '农户代码';
comment on column LOSSRATELOSSLIST.itemcode
  is '标的代码';
comment on column LOSSRATELOSSLIST.lossserialno
  is '损失序列号';
comment on column LOSSRATELOSSLIST.lossrate
  is '损失率';
comment on column LOSSRATELOSSLIST.lossamount
  is '损失数量';
comment on column LOSSRATELOSSLIST.lossmoney
  is '损失金额';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LOSSRATELOSSLIST
  add constraint PK_LOSSRATELOSSLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE, LOSSSERIALNO);
