# 1 application.yml文件
```
myProps: #自定义的属性和值  
  simpleProp: asfssdfsdsfffssdfsfss
  arrayProps: 1,2,3,4,5  
  listProp1:  
    - name: abc
      value: abcValue  
    - name: efg  
      value: efgValue  
  listProp2:  
    - config2Value1  
    - config2Vavlue2  
  mapProps:  
    key1: value1  
    key2: value2  
```
- 如果在配置中需要配置集合的话，我们需要使用“-”符号
- 属性名的值和冒号中间必须有空格
- 注释用#
- 属性命名:
    - person.firstName，标准的驼峰式命名  
    - person.first-name，虚线（-）分割方式，推荐在.properties和.yml配置文件中使用  
    - PERSON_FIRST_NAME，大写下划线形式，建议在系统环境变量中使用


# 2 yml文件读取
## 2.1 注解注入
```
@Value(“${myProps.simpleProp}”)
private String simpleProp;
```
## 2.2 javaBean注入
```    
@Component
@ConfigurationProperties(prefix = "myProps") //接收application.yml中的myProps下面的属性
public class YmlConfig {
    private String simpleProp;
    private String[] arrayProps;
    private List<Map<String,String>> listProp1=new ArrayList<>();
    private List<String> listProp2=new ArrayList<>();
    private Map<String,String> mapProps=new HashMap<>();
    //省略get set
}
```
