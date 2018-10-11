package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.RequestQueryProposalListInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseQueryProposalInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseQueryProposalListInfoDto;
import com.sinosoft.framework.dto.PageInfo;

/**
* @Description: 投保单信息查询Core层
* @Author: 何伟东
* @Date: 2017/10/15 11:16
*/
public interface QueryProposalService {

    /**
     * @description: 方法功能简述：根据查询入参的条件以及查询方式分页查询投保单列表信息
     * @author: 何伟东
     * @date: 2017/10/15 11:13
     * @param requestDto
     * @return
     * @throws Exception
     */
    public PageInfo<ResponseQueryProposalListInfoDto> queryProposalListInfoByConditon(RequestQueryProposalListInfoDto requestDto) throws Exception ;

    /**
     * @description: 方法功能简述：根据投保单号码查询投保单详细信息
     * @author: 何伟东
     * @date: 2017/10/18 11:52
     * @param proposalNo 投保单号
     * @return
     * @throws Exception
     */
    public ResponseQueryProposalInfoDto queryProposalInfoByProposalNoAndFamilyNos(String proposalNo, String familyNos) throws Exception;
}