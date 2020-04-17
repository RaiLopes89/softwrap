package br.softwrap.dao;

import br.com.softwrap.model;

import java.sql.*;
import java.util.Arrays;


public class FuncionarioDAO extends Funcionario{
	public Boolean inserir(Connection conn) throws SQLException {
		String sqlInsert = "INSERT INTO funcionario (id, nome, cargo, setor, salarioBase, entrada, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setLong(1, id);
			stm.setString(2, nome);
			stm.setEnum(3, cargo);
			stm.setSetorModel(4, setor);
			stm.setDouble(5, salarioBase);
			stm.setDate(6, entrada, cal);
			stm.setEnum(7, status);
			
			stm.execute();
                        return true;
		} catch (Exception e) {
                    conn.rollback();
		}
                return false;
	}

	public void atualizar(Connection conn) throws SQLException {
		String sqlUpdate = "UPDATE funcionario SET status=? WHERE id = ?";

		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setEnum(1, getStatus());
			stm.setInt(4, getId());

			stm.execute();
		} catch (Exception e) {
                    conn.rollback();
		}
	}
	public void carregarTodos(Connection conn) {
		String sqlSelect = "SELECT nome FROM funcionario";

		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
				} else {
					setNome(null);
					setTelefone(null);
				}

			} catch (Exception e) {
			}
		} catch (SQLException e1) {
			System.out.print(Arrays.toString(e1.getStackTrace()));
		}
	}
}
