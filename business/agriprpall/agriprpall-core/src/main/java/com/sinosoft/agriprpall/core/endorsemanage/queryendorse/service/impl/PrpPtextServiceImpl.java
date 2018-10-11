package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPtextDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPtextDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPtext;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPtextKey;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPtextService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * @description 批改文字信息表Core接口实现
 */
@Service
public class PrpPtextServiceImpl extends BaseServiceImpl implements PrpPtextService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPtextServiceImpl.class);
    
    @Autowired
    private PrpPtextDao prpPtextDao;
    @Autowired
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpPtextDto prpPtextDto) {
        PrpPtext prpPtext = this.convert(prpPtextDto, PrpPtext.class);
        prpPtextDao.save(prpPtext);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String endorseNo,String policyNo,Integer lineNo) {
        PrpPtextKey prpPtextKey = new PrpPtextKey(endorseNo,policyNo,lineNo);
        prpPtextDao.delete(prpPtextKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpPtextDto prpPtextDto) {
        PrpPtext prpPtext = this.convert(prpPtextDto, PrpPtext.class);
        prpPtextDao.save(prpPtext);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpPtextDto queryByPK(String endorseNo,String policyNo,Integer lineNo) {
        PrpPtextKey prpPtextKey = new PrpPtextKey(endorseNo,policyNo,lineNo);
        PrpPtext prpPtext = prpPtextDao.findOne(prpPtextKey);
        return this.convert(prpPtext,PrpPtextDto.class);
    }
    /**
     * 根据批单号查询批文信息
     * @author: 宋振振
     * @date: 2017/11/20 10:02
     * @param endorseNo 批单号
     * @return List<PrpPtextDto> 返回批文信息
     * @throws Exception
     */
    public  List<PrpPtextDto> queryPrpPtextByEndorseNo(String endorseNo)throws Exception{
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号endorseNo不能为空！");
        }
        List<PrpPtextDto> prpPtextDtoList=new ArrayList<PrpPtextDto>();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("select p from PrpPtext p where p.endorseNo=:endorseNo order by lineNo");
        Query dataQuery=entityManager.createQuery(stringBuilder.toString());
        dataQuery.setParameter("endorseNo",endorseNo);
        List<PrpPtext> prpPtextList=dataQuery.getResultList();
        convertCollection(prpPtextList,prpPtextDtoList,PrpPtextDto.class);

        return prpPtextDtoList;
    }
    /**
     * 修改批文
     * @author: 宋振振
     * @date: 2017/11/20 18:01
     * @param endorseNo 批单号
     * @param strPtext 批文
     * @param fromPage 是否该页从批单修改处进入的标志
     * @throws Exception
     */
    @Transactional
    public void modifyPrpPtext(String endorseNo,String strPtext,String fromPage)throws Exception{
        //校验参数
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号endorseNo不能为空！");
        }
        if(StringUtils.isEmpty(strPtext)){
            throw new DataVerifyException("strPtext不能为空！");
        }
        if(StringUtils.isEmpty(fromPage)){
            throw new DataVerifyException("fromPage不能为空！");
        }

        //从修改批文进入的处理
         if (fromPage.equals("EditText") ) //判断是否该页从批单修改处进入
        {
            StringBuilder stringBuilder=new StringBuilder("select p from PrpPhead p where p.endorseNo=:endorseNo");
            Query dataQuery=entityManager.createQuery(stringBuilder.toString());
            dataQuery.setParameter("endorseNo",endorseNo);
            List<PrpPhead> prpPheadList=dataQuery.getResultList();
            if( prpPheadList.size()>0) {
                PrpPtextDto prpPtextDto = new PrpPtextDto();
                prpPtextDto.setLineNo(0);
                prpPtextDto.setEndorseText(StringUtils.rightTrim(strPtext));

                List<PrpPtextDto> arrPrpPtextDtoList = ungroup(prpPtextDto);
                for (int i = 0; i < arrPrpPtextDtoList.size(); i++) {
                    arrPrpPtextDtoList.get(i).setEndorseNo(prpPheadList.get(0).getEndorseNo());
                    arrPrpPtextDtoList.get(i).setPolicyNo(prpPheadList.get(0).getPolicyNo());
                }
                String strEndorseNo = prpPheadList.get(0).getEndorseNo();
                //先删后插入
                StringBuilder deleteStringBuilder=new StringBuilder("DELETE FROM PrpPtext WHERE endorseNo=:endorseNo");
                Query deleteData=entityManager.createQuery(deleteStringBuilder.toString());
                deleteData.setParameter("endorseNo",strEndorseNo);
                deleteData.executeUpdate();

                List<PrpPtext> prpPtextList=new ArrayList<>();
                convertCollection(arrPrpPtextDtoList,prpPtextList,PrpPtext.class);

                prpPtextDao.save(prpPtextList);
            }
        }
    }
    /**
    * 批单保存前批文修改功能
    * @param strPtext   新批文
    * @return PrpPtextDto 批文对象
    * @throws Exception
    * @author 李冬松
    * @date 11:03 2018/1/10
    */
    @Transactional
    public List<PrpPtextDto> updatePrpPtext(String strPtext)throws Exception{
        if(StringUtils.isEmpty(strPtext)){
            throw new DataVerifyException("strPtext不能为空！");
        }
        PrpPtextDto prpPtextDto = new PrpPtextDto();
        prpPtextDto.setLineNo(0);
        prpPtextDto.setEndorseText(strPtext);
        List<PrpPtextDto> prpPtextDtoList = ungroup(prpPtextDto);
        return prpPtextDtoList;
    }

    /**
     * 将PrpPtextDto里面的批文按80长度拆分成多个PrpPtextDto
     * @author: 宋振振
     * @date: 2017/11/20 18:27
     * @param prpPtextDto 批改文字信息
     * @return List<PrpPtextDto> 批改文字信息集合
     * @throws Exception
     */
    private List<PrpPtextDto> ungroup(PrpPtextDto prpPtextDto) throws Exception {

        PrpPtextDto prpPtextSchemaAdd = null; // 新增Schema
        String[] arrEndorseText = {}; // 拆分的批文数组
        List list = new ArrayList(); // 数组
        int intLineNo = 0; // 行号

        intLineNo = 0;
        StringBuilder buffer = new StringBuilder();
        // 循环拆分
        //for (int i = 0; i < this.getSize(); i++) {
            if (prpPtextDto.getEndorseText() == null) {
                prpPtextDto.setEndorseText("");
            }
            buffer.append(prpPtextDto.getEndorseText());
        //}
        // 拆分
        if (buffer.length() == 0) {
            String[] arrTemp = new String[1];
            arrTemp[0] = "";
            arrEndorseText = arrTemp;

        } else {
            //System.out.println(arrEndorseText);
            LOGGER.error(buffer.toString());
            arrEndorseText = splits(buffer.toString(), AgriPrpallConstant.AGRI_PRPALL_SERVICE_FIELDLENGHT);//FIELDLENGHT=80

        }

        // 赋值
        for (int i = 0; i < arrEndorseText.length; i++) {
            // 长度校验
            if (arrEndorseText[i].length() > AgriPrpallConstant.AGRI_PRPALL_SERVICE_FIELDLENGHT) {
                 throw new DataVerifyException("批文长度过长！");
            }

            intLineNo++; // 行号加一
            prpPtextSchemaAdd = new PrpPtextDto();
            prpPtextSchemaAdd.setEndorseNo(prpPtextDto.getEndorseNo());
            prpPtextSchemaAdd.setPolicyNo(prpPtextDto.getPolicyNo());
            prpPtextSchemaAdd.setLineNo(intLineNo);
            prpPtextSchemaAdd.setEndorseText(arrEndorseText[i]);
            prpPtextSchemaAdd.setFlag(prpPtextDto.getFlag());
            list.add(prpPtextSchemaAdd);
        }

        return list;
    }

    private static String[] splits(String originalString, int splitByteLength){
        if(originalString.isEmpty()){
            return null;
        }

        int total=originalString.length();
        //获取数组总长度
        int len=(int)  Math.ceil(total/Double.valueOf(splitByteLength));
        //截取的起始位置
        int startIndex,endIndex;

        String[] ary=new String[len];
        String temp;
        for(int i=0;i<len;i++){
            startIndex=i*splitByteLength;
            endIndex=(i+1)*splitByteLength;
            if(endIndex>total){
                endIndex=total;
            }
            temp=originalString.substring(startIndex,endIndex);
            ary[i]=temp;
        }
        return ary;
    }
}