package com.dxm.insuranceSpring.controls;
/**
 * 保险
 */
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxm.insuranceSpring.aspectj.Logaspect;
import com.dxm.insuranceSpring.pojo.CarType;
import com.dxm.insuranceSpring.pojo.InsuranceType;
import com.dxm.insuranceSpring.services.ICarTypeServices;
import com.dxm.insuranceSpring.services.InsuranceTypeServices;
import com.dxm.insuranceSpring.utils.APIRequest;

@Controller
public class InsuranceControls {
	
	@Resource(name="insuranceTypeServicesImpls")
	InsuranceTypeServices service;
	
	
	@RequestMapping(value="/addInsuranceType.do",produces="application/json;charset=utf-8")
	public String addCarType(InsuranceType it) {
		System.out.println("dddd="+it);
		APIRequest api=service.addInsuranceType(it);
		return "redirect:src/page/section_dwl/insurance.jsp";
	}
	@RequestMapping(value="/loadInsuranceInfo.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryInsuranceType(Integer indexPage) {
		APIRequest<InsuranceType> api=service.queryInsuranceType(indexPage);
		return api.toString();
	}
	@RequestMapping(value="/deleteInsuranceInfo.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String deleteInsuranceType(Integer id) {
		APIRequest api=service.deleteInsuranceType(id);
	//	System.out.println(api.getDatas().size());
		return api.toString();
	}
	@RequestMapping(value="/updateInsuranceInfo.do",produces="application/json;charset=utf-8")
	public String updateInsuranceType(InsuranceType it) {
		APIRequest api=service.updateInsuranceType(it);
		return "redirect:src/page/section_dwl/insurance.jsp";
	}
	@RequestMapping(value="/toupdateInsuranceInfo.do")
	public String toupdateInsuranceType(Integer id,HttpServletRequest request) {
		APIRequest api=service.queryInsuranceTypeById(id);
	   request.setAttribute("api", api);
		//System.out.println(api.getSingerData().toString());
		return "src/page/section_dwl/insuranceUpdate";
	}
	@RequestMapping(value="/queryInsuranceType.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryInsuranceType() {
		APIRequest<InsuranceType> api=service.queryInsuranceType();
	//	System.out.println(api.getDatas().size());
		return api.toString();
	}
	
}
