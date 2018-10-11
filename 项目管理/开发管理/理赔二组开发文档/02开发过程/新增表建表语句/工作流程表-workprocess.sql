

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
  is '�������̱�';
comment on column agriclaim.WORKPROCESS.registno
  is '������';
comment on column agriclaim.WORKPROCESS.policyno
  is '������';
comment on column agriclaim.WORKPROCESS.claimno
  is '������';
comment on column agriclaim.WORKPROCESS.compensateno
  is '���������';
comment on column agriclaim.WORKPROCESS.caseno
  is '�᰸��';
comment on column agriclaim.WORKPROCESS.flowid
  is '���̺�';
comment on column agriclaim.WORKPROCESS.precompensateno
  is 'Ԥ���';
comment on column agriclaim.WORKPROCESS.nodetype
  is '��ǰ�ڵ����';
comment on column agriclaim.WORKPROCESS.nodename
  is '��ǰ�ڵ�';
comment on column agriclaim.WORKPROCESS.nextnodetype
  is '��һ�ڵ����';
comment on column agriclaim.WORKPROCESS.classcode
  is '���ִ���';
comment on column agriclaim.WORKPROCESS.riskcode
  is '����';
comment on column agriclaim.WORKPROCESS.nodestatus
  is '��ǰ״̬';
comment on column agriclaim.WORKPROCESS.casetype
  is '����״̬';
comment on column agriclaim.WORKPROCESS.registflowintime
  is '��������ʱ��';
comment on column agriclaim.WORKPROCESS.flowintime
  is '���½ڵ�����ʱ��';
comment on column agriclaim.WORKPROCESS.operator
  is '������';
comment on column agriclaim.WORKPROCESS.operatedate
  is '����ʱ��';
comment on column agriclaim.WORKPROCESS.createdby
  is '������';
comment on column agriclaim.WORKPROCESS.createdtime
  is '����ʱ��';
comment on column agriclaim.WORKPROCESS.updatedby
  is '������';
comment on column agriclaim.WORKPROCESS.updatedtime
  is '����ʱ��';
alter table agriclaim.WORKPROCESS
  add constraint PK_WORKPROCESS primary key (ID, REGISTNO);



