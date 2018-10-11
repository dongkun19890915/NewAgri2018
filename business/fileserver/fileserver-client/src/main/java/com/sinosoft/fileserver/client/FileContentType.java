package com.sinosoft.fileserver.client;

import java.util.HashMap;
import java.util.Map;
/**
 * 
* @description 文件类型对应
* @author 周建龙
* @date 2016年10月5日下午5:58:30
 */
public final class FileContentType {
	private static Map<String, String> contentType = new HashMap<String, String>();

	static {
		contentType.put("doc", "application/vnd.ms-word");
		contentType.put("ai", "application/postscript");
		contentType.put("aif", "audio/x-aiff");
		contentType.put("aifc", "audio/x-aiff");
		contentType.put("aiff", "audio/x-aiff");
		contentType.put("asc", "text/plain");
		contentType.put("au", "audio/basic");
		contentType.put("avi", "video/x-msvideo");
		contentType.put("bcpio", "application/x-bcpio");
		contentType.put("bin", "application/octet-stream");
		contentType.put("bmp", "image/bmp");
		contentType.put("cdf", "application/x-netcdf");
		contentType.put("cgm", "image/cgm");
		contentType.put("class", "application/octet-stream");
		contentType.put("cpio", "application/x-cpio");
		contentType.put("cpt", "application/mac-compactpro");
		contentType.put("csh", "application/x-csh");
		contentType.put("css", "text/css");
		contentType.put("dcr", "application/x-director");
		contentType.put("dir", "application/x-director");
		contentType.put("djv", "image/vnd.djvu");
		contentType.put("djvu", "image/vnd.djvu");
		contentType.put("dll", "application/octet-stream");
		contentType.put("dmg", "application/octet-stream");
		contentType.put("dms", "application/octet-stream");
		contentType.put("dtd", "application/xml-dtd");
		contentType.put("dvi", "application/x-dvi");
		contentType.put("dxr", "application/x-director");
		contentType.put("eps", "application/postscript");
		contentType.put("etx", "text/x-setext");
		contentType.put("exe", "application/octet-stream");
		contentType.put("ez", "application/andrew-inset");
		contentType.put("gif", "image/gif");
		contentType.put("gram", "application/srgs");
		contentType.put("grxml", "application/srgs+xml");
		contentType.put("gtar", "application/x-gtar");
		contentType.put("hdf", "application/x-hdf");
		contentType.put("hqx", "application/mac-binhex40");
		contentType.put("htm", "text/html");
		contentType.put("html", "text/html");
		contentType.put("ice", "x-conference/x-cooltalk");
		contentType.put("ico", "image/x-icon");
		contentType.put("ics", "text/calendar");
		contentType.put("ief", "image/ief");
		contentType.put("ifb", "text/calendar");
		contentType.put("iges", "model/iges");
		contentType.put("igs", "model/iges");
		contentType.put("jpe", "image/jpeg");
		contentType.put("jpeg", "image/jpeg");
		contentType.put("jpg", "image/jpeg");
		contentType.put("js", "application/x-javascript");
		contentType.put("kar", "audio/midi");
		contentType.put("latex", "application/x-latex");
		contentType.put("lha", "application/octet-stream");
		contentType.put("lzh", "application/octet-stream");
		contentType.put("m3u", "audio/x-mpegurl");
		contentType.put("m4u", "video/vnd.mpegurl");
		contentType.put("man", "application/x-troff-man");
		contentType.put("mathml", "application/mathml+xml");
		contentType.put("me", "application/x-troff-me");
		contentType.put("mesh", "model/mesh");
		contentType.put("mid", "audio/midi");
		contentType.put("midi", "audio/midi");
		contentType.put("mif", "application/vnd.mif");
		contentType.put("mov", "video/quicktime");
		contentType.put("movie", "video/x-sgi-movie");
		contentType.put("mp2", "audio/mpeg");
		contentType.put("mp3", "audio/mpeg");
		contentType.put("mpe", "video/mpeg");
		contentType.put("mpeg", "video/mpeg");
		contentType.put("mpg", "video/mpeg");
		contentType.put("mpga", "audio/mpeg");
		contentType.put("ms", "application/x-troff-ms");
		contentType.put("msh", "model/mesh");
		contentType.put("mxu", "video/vnd.mpegurl");
		contentType.put("nc", "application/x-netcdf");
		contentType.put("oda", "application/oda");
		contentType.put("ogg", "application/ogg");
		contentType.put("pbm", "image/x-portable-bitmap");
		contentType.put("pdb", "chemical/x-pdb");
		contentType.put("pdf", "application/pdf");
		contentType.put("pgm", "image/x-portable-graymap");
		contentType.put("pgn", "application/x-chess-pgn");
		contentType.put("png", "image/png");
		contentType.put("pnm", "image/x-portable-anymap");
		contentType.put("ppm", "image/x-portable-pixmap");
		contentType.put("ppt", "application/vnd.ms-powerpoint");
		contentType.put("ps", "application/postscript");
		contentType.put("qt", "video/quicktime\t");
		contentType.put("ra", "audio/x-pn-realaudio");
		contentType.put("ram", "audio/x-pn-realaudio");
		contentType.put("ras", "image/x-cmu-raster");
		contentType.put("rdf", "application/rdf+xml");
		contentType.put("rgb", "image/x-rgb");
		contentType.put("rm", "application/vnd.rn-realmedia");
		contentType.put("roff", "application/x-troff");
		contentType.put("rtx", "text/richtext");
		contentType.put("sgm", "text/sgml");
		contentType.put("sgml", "text/sgml");
		contentType.put("sh", "application/x-sh");
		contentType.put("shar", "application/x-shar");
		contentType.put("silo", "model/mesh");
		contentType.put("sit", "application/x-stuffit");
		contentType.put("skd", "application/x-koan");
		contentType.put("skm", "application/x-koan");
		contentType.put("skp", "application/x-koan");
		contentType.put("skt", "application/x-koan");
		contentType.put("smi", "application/smil");
		contentType.put("smil", "application/smil");
		contentType.put("snd", "audio/basic");
		contentType.put("so", "application/octet-stream");
		contentType.put("spl", "application/x-futuresplash");
		contentType.put("src", "application/x-wais-source");
		contentType.put("sv4cpio", "application/x-sv4cpio");
		contentType.put("svg", "image/svg+xml");
		contentType.put("swf", "application/x-shockwave-flash");
		contentType.put("t", "application/x-troff");
		contentType.put("tar", "application/x-tar");
		contentType.put("tcl", "application/x-tcl");
		contentType.put("tex", "application/x-tex");
		contentType.put("texi", "application/x-texinfo");
		contentType.put("texinfo", "application/x-texinfo");
		contentType.put("tif", "image/tiff");
		contentType.put("tiff", "image/tiff");
		contentType.put("tr", "application/x-troff");
		contentType.put("tsv", "text/tab-separated-values");
		contentType.put("txt", "text/plain");
		contentType.put("ustar", "application/x-ustar");
		contentType.put("vcd", "application/x-cdlink");
		contentType.put("vrml", "model/vrml");
		contentType.put("vxml", "application/voicexml+xml");
		contentType.put("wav", "audio/x-wav");
		contentType.put("wbxml", "application/vnd.wap.wbxml");
		contentType.put("wml", "text/vnd.wap.wml");
		contentType.put("wmlc", "application/vnd.wap.wmlc");
		contentType.put("wmls", "text/vnd.wap.wmlscript");
		contentType.put("wmlsc", "application/vnd.wap.wmlscriptc");
		contentType.put("wrl", "model/vrml");
		contentType.put("xbm", "image/x-xbitmap");
		contentType.put("xht", "application/xhtml+xml");
		contentType.put("xhtml", "application/xhtml+xml");
		contentType.put("xls", "application/vnd.ms-excel");
		contentType.put("xml", "application/xml");
		contentType.put("xpm", "image/x-xpixmap");
		contentType.put("xsl", "application/xml");
		contentType.put("xslt", "application/xslt+xml");
		contentType.put("xwd", "image/x-xwindowdump");
		contentType.put("xyz", "chemical/x-xyz");
		contentType.put("zip", "application/zip");
	}
	/**
	* @description 根据文件后缀找到对应的contentType
	* @param extend 后缀名
	* @return
	* @author 周建龙
	* @date 2016年10月5日下午3:06:56
	 */
	public static String getContentType(String extend) {
		if (extend == null) {
			extend = "";
		}
		String type = (String) contentType.get(extend.toLowerCase());
		if (type == null) {
			type = "application/octet-stream";
		}
		return type;
	}
}