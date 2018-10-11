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
  createdby         VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table GYIC.PRPLCONFIGURATION
  is '条款公式配置表';
-- Add comments to the columns 
comment on column GYIC.PRPLCONFIGURATION.id
  is '序号，唯一标识';
comment on column GYIC.PRPLCONFIGURATION.classcode
  is '险种';
comment on column GYIC.PRPLCONFIGURATION.riskcode
  is '险类';
comment on column GYIC.PRPLCONFIGURATION.clausenumber
  is '条款编号';
comment on column GYIC.PRPLCONFIGURATION.formuladescribing
  is '赔款公式文字描述';
comment on column GYIC.PRPLCONFIGURATION.formula
  is '计算公式';
comment on column GYIC.PRPLCONFIGURATION.reserve1
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve2
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve3
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve4
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve5
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve6
  is '备用字段 ';
comment on column GYIC.PRPLCONFIGURATION.reserve7
  is '备用字段 ';
-- Create/Recreate indexes 
create unique index GYIC.PK_PRPLFORMULA on GYIC.PRPLCONFIGURATION (ID)
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
-- Create/Recreate primary, unique and foreign key constraints 
alter table GYIC.PRPLCONFIGURATION
  add constraint PK_PRPLCONFIGURATION primary key (ID);
-- Grant/Revoke object privileges 
grant select, insert, update, delete on GYIC.PRPLCONFIGURATION to GYIC2;
