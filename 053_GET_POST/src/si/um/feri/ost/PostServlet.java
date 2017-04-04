package si.um.feri.ost;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/postServlet")
public class PostServlet extends HttpServlet {

	private static final long serialVersionUID = 2880684690475097185L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out=res.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println("	<meta charset='UTF-8'>");
		out.println("	<title>Spletna stran</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("	<h1>Spletna stran</h1>");
		out.println("	Odziv na metodo POST.<br/>");
		out.println("	Parameter ime:");
		out.println(req.getParameter("ime")+"<br/>");
		out.println("	Parameter priimek:");
		out.println(req.getParameter("priimek")+"<br/>");
		out.println("	Parameter spol:");
		out.println(req.getParameter("spol")+"<br/>");
		out.println("	Parameter vrsta:");
		out.println(req.getParameter("vrsta")+"<br/>");
		out.println("	Parameter opombe:");
		out.println(req.getParameter("opombe")+"<br/>");
		
		out.println("</body>");

		out.println("</html>");
	}
	
}
