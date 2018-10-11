-- Create table
create table PLANTINGLOSSRATELIST
(
  listno      VARCHAR2(31) not null,
  policyno    VARCHAR2(21) not null,
  registno    VARCHAR2(22),
  fcode       VARCHAR2(25) not null,
  fname       VARCHAR2(50),
  fieldno     VARCHAR2(19) not null,
  insurearea  NUMBER(10,4),
  lossarea    NUMBER(10,4),
  lossrate    NUMBER(10,4),
  remark      VARCHAR2(200),
  createdby   VARCHAR2(20),
  createdtime DATE,
  updatedby   VARCHAR2(20),
  updatedtime DATE,
  serialno    VARCHAR2(21) not null
);
-- Add comments to the table 
comment on table PLANTINGLOSSRATELIST
  is '种植险损失率清单表';
-- Add comments to the columns 
comment on column PLANTINGLOSSRATELIST.listno
  is '损失率清单号';
comment on column PLANTINGLOSSRATELIST.policyno
  is '保单号';
comment on column PLANTINGLOSSRATELIST.registno
  is '报案号';
comment on column PLANTINGLOSSRATELIST.fcode
  is '农户代码';
comment on column PLANTINGLOSSRATELIST.fname
  is '农户姓名';
comment on column PLANTINGLOSSRATELIST.fieldno
  is '田块代码';
comment on column PLANTINGLOSSRATELIST.insurearea
  is '承保面积';
comment on column PLANTINGLOSSRATELIST.lossarea
  is '损失面积';
comment on column PLANTINGLOSSRATELIST.lossrate
  is '损失率';
comment on column PLANTINGLOSSRATELIST.remark
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PLANTINGLOSSRATELIST
  add constraint PK_PLANTINGLOSSRATELIST primary key (LISTNO, SERIALNO);
