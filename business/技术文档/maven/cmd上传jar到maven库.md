# cmd上传jar到maven库
## 命令
```
mvn --settings c:\user\settings.xml  deploy:deploy-file -DgroupId=com.xy.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.4.0 -Dpackaging=jar -Dfile=E:\ojdbc14.jar -Durl=http://localhost:9090/nexus-2.2-01/content/repositories/thirdparty/ -DrepositoryId=thirdparty
```
## 参数说明
- DgroupId和DartifactId构成了该jar包在pom.xml的坐标，项目就是依靠这两个属性定位。自己起名字也行。
- Dfile表示需要上传的jar包的绝对路径。
- Durl私服上仓库的位置，打开nexus——>repositories菜单，可以看到该路径。
- DrepositoryId服务器的表示id，在nexus的configuration可以看到。
- Dversion表示版本信息，怎样得到一个jar包准确的版本呢

## 样例
```
mvn --settings D:\software\maven\repos\NewAgriculturalInsurance\settings.xml  deploy:deploy-file -DgroupId=com.sinosoft -DartifactId=esClient -Dversion=0.0.5-SNAPSHOT -Dpackaging=jar -Dfile=C:\Users\zhoujiawei\Desktop\esClient-0.0.5-SNAPSHOT.jar -Durl=http://192.168.0.2:9081/nexus/content/repositories/AgriculturalInsuranceS/ -DrepositoryId=sinosoft-AgriculturalInsuranceR
```