package si.um.feri.aiv;

import java.util.ArrayList;
import java.util.List;

public class OsebaDao {

	private List<Oseba> seznam=new ArrayList<>();

	public void izbrisi(String email) {
		System.out.println("DAO: brišem "+email);
		Oseba o=najdi(email);
		System.out.println(o);
		if (o!=null) seznam.remove(o);
	}
	
	public Oseba najdi(String email) {
		System.out.println("DAO: išèem "+email);
		if (email==null) return null;
		Oseba ret=null;
		for (Oseba o:seznam)
			if (email.equals(o.getEmail()))
				return o;
		return ret;
	}

	public void spremeni(Oseba o) {
		System.out.println("DAO: speminjam "+o);
		if (o==null) return;
		Oseba os=najdi(o.getEmail());
		if (os==null) return;
		os.setIme(o.getIme());
		os.setPriimek(o.getPriimek());
		os.setEmail(o.getEmail());
	}
	
	public void shrani(Oseba o) {
		System.out.println("DAO: shranjujem "+o);
		seznam.add(o);
	}

	public List<Oseba> vrniVse() {
		System.out.println("DAO: vraèam vse.");
		return seznam;
	}

}