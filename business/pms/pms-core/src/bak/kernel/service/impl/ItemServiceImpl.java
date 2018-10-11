package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.ItemTypeQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDItemTypeDto;
import com.sinosoft.pms.core.kernel.dao.PrpDItemTypeDao;
import com.sinosoft.pms.core.kernel.entity.PrpDItemType;
import com.sinosoft.pms.core.kernel.entity.PrpDItemTypeKey;
import com.sinosoft.pms.core.kernel.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImpl implements ItemService {
    private static Log LOGGER = LogFactory.getLog(ItemServiceImpl.class);
    
    @Autowired
    PrpDItemTypeDao prpDItemTypeDao;
    
    /**
     * @description 根据标的代码，标的分类标准，标的分类代码 获取标的相关信息
     * @param conditionDto
     * @return PrpDRiskDto
     * @author yinqingzhu
     * @date 2016年10月13日上午9:19:41
     */
    @Override
    public PrpDItemTypeDto getItemType(ItemTypeQueryConditionDto conditionDto){
        PrpDItemTypeDto itemTypeReturnDto = new PrpDItemTypeDto();
        
        PrpDItemTypeKey key = new PrpDItemTypeKey();
        //标的代码
        String itemCode = conditionDto.getItemCode();
        //标的分类标准
        String itemTypeBase = conditionDto.getItemTypeBase();
        //标的分类代码
        String itemTypeCode = conditionDto.getItemTypeCode();
        if(StringUtils.isNotEmpty(itemCode)
            &&StringUtils.isNotEmpty(itemTypeBase)
            &&StringUtils.isNotEmpty(itemTypeCode)){
            //pms数据库中itemTypeCode是itemTypeBase+itemTypeCode，在此组装
            itemTypeCode = itemTypeBase+itemTypeCode;
            key.setItemCode(itemCode);
            key.setItemTypeBase(itemTypeBase);
            key.setItemTypeCode(itemTypeCode);
            
            PrpDItemType itemType = prpDItemTypeDao.findOne(key);
            if(itemType!=null){
                itemTypeReturnDto = this.convert(itemType,PrpDItemTypeDto.class);
                itemTypeReturnDto.setResultCode("Y");
                itemTypeReturnDto.setResultMsg("查询成功，数据已返回");
            }else{
                itemTypeReturnDto.setResultCode("N");
                itemTypeReturnDto.setResultMsg("没有符合查询条件的数据");
            }
        }else{
            itemTypeReturnDto.setResultCode("N");
            itemTypeReturnDto.setResultMsg("查询条件为空");
        }
        return itemTypeReturnDto;
    }
}
