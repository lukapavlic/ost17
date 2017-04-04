package si.um.feri.ost;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/seja")
public class SejaDemo extends HttpServlet {

	private static final long serialVersionUID = 2880684690475097185L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out=res.getWriter();
		HttpSession session=req.getSession();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println("	<meta charset='UTF-8'>");
		out.println("	<title>Spletna stran</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("	<h1>Spletna stran</h1>");
		out.println("	Odziv na metodo GET.<br/>");
		out.println("	Identifikator seje:");
		out.println(session.getId()+"<br/>");
		out.println("	Trenutna vrednost A iz seje:");
		out.println(session.getAttribute("A")+"<br/>");
		
		if (req.getParameter("A")!=null) {
			out.println("	Spreminjam vrednost A na:");
			out.println(req.getParameter("A")+"<br/>");
			
			session.setAttribute("A", req.getParameter("A"));
		}
		
		out.println("</body>");

		out.println("</html>");

	}
	
}
