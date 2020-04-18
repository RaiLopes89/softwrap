package dao;

import model.FuncionarioModel;
import model.SetorModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import Enum.Cargo;
import Enum.Status;




public class FuncionarioDAO{
	
	Connection conn;
	
	public FuncionarioDAO() {
		try {
			this.conn = ConexaoBD.conectar();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public long inserir(FuncionarioModel funcionario) throws SQLException {
		String sqlInsert = "INSERT INTO funcionario (idfuncionario, nome, cargo, setor, salarioBase, entrada, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stm.setLong(1, funcionario.getId());
			stm.setString(2, funcionario.getNome());
			stm.setString(3, funcionario.getCargo().toString());
			stm.setLong(4, funcionario.getSetor().getId());
			stm.setDouble(5, funcionario.getSalarioBase());
			stm.setDate(6,new java.sql.Date(funcionario.getEntrada().getTime()));
			stm.setString(7, funcionario.getStatus().toString());
			
			stm.execute();
            
			try (ResultSet rs = stm.getGeneratedKeys(); ){
				if(rs.next()) {
					long id = rs.getLong(1);
					return id;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		} catch (Exception e) {
                    conn.rollback();
                    
		}
		return -1;
	}

	public void atualizar(FuncionarioModel funcionario) throws SQLException {
		String sqlUpdate = "UPDATE funcionario SET status=? WHERE idfuncionario = ?";

		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, funcionario.getStatus().toString());
			stm.setLong(2, funcionario.getId());

			stm.execute();
		} catch (Exception e) {
                    conn.rollback();
		}
	}
	public ArrayList<FuncionarioModel> carregarTodos() {
		String sqlSelect = "SELECT idFuncionario, nome, cargo, idSetor, salarioBase, entrada, status FROM funcionario";
		
		ArrayList<FuncionarioModel> funcionarios = new ArrayList<>();
		
		try {
			
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
			
			FuncionarioModel funcionario = new FuncionarioModel();
			SetorModel setor = new SetorModel();
			Cargo cargo;
			Status status;
			
			funcionario.setId(rs.getLong(1));
			funcionario.setNome(rs.getString(2));
			cargo = Cargo.valueOf(rs.getString(3));
			funcionario.setCargo(cargo);
			setor.setId(rs.getLong(4));
			funcionario.setSetor(setor);
			funcionario.setSalarioBase(rs.getDouble(5));
			funcionario.setEntrada(rs.getDate(6));
			status = Status.valueOf(rs.getString(7));
			funcionario.setStatus(status);
			
			
			}
		} catch (SQLException e1) {
			System.out.print(Arrays.toString(e1.getStackTrace()));
		}
		return funcionarios;
	}
}
