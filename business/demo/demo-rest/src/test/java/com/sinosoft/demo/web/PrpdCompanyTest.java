package com.sinosoft.demo.web;

import com.alibaba.fastjson.JSON;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2017-12-27 10:31
 */
public class PrpdCompanyTest {
    public static void main(String[] args) {
        List<PrpdCompany> list = initData();

        parseTree(list);
    }

    //根据数据生成tree
    public static List<PrpdCompany> parseTree( List<PrpdCompany> list ){

        List<PrpdCompany> treeList=new ArrayList<>();

        //找出一级菜单
        for(PrpdCompany prpdCompany:list){
            if(prpdCompany.getComcode().equals("0000000000")){
                treeList.add(prpdCompany);
            }
        }

        for(PrpdCompany prpdCompany:treeList){
            //获取子集
            List<PrpdCompany> childs=getChilds(list,prpdCompany.getComcode());
            prpdCompany.setChilds(childs);
        }

        //输出结果
        String str= JSON.toJSONString(treeList);
        System.out.println(str);

        return treeList;
    }

    //获取子集
    public static List<PrpdCompany> getChilds(List<PrpdCompany> list ,String comcode){
        List<PrpdCompany> childs=new ArrayList<>();

        //获取子集
        for(PrpdCompany prpdCompany:list){
            //查询子集的父id 并且自己不能等于自己
            if(prpdCompany.getUppercomcode().equals(comcode)&&!prpdCompany.getComcode().equals(comcode)){
                childs.add(prpdCompany);
            }
        }

        for(PrpdCompany p:childs){
            //递归获取子集
            List<PrpdCompany> prpdCompanies=getChilds(list,p.getComcode());
            p.setChilds(prpdCompanies);
        }
        if(childs.size()==0){
            return null;
        }

        return childs;
    }

