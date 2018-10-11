/**
 * 
 */
package com.sinosoft.fileserver.service;

import com.sinosoft.fileserver.entity.TFileShortLink;

/**
* @description 短链接服务
* @author 周建龙
* @date 2016年10月20日上午9:19:50
*/

public interface TFileShortLinkService {
	/**
	* @description 根据文件id找到短链接信息
	* @param fileId 文件id
	* @return 短链接信息
	* @author 周建龙
	* @date 2016年10月5日下午3:02:50
	 */
	public TFileShortLink queryTFileShortLinkByPk(String shortLinkId);
	/**
	 * 
	* @description 保存短链接信息
	* @param tFileShortLink 短链接信息
	* @author 周建龙
	* @date 2016年10月5日下午3:04:00
	 */
	public void save(TFileShortLink tFileShortLink);
}
