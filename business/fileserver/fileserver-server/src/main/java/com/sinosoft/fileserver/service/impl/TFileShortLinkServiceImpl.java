package com.sinosoft.fileserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.fileserver.dao.TFileShortLinkMapper;
import com.sinosoft.fileserver.entity.TFileShortLink;
import com.sinosoft.fileserver.entity.TFileShortLinkKey;
import com.sinosoft.fileserver.service.TFileShortLinkService;

/**
* @description 文件短链接服务
* @author 周建龙
* @date 2016年10月20日上午9:20:53
*/

public class TFileShortLinkServiceImpl implements TFileShortLinkService {
	@Autowired
	private TFileShortLinkMapper tFileShortLinkMapper;
	/**
	* @description 根据文件id找到短链接信息
	* @param fileId 文件id
	* @return 短链接信息
	* @author 周建龙
	* @date 2016年10月5日下午3:02:50
	 */
	@Override
	public TFileShortLink queryTFileShortLinkByPk(String shortLinkId) {
		TFileShortLinkKey key=new TFileShortLinkKey();
		key.setShortLinkId(shortLinkId);
		return tFileShortLinkMapper.selectByPrimaryKey(key);
	}

	/**
	 * 
	* @description 保存短链接信息
	* @param tfileInfo 短链接息
	* @author 周建龙
	* @date 2016年10月5日下午3:04:00
	 */
	@Override
	public void save(TFileShortLink tFileShortLink) {
		tFileShortLinkMapper.insert(tFileShortLink);
	}

}
