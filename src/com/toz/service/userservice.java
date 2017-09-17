package com.toz.service;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toz.model.stuInfo;
import com.toz.model.userTable;
public class userservice {
private Connection conn;
private PreparedStatement pstmt;
public userservice(){
	conn=(Connection) new com.toz.conn.conn().getCon();
}
    public boolean valiUser(userTable user){
    	
    	try {
			pstmt= (PreparedStatement) conn.prepareStatement("select * from usertable where username=? and password=?");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
		    ResultSet rs= pstmt.executeQuery();
		    if(rs.next()){
		    	return true;
		    }
		    else
		    	return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    public stuInfo queryStubyID(int id) {
		// List stus = new ArrayList();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement("select * from studentinfo where id=?");
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
			pstmt = (PreparedStatement) conn
					.prepareStatement("update  studentinfo set nicheng=? , truename=? , ,csrq=? ,"
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

	public Boolean deleteStu(int id) {

		try {
			pstmt = (PreparedStatement) conn.prepareStatement("delete from  studentinfo where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}
}
