package si.um.feri.ost;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/redirect")
public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 2880684690475097185L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setStatus(302);
		res.setHeader("Location", "http://www.rtvslo.si");
	}
	
}
