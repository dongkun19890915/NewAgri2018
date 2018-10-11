package com.sinosoft.fileserver.dao;

import com.sinosoft.fileserver.entity.TFileInfo;
import com.sinosoft.fileserver.entity.TFileInfoExample;
import com.sinosoft.fileserver.entity.TFileInfoKey;
import java.util.List;
/**
 * @author codegen@研发中心
 * @mail zhoujianlong@sinosoft.com.cn
 * @time  2016-11-25 15:25:25.477 
 * TFileInfo  数据操作接口类
 */
public interface TFileInfoMapper {
    //按照主键删除
    int deleteByPrimaryKey(TFileInfoKey key);
    //插入对象
    int insert(TFileInfo record);
    //插入对象
    int insertSelective(TFileInfo record);
    //系统封装查询
    List<TFileInfo> selectByExample(TFileInfoExample example);
    //按主键查询
    TFileInfo selectByPrimaryKey(TFileInfoKey key);
    //主键更新
    int updateByPrimaryKeySelective(TFileInfo record);
    //主键更新
    int updateByPrimaryKey(TFileInfo record);
}