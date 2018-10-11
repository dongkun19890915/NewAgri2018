package com.sinosoft.txnlist.core.makeuplist.readexcel;

import com.sinosoft.framework.agri.core.excel.hanlder.ReadHandler;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.makeuplist.dto.CodeKeyDto;
import com.sinosoft.txnlist.api.makeuplist.dto.EarLabelListDto;

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
public class EarLabelExcelReadHandler implements ReadHandler {

    private Map<CodeKeyDto, Integer> earLabelNumber = new HashMap<>();

    private List<EarLabelListDto> earLabelListDtos = new ArrayList<>();

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
            this.readEarLabelList(row);
            this.readEarLabelNumber(row);
        } else {
            index++;
            boolean checkFormat;
            try {
                checkFormat = row.get(0).equals("清单编号") && row.get(1).equals("农户代码") && row.get(2).equals("农户姓名") &&
                        row.get(3).equals("标的序号") && row.get(4).equals("标的名称") && row.get(5).equals("耳标号");
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
    private void readEarLabelList(List<String> row) {
        String fCode = row.get(1);
        String itemCode = row.get(3);
        CodeKeyDto codeKeyDto = new CodeKeyDto(fCode, itemCode);
        if (earLabelNumber.containsKey(codeKeyDto)) {
            Integer sum = earLabelNumber.get(codeKeyDto);
            earLabelNumber.put(codeKeyDto, sum + 1);
        } else {
            earLabelNumber.put(codeKeyDto, 1);
        }
    }

    /**
     * 解析excel数据并汇总得到农户-标的耳标号数量
     *
     * @param row 当前数据
     * @date: 2018/2/7 16:45
     * @author: 何伟东
     */
    private void readEarLabelNumber(List<String> row) {
        EarLabelListDto earLabelListDto = new EarLabelListDto();
        earLabelListDto.setInsureListCode(row.get(0));
        earLabelListDto.setfCode(row.get(1));
        earLabelListDto.setfName(row.get(2));
        earLabelListDto.setItemCode(row.get(3));
        earLabelListDto.setItemName(row.get(4));
        earLabelListDto.setEarLabel(row.get(5));
        earLabelListDtos.add(earLabelListDto);
    }


    /**
     * 获取农户对应标的投保数量
     *
     * @return earLabelNumber
     */
    public Map<CodeKeyDto, Integer> getEarLabelNumber() {
        return earLabelNumber;
    }

    /**
     * 获取导入的耳标号清单
     *
     * @return earLabelListDtos
     */
    public List<EarLabelListDto> getEarLabelListDtos() {
        return earLabelListDtos;
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
