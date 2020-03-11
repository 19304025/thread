import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.ResponseBean;
import bean.ThreadBean;

public class ResponseServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			DatabaseAccesser dba=new DatabaseAccesser();
			ArrayList ResponseList = new ArrayList();
			TextConversion tc = new TextConversion();

			req.setCharacterEncoding("UTF-8");

			String name=tc.TextReplace(req.getParameter("name"));
			String comments=tc.TextReplace(req.getParameter("comments"));
			String title = req.getParameter("title");
			int ThreadID=Integer.parseInt(req.getParameter("ThreadID"));
			System.out.println(ThreadID);

			dba.InsertResponse(ThreadID,name,comments);
			ResponseList=dba.getResponse(ThreadID);


			// req.setAttribute("threadID",);
			req.setAttribute("Response",ResponseList);
			req.setAttribute("ThreadID",ThreadID);
			req.setAttribute("title",title);

			RequestDispatcher Response=req.getRequestDispatcher("Response");
			// RequestDispatcher threadID=req.getRequestDispatcher("Response");
			// RequestDispatcher Title=req.getRequestDispatcher("Response");

			// threadID.forward(req,res);
			Response.forward(req,res);
			// Title.forward(req,res);

			// res.sendRedirect("ResponseServlet?ThreadID="+ThreadID);





		}
		public  void doGet(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException
		{
			doPost(req,res);
		}
}
