-- Create table
create table LOSSRATELIST
(
  listno        VARCHAR2(31) not null,
  listname      VARCHAR2(31) not null,
  policyno      VARCHAR2(21) not null,
  registno      VARCHAR2(22),
  compensateno  VARCHAR2(25),
  paymentlistno VARCHAR2(31),
  claimlistno   VARCHAR2(31),
  areacode      VARCHAR2(20),
  remark        VARCHAR2(200),
  remark1       VARCHAR2(200),
  remark2       VARCHAR2(200),
  createdby     VARCHAR2(20),
  createdtime   DATE,
  updatedby     VARCHAR2(20),
  updatedtime   DATE
);
-- Add comments to the table 
comment on table LOSSRATELIST
  is '养殖险损失率清单表';
-- Add comments to the columns 
comment on column LOSSRATELIST.listno
  is '损失率清单号';
comment on column LOSSRATELIST.listname
  is '定损清单名称';
comment on column LOSSRATELIST.policyno
  is '保单号';
comment on column LOSSRATELIST.registno
  is '报案号';
comment on column LOSSRATELIST.compensateno
  is '计算书号';
comment on column LOSSRATELIST.paymentlistno
  is '支付清单号';
comment on column LOSSRATELIST.claimlistno
  is '理赔清单号';
comment on column LOSSRATELIST.areacode
  is '归属区域';
comment on column LOSSRATELIST.remark
  is '备用';
comment on column LOSSRATELIST.remark1
  is '备用1';
comment on column LOSSRATELIST.remark2
  is '备用2';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LOSSRATELIST
  add constraint PK_LOSSRATELIST primary key (LISTNO);
