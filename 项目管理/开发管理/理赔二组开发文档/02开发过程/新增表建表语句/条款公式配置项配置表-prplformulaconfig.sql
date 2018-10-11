-- Create table
create table PRPLFORMULACONFIG
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
  reserve7             VARCHAR2(10),
  updatedtime          DATE,
  createdtime          DATE,
  updatedby            VARCHAR2(20),
  createdby            VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table PRPLFORMULACONFIG
  is '条款公式配置项配置表';
-- Add comments to the columns 
comment on column PRPLFORMULACONFIG.id
  is '序号，唯一标识';
comment on column PRPLFORMULACONFIG.classcode
  is '险种';
comment on column PRPLFORMULACONFIG.riskcode
  is '险类';
comment on column PRPLFORMULACONFIG.configcode
  is '配置项代码';
comment on column PRPLFORMULACONFIG.configdescribing
  is '配置项说明';
comment on column PRPLFORMULACONFIG.configurationrange
  is '配置范围  H汇总计算  F分开计算';
comment on column PRPLFORMULACONFIG.configurationtype
  is '取值方式  0直接取值  1通过SQL取值';
comment on column PRPLFORMULACONFIG.configurationcontent
  is '取值内容';
comment on column PRPLFORMULACONFIG.reserve1
  is '备用字段 ';
comment on column PRPLFORMULACONFIG.reserve2
  is '备用字段 ';
comment on column PRPLFORMULACONFIG.reserve3
  is '备用字段 ';
comment on column PRPLFORMULACONFIG.reserve4
  is '备用字段 ';
comment on column PRPLFORMULACONFIG.reserve5
  is '备用字段 ';
comment on column PRPLFORMULACONFIG.reserve6
  is '备用字段 ';
comment on column PRPLFORMULACONFIG.reserve7
  is '备用字段 ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PRPLFORMULACONFIG
  add constraint PK_PRPLFORMULACONFIG primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
