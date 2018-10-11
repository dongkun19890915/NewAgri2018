package com.sinosoft.agriprpall.core.paymanage.excel.read;

import com.sinosoft.agriprpall.api.paymanage.dto.PrpPayMainDto;
import com.sinosoft.framework.agri.core.excel.hanlder.ReadHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 读取导入的支付信息Excel数据时的回调类
 *
 * @author: 何伟东
 * @date: 2017/12/29 10:46
 */
public class PayInfoExcelRead implements ReadHandler {

    /**
     * 用于存储数据的list
     */
    private List<PrpPayMainDto> prpPayMainDtos = new ArrayList<>();

    /**
     * 处理当前行数据
     *
     * @param sheetIndex 当前sheet页的页码,从0开始
     * @param rowIndex   当前行的行号，从0开始
     * @param row        当前行数据
     * @author: 何伟东
     * @date: 2017/11/24 10:44
     */
    @Override
    public void handler(int sheetIndex, int rowIndex, List<String> row) {
        PrpPayMainDto prpPayMainDto = new PrpPayMainDto();
        //批单号码
        prpPayMainDto.setEndorseNo(row.get(1));
        //保单号码
        prpPayMainDto.setPolicyNo(row.get(2));
        //农户代码
        prpPayMainDto.setfCode(row.get(3));
        //农户名称
        prpPayMainDto.setfName(row.get(4));
        //领款人类型
        prpPayMainDto.setReceiverType(row.get(5));
        //领款人名称（银行账户户名）
        prpPayMainDto.setReceiverName(row.get(6));
        //领款人证件类型
        prpPayMainDto.setCertifyType(row.get(7));
        //领款人证件号
        prpPayMainDto.setCertifyNo(row.get(8));
        //开户银行大类名称bankType
        prpPayMainDto.setBankType(row.get(9));
        //开户银行所在省份名称bankProv
        prpPayMainDto.setBankProv(row.get(10));
        //开户银行所在城市名称bankCity
        prpPayMainDto.setBankCity(row.get(11));
        //开户银行名称bank
        prpPayMainDto.setBank(row.get(12));
        //银行账号bankAccount
        prpPayMainDto.setBankAccount(row.get(13));
        //账号属性accountType
        prpPayMainDto.setAccountType(row.get(14));
        //账号类型accountFlag
        prpPayMainDto.setAccountFlag(row.get(15));
        //领款人手机号码mobilePhone
        prpPayMainDto.setMobilePhone(row.get(16));
        //退款金额（元）chgPremium
        prpPayMainDto.setChgPremium(Double.parseDouble(row.get(17)));
        prpPayMainDtos.add(prpPayMainDto);
    }

    /**
     * 获取存储数据的list
     *
     * @return 存储支付信息数据的list
     * @author: 何伟东
     * @date: 2017/12/29 10:49
     */
    public List<PrpPayMainDto> getPrpPayMainDtos() {
        return prpPayMainDtos;
    }
}
