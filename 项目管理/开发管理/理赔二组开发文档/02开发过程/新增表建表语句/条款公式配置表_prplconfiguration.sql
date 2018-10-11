-- Create table
create table PRPLCONFIGURATION
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
  reserve7          VARCHAR2(10)
);
-- Add comments to the table 
comment on table PRPLCONFIGURATION
  is '条款公式配置表';
-- Add comments to the columns 
comment on column PRPLCONFIGURATION.id
  is '序号，唯一标识';
comment on column PRPLCONFIGURATION.classcode
  is '险种';
comment on column PRPLCONFIGURATION.riskcode
  is '险类';
comment on column PRPLCONFIGURATION.clausenumber
  is '条款编号';
comment on column PRPLCONFIGURATION.formuladescribing
  is '赔款公式文字描述';
comment on column PRPLCONFIGURATION.formula
  is '计算公式';
comment on column PRPLCONFIGURATION.reserve1
  is '备用字段 ';
comment on column PRPLCONFIGURATION.reserve2
  is '备用字段 ';
comment on column PRPLCONFIGURATION.reserve3
  is '备用字段 ';
comment on column PRPLCONFIGURATION.reserve4
  is '备用字段 ';
comment on column PRPLCONFIGURATION.reserve5
  is '备用字段 ';
comment on column PRPLCONFIGURATION.reserve6
  is '备用字段 ';
comment on column PRPLCONFIGURATION.reserve7
  is '备用字段 ';
-- Create/Recreate indexes 
create unique index PK_PRPLFORMULA on PRPLCONFIGURATION (ID);
-- Create/Recreate primary, unique and foreign key constraints 
alter table PRPLCONFIGURATION
  add constraint PK_PRPLCONFIGURATION primary key (ID);