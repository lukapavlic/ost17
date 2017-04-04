package si.um.feri.ost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPClient {

	public static void main(String[] args) throws IOException {
		HttpURLConnection con = (HttpURLConnection) new URL("http://www.rtvslo.si").openConnection();
		con.setRequestMethod("GET");
		if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String s;
			while ((s = in.readLine()) != null) {
				System.out.println(s);
			}
			in.close();
		} else {
			System.out.println(con.getResponseCode());
		}
	}

}
