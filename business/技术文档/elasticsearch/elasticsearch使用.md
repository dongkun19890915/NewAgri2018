# EsClient
> 一个elasticsearch客户端调用解决方案，主要提供文档数据的CURD操作，以及说明了数据同步的方案。

> 目前为了照顾低版本jdk系统，开发基线JDK版本为1.6，后续会陆续推出spring集成版本。

## 更新记录

- 0.0.6-SNAPSHOT

> 优化API方式检索条件逻辑，重做了API模式构造器的实现逻辑，支持and (or) and (or)模式，每次调用must、should、mustnot方法都会作为一个独立子查询语句，相互为and的关系
不会再合并相同模式的查询条件，API调用增加MATCHPHRASE模式。

> 2017-09-27

- 0.0.5-SNAPSHOT

> 修复了高并发情况下，Http连接报错的问题，https请求添加同步锁。查询添加了异步调用方式。新增、更新数据默认为异步模式调用

> 2017-09-19

- 0.0.4-SNAPSHOT

> 排序增加了注解的方式,新增、更新、删除文档数据支持批量模式

> 2017-09-19

- 0.0.3-SNAPSHOT

> API方式增加大于小于方式、IN的方式，工厂入参调整为枚举，修复了高亮替换的BUG，修复了http客户端初始化慢的问题

> 2017-09-13

- 0.0.2-SNAPSHOT

> 搜索加入注解支持简化API，高亮字段设置优化，全文检索分割优化，重构代理层实现方式

> 2017-09-12

- 0.0.1-SNAPSHOT

> 初版

> 2017-09-08






> 最新版本下载地址：



## 使用准备
> 需要有一定的elasticsearch知识

> 工具包依赖详见如下POM，**注意，不可更改es工具包版本**，并引入esClinet.jar


```
<properties>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	<commons-io.version>2.4</commons-io.version>
	<commons-net.version>3.3</commons-net.version>
	<commons-beanutils.version>1.8.0</commons-beanutils.version>
	<commons-lang.version>2.6</commons-lang.version>
	<commons-lang3.version>3.4</commons-lang3.version>
	<commons-collections4.version>4.1</commons-collections4.version>
	<commons-logging.version>1.2</commons-logging.version>
	<fastjson.version>1.2.16</fastjson.version>
</properties>

<dependency>
    <groupId>org.elasticsearch</groupId>
    <artifactId>elasticsearch</artifactId>
    <version>0.19.11</version>
</dependency>
<dependency>
  <groupId>io.searchbox</groupId>
  <artifactId>jest</artifactId>
  <version>0.0.3</version>
</dependency>
<dependency>
	<groupId>commons-io</groupId>
	<artifactId>commons-io</artifactId>
	<version>${commons-io.version}</version>
</dependency>
<dependency>
	<groupId>commons-net</groupId>
	<artifactId>commons-net</artifactId>
	<version>${commons-net.version}</version>
</dependency>
<dependency>
	<groupId>commons-beanutils</groupId>
	<artifactId>commons-beanutils</artifactId>
	<version>${commons-beanutils.version}</version>
</dependency>
<dependency>
	<groupId>commons-lang</groupId>
	<artifactId>commons-lang</artifactId>
	<version>${commons-lang.version}</version>
</dependency>
<dependency>
	<groupId>org.apache.commons</groupId>
	<artifactId>commons-lang3</artifactId>
	<version>${commons-lang3.version}</version>
</dependency>
<dependency>
	<groupId>org.apache.commons</groupId>
	<artifactId>commons-collections4</artifactId>
	<version>${commons-collections4.version}</version>
</dependency>
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>fastjson</artifactId>
	<version>${fastjson.version}</version>
</dependency>
```


## 1. 检索数据


方式 | 底层 | 支持分页 | 支持高亮 | 支持排序 | 备注
---|---|---|---|---|---
JSON| http|是|半|是|
SQL| http|是|否|是|需要安装es-sql插件 
全文| http|是|半|是|
API| api|是|是|是|需要引入相关工具jar

