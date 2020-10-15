package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

public class CidadeDao {
	public LinkedList<Cidade> listar() {
		Conexao con = new Conexao();
		LinkedList<Cidade> cidades = new LinkedList<Cidade>();
		try {
			String sql = "SELECT codibge, nome, uf FROM cidade";
			Statement instrucao = con.getConexao().createStatement();
			ResultSet res = instrucao.executeQuery(sql);
			while(res.next()) {
				Cidade a = new Cidade();
				a.setCodibge(res.getInt(1));
				a.setCidade(res.getString(2));
				a.setEstado(res.getString(3));
				cidades.addLast(a);
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return cidades;
	}
}