    /**
     * 初始化数据
     * @return
     */
    public static List<PrpdCompany> initData() {
        List<PrpdCompany> list = new ArrayList<>();

        list.add(new PrpdCompany("0000000000", "总公司", "0000000000"));
        list.add(new PrpdCompany("0000000100", "公司领导", "0000000000"));
        list.add(new PrpdCompany("0000000200", "公司办公室", "0000000000"));
        list.add(new PrpdCompany("0000000300", "公司人力资源部", "0000000000"));
        list.add(new PrpdCompany("0000000400", "公司财务会计部", "0000000000"));
        list.add(new PrpdCompany("0000000500", "公司发展研究部", "0000000000"));
        list.add(new PrpdCompany("0000000600", "公司农业保险部", "0000000000"));
        list.add(new PrpdCompany("0000000700", "公司财产保险部", "0000000000"));
        list.add(new PrpdCompany("0000000800", "公司客户服务部(停用)", "0000000000"));
        list.add(new PrpdCompany("0000000900", "公司信息技术部", "0000000000"));
        list.add(new PrpdCompany("0000001000", "公司资产管理部", "0000000000"));
        list.add(new PrpdCompany("0000001100", "公司稽核监察部", "0000000000"));
        list.add(new PrpdCompany("0000001200", "公司客户服务部", "0000000000"));
        list.add(new PrpdCompany("0000001300", "公司车辆保险部", "0000000000"));
        list.add(new PrpdCompany("0000001321", "中衡保险公估有限公司", "0000001300"));
        list.add(new PrpdCompany("0000001322", "上海大洋保险公估有限公司", "0000001300"));
        list.add(new PrpdCompany("0000001324", "天正保险公估有限公司", "0000001300"));
        list.add(new PrpdCompany("0000001325", "中太保险公估有限公司", "0000001300"));
        list.add(new PrpdCompany("0000001328", "方正保险公估有限公司", "0000001300"));
        list.add(new PrpdCompany("0000001400", "公司再保险部", "0000000000"));
        list.add(new PrpdCompany("0000001500", "公司法律合规部", "0000000000"));
        list.add(new PrpdCompany("0000001600", "公司行政管理部", "0000000000"));
        list.add(new PrpdCompany("0000001700", "公司承保管理部", "0000000000"));
        list.add(new PrpdCompany("0000001800", "公司理赔管理部", "0000000000"));
        list.add(new PrpdCompany("0000001900", "公司市场营销部", "0000000000"));
        list.add(new PrpdCompany("0000002000", "公司费用", "0000000000"));
        list.add(new PrpdCompany("0000002100", "公司省外机构调研组", "0000000000"));
        list.add(new PrpdCompany("0000002200", "公司河南分公司筹建组", "0000000000"));
        list.add(new PrpdCompany("0000002300", "公司健康保险部", "0000000000"));
        list.add(new PrpdCompany("0000002400", "公司纪检监察室", "0000000000"));
        list.add(new PrpdCompany("0000002500", "公司互联网保险部", "0000000000"));
        list.add(new PrpdCompany("0000002600", "公司团委", "0000000000"));
        list.add(new PrpdCompany("000000YL00", "医疗保险事业总部", "0000000000"));
        list.add(new PrpdCompany("000000YL01", "医保总部业务管理部", "000000YL00"));
        list.add(new PrpdCompany("000000YL02", "医保总部理赔管理部", "000000YL00"));
        list.add(new PrpdCompany("000000YL03", "医保总部医疗稽查部", "000000YL00"));
        list.add(new PrpdCompany("000000YL04", "医保总部综合管理部", "000000YL00"));
        list.add(new PrpdCompany("0000180001", "民太安公估深圳分公司", "0000001800"));
        list.add(new PrpdCompany("0000180002", "民太安公估有限公司河南分公司", "4100000000"));
        list.add(new PrpdCompany("0000180003", "河南恒兴保险公估有限公司", "4100000000"));
        list.add(new PrpdCompany("0000180004", "中衡保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180005", "上海大洋保险公估安徽分公司", "0000001800"));
        list.add(new PrpdCompany("0000180006", "中太保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180007", "方正保险公估有限公司安徽分公司", "0000001800"));
        list.add(new PrpdCompany("0000180008", "方正保险公估有限公司江苏分公司", "0000001800"));
        list.add(new PrpdCompany("0000180009", "新东方保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180010", "杭州安信保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180011", "泰诚保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180012", "天元保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180013", "龙江保险公估有限公司", "0000000100"));
        list.add(new PrpdCompany("0000180014", "西安水平保险公估有限公司", "0000000100"));
        list.add(new PrpdCompany("0000180015", "山东光政保险公估股份有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180016", "明嘉公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180017", "上海城市保险公估中心", "0000001800"));
        list.add(new PrpdCompany("0000180018", "德立信公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180019", "杭州华平保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180020", "圣源祥保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180021", "平正公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180022", "神舟公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180023", "安泰公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180024", "同正行保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180025", "天正保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180026", "河南龙郡查勘代理公司", "4100000000"));
        list.add(new PrpdCompany("0000180027", "南京阳光智恒保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180028", "河南志城保险查勘代理有限公司", "4100000000"));
        list.add(new PrpdCompany("0000180029", "定律安侯保险查勘代理有限公司", "4100000000"));
        list.add(new PrpdCompany("0000180030", "广泰查勘有限公司", "4100000000"));
        list.add(new PrpdCompany("0000180031", "泛华保险公估有限公司河南分公司", "4100000000"));
        list.add(new PrpdCompany("0000180032", "泛华保险公估有限公司深圳总公司", "0000001800"));
        list.add(new PrpdCompany("0000180033", "湖北阳昌保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180034", "颍海保险查勘代理有限公司", "4100000000"));
        list.add(new PrpdCompany("0000180035", "河南中鑫之宝保险查勘代理有限公司", "4100000000"));
        list.add(new PrpdCompany("0000180036", "合肥众保联信息技术有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180037", "安徽华瑞保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180038", "安徽振援保险公估有限公司", "0000001800"));
        list.add(new PrpdCompany("0000180039", "浙江联创保险销售有限公司河南分公司", "4100000000"));
        list.add(new PrpdCompany("0000180040", "恒邦保险销售服务有限公司", "4100000000"));
        list.add(new PrpdCompany("0000180041", "河南保尔保险代理有限公司代查勘", "4100000000"));
        list.add(new PrpdCompany("0000180042", "郑州瑞丰保险查勘代理有限公司驻马店分公司代查勘", "4100000000"));
        list.add(new PrpdCompany("0000180047", "合肥通保联信息技术有限公司", "0000001800"));
        list.add(new PrpdCompany("0088000000", "总公司直属营业部", "0000000000"));
        list.add(new PrpdCompany("0088000001", "总公司直属营业部合肥新梅汽车服务有限公司", "0088000000"));
        list.add(new PrpdCompany("0088000002", "总公司直属营业部安徽欣安康保险代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000003", "总公司直属营业部协和保险代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000004", "总公司直属营业部东衡保险代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000005", "直属营业部安徽锦和汽车代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000006", "直属营业部安徽金龙汽车代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000007", "直属营业部安徽双盛保险代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000008", "直属营业部安徽经略保险代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000009", "直属营业部安徽民盛保险代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000010", "直属营业部北京金诚国际保险安徽出单点", "0088000000"));
        list.add(new PrpdCompany("0088000011", "直属营业部合肥祥虎汽车服务公司出单点", "0088000000"));
        list.add(new PrpdCompany("0088000012", "直属营业部舒城大地汽贸出单点", "0088000000"));
        list.add(new PrpdCompany("0088000013", "直属营业部美联盛航保险代理出单点", "0088000000"));
        list.add(new PrpdCompany("0088000014", "直属营业部合肥鸿星盛泰汽车出单点", "0088000000"));
        list.add(new PrpdCompany("0088000015", "直属营业部大童保险安徽出单点", "0088000000"));
        list.add(new PrpdCompany("0088000300", "总公司直属营业部财务会计部", "0088000000"));
        list.add(new PrpdCompany("0088000800", "总公司直属营业部客户服务部", "0088000000"));
        list.add(new PrpdCompany("0088000900", "总公司直属营业部销售部", "0088000000"));
        list.add(new PrpdCompany("0088001000", "总公司直属营业部市场营销部", "0088000000"));
        list.add(new PrpdCompany("0088001100", "总公司直属营业部重点客户部", "0088000000"));
        list.add(new PrpdCompany("0088001200", "总公司直属营业部市场开发部", "0088000000"));
        list.add(new PrpdCompany("3400000000", "合肥中心支公司", "3488000000"));
        list.add(new PrpdCompany("3400000001", "合肥中心支公司怀远群力出单点", "3400000000"));
        list.add(new PrpdCompany("3400000002", "合肥中心支公司建华汽贸出单点", "3400000000"));
        list.add(new PrpdCompany("3400000003", "合肥中心支公司华天汽销出单点", "3400000000"));
        list.add(new PrpdCompany("3400000004", "合肥中心支公司渝皖汽销出单点", "3400000000"));
        list.add(new PrpdCompany("3400000005", "合肥中心支公司金武联出单点", "3400000000"));
        list.add(new PrpdCompany("3400000006", "合肥中心支公司奥美出单点", "3400000000"));
        list.add(new PrpdCompany("3400000007", "合肥中心支公司广顺汽贸出单点", "3400000000"));
        list.add(new PrpdCompany("3400000008", "合肥中心支公司北方汽车出单点", "3400000000"));
        list.add(new PrpdCompany("3400000009", "合肥中心支公司南联汽贸出单点", "3400000000"));
        list.add(new PrpdCompany("3400000010", "合肥中心支公司春风代理出单点", "3400000000"));
        list.add(new PrpdCompany("3400000011", "合肥中心支公司洋泰保险代理出单点", "3400000000"));
        list.add(new PrpdCompany("3400000012", "合肥中心支公司环亚保险经纪出单点", "3400000000"));
        list.add(new PrpdCompany("3400000013", "合肥中心支公司马鞍山车检中心代理出单点", "3400000000"));
        list.add(new PrpdCompany("3400000014", "合肥中心支公司海康汽销出单点", "3400000000"));
        list.add(new PrpdCompany("3400000015", "合肥中心支公司安泰代理出单点", "3400000000"));
        list.add(new PrpdCompany("3400000016", "合肥中心支公司新梅汽车服务有限公司", "3400000000"));
        list.add(new PrpdCompany("3400000017", "合肥皖友汽车服务有限公司", "3400000000"));
        list.add(new PrpdCompany("3400000018", "合肥宿州路证券营业部出单点", "3400000000"));
        list.add(new PrpdCompany("3400000019", "合肥金寨路凯旋大厦证券营业部出单点", "3400000000"));
        list.add(new PrpdCompany("3400000020", "安徽天汇汽车销售服务有限公司", "3400000000"));
        list.add(new PrpdCompany("3400000021", "安徽安瑞汽车销售有限公司出单点", "3400000000"));
        list.add(new PrpdCompany("3400000022", "安徽协和保险代理舒城洪伟出单点", "3400000000"));
        list.add(new PrpdCompany("3400000023", "安徽正华保险代理肥东分公司出单点", "3400000000"));
        list.add(new PrpdCompany("3400000024", "合肥市金亚汽车出单点", "3400000000"));
        list.add(new PrpdCompany("3400000025", "合肥中心支公司安徽易速汽车出单点", "3400000000"));
        list.add(new PrpdCompany("3400000026", "合肥中心支公司安徽凯迪汽车出单点", "3400000000"));
        list.add(new PrpdCompany("3400000027", "合肥中心支公司合肥宇诚汽车出单点", "3400000000"));
        list.add(new PrpdCompany("3400000028", "合肥中心支公司安徽亚夏保险经纪出单点", "3400000000"));
        list.add(new PrpdCompany("3400000029", "合肥中心支公司安徽联达汽车销售出单点", "3400000000"));
        list.add(new PrpdCompany("3400000030", "合肥中心支公司金亚汽车北城分公司出单点", "3400000000"));
        list.add(new PrpdCompany("3400000031", "合肥中心支公司金安保险代理出单点", "3400000000"));
        list.add(new PrpdCompany("3400000100", "合肥中心支公司总经理室", "3400000000"));
        list.add(new PrpdCompany("3400000200", "合肥中心支公司综合管理部", "3400000000"));
        list.add(new PrpdCompany("3400000300", "合肥中心支公司财务会计部", "3400000000"));
        list.add(new PrpdCompany("3400000400", "合肥中心支公司客户服务部", "3400000000"));
        list.add(new PrpdCompany("3400000500", "合肥中心支公司业务管理部", "3400000000"));
        list.add(new PrpdCompany("3400000600", "合肥中心支公司业务销售部", "3400000000"));
        list.add(new PrpdCompany("3400000800", "合肥中心支公司农业保险部", "3400000000"));
        list.add(new PrpdCompany("3400000900", "合肥中心支公司财产保险部", "3400000000"));
        list.add(new PrpdCompany("3400003000", "合肥中心支公司霍邱汇嘉出单点", "3400000000"));
        list.add(new PrpdCompany("3400006600", "保险公估公司", "3400000000"));
        list.add(new PrpdCompany("3400006601", "中太保险公估", "3400006600"));
        list.add(new PrpdCompany("3400009900", "合肥中心支公司政策性农险业务部", "3400000000"));
        list.add(new PrpdCompany("340000YL00", "合肥市医疗保险事业分部", "3400000000"));
        list.add(new PrpdCompany("3401020000", "瑶海支公司", "3400000000"));
        list.add(new PrpdCompany("3401020001", "瑶海支公司华凯保险出单点", "3401020000"));
        list.add(new PrpdCompany("3401020002", "瑶海支公司中联金安保险出单点", "3401020000"));
        list.add(new PrpdCompany("3401020100", "瑶海支公司经理室", "3401020000"));
        list.add(new PrpdCompany("3401020200", "瑶海支公司综合管理部", "3401020000"));
        list.add(new PrpdCompany("3401020300", "瑶海支公司财务会计部", "3401020000"));
        list.add(new PrpdCompany("3401020400", "瑶海支公司财产保险部", "3401020000"));
        list.add(new PrpdCompany("3401020500", "瑶海支公司农业保险部", "3401020000"));
        list.add(new PrpdCompany("3401020800", "瑶海支公司客户服务部", "3401020000"));
        list.add(new PrpdCompany("3401029900", "瑶海支公司政策性农险业务部", "3401020000"));
        list.add(new PrpdCompany("340102YL00", "瑶海区医疗保险服务中心", "3401020000"));
        list.add(new PrpdCompany("3401110000", "包河支公司", "3400000000"));
        list.add(new PrpdCompany("3401110001", "合肥中建起重机销售有限公司出单点", "3401110000"));
        list.add(new PrpdCompany("3401110002", "包河支公司安徽锦和汽车销售出单点", "3401110000"));
        list.add(new PrpdCompany("3401110003", "包河支公司安徽南联汽车出单点", "3401110000"));
        list.add(new PrpdCompany("3401110004", "包河支公司合肥昌河航华汽贸出单点", "3401110000"));
        list.add(new PrpdCompany("3401110005", "包河支公司安徽世辉汽车出单点", "3401110000"));
        list.add(new PrpdCompany("3401110100", "包河支公司经理室", "3401110000"));
        list.add(new PrpdCompany("3401110200", "包河支公司综合管理部", "3401110000"));
        list.add(new PrpdCompany("3401110300", "包河支公司财务会计部", "3401110000"));
        list.add(new PrpdCompany("3401110400", "包河支公司财产保险部", "3401110000"));
        list.add(new PrpdCompany("3401110500", "包河支公司农业保险部", "3401110000"));
        list.add(new PrpdCompany("3401110800", "包河支公司客户服务部", "3401110000"));
        list.add(new PrpdCompany("3401119900", "包河支公司政策性农险业务部", "3401110000"));
        list.add(new PrpdCompany("340111YL00", "包河区医疗保险服务中心", "3401110000"));
        list.add(new PrpdCompany("3401210000", "长丰支公司", "3400000000"));
        list.add(new PrpdCompany("3401210001", "长丰农机站出单点", "3401210000"));
        list.add(new PrpdCompany("3401210002", "长丰丰源车检站出单点", "3401210000"));
        list.add(new PrpdCompany("3401210100", "长丰支公司经理室", "3401210000"));
        list.add(new PrpdCompany("3401210200", "长丰支公司综合部", "3401210000"));
        list.add(new PrpdCompany("3401210600", "长丰支公司业务部", "3401210000"));
        list.add(new PrpdCompany("3401210700", "长丰支公司销售部", "3401210000"));
        list.add(new PrpdCompany("3401212000", "长丰支公司下塘营销服务部", "3401210000"));
        list.add(new PrpdCompany("3401219900", "长丰支公司政策性农险业务部", "3401210000"));
        list.add(new PrpdCompany("340121YL00", "长丰县医疗保险服务中心", "3401210000"));
        list.add(new PrpdCompany("3401220000", "肥东支公司", "3400000000"));
        list.add(new PrpdCompany("3401220001", "肥东农监站出单点", "3401220000"));
        list.add(new PrpdCompany("3401220002", "安徽春风保险代理有限公司", "3401220000"));
        list.add(new PrpdCompany("3401220100", "肥东支公司经理室", "3401220000"));
        list.add(new PrpdCompany("3401220200", "肥东支公司综合部", "3401220000"));
        list.add(new PrpdCompany("3401220600", "肥东支公司业务部", "3401220000"));
        list.add(new PrpdCompany("3401220700", "肥东支公司销售部", "3401220000"));
        list.add(new PrpdCompany("3401222000", "肥东支公司八斗营销服务部", "3401220000"));
        list.add(new PrpdCompany("3401229900", "肥东支公司政策性农险业务部", "3401220000"));
        list.add(new PrpdCompany("340122YL00", "肥东县医疗保险服务中心", "3401220000"));
        list.add(new PrpdCompany("3401230000", "肥西支公司", "3400000000"));
        list.add(new PrpdCompany("3401230001", "肥西建华汽贸出单点", "3401230000"));
        list.add(new PrpdCompany("3401230002", "肥西县农用机械管理局", "3401230000"));
        list.add(new PrpdCompany("3401230100", "肥西支公司经理室", "3401230000"));
        return list;
    }
}
