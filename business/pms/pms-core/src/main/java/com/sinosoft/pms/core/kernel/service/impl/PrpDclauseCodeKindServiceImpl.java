package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeKindDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseCodeKindDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseCodeKind;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseCodeKindKey;
import com.sinosoft.pms.core.kernel.service.PrpDclauseCodeKindService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款险别配置表Core接口实现
 */
@Service
public class PrpDclauseCodeKindServiceImpl extends BaseServiceImpl implements PrpDclauseCodeKindService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseCodeKindServiceImpl.class);
    
    @Autowired
    private PrpDclauseCodeKindDao prpDclauseCodeKindDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseCodeKindDto prpDclauseCodeKindDto) {
        PrpDclauseCodeKind prpDclauseCodeKind = this.convert(prpDclauseCodeKindDto, PrpDclauseCodeKind.class);
        prpDclauseCodeKindDao.save(prpDclauseCodeKind);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,java.lang.Double serialNo,String kindCode) {
        PrpDclauseCodeKindKey prpDclauseCodeKindKey = new PrpDclauseCodeKindKey(clauseCode,serialNo,kindCode);
        prpDclauseCodeKindDao.delete(prpDclauseCodeKindKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseCodeKindDto prpDclauseCodeKindDto) {
        PrpDclauseCodeKind prpDclauseCodeKind = this.convert(prpDclauseCodeKindDto, PrpDclauseCodeKind.class);
        prpDclauseCodeKindDao.save(prpDclauseCodeKind);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseCodeKindDto queryByPK(String clauseCode,java.lang.Double serialNo,String kindCode) {
        PrpDclauseCodeKindKey prpDclauseCodeKindKey = new PrpDclauseCodeKindKey(clauseCode,serialNo,kindCode);
        PrpDclauseCodeKind prpDclauseCodeKind = prpDclauseCodeKindDao.findOne(prpDclauseCodeKindKey);
        return this.convert(prpDclauseCodeKind,PrpDclauseCodeKindDto.class);
    }
    /**
     * 根据clauseCode条款代码和calculateFlag主险标识代码查询险别
     * @author: 田慧
     * @date: 2017/12/14 14:16
     * @param clauseCode 条款代码
     * @param calculateFlag 主险标识：1-主险，2-附加险
     * @return  kindCodeList kindCode的集合
     * @throws Exception
     */
    @Override
    public List<String> queryKindCodeByClauseCode(String clauseCode,String calculateFlag)throws Exception{
        if (StringUtils.isEmpty(clauseCode)) {
            throw new DataVerifyException("条款代码不能为空!");
        }
        if (StringUtils.isEmpty(calculateFlag)) {
            throw new DataVerifyException("主险标识不能为空!");
        }
        List<String> kindCodeList = prpDclauseCodeKindDao.queryByClauseCode(clauseCode, calculateFlag);
        return kindCodeList;
    }
    /**
     *  根据clauseCode条款代码和kindCode险别代码查询标的
     * @author: 田慧
     * @date: 2017/12/16 10:38
     * @param clauseCode 条款代码
     * @param kindCode 险别代码
     * @return itemCodeList itemCode的集合
     * @throws Exception
     */
    @Override
    public List<String> queryItemCodeByClauseCodeAndKindCode(String clauseCode,String kindCode) throws Exception{
        if (StringUtils.isEmpty(clauseCode)) {
            throw new DataVerifyException("条款代码不能为空!");
        }
        if (StringUtils.isEmpty(kindCode)) {
            throw new DataVerifyException("险别代码不能为空!");
        }
        List<String> itemCodeList = prpDclauseCodeKindDao.queryItemCode(clauseCode,kindCode);
        return itemCodeList;

    }
    /**
     * 根据条款代码查询条款险别配置
     * @author: 宋振振
     * @date: 2018/4/14 14:20
     * @param clauseCode
     * @return  List<PrpDclauseCodeKindDto>
     */
    public List<PrpDclauseCodeKindDto> queryPrpDclauseCodeKindByClauseCode(String clauseCode)throws Exception{
        if (StringUtils.isEmpty(clauseCode)) {
            throw new DataVerifyException("条款代码不能为空!");
        }
        List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtos=new ArrayList<>();
        List<PrpDclauseCodeKind> prpDclauseCodeKindList = prpDclauseCodeKindDao.queryByClauseCode(clauseCode);
        convertCollection(prpDclauseCodeKindList,prpDclauseCodeKindDtos,PrpDclauseCodeKindDto.class);
        return prpDclauseCodeKindDtos;
    }
}