### 1.1 JSON方式 
> 此方式是通过传送JSON报文并调用ES服务端接口来实现检索的方式，JSON报文为ES2.2版本的官网RESTAPI

> API参考地址：
- https://www.elastic.co/guide/en/elasticsearch/reference/current/docs.html
- http://www.cnblogs.com/yjf512/p/4862992.html

> 通过EsClient工厂获取查询服务，getESSearch方法的第一个参数需传_ESSEARCHTYPE.JSON（JSON方式）

```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESSearch<InsuredDto> esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.JSON, uri);
```

> 定义查询API（ES2.2版本官方API）

```
String condition = "{\"from\":0,\"size\":10,\"query\":{\"bool\":{\"must\":{\"match\":{\"_all\":\"zzxxpp11223344556677889900\"}}}}}";
```
> 设置查询信息，半支持高亮（需要同时在JSON中定义高亮条件，并在查询配置中设置对应高亮字段），分页、排序等需要在JSON中定义


```
ESSearchConfig esconfig = new ESSearchConfig();
/**设置索引类型*/
esconfig.set_indextype("insured");
/**设置索引名称*/
esconfig.set_indexname("index");
/**设置查询条件*/
esconfig.setCondition(condition);
/**设置是否打印报文*/
esconfig.set_showLog(true);
/**设置是否打印报文*/
esconfig.set_highlightFields("address,riskname");

esSearch.setEsconfig(esconfig);
```

> 调用检索方法


```
ESSearchResponse<InsuredDto> insuredList = esSearch.search(InsuredDto.class);
```



### 1.2 SQL方式 

> 此方式是通过MYSQL语句来执行数据检索（需要自行安装es-sql插件，和系统使用数据库无关）

> 通过EsClient工厂获取查询服务，getESSearch方法的第一个参数需传_ESSEARCHTYPE.SQL（SQL方式）

```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESSearch<InsuredDto> esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.SQL, uri);
```

> 定义查询SQL，请注意，分页、排序需要按照MYSQL语法写，分页也支持通过配置设置

```
String condition = "SELECT * FROM insured where _all = 'zzxxpp11223344556677889900' limit 0,10";
```
> 设置查询信息，不支持高亮


```
ESSearchConfig esconfig = new ESSearchConfig();
/**设置索引类型*/
esconfig.set_indextype("insured");
/**设置索引名称*/
esconfig.set_indexname("index");
/**设置查询条件*/
esconfig.setCondition(condition);
/**设置是否打印报文*/
esconfig.set_showLog(true);

esSearch.setEsconfig(esconfig);
```
> 调用检索方法


```
ESSearchResponse<InsuredDto> insuredList = esSearch.search(InsuredDto.class);
```

### 1.3 全文检索方式 

> 此方式是通过传入一个或多个关键字（多个关键字以半角空格分割）进行的相关性检索，此模式必须设置分页信息

> 检索策略为：

```
graph LR
term拆分查询-->|没查到|match拆分查询
match拆分查询-->|没查到|match整体查询
match整体查询-->|没查到|通配符查询
```

> 通过EsClient工厂获取查询服务，getESSearch方法的第一个参数需传_ESSEARCHTYPE.FULLTEXT（全文检索方式）

```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESSearch<InsuredDto> esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.FULLTEXT, uri);
```

> 定义全文查询内容，即EsClient会根据设置的查询内容根据设定的索引范围进行查询（检索策略见上文），也可以录入多项关键字进行查询，以半角空格分割

```
String condition = "zzxxpp11223344556677889900";
```
> 设置查询信息

