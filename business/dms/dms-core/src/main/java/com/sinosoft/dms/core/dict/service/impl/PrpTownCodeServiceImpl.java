package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpTownCodeDto;
import com.sinosoft.dms.core.dict.dao.PrpTownCodeDao;
import com.sinosoft.dms.core.dict.entity.PrpTownCode;
import com.sinosoft.dms.core.dict.entity.PrpTownCodeKey;
import com.sinosoft.dms.core.dict.service.PrpTownCodeService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:26:37.210 
 * @description prpTownCodeCore接口实现
 */
@Service
public class PrpTownCodeServiceImpl extends BaseServiceImpl implements PrpTownCodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTownCodeServiceImpl.class);
    
    @Autowired
    private PrpTownCodeDao prpTownCodeDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpTownCodeDto prpTownCodeDto) {
        PrpTownCode prpTownCode = this.convert(prpTownCodeDto, PrpTownCode.class);
        prpTownCodeDao.save(prpTownCode);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String codeCode) {
        PrpTownCodeKey prpTownCodeKey = new PrpTownCodeKey(codeCode);
        prpTownCodeDao.delete(prpTownCodeKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpTownCodeDto prpTownCodeDto) {
        PrpTownCode prpTownCode = this.convert(prpTownCodeDto, PrpTownCode.class);
        prpTownCodeDao.save(prpTownCode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpTownCodeDto queryByPK(String codeCode) {
        PrpTownCodeKey prpTownCodeKey = new PrpTownCodeKey(codeCode);
        PrpTownCode prpTownCode = prpTownCodeDao.findOne(prpTownCodeKey);
        return this.convert(prpTownCode,PrpTownCodeDto.class);
    }

    /**
     * codeType和feildExt查询归属机构信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param codeType 代码种类
     * @param feildExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    @Override
    public List<PrpTownCodeDto> queryAreasProvinceInfo(String codeType,String fieldExt) throws Exception {
        if (StringUtils.isEmpty(fieldExt)){
            throw new Exception("fieldExt不能为空");
        }
        List<PrpTownCode> prpTownCodeList=prpTownCodeDao.findAllByUpCode(fieldExt);
        List<PrpTownCodeDto> prpTownCodeDtoList=new ArrayList<>();
        convertCollection(prpTownCodeList,prpTownCodeDtoList,PrpTownCodeDto.class);
        return prpTownCodeDtoList;
    }
}