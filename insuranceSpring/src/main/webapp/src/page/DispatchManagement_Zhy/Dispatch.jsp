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
    	
    		#top{
    			margin-top:14px ;
    		}
				#user_name{
					float:right;
				}
				
				#s1{
					font-size: 30px;
				}
				#page {
				text-align: center;
			}
    </style>
    
  </head>

  <body style="background: #F7F7F7;" onload="querydispatch()">
    
				
				<!--
                	作者：offline
                	时间：2017-10-24
                	描述：内容开始
                -->
            	
        <div id="top">
           <div id="s1" class="col-md-3">
            	  报案信息调度管理
           </div>
          
		        <form class="form-inline">
				  <div class="form-group">
				    <label for="exampleInputName2">报案编号</label>
				    <input type="text" class="form-control" id="reported_number" placeholder="123">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputName2">报案人姓名</label>
				    <input type="text" class="form-control" id="reported_name" placeholder="张三">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputName2">报案人电话</label>
				    <input type="text" class="form-control" id="reported_tel" placeholder="16304975464">
				  </div>
				  <span class="btn btn-default" onclick="search(1);"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
				</form>
				  </div>
     		
           <div id="table">
						<table class="table table-bordered">
					 		<tr class="">
					 			<th class="active">报案编号</th>
					 			<th class="active">报案人</th>
					 			<th class="active">报案时间</th>
					 			<th class="active">报案地点所在省</th>
					 			<th class="active">报案地点所在市</th>
					 			<th class="active">报案地点所在县/区</th>
					 			<th class="active">报案原因</th>
					 			<th class="active">路段方向</th>
					 			<th class="active">事故司机联系方式</th>
					 			<th class="active">案件状态</th>
					 			<th class="active">操作</th>
					 			
					 		</tr>	
                            
							<tbody id="dispatchInfo"></tbody>

						</table>
			 <div id="page">
			<button id="firstpage" class="btn btn-sm btn-primary" style="margin-right:20px">首页</button>
			<button id="jian" class="btn btn-sm btn-primary" style="margin-right:20px">上一页</button>
			1/1
			<button id="jia" class="btn btn-sm btn-primary" style="margin-right:20px;margin-left:20px">下一页</button>
			<button id="lastpage" class="btn btn-sm btn-primary" style="margin-right:20px">尾页</button>
		    </div>
					</div>
				
					<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade myModal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">派遣一个员工</h4>
      </div>
      <input type="hidden" id="id" />
      <div class="modal-body">
      		<select id="diaoduyuan" class="form-control">
  					
			</select>
        
      </div>
      <div class="modal-footer">
        <button type="button" id="close" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="paiqian" class="btn btn-primary">确认派遣</button>
      </div>
    </div>
  </div>
</div>
                   
                   
                   
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
		<script src="../../js/jquery-1.8.3.js"></script>
		<script src="../../js/report/dispatch.js"></script>
 
			
				
					<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade myModal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">派遣一个员工</h4>
      </div>
      <input type="hidden" id="id" />
      <div class="modal-body">
      		<select id="diaoduyuan" class="form-control">
  					
			</select>
        
      </div>
      <div class="modal-footer">
        <button type="button" id="close" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="paiqian" class="btn btn-primary">确认派遣</button>
      </div>
    </div>
  </div>
</div>
                   
                   
                   
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
		<script src="../../js/jquery-1.8.3.js"></script>
		<script src="../../js/report/dispatch.js"></script>
  </body>
</html>