package si.um.feri.ost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OsebaDao {

	/*
	 * Podatkovna baza:
	 * create database ost;
	 * use ost;
	 * 
	 * Podatkovna tabela:
	 * create table oseba(id int auto_increment, ime varchar(255), priimek varchar(255), primary key (id));
	 * */
	
	private Connection getConnection() {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/ost_baza");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Oseba> select() throws Exception {
		List<Oseba> ret=new ArrayList<Oseba>();
		Connection conn=getConnection();
		try {
			
			ResultSet rs=conn.createStatement().executeQuery("select * from oseba");
			while (rs.next()) {
				Oseba o=new Oseba(rs.getString("ime"),rs.getString("priimek"),rs.getInt("id"));
				ret.add(o);
			}
			rs.close();
			
		} finally {
			conn.close();
		}
		return ret;
	}
	
	public Oseba select(int id) throws Exception {
		Oseba ret=null;
		Connection conn=getConnection();
		try {
			
			PreparedStatement ps=conn.prepareStatement("select * from oseba where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ret=new Oseba(rs.getString("ime"),rs.getString("priimek"),rs.getInt("id"));
				break;
			}
			rs.close();
			
		} finally {
			conn.close();
		}
		return ret;
	}
	
	public void delete(int id) throws Exception {
		Connection conn=getConnection();
		try {

			PreparedStatement ps=conn.prepareStatement("delete from oseba where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} finally {
			conn.close();
		}
	}
	
	public void insert(Oseba o) throws Exception {
		Connection conn=getConnection();
		try {

			PreparedStatement ps=conn.prepareStatement("insert into oseba(ime , priimek) values (?,?)");
			ps.setString(1, o.getIme());
			ps.setString(2, o.getPriimek());
			ps.executeUpdate();

		} finally {
			conn.close();
		}
	}
	
}
