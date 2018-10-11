package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.AutoClauseApi;
import com.sinosoft.pms.api.kernel.dto.*;
import com.sinosoft.pms.core.kernel.service.AutoClauseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 自动特约接口服务controller
 * @author hrx
 * @date 2017年9月12
 */
@RestController
@RequestMapping(value = AutoClauseApi.PATH)
public class AutoClauseController implements AutoClauseApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoClauseController.class);

    @Autowired
    private AutoClauseService autoClauseService;

    /**
     * @description 新增自动特约
     * @param autoClauseRequestDto
     * @author hrx
     * @date 2017年9月13
     */
    @Override
    public String saveAutoClause (@RequestBody AutoClauseRequestDto autoClauseRequestDto) throws Exception {
        LOGGER.error("自动特约新增Controller");
        return autoClauseService.saveAutoClause(autoClauseRequestDto);
    }

    /**
     * @description 查询自动特约
     * @param autoClauseQueryConditionDto
     * @author hrx
     * @date 2017年9月18
     */
    @Override
    public PageInfo<PrpDautoClauseDto> queryAutoClause (@RequestBody AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception {
        LOGGER.error("自动特约查询Controller");
        try {
            return autoClauseService.queryAutoClause(autoClauseQueryConditionDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description 自动特约删除
     * @param autoClauseDeleteConditionDto
     * @author hrx
     * @date 2017年9月19
     */
    @Override
    public String deleteAutoClause (@RequestBody AutoClauseDeleteConditionDto autoClauseDeleteConditionDto) throws Exception {
        LOGGER.error("自动特约删除Controller");
        return autoClauseService.deleteAutoClause(autoClauseDeleteConditionDto);
    }

    /**
     * @description 自动特约修改
     * @param autoClauseQueryConditionDto
     * @author hrx
     * @date 2017年9月20
     */
    @Override
    public AutoClauseResponseDto updateAutoClause (@RequestBody AutoClauseQueryConditionDto autoClauseQueryConditionDto) throws Exception {
        LOGGER.error("自动特约修改Controller");
        return autoClauseService.updateAutoClause(autoClauseQueryConditionDto);
    }
}
