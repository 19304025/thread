import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.ResponseBean;
import bean.ThreadBean;

public class ResponsePrintServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			DatabaseAccesser dba=new DatabaseAccesser();
			ArrayList ResponseList = new ArrayList();

			req.setCharacterEncoding("UTF-8");

			int ThreadID=Integer.parseInt(req.getParameter("ThreadID"));
			String title=dba.getThreadTitle(ThreadID);



			ResponseList=dba.getResponse(ThreadID);


			// req.setAttribute("threadID",);
			req.setAttribute("Response",ResponseList);
			req.setAttribute("ThreadID",ThreadID);
			req.setAttribute("title",title);

			RequestDispatcher Response=req.getRequestDispatcher("Response");
			// RequestDispatcher threadID=req.getRequestDispatcher("Response");
			// RequestDispatcher Title = req.getRequestDispatcher("Response");
			Response.forward(req,res);
			// threadID.forward(req,res);
			// Title.forward(req,res);


			// res.sendRedirect("ResponsePrintServlet?ThreadID="+ThreadID);





		}
		public  void doGet(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException
		{
			doPost(req,res);
		}
}