```
ESSearchConfig esconfig = new ESSearchConfig();
/**设置索引类型*/
esconfig.set_typename("insured");
/**设置索引名称*/
esconfig.set_indexname("index");
/**设置查询条件*/
esconfig.setCondition(condition);
/**设置是否打印报文*/
esconfig.set_showLog(true);
/**设置高亮字段，以,分割*/
esconfig.set_highlightFields("address,riskname");
/**设置当前页数 从1开始*/
esconfig.setCurrentPage(1);
/**设置每页数量*/
esconfig.set_itemsPerPage(10);
/**设置升序字段 以,分割*/
esconfig.set_asc("address");
/**设置降序字段 以,分割*/
esconfig.set_desc("address");

esSearch.setEsconfig(esconfig);
```
> 调用检索方法

```
ESSearchResponse<InsuredDto> insuredList = esSearch.search(InsuredDto.class);
```

### 1.4 API方式 

> 此方式是调用封装后的JEST（ES的java客户端工具，但仍然基于http方式）API进行调用检索

> 目前支持的关系方式有

1. must（与）

```
constructor.must(new ESSearchBuliders().term("id", "zzxxpp11223344556677889900"))
```

2. should（或）

```
constructor.should(new ESSearchBuliders().term("id", "zzxxpp11223344556677889900"))
```

> 封装了in的实现，调用下面should方法可实现in的操作

```
String[] modelcodeTree = {"BJFAAI0001","ZZZZZI0154","HSHZZD0011"}; 
constructor.should("modelcode",modelcodeTree,_ESDSL.Operator.TERM); 
```



3. mustNot（非）

```
constructor.mustNot(new ESSearchBuliders().term("id", "zzxxpp11223344556677889900"))
```

> 目前支持的比较方式有

1. term（term匹配）

```
constructor.must(new ESSearchBuliders().term("id", "zzxxpp11223344556677889900"))
```

2. terms（多个term匹配，类似于SQL中的in）

```
Collection<Object> c = new ArrayList<Object>();
c.add("A");
c.add("B");
constructor.should(new ESSearchBuliders().terms("id", c))
```

3. match（match匹配）

```
constructor.must(new ESSearchBuliders().match("address", "陕西西安"))
```

4. wildcard（通配符匹配，?单字通配、*多字通配）

```
constructor.must(new ESSearchBuliders().wildcard("wildcard", "*ABC"))
```

5. fuzzy（相似度查询）

```
constructor.must(new ESSearchBuliders().fuzzy("fuzzy", "sting"))
```

6. range（范围查询）

```
constructor.must(new ESSearchBuliders().range("purchaseprice", 2100, 2200, true, false))
```

7. rangelt（小于）

```
constructor.must(new ESSearchBuliders().rangelt("purchaseprice", 2100))
```

8. rangele（小于等于）

```
constructor.must(new ESSearchBuliders().rangelte("purchaseprice", 2100))
```

9. rangegt（大于）

```
constructor.must(new ESSearchBuliders().rangegt("purchaseprice", 2100))
```

10. rangege（大于等于）

```
constructor.must(new ESSearchBuliders().rangegte("purchaseprice", 2100))
```

11. MATCHPHRASE（全字匹配）

```
constructor.must(new ESSearchBuliders().matchPhrase("modelname", "123"))
```

> 通过EsClient工厂获取查询服务，getESSearch方法的第一个参数需传_ESSEARCHTYPE.API（API方式）

```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESSearch<InsuredDto> esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.API, uri);
```

> 定义查询ESSearchJestBuliderConstructor

```
ESSearchJestBuliderConstructor constructor = new ESSearchJestBuliderConstructor();
constructor.must(new ESSearchBuliders().term("id", "zzxxpp11223344556677889900"))
```
> 设置查询信息

