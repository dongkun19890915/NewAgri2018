/**
 * 自动回写token
 */
function autoSetCookieRemote() {
    var urls = fm.urls;
    var data=new Array()
    for(var i=0;i<urls.length;i++){
        data[i] = $.trim(urls[i].value);
	}
    setCookieRemote(data);
}