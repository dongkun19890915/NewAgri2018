package com.sinosoft.fileserver.dao;

import java.util.List;

import com.sinosoft.fileserver.entity.TFileShortLink;
import com.sinosoft.fileserver.entity.TFileShortLinkExample;
import com.sinosoft.fileserver.entity.TFileShortLinkKey;
/**
 * @author codegen@研发中心
 * @mail weiyang@sinosoft.com.cn
 * @time  2016-10-06 18:53:43.125 
 * TFileShortLink-文件短链接表  数据操作接口类
 */
public interface TFileShortLinkMapper {
    //按照主键删除
    int deleteByPrimaryKey(TFileShortLinkKey key);
    //插入对象
    int insert(TFileShortLink record);
    //插入对象
    int insertSelective(TFileShortLink record);
    //系统封装查询
    List<TFileShortLink> selectByExample(TFileShortLinkExample example);
    //按主键查询
    TFileShortLink selectByPrimaryKey(TFileShortLinkKey key);
    //主键更新
    int updateByPrimaryKeySelective(TFileShortLink record);
    //主键更新
    int updateByPrimaryKey(TFileShortLink record);    
}