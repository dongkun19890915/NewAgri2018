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
  is '条款公式配置项配置表';
-- Add comments to the columns 
comment on column prplformulaconfig.id
  is '序号，唯一标识';
comment on column prplformulaconfig.classcode
  is '险种';
comment on column prplformulaconfig.riskcode
  is '险类';
comment on column prplformulaconfig.configcode
  is '配置项代码';
comment on column prplformulaconfig.configdescribing
  is '配置项说明';
comment on column prplformulaconfig.configurationrange
  is '配置范围  H汇总计算  F分开计算';
comment on column prplformulaconfig.configurationtype
  is '取值方式  0直接取值  1通过SQL取值';
comment on column prplformulaconfig.configurationcontent
  is '取值内容';
comment on column prplformulaconfig.reserve1
  is '备用字段 ';
comment on column prplformulaconfig.reserve2
  is '备用字段 ';
comment on column prplformulaconfig.reserve3
  is '备用字段 ';
comment on column prplformulaconfig.reserve4
  is '备用字段 ';
comment on column prplformulaconfig.reserve5
  is '备用字段 ';
comment on column prplformulaconfig.reserve6
  is '备用字段 ';
comment on column prplformulaconfig.reserve7
  is '备用字段 ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table prplformulaconfig
  add constraint pk_prplformulaconfig22 primary key (ID);