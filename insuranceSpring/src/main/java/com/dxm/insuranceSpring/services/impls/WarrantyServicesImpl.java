package com.dxm.insuranceSpring.services.impls;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.dxm.insuranceSpring.aspectj.Logaspect;
import com.dxm.insuranceSpring.dao.CarTypeDao;
import com.dxm.insuranceSpring.dao.PolicyholdersDao;
import com.dxm.insuranceSpring.dao.RecognizeeDao;
import com.dxm.insuranceSpring.dao.WarrantyDao;
import com.dxm.insuranceSpring.pojo.CarType;
import com.dxm.insuranceSpring.pojo.Policyholders;
import com.dxm.insuranceSpring.pojo.Recognizee;
import com.dxm.insuranceSpring.pojo.Report;
import com.dxm.insuranceSpring.pojo.Warranty;
import com.dxm.insuranceSpring.services.IWarrantyServices;
import com.dxm.insuranceSpring.utils.APIRequest;
import com.dxm.insuranceSpring.utils.Pages;
/**
 * 实现保单services
 * @author qianjun
 *
 */
@Service("warrantyServicesImpl")
public class WarrantyServicesImpl implements IWarrantyServices {
	@Resource
	WarrantyDao dao;
	@Resource
	PolicyholdersDao pdao;
	@Resource
	RecognizeeDao rdao;
	@Resource
	CarTypeDao cdao;
	
	
	@Override
	@Logaspect(operationName="保单编号查询保单")
	/**
	 * 根据保单编号查询保单
	 */
	public Warranty queryWarrantyById(Integer warrantyId) {
		// TODO Auto-generated method stub
		Warranty data=dao.queryById(warrantyId);
		return data;
	}
	@Override
	@Logaspect(operationName="车辆编号查询车辆信息")
	public CarType queryWarrantyCarTypeById(Integer carTypeId) {
		CarType data=cdao.queryWarrantyCarTypeById(carTypeId);
		return data;
	}
	@Override
	@Logaspect(operationName="车辆名称查询车辆信息")
	public APIRequest queryWarrantyCarTypeByName(String carTypeName) {
		List<CarType> data = cdao.queryCarTypeByName(carTypeName);
		APIRequest<CarType> api= new APIRequest<>();
		if(data.size()>0) {
			api.setResult(true);
			api.setDatas(data);
		}else {
			api.setResult(false);
			api.setMessage("查询失败！");			
		}
		return api;
	}
	@Override
	@Logaspect(operationName="编号查询投保人")
	public Policyholders queryPolicyholderById(Integer policyholdersId) {
		// TODO Auto-generated method stub
		Policyholders data = pdao.queryPolicyholdersById(policyholdersId);
		
		return data;
	}
	@Override
	@Logaspect(operationName="编号查询被保人")
	public Recognizee queryRecognizeeById(Integer recognizeeId) {
		// TODO Auto-generated method stub
		Recognizee data = rdao.queryRecognizeeById(recognizeeId);
		return data;
	}
	@Override
	@Logaspect(operationName="身份证查询投保人")
	public APIRequest queryPolicyholderByCardId(String cardId) {
		// TODO Auto-generated method stub
		List<Policyholders> data = pdao.queryPolicyholdersByCardId(cardId);
		APIRequest<Policyholders> api= new APIRequest<>();
		if(data.size()>0) {
			api.setResult(true);
			api.setDatas(data);
		}else {
			api.setResult(false);
			api.setMessage("查询失败！");			
		}
		return api;
	}
	
	@Override
	@Logaspect(operationName="身份证查询被保人")
	public APIRequest queryRecognizeeByCardId(String cardId) {
		// TODO Auto-generated method stub
		List<Recognizee> data = rdao.queryRecognizeeByCardId(cardId);
		APIRequest<Recognizee> api= new APIRequest<>();
		if(data.size()>0) {
			api.setResult(true);
			api.setDatas(data);
		}else {
			api.setResult(false);
			api.setMessage("查询失败！");			
		}
		return api;
	}
	/**
	 * 修改保单信息
	 */
	@Override
	@Logaspect(operationName="保单修改")
	public APIRequest update(Warranty wa) {
		// TODO Auto-generated method stub
		APIRequest api=new APIRequest();
		if(dao.updateWarranty(wa)>0) {
			System.out.println("11111");
			api.setResult(true);
			api.setMessage("更新成功..");
		}else {
			api.setResult(false);
			api.setMessage("更新失败");
		}
		return api;
	}
	/**
	 *续保业务
	 */
	@Override
	@Logaspect(operationName="续保")
	public APIRequest xubao(Integer warrantyId, String years) {
		// TODO Auto-generated method stub
		APIRequest api=new APIRequest();
		if(dao.updateDate(warrantyId,years)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("更新失败");
		}
		return api;
	}
	
