package com.toz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.toz.model.PageBean;
import com.toz.model.stuInfo;


public class stuinfoservice {

	public ResultSet gradeList(Connection con, PageBean pageBean, stuInfo stuInfo) throws Exception {
		StringBuffer sb = new StringBuffer("select * from studentinfo");
		if(stuInfo != null && StringUtil.isNotEmpty(stuInfo.getTruename())) {
			sb.append(" and trueName like '%" + stuInfo.getTruename() + "%'");
		}

		if(pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}

		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	public int gradeCount(Connection con, stuInfo grade) throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from studentinfo");
		if(StringUtil.isNotEmpty(grade.getTruename())) {
			sb.append(" and trueName like '%" + grade.getTruename() + "%'");
		}

		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		return rs.next()?rs.getInt("total"):0;
	}

	private Connection conn;
	private PreparedStatement pstmt;

	public stuinfoservice() {
		conn = new com.toz.conn.conn().getCon();
	}

	public boolean addStu(stuInfo stu) {
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("insert into studentinfo"
					+ "(nicheng,truename,csrq,zy,kc,xq,bz) "
					+ "values(?,?,?,?,?,?,?)");
			pstmt.setString(1, stu.getNicheng());
			pstmt.setString(2, stu.getTruename());
			pstmt.setString(3, stu.getCsrq());
			pstmt.setString(4, stu.getZy());
			pstmt.setString(5, stu.getKcs());
			pstmt.setString(6, stu.getXqs());
			pstmt.setString(7, stu.getBz());

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		}

	}
	public List queryAllStu() {
		List stus = new ArrayList();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from studentinfo");
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			while (rs.next()) {
				stuInfo stu = new stuInfo();
				stu.setId(rs.getInt(1));
				stu.setNicheng(rs.getString(2));
				stu.setTruename(rs.getString(3));
				if (rs.getDate(4) != null)
					stu.setCsrq(rs.getDate(4).toString());
				stu.setZy(rs.getString(5));
				if (rs.getString(6) != null)
					stu.setKc(rs.getString(6).split("&"));
				if (rs.getString(7) != null)
					stu.setXq(rs.getString(7).split("&"));
				stu.setBz(rs.getString(8));
				stus.add(stu);

			}
			return stus;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public stuInfo queryStubyID(int id) {
		// List stus = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from studentinfo where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				stuInfo stu = new stuInfo();
				stu.setId(rs.getInt(1));
				stu.setNicheng(rs.getString(2));
				stu.setTruename(rs.getString(3));
				if (rs.getDate(4) != null)
					stu.setCsrq(rs.getDate(4).toString());
				stu.setZy(rs.getString(5));
				if (rs.getString(6) != null)
					stu.setKc(rs.getString(6).split("&"));
				if (rs.getString(7) != null)
					stu.setXq(rs.getString(7).split("&"));
				stu.setBz(rs.getString(8));
				// stus.add(stu);
				return stu;

			}
			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean updateStu(stuInfo stu) {

		try {
			pstmt = conn
					.prepareStatement("update  studentinfo set nicheng=? , truename=?  ,csrq=? ,"
							+ " zy=? ,kc=? , xq=?, bz=?   where id=?");
			pstmt.setString(1, stu.getNicheng());
			pstmt.setString(2, stu.getTruename());
			pstmt.setString(3, stu.getCsrq());
			pstmt.setString(4, stu.getZy());
			pstmt.setString(5, stu.getKcs());
			pstmt.setString(6, stu.getXqs());
			pstmt.setString(7, stu.getBz());
			pstmt.setInt(8, stu.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public int deleteStu(String ids) {

		try {
			pstmt = conn.prepareStatement("delete from  studentinfo where id in("+ids+")");
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return 0;
	}
}
