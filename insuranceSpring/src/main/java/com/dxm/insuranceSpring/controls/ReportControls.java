package com.dxm.insuranceSpring.controls;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxm.insuranceSpring.pojo.Report;
import com.dxm.insuranceSpring.pojo.Warranty;
import com.dxm.insuranceSpring.services.IReportServices;
import com.dxm.insuranceSpring.utils.APIRequest;

@Controller
@RequestMapping("src/page/report_wb")
public class ReportControls {
	@Resource(name="reportServicesImpls")
	IReportServices service;
	
	@RequestMapping(value="/loadWarranty.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String loadWarranty(Warranty warranty,Integer indexPage) {
		APIRequest<Warranty> api=service.queryWarranty(warranty,indexPage);
//		System.out.println(api.getDatas().size());
		return api.toString();
	}
	
	@RequestMapping(value="/loadWarrantyDetial.do",produces="application/json;charset=utf-8")
	public String loadWarrantyDetial(Integer warrantyId,HttpServletRequest request) {
		APIRequest api=service.queryWarrantyDetilsById(warrantyId);
		request.setAttribute("api",api);
		return "src/page/report_wb/report_insert";
	}
	
	@RequestMapping(value="/addReport.do",produces="application/json;charset=utf-8")
	public String addReport(Report report) {
		APIRequest api=service.addReport(report);
		return "src/page/report_wb/report_allquery";
	}
	
	@RequestMapping(value="/loadAllReport.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String loadAllReport(Report report,Integer indexPage) {
		APIRequest api=service.queryAllReport(report, indexPage);
		return api.toString();
		
	}
	
	@RequestMapping(value="/loadAllReportDetial.do",produces="application/json;charset=utf-8")
	public String loadAllReportDetial(Integer reportId,HttpServletRequest request) {
		APIRequest api=service.queryAllReportDetils(reportId);
		request.setAttribute("api", api);
		return "src/page/report_wb/report_allquerydetail";
	}
	
	@RequestMapping(value="/updateReport.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateReport(Report report) {
//		System.out.println(report.toString());
		report.getReportId();
		report.getWarrantyId();
		APIRequest api=service.updateReport(report);
		return api.toString();
	}
	
	@RequestMapping(value="/updateReportStatus.do",produces="application/json;charset=utf-8")
	public String updateReportStatus(Integer reportId) {
		APIRequest api=service.updateReportStatus(reportId);
		return "src/page/report_wb/report_myquery";
	}
	
	@RequestMapping(value="/loadHandleReport.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String loadHandleReport(Report report,Integer indexPage) {
		APIRequest<Report> api=service.queryHandleReport(report, indexPage);
//		System.out.println(api.getDatas().size());
		return api.toString();
	}
	
	@RequestMapping(value="/loadHandleReportDetails.do",produces="application/json;charset=utf-8")
	public String loadHandleReportDetails(Integer reportId,HttpServletRequest request) {
		APIRequest<Report> api=service.queryHandleReportDetails(reportId);
//		System.out.println(api.getDatas().toString());
		request.setAttribute("api", api);
		return "src/page/report_wb/report_myquerydetail";
	}
	
	@RequestMapping(value="/loadupdateReportDetails.do",produces="application/json;charset=utf-8")
	public String loadupdateReportDetails(Integer reportId,HttpServletRequest request) {
//		System.out.println(reportId);
		APIRequest<Report> api=service.queryAllReportDetils(reportId);
//		System.out.println(api.getDatas().toString());
		request.setAttribute("api", api);
		return "src/page/report_wb/report_upd";	
	}
	

	@RequestMapping(value="/loadUnHandleReport.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String loadUnHandleReport(Report report,Integer indexPage) {
		APIRequest<Report> api=service.queryUnHandleReport(report, indexPage);
//		System.out.println(api.getDatas().size());
		return api.toString();
	}
	
	@RequestMapping(value="/updateReportStatusById.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateReportStatusById(Integer reportId) {
		APIRequest api=service.updateReportStatusByReportId(reportId);
//		System.out.println(api.getDatas().toString());
		return api.toString();
	}
	
	
}
