package com.sinosoft.demo.elasticsearch.dto;

import com.sinosoft.demo.elasticsearch.dto.PrpDuserDto;
import com.sinosoft.esClient.core.factory.ESClientFactory;
import com.sinosoft.esClient.core.factory._ESSEARCHTYPE;
import com.sinosoft.esClient.core.handle.ESHandle;
import com.sinosoft.esClient.core.jest.ESSearchBuliders;
import com.sinosoft.esClient.core.jest.ESSearchJestBuliderConstructor;
import com.sinosoft.esClient.core.search.ESSearch;
import com.sinosoft.esClient.core.search.dto.ESSearchConfig;
import com.sinosoft.esClient.core.search.dto.response.ESSearchResponse;
import org.junit.Test;

 /**
 * @Description:ElasticSearch样例代码
 * 1查询
 * 1.1.JSON方式 jsonQueryTest()
 * 1.2.SQL方式  sqlQueryTest()
 * 1.3.API方式 apiQueryTest()
 *
 * @Author: 周家伟
 * @Date: 2017/10/19 15:23
 */
public class ElasticSearchTest {
    /** ElasticSearch地址 */
    private String esUri="http://192.168.0.6:9200";

    /**
     * @description: json方式  ElasticSearch查询样例代码
     * @author: 周家伟
     * @date: 2017/10/19 15:24
     * @throws Exception
     */
    @Test
    public void jsonQueryTest(){
        try {
            System.out.println(esUri);
            ESClientFactory<PrpDuserDto> eSSearchFactory = new ESClientFactory<PrpDuserDto>();
            ESSearch<PrpDuserDto> esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.JSON, esUri);
            //定义查询API（ES2.2版本官方API）
            String condition = "{\"from\": 0,\"size\": 5}";
            //设置查询信息，半支持高亮（需要同时在JSON中定义高亮条件，并在查询配置中设置对应高亮字段），分页、排序等需要在JSON中定义
            ESSearchConfig esconfig = new ESSearchConfig();
            /**设置索引名称*/
            esconfig.set_indexname("agri");
            /**设置索引类型*/
            esconfig.set_indextype("prpduser");
            /**设置查询条件*/
            esconfig.setCondition(condition);
            /**设置是否打印报文*/
            esconfig.set_showLog(true);
            /**设置是否打印报文*/
            esconfig.set_highlightFields("usercode");

            esSearch.setEsconfig(esconfig);
            //注意： PrpDuserDto中一定要由id,使用@ESId注解，否则查询报错
            ESSearchResponse<PrpDuserDto> insuredList = esSearch.search(PrpDuserDto.class);
            for(PrpDuserDto prpDuserDto:insuredList.getOut()){
                System.out.println(prpDuserDto.getId()+"---"+prpDuserDto.getName()+"---"+prpDuserDto.getUsercode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description: SQL方式  ElasticSearch查询样例代码
     * @author: 周家伟
     * @date: 2017/10/19 16:46
     */
    @Test
    public void sqlQueryTest(){
        try {
            ESClientFactory<PrpDuserDto> eSSearchFactory = new ESClientFactory<PrpDuserDto>();
            ESSearch<PrpDuserDto> esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.SQL, esUri);
            //定义查询SQL，请注意，分页、排序需要按照MYSQL语法写，分页也支持通过配置设置
            String condition = "SELECT * FROM prpduser limit 0,5";
            //设置查询信息，不支持高亮
            ESSearchConfig esconfig = new ESSearchConfig();
            /**设置索引类型*/
            esconfig.set_indextype("prpduser");
            /**设置索引名称*/
            esconfig.set_indexname("agri");
            /**设置查询条件*/
            esconfig.setCondition(condition);
            /**设置是否打印报文*/
            esconfig.set_showLog(true);

            esSearch.setEsconfig(esconfig);
            //调用检索方法
            ESSearchResponse<PrpDuserDto> insuredList = esSearch.search(PrpDuserDto.class);
            for(PrpDuserDto prpDuserDto:insuredList.getOut()){
                System.out.println(prpDuserDto.getId()+"---"+prpDuserDto.getName()+"---"+prpDuserDto.getUsercode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

     /**
      * @description: API方式  ElasticSearch查询样例代码
      * @author: 周家伟
      * @date: 2017/10/19 16:48
      */
    @Test
    public void apiQueryTest(){
        try {
            //通过EsClient工厂获取查询服务，getESSearch方法的第一个参数需传_ESSEARCHTYPE.API（API方式）
            ESClientFactory<PrpDuserDto> eSSearchFactory = new ESClientFactory<PrpDuserDto>();
            ESSearch<PrpDuserDto> esSearch = eSSearchFactory.getESSearch(_ESSEARCHTYPE.API, esUri);

            //定义查询ESSearchJestBuliderConstructor
            ESSearchJestBuliderConstructor constructor = new ESSearchJestBuliderConstructor();
            constructor.must(new ESSearchBuliders().term("name", "zhangsan"));

            //设置查询信息
            ESSearchConfig esconfig = new ESSearchConfig();
            /**设置索引类型*/
            esconfig.set_indextype("prpduser");
            /**设置索引名称*/
            esconfig.set_indexname("agri");
            /**设置高亮字段，以,分割*/
            esconfig.set_highlightFields("name");
            /**设置是否打印报文*/
            esconfig.set_showLog(true);
            /**设置当前页数 从1开始*/
            esconfig.setCurrentPage(1);
            /**设置每页数辆*/
            esconfig.set_itemsPerPage(10);
            esconfig.setConstructor(constructor);
            esSearch.setEsconfig(esconfig);

            //调用检索方法
            ESSearchResponse<PrpDuserDto> insuredList = esSearch.search(PrpDuserDto.class);
            for(PrpDuserDto prpDuserDto:insuredList.getOut()){
                System.out.println(prpDuserDto.getId()+"---"+prpDuserDto.getName()+"---"+prpDuserDto.getUsercode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /**
      * @description: ElasticSearch 新增数数据
      * @author: 周家伟
      * @date: 2017/10/23 9:37
      */
    @Test
    public void insertTest(){
        try {
            // 通过EsClient工厂获取更新服务
            ESClientFactory<PrpDuser2Dto> eSSearchFactory = new ESClientFactory<PrpDuser2Dto>();
            ESHandle esHandle = eSSearchFactory.getESHandle( esUri);

            // 对需要新增文档数据的对象进行赋值
            PrpDuser2Dto prpDuser2Dto = new PrpDuser2Dto();
            prpDuser2Dto.setId("000005");
            prpDuser2Dto.setUsercode("000004");
            prpDuser2Dto.setName("张三4");

            // 调用新增文档API，返回值为成功或失败，布尔类型值
            boolean flag = esHandle.insertDoc(prpDuser2Dto);
            System.out.println(flag?"提交成功！":"提交失败！");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     /**
      * @description: ElasticSearch 更新操作
      * @author: 周家伟
      * @date: 2017/10/23 9:55
      */
    @Test
    public void updateTest(){
        try {
            // 通过EsClient工厂获取更新服务
            ESClientFactory<PrpDuser2Dto> eSSearchFactory = new ESClientFactory<PrpDuser2Dto>();
            ESHandle esHandle = eSSearchFactory.getESHandle(esUri);

            // 对需要更新文档数据的对象进行赋值
            PrpDuser2Dto prpDuser2Dto = new PrpDuser2Dto();
            prpDuser2Dto.setId("000005");
            prpDuser2Dto.setUsercode("000005");
            prpDuser2Dto.setName("张三5");

            // 调用更新文档API，返回值为成功或失败，布尔类型值
            boolean flag = esHandle.updateDoc(prpDuser2Dto);
            System.out.println(flag?"更新成功！":"更新失败！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

     /**
      * @description: ElasticSearch 删除操作
      * @author: 周家伟
      * @date: 2017/10/23 9:58
      */
    @Test
    public void deleteTest(){
        try {
            // 通过EsClient工厂获取更新服务
            ESClientFactory<PrpDuser2Dto> eSSearchFactory = new ESClientFactory<PrpDuser2Dto>();
            ESHandle esHandle = eSSearchFactory.getESHandle( esUri);

            // 对需要更新文档数据的删除进行赋值，可以只赋值ESID注解字段的值即可
            PrpDuser2Dto prpDuser2Dto = new PrpDuser2Dto();
            prpDuser2Dto.setId("000005");

            // 调用删除文档API，返回值为成功或失败，布尔类型值
            boolean flag = esHandle.deleteDoc(prpDuser2Dto);
            System.out.println(flag?"删除成功！":"删除失败！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
