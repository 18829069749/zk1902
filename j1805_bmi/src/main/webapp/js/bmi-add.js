

function error(msg){
	alert(msg);
}
  
  function displayRecord(datas){
	  alert(datas);
	  var data = JSON.parse(datas);
	  data = data[0];
	 
//		获取容器对象
		var tab = document.getElementById('table_history');
			var tr = document.createElement("tr");
			tr.id = data.id;//设置tr的id值 便于删除
			tr.className = "table_history_rsult";
			tr.innerHTML='<td>'
				+ data.id
				+ '</td>'
				+ '<td>'
				+ data.mydate
				+ '</td>'
				+ '<td>'
				+ data.height
				+ '</td>'
				+ '<td>'
				+ data.weight
				+ '</td>'
				+ '<td>'
				+ data.bmi
				+ '</td>'
				+ '<td>'
				+ '<input type="submit" value="删除" class="submit" onclick="deletes('
				+ data.id
				+')" />'
				+ '</td>' ;
			tab.appendChild(tr);//将tr追加到容器中	  
	  
	  
  }