	/**
	 * 添加保单
	 */
	@Override
	@Logaspect(operationName="添加保单")
	public APIRequest add(Warranty wa) {
		// TODO Auto-generated method stub
		APIRequest api=new APIRequest();
		if(dao.addWarranty(wa)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("添加失败");
		}
		return api;
	}
	/**
	 * 分页查询保单信息
	 */
	@Override
	@Logaspect(operationName="分页查询保单")
	public APIRequest queryAll(Integer indexpage) {
		// TODO Auto-generated method stub
		if(indexpage==null) {
			indexpage=1;
		}
		int rowcount  = dao.count();
		Pages page = new Pages(rowcount);
		page.setIndexPage(indexpage);
		
		RowBounds rb = new RowBounds(page.getBeginRow(),page.getPageSize());
		List<Warranty> data = dao.queryAll(rb);
		
		APIRequest<Warranty> api = new APIRequest<>();
		
		if(data.size()>0) {
			api.setResult(true);
			api.setDatas(data);
			api.setSingerData(page);
		}else {
			api.setResult(false);
			api.setMessage("对不起，当前没有数据！");
		}
		return api;
	}
	/**
	 * 添加投保人
	 */
	@Override
	@Logaspect(operationName="添加投保人")
	public APIRequest addPolicyHolder(Policyholders pc) {
		// TODO Auto-generated method stub
		APIRequest api=new APIRequest();
		if(pdao.add(pc)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("添加失败");
		}
		return api;
	}
	//修改投保人信息
	@Override
	@Logaspect(operationName="修改投保人信息")
	public Integer updatePolicyHolder(Policyholders pc) {
		// TODO Auto-generated method stub
		return pdao.update(pc);
	}
	
	/**
	 * 删除投保人信息
	 */
	@Override
	@Logaspect(operationName="删除投保人")
	public APIRequest deletePolicyHolder(Integer policyholdersId) {
		// TODO Auto-generated method stub
		APIRequest<Policyholders> api=new APIRequest();
		if(pdao.delete(policyholdersId)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("删除失败");
		}
		return api;
	}
	/**
	 * 添加被保人信息
	 */
	@Override
	@Logaspect(operationName="添加被保人")
	public APIRequest addRecognizee(Recognizee rg) {
		// TODO Auto-generated method stub
		APIRequest api=new APIRequest();
		if(rdao.addRecognizee(rg)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("添加失败");
		}
		return api;
	}
	/**
	 * 修改被保人信息
	 */
	@Override
	@Logaspect(operationName="修改被保人信息")
	public APIRequest updateRecognizee(Recognizee rg) {
		// TODO Auto-generated method stub
		APIRequest api=new APIRequest();
		if(rdao.updateRecognizee(rg)>0) {
			api.setResult(true);
			api.setMessage("更新成功..");
		}else {
			api.setResult(false);
			api.setMessage("更新失败!");
		}
		return api;
	}
	@Override
	@Logaspect(operationName="修改投保人信息")
	public APIRequest updatePolicy(Policyholders pc) {
		// TODO Auto-generated method stub
		  APIRequest<Policyholders> api=new APIRequest();
			if(pdao.update(pc)>0) {
				api.setResult(true);
				api.setMessage("更新成功..");
			}else {
				api.setResult(false);
				api.setMessage("更新失败!");
			}
			return api;
	}
	/**
	 * 删除被保人信息
	 */
	@Override
	@Logaspect(operationName="删除被保人")
	public APIRequest deleteRecognizee(Integer RecognizeeId) {
		// TODO Auto-generated method stub
		APIRequest<Recognizee> api=new APIRequest();
		if(rdao.deleteRecognizee(RecognizeeId)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("删除失败");
		}
		return api;
	}
	