```
ESSearchConfig esconfig = new ESSearchConfig();
/**设置索引类型*/
esconfig.set_indextype("insured");
/**设置索引名称*/
esconfig.set_indexname("index");
/**设置查询条件*/
esconfig.setCondition(condition);
/**设置高亮字段，以,分割*/
esconfig.set_highlightFields("address,riskname");
/**设置是否打印报文*/
esconfig.set_showLog(true);
/**设置当前页数 从1开始*/
esconfig.setCurrentPage(1);
/**设置每页数辆*/
esconfig.set_itemsPerPage(10);
/**设置升序字段 以,分割*/
esconfig.set_asc("address");
/**设置降序字段 以,分割*/
esconfig.set_desc("address");
/**设置constructor*/
esconfig.setConstructor(constructor);

esSearch.setEsconfig(esconfig);
```
> 调用检索方法

```
ESSearchResponse<InsuredDto> insuredList = esSearch.search(InsuredDto.class);
```
### 1.5 设置排序

> JSON方式设置排序需要定义在JSON报文中、SQL方式设置排序需要定义在SQL中

> API、全文检索方式以如下方式设置

> 请勿同时使用

```
/**设置升序字段 以,分割*/
esconfig.set_asc("address");
/**设置降序字段 以,分割*/
esconfig.set_desc("address");

esSearch.setEsconfig(esconfig);
```

### 1.6 设置分页

> JSON方式设置分页需要定义在JSON报文中、SQL方式设置分页需要定义在SQL中

> API、全文检索方式以如下方式设置


```
/**设置当前页数 从1开始*/
esconfig.setCurrentPage(1);
/**设置每页数量*/
esconfig.set_itemsPerPage(10);
```

### 1.7 设置高亮

> JSON方式设置高亮需要分别在JSON报文和设置对象中定义、SQL方式不支持高亮

> API、全文检索方式以如下方式设置


```
/**设置高亮字段，以,分割*/
esconfig.set_highlightFields("address,riskname");
```

> 返回对象中，如果设置的字段存在高亮信息（被检索的内容），那么返回对象的对应字段直接以HTML高亮代码返回（默认背景色为黄色）


### 1.8 返回对象ESSearchResponse的描述

- T[] out：检索结果数据
- int count：查询结果总数量
- long longtimes：查询耗时
- String request：请求报文
- String response：返回报文
- 当前页数量为out.length

### 1.9 使用注解方式简化API调用
> esconfig只需要设置查询条件即可，esconfig设置值优先级大于注解配置

> 注解都是需要声明再规则引擎出入参数Dto类中

> 可以被注解替代的配置

```
/**设置索引类型*/
esconfig.set_indextype("insured");
/**设置索引名称*/
esconfig.set_indexname("index");
/**设置高亮字段，以,分割*/
esconfig.set_highlightFields("address,riskname");
/**设置是否打印报文*/
esconfig.set_showLog(true);
/**设置每页数辆*/
esconfig.set_itemsPerPage(10);
/**设置升序字段 以,分割*/
esconfig.set_asc("address");
/**设置降序字段 以,分割*/
esconfig.set_desc("address");
```
> indexname、typename如何设置？

```
//在传入的Class中定义头部注解
@ESIndex(indexName="index",indexType="insured")
public class InsuredDto {
……
```

> 高亮如何设置？


```
//如果定义在类头部，则所有声明字段全部可以返回高亮
@ESHighLight
public class InsuredDto {
```


```
//如果定义在字段上，则所对应字段可以返回高亮，如下例：insuredname、address可返回高亮
@ESHighLight
private String insuredname;
private String riskname;
private String idNum;
@ESHighLight
private String address;
```


> 打印交互信息以及报文如何设置？


```
@ESShowLog
public class InsuredDto {
```

```
//输出内容如下
=====搜索引擎查询信息=====                                                               
【ESPRINT:2017-09-12 11:19:32】索引名称（库）:index 索引类型（表）:insured
【ESPRINT:2017-09-12 11:19:33】查询总数量：1
【ESPRINT:2017-09-12 11:19:33】当前分页数量：1
【ESPRINT:2017-09-12 11:19:33】查询时间（毫秒）:1894
【ESPRINT:2017-09-12 11:19:33】请求报文:{"from":0,"size":10,"query":{"bool":{"must":{"mat……
【ESPRINT:2017-09-12 11:19:33】返回报文:{"took":43,"timed_out":false,"_shards":{"total":5……
总数量：1
当前数量：1
查询时间（毫秒）：1894
==================每条内容===================
InsuredDto [id=zzxxpp11223344556677889900, policyno=null, insuredname=你好7, riskname=nul……
```

