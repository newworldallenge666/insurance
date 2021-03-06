package com.dxm.insuranceSpring.utils;

import org.apache.ibatis.jdbc.SQL;

import com.dxm.insuranceSpring.pojo.Case;
import com.dxm.insuranceSpring.pojo.Check;

public class CheckSqlUtils {
	//方法中的关键字区分大小写 SQL WHERE SELECT
	/**
	 * 动态更新方法
	 * @param param
	 * @return
	 */
	public String updateWithParamSql(final Check param){
		return new SQL(){
			{
				UPDATE("t_check");
				if(param.getReportId()!=null && param.getReportId()>0) {
					SET("reportId=#{reportId}");
				}
				if(param.getCheckPersonId()!=null && param.getReportId()>0) {
					SET("checkPersonId=#{checkPersonId}");
				}
				if(param.getCheckName()!=null) {
					SET("checkName=#{checkName}");
				}
				if(param.getCheckAddress()!=null) {
					SET("checkAddress=#{checkAddress}");
				}
				if(param.getCheckTime()!=null) {
					SET("checkTime=#{checkTime}");
				}
				if(param.getMydriverName()!=null) {
					SET("mydriverName=#{mydriverName}");
				}
				if(param.getOppositeDriverName()!=null) {
					SET("oppositeDriverName=#{oppositeDriverName}");
				}
				if(param.getMydriverTel()!=null) {
					SET("mydriverTel=#{mydriverTel}");
				}
				if(param.getOppositeDriverTel()!=null) {
					SET("oppositeDriverTel=#{oppositeDriverTel}");
				}
				if(param.getMyVehicleLicense()!=null) {
					SET("myVehicleLicense=#{myVehicleLicense}");
				}
				if(param.getOppositeVehicleLicense()!=null) {
					SET("oppositeVehicleLicense=#{oppositeVehicleLicense}");
				}
				if(param.getMyLicense()!=null) {
					SET("myLicense=#{myLicense}");
				}
				if(param.getOppositeLicense()!=null) {
					SET("oppositeLicense=#{oppositeLicense}");
				}
				WHERE("checkId=#{checkId}");
			}
		}.toString();
	}
	/**
	 * 动态查询 已勘察案件
	 */
	public String selectCheckedWithParamSql(final Check param) {
		StringBuffer sql = new StringBuffer("select * from t_check where 1=1");
		if(param.getCheckId()!=null && param.getCheckId()>0) {
			sql.append(" and checkId="+param.getCheckId());
		}
//		if(param.getReportId()!=null && param.getReportId()>0) {
//			sql.append(" and reportId="+param.getReportId());
//		}
//		if(param.getCheckPersonId()!=null && param.getCheckPersonId()>0) {
//			sql.append(" and checkPersonId="+param.getCheckPersonId());
//		}
		if(param.getCheckName()!=null && !"".equals(param.getCheckName())) {
			sql.append(" and checkName LIKE '%"+param.getCheckName()+"%'");
		}
		if(param.getCheckAddress()!=null && !"".equals(param.getCheckAddress())) {
			sql.append(" and checkAddress LIKE '%"+param.getCheckAddress()+"%'");
		}
//		if(param.getCheckTime()!=null && !"".equals(param.getCheckTime())) {
//			sql.append(" and checkTime LIKE '%"+param.getCheckTime()+"%'");
//		}
//		if(param.getMydriverName()!=null && !"".equals(param.getMydriverName())) {
//			sql.append(" and mydriverName LIKE '%"+param.getMydriverName()+"%'");
//		}
//		if(param.getOppositeDriverName()!=null && !"".equals(param.getOppositeDriverName())) {
//			sql.append(" and oppositeDriverName LIKE '%"+param.getOppositeDriverName()+"%'");
//		}
//		if(param.getMydriverTel()!=null && !"".equals(param.getMydriverTel())) {
//			sql.append(" and mydriverTel LIKE '%"+param.getMydriverTel()+"%'");
//		}
//		if(param.getOppositeDriverTel()!=null && !"".equals(param.getOppositeDriverTel())) {
//			sql.append(" and oppositeDriverTel LIKE '%"+param.getOppositeDriverTel()+"%'");
//		}
//		if(param.getMyLicense()!=null && !"".equals(param.getMyLicense())) {
//			sql.append(" and myLicense LIKE '%"+param.getMyLicense()+"%'");
//		}
//		if(param.getOppositeLicense()!=null && !"".equals(param.getOppositeLicense())) {
//			sql.append(" and oppositeLicense LIKE '%"+param.getOppositeLicense()+"%'");
//		}
//		if(param.getMyVehicleLicense()!=null && !"".equals(param.getMyVehicleLicense())) {
//			sql.append(" and myVehicleLicense LIKE '%"+param.getMyVehicleLicense()+"%'");
//		}
//		if(param.getOppositeVehicleLicense()!=null && !"".equals(param.getOppositeVehicleLicense())) {
//			sql.append(" and oppositeVehicleLicense LIKE '%"+param.getOppositeVehicleLicense()+"%'");
//		}
		//System.out.println("sqluti:"+sql.toString());
		return sql.toString();
	}
	/**
	 * 动态查询 已勘察案件分页
	 */
	public String selectCheckedWithParamCountSql(final Check param) {
		StringBuffer sql = new StringBuffer("select count(1) from t_check where 1=1");
		if(param.getCheckId()!=null && param.getCheckId()>0) {
			sql.append(" and checkId="+param.getCheckId());
		}
//		if(param.getReportId()!=null && param.getReportId()>0) {
//			sql.append(" and reportId="+param.getReportId());
//		}
//		if(param.getCheckPersonId()!=null && param.getCheckPersonId()>0) {
//			sql.append(" and checkPersonId="+param.getCheckPersonId());
//		}
		if(param.getCheckName()!=null && !"".equals(param.getCheckName())) {
			sql.append(" and checkName LIKE '%"+param.getCheckName()+"%'");
		}
		if(param.getCheckAddress()!=null && !"".equals(param.getCheckAddress())) {
			sql.append(" and checkAddress LIKE '%"+param.getCheckAddress()+"%'");
		}
//		if(param.getCheckTime()!=null && !"".equals(param.getCheckTime())) {
//			sql.append(" and checkTime LIKE '%"+param.getCheckTime()+"%'");
//		}
//		if(param.getMydriverName()!=null && !"".equals(param.getMydriverName())) {
//			sql.append(" and mydriverName LIKE '%"+param.getMydriverName()+"%'");
//		}
//		if(param.getOppositeDriverName()!=null && !"".equals(param.getOppositeDriverName())) {
//			sql.append(" and oppositeDriverName LIKE '%"+param.getOppositeDriverName()+"%'");
//		}
//		if(param.getMydriverTel()!=null && !"".equals(param.getMydriverTel())) {
//			sql.append(" and mydriverTel LIKE '%"+param.getMydriverTel()+"%'");
//		}
//		if(param.getOppositeDriverTel()!=null && !"".equals(param.getOppositeDriverTel())) {
//			sql.append(" and oppositeDriverTel LIKE '%"+param.getOppositeDriverTel()+"%'");
//		}
//		if(param.getMyLicense()!=null && !"".equals(param.getMyLicense())) {
//			sql.append(" and myLicense LIKE '%"+param.getMyLicense()+"%'");
//		}
//		if(param.getOppositeLicense()!=null && !"".equals(param.getOppositeLicense())) {
//			sql.append(" and oppositeLicense LIKE '%"+param.getOppositeLicense()+"%'");
//		}
//		if(param.getMyVehicleLicense()!=null && !"".equals(param.getMyVehicleLicense())) {
//			sql.append(" and myVehicleLicense LIKE '%"+param.getMyVehicleLicense()+"%'");
//		}
//		if(param.getOppositeVehicleLicense()!=null && !"".equals(param.getOppositeVehicleLicense())) {
//			sql.append(" and oppositeVehicleLicense LIKE '%"+param.getOppositeVehicleLicense()+"%'");
//		}
		//System.out.println("sql:"+sql.toString());
		return sql.toString();
	}
}
