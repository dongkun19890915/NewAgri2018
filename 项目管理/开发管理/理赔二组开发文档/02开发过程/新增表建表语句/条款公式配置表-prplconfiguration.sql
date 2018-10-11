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
  is '���ʽ���ñ�';
-- Add comments to the columns 
comment on column GYIC.PRPLCONFIGURATION.id
  is '��ţ�Ψһ��ʶ';
comment on column GYIC.PRPLCONFIGURATION.classcode
  is '����';
comment on column GYIC.PRPLCONFIGURATION.riskcode
  is '����';
comment on column GYIC.PRPLCONFIGURATION.clausenumber
  is '������';
comment on column GYIC.PRPLCONFIGURATION.formuladescribing
  is '��ʽ��������';
comment on column GYIC.PRPLCONFIGURATION.formula
  is '���㹫ʽ';
comment on column GYIC.PRPLCONFIGURATION.reserve1
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve2
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve3
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve4
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve5
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve6
  is '�����ֶ� ';
comment on column GYIC.PRPLCONFIGURATION.reserve7
  is '�����ֶ� ';
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