	/**
	 * 分页查询投保人信息
	 */
	@Override
	@Logaspect(operationName="分页查询投保人")
	public APIRequest queryPolicyHolder(Integer indexpage) {
		// TODO Auto-generated method stub
		if(indexpage==null) {
			indexpage=1;
		}
		int rowcount  = pdao.count();
		Pages page = new Pages(rowcount);
		page.setIndexPage(indexpage);
		RowBounds rb = new RowBounds(page.getBeginRow(),page.getPageSize());
		List<Policyholders> data = pdao.query(rb);
		
		APIRequest<Policyholders> api = new APIRequest<>();
		
		if(data.size()>0) {
			api.setResult(true);
			api.setDatas(data);
			api.setSingerData(page);
		}else {
			api.setResult(false);
			api.setMessage("对不起，当前没有数据！");
		}
		return api;
	}
	/**
	 * 分页查询被保人信息
	 */
	@Override
	@Logaspect(operationName="分页查询被保人")
	public APIRequest queryRecognizee(Integer indexpage) {
		// TODO Auto-generated method stub
		if(indexpage==null) {
			indexpage=1;
		}
		int rowcount  = rdao.count();
		Pages page = new Pages(rowcount);
		page.setIndexPage(indexpage);
		RowBounds rb = new RowBounds(page.getBeginRow(),page.getPageSize());
		List<Recognizee> data = rdao.queryRecognizee(rb);
		//System.out.println(data.toString());
		APIRequest<Recognizee> api = new APIRequest<>();
		
		if(data.size()>0) {
			api.setResult(true);
			api.setDatas(data);
			api.setSingerData(page);
		}else {
			api.setResult(false);
			api.setMessage("对不起，当前没有数据！");
		}
		return api;
	}
	
	/**
	 * 按条件查询保单信息
	 */
	@Override
	@Logaspect(operationName="按条件查询保单")
	public APIRequest queryByInfo(Warranty wa, Integer indexpage) {
		// TODO Auto-generated method stub
		if(indexpage == null) {
			indexpage = 1;
		}
		System.out.println("wa="+wa);
		Integer count=dao.countByInfo(wa);
		System.out.println("count="+count);
		Pages page=new Pages(count);
		page.setIndexPage(indexpage);
		RowBounds row=new RowBounds(page.getBeginRow(),page.getPageSize());
		
		List<Warranty> data=dao.queryByInfo(wa,row);
		System.out.println("data="+data);
		APIRequest<Warranty> api=new APIRequest<>();
		if(data.size() > 0) {
			System.out.println("true");
			api.setResult(true);
			api.setDatas(data);
			api.setSingerData(page);
		}else {
			api.setResult(false);
			api.setMessage("对不起,当前没有数据");
		}
		return api;
	}
	
	/**
	 * 按条件查询被保人信息
	 */
	@Override
	@Logaspect(operationName="按条件查询被保人")
	public APIRequest queryRecognizeeByInfo(Recognizee rg, Integer indexpage) {
		// TODO Auto-generated method stub
		if(indexpage == null) {
			indexpage = 1;
		}
		System.out.println("pcpcpc="+rg);
		Integer count=rdao.countByInfo(rg);
		System.out.println("count="+count);
		Pages page=new Pages(count);
		page.setIndexPage(indexpage);
		RowBounds row=new RowBounds(page.getBeginRow(),page.getPageSize());
		
		List<Recognizee> data=rdao.queryRecognizeeByInfo(rg, row);
		System.out.println("data="+data);
		APIRequest<Recognizee> api=new APIRequest<>();
		if(data.size() > 0) {
			api.setResult(true);
			api.setDatas(data);
			api.setSingerData(page);
		}else {
			api.setResult(false);
			api.setMessage("对不起,当前没有数据");
		}
		return api;
	}
	
	/**
	 * 按条件查询投保人信息
	 */
	@Override
	@Logaspect(operationName="按条件查询投保人")
	public APIRequest queryPolicyHolderByInfo(Policyholders pc, Integer indexpage) {
		// TODO Auto-generated method stub
		if(indexpage == null) {
			indexpage = 1;
		}   
		Integer count=pdao.countByInfo(pc);
		Pages page=new Pages(count);
		page.setIndexPage(indexpage);
		RowBounds row=new RowBounds(page.getBeginRow(),page.getPageSize());
		List<Policyholders> data=pdao.queryByInfo(pc,row);
		APIRequest<Policyholders> api=new APIRequest<>();
		if(data.size() > 0) {
			api.setResult(true);
			api.setDatas(data);
			api.setSingerData(page);
		}else {
			api.setResult(false);
			api.setMessage("对不起,当前没有数据");
		}
		return api;
	}
	@Override
	@Logaspect(operationName="查询保单")
	public APIRequest<Warranty> queryWarrantyDetilsById(Integer warrantyId) {
		// TODO Auto-generated method stub
		List<Warranty> data = dao.queryWarrantyDetilsById(warrantyId);
		APIRequest<Warranty> api = new APIRequest<>();
		if(data.size()>0) {
			api.setResult(true);
			api.setDatas(data);
			api.setSingerData(data.get(0));
		}else {
			api.setResult(false);
			api.setMessage("对不起，当前没有数据！");
		}
		return api;
	}
}
