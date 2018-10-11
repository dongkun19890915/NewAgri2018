package com.sinosoft.agriprpall.web.proposalmanage;


import com.sinosoft.agriprpall.api.proposalmanage.CalPremiumApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumResponseDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.CalPremiumService;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = CalPremiumApi.PATH)
public class CalPremiumController implements CalPremiumApi{

    @Autowired
    private CalPremiumService calPremiumService;

    /**
     * 种植险、养殖险公用计算方法（点击币别确认时）
     * 1、flag为T02或Cal（养殖险与种植险不同）时，根据inusreListCode查询清单表,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     * @author: 田健
     * @date: 2017/12/20 20:47
     * @param calPremiumDto 计算费用请求入参：包含清单号、金禾清单号、险别、标的、总保额、费率、补贴比例等信息
     * @return CalPremiumResponseDto 计算返回信息
     * @throws Exception
     */
    @Override
    public CalPremiumResponseDto CurrencyEnsure(@RequestBody CalPremiumDto calPremiumDto)throws Exception{
        return calPremiumService.CurrencyEnsure(calPremiumDto);
    }

}
