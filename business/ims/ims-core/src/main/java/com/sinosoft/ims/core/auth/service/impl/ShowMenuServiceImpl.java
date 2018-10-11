package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.dto.*;
import com.sinosoft.ims.api.kernel.dto.RequestLoginDto;
import com.sinosoft.ims.core.auth.service.*;
import com.sinosoft.ims.core.kernel.service.UserLoginService;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.sysframework.common.Constants;
import java.util.*;

@Service
public class ShowMenuServiceImpl extends BaseServiceImpl implements ShowMenuService {

    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUserGradeTaskServiceImpl.class);

    public int countMenu = 0;
    @Autowired
    private UtiMenuService utiMenuService;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private UtiUserGradeService utiUserGradeService;
    @Autowired
    private UtiUserGradeTaskService utiUserGradeTaskService;
    @Autowired
    private UtiGradeTaskService utiGradeTaskService;
    @Autowired
    private UtiUserGradePowerService utiUserGradePowerService;
    @Autowired
    private UserLoginService userLoginService;

    /**
     * 根据comCode、userCode、systemCode、generateCheckPower返回用户权限菜单信息
     * @param requestLoginDto 请求参数dto
     * @param generateCheckPower 是否需要补充CheckPower()方法所需的入参
     * @return MenuTreeDto集合
     * @throws Exception
     */
    @Override
    public List<MenuTreeDto> queryUserMenu(RequestLoginDto requestLoginDto,boolean generateCheckPower) throws Exception{
        String comCode = requestLoginDto.getLoginComCode();
        String userCode = requestLoginDto.getUserCode();
        String systemCode = requestLoginDto.getSystemCode();
        if(comCode == null || comCode.equals("")){
            throw new DataVerifyException("机构代码不能为空！");
        }
        if(userCode == null || userCode.equals("")){
            throw new DataVerifyException("用户代码不能为空！");
        }
        if(systemCode == null || systemCode.equals("")){
            throw new DataVerifyException("系统代码不能为空！");
        }

        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();
        //查询用户权限菜单
        List<UtiMenuDto> nyxMenuList = this.queryNYXMenuList(requestLoginDto,generateCheckPower);
        if(nyxMenuList != null && nyxMenuList.size() > 0) {//该用户有权限菜单
            for (Iterator nyxMenuIter = nyxMenuList.iterator(); nyxMenuIter.hasNext(); ) {
                UtiMenuDto utiMenuDto = (UtiMenuDto) nyxMenuIter.next();
                if(utiMenuDto.getMenuLevel() == 1){//查询一级菜单
                    utiMenuDto.setMenuCName(utiMenuDto.getMenuCName().trim());//去空格
                    MenuTreeDto menuTreeDto = new MenuTreeDto();
                    menuTreeDto.setUtiMenuDto(utiMenuDto);
                    //获取子集菜单
                    List<MenuTreeDto> menuTreeChildList = getMenuChild(utiMenuDto.getMenuId(),nyxMenuList);
                    menuTreeDto.setChildMenuList(menuTreeChildList);
                    menuTreeDtoList.add(menuTreeDto);
                }
            }
        }
        return menuTreeDtoList;
    }

    /**
     * 查询下级菜单
     * @param nyxMenuList 用户权限菜单
     * @return 下级菜单
     * @throws Exception
     */
    public List<MenuTreeDto> getMenuChild(String upperMenuId,List<UtiMenuDto> nyxMenuList) throws Exception{
        List<MenuTreeDto> menuTreeChildList = new ArrayList<>();
        //查询子菜单
        List<UtiMenuDto> utiMenuChildList = new ArrayList<>();
        for (Iterator nyxMenuIter = nyxMenuList.iterator(); nyxMenuIter.hasNext(); ) {
            UtiMenuDto utiMenuDto = (UtiMenuDto) nyxMenuIter.next();
            if(utiMenuDto.getUpperMenuId().equals(upperMenuId)){
                utiMenuDto.setMenuCName(utiMenuDto.getMenuCName().trim());//去空格
                MenuTreeDto menuTreeDto = new MenuTreeDto();
                menuTreeDto.setUtiMenuDto(utiMenuDto);
                menuTreeDto.setChildMenuList(getMenuChild(utiMenuDto.getMenuId(),nyxMenuList));
                menuTreeChildList.add(menuTreeDto);
            }
        }
        return menuTreeChildList;
    }


    /**
     *  查询农业险的菜单menuId
     * @author: ldd
     * @date: 2017/11/16 11:09
     * @return 菜单menuId的map
     */
    public List<UtiMenuDto> queryNYXMenuList(RequestLoginDto requestLoginDto,boolean generateCheckPower) throws Exception{
        String comCode = requestLoginDto.getLoginComCode();
        String userCode = requestLoginDto.getUserCode();
        String systemCode = requestLoginDto.getSystemCode();
        //清空taskCode,防止queryLoginInfo时的systemCode影响判断
        requestLoginDto.setTaskCode("");
        //如果需要补充参数
        if(generateCheckPower) {
            requestLoginDto = generateCheckPowerConditon(requestLoginDto);
        }

        List<PrpDriskDto> prpDriskDtoList = (List<PrpDriskDto>)requestLoginDto.getPrpDriskDtoList();

        List<UtiMenuDto> nyxMenuList = new ArrayList<>();
        List<UtiMenuDto> utiMenuDtoList = utiMenuService.queryAllBySystemCode(systemCode);
        for(UtiMenuDto utiMenuDto : utiMenuDtoList){
            //带险种的菜单需判断菜单的险种范围
            String permitRiskClass = utiMenuDto.getPermitRiskClass();// 允许险类
            String exceptRiskCode = utiMenuDto.getExceptRiskCode();// 允许险类除外险种
            String exceptRiskClass = utiMenuDto.getExceptRiskClass();// 禁止险类
            String permitRiskCode = utiMenuDto.getPermitRiskCode();// 禁止险类除外险种
            //判断用户菜单是否有执行权限
            boolean ifCheckPower = false;
            requestLoginDto.setTaskCode(utiMenuDto.getTaskCode());
            for(PrpDriskDto prpDriskDto : prpDriskDtoList){
                //判断用户菜单是否有执行权限
                ifCheckPower = checkPower(requestLoginDto);
                if(ifCheckPower) {
                    // 如果禁止险类范围有值，则表示使用险种选项
                    if (exceptRiskClass != null && !exceptRiskClass.equals("")) {
                        // 校验当前的险类在禁止险类范围内存在，且险种在禁止险类除外险种范围类则允许显示
                        if (((exceptRiskClass + ",").indexOf(prpDriskDto.getClassCode()) > -1) &&
                                ((permitRiskCode + ",").indexOf(prpDriskDto.getRiskCode()) > -1)) {
                            //只要有一个农险的险种允许显示菜单就可以
                            nyxMenuList.add(utiMenuDto);
                            break;

                        }
                    } else if (permitRiskClass != null && !permitRiskClass.equals("")) {
                        // 校验当前的险类在允许险类范围存在,险种不在允许险类除外险种范围内则则允许显示
                        if (((permitRiskClass + ",").indexOf(prpDriskDto.getClassCode()) > -1) &&
                                ((exceptRiskCode + ",").indexOf(prpDriskDto.getRiskCode()) == -1)) {
                            nyxMenuList.add(utiMenuDto);
                            break;
                        }
                    } else {
                        nyxMenuList.add(utiMenuDto);
                        break;
                    }
                }
            }
            LOGGER.debug("ifCheckPower=="+ifCheckPower+"==comCode=="+comCode+"==userCode=="+userCode+"==MenuId=="+utiMenuDto.getMenuId()+"==MenuCName=="+utiMenuDto.getMenuCName() +"==utiMenuDto.getTaskCode()=="+utiMenuDto.getTaskCode());
        }

        return nyxMenuList;
    }

    /**
     *  用户对当前菜单是否存在操作权限(如果是用户代码全部为0，且长度大于等于8位，则有所有执行权限）
     * @author: ldd
     * @date: 2017/11/16 10:22
     * @param utiMenuDto
     * @return 存在返回true,否则返回false
     * @throws Exception
     */
    public boolean hasExecutePermission(UtiMenuDto utiMenuDto,HashMap nyxMenuIdMap) throws Exception{
        // 没有配置功能代码则无权显示
        if (utiMenuDto.getTaskCode() ==null || utiMenuDto.getTaskCode().trim().equals("")) {
            return false;
        }

        if(nyxMenuIdMap.containsKey(utiMenuDto.getMenuId())){
            return true;
        }
        return false;
    }

    /**
     * 补充CheckPower()方法所需的入参
     * @author: 李东东
     * @param requestLoginDto 请求参数集合
     * @return 补充完参数的RequestLoginDto集合
     * @throws Exception
     */
    @Override
    public RequestLoginDto generateCheckPowerConditon(RequestLoginDto requestLoginDto) throws Exception{
        String comCode = requestLoginDto.getLoginComCode();
        String userCode = requestLoginDto.getUserCode();
        String systemCode = requestLoginDto.getSystemCode();
        //是否超级用户
        requestLoginDto.setIfSuperUser(userLoginService.isSuperUser(comCode, userCode));
        //农险险类
        List<String> classCodeList = new ArrayList<>();
        classCodeList.add("31");//种植
        classCodeList.add("32");//养殖
        requestLoginDto.setClassCodeList(classCodeList);//加入requestLoginDto
        Map<String,String> map;
        List<PrpDriskDto> prpDriskDtoList = new ArrayList<>();
        for(String classCode : classCodeList) {
            map=new HashMap<>();
            map.put("classCode",classCode);
            List<PrpDriskDto> prpDriskDtoList2 = prpDriskApi.queryRiskCodeInfo(map);
            for(PrpDriskDto prpDriskDto2 : prpDriskDtoList2){
                prpDriskDtoList.add(prpDriskDto2);
            }
        }
        requestLoginDto.setPrpDriskDtoList(prpDriskDtoList);//加入requestLoginDto

        //为了避免过多得与数据库交互，下面Collection作为校验用户菜单权限方法入参
//        List<UtiUserGradeDto> utiUserGradeDtoList = utiUserGradeService.queryAllByConditon(comCode,userCode);
//        requestLoginDto.setUtiUserGradeDtoList(utiUserGradeDtoList);//加入requestLoginDto
//        List<UtiUserGradeTaskDto> utiUserGradeTaskDtoList = utiUserGradeTaskService.queryAllByCondition(comCode,userCode);
//        HashMap utiUserGradeTaskMap = new HashMap();
//        加入utiUserGradeTaskMap里方便取值
//        if(utiUserGradeTaskDtoList != null && utiUserGradeTaskDtoList.size() > 0){
//            for(Iterator utiUserGradeTaskIter = utiUserGradeDtoList.iterator(); utiUserGradeTaskIter.hasNext();){
//                UtiUserGradeTaskDto utiUserGradeTaskDto = (UtiUserGradeTaskDto)utiUserGradeTaskIter.next();
//                //加入map
//                utiUserGradeTaskMap.put(utiUserGradeTaskDto.getGradeCode()+"-"+utiUserGradeTaskDto.getTaskCode(),utiUserGradeTaskDto.getValue());
//            }
//        }
//        requestLoginDto.setUtiUserGradeTaskMap(utiUserGradeTaskMap);//加入requestLoginDto
//
//        Collection utiGradeTaskDtoList = utiGradeTaskService.queryAllBySystemCode(systemCode);
//        HashMap utiGradeTaskMap = new HashMap();
//        //加入utiGradeTaskMap里方便取值
//        if(utiGradeTaskDtoList != null && utiGradeTaskDtoList.size() > 0){
//            for(Iterator utiGradeTaskIter = utiGradeTaskDtoList.iterator(); utiGradeTaskIter.hasNext();){
//                UtiGradeTaskDto utiGradeTaskDto = (UtiGradeTaskDto)utiGradeTaskIter.next();
//                //加入map
//                utiUserGradeTaskMap.put(utiGradeTaskDto.getGradeCode()+"-"+utiGradeTaskDto.getTaskCode(),utiGradeTaskDto.getValue());
//            }
//        }
//        requestLoginDto.setUtiGradeTaskMap(utiGradeTaskMap);//加入requestLoginDto
//        Collection utiUserGradePowerDtoList = utiUserGradePowerService.queryAllByCondition(comCode,userCode);
//        requestLoginDto.setUtiUserGradePowerDtoList(utiUserGradePowerDtoList);//加入requestLoginDto
        //-----------------
//        List<PrpDriskDto> prpDriskDtoList = (List<PrpDriskDto>) requestLoginDto.getPrpDriskDtoList();
//        Collection utiUserGradeDtoList = utiUserGradeService.queryAllByConditon(comCode, userCode);
//        // 对所有的机构员工岗位进行顺序处理
//        for (Iterator iter = utiUserGradeDtoList.iterator(); iter.hasNext(); ) {
//            UtiUserGradeDto utiUserGradeDto = (UtiUserGradeDto) iter.next();
//            boolean value = false;
//            // 如果机构员工岗位差异功能权限中有值，则为机构员工岗位差异功能权限的值，否则为机构员工岗位的岗位权限值，如果再没有则为false
//            UtiUserGradeTaskDto utiUserGradeTaskDto = utiUserGradeTaskService.queryByPK(utiUserGradeDto.getComCode(),
//                    utiUserGradeDto.getUserCode(), utiUserGradeDto.getGradeCode(), taskCode);
//            if (utiUserGradeTaskDto != null) {
//                value = DataUtils.getBoolean(utiUserGradeTaskDto.getValue());
//            } else {
//                UtiGradeTaskDto utiGradeTaskDto = utiGradeTaskService.queryByPK(utiUserGradeDto.getGradeCode(), taskCode);
//                if (utiGradeTaskDto != null) {
//                    value = DataUtils.getBoolean(utiGradeTaskDto.getValue());
//                } else {
//                    value = false;
//                }
//            }
//            if (value == true) {
//                if (hasRiskCode) {
//                    Collection utiUserGradePowers = utiUserGradePowerService.queryAllByCondition(comCode, userCode);
//                    for (Iterator iterator = utiUserGradePowers.iterator(); iterator.hasNext(); ) {
//                        UtiUserGradePowerDto utiUserGradePowerDto = (UtiUserGradePowerDto) iterator.next();
//                        String permitRiskCode = utiUserGradePowerDto.getPermitRiskCode();
//                        // 允许操作的险种为*或包含传入险种即返回true
//                        for (PrpDriskDto prpDriskDto : prpDriskDtoList) {
//                            if (permitRiskCode.equals("*") || permitRiskCode.endsWith(prpDriskDto.getRiskCode())
//                                    || permitRiskCode.indexOf(prpDriskDto.getRiskCode() + ",") > -1) {
//                                return true;
//                            }
//                        }
//                    }
//                } else { // 不含险种时直接返回true
//                    return true;
//                }
//            }
//        }
        //-------------------------改写他的方法--------------------------------------------------
//        //为了避免过多得与数据库交互，下面Collection作为校验用户菜单权限方法入参
        List<UtiUserGradeDto> utiUserGradeDtoList = utiUserGradeService.queryAllByConditon(comCode,userCode);
        requestLoginDto.setUtiUserGradeDtoList(utiUserGradeDtoList);//加入requestLoginDto
        Map<String,UtiUserGradeTaskDto> utiUserGradeTaskDtoMap = new HashMap<>();
        Map<String,UtiGradeTaskDto> utiGradeTaskDtoMap = new HashMap<>();
        String utiUserGradeTaskDtoMapKey = "";
        String utiGradeTaskDtoMapKey = "";
        for(UtiUserGradeDto utiUserGradeDto :utiUserGradeDtoList){
            // 如果机构员工岗位差异功能权限中有值，则为机构员工岗位差异功能权限的值，否则为机构员工岗位的岗位权限值
            //此时岗位未获取到，根据其他3个条件进行查询出一个集合，将集合放进map中根据机构、员工代码、岗位代码、功能代码
            List<UtiUserGradeTaskDto> utiUserGradeTaskDtoList = utiUserGradeTaskService.queryUtiUserGradeTaskDtoByCondition(utiUserGradeDto.getComCode(),
                    utiUserGradeDto.getUserCode(), utiUserGradeDto.getGradeCode());
            for(UtiUserGradeTaskDto utiUserGradeTaskDto:utiUserGradeTaskDtoList){
                //utiUserGradeTaskDto key值
                utiUserGradeTaskDtoMapKey = utiUserGradeTaskDto.getComCode()+utiUserGradeTaskDto.getUserCode()+utiUserGradeTaskDto.getGradeCode()+utiUserGradeTaskDto.getTaskCode();
                //put utiUserGradeTaskDto值
                utiUserGradeTaskDtoMap.put(utiUserGradeTaskDtoMapKey,utiUserGradeTaskDto);
            }

            List<UtiGradeTaskDto> utiGradeTaskDtoList = utiGradeTaskService.queryAllByGradeCode(utiUserGradeDto.getGradeCode());
            for(UtiGradeTaskDto utiGradeTaskDto:utiGradeTaskDtoList){
                // utiGradeTaskDto key值
                utiGradeTaskDtoMapKey = utiUserGradeDto.getGradeCode()+utiGradeTaskDto.getTaskCode();
                //put utiGradeTaskDto值
                utiGradeTaskDtoMap.put(utiGradeTaskDtoMapKey,utiGradeTaskDto);
            }
        }
        requestLoginDto.setUtiUserGradeTaskDtoMap(utiUserGradeTaskDtoMap);//加入requestLoginDto
        requestLoginDto.setUtiGradeTaskDtoMap(utiGradeTaskDtoMap);
        List<UtiUserGradePowerDto> utiUserGradePowerDtoList = utiUserGradePowerService.queryAllByCondition(comCode,userCode);
        requestLoginDto.setUtiUserGradePowerDtoList(utiUserGradePowerDtoList);//加入requestLoginDto
        //超级用户task
        HashMap taskMap = new HashMap();
        taskMap.put(Constants.TASK_PLATFORM,"TASK_PLATFORM");
        taskMap.put(Constants.TASK_COMPANY_QUERY,"TASK_COMPANY_QUERY");
        taskMap.put(Constants.TASK_MENU,"TASK_MENU");
        taskMap.put(Constants.TASK_MENU_CONFIG,"TASK_MENU_CONFIG");
        taskMap.put(Constants.TASK_POWER,"TASK_POWER");
        taskMap.put(Constants.TASK_POWER_GRADE,"TASK_POWER_GRADE");
        taskMap.put(Constants.TASK_POWER_GRADE_DELETE,"TASK_POWER_GRADE_DELETE");
        taskMap.put(Constants.TASK_POWER_GRADE_INSERT,"TASK_POWER_GRADE_INSERT");
        taskMap.put(Constants.TASK_POWER_GRADE_QUERY,"TASK_POWER_GRADE_QUERY");
        taskMap.put(Constants.TASK_POWER_GRADE_UPDATE,"TASK_POWER_GRADE_UPDATE");
        taskMap.put(Constants.TASK_POWER_USERGRADE,"TASK_POWER_USERGRADE");
        taskMap.put(Constants.TASK_POWER_USERGRADE_DELETE,"TASK_POWER_USERGRADE_DELETE");
        taskMap.put(Constants.TASK_POWER_USERGRADE_INSERT,"TASK_POWER_USERGRADE_INSERT");
        taskMap.put(Constants.TASK_POWER_USERGRADE_QUERY,"TASK_POWER_USERGRADE_QUERY");
        taskMap.put(Constants.TASK_POWER_USERGRADE_QUERYGRADE_CONFIGPOWER,"TASK_POWER_USERGRADE_QUERYGRADE_CONFIGPOWER");
        taskMap.put(Constants.TASK_POWER_USERGRADE_QUERYGRADE_CONFIGTASK,"TASK_POWER_USERGRADE_QUERYGRADE_CONFIGTASK");
        taskMap.put(Constants.TASK_POWER_USERGRADE_QUERYGRADE_DELETE,"TASK_POWER_USERGRADE_QUERYGRADE_DELETE");
        taskMap.put(Constants.TASK_POWER_USERGRADE_QUERYGRADE_INSERT,"TASK_POWER_USERGRADE_QUERYGRADE_INSERT");
        requestLoginDto.setTaskMap(taskMap);

        return requestLoginDto;
    }

    /**
     *  判断某个菜单是否有权执行
     * @author: 李东东
     * @date: 2017/11/16 14:26
     * @param requestLoginDto 登录请求dto
     * @return 判断某个菜单是否有权执行
     */
    @Override
    public boolean checkPower(RequestLoginDto requestLoginDto) throws Exception{
        String comCode =  requestLoginDto.getLoginComCode();
        String userCode = requestLoginDto.getUserCode();
        String taskCode = requestLoginDto.getTaskCode();
        boolean ifSuperUser = requestLoginDto.isIfSuperUser();
        if(comCode == null || comCode.equals("")){
            throw new DataVerifyException("机构代码不能为空！");
        }
        if(userCode == null || userCode.equals("")){
            throw new DataVerifyException("用户代码不能为空！");
        }
        if(taskCode == null || taskCode.equals("")){
            throw new DataVerifyException("菜单任务代码不能为空！");
        }
//        Collection utiUserGradeDtoList = requestLoginDto.getUtiUserGradeDtoList();
//        HashMap utiUserGradeTaskMap = requestLoginDto.getUtiUserGradeTaskMap();
//        HashMap utiGradeTaskMap = requestLoginDto.getUtiGradeTaskMap();
//        Collection utiUserGradePowerDtoList = requestLoginDto.getUtiUserGradePowerDtoList();
//        List<PrpDriskDto> prpDriskDtoList = (List<PrpDriskDto>)requestLoginDto.getPrpDriskDtoList();
//        boolean hasRiskCode = requestLoginDto.isHasRiskCode();

        if (ifSuperUser) {
            // POWER:超级用户具有权限管理功能的权限
            if (taskCode == Constants.TASK_PLATFORM || taskCode == Constants.TASK_COMPANY_QUERY
                    || taskCode == Constants.TASK_MENU || taskCode == Constants.TASK_MENU_CONFIG
                    || taskCode == Constants.TASK_POWER || taskCode == Constants.TASK_POWER_GRADE
                    || taskCode == Constants.TASK_POWER_GRADE_DELETE || taskCode == Constants.TASK_POWER_GRADE_INSERT
                    || taskCode == Constants.TASK_POWER_GRADE_QUERY || taskCode == Constants.TASK_POWER_GRADE_UPDATE
                    || taskCode == Constants.TASK_POWER_USERGRADE || taskCode == Constants.TASK_POWER_USERGRADE_DELETE
                    || taskCode == Constants.TASK_POWER_USERGRADE_INSERT
                    || taskCode == Constants.TASK_POWER_USERGRADE_QUERY
                    || taskCode == Constants.TASK_POWER_USERGRADE_QUERYGRADE_CONFIGPOWER
                    || taskCode == Constants.TASK_POWER_USERGRADE_QUERYGRADE_CONFIGTASK
                    || taskCode == Constants.TASK_POWER_USERGRADE_QUERYGRADE_DELETE
                    || taskCode == Constants.TASK_POWER_USERGRADE_QUERYGRADE_INSERT) {
                return true;
            }
        }
        // 对所有的机构员工岗位进行顺序处理
//        for (Iterator iter = utiUserGradeDtoList.iterator(); iter.hasNext();) {
//            UtiUserGradeDto utiUserGradeDto = (UtiUserGradeDto) iter.next();
//            String gradeTaskKey = utiUserGradeDto.getGradeCode() + "-" + taskCode;
//            boolean value = false;
//            boolean hasUtiUserGradeTask = false;
//            // 如果机构员工岗位差异功能权限中有值，则为机构员工岗位差异功能权限的值，否则为机构员工岗位的岗位权限值，如果再没有则为false
//            if(utiUserGradeTaskMap != null && utiUserGradeTaskMap.size() > 0){
//                if(utiUserGradeTaskMap.containsKey(gradeTaskKey)){
//                   //value = utiUserGradeTaskMap.get(gradeTaskKey).equals("1")?true:false;
//                    value = DataUtils.getBoolean((String)utiUserGradeTaskMap.get(gradeTaskKey));
//                    hasUtiUserGradeTask = true;//根据utiUserGradeTaskKey能否查找到utiUserGrade表信息
//
//                }
//            }
//            //如果不能根据ComCode、UserCode、GradeCode、TaskCode查到utiUserGradeTask表中数据
//            boolean hasUtiGradeTask = false;
//            if(hasUtiUserGradeTask == false){
//                if(utiGradeTaskMap != null && utiGradeTaskMap.size() > 0){
//                    if(utiGradeTaskMap.containsKey(gradeTaskKey)){
//                        //value = utiGradeTaskMap.get(gradeTaskKey).equals("1")?true:false;
//                        value = DataUtils.getBoolean((String)utiGradeTaskMap.get(gradeTaskKey));
//                        hasUtiGradeTask = true;
//                    }
//                }
//                if(hasUtiGradeTask == false){
//                    value = false;
//                }
//            }
//            if (value == true) {
//                if (hasRiskCode) {
//                    for (Iterator iterator = utiUserGradePowerDtoList.iterator(); iterator.hasNext();) {
//                        UtiUserGradePowerDto utiUserGradePowerDto = (UtiUserGradePowerDto) iterator.next();
//                        if(utiUserGradePowerDto.getGradeCode().equals(utiUserGradeDto.getGradeCode())) {
//                            String permitRiskCode = utiUserGradePowerDto.getPermitRiskCode();
//                            // 允许操作的险种为*或包含传入险种即返回true
//                            for (PrpDriskDto prpDriskDto : prpDriskDtoList) {
//                                if (permitRiskCode.equals("*") || permitRiskCode.endsWith(prpDriskDto.getRiskCode())
//                                        || permitRiskCode.indexOf(prpDriskDto.getRiskCode() + ",") > -1) {
//                                    return true;
//                                }
//                            }
//                        }
//                    }
//                } else { // 不含险种时直接返回true
//                    return true;
//                }
//            }
//        }

        // 如果配置了检查类则调用检查类的方法来作最后的处理 utiMenuDto.getCheckClass() 目前只有特殊因子有，暂不写
        //-------------------------------------按老系统重新改造------------------------------------
//        boolean hasRiskCode = requestLoginDto.isHasRiskCode();
//        List<PrpDriskDto> prpDriskDtoList = (List<PrpDriskDto>) requestLoginDto.getPrpDriskDtoList();
//        Collection utiUserGradeDtoList = utiUserGradeService.queryAllByConditon(comCode, userCode);
//        // 对所有的机构员工岗位进行顺序处理
//        for (Iterator iter = utiUserGradeDtoList.iterator(); iter.hasNext(); ) {
//            UtiUserGradeDto utiUserGradeDto = (UtiUserGradeDto) iter.next();
//            boolean value = false;
//            // 如果机构员工岗位差异功能权限中有值，则为机构员工岗位差异功能权限的值，否则为机构员工岗位的岗位权限值，如果再没有则为false
//            UtiUserGradeTaskDto utiUserGradeTaskDto = utiUserGradeTaskService.queryByPK(utiUserGradeDto.getComCode(),
//                    utiUserGradeDto.getUserCode(), utiUserGradeDto.getGradeCode(), taskCode);
//            if (utiUserGradeTaskDto != null) {
//                value = DataUtils.getBoolean(utiUserGradeTaskDto.getValue());
//            } else {
//                UtiGradeTaskDto utiGradeTaskDto = utiGradeTaskService.queryByPK(utiUserGradeDto.getGradeCode(), taskCode);
//                if (utiGradeTaskDto != null) {
//                    value = DataUtils.getBoolean(utiGradeTaskDto.getValue());
//                } else {
//                    value = false;
//                }
//            }
//            if (value == true) {
//                if (hasRiskCode) {
//                    Collection utiUserGradePowers = utiUserGradePowerService.queryAllByCondition(comCode, userCode);
//                    for (Iterator iterator = utiUserGradePowers.iterator(); iterator.hasNext(); ) {
//                        UtiUserGradePowerDto utiUserGradePowerDto = (UtiUserGradePowerDto) iterator.next();
//                        String permitRiskCode = utiUserGradePowerDto.getPermitRiskCode();
//                        // 允许操作的险种为*或包含传入险种即返回true
//                        for (PrpDriskDto prpDriskDto : prpDriskDtoList) {
//                            if (permitRiskCode.equals("*") || permitRiskCode.endsWith(prpDriskDto.getRiskCode())
//                                    || permitRiskCode.indexOf(prpDriskDto.getRiskCode() + ",") > -1) {
//                                return true;
//                            }
//                        }
//                    }
//                } else { // 不含险种时直接返回true
//                    return true;
//                }
//            }
//        }
        List<UtiUserGradeDto> utiUserGradeDtoList = requestLoginDto.getUtiUserGradeDtoList();
        Map<String,UtiUserGradeTaskDto> utiUserGradeTaskDtoMap = requestLoginDto.getUtiUserGradeTaskDtoMap();
        UtiUserGradeTaskDto utiUserGradeTaskDto = new UtiUserGradeTaskDto();
        Map<String,UtiGradeTaskDto> utiGradeTaskDtoMap = requestLoginDto.getUtiGradeTaskDtoMap();
        UtiGradeTaskDto utiGradeTaskDto = new UtiGradeTaskDto();
        List<UtiUserGradePowerDto> utiUserGradePowerDtoList = requestLoginDto.getUtiUserGradePowerDtoList();
        List<PrpDriskDto> prpDriskDtoList = (List<PrpDriskDto>)requestLoginDto.getPrpDriskDtoList();
        boolean hasRiskCode = requestLoginDto.isHasRiskCode();
        String utiUserGradeTaskDtoMapKey ="";
        String utiGradeTaskDtoMapKey = "";
        for(UtiUserGradeDto utiUserGradeDto:utiUserGradeDtoList){
            boolean value = false;
            //utiUserGradeTaskDto key值
            utiUserGradeTaskDtoMapKey = utiUserGradeDto.getComCode()+utiUserGradeDto.getUserCode()+utiUserGradeDto.getGradeCode()+taskCode;
            utiUserGradeTaskDto = utiUserGradeTaskDtoMap.get(utiUserGradeTaskDtoMapKey);
            if (utiUserGradeTaskDto != null) {
                value = DataUtils.getBoolean(utiUserGradeTaskDto.getValue());
            } else {
                // utiGradeTaskDto key值
                utiGradeTaskDtoMapKey = utiUserGradeDto.getGradeCode()+taskCode;
                 utiGradeTaskDto = utiGradeTaskDtoMap.get(utiGradeTaskDtoMapKey);
                if (utiGradeTaskDto != null) {
                    value = DataUtils.getBoolean(utiGradeTaskDto.getValue());
                } else {
                    value = false;
                }
            }
            if (value == true) {
                if (hasRiskCode) {
                    for (UtiUserGradePowerDto utiUserGradePowerDto:utiUserGradePowerDtoList) {
                        String permitRiskCode = utiUserGradePowerDto.getPermitRiskCode();
                        // 允许操作的险种为*或包含传入险种即返回true
                        for (PrpDriskDto prpDriskDto : prpDriskDtoList) {
                            if (permitRiskCode.equals("*") || permitRiskCode.endsWith(prpDriskDto.getRiskCode())
                                    || permitRiskCode.indexOf(prpDriskDto.getRiskCode() + ",") > -1) {
                                return true;
                            }
                        }
                    }
                } else { // 不含险种时直接返回true
                    return true;
                }
            }
        }
        return false;
    }
}