> 分页信息如何设置


```
//_itemsPerPage表示每页条数
@ESPagination(_itemsPerPage=10)
public class InsuredDto {
```

> 排序如何设置


```
@ESSortAsc
private String endDate         = "";
@ESSortDesc
private String policyNo        = "";
```


## 2. 新增数据
> 通过注解的方式配置新增数据的索引信息

> 类头部配置索引名称和类型的注解[@ESIndex]

```
@ESIndex(indexName="index",indexType="insured")
public class InsuredDto {
……
```

> 在字段中配置索引ID的注解[@ESId]


```
@ESId
private String id;
```

> 通过EsClient工厂获取更新服务


```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESHandle esHandle = eSSearchFactory.getESHandle( uri);
```
> 对需要新增文档数据的对象进行赋值


```
InsuredDto dto = new InsuredDto();
dto.setId("zzxxpp11223344556677889900");
dto.setInsuredname("你好7");
```

> 调用新增文档API，返回值为成功或失败，布尔类型值


```
boolean flag = esHandle.insertDoc(dto);
```



## 3. 更新数据

> 注解配置详见新增数据部分

> 通过EsClient工厂获取更新服务


```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESHandle esHandle = eSSearchFactory.getESHandle( uri);
```
> 对需要更新文档数据的对象进行赋值


```
InsuredDto dto = new InsuredDto();
dto.setId("zzxxpp11223344556677889900");
dto.setInsuredname("你好7");
```

> 调用更新文档API，返回值为成功或失败，布尔类型值


```
boolean flag = esHandle.updateDoc(dto);
```



## 4. 删除数据

> 注解配置详见新增数据部分

> 通过EsClient工厂获取更新服务


```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESHandle esHandle = eSSearchFactory.getESHandle( uri);
```
> 对需要更新文档数据的删除进行赋值，可以只赋值ESID注解字段的值即可


```
InsuredDto dto = new InsuredDto();
dto.setId("zzxxpp11223344556677889900");
```

> 调用删除文档API，返回值为成功或失败，布尔类型值


```
boolean flag = esHandle.deleteDoc(dto);
```

## 5. 批量操作

> 注解配置详见新增数据部分

> 通过EsClient工厂获取更新服务


```
String uri = "http://localhost:9200";
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESHandle esHandle = eSSearchFactory.getESHandle( uri);
```

> 对需要更新文档数据的删除进行赋值，可以只赋值ESID注解字段的值即可

```
ArrayList<InsuredDto> ar = new ArrayList<InsuredDto>();
for (int i = 0; i < 10; i++) {
    InsuredDto dto = new InsuredDto();
    dto.setInsuredCode("zzxxpp1122334455667788990a" + (i));
    dto.setId("zzxxpp1122334455667788990a" + (i));
    dto.setInsuredname("你好" + (i));
    ar.add(dto);
}
```

> 定义回调接口实现类


```
BulkCallBack lll = new BulkCallBack() {
    @Override
    public void beforeBulk(String requestData) {
    	System.out.println("执行之前"+requestData);
    }
    @Override
    public void afterBulk(String requestData, String responseData) {
        System.out.println("执行完成"+responseData);
    }
    @Override
    public void afterBulk(String requestData, Throwable failure) {
        System.out.println("执行异常");
    }
};
```
> 调用批量操作方法


```
esHandle.bulkProcess(lll, ar, _ESBULKOP.INSERT);
```

> 批量操作包括：

1. _ESBULKOP.DELETE 批量删除
2. _ESBULKOP.UPDATE 批量更新
3. _ESBULKOP.INSERT 批量插入

