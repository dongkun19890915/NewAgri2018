package com.sinosoft.framework.agri.core.utils;

import java.util.UUID;

public class UUIDUtil {

	public static String create32Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id.replace("-", "");
	}

	public static String create4Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		String[] ids = id.split("-");
		return ids[1];
	}

	public static String create8Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		String[] ids = id.split("-");
		return ids[0];
	}

	public static String create12Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		String[] ids = id.split("-");
		return ids[4];
	}
	public static String create16Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		String[] ids = id.split("-");
		return ids[4]+ids[3];
	}
	public static String create20Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		String[] ids = id.split("-");
		return ids[4]+ids[0];
	}
	public static String create24Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		String[] ids = id.split("-");
		return ids[4]+ids[0]+ids[1];
	}
	public static String create28Id(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		String[] ids = id.split("-");
		return ids[4]+ids[0]+ids[1]+ids[2];
	}


}
