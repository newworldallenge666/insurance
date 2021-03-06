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
    
    form{
    	margin-left: 30%;
    }
    
    table{
    	margin-top:20px ;
    }
	
	.disabled {
	    opacity: 0.6;
	    cursor: not-allowed;
	}
    #page {
				text-align: center;
			}
    	</style>
		
		<title></title>
	</head>
	<body style="background: #F7F7F7;" onload="queryAllreport()">
		
		<form class="form-inline">
  <div class="form-group">
    <label for="exampleInputName2">报案编号</label>
    <input type="text" class="form-control" id="reported_number" placeholder="请输入报案编号">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">报案人姓名</label>
    <input type="text" class="form-control" id="reported_name" placeholder="请输入报案人姓名">
  </div>
   <div class="form-group">
    <label for="exampleInputName2">报案人电话</label>
    <input type="text" class="form-control" id="reported_tel" placeholder="请输入报案人电话">
  </div>
  <span class="btn btn-default" onclick="search(1);"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
</form>
		
		
		<table class="table table-bordered" id="table">
                    <tr>
                     <th>报案编号</th>
                	 <th>车牌号</th>
                	 <th>报案人</th>
                	 <th>报案人电话</th>
                	 <th>出险原因</th>
                	 <th>出险地点所在省</th>
					 <th>出险地点所在市</th>
					 <th>出险地点所在区县</th>
					 <th>出险地点所在路段</th>
					 <th>出险地点所在方向</th>
                	 <th>出险日期</th>
                	 <th>操作</th>
                    </tr>
					<tbody id="allreportInfo"></tbody>
                     
        </table>
        <div id="page">
			<button id="firstpage" class="btn btn-sm btn-primary" style="margin-right:20px">首页</button>
			<button id="jian" class="btn btn-sm btn-primary" style="margin-right:20px">上一页</button>
			1/1
			<button id="jia" class="btn btn-sm btn-primary" style="margin-right:20px;margin-left:20px">下一页</button>
			<button id="lastpage" class="btn btn-sm btn-primary" style="margin-right:20px">尾页</button>
		</div>
	</body>
	<script src="../../js/jquery-1.8.3.js"></script>
	<script src="../../js/report/AllReportQuery.js"></script>
</html>