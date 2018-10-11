-- Create table
create table LOSSRATEITEMLIST
(
  losslistcode VARCHAR2(25) not null,
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
);
-- Add comments to the table 
comment on table LOSSRATEITEMLIST
  is '定损清单标的表';
-- Add comments to the columns 
comment on column LOSSRATEITEMLIST.losslistcode
  is '理赔损失清单编号';
comment on column LOSSRATEITEMLIST.serialno
  is '序列号 考虑同一清单有多次修改但清单号不变的情况，增加序列号加以区分';
comment on column LOSSRATEITEMLIST.fcode
  is '农户代码';
comment on column LOSSRATEITEMLIST.fname
  is '农户姓名';
comment on column LOSSRATEITEMLIST.fidtype
  is '证件类型';
comment on column LOSSRATEITEMLIST.fidcard
  is '证件号码';
comment on column LOSSRATEITEMLIST.itemcode
  is '标的代码';
comment on column LOSSRATEITEMLIST.itemtype
  is '标的类型';
comment on column LOSSRATEITEMLIST.itemname
  is '标的名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LOSSRATEITEMLIST
  add constraint PK_LOSSRATEITEMLIST primary key (LOSSLISTCODE, SERIALNO, FCODE, ITEMCODE);
