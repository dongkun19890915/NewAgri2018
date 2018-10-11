---
date: 2017-10-23 13:53
status: public
title: elasticsearch同步数据
---

# 1 elasticsearch-jdbc插件安装
## 1 jdk安装
安装过程（略）
安装版本：jdk1.8
```
[redhat@localhost soft]$ java -version
java version "1.8.0_111"
Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
```
## 2 jdbc插件安装
### 2.1 插件下载
- 插件地址：
  - [插件源码](https://github.com/jprante/elasticsearch-jdbc/tree/2.2.0.0)
  - [插件包:elasticsearch-jdbc-2.2.0.0-dist.zip](http://xbib.org/repository/org/xbib/elasticsearch/importer/elasticsearch-jdbc/2.2.0.0/elasticsearch-jdbc-2.2.0.0-dist.zip)
  下载elasticsearch-jdbc-2.2.0.0-dist.zip安装包。
  例如：
```
[redhat@localhost soft]$ pwd
/home/redhat/soft
[redhat@localhost soft]$ ls -la
total 29636
drwxrwxr-x.  7 redhat redhat     4096 Oct 23 02:54 .
drwx------. 30 redhat redhat     4096 Oct 23 05:16 ..
-rw-rw-r--.  1 redhat redhat 30316608 Oct 23 02:54 elasticsearch-jdbc-2.2.0.0-dist.zip
```  
### 2.2 安装插件
1）解压包  
  ```
  unzip elasticsearch-jdbc-2.2.0.0-dist.zip
  ```
2）配置环境变量
```
[redhat@localhost soft]$ vim ~/.bash_profile
```
在最后新增以下内容：

```
export JDBC_IMPORTER_HOME=/home/redhat/soft/elasticsearch-jdbc-2.2.0.0
```
3）使配置生效：
```
source ~/.bash_profile
```
# 2 mysql数据库数据迁移至ES
1）进入插件bin目录
```
cd $JDBC_IMPORTER_HOME/bin
```
2）编写sh脚本
```
[redhat@localhost bin]$ vim mysql_test01.sh
```
新增以下内容：
```
#!/bin/sh
bin=$JDBC_IMPORTER_HOME/bin
lib=$JDBC_IMPORTER_HOME/lib
echo '{
    "jdbc" : {
        "url" : "jdbc:mysql://192.168.0.2:3306/account201709271726",
        "user" : "account",
        "password" : "sinosoft_account",
        "sql" : "select pu.usercode as _id,pu.usercode as usercode,pu.username as username,pu.comcode as comcode,pc.comcname as comname from prpduser pu,prpdcompany pc where pu.comcode=pc.comcode",
        "index" : "agri",
        "type":"prpduser" 
   }
}' | java \
       -cp "${lib}/*" \
       -Dlog4j.configurationFile=${bin}/log4j2.xml \
       org.xbib.tools.Runner \
       org.xbib.tools.JDBCImporter
```
配置说明：
- bin:插件的bin路径 
- lib:插件的lib路径
- echo-type:文档类型
- echo-jdbc：mysql数据库相关配置
- echo-sql:mysql查询脚本，数据会匹配插入ES，注意_id。
- echo-index:ES索引
- echo-type:ES类型

# 3 oracle数据库数据迁移至ES 
注意：oracle需要先建好索引，不然会报错。
1）上传ojdbc驱动包至`$JDBC_IMPORTER_HOME/lib`路径下。
例如：
```
[redhat@localhost lib]$ pwd
/home/redhat/soft/elasticsearch-jdbc-2.2.0.0/lib
[redhat@localhost lib]$ ls -la
total 36196
drwxr-xr-x. 2 redhat redhat     4096 Oct 23 02:55 .
drwxrwxr-x. 4 redhat redhat     4096 Oct 23 02:55 ..
-rw-r--r--. 1 redhat redhat  3103132 Feb  5  2016 derby-10.11.1.1.jar
-rw-r--r--. 1 redhat redhat 25311329 Feb  5  2016 elasticsearch-jdbc-2.2.0.0-uberjar.jar
-rw-r--r--. 1 redhat redhat  1683607 Feb  5  2016 h2-1.4.181.jar
-rw-r--r--. 1 redhat redhat  1473091 Feb  5  2016 hsqldb-2.3.2.jar
-rw-r--r--. 1 redhat redhat   216932 Feb  5  2016 jdbc-driver-csv-1.0.0.jar
-rw-r--r--. 1 redhat redhat   959984 Feb  5  2016 mysql-connector-java-5.1.33.jar
-rw-rw-r--. 1 redhat redhat  3698857 Oct 23 02:55 ojdbc7-12.1.0.2.0.jar
-rw-r--r--. 1 redhat redhat   592322 Feb  5  2016 postgresql-9.3-1102-jdbc41.jar
```
2）进入`bin=$JDBC_IMPORTER_HOME/bin`，
```
[redhat@localhost bin]$ vim oracle_test01.sh 
```
新增脚本文件如下：
```
#!/bin/sh
bin=$JDBC_IMPORTER_HOME/bin
lib=$JDBC_IMPORTER_HOME/lib
echo '{
    "jdbc" : {
        "url" : "jdbc:oracle:thin:@192.168.0.4:1521/agri",
        "user" : "gyic",
        "password" : "****",
        "sql" : "select pu.usercode as \"_id\",pu.usercode as usercode,pu.username as username,pu.comcode as comcode,pc.comcname as comname from prpduser pu,prpdcompany pc where pu.comcode=pc.comcode",
        "index" : "agri02",
        "type":"prpduser" 
   }
}' | java \
       -cp "${lib}/*" \
       -Dlog4j.configurationFile=${bin}/log4j2.xml \
       org.xbib.tools.Runner \
       org.xbib.tools.JDBCImporter
```
**注意：`_id`oracle不能识别，会报错`ORA-00911:无效字符`，所以脚本中`_id`得修改为` \"_id\"`**

# 4 标准配置参考
`oracle-connection-properties.sh`
```
#!/bin/sh
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
bin=${DIR}/../bin
lib=${DIR}/../lib

echo '
{
    "type" : "jdbc",
    "jdbc" : {
        "url" : "jdbc:oracle:thin:@//host:1521/sid",
        "connection_properties" : {
            "oracle.jdbc.TcpNoDelay" : false,
            "useFetchSizeWithLongColumn" : false,
            "oracle.net.CONNECT_TIMEOUT" : 10000,
            "oracle.jdbc.ReadTimeout" : 50000
        },
        "user" : "user",
        "password" : "password",
        "sql" : "select or_id as \"_id\", or_tan as \"tan\" from orders",
        "index" : "myoracle",
        "type" : "myoracle",
        "elasticsearch" : {
            "cluster" : "elasticsearch",
            "host" : "localhost",
            "port" : 9300
        },
        "max_bulk_actions" : 20000,
        "max_concurrent_bulk_requests" : 10,
        "index_settings" : {
            "index" : {
                "number_of_shards" : 1,
                "number_of_replica" : 0
            }
        }
    }
}
' | java \
    -cp "${lib}/*" \
    -Dlog4j.configurationFile=${bin}/log4j2.xml \
    org.xbib.tools.Runner \
    org.xbib.tools.JDBCImporter

```
# 5 增量同步数据
**注意：目前只能实现新增，修改的数据同步，删除的无法实现**
```
#!/bin/sh
bin=$JDBC_IMPORTER_HOME/bin
lib=$JDBC_IMPORTER_HOME/lib
echo '{
    "jdbc" : {
        "url" : "jdbc:oracle:thin:@192.168.0.4:1521/agri",
        "statefile" : "agri02.json",          
        "schedule" : "0/5 0-59 0-23 ? * *",
        "user" : "gyic",
        "password" : "gyic1001",
        "sql" : [{"statement":"select pu.usercode as \"_id\",pu.usercode as usercode,pu.username as username,pu.comcode as comcode from prpduser pu where  UPDATEDATE >? ","parameter" : [ "$metrics.lastexecutionstart" ]}],
        "index" : "agri02",
        "type":"prpduser" 
   }
}' | java \
       -cp "${lib}/*" \
       -Dlog4j.configurationFile=${bin}/log4j2.xml \
       org.xbib.tools.Runner \
       org.xbib.tools.JDBCImporter
```
-  为了让 oracle-test01.sh后台执行，我们可以使用 nohup 命令。
- statefile ：计划任务状态文件名称。内容如下：  
    **注意：调整时间活参数时需要删除此文件，否则配置不生效**

```
{
  "type" : "jdbc",
  "jdbc" : {
    "schedule" : "0/5 0-59 0-23 ? * *",
    "password" : "gyic1001",
    "index" : "agri02",
    "statefile" : "agri02.json",
    "metrics" : {
      "lastexecutionstart" : "2017-10-23T14:40:27.051Z",
      "lastexecutionend" : "2017-10-23T14:40:27.082Z",
      "counter" : "16"
    },
    "type" : "prpduser",
    "user" : "gyic",
    "url" : "jdbc:oracle:thin:@192.168.0.4:1521/agri",
    "sql" : [ {
      "statement" : "select pu.usercode as \"_id\",pu.usercode as usercode,pu.username as username,pu.comcode as comcode from prpduser pu where  UPDATEDATE >? ",
      "parameter" : [ "$metrics.lastexecutionstart" ]
    } ]
  }
}
```
- schedule：计划任务时间表。表示多久执行一次更新。  
样例：
0 0-59 0-23 ? * *：每分钟执行一次  
0 0/5 0-23 ? * * ：每五分钟执行一次；当分钟等于 0，5，…55的时候执行

 **注意：调整时间活参数时需要删除statefile文件，否则配置不生效**
 
字段名称|允许的值|允许的特殊字符
 ---|---|---
Seconds|0-59|, - * /  
Minutes|0-59|, - * / 
Hours  |0-23| , - * / 
Day-of-month| 1-31|, - * ? / L W 
Month |1-12 or JAN-DEC |, - * / 
Day-of-Week|1-7 or SUN-SAT|, - * ? / L # 
Year (Optional)|empty, 1970-2199|, - * /




