<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>保单添加</title>
			<!-- Bootstrap -->
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

	<link href="../../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	
    
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
		<!-- jQuery -->
     <script src="../../../src/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="../../js/WarrantyInfo/addWarranty.js"></script>
	</head>
	<script type="text/javascript">
	//省份城市二级联动
	  var cityList = new Array();//创建数组
	  cityList['北京市'] = ['朝阳区','东城区','西城区', '海淀区','宣武区','丰台区','怀柔','延庆','房山'];
	  cityList['上海市'] = ['宝山区','长宁区','丰贤区', '虹口区','黄浦区','青浦区','南汇区','徐汇区','卢湾区'];
	  cityList['广东省'] = ['广州市','惠州市','汕头市','珠海市','佛山市','中山市','东莞市'];
	  cityList['深圳市'] = ['福田区', '罗湖区', '盐田区', '宝安区', '龙岗区', '南山区', '深圳周边'];
	  cityList['重庆市'] = ['俞中区', '南岸区', '江北区', '沙坪坝区', '九龙坡区', '渝北区', '大渡口区', '北碚区'];
	  cityList['天津市'] = ['和平区', '河西区', '南开区', '河北区', '河东区', '红桥区', '塘古区', '开发区'];
	  cityList['江苏省'] = ['南京市','苏州市','无锡市'];
	  cityList['浙江省'] = ['杭州市','宁波市','温州市'];
	  cityList['四川省'] = ['成都市','宜宾市'];
	  cityList['海南省'] = ['海口市'];
	  cityList['福建省'] = ['福州市','厦门市','泉州市','漳州市'];
	  cityList['山东省'] = ['济南市','青岛市','烟台市'];
	  cityList['江西省'] = ['南昌市','丰城市','新余市'];
	  cityList['广西省'] = ['柳州市','南宁市'];
	  cityList['安徽省'] = ['合肥市'];
	  cityList['河北省'] = ['邯郸市','石家庄市'];
	  cityList['河南省'] = ['郑州市','洛阳市'];
	  cityList['湖北省'] = ['武汉市','宜昌市'];
	  cityList['湖南省'] = ['长沙市','株洲市','湘潭市','衡阳市','怀化市'];
	  cityList['陕西省'] = ['西安市'];
	  cityList['山西省'] = ['太原市'];
	  cityList['黑龙江省'] = ['哈尔滨市'];
	  cityList['其他'] = ['其他'];
	  //加载城市
	  function change(){
	  	//获取到province的值
	  	var province=document.getElementById("RaddressShen").value; 
	  	//获取到id为city元素
	  	var city=document.getElementById("RaddressShi");
	  	city.options.length=0; //清除当前city中的选项
	  	//循环数组二维数组
	  	for (var i in cityList){
	  		//如果数组中的对象与省份相同
	  	    if (i == province){
	  	    	//则循环数组
	  	        for (var j in cityList[i]){
	  				city.add(new Option(cityList[i][j]),null);//将城市放入下拉框中
	  	        }
	  	    }
	  	}
	  } 
	  //加载省份
	  function AllCity(){
		  //获取省份元素
	  	 var province=document.getElementById("RaddressShen");
	  	 //循环将数组
	  	 for (var i in cityList){
	  		 province.add(new Option(i),null); //将数组里的对象放入下拉框中
	  	 }	
	 }
	  
	  function changeCity(){
		  	//获取到province的值
		  	var province=document.getElementById("PaddressShen").value; 
		  	//获取到id为city元素
		  	var city=document.getElementById("PaddressShi");
		  	city.options.length=0; //清除当前city中的选项
		  	//循环数组二维数组
		  	for (var i in cityList){
		  		//如果数组中的对象与省份相同
		  	    if (i == province){
		  	    	//则循环数组
		  	        for (var j in cityList[i]){
		  				city.add(new Option(cityList[i][j]),null);//将城市放入下拉框中
		  	        }
		  	    }
		  	}
		  } 
		  //加载省份
		  function allCity(){
			  //获取省份元素
		  	 var province=document.getElementById("PaddressShen");
		  	 //循环将数组
		  	 for (var i in cityList){
		  		 province.add(new Option(i),null); //将数组里的对象放入下拉框中
		  	 }
		 }
		 window.onload=function(){
			  allCity();
			  AllCity();
			  queryAllByCar();
			  queryAllInsureType();
		 }
 </script>
 	 <style type="text/css">
					#add_pros{
						font-size: 25px;
						text-align: center;
					}
					#tab{width: 100%;}
					#pro_bg{width: 80%;}	
	</style>
	<body style="background: #F7F7F7;">
			 <form>
				  <div id="add_pros">
	        		投保人信息添加
	        	  </div>
	        	  <input type="hidden" id="policyholdersId" value="">
	        	  <input type="hidden" id="recognizeeId" value="">
	        	  <input type="hidden" id="carTypeId" value="">
	        	  <input type="hidden" id="userId" value="${loginUser.userId }">
	        	  <div id="tab">
	        	    <table id="pro_bg" class="table table-bordered" align="center">
							<tr>
								<td>投保人姓名:<br><input type="text" class="form-control" id="policyholdersName" name="policyholdersName" value=""></td>
								<td>身份证:<br><input type="text" class="form-control" id="policyholdersCardId" onchange="query()" name="policyholdersCardId" value=""></td>
        			   			 <td>性别：<br><label class="radio-inline">
  										<input type="radio" name="Psex" id="Psex" value="男" checked="checked"> 男
								</label>
								<label class="radio-inline">
  										<input type="radio" name="Psex" id="Psex" value="女"> 女
								</label>
								</td>
							</tr>
							<tr>
								<td>联系地址/省：<br><select id="PaddressShen" onchange="changeCity()" class="form-control">
        													<option id="aa" >请选择省/城市</option>			</select>
			        			</td>
			        			<td>联系地址/市：<br><select id="PaddressShi" class="form-control">
			        										<option id="bb" >请选择城市/地区</option>			</select>
			        			</td>
			        			<td>联系电话：<br><input type="text" class="form-control" name="policyholdersTel" id="policyholdersTel" value=""/></td>
								<td>邮箱:<input type="text" class="form-control" id="policyholdersEmail" name="policyholdersEmail" value=""></td>
							</tr>
					</table>
				</div>
			</form>
			
			<form>
				  <div id="add_pros">
	        		被保人信息添加
	        	  </div>
	        	  <div id="tab">
	        	    <table id="pro_bg" class="table table-bordered" align="center">
							<tr>
								<td>被保人姓名:<br><input type="text" class="form-control" id="recognizeeName" name="recognizeeName" value=""></td>
								<td>身份证:<br><input type="text" class="form-control" id="recognizeeCardId" onchange="query()" name="recognizeeCardId" value=""></td>
        			   			<td>性别：<br><label class="radio-inline">
  										<input type="radio" name="Rsex" id="Rsex" value="男" checked="checked"> 男
								</label>
								<label class="radio-inline">
  										<input type="radio" name="Rsex" id="Rsex" value="女"> 女
								</label>
								</td>
							</tr>
							<tr>
								<td>联系地址/省：<br><select id="RaddressShen" onchange="change()" class="form-control">
        													<option id="cc" >请选择省/城市</option>			</select>
			        			</td>
			        			<td>联系地址/市：<br><select id="RaddressShi" class="form-control">
			        										<option id="dd" >请选择城市/地区</option>			</select>
			        			</td>
			        			<td>联系电话：<br><input type="text" class="form-control" name="recognizeeTel" id="recognizeeTel" value=""/></td>
								<td>邮箱:<br><input type="text" class="form-control" id="recognizeeEmail" name="recognizeeEmail" value=""></td>
							</tr>
							<tr>
								<td>银行账户:<br><input type="text" class="form-control" id="bankNumber" name="bankNumber" value=""></td>
								<td>行驶证编号:<br><input type="text" class="form-control" id="vehicleLicenseId" name="vehicleLicenseId" value=""></td>
								<td>驾驶证号码:<br><input type="text" class="form-control" id="driveId" name="driveId" value=""></td>
								<td>发动机编号:<br><input type="text" class="form-control" id="engineId" name="engineId" value=""></td>
							</tr>
					</table>
				</div>
			</form>

			<form>
				  <div id="add_pros">
	        		车辆信息添加
	        	  </div>
	        	  <div id="tab">
	        	    <table id="pro_bg" class="table table-bordered" align="center">
							<tr>
								<td>车辆名称:<br><select class="form-control" onchange="queryCarId()" id="carName">
									<option id="car" >-------请         选         择---------</option>
								</select></td>
								<td>车辆品牌:<br><input type="text" class="form-control" id="carBrand" name="carBrand" value=""></td>
								<td>车辆类型:<br><input type="text" class="form-control" id="carSpecificType" name="carSpecificType" value=""></td>
								<td>市场价格(万元):<br><input type="text" class="form-control" id="carValue" name="carValue" value=""></td>
							</tr>
					</table>
				</div>
			</form>
			
			<form>
				  <div id="add_pros">
	        		保单信息添加
	        	  </div>
	        	  <div id="tab">
	        	    <table id="pro_bg" class="table table-bordered" align="center">
							<tr>
								<td>操作人员:<br><input type="text" class="form-control" id="userName" name="userName" value="${loginUser.userName }"></td>
								<td>保险起期:<br><input type="date" class="form-control" id="insuranceBeginTime" name="insuranceBeginTime" value=""></td>
								<td>投保金额:<br><input type="text" class="form-control" id="insurancePrice" name="insurancePrice" value="0"></td>
								<td>缴费时间:<br><input type="date" class="form-control" id="paymentDate" value="" name="paymentDate"></td>
							</tr>
							<tr>
								<td></td>
								<td>保险止期:<br><input type="date" class="form-control" id="insuranceEndTime" value="" name="insuranceEndTime"></td>
								<td>保费金额:<br><input type="text" class="form-control" id="warrantyPrice" value="0" name="warrantyPrice"></td>
								<td>签单日期:<br><input type="date" class="form-control" id="signingDate" value="" name="signingDate"></td>
							</tr>
							<tr>
								<td colspan="4">
								选择险种:<br>
								<ul style="list-style-type:none" id="itypeall">
								<li style="float:left">动物险<input type="checkbox" id="insureType"><>
								<li style="float:left">意外险<input type="checkbox" id="insureType"><>
								<li style="float:left">车祸险<input type="checkbox" id="insureType"><>
								<li style="float:left">玻璃险<input type="checkbox" id="insureType"><>
								<li style="float:left">天灾险<input type="checkbox" id="insureType"><>
								<li style="float:left">人祸险<input type="checkbox" id="insureType"><>
								</ul>
								</td>
							</tr>
					</table>
				</div>
			</form>	
		
		<div style="width: 100%;text-align: center;">
			<button onclick="addWarranty()" style="width: 300px;" class="btn btn-primary">提交</button>
		</div>	
	</body>

</html>