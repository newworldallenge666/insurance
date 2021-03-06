
//查询未指派报案信息
function querydispatch(indexPage) {
	//alert(1);
	$("#dispatchInfo").empty();
	$.ajax({
		url:'http://localhost:8080/src/page/report_wb/loadUnHandleReport.do',
		type:'post',
		data:{
			'indexPage':indexPage
		},
	    dataType : 'json',
		success : function(data) {
			//data=$.parseJSON(data);
			//alert(data.datas.length);
			var contentHtml ="";
			for (var i = 0; i<data.datas.length; i++) {
				var rowHtml ="<tr>";
				rowHtml+="<td >"+data.datas[i].reportId+"</td>";
				rowHtml+="<td >"+data.datas[i].reportPersonName+"</td>";
				rowHtml+="<td >"+data.datas[i].reportTime+"</td>";
				rowHtml+="<td >"+data.datas[i].province+"</td>";
				rowHtml+="<td >"+data.datas[i].city+"</td>";
				rowHtml+="<td >"+data.datas[i].area+"</td>";
				rowHtml+="<td >"+data.datas[i].reportReason+"</td>";
				rowHtml+="<td >"+data.datas[i].road_direction+"</td>";
				rowHtml+="<td >"+data.datas[i].reporPersontPhone+"</td>";
				if(data.datas[i].caseStatus==0){
					rowHtml += "<td>未处理</td>";
					rowHtml += "<td ><button class='btn btn-sm btn-primary'onclick='handle("+data.datas[i].reportId+");'>处理</button></td></tr>";
				}else{
					rowHtml +="</tr>";
				}
				contentHtml += rowHtml;
				}
		//alert(contentHtml);
		$("#dispatchInfo").append(contentHtml);
			page(data.singerData,"querydispatch");
		},
	error : function() {
		alert("查找失败!");
		}
	})
} 

function handle(reportId){
	alert("已处理！");
	setTimeout(function(){handle(reportId);},10000);
	window.location.href="http://localhost:8080/src/page/report_wb/updateReportStatus.do?reportId="+reportId;
}

function search(indexPage){
	//alert(1);
	var reportId = $("#reported_number").val();
	var reportPersonName = $("#reported_name").val();
	var reporPersontPhone = $("#reported_tel").val();
	$("#dispatchInfo").empty();
	$.ajax({
		url:'http://localhost:8080/src/page/report_wb/loadUnHandleReport.do',
		type:'post',
		dataType:'json',
		data:{
			'indexPage':indexPage,
			'reportId':reportId,
			'reportPersonName':reportPersonName,
			'reporPersontPhone':reporPersontPhone
		},
		success:function(data){
			//data = $.parseJSON(data);
			//控制输出
			console.log(data);
    		var contentHtml = "";
			if(data.result){
				for (var i = 0; i<data.datas.length; i++) {
					var rowHtml ="<tr>";
					rowHtml+="<td >"+data.datas[i].reportId+"</td>";
					rowHtml+="<td >"+data.datas[i].reportPersonName+"</td>";
					rowHtml+="<td >"+data.datas[i].reportTime+"</td>";
					rowHtml+="<td >"+data.datas[i].province+"</td>";
					rowHtml+="<td >"+data.datas[i].city+"</td>";
					rowHtml+="<td >"+data.datas[i].area+"</td>";
					rowHtml+="<td >"+data.datas[i].reportReason+"</td>";
					rowHtml+="<td >"+data.datas[i].road_direction+"</td>";
					rowHtml+="<td >"+data.datas[i].reporPersontPhone+"</td>";
					if(data.datas[i].caseStatus==0){
						rowHtml += "<td>未处理</td>";
						rowHtml += "<td ><button class='btn btn-sm btn-primary'onclick='handle("+data.datas[i].reportId+");'>处理</button></td></tr>";
					}else{
						rowHtml +="</tr>";
					}
					contentHtml += rowHtml;
				}
				$("#dispatchInfo").append(contentHtml);
				page(data.singerData,"search");
			 }
			else
			{
				$("#page").empty();
				alert(data.message);
			}
		},
		error:function(){
			alert("查询失败");
		}
	});
}


//分页
function page(page,method){
//	alert(11);
	$("#page").empty();
	var pagehtml = "<button class='btn btn-sm btn-primary' style='margin-right:20px' onclick='"+method+"(\"1\")'>首页</button>";
	if(page.indexPage == 1){
		pagehtml += "<button class='btn btn-sm btn-primary' style='margin-right:20px'>上一页</button>";
	}else{
		pagehtml += "<button class='btn btn-sm btn-primary' style='margin-right:20px' onclick='"+method+"(\""+(page.indexPage - 1)+"\")'>上一页</button>";
	}
	
	pagehtml += page.indexPage + "/" + page.pageCount;
	
	if(page.indexPage == page.pageCount){
		pagehtml += "<button class='btn btn-sm btn-primary' style='margin-right:20px;margin-left:20px'>下一页</button>";
	}else{
		pagehtml += "<button class='btn btn-sm btn-primary' style='margin-right:20px;margin-left:20px' onclick='"+method+"(\""+(page.indexPage + 1)+"\")'>下一页</button>";
	}
	pagehtml += "<button class='btn btn-sm btn-primary' style='margin-right:20px' onclick='"+method+"(\""+page.pageCount+"\")'>尾页</button>";
	$("#page").append(pagehtml);
}	    