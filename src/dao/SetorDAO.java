package dao;

import model.SetorModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SetorDAO{
	
	Connection conn;
	
	public SetorDAO() {
		try {
			this.conn = ConexaoBD.conectar();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public long inserir(SetorModel setor) throws SQLException {
		String sqlInsert = "INSERT INTO setor (idSetor, nome, dataDeAbertura) VALUES (?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setLong(1, setor.getId());
			stm.setString(2, setor.getNome());
			stm.setDate(3,new java.sql.Date(setor.getDataDeAbertura().getTime()));
			
			stm.execute();
            
			try(ResultSet rs = stm.getGeneratedKeys(); ){
				if(rs.next()) {
					long id = rs.getLong(1);
					return id;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
                    conn.rollback();
		}
                return -1;
	}
	
	public void atualizar(SetorModel setor) throws SQLException{
		String sqlUpdate = "UPDATE setor SET nome=? WHERE idSetor = ?";
		
		try(PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, setor.getNome());
			stm.setLong(2, setor.getId());
			
			stm.execute();
		}catch(Exception e) {
			conn.rollback();
		}
	}
	
	
	
	public ArrayList<SetorModel> carregarTodos() {
		String sqlSelect = "SELECT idSetor, nome, dataDeAbertura FROM setor";
		
		ArrayList<SetorModel> setores = new ArrayList<>();
		
		try {
			
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
			SetorModel setor = new SetorModel();
			setor.setId(rs.getLong(1));
			setor.setNome(rs.getString(2));
			setor.setDataDeAbertura(rs.getDate(3));
			
			
			}
		} catch (SQLException e1) {
			System.out.print(Arrays.toString(e1.getStackTrace()));
		}
		return setores;
	}
}