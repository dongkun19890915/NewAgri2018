select * from utiusergrade t;--机构、用户、岗位代码；
select * from prpdcompany t1;--机构信息；
select * from prpduser t2;--用户信息；
select * from utigrade t3;--岗位信息；

 select t.comcode,t1.comcname,t1.comlevel,
        t.usercode,t2.username,t2.comcode as 归属机构,t2.makecom as 出单机构,
        t.gradecode,t3.gradename,t.validstatus
   from utiusergrade t left join prpdcompany t1 on t1.comcode = t.comcode  
   left join prpduser t2  on t2.usercode = t.usercode
   left join utigrade t3  on t3.gradecode = t.gradecode
   where t.usercode = '0088000000' ; --承保岗（养殖险）832
   where t.comcode='23010000' and t.usercode = '0000130010';
    --where t.comcode='23320000' and t.gradecode = '703';
    --where  t2.username like '%陈家文%' ;
   -- where t2.makecom ='44075100'
    where t2.comcode='23100000' and t.gradecode = '733'

select * from payflog p where p.certino='44015100LSPN201711003'

select * from prpjaccountconfig p where  comcode in ('44000000') order by p.acctypecode1,p.acctypecode2 
