window.onload = function(){
	
	//alert("hello!");
	/**
	 * 1、发出ajax请求；
	 * 2、对返回的结果进行解析；
	 * 3、遍历结果集，并构造新的dom对象，同时添加到容器中
	 */
//	1、
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
//			alert(jsonStr);
			var datas = JSON.parse(jsonStr);//解析json字符串为对象数组
//			获取容器对象
			var tab = document.getElementById('table_history');
			for(var i in datas){
//				alert(datas[i].id+','+datas[i].mydate);
				var tr = document.createElement("tr");
				tr.id = datas[i].id;//设置tr的id值 便于删除
				tr.className = "table_history_rsult";
				tr.innerHTML='<td>'
					+ datas[i].id
					+ '</td>'
					+ '<td>'
					+ datas[i].mydate
					+ '</td>'
					+ '<td>'
					+ datas[i].height
					+ '</td>'
					+ '<td>'
					+ datas[i].weight
					+ '</td>'
					+ '<td>'
					+ datas[i].bmi
					+ '</td>'
					+ '<td>'
					+ '<input type="submit" value="删除" class="submit" onclick="deletes('
					+ datas[i].id
					+')" />'
					+ '</td>' ;
				tab.appendChild(tr);//将tr追加到容器中
			}
			
		}
	}
//	1.3 设置访问路径
	var url = "http://localhost:8088/bmiServlet?action=list";
	xmlHttp.open("GET",url,true);
//	1.4 发送请求
	xmlHttp.send(null);
}