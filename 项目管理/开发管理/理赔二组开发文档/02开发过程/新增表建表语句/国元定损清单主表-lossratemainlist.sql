-- Create table
create table LOSSRATEMAINLIST
(
  losslistcode   VARCHAR2(25) not null,
  serialno       NUMBER not null,
  bizno          VARCHAR2(25),
  policyno       VARCHAR2(22),
  listcreatetime DATE,
  opcode         VARCHAR2(10),
  opname         VARCHAR2(20),
  listaffirmtime DATE,
  affirmopcode   VARCHAR2(10),
  affirmopname   VARCHAR2(20),
  createdby      VARCHAR2(20),
  createdtime    DATE,
  updatedby      VARCHAR2(20),
  updatedtime    DATE,
  explorearea    VARCHAR2(50),
  exploretime    DATE,
  remark         VARCHAR2(100)
);
-- Add comments to the table 
comment on table LOSSRATEMAINLIST
  is '定损清单主表';
-- Add comments to the columns 
comment on column LOSSRATEMAINLIST.losslistcode
  is '理赔损失清单编号';
comment on column LOSSRATEMAINLIST.serialno
  is '序列号 考虑同一清单有多次修改但清单号不变的情况，增加序列号加以区分';
comment on column LOSSRATEMAINLIST.bizno
  is '业务单号  保单号/报案号/立案号';
comment on column LOSSRATEMAINLIST.policyno
  is '保单号 保单号';
comment on column LOSSRATEMAINLIST.listcreatetime
  is '清单缮制时间';
comment on column LOSSRATEMAINLIST.opcode
  is '清单缮制人工号';
comment on column LOSSRATEMAINLIST.opname
  is '清单缮制人姓名';
comment on column LOSSRATEMAINLIST.listaffirmtime
  is '清单最终确认时间';
comment on column LOSSRATEMAINLIST.affirmopcode
  is '清单最终确认人代码';
comment on column LOSSRATEMAINLIST.affirmopname
  is '清单最终确认人姓名';
comment on column LOSSRATEMAINLIST.remark
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LOSSRATEMAINLIST
  add constraint PK_LOSSRATEMAINLIST primary key (LOSSLISTCODE, SERIALNO);
