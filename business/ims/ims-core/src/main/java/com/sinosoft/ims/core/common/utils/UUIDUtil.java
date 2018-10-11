package com.sinosoft.ims.core.common.utils;

import java.util.UUID;

public class UUIDUtil {

	public static String createId(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id.replace("-", "");
	}


}
