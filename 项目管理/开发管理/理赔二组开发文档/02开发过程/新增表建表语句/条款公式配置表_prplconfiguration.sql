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
  is '���ʽ���ñ�';
-- Add comments to the columns 
comment on column PRPLCONFIGURATION.id
  is '��ţ�Ψһ��ʶ';
comment on column PRPLCONFIGURATION.classcode
  is '����';
comment on column PRPLCONFIGURATION.riskcode
  is '����';
comment on column PRPLCONFIGURATION.clausenumber
  is '������';
comment on column PRPLCONFIGURATION.formuladescribing
  is '��ʽ��������';
comment on column PRPLCONFIGURATION.formula
  is '���㹫ʽ';
comment on column PRPLCONFIGURATION.reserve1
  is '�����ֶ� ';
comment on column PRPLCONFIGURATION.reserve2
  is '�����ֶ� ';
comment on column PRPLCONFIGURATION.reserve3
  is '�����ֶ� ';
comment on column PRPLCONFIGURATION.reserve4
  is '�����ֶ� ';
comment on column PRPLCONFIGURATION.reserve5
  is '�����ֶ� ';
comment on column PRPLCONFIGURATION.reserve6
  is '�����ֶ� ';
comment on column PRPLCONFIGURATION.reserve7
  is '�����ֶ� ';
-- Create/Recreate indexes 
create unique index PK_PRPLFORMULA on PRPLCONFIGURATION (ID);
-- Create/Recreate primary, unique and foreign key constraints 
alter table PRPLCONFIGURATION
  add constraint PK_PRPLCONFIGURATION primary key (ID);