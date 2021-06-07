package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Information;

public class InformationDAO extends DAO {
	public Information search(String login, String password)
	throws Exception {
	Information information=null;
	
	Connection con=getConnection();
	
	PreparedStatement st;
	st=con.prepareStatement("select *from information where login=? and password=?");
	st.setString(1, login);
	st.setString(2, password);
	ResultSet rs=st.executeQuery();
	
	while (rs.next()) {
		information=new Information();
		information.setId(rs.getInt("id"));
		information.setLogin(rs.getString("login"));
		information.setPassword(rs.getString("password"));
	}
	
	st.close();
	con.close();
	return information;
	}

}
