import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.ResponseBean;
import bean.ThreadBean;


public class ThreadServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			System.out.print("djaklfja");
			req.setCharacterEncoding("UTF-8");
				DatabaseAccesser dba=new DatabaseAccesser();
				ArrayList ResponseList = new ArrayList();
				TextConversion tc=new TextConversion();




				String name=tc.TextReplace(req.getParameter("name"));
				String title=tc.TextReplace(req.getParameter("title"));
				String comments=tc.TextReplace(req.getParameter("comments"));




				//int ThreadID = Integer.parseInt(req.getParameter("ThreadID"));

				dba.InsertThread(title,name);
				int ThreadID=dba.lastThreadID();

				dba.InsertResponse(ThreadID,name,comments);

				ResponseList=dba.getResponse(ThreadID);
				System.out.println(ThreadID);


				req.setAttribute("Response",ResponseList);
				req.setAttribute("ThreadID",ThreadID);
				req.setAttribute("title",title);

	            // RequestDispatcher Thread=req.getRequestDispatcher("index");

				RequestDispatcher Response=req.getRequestDispatcher("Response");
				// RequestDispatcher threadID=req.getRequestDispatcher("Response");
				// RequestDispatcher Title = req.getRequestDispatcher("Response");


				Response.forward(req,res);
				// threadID.forward(req,res);
				// Title.forward(req,res);

				// res.sendRedirect("Response");
				// Search.forward(req,res);

				// res.sendRedirect("ResponseServlet");






		}

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
			doGet(req, res);
		}
}
