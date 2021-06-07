package jp.co.aforce.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Information;
import jp.co.aforce.dao.InformationDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
	
		HttpSession session=request.getSession();
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		InformationDAO dao=new InformationDAO();
		Information information=dao.search(login, password);
		
		if(information!=null) {
			session.setAttribute("information", information);
			return "login-ok.jsp";
		}
		
		return "login.jsp";
		
		
	}
	
	

}
