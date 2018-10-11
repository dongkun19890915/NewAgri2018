package com.sinosoft.dms.web.bill;

import com.sinosoft.dms.api.bill.BillApi;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.core.bill.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = BillApi.ServicePath)
public class BillController implements BillApi{

    private static Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillService billService;

    @Override
    public String getProposalNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getProposalNo(billConditionDto);
    }

    @Override
    public String getOrderNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getOrderNo(billConditionDto);
    }

    @Override
    public String getPolicyNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getPolicyNo(billConditionDto);
    }

    @Override
    public String getEndorseNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getEndorseNo(billConditionDto);
    }

    @Override
    public String getApplyNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getApplyNo(billConditionDto);
    }

    @Override
    public String getItemNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getItemNo(billConditionDto);
    }

    @Override
    public String getCustomerCode(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getCustomerCode(billConditionDto);
    }

    @Override
    public String getSerialNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
        return billService.getSerialNo(billConditionDto);
    }

	@Override
	public String getBillNo(@RequestBody BillConditionDto billConditionDto) throws Exception {
		return billService.getBillNo(billConditionDto);
	}
}
