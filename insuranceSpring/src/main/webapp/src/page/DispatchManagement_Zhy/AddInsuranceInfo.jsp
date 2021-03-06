<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加投保人</title>
<!-- Bootstrap -->
    <link href="../../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
   
    <!-- iCheck -->
   
    <link href="../../../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap 
    <link href="../../../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker 
    <link href="../../../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style 
    <link href="../../../build/css/custom.min.css" rel="stylesheet">
    -->
    <style type="text/css">
					#add_pros{
						font-size: 25px;
						text-align: center;
					}
					#tab{width: 100%;}
					#pro_bg{width: 80%;}
    	</style>
  </head>

  <body style="background: #F7F7F7;">
    

        	<form>
        	<div id="add_pros">
        		添加投保人
        	</div>
        	<div id="tab">
        	<table id="pro_bg" class="table table-bordered" align="center">
        		
        		<tr>
        			<td colspan="3">基本信息：</td>
        		</tr>
        		<tr>
        			<td>投保人姓名：<br><input type="text" class="form-control" id="policyholdersName"/></td>
        			<td>身份证：<br><input type="text" class="form-control"  id="cardId"/></td>
        			<td>性别：<br><label class="radio-inline">
  										<input type="radio"  id="sex" name="sex"  value="男" checked="checked">男
								</label>
								<label class="radio-inline">
  										<input type="radio"  id="sex" name="sex" value="女">女
								</label>
					</td>
        		</tr>
        		<tr>
        			<td>联系地址/省：<br><select onchange="changeCity()" id="addressShen" name="addressShen" class="form-control">
        														<option value="1">联系地址/省:</option>
        														
        													</select>
        			联系地址/市：<br><select id="addressShi" name="addressShi" class="form-control">
        														<option value="2"></option>
        													</select>
        			</td>
        			<td>联系方式：<br><input type="text" class="form-control" id="tel" name="tel"/></td>
        			<td>邮箱：<br><input type="text" class="form-control" id="email" name="email"/></td>
        		</tr>
        		
                
                <tr class="count" style="text-align: center;">  
        					<td colspan="3">
        						<button type="button" onclick="add();" class="btn btn-default"  id="but1"><span class="glyphicon glyphicon-ok" aria-hidden="true" ></span></button>
							<a href="Policy-holder.jsp">	
								<button type="button" class="btn btn-default"  id="but2"><span class="glyphicon glyphicon-remove" aria-hidden="true" ></span></button></a>
								<button type="reset" class="btn btn-default"  id="but3"><span class="glyphicon glyphicon-repeat" aria-hidden="true" ></span></button>
        					</td>
        				</tr>
          
        	</table>
        	</div>
		</form>
     
                   
                   
                   
                   							
   		<script  src="../../../vendors/jquery/dist/jquery.min.js"></script>
	    <script type="text/javascript" src="../../js/WarrantyInfo/address.js"></script>
   		<script type="text/javascript" src="../../js/WarrantyInfo/addPolicyholders.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../../../build/js/custom.min.js"></script>
  </body>
</html>