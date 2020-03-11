import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowThreadServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			System.out.print("djaklfja");
				DatabaseAccesser dba=new DatabaseAccesser();
				ArrayList ThreadList = new ArrayList();




				//int ThreadID = Integer.parseInt(req.getParameter("ThreadID"));


				ThreadList=dba.getThread();
				

				req.setAttribute("ThreadList",ThreadList);

	            RequestDispatcher Thread=req.getRequestDispatcher("Thread");



				Thread.forward(req,res);

				// Search.forward(req,res);

				// res.sendRedirect("ResponseServlet");






		}

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
			doGet(req, res);
		}
}