## 6.异步查询、新增、更新、删除数据

> 异步查询调用API详见以下示例代码


```
String uri = "http://localhost:9200";
ESSearchConfig esconfig = new ESSearchConfig();
String condition = "{\"from\":0,\"size\":10,\"query\":{\"bool\":{\"must\":{\"match\":{\"_all\":\"zzxxpp11223344556677889900\"}}}}}";
esconfig.setCondition(condition);
ESClientFactory<InsuredDto> eSSearchFactory = new ESClientFactory<InsuredDto>();
ESSearch<InsuredDto> esSearch = null;
//获取ES查询组件
esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.JSON, uri, esconfig);
//通过线程池工具类执行查询
//需要传入一个ESSearchThreadCallBack接口的实现类，以便于回调
ESSearchThreadPool.excutesAsyn(esSearch, InsuredDto.class, new ESSearchThreadCallBack() {
    @Override
    public void callBack(ESSearchResponse esSearchResponse) {
        printMessage(esSearchResponse);
    }
});
```

> 异步新增、更新、删除数据

> 默认以异步方式调用新增、更新、删除操作，API无变化

> 如果不想以异步方式执行，则需要在入参对象类注解上添加：


```
@ESSearchWithoutThreadPool
public class InsuredDto {
……
```

> 批量更新数据暂未实现异步处理方式



## 7. 同步数据
> 安装插件：elasticsearch-jdbc

> 参考资料：
- https://github.com/jprante/elasticsearch-jdbc
- http://blog.csdn.net/laoyang360/article/details/51694519

> 操作过程（window本地操作）
1. 下载elasticsearch-jdbc并解压
2. 新建oracle_to_es.bat文件：
> 主要配置参数说明：

> elasticsearch.cluster 集群名称，必须设置（与es服务配置相同）

> elasticsearch.port 传输端口，必须设置（注意：需要设置为transport_address的端口）

> sql 同步sql

> 其他参数详见官方文档

```
@echo off
 
set DIR=%~dp0
set LIB=%DIR%..\lib\*
set BIN=%DIR%..\bin
 
 
set JAVA_HOME=C:\java\jdk1.8.0_101
 
echo {^
      "type" : "jdbc",^
      "jdbc" : {^
          "url" :   "jdbc:oracle:thin:@10.28.1.10:1521:coreoracle",^
          "user" : "online_old",^
          "password" : "online_old",^
          "sql" :  "select modelcode as \"_id\",modelcode as \"modelcode\",modelname as \"modelname\",carbrand as \"carbrand\",carseriesname as \"carseriesname\",carkind as \"carkind\",purchaseprice as \"purchaseprice\",factory as \"factory\",platdeptname as \"platdeptname\" from prpdcarmodelnew",^
          "elasticsearch" : {^
             "host" :   "localhost",^
             "cluster" : "elasticsearch",^
             "port" : 9300,^
             "autodiscover" : false^
          },^
          "index" : "car",^
          "type" : "carModel"^
        }^
}^ | "%JAVA_HOME%\bin\java" -cp   "%LIB%" -Dlog4j.configurationFile="%BIN%\log4j2.xml"   "org.xbib.tools.Runner" "org.xbib.tools.JDBCImporter"

```

3. 将oracle驱动包拷贝到elasticsearch-jdbc/lib，注意：jdk1.8需要ojdbc7.jar
4. 启动oracle_to_es.bat（日志详见elasticsearch-jdbc/bin/logs/jdbc.log）
5. 建议同步前，将index、type、mapping建立好
6. 建议es服务提前建立为集群模式，其中集群名称需要与jdbc插件配置项elasticsearch.cluster对应，端口设置为es服务传输端口（注意：与CURD接口不同，默认9300）


## 7. 【附】技术配方

> jest、elasticsearch、动态代理、责任链、简单工厂、spring、注解、反射

