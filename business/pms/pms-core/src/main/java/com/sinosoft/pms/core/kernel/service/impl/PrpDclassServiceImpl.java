package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclassDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclass;
import com.sinosoft.pms.core.kernel.entity.PrpDclassKey;
import com.sinosoft.pms.core.kernel.service.PrpDclassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 险种分类定义表Core接口实现
 */
@Service
public class PrpDclassServiceImpl extends BaseServiceImpl implements PrpDclassService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclassServiceImpl.class);
    
    @Autowired
    private PrpDclassDao prpDclassDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDclassDto prpDclassDto) {
        PrpDclass prpDclass = this.convert(prpDclassDto, PrpDclass.class);
        prpDclassDao.save(prpDclass);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String classCode) {
        PrpDclassKey prpDclassKey = new PrpDclassKey(classCode);
        prpDclassDao.delete(prpDclassKey);
    }

    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDclassDto prpDclassDto) {
        PrpDclass prpDclass = this.convert(prpDclassDto, PrpDclass.class);
        prpDclassDao.save(prpDclass);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDclassDto queryByPK(String classCode) {
        PrpDclassKey prpDclassKey = new PrpDclassKey(classCode);
        PrpDclass prpDclass = prpDclassDao.findOne(prpDclassKey);
        return this.convert(prpDclass,PrpDclassDto.class);
    }
    /**
     *@description 查询所有险类
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpDclassDto> queryAll(String classCode) {
        List<PrpDclass> prpDclassList = null;
        List<PrpDclassDto> prpDclassDtoList=new ArrayList<>();
        if(classCode!=null){
            PrpDclassDto prpDclassDto = this.queryByPK(classCode);
            prpDclassDtoList.add(prpDclassDto);
        }else{
            prpDclassList=prpDclassDao.findAll();
            convertCollection(prpDclassList,prpDclassDtoList,PrpDclassDto.class);
        }
        return prpDclassDtoList;
    }
}