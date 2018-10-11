package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestSpecialEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.*;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SpecialEndorseServiceImpl extends BaseServiceImpl implements SpecialEndorseService {

    @Autowired
    private SpecialEndorItemKindService specialEndorItemKindService;
    @Autowired
    private SpecialEndorse21Service specialEndorse21Service;
    @Autowired
    private SpecialEndorse85Service specialEndorse85Service;
    @Autowired
    private SpecialEndorse19Service specialEndorse19Service;
    @Autowired
    private SpecialNyxCoinsService specialNyxCoinsService;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private SpecialEndorseSeeFeeWithdrawServiceImpl specialEndorseSeeFeeWithdrawService;

    /**
     * 特殊批改批量处理总接口
     * @param blEndorseDtoList 批单对象集合
     * @param endorseConditionDto 批改条件
     * @return List<PolicyEndorseDto>新旧保单、批单大对象集合
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-22
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PolicyEndorseDto> specialEndorse(RequestSpecialEndorseDto requestSpecialEndorseDto) throws Exception {

        List<BLEndorseDto> blEndorseDtoList=requestSpecialEndorseDto.getBlEndorseDtoList();
        EndorseConditionDto endorseConditionDto=requestSpecialEndorseDto.getEndorseConditionDto();
        if (blEndorseDtoList.size()==0){
            throw new DataVerifyException("请传入希望批改的相应的批单信息");
        }
        if (endorseConditionDto==null){
            throw new DataVerifyException("请传入相应的批改信息");

        }
        //TODO 事务处理



        /** 生成批次号*/
        String comCode=endorseConditionDto.getLoginComCode();
        BillNoDto billNoDto=new BillNoDto();
        billNoDto.setiComCode(comCode);
        //生成批次号的判断tableName必须为:prpphead不区分大小写
        billNoDto.setTableName("prpphead");
        //不需要险种代码,但是为了避免空指针,需要传入一个空字符串
        billNoDto.setRiskCode("");
        // getbatchNo Map 中的约定是billNo
        Map<String,String> map = billNoApi.getBillNo(billNoDto);
        if (map==null){
            throw new BusinessException("获取批次号失败");
        }
        String batchNo=map.get("billNo");
        //给 endorseConditionDto赋值批次号 方便循环的时候取出赋值
        endorseConditionDto.setBatchNo(batchNo);
        String endorType=endorseConditionDto.getEndorType();
        List<PolicyEndorseDto> policyEndorseDtos=new ArrayList<>();
        PolicyEndorseDto policyEndorseDto = new PolicyEndorseDto();
        for (int i=0;i<blEndorseDtoList.size();i++){
            if ("01".equals(endorType)||"11".equals(endorType)||"71".equals(endorType)||"91".equals(endorType)){
                /** 01调整保险期限 11调整费率 71补贴比例批改 91调整单位保额 */
                policyEndorseDto = specialEndorItemKindService.specialEndorse01(blEndorseDtoList.get(i),endorseConditionDto,
                                                                                requestSpecialEndorseDto.getPrpCsubsidyDtoListNew(),
                                                                                requestSpecialEndorseDto.getPrpCitemKindDtoListNew());
            }else if ("19".equals(endorType)){/** 保单注销 */
                policyEndorseDto = specialEndorse19Service.specialEndorse19(blEndorseDtoList.get(i),endorseConditionDto);
            }else if ("21".equals(endorType)){/** 全单退保 */
                policyEndorseDto = specialEndorse21Service.specialEndorse21(blEndorseDtoList.get(i),endorseConditionDto);
            }else if ("85".equals(endorType)){/** 业务员批改 */
                policyEndorseDto = specialEndorse85Service.specialEndorse85(blEndorseDtoList.get(i),endorseConditionDto);
            }else if ("92".equals(endorType)){/** 见费出单保单注销 */
                specialEndorseSeeFeeWithdrawService.specialEndorseSeeFeeWithdraw(blEndorseDtoList.get(i).getPrpPheadDto().getPolicyNo());
            }
            else{
                throw new DataVerifyException("批改类型不存在！");
            }
            if(!"92".equals(endorType)){
                specialNyxCoinsService.dealNyxCoins(blEndorseDtoList.get(i),endorseConditionDto,
                        requestSpecialEndorseDto.getPrpCsubsidyDtoListNew(),
                        requestSpecialEndorseDto.getPrpCitemKindDtoListNew());
            }
            policyEndorseDtos.add(policyEndorseDto);
        }
        return policyEndorseDtos;
    }
}
