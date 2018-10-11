package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.ims.api.auth.dto.UtiUserGradeDto;
import com.sinosoft.ims.core.auth.dao.UtiUserGradeDao;
import com.sinosoft.ims.core.auth.entity.UtiUserGrade;
import com.sinosoft.ims.core.auth.entity.UtiUserGradeKey;
import com.sinosoft.ims.core.auth.service.UtiUserGradeService;
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
 * @time  2017-08-22 03:00:27.902 
 * @description 用户权限表Core接口实现
 */
@Service
public class UtiUserGradeServiceImpl extends BaseServiceImpl implements UtiUserGradeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUserGradeServiceImpl.class);
    
    @Autowired
    private UtiUserGradeDao utiUserGradeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUserGradeDto utiUserGradeDto) {
        UtiUserGrade utiUserGrade = this.convert(utiUserGradeDto, UtiUserGrade.class);
        utiUserGradeDao.save(utiUserGrade);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,String userCode,String gradeCode) {
        UtiUserGradeKey utiUserGradeKey = new UtiUserGradeKey(comCode,userCode,gradeCode);
        utiUserGradeDao.delete(utiUserGradeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUserGradeDto utiUserGradeDto) {
        UtiUserGrade utiUserGrade = this.convert(utiUserGradeDto, UtiUserGrade.class);
        utiUserGradeDao.save(utiUserGrade);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserGradeDto queryByPK(String comCode,String userCode,String gradeCode) {
        UtiUserGradeKey utiUserGradeKey = new UtiUserGradeKey(comCode,userCode,gradeCode);
        UtiUserGrade utiUserGrade = utiUserGradeDao.findOne(utiUserGradeKey);
        return this.convert(utiUserGrade,UtiUserGradeDto.class);
    }

    /**
     *  根据comCode、userCode查询UtiUserGradeDto集合
     * @author: ldd
     * @date: 2017/11/16 14:55
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return UtiUserGradeDto集合
     * @throws Exception
     */
    @Override
    public List<UtiUserGradeDto> queryAllByConditon(String comCode, String userCode) throws Exception {
        List<UtiUserGrade> utiUserGradeList = utiUserGradeDao.findAllByCondition(comCode,userCode);
        List<UtiUserGradeDto> utiUserGradeDtoList = new ArrayList<>();
        convertCollection(utiUserGradeList,utiUserGradeDtoList,UtiUserGradeDto.class);
        return utiUserGradeDtoList;
    }
}