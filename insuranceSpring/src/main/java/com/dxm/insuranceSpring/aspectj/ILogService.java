package com.dxm.insuranceSpring.aspectj;

import java.util.HashMap;

import com.dxm.insuranceSpring.pojo.Log;
import com.dxm.insuranceSpring.utils.APIRequest;

public interface ILogService {
	
	public Integer addLog(Log log);
	
	public HashMap<String,Object> queryLog(Integer indexPage,Log log);
	
	public APIRequest<Integer> deleteLog(Integer... logIds);
	
}
