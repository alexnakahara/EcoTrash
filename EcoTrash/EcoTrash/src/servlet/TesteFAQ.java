package servlet;

import beans.Pergunta;
import dao.PerguntaDAO;

public class TesteFAQ {
	public static void main(String [] args){
		Pergunta p = new Pergunta(1, "teste", "teste", "teste");
		PerguntaDAO.criar(p);
		
	}
}
