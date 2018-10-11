-- Create table
create table BREEDLOSSRATELIST
(
  listno      VARCHAR2(31) not null,
  policyno    VARCHAR2(21) not null,
  registno    VARCHAR2(22),
  fcode       VARCHAR2(25) not null,
  fname       VARCHAR2(50),
  earconno    VARCHAR2(50),
  payamount   NUMBER(10,4),
  remark      VARCHAR2(200),
  createdby   VARCHAR2(20),
  createdtime DATE,
  updatedby   VARCHAR2(20),
  updatedtime DATE,
  serialno    VARCHAR2(21) not null
);
-- Add comments to the table 
comment on table BREEDLOSSRATELIST
  is '养殖险损失率清单表';
-- Add comments to the columns 
comment on column BREEDLOSSRATELIST.listno
  is '损失率清单号';
comment on column BREEDLOSSRATELIST.policyno
  is '保单号';
comment on column BREEDLOSSRATELIST.registno
  is '报案号';
comment on column BREEDLOSSRATELIST.fcode
  is '农户代码';
comment on column BREEDLOSSRATELIST.fname
  is '农户姓名';
comment on column BREEDLOSSRATELIST.earconno
  is '耳标号';
comment on column BREEDLOSSRATELIST.payamount
  is '赔款金额';
comment on column BREEDLOSSRATELIST.remark
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table BREEDLOSSRATELIST
  add constraint PK_BREEDLOSSRATELIST primary key (LISTNO, SERIALNO);
