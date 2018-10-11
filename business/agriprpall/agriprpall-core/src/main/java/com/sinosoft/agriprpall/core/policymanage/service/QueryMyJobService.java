package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.policymanage.dto.QueryMyJobCountDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestMyJobDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseMyJobDto;
import com.sinosoft.framework.dto.PageInfo;

/**(我的任务查询)
 * @Author: 刘曼曼
 * @Date: 2017/11/14 15:09
 */
public interface QueryMyJobService {
    /**
     * 我的任务条件分页查询
     * @author: 刘曼曼
     * @date: 2017/11/14 18:08
     * @param requestMyJobDto 查询所需数据Dto
     * @return PageInfo<ResponseMyJobDto>暂存单，投保单，保单，批单返回数据的Dto 集合
     * @throws Exception
     */
    public PageInfo<ResponseMyJobDto> queryMyJobByCondition(RequestMyJobDto requestMyJobDto)throws Exception;

    /**
     * 查询待处理暂存单，待处理投保单，待处理保单，待处理批单总条数
     * @author: 刘曼曼
     * @date: 2017/11/19 11:48
     * @param userCode 用户代码
     * @return QueryMyJobCountDto 总条数Dto
     * @throws Exception
     */
    public QueryMyJobCountDto queryMyJobByCount(String userCode)throws Exception;
}
