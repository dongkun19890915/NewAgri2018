package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.BLPDataService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BLPDataServiceImpl extends BaseServiceImpl implements BLPDataService {
    @Autowired
    private PrpPexpenseDao prpPexpenseDao;
    @Autowired
    private PrpPfeeDao prpPfeeDao;
    @Autowired
    private PrpPmainDao prpPmainDao;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpPmainAgriDao prpPmainAgriDao;
    @Autowired
    private PrpPengageDao prpPengageDao;
    @Autowired
    private PrpPaddressDao prpPaddressDao;
    @Autowired
    private PrpPcoinsDao prpPcoinsDao;
    @Autowired
    private PrpPinsuredDao prpPinsuredDao;
    @Autowired
    private PrpPitemKindAgriDao prpPitemKindAgriDao;
    @Autowired
    private PrpPitemKindDao prpPitemKindDao;
    @Autowired
    private PrpPplanDao prpPplanDao;
    @Autowired
    private PrpPsubSidyDao prpPsubSidyDao;
    @Autowired
    private PrpPcoinsDetailDao prpPcoinsDetailDao;
    @Autowired
    private PrpPtextDao prpPtextDao;
    @Autowired
    private PrpPheadCopyDao prpPheadCopyDao;
    @Autowired
    private PrpPmainCopyDao prpPmainCopyDao;
    @Autowired
    private PrpPitemKindCopyDao prpPitemKindCopyDao;
    @Autowired
    private PrpPitemKindAgriCopyDao prpPitemKindAgriCopyDao;
    @Autowired
    private PrpPaddressCopyDao prpPaddressCopyDao;
    @Autowired
    private PrpPfeeCopyDao prpPfeeCopyDao;
    @Autowired
    private PrpPplanCopyDao prpPplanCopyDao;
    @Autowired
    private PrpPcoinsCopyDao prpPcoinsCopyDao;
    @Autowired
    private PrpPplanCoinsCopyDao prpPplanCoinsCopyDao;
    @Autowired
    private PrpPengageCopyDao prpPengageCopyDao;
    @Autowired
    private PrpPexpenseCopyDao prpPexpenseCopyDao;
    @Autowired
    private PrpPmainAgriCopyDao prpPmainAgriCopyDao;
    @Autowired
    private PrpPsubSidyCopyDao prpPsubSidyCopyDao;
    @Autowired
    private PrpPinsuredCopyDao prpPinsuredCopyDao;
    @Autowired
    private PrpPcoinsDetailCopyDao prpPcoinsDetailCopyDao;
    /**
    * P表保存
    * @param blEndorseDto 批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 16:38 2017/12/21
    */
    @Override
    public void saveP(PolicyEndorseDto policyEndorseDto) throws Exception{
        savePrimaryKeyTable(policyEndorseDto);
        saveOth(policyEndorseDto);
    }
    /**
    * P表外键关联表的保存
    * @param blEndorseDto 批单大对象
    * @return void
    * @throws
    * @author 李冬松
    * @date 16:38 2017/12/21
    */
    @Transactional
    public void savePrimaryKeyTable(PolicyEndorseDto policyEndorseDto) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDtoOld=policyEndorseDto.getBlPolicyInfoDtoOld();
        BLEndorseDto blEndorseDto=policyEndorseDto.getBlEndorseDto();
        if (blEndorseDto==null){
            throw new Exception("没有传入blEndorseDto对象");
        }
        try{
            PrpPheadDto prpPheadDto=blEndorseDto.getPrpPheadDto();
            if (prpPheadDto!=null){
                PrpPhead prpPhead=convert(prpPheadDto,PrpPhead.class);
                prpPheadDao.saveAndFlush(prpPhead);
                prpPheadCopyDao.saveAndFlush(convert(prpPhead,PrpPheadCopy.class));

            }
            List<PrpPitemKindDto> prpPitemKindDtoList =blEndorseDto.getPrpPitemKindDtoList();
            if (prpPitemKindDtoList !=null && prpPitemKindDtoList.size()!=0){
                List<PrpPitemKind> prpPitemKindList =new ArrayList<PrpPitemKind>();
                convertCollection(prpPitemKindDtoList, prpPitemKindList,PrpPitemKind.class);
                prpPitemKindDao.save(prpPitemKindList);
                List<PrpPitemKindCopy> prpPitemKindCopyList=new ArrayList<>();
                convertCollection(prpPitemKindDtoList,prpPitemKindCopyList,PrpPitemKindCopy.class);
                prpPitemKindCopyDao.save(prpPitemKindCopyList);
            }else {
                List<PrpPitemKindCopy> prpPitemKindCopyList=new ArrayList<>();
                convertCollection(blPolicyDtoOld.getPrpCitemKindDtoList(),prpPitemKindCopyList,PrpPitemKindCopy.class);
                for(PrpPitemKindCopy prpPitemKindCopy:prpPitemKindCopyList){
                    prpPitemKindCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPitemKindCopyDao.save(prpPitemKindCopyList);

            }
        }catch (Exception e){
            throw new DataVerifyException("外键关联表保存失败！");
        }
    }
    /**
    * P表其他表的保存
    * @param policyEndorseDto  批单大对象
    * @return void
    * @throws
    * @author 李冬松
    * @date 16:39 2017/12/21
    */
    @Transactional
    public void saveOth(PolicyEndorseDto policyEndorseDto) throws Exception{
        BLEndorseDto blEndorseDto=policyEndorseDto.getBlEndorseDto();
        ResponseQueryPolicyInfoDto blPolicyDtoOld=policyEndorseDto.getBlPolicyInfoDtoOld();
        try {
            PrpPexpenseDto prpPexpenseDto =blEndorseDto.getPrpPexpenseDto();
            if (prpPexpenseDto != null) {
                PrpPexpense prpPexpense = convert(prpPexpenseDto, PrpPexpense.class);
                prpPexpenseDao.saveAndFlush(prpPexpense);
                prpPexpenseCopyDao.saveAndFlush(convert(prpPexpense, PrpPexpenseCopy.class));
            }
//            }else {
//                PrpPexpenseCopy prpPexpenseCopy=convert(blPolicyDtoOld.getPrpCexpenseDto(),PrpPexpenseCopy.class);
//                prpPexpenseCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
//                prpPexpenseCopyDao.saveAndFlush(prpPexpenseCopy);
//            }

            List<PrpPfeeDto> prpPfeeDtoList=blEndorseDto.getPrpPfeeDtoList();
            if (prpPfeeDtoList!=null&&prpPfeeDtoList.size()>0){
                List<PrpPfee> prpPfeeList=new ArrayList<>();
                convertCollection(prpPfeeDtoList,prpPfeeList,PrpPfee.class);
                prpPfeeDao.save(prpPfeeList);
                List<PrpPfeeCopy> prpPfeeCopyList=new ArrayList<>();
                convertCollection(prpPfeeList,prpPfeeCopyList,PrpPfeeCopy.class);
                prpPfeeCopyDao.save(prpPfeeCopyList);
            }else {
                List<PrpPfeeCopy> prpPfeeCopyList=new ArrayList<>();
                convertCollection(blPolicyDtoOld.getPrpCfeeDtoList(),prpPfeeCopyList,PrpPfeeCopy.class);
                for (PrpPfeeCopy prpPfeeCopy: prpPfeeCopyList){
                    prpPfeeCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPfeeCopyDao.save(prpPfeeCopyList);
            }

            PrpPmainDto prpPmainDto =blEndorseDto.getPrpPmainDto();
            if (prpPmainDto !=null){
                PrpPmain prpPmain =convert(prpPmainDto,PrpPmain.class);
                prpPmainDao.save(prpPmain);
                prpPmainCopyDao.save(convert(prpPmain,PrpPmainCopy.class));
            }else{
                PrpPmainCopy prpPmainCopy=convert(blPolicyDtoOld.getPrpCmainDto(),PrpPmainCopy.class);
                prpPmainCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                prpPmainCopyDao.save(prpPmainCopy);
            }
            PrpPmainAgriDto prpPmainAgriDto=blEndorseDto.getPrpPmainAgriDto();
            if (prpPmainAgriDto!=null){
                PrpPmainAgri prpPmainAgri=convert(prpPmainAgriDto,PrpPmainAgri.class);
                prpPmainAgriDao.save(prpPmainAgri);
                prpPmainAgriCopyDao.save(convert(prpPmainAgri,PrpPmainAgriCopy.class));
            }else {
                PrpPmainAgriCopy prpPmainAgriCopy=convert(blPolicyDtoOld.getPrpCmainAgriDto(),PrpPmainAgriCopy.class);
                prpPmainAgriCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                prpPmainAgriCopyDao.save(prpPmainAgriCopy);
            }

            List<PrpPengageDto> prpPengageDtoList =blEndorseDto.getPrpPengageDtoList();
            if (prpPengageDtoList !=null && prpPengageDtoList.size()!=0){
                List<PrpPengage> prpPengageList =new ArrayList<PrpPengage>();
                convertCollection(prpPengageDtoList, prpPengageList,PrpPengage.class);
                prpPengageDao.save(prpPengageList);
                List<PrpPengageCopy> prpPengageCopyList=new ArrayList<>();
                convertCollection(prpPengageList,prpPengageCopyList,PrpPengageCopy.class);
                prpPengageCopyDao.save(prpPengageCopyList);
            }else {
                List<PrpPengageCopy> prpPengageCopyList=new ArrayList<>();
                convertCollection(blPolicyDtoOld.getPrpCengageDtoList(),prpPengageCopyList,PrpPengageCopy.class);
                for(PrpPengageCopy prpPengageCopy:prpPengageCopyList){
                    prpPengageCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPengageCopyDao.save(prpPengageCopyList);
            }

            List<PrpPaddressDto> prpPaddressDtoList=blEndorseDto.getPrpPaddressDtoList();
            if (prpPaddressDtoList!=null && prpPaddressDtoList.size()!=0){
                List<PrpPaddress> prpPaddressList=new ArrayList<PrpPaddress>();
                convertCollection(prpPaddressDtoList,prpPaddressList,PrpPaddress.class);
                prpPaddressDao.save(prpPaddressList);
                List<PrpPaddressCopy> prpPaddressCopyList=new ArrayList<>();
                convertCollection(prpPaddressList,prpPaddressCopyList,PrpPaddressCopy.class);
                prpPaddressCopyDao.save(prpPaddressCopyList);
            }else {
                List<PrpPaddressCopy> prpPaddressCopyList=new ArrayList<>();
                convertCollection(blPolicyDtoOld.getPrpCaddressDtoList(),prpPaddressCopyList,PrpPaddressCopy.class);
                for(PrpPaddressCopy prpPaddressCopy:prpPaddressCopyList){
                    prpPaddressCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPaddressCopyDao.save(prpPaddressCopyList);
            }

            List<PrpPcoinsDto> prpPcoinsDtoList =blEndorseDto.getPrpPcoinsDtoList();
            if (prpPcoinsDtoList !=null && prpPcoinsDtoList.size()!=0){
                List<PrpPcoins> prpPcoinsList =new ArrayList<PrpPcoins>();
                convertCollection(prpPcoinsDtoList, prpPcoinsList,PrpPcoins.class);
                prpPcoinsDao.save(prpPcoinsList);
                List<PrpPcoinsCopy> prpPcoinsCopyList=new ArrayList<>();
                convertCollection(prpPcoinsList,prpPcoinsCopyList,PrpPcoinsCopy.class);
                prpPcoinsCopyDao.save(prpPcoinsCopyList);
            }else{
                List<PrpPcoinsCopy> prpPcoinsCopyList=new ArrayList<>();
                convertCollection(blPolicyDtoOld.getPrpCcoinsDtoList(),prpPcoinsCopyList,PrpPcoinsCopy.class);
                for(PrpPcoinsCopy prpPcoinsCopy:prpPcoinsCopyList){
                    prpPcoinsCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPcoinsCopyDao.save(prpPcoinsCopyList);
            }

            List<PrpPinsuredDto> prpPinsuredDtoList=blEndorseDto.getPrpPinsuredDtoList();
            if (prpPinsuredDtoList!=null && prpPinsuredDtoList.size()!=0){
                List<PrpPinsured> prpPinsuredList=new ArrayList<PrpPinsured>();
                convertCollection(prpPinsuredDtoList,prpPinsuredList,PrpPinsured.class);
                prpPinsuredDao.save(prpPinsuredList);
                List<PrpPinsuredCopy> PrpPinsuredCopyList=new ArrayList<>();
                convertCollection(prpPinsuredList,PrpPinsuredCopyList,PrpPinsuredCopy.class);
                prpPinsuredCopyDao.save(PrpPinsuredCopyList);
            }else{
                List<PrpPinsuredCopy> PrpPinsuredCopyList=new ArrayList<>();
                convertCollection(blPolicyDtoOld.getPrpCinsuredDtoList(),PrpPinsuredCopyList,PrpPinsuredCopy.class);
                for(PrpPinsuredCopy prpPinsuredCopy:PrpPinsuredCopyList){
                    prpPinsuredCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPinsuredCopyDao.save(PrpPinsuredCopyList);
            }

            List<PrpPitemKindAgriDto> prpPitemKindAgriDtoList=blEndorseDto.getPrpPitemKindAgriDtoList();

                String endorseNo=blEndorseDto.getPrpPheadDto().getEndorseNo();
                for (PrpPitemKindAgriDto prpPitemKindAgriDto:prpPitemKindAgriDtoList){
                    prpPitemKindAgriDto.setEndorseNo(endorseNo);
                }
                List<PrpPitemKindAgri> prpPitemKindAgriList=new ArrayList<PrpPitemKindAgri>();
                convertCollection(prpPitemKindAgriDtoList,prpPitemKindAgriList,PrpPitemKindAgri.class);
                prpPitemKindAgriDao.save(prpPitemKindAgriList);
                List<PrpPitemKindAgriCopy> PrpPitemKindAgriCopys=new ArrayList<>();
                convertCollection(blPolicyDtoOld.getPrpCitemKindAgriDtoList(),PrpPitemKindAgriCopys,PrpPitemKindAgriCopy.class);
                for(PrpPitemKindAgriCopy prpPitemKindAgriCopy:PrpPitemKindAgriCopys){
                    prpPitemKindAgriCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPitemKindAgriCopyDao.save(PrpPitemKindAgriCopys);


            List<PrpPtextDto> prpPtextDtoList=blEndorseDto.getPrpPtextDtoList();
            if(prpPtextDtoList!=null&& prpPtextDtoList.size()!=0){
                List<PrpPtext> prpPtextList=new ArrayList<>();
                convertCollection(prpPtextDtoList,prpPtextList,PrpPtext.class);
                prpPtextDao.save(prpPtextList);
            }


            List<PrpPplanDto> prpPplanDtoList =blEndorseDto.getPrpPplanDtoList();
            if (prpPplanDtoList !=null && prpPplanDtoList.size()!=0){
                List<PrpPplan> prpPplanList =new ArrayList<PrpPplan>();
                convertCollection(prpPplanDtoList, prpPplanList,PrpPplan.class);
                prpPplanDao.save(prpPplanList);
                List<PrpPplanCopy> prpPplanCopyList =new ArrayList<PrpPplanCopy>();
                convertCollection(prpPplanList,prpPplanCopyList,PrpPplanCopy.class);
                prpPplanCopyDao.save(prpPplanCopyList);
            }else{
                List<PrpPplanCopy> prpPplanCopyList =new ArrayList<PrpPplanCopy>();
                convertCollection(blPolicyDtoOld.getPrpCplanDtoList(),prpPplanCopyList,PrpPplanCopy.class);
                for(PrpPplanCopy prpPplanCopy:prpPplanCopyList){
                    prpPplanCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPplanCopyDao.save(prpPplanCopyList);
            }

            List<PrpPsubsidyDto> prpPsubsidyDtoList=blEndorseDto.getPrpPsubsidyDtoList();
            if (prpPsubsidyDtoList!=null && prpPsubsidyDtoList.size()!=0){
                List<PrpPsubSidy> prpPsubsidyList=new ArrayList<PrpPsubSidy>();
                convertCollection(prpPsubsidyDtoList,prpPsubsidyList,PrpPsubSidy.class);
                prpPsubSidyDao.save(prpPsubsidyList);
                List<PrpPsubSidyCopy> prpPsubSidyCopyList =new ArrayList<PrpPsubSidyCopy>();
                convertCollection(prpPsubsidyList,prpPsubSidyCopyList,PrpPsubSidyCopy.class);
                prpPsubSidyCopyDao.save(prpPsubSidyCopyList);
            }else{
                List<PrpPsubSidyCopy> prpPsubSidyCopyList =new ArrayList<PrpPsubSidyCopy>();
                convertCollection(blPolicyDtoOld.getPrpCsubsidyDtoList(),prpPsubSidyCopyList,PrpPsubSidyCopy.class);
                for(PrpPsubSidyCopy prpPsubSidyCopy:prpPsubSidyCopyList){
                    prpPsubSidyCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPsubSidyCopyDao.save(prpPsubSidyCopyList);
            }

            List<PrpPcoinsDetailDto> prpPCoinsDetailDtoList=blEndorseDto.getPrpPcoinsDetailDtoList();
            if (prpPCoinsDetailDtoList!=null && prpPCoinsDetailDtoList.size()!=0){
                List<PrpPcoinsDetail> prpPcoinsDetailList=new ArrayList<PrpPcoinsDetail>();
                convertCollection(prpPCoinsDetailDtoList,prpPcoinsDetailList,PrpPcoinsDetail.class);
                prpPcoinsDetailDao.save(prpPcoinsDetailList);
                List<PrpPcoinsDetailCopy> prpPcoinsDetailCopyList =new ArrayList<PrpPcoinsDetailCopy>();
                convertCollection(prpPcoinsDetailList,prpPcoinsDetailCopyList,PrpPcoinsDetailCopy.class);
                prpPcoinsDetailCopyDao.save(prpPcoinsDetailCopyList);
            }else{
                List<PrpPcoinsDetailCopy> prpPcoinsDetailCopyList =new ArrayList<PrpPcoinsDetailCopy>();
                convertCollection(blPolicyDtoOld.getPrpCcoinsDetailDtoList(),prpPcoinsDetailCopyList,PrpPcoinsDetailCopy.class);
                for(PrpPcoinsDetailCopy prpPcoinsDetailCopy:prpPcoinsDetailCopyList){
                    prpPcoinsDetailCopy.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                }
                prpPcoinsDetailCopyDao.save(prpPcoinsDetailCopyList);
            }

        }catch (Exception e){
                prpPheadDao.deleteByEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                prpPitemKindDao.deleteByEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());

                prpPheadCopyDao.deleteByEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                prpPitemKindCopyDao.deleteByEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                throw new DataVerifyException("P表保存失败！");
            }
    }
    /**
    * P表删除
    * @param endorseNo 批单号
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 16:39 2017/12/21
    */
    @Override
    public void deleteP(String endorseNo) throws Exception {
        if (StringUtils.isEmpty(endorseNo)){
            throw new Exception("批单号不能为空,请传入");
        }

        prpPexpenseDao.deleteByEndorseNo(endorseNo);

        prpPfeeDao.deleteByEndorseNo(endorseNo);

        prpPmainDao.deleteByEndorseNo(endorseNo);

        prpPheadDao.deleteByEndorseNo(endorseNo);

        prpPmainAgriDao.deleteByEndorseNo(endorseNo);

        prpPengageDao.deleteByEndorseNo(endorseNo);

        prpPaddressDao.deleteByEndorseNo(endorseNo);

        prpPcoinsDao.deleteByEndorseNo(endorseNo);

        prpPinsuredDao.deleteByEndorseNo(endorseNo);

        prpPitemKindAgriDao.deleteByEndorseNo(endorseNo);

        prpPitemKindDao.deleteByEndorseNo(endorseNo);

        prpPplanDao.deleteByEndorseNo(endorseNo);

        prpPsubSidyDao.deleteByEndorseNo(endorseNo);

        prpPcoinsDetailDao.deleteByEndorseNo(endorseNo);

        prpPtextDao.cancelPrpPtext(endorseNo);
    }
}
