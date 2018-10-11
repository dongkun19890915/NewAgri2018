package com.sinosoft.agriclaim.core.businessutilmanage.utils;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimCodeDto;

import java.util.ArrayList;
import java.util.List;

public class UsuallyUseUtils {

    /**
     * 当前状态转化为中文，nodestatus,（0未处理）/（2，3正在处理）/（4已处理，5不通过退回）
     * @author: 孙朋飞
     * @date: 2017/12/12 9:39
     * @param nodeStatus 当前状态
     * @return 返回当前状态的中文
     * @throws Exception
     */
    public static String nodeStatusToChinese(String nodeStatus) throws Exception{
        if("0".equals(nodeStatus)){
           return AgriClaimConstant.AGRI_CLAIM_TO_BE_DONE;
        }else if("2".equals(nodeStatus)||"3".equals(nodeStatus)){
            return AgriClaimConstant.AGRI_CLAIM_BEING_DONE;
        }else if("4".equals(nodeStatus)||"5".equals(nodeStatus)||"8".equals(nodeStatus)){
            return AgriClaimConstant.AGRI_CLAIM_DONE;
        }
        return "";
    }

    /**
     * 流程状态转化为中文“0”-流转结束；“1”-正常流转；“9”-流转异常
     * @author: 孙朋飞
     * @date: 2017/12/12 9:52
     * @param flowStatus 流程的状态
     * @return 返回流程状态的中文
     * @throws Exception
     */
    public static String flowStatusToChinese(String flowStatus) throws Exception{
        if("0".equals(flowStatus)){
            return AgriClaimConstant.AGRI_CLAIM_FLOWEND;
        }else if("1".equals(flowStatus)){
            return AgriClaimConstant.AGRI_CLAIM_FLOWNOMAL;
        }else if("9".equals(flowStatus)){
            return AgriClaimConstant.AGRI_CLAIM_FLOWEXCEPTION;
        }
        return "";
    }

    /**
     *节点的英文名转化为中文
     * @author: 孙朋飞
     * @date: 2017/12/16 11:55
     * @param nodeType 节点英文
     * @return 节点的中文名
     * @throws Exception
     */
    public static String nodeTypeTransformToChinese(String nodeType) throws Exception{
        if("backc".equals(nodeType)){
            return "回勘";
        }else if("cance".equals(nodeType)){
            return "注销/拒赔";
        }else if("certa".equals(nodeType)){
            return "定损";
        } else if("certi".equals(nodeType)){
            return "单证";
        } else if("check".equals(nodeType)){
            return "查勘";
        } else if("claim".equals(nodeType)){
            return "立案";
        } else if("compe".equals(nodeType)){
            return "理算";
        } else if("compp".equals(nodeType)){
            return "计算书";
        } else if("endca".equals(nodeType)){
            return "结案";
        } else if("prepa".equals(nodeType)){
            return "预赔";
        } else if("propc".equals(nodeType)){
            return "财产定损";
        } else if("propv".equals(nodeType)){
            return "财产核损";
        } else if("regis".equals(nodeType)){
            return "报案";
        } else if("rview".equals(nodeType)){
            return "人伤复核";
        } else if("sched".equals(nodeType)){
            return "调度";
        } else if("schel".equals(nodeType)){
            return "定损调度";
        } else if("speci".equals(nodeType)){
            return "特殊赔案";
        } else if("surve".equals(nodeType)){
            return "人伤查勘";
        } else if("veric".equals(nodeType)){
            return "核赔";
        } else if("verif".equals(nodeType)){
            return "核损";
        } else if("verip".equals(nodeType)){
            return "核价";
        } else if("veriw".equals(nodeType)){
            return "人伤核损";
        } else if("verpo".equals(nodeType)){
            return "向外询价";
        } else if("wound".equals(nodeType)){
            return "人伤定损";
        }
        return "";
    }
    /**
     *查询的数据封装成父子级关系dto
     * @author: 孙朋飞
     * @date: 2017/12/25 9:16
     * @param comCode 班表机构
     * @param resultList 班表机构集合
     * @return 有父子级关系的dto
     */
    public static SelectClaimCodeDto  createComCodeTree(String comCode, List<SelectClaimCodeDto> resultList){
        SelectClaimCodeDto selectClaimCode = parentTree(comCode, resultList);
        //获取comcode下面所有的子节点
        List<SelectClaimCodeDto> selectClaimDtoList=null;
        if(selectClaimCode!=null){
            selectClaimDtoList = childTree(selectClaimCode.getCodeCode(), resultList);
        }
        if(selectClaimDtoList!=null){
            for (SelectClaimCodeDto dcompany : selectClaimDtoList) {
                SelectClaimCodeDto selectClaim = createComCodeTree(dcompany.getCodeCode(), resultList);
                selectClaimCode.getSelectClaimList().add(selectClaim);
            }
        }
        return selectClaimCode;
    }
    /**
     * 获取当前班表机构的节点对象
     * @author: 孙朋飞
     * @date: 2017/12/25 9:13
     * @param comCode 班表机构
     * @param list 传入的参数集合
     * @return 当前班表机构的节点对象
     */
    public static SelectClaimCodeDto parentTree(String comCode, List<SelectClaimCodeDto> list) {
        //根据comcode获取节点对象
        for (SelectClaimCodeDto selectClaimCodeDto : list) {
            if(comCode.equals(selectClaimCodeDto.getCodeCode())){
                return selectClaimCodeDto;
            }
        }
        return null;
    }
    /**
     * 获取comcode下面的子节点
     * @author: 孙朋飞
     * @date: 2017/12/25 9:13
     * @param comCode 班表机构
     * @param list 传入的参数集合
     * @return 所有的子节点
     */
    public static List<SelectClaimCodeDto> childTree(String comCode,List<SelectClaimCodeDto> list) {
        //根据comcode获取节点对象
        List<SelectClaimCodeDto> childList=new ArrayList<>();
        for (SelectClaimCodeDto selectClaimCodeDto : list) {
            if (comCode.equals(selectClaimCodeDto.getUpperComCode())&&!selectClaimCodeDto.getCodeCode().equals(selectClaimCodeDto.getUpperComCode())) {
                childList.add(selectClaimCodeDto);
            }
        }
        return childList;
    }

}
