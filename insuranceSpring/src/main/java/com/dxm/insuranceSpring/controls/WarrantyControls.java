package com.dxm.insuranceSpring.controls;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxm.insuranceSpring.pojo.CarType;
import com.dxm.insuranceSpring.pojo.Policyholders;
import com.dxm.insuranceSpring.pojo.Recognizee;
import com.dxm.insuranceSpring.pojo.Warranty;
import com.dxm.insuranceSpring.services.IWarrantyServices;
import com.dxm.insuranceSpring.utils.APIRequest;

@Controller
public class WarrantyControls {
	@Resource(name="warrantyServicesImpl")
	IWarrantyServices service;
	
	
	@RequestMapping(value="/queryWarrantyDetilsById.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryWarrantyDetilsById(Integer warrantyId,HttpServletRequest request) {
		APIRequest api=service.queryWarrantyDetilsById(warrantyId);
		System.out.println("保单信息contorl:"+api.toString());
		request.setAttribute("api", api);
		return api.toString();	
	}
	
	@RequestMapping(value="/addWarranty.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String addWarranty(Warranty wa){
		APIRequest<Warranty> api=service.add(wa);
		return api.toString();
	}
	@RequestMapping(value="/queryCarByCarName.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryCarByCarName(String carTypeName) {
		APIRequest api=service.queryWarrantyCarTypeByName(carTypeName);
		return api.toString();
	}
	@RequestMapping(value="/queryReByCardId.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryReByCardId(String recognizeeCardId) {
		APIRequest api=service.queryRecognizeeByCardId(recognizeeCardId);
		return api.toString();
	}
	
	@RequestMapping(value="/queryPoByCardId.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryPoByCardId(String policyholdersCardId) {
		APIRequest api=service.queryPolicyholderByCardId(policyholdersCardId);
		return api.toString();
	}
	
	@RequestMapping(value="/queryWarranty.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryWarranty(Integer indexpage) {
		APIRequest<Warranty> api=service.queryAll(indexpage);
		return api.toString();
	}
	
	@RequestMapping(value="/queryWarrantyByInfo.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryWarrantyByInfo(Warranty wa,Integer indexpage) {
		APIRequest<Warranty> api = service.queryByInfo(wa, indexpage);
		return api.toString();
	}
	
	@RequestMapping(value="/updateWarranty.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateWarranty(Warranty wa){
		APIRequest<Warranty> api=service.update(wa);
		return api.toString();
	}
	@RequestMapping(value="/updateWarranty1.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateWarranty1(Recognizee rg){
		APIRequest<Recognizee> api=service.updateRecognizee(rg);
		return api.toString();
	}
	@RequestMapping(value="/updateWarranty2.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateWarranty2(Policyholders pc){
		APIRequest<Policyholders> api=service.updatePolicy(pc);
		return api.toString();
	}
	@RequestMapping("/queryByList.do")
	public String queryByList(HttpServletRequest request,String recognizeeId,String policyholdersId,String warrantyId,String carTypeId){
		Recognizee rapi=service.queryRecognizeeById(Integer.parseInt(recognizeeId));
		Policyholders papi=service.queryPolicyholderById(Integer.parseInt(policyholdersId));
		Warranty wapi=service.queryWarrantyById(Integer.parseInt(warrantyId));
		CarType capi=service.queryWarrantyCarTypeById(Integer.parseInt(carTypeId));
		
		request.setAttribute("rapi",rapi);
		request.setAttribute("papi",papi);
		request.setAttribute("capi",capi);
		request.setAttribute("wapi",wapi);
		return "src/page/insurance_manage/insureInfo";
	}
	
	@RequestMapping("/queryToUpdate.do")
	public String queryToUpdate(HttpServletRequest request,String recognizeeId,String policyholdersId,String warrantyId,String carTypeId){
		Recognizee rapi=service.queryRecognizeeById(Integer.parseInt(recognizeeId));
		Policyholders papi=service.queryPolicyholderById(Integer.parseInt(policyholdersId));
		Warranty wapi=service.queryWarrantyById(Integer.parseInt(warrantyId));
		CarType capi=service.queryWarrantyCarTypeById(Integer.parseInt(carTypeId));
		
		request.setAttribute("rapi",rapi);
		request.setAttribute("papi",papi);
		request.setAttribute("capi",capi);
		request.setAttribute("wapi",wapi);
		return "src/page/insurance_manage/updateInsure";
		
		
	}
	@RequestMapping(value="/xubao.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String xubao(Integer warrantyId,String insuranceEndTime){
		System.out.println("dddd="+warrantyId+"  "+insuranceEndTime);
		APIRequest<Warranty> api=service.xubao(warrantyId,insuranceEndTime);
		System.out.println(api);
		return api.toString();
	}
	
}
