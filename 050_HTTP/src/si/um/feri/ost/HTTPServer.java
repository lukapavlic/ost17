package si.um.feri.ost;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {

	private static int port = 80;

	public static void main(String[] args) throws Exception {

		System.out.println("Registriram strežnik na portu 80.");
		
		ServerSocket serverSocket = new ServerSocket(port);
		Socket clientSocket = serverSocket.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		
		String s=in.readLine();
		System.out.println("Prejeta je bila zahteva");
		while (!"".equals(s)) {
			System.out.println(s);
			s=in.readLine();
		}
 		
		out.println("HTTP/1.1 200 OK");
		out.println("Content-Type: text/html");
		out.println("");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>OJLA!</h1>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Ugašam strežnik.");
		serverSocket.close();
		clientSocket.close();

	}

}
