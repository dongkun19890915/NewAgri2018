package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPcoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDto;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCcoinsDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoins;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoinsKey;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCcoinsService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrpCcoinsServiceImpl extends BaseServiceImpl implements PrpCcoinsService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCplanServiceImpl.class);
    @Autowired
    private PrpCcoinsDao prpCcoinsDao;
    /**
     *  根据主键查询PrpCcoin共保信息表信息
     * @author: 田慧
     * @date: 2017/12/3 12:08
     * @param policyNo 保单号
     * @param serialNo 序列号
     * @return PrpCcoinsDto 共保信息表信息的Dto
     */
    @Override
    public PrpCcoinsDto queryByPK(String policyNo, Integer serialNo) {
        PrpCcoinsKey prpCcoinsKey = new PrpCcoinsKey(policyNo,serialNo);
        PrpCcoins prpCcoins = prpCcoinsDao.findOne(prpCcoinsKey);
        return this.convert(prpCcoins,PrpCcoinsDto.class);
    }

    /**
     *  根据保单号查询prpCcoins 共保信息表信息
     * @author: 田慧
     * @date: 2017/11/20 15:32
     * @param policyNo 保单号
     * @return prpCcoinsDtoList 返回共保信息表Dto的集合
     */
    @Override
    public List<PrpCcoinsDto> queryByPolicyNo(String policyNo)throws Exception{
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        policyNo = "%" + policyNo + "%";
        List<PrpCcoins> prpCcoinsList = prpCcoinsDao.findByPolicyNoLike(policyNo);
        List<PrpCcoinsDto> prpCcoinsDtoList = new ArrayList<PrpCcoinsDto>();
        this.convertCollection(prpCcoinsList, prpCcoinsDtoList, PrpCcoinsDto.class);
        return prpCcoinsDtoList;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCcoinsDto generatePrpCcoins(PrpCPcoinsDto prpCPcoinsDto) throws Exception {
        PrpCcoinsDto prpCcoinsDto=new PrpCcoinsDto();
        prpCcoinsDto.setPolicyNo(prpCPcoinsDto.getPolicyNo());
        prpCcoinsDto.setSerialNo(prpCPcoinsDto.getSerialNo());
        prpCcoinsDto.setMainPolicyNo(prpCPcoinsDto.getMainPolicyNo());
        prpCcoinsDto.setCoinsCode(prpCPcoinsDto.getCoinsCode());
        prpCcoinsDto.setCoinsName(prpCPcoinsDto.getCoinsName());
        prpCcoinsDto.setCoinsType(prpCPcoinsDto.getCoinsType());
        // modify by yangkun begin 20051216 联共保处理新增加字段
        prpCcoinsDto.setChiefFlag(prpCPcoinsDto.getChiefFlag()); // 首席标志
        prpCcoinsDto.setCoinsRate(prpCPcoinsDto.getCoinsRate());
        prpCcoinsDto.setProportionFlag(prpCPcoinsDto
                .getProportionFlag()); // 分摊标志
        // modify by yangkun end 20051216
        prpCcoinsDto.setCoinsTreatyNo(prpCPcoinsDto
                .getCoinsTreatyNo());
        prpCcoinsDto.setFlag(prpCPcoinsDto.getFlag());
        return prpCcoinsDto;
    }

    /**
     * （获取pubTolls 服务）
     * @author: 王志文
     * @date: 2018/4/12 18:08
     * @param iBaseCurrency
     * @param iExchCurrency
     * @param iExchDate
     * @return
     * @throws Exception
     */
    @Override
    public double getPubTools(String iBaseCurrency, String iExchCurrency, String iExchDate)throws Exception{
        PubTools pubTools = new PubTools();
        return pubTools.getExchangeRate(iBaseCurrency,iExchCurrency,iExchDate);
    }
}
