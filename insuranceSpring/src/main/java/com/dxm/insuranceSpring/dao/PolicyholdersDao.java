package com.dxm.insuranceSpring.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import com.dxm.insuranceSpring.pojo.Policyholders;
import com.dxm.insuranceSpring.pojo.Recognizee;
import com.dxm.insuranceSpring.utils.WarrantySqlUtils;

/**
 * 投保人Dao
 * @author 钱俊
 *
 */
public interface PolicyholdersDao {
	/**
	 * 添加投保人信息
	 * @param ph
	 * @return
	 */
	@Insert("insert into t_policyholders values(0,#{policyholdersName},#{sex},#{cardId},#{tel},#{addressShen},#{addressShi},#{email})")
	public Integer add(Policyholders ph);
	
	/**
	 * 根据编号删除投保人信息
	 * @param id
	 * @return
	 */
	@Delete("delete from t_policyholders where policyholdersId=#{policyholdersId}")
	public Integer delete(Integer policyholdersId);
	/**
	 * 根据Id查询数据
	 * @param policyholdersid
	 * @return
	 */
	@Select("select * from t_policyholders where policyholdersid=#{policyholdersid}")
	public Policyholders queryPolicyholdersById(Integer policyholdersId);
	/**
	 * 分页查询所有投保人信息
	 * @param row
	 * @return
	 */
	@Select("select * from t_policyholders")
	public List<Policyholders> query(RowBounds row);
	
	@Select("select count(1) from t_policyholders")
	public Integer count();
	
	@SelectProvider(type=WarrantySqlUtils.class,method="selectCountPolicyholders")
	public Integer countByInfo(Policyholders pc);
	/**
	 * 根据投保人编号,投保人姓名和身份证号查询投保人信息
	 * @param pc
	 * @return
	 */
	@SelectProvider(type=WarrantySqlUtils.class,method="selectPolicyholders")
	public List<Policyholders> queryByInfo(Policyholders pc,RowBounds row);
	
	@Select("select * from t_policyholders where cardId=#{cardId}")
	public List<Policyholders> queryPolicyholdersByCardId(String cardId);
	/**
	 * 修改投保人信息
	 * @param ph
	 * @return
	 */
	@UpdateProvider(type=WarrantySqlUtils.class,method="updatePolicyholders")
	public Integer update(Policyholders pc);
}
