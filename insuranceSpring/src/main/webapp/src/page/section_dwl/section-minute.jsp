<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
    <link href="../../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
   
    <!-- iCheck -->
   
	
    <!-- bootstrap-progressbar 
    <link href="../../../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap 
    <link href="../../../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker 
    <link href="../../../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style 
    <link href="../../../build/css/custom.min.css" rel="stylesheet">
    -->
    <style type="text/css">

    	</style>
  </head>

  <body style="background: #F7F7F7;">
    
				
				<!--
                	作者：offline
                	时间：2017-10-24
                	描述：内容开始
                -->

         <div align="center">
      <div class="table">
      <table border="1"  style="border-collapse:collapse;width: 500px;" class="table tableOne table-bordered" valign="middle">
	    <tr>
	      <td>部门</td>
	      <td>人数</td>
	    </tr>
     </table>
     </div>
     	<div class="table">
			<table border="1"  style="border-collapse:collapse;width: 800px;" class="table tableTwo table-bordered" valign="middle">
			    <tr>
			      <td width="100">员工编号</td>
			      <td width="100">员工姓名</td>
			      <td width="100">员工性别</td>
			      <td width="100">员工部门</td>
			      <td width="100">联系方式</td>
			      <td width="100">员工地址</td>
			    </tr>

            </table>
          </div>  
           <ul class="pagination">
					  <li><a href="#" id="jian">&laquo;</a></li>
					  <li><a href="#" id="">当前页</a></li>
					  <li><a href="#" id="firstpage"></a></li>
					  <li><a href="#" id="">总页数</a></li>
					  <li><a href="#" id="lastpage"></a></li>
					  <li><a href="#" id="jia">&raquo;</a></li>
					</ul>
                   
                   
      </tr>
      </table>
      </div>             
               <input type="hidden" id="dapartment" value="<%=request.getParameter("dapartment") %>"/>    
				<!--
                	作者：offline
                	时间：2017-10-24
                	描述：内容结束
                -->								
    <!-- jQuery -->
    <script src="../../../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../../../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../../../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../../../vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="../../../vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="../../../vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../../../vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="../../../vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="../../../vendors/Flot/jquery.flot.js"></script>
    <script src="../../../vendors/Flot/jquery.flot.pie.js"></script>
    <script src="../../../vendors/Flot/jquery.flot.time.js"></script>
    <script src="../../../vendors/Flot/jquery.flot.stack.js"></script>
    <script src="../../../vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="../../../vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="../../../vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="../../../vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="../../../vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="../../../vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="../../../vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="../../../vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../../../vendors/moment/min/moment.min.js"></script>
    <script src="../../../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../../../build/js/custom.min.js"></script>
     <script src="../../../src/js/jquery-1.8.3.js"></script>
     <script src="../../../src/js/employee/section-minute.js"></script>
  </body>
</html>