select * from utiusergrade t;--�������û�����λ���룻
select * from prpdcompany t1;--������Ϣ��
select * from prpduser t2;--�û���Ϣ��
select * from utigrade t3;--��λ��Ϣ��

 select t.comcode,t1.comcname,t1.comlevel,
        t.usercode,t2.username,t2.comcode as ��������,t2.makecom as ��������,
        t.gradecode,t3.gradename,t.validstatus
   from utiusergrade t left join prpdcompany t1 on t1.comcode = t.comcode  
   left join prpduser t2  on t2.usercode = t.usercode
   left join utigrade t3  on t3.gradecode = t.gradecode
   where t.usercode = '0088000000' ; --�б��ڣ���ֳ�գ�832
   where t.comcode='23010000' and t.usercode = '0000130010';
    --where t.comcode='23320000' and t.gradecode = '703';
    --where  t2.username like '%�¼���%' ;
   -- where t2.makecom ='44075100'
    where t2.comcode='23100000' and t.gradecode = '733'

select * from payflog p where p.certino='44015100LSPN201711003'

select * from prpjaccountconfig p where  comcode in ('44000000') order by p.acctypecode1,p.acctypecode2 
