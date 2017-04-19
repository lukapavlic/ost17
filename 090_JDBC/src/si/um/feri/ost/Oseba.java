package si.um.feri.ost;

public class Oseba {

	public Oseba() {
		this("","",0);
	}
	
	public Oseba(String ime, String priimek, int id) {
		this.ime = ime;
		this.priimek = priimek;
		this.id=id;
	}

	private String ime;
	
	private String priimek;
	
	private int id;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ime+" "+priimek+" ("+id+")";
	}
	
}
