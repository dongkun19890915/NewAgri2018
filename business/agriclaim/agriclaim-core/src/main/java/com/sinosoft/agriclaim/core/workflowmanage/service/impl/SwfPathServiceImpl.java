package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfConditionDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDto;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfCondition;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPath;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPathService;
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
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流路径定义表Core接口实现
 */
@Service
public class SwfPathServiceImpl extends BaseServiceImpl implements SwfPathService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SwfPathServiceImpl.class);
    
    @Autowired
    private SwfPathDao swfPathDao;
    @PersistenceContext
	private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(SwfPathDto swfPathDto) {
        SwfPath swfPath = this.convert(swfPathDto, SwfPath.class);
        swfPathDao.save(swfPath);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer modelNo,java.lang.Integer pathNo) {
        SwfPathKey swfPathKey = new SwfPathKey(modelNo,pathNo);
        swfPathDao.delete(swfPathKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(SwfPathDto swfPathDto) {
        SwfPath swfPath = this.convert(swfPathDto, SwfPath.class);
        swfPathDao.save(swfPath);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfPathDto queryByPK(java.lang.Integer modelNo,java.lang.Integer pathNo) {
        SwfPathKey swfPathKey = new SwfPathKey(modelNo,pathNo);
        SwfPath swfPath = swfPathDao.findOne(swfPathKey);
        return this.convert(swfPath,SwfPathDto.class);
    }
    /**
	 * @description 检验是不是满足路径上的条件
	 * @author yanlei
	 * @param swfPathDto 工作流路径对象
	 * @param iBusinessNo 检验条件
	 * @return
	 */
	@Override
	public boolean checkPathCondition(SwfPathDto swfPathDto, String iBusinessNo) {
		List wfConditionDtoList = new ArrayList();
		boolean blnResult = false;
		wfConditionDtoList =swfPathDao.findByModelNoAndPathNo(swfPathDto.getModelNo(), swfPathDto.getPathNo());
		Iterator itcc =wfConditionDtoList.iterator();
		//必须设置开始的条件检验为 true
		while (itcc.hasNext()){
			SwfConditionDto swfConditionDto = new SwfConditionDto();
			swfConditionDto= convert((SwfCondition) itcc.next(),SwfConditionDto.class) ;
			//根据业务号码，判断业务数据库中是否满足路径上的条件，如果都满足，则说明可以通过
			//.0/1简单条件
			if (swfConditionDto.getConfigType().equals("0")||swfConditionDto.getConfigType().equals("1")){
				String businessKey = swfConditionDto.getBusinessKey().trim();
				String configText = swfConditionDto.getConfigText().trim();
				String tableName = swfConditionDto.getTableName().trim();
				String strTemp = "SELECT COUNT(1) FROM " + tableName + " where " + businessKey + "= :businessKey?1 AND " + configText;
				Query query=entityManager.createQuery(strTemp);
				query.setParameter(1, iBusinessNo);
				int resultList=query.getFirstResult();
				if(resultList>0){
					blnResult = true ;
				}
			}
			 // 2高级条件或者是function
	        if (swfConditionDto.getConfigType().equals("2")){
	        //目前没有设置function (保留)
	        }
			//如果不符合条件,立即跳出循环
			if (!blnResult) break;
		}
		return blnResult;
	}
    
}