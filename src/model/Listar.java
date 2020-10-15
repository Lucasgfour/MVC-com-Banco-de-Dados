package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Listar {
	public void executar(HttpServletRequest request, HttpServletResponse response) {
		try {
			CidadeDao cityDao = new CidadeDao();
			String saida = "";
			for (Cidade city : cityDao.listar()) {
				saida = saida + "<tr>\n";
				saida = saida +  "	<td>" + city.getCodibge() + "</td>\n";
				saida = saida +  "	<td>" + city.getCidade() + "</td>\n";
				saida = saida +  "	<td>" + city.getEstado() + "</td>\n";
				saida = saida +  "</tr>\n";
			}
			
			request.setAttribute("cidades", saida);
			
			RequestDispatcher dis = request.getRequestDispatcher("listarcidade.jsp");
			dis.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
