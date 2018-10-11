package com.sinosoft.agriclaim.web.individuation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.individuation.UndwrtInfoClaimApi;
import com.sinosoft.agriclaim.api.individuation.dto.UndwrtInfoClaimDto;
import com.sinosoft.agriclaim.core.individuation.service.UndwrtInfoClaimService;

/**
 * 
 * @author jiaoyunzhen
 *
 */
@RestController
@RequestMapping(value = UndwrtInfoClaimController.PATH)
public class UndwrtInfoClaimController implements UndwrtInfoClaimApi{
	
	private static Logger LOGGER = LoggerFactory.getLogger(UndwrtInfoClaimController.class);
	
	@Autowired
    private UndwrtInfoClaimService undwrtInfoClaimService;

	@Override
	@ResponseBody
	public void checkPass(@RequestBody UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception {
		undwrtInfoClaimService.checkPass(undwrtInfoClaimDto);
	}

	@Override
	@ResponseBody
	public void issuedRevise(@RequestBody UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception {
		undwrtInfoClaimService.issuedRevise(undwrtInfoClaimDto);
	}

}
