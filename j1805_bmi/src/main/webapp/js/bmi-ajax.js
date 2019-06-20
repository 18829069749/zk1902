
function myAjax(method ,url,sync,data,succ,error){
//	1.1 创建xmlhttprequest对象
	var  xmlHttp;
	if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
//	1.2 设置回调函数 
	xmlHttp.onreadystatechange = function (){
		//alert("回调成功");
//		2
		if(xmlHttp.readyState==4&&xmlHttp.status==200){
			var jsonStr = xmlHttp.responseText;
             succ(jsonStr);//执行回调动作
			
		}else{
			error(xmlHttp.status);//执行错误时操作
		}
	}
//	1.3 设置访问路径
	//var url = "http://localhost:8088/bmiServlet?action=list";
	xmlHttp.open(method,url,sync);
//	1.4 发送请求
	xmlHttp.send(data);
}