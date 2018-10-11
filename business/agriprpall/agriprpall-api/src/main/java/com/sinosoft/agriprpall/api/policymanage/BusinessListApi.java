package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.SumAmountAndPremiumDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
*业务清单查询
* @Author: 陈道洋
* @Date: 2017/11/4 14:32
*/
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = BusinessListApi.PATH)
public interface BusinessListApi {
    public static final String PATH = "businessList";

    /**
     * 业务清单查询
     * @author: 陈道洋
     * @date: 2017/11/4 14:50
     * @param requestBusinessListDto 请求Dto
     * @return 业务清单查询所需的数据
     * @throws Exception
     */
    @RequestMapping(value = "queryBusinessListByCondition",method ={ RequestMethod.POST})
    public @ResponseBody
    PageInfo<ResponseBusinessListDto> queryBusinessListByCondition(@RequestBody RequestBusinessListDto requestBusinessListDto) throws Exception;

    /**
     * 查询签单总保额、总保费，未交费保单总保额、总保费，应收保费总保额、总保费
     * @author: 刘曼曼
     * @date: 2017/11/13 11:20
     * @param comCode 用户代码
     * @return ResponseDto 大对象
     * @throws Exception
     */
    @RequestMapping(value = "queryPremiumInfo",method ={ RequestMethod.POST})
    public @ResponseBody
    SumAmountAndPremiumDto queryPremiumInfo(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 业务清单查询导出Excel
     * @author: 何伟东
     * @date: 2017/11/23 16:41
     * @param param classCode 险类代码 listType 清单类型 startDate 开始日期 endDate 结束日期
     * @return shortLink 文件下载短链接
     * @throws Exception
     */
    @RequestMapping(value = "businessListExportExcel",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> businessListExportExcel(@RequestBody Map<String,String> param) throws Exception;

}
