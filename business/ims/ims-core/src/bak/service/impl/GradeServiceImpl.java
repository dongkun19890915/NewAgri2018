package com.sinosoft.ims.core.kernel.service.impl;


import com.sinosoft.dms.api.bill.BillApi;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.api.bill.dto.BillDto;
import com.sinosoft.framework.core.convert.BeanConverter;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.dto.GradeQueryConditionDto;
import com.sinosoft.ims.api.kernel.dto.SaaGradeDto;
import com.sinosoft.ims.api.kernel.dto.UserGradeConditionDto;
import com.sinosoft.ims.core.kernel.dao.SaaGradeDao;
import com.sinosoft.ims.core.kernel.dao.SaaUserGradeDao;
import com.sinosoft.ims.core.kernel.entity.SaaGrade;
import com.sinosoft.ims.core.kernel.entity.SaaUserGrade;
import com.sinosoft.ims.core.kernel.service.GradeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author hzhongkai
 * @description 岗位服务接口
 * @date 2016年9月19日下午3:02:06
 */
@Service
public class GradeServiceImpl extends BaseServiceImpl implements GradeService {
    /**
     * log日志
     */
    private static Log LOGGER = LogFactory.getLog(GradeServiceImpl.class);

    @Autowired
    private SaaUserGradeDao saaUserGradeMapper;
    @Autowired
    private SaaGradeDao saaGradeMapper;
    @Autowired
    private BillApi billService;

    /**
     * @return ResponseDto
     * @description 用户岗位配置服务
     * @
     * @author hzhongkai
     * @date 2016年9月21日下午4:36:52
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean configUserGrade(UserGradeConditionDto userGradeConditionDto)

    {
        if (StringUtils.isEmpty(userGradeConditionDto.getUserCode())) {
            throw new DataVerifyException("用户岗位配置服务  入参 UserCode 不允许为空！");
        }
        if (userGradeConditionDto.getGradeIds() == null || userGradeConditionDto.getGradeIds().size() == 0) {
            throw new DataVerifyException("用户岗位配置服务  GradeIds 不允许为空！");
        }

        SaaUserGrade userGrade = null;
        BillConditionDto billConditionDto = new BillConditionDto();
        billConditionDto.setBillType("imsSaaUserGrade_");
        //先将用户所有岗位置为无效
        userGrade = new SaaUserGrade();
        userGrade.setUserCode(userGradeConditionDto.getUserCode());
        userGrade.setUpdateDate(new Date());
        //userGrade.setUpdaterCode(userGradeConditionDto.getGlobalUserCode());
        userGrade.setValidStatus("0");
        //saaUserGradeMapper.updateUserGradeToInvalid(userGrade);
        saaUserGradeMapper.save(userGrade);
        for (int i = 0; i < userGradeConditionDto.getGradeIds().size(); i++) {
            userGrade = new SaaUserGrade();
            userGrade.setUserCode(userGradeConditionDto.getUserCode());
            userGrade.setGradeID(userGradeConditionDto.getGradeIds().get(i));
            userGrade.setValidStatus("1");
            try {
                SaaUserGrade finalUserGrade = userGrade;
                List<SaaUserGrade> list = saaUserGradeMapper.findAll(new Specification<SaaUserGrade>() {
                    @Override
                    public Predicate toPredicate(Root<SaaUserGrade> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                        List<Predicate> list = new ArrayList<Predicate>();

                            list.add(cb.equal(root.get("userCode").as(String.class), finalUserGrade.getUserCode()));
                            list.add(cb.equal(root.get("gradeID").as(String.class), finalUserGrade.getGradeID()));

                        Predicate[] p = new Predicate[list.size()];
                        return cb.and(list.toArray(p));
                    }

                });

                if (list != null && list.size() > 0) {
                    //更新
                    userGrade.setID(list.get(0).getID());
                    userGrade.setUpdateDate(new Date());
                    saaUserGradeMapper.save(userGrade);
                } else {
                    //插入
                    BillDto billDto = billService.getSerialNo(billConditionDto);
                    Long id = billDto.getSerialNo();
                    String str = String.format("%019d", id);
                    userGrade.setID(str);
                    userGrade.setCreateDate(new Date());
                    saaUserGradeMapper.save(userGrade);
                }
                return true;
            } catch (Exception e) {
                throw new BusinessException(" 用户岗位配置服务 发生异常！ ");
            }
        }

        return false;
    }

    /**
     * @return GradeReturnDto
     * @description 岗位查询服务, 只返回用户拥有的岗位列表
     * @
     * @author hzhongkai
     * @date 2016年9月21日下午4:36:52
     */
    @Override
    public List<SaaGradeDto> queryGradeList(GradeQueryConditionDto gradeQueryConditionDto)

    {
        //返回列表
        List<SaaGradeDto> gradeDtoList = new ArrayList<SaaGradeDto>();
        try {
            List<SaaGrade> gradeList = saaGradeMapper.findAll(Specifications.<SaaGrade>and()
                    .eq("userCode", gradeQueryConditionDto.getUserCode())
                    .build());
            for (SaaGrade saaGrade : gradeList) {
                gradeDtoList.add(GradeTOGradeDto(saaGrade));
            }
        } catch (Exception e) {
            LOGGER.error("岗位查询服务发生异常！" + e.getMessage());
            throw e;
        }
        return gradeDtoList;
    }

    /**
     * @return GradeReturnDto
     * @description 岗位查询服务, 返回所有岗位，并将用户拥有的岗位checked属性置为true
     * @
     * @author hzhongkai
     * @date 2016年9月21日下午4:36:52
     */
    @Override
    public List<SaaGradeDto> queryUserGradeList(GradeQueryConditionDto gradeQueryConditionDto) {
        try {
            // 获取所有岗位
            List<SaaGradeDto> gradeList1 = queryGradeList(null);
            // 获取用户所有岗位
            List<SaaGradeDto> gradeList2 = queryGradeList(gradeQueryConditionDto);
            for (SaaGradeDto grade1 : gradeList1) {
                for (SaaGradeDto grade2 : gradeList2) {
                    if (grade1.getID().equals(grade2.getID())) {
                        grade1.setChecked(true);
                        break;
                    }
                }
            }
            return gradeList1;
        } catch (Exception e) {
            LOGGER.error("岗位查询服务发生异常！" + e.getMessage());
            throw e;
        }
    }


    /**
     * @param grade
     * @return SaaGradeDto
     * @description 对象互转
     * @author hzhongkai
     * @date 2016年9月20日下午3:58:45
     */
    private SaaGradeDto GradeTOGradeDto(SaaGrade grade) {
        SaaGradeDto saaGradeDto = convert(grade, SaaGradeDto.class);
        return saaGradeDto;
    }
}
