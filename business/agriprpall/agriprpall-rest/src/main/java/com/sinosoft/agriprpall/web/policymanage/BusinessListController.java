package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.BusinessListApi;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.SumAmountAndPremiumDto;
import com.sinosoft.agriprpall.core.policymanage.service.BusinessListService;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
*（业务清单查询）
* @Author: 陈道洋
* @Date: 2017/11/4 14:46
*/
@RestController
@RequestMapping(value = BusinessListController.PATH)
public class BusinessListController implements BusinessListApi {
    @Autowired
    private BusinessListService businessListService;
    /**
     * 业务清单查询
     * @author: 陈道洋
     * @date: 2017/11/4 14:50
     * @param requestBusinessListDto 险种代码请求参数Dto
     * @return 业务清单查询所需的数据
     * @throws Exception
     */
    @Override
    public @ResponseBody
    PageInfo<ResponseBusinessListDto> queryBusinessListByCondition(@RequestBody RequestBusinessListDto requestBusinessListDto) throws Exception {
        return businessListService.queryBusinessListByCondition(requestBusinessListDto);
    }

    /**
     * 查询签单总保额、总保费，未交费保单总保额、总保费，应收保费总保额、总保费
     * @author: 刘曼曼
     * @date: 2017/11/13 11:20
     * @param map comCode 用户代码
     * @return ResponseDto 大对象
     * @throws Exception
     */
    @Override
    public @ResponseBody SumAmountAndPremiumDto queryPremiumInfo(@RequestBody Map<String,String> map) throws Exception{
        String comCode=map.get("comCode");
        return businessListService.queryPremiumInfo(comCode);
    }

    /**
     * 业务清单查询导出Excel
     * @author: 何伟东
     * @date: 2017/11/23 16:41
     * @param param classCode 险类代码 listType 清单类型 startDate 开始日期 endDate 结束日期
     * @return shortLink 文件下载短链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> businessListExportExcel(@RequestBody Map<String, String> param) throws Exception {
        String shortLink = businessListService.businessListExportExcel(param.get("classCode"), param.get("listType"), param.get("startDate"), param.get("endDate"));
        Map<String,String> map = new HashMap<>(1);
        map.put("shortLink",shortLink);
        return map;
    }

}
