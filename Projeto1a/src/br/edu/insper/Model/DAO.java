package br.edu.insper.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// nao esquece de coloca a senha!!!!!!!!
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto1" , "root" ,"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void postUser(User user) {
		
		String sql = "INSERT INTO login (login, password) values(?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User getUser(String login) {
		User user = new User();
		String sql = "SELECT * FROM login WHERE login=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setLogin(null);
		return user;
		
	}
	
	
	public void postNotas(Notas notinhas) {
		
		String sql = "INSERT INTO notas (pessoa, titulo_nota, notas) values(?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(2, notinhas.getTitulo());
			stmt.setString(3, notinhas.getNotas());
			stmt.setString(1, notinhas.getUser());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public User getNotas(String login) {
		// PRECISO ARRUMAR E COLOCAR PRA GET NOTAS
		User user = new User();
		String sql = "SELECT * FROM login WHERE login=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setLogin(null);
		return user;
		
	}
	
public void editarNotas(Notas notinhas) {
		
		String sql = "UPDATE notas SET titulo_nota=?, notas=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, notinhas.getTitulo());
			stmt.setString(2, notinhas.getNotas());
			stmt.setInt(3, notinhas.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public void deletarNotas(Integer id) throws SQLException {
		
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM notas WHERE id=?");
		stmt.setInt(1, id);

		stmt.execute();
		stmt.close();
		
	}
	
	public List<Notas> getLista(String user) throws SQLException{
		List<Notas> notas = new ArrayList<Notas>();
		
		PreparedStatement stmt = connection.
				 prepareStatement("SELECT * FROM notas WHERE pessoa = ?");
		stmt.setString(1, user);
		ResultSet rs = stmt.executeQuery();
				
		while (rs.next()) {
				Notas nota = new Notas();
				nota.setUser(rs.getString("pessoa"));
				nota.setTitulo(rs.getString("titulo_nota"));
				nota.setNotas(rs.getString("notas"));
				nota.setId(rs.getInt("id"));
				notas.add(nota);
				}
				rs.close();
				stmt.close();
				return notas;
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
