
function Cal(){
/**
 * 1、获取表单元素的值
 * 2、计算bmi
 */
//	1
	var h =  document.getElementById("height").value;
	var w =  document.getElementById("weight").value;
	var genders =  document.getElementsByName("sex");
	if(h == null || w == null || genders == null){
		alert("请输入完整信息！");
		return false;
	}
    var idea_weight = (h - 150) * 0.6 +50 ;
	h = h/100
	//alert(h);
	var bmi = Math.round( w / (h * h) * 100 ) / 100 ;
	
//	alert(bmi);
//	获取性别的id值
	var gender ;
	for(var i in genders){
		if(genders[i].checked){
			gender = genders[i].id;
		}
	}
	//获取需要更新的对象
	var bmi_result_photo = document.getElementById("bmi_result_photo");
	var bmi_result_value = document.getElementById("bmi_result_value");
	var bmi_result_idealweight = document.getElementById("bmi_result_idealweight");
	bmi_result_idealweight.innerText = idea_weight +'(kg)' ;
	if(gender=='male' ){//男
		
		if(bmi <=20.4 ){
			bmi_result_photo.src = "img/3_01.jpg";	
			bmi_result_value.innerText = bmi +' 偏瘦';
			bmi_result_value.style.background = 'rgb( 135, 206, 250)';
			bmi_result_idealweight.style.background = 'rgb( 135, 206, 250)';
		}else if(bmi >20.4 && bmi<= 25.9){
			bmi_result_photo.src = "img/3_02.jpg";
			bmi_result_value.innerText = bmi +'正常';
			bmi_result_value.style.background = 'rgb(180, 238, 180)';
			bmi_result_idealweight.style.background = 'rgb(180, 238, 180)';
		}
		else if(bmi >=26 && bmi<= 29.9){
			bmi_result_photo.src = "img/3_03.jpg";
			bmi_result_value.innerText = bmi +'肥胖';
			bmi_result_value.style.background = 'gold';
			bmi_result_idealweight.style.background = 'gold';
		}else if(bmi >=30 ){
			bmi_result_photo.src = "img/3_04.jpg";
			bmi_result_value.innerText = bmi +'超重';
			bmi_result_value.style.background = 'rgb(238, 99, 99)';
			bmi_result_idealweight.style.background = 'rgb(238, 99, 99)';
		}
		
	}else{//女
		
	}
	
	//将录入录入数据写入数据库中
	var mydate = new Date().getFullYear()+'-' +(new Date().getMonth()+1) ;
	alert(mydate);
	var sign  = new Date().getTime();
	alert(sign);
	var username = 'j1805';
	
	var url_add = 'http://localhost:8088/bmiServlet?action=add'
		        + '&h='+h
		        + '&w='+w
		        + '&bmi=' + bmi
		        + '&mydate=' + mydate
		        + '&sign=' + sign
		        + '&username='+username;
	alert(url_add);
	 myAjax("GET",url_add,true,null,displayRecord,error);
}