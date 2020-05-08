package com.dxm.insuranceSpring.services.impls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dxm.insuranceSpring.aspectj.Logaspect;
import com.dxm.insuranceSpring.dao.DataDao;

import com.dxm.insuranceSpring.pojo.Data;
import com.dxm.insuranceSpring.services.IDataServices;
import com.dxm.insuranceSpring.utils.APIRequest;
@Service("DataServicesImpls")
public class DataServicesImpls implements  IDataServices {
    @Resource 
   DataDao dao;
	@Override
	@Logaspect(operationName="添加理赔清单资料")
	public APIRequest addData(Data dt) {
		APIRequest api=new APIRequest();
		if(dao.addData(dt)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("添加失败");
		}
		return api;
	}

	@Override
	@Logaspect(operationName="更新理赔清单资料")
	public APIRequest updateData(Data dt) {
		APIRequest api=new APIRequest();
		if(dao.updateData(dt)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("更新失败");
		}
		return api;
	}

	@Override
	@Logaspect(operationName="删除理赔清单资料")
	public APIRequest deleteData(Integer dataId) {
		APIRequest api=new APIRequest();
		if(dao.deleteData(dataId)>0) {
			api.setResult(true);
		}else {
			api.setResult(false);
			api.setMessage("删除失败");
		}
		return api;
	}

	@Override
	@Logaspect(operationName="查询所有理赔清单资料")
	public APIRequest<Data> queryData() {
		APIRequest<Data> api=new APIRequest<Data>();
		List<Data> datas=dao.queryData();
		if(datas.size()>0) {
			api.setResult(true);
			api.setDatas(datas);
		}else {
			api.setResult(false);
			api.setMessage("查询失败");
		}
		return api;
	}

	@Override
	@Logaspect(operationName="查询某条理赔清单资料ById")
	public APIRequest queryDataById(Integer dataId) {
		APIRequest api=new APIRequest();
		List<Data> data=dao.queryDataById(dataId);
		if(data.size()>0) {
			api.setResult(true);
			api.setSingerData(data.get(0));
		}else {
			api.setResult(false);
			api.setMessage("查找失败");
		}
		return api; 
	}
	}

