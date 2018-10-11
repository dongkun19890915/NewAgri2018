package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.QueryPApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = QueryPApi.PATH)
public class QueryPController implements QueryPApi{
    @Autowired
    private QueryPService queryPService;

    /**
     *  根据批单号查询出相应的Blendorse中的P表大对象
     * @param endorseNo 批单号
     * @return BlendorseDto(查出来的是所有的P表对象)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    @Override
    public BLEndorseDto queryP(String endorseNo) throws Exception {
        return queryPService.queryP(endorseNo);
    }
}
