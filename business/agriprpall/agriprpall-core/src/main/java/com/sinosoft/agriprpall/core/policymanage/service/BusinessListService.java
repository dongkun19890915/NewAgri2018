package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.policymanage.dto.RequestBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseBusinessListDto;
import com.sinosoft.agriprpall.api.policymanage.dto.SumAmountAndPremiumDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.Map;

/**
*（业务清单查询）
* @Author: 陈道洋
* @Date: 2017/11/4 14:55
*/

public interface BusinessListService {
    /**
     * （业务清单查询）
     * @author: 陈道洋
     * @date: 2017/11/4 14:50
     * @param requestBusinessListDto 请求Dto
     * @para作时间止期
     * @return 业务清单查询所需的数据
     * @throws Exception
     */
    public PageInfo<ResponseBusinessListDto> queryBusinessListByCondition(RequestBusinessListDto requestBusinessListDto) throws Exception;

    /**
     * 查询签单总保额、总保费，未交费保单总保额、总保费，应收保费总保额、总保费
     * @author: 刘曼曼
     * @date: 2017/11/13 11:20
     * @param comCode 机构代码
     * @return SumAmountAndPremiumDto总保额、总保费查询所需结果
     * @throws Exception
     */
    public SumAmountAndPremiumDto queryPremiumInfo(String comCode) throws Exception;

    /**
     * 业务清单查询导出Excel
     * @author: 何伟东
     * @date: 2017/11/23 16:41
     * @param classCode 险类代码
     * @param listType 清单类型
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return shortLink 文件下载短链接
     * @throws Exception
     */
    public String businessListExportExcel(String classCode, String listType, String startDate, String endDate) throws Exception;

}
