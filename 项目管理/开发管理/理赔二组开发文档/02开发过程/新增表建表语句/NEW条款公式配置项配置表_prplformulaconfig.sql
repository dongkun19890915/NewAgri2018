-- Create table
create table prplformulaconfig
(
  id                   VARCHAR2(10) not null,
  classcode            VARCHAR2(3),
  riskcode             VARCHAR2(4),
  configcode           VARCHAR2(10),
  configdescribing     VARCHAR2(200),
  configurationrange   VARCHAR2(1),
  configurationtype    VARCHAR2(1),
  configurationcontent VARCHAR2(2000),
  reserve1             VARCHAR2(10),
  reserve2             VARCHAR2(10),
  reserve3             VARCHAR2(10),
  reserve4             VARCHAR2(10),
  reserve5             VARCHAR2(10),
  reserve6             VARCHAR2(10),
  reserve7             VARCHAR2(10)
)
;
-- Add comments to the table 
comment on table prplformulaconfig
  is '���ʽ���������ñ�';
-- Add comments to the columns 
comment on column prplformulaconfig.id
  is '��ţ�Ψһ��ʶ';
comment on column prplformulaconfig.classcode
  is '����';
comment on column prplformulaconfig.riskcode
  is '����';
comment on column prplformulaconfig.configcode
  is '���������';
comment on column prplformulaconfig.configdescribing
  is '������˵��';
comment on column prplformulaconfig.configurationrange
  is '���÷�Χ  H���ܼ���  F�ֿ�����';
comment on column prplformulaconfig.configurationtype
  is 'ȡֵ��ʽ  0ֱ��ȡֵ  1ͨ��SQLȡֵ';
comment on column prplformulaconfig.configurationcontent
  is 'ȡֵ����';
comment on column prplformulaconfig.reserve1
  is '�����ֶ� ';
comment on column prplformulaconfig.reserve2
  is '�����ֶ� ';
comment on column prplformulaconfig.reserve3
  is '�����ֶ� ';
comment on column prplformulaconfig.reserve4
  is '�����ֶ� ';
comment on column prplformulaconfig.reserve5
  is '�����ֶ� ';
comment on column prplformulaconfig.reserve6
  is '�����ֶ� ';
comment on column prplformulaconfig.reserve7
  is '�����ֶ� ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table prplformulaconfig
  add constraint pk_prplformulaconfig22 primary key (ID);