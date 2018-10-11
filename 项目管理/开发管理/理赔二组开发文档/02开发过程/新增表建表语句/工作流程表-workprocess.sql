

create table agriclaim.WORKPROCESS
(
  id               NUMBER not null,
  registno         VARCHAR2(22) not null,
  policyno         VARCHAR2(22) not null,
  claimno          VARCHAR2(22),
  compensateno     VARCHAR2(25),
  caseno           VARCHAR2(22),
  flowid           VARCHAR2(22),
  precompensateno  VARCHAR2(22),
  nodetype         VARCHAR2(5),
  nodename         VARCHAR2(100),
  nextnodetype     VARCHAR2(100),
  classcode        VARCHAR2(3),
  riskcode         VARCHAR2(4),
  nodestatus       VARCHAR2(2),
  casetype         VARCHAR2(22),
  registflowintime VARCHAR2(19),
  flowintime       VARCHAR2(19),
  operator         VARCHAR2(100),
  operatedate      DATE,
  createdby        VARCHAR2(20),
  createdtime      DATE,
  updatedby        VARCHAR2(20),
  updatedtime      DATE
);
comment on table agriclaim.WORKPROCESS
  is '工作流程表';
comment on column agriclaim.WORKPROCESS.registno
  is '报案号';
comment on column agriclaim.WORKPROCESS.policyno
  is '保单号';
comment on column agriclaim.WORKPROCESS.claimno
  is '立案号';
comment on column agriclaim.WORKPROCESS.compensateno
  is '赔款计算书号';
comment on column agriclaim.WORKPROCESS.caseno
  is '结案号';
comment on column agriclaim.WORKPROCESS.flowid
  is '流程号';
comment on column agriclaim.WORKPROCESS.precompensateno
  is '预赔号';
comment on column agriclaim.WORKPROCESS.nodetype
  is '当前节点代码';
comment on column agriclaim.WORKPROCESS.nodename
  is '当前节点';
comment on column agriclaim.WORKPROCESS.nextnodetype
  is '下一节点代码';
comment on column agriclaim.WORKPROCESS.classcode
  is '险种大类';
comment on column agriclaim.WORKPROCESS.riskcode
  is '险种';
comment on column agriclaim.WORKPROCESS.nodestatus
  is '当前状态';
comment on column agriclaim.WORKPROCESS.casetype
  is '案件状态';
comment on column agriclaim.WORKPROCESS.registflowintime
  is '报案流入时间';
comment on column agriclaim.WORKPROCESS.flowintime
  is '最新节点流入时间';
comment on column agriclaim.WORKPROCESS.operator
  is '操作人';
comment on column agriclaim.WORKPROCESS.operatedate
  is '操作时间';
comment on column agriclaim.WORKPROCESS.createdby
  is '创建人';
comment on column agriclaim.WORKPROCESS.createdtime
  is '创建时间';
comment on column agriclaim.WORKPROCESS.updatedby
  is '更新人';
comment on column agriclaim.WORKPROCESS.updatedtime
  is '更新时间';
alter table agriclaim.WORKPROCESS
  add constraint PK_WORKPROCESS primary key (ID, REGISTNO);



