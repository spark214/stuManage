package com.toz.conn;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class conn {
    //1����һ���Ż�����
	public Connection getCon(){
		try{
			//1)����jdbc������
			Class.forName("com.mysql.jdbc.Driver");
			//2)url,user,password
			String url="jdbc:mysql://localhost/jkxystudent?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String password="123456z";
			//3)��ȡ����
			Connection conn=(Connection) DriverManager.getConnection(url, user, password);
			System.out.println(conn.getMetaData().getURL());
			return conn;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public void closeCon(java.sql.Connection con) throws Exception {
		if(con != null) {
			con.close();
		}

	}
}
