package com.sinosoft.txnlist.core.makeuplist.readexcel;

import com.sinosoft.framework.agri.core.excel.hanlder.ReadHandler;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.makeuplist.dto.CodeKeyDto;
import com.sinosoft.txnlist.api.makeuplist.dto.JointInsuredListDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 耳标号清单Excel读取数据处理类
 *
 * @date: 2018/2/7 15:56
 * @author: 何伟东
 */
public class JoinInsuredReadHandler implements ReadHandler {

    private Map<CodeKeyDto, Integer> jointInsuredNumber = new HashMap<>();

    private List<JointInsuredListDto> jointInsuredListDtos = new ArrayList<>();

    private String inusreListCode = "";
    private String inusreListCodeOld = "";

    private int index = 0;

    /**
     * 处理当前行数据
     *
     * @param sheetIndex 当前sheet页的页码,从0开始
     * @param rowIndex   当前行的行号，从0开始
     * @param row        当前行数据
     * @author: 何伟东
     * @date: 2018/2/7 15:56
     */
    @Override
    public void handler(int sheetIndex, int rowIndex, List<String> row) {
        if (index != 0) {
            String insureListCode = row.get(0);
            this.inusreListCodeOld = this.inusreListCode;
            this.inusreListCode = insureListCode;
            if (!this.inusreListCodeOld.equals("") && !this.inusreListCodeOld.equals(this.inusreListCode)) {
                throw new DataVerifyException("第" + (sheetIndex + 1) + "个sheet页的第" + (rowIndex + 1) + "行,清单号码[" + insureListCode + "]与其他清单号码不一致！");
            }
            this.joinInsuredList(row);
            this.joinInsuredNumber(row);
        } else {
            index++;
            boolean checkFormat;
            try {
                checkFormat = row.get(0).equals("清单编号") && row.get(1).equals("农户代码") && row.get(2).equals("农户姓名")
                        && row.get(3).equals("标的序号") && row.get(4).equals("证件类型") && row.get(5).equals("证件号码")
                        && row.get(6).equals("姓名") && row.get(7).equals("性别") && row.get(8).equals("与农户关系");
            } catch (Exception e) {
                checkFormat = false;
            }
            if (!checkFormat) {
                throw new DataVerifyException("您导入的格式不符合系统要求，请下载模板重新编辑导入！");
            }
        }
    }


    /**
     * 解析excel数据保存到list中
     *
     * @param row 当前行数据
     * @date: 2018/2/7 16:45
     * @author: 何伟东
     */
    private void joinInsuredList(List<String> row) {
        JointInsuredListDto jointInsuredListDto = new JointInsuredListDto();
        jointInsuredListDto.setInsureListCode(row.get(0));
        jointInsuredListDto.setfCode(row.get(1));
        jointInsuredListDto.setfName(row.get(2));
        jointInsuredListDto.setItemCode(row.get(3));
        jointInsuredListDto.setIdType(row.get(4));
        jointInsuredListDto.setIdCard(row.get(5));
        jointInsuredListDto.setName(row.get(6));
        jointInsuredListDto.setSex(row.get(7));
        jointInsuredListDto.setRelation(row.get(8));
        jointInsuredListDtos.add(jointInsuredListDto);
    }

    /**
     * 解析excel数据并汇总得到农户-标的耳标号数量
     *
     * @param row 当前数据
     * @date: 2018/2/7 16:45
     * @author: 何伟东
     */
    private void joinInsuredNumber(List<String> row) {
        String fCode = row.get(1);
        String itemCode = row.get(3);
        CodeKeyDto codeKeyDto = new CodeKeyDto(fCode, itemCode);
        if (jointInsuredNumber.containsKey(codeKeyDto)) {
            Integer sum = jointInsuredNumber.get(codeKeyDto);
            jointInsuredNumber.put(codeKeyDto, sum + 1);
        } else {
            jointInsuredNumber.put(codeKeyDto, 1);
        }
    }


    /**
     * 获取农户对应标的投保数量
     *
     * @return jointInsuredNumber
     */
    public Map<CodeKeyDto, Integer> getJointInsuredNumber() {
        return jointInsuredNumber;
    }

    /**
     * 获取导入的连带被保险人清单
     *
     * @return earLabelListDtos
     */
    public List<JointInsuredListDto> getJointInsuredListDtos() {
        return jointInsuredListDtos;
    }

    /**
     * 清单号码
     *
     * @return inusreListCode
     */
    public String getInusreListCode() {
        return inusreListCode;
    }


}
