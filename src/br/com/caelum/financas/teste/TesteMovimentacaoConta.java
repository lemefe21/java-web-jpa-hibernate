package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Movimentacao movimentacao = manager.find(Movimentacao.class, 1);

		//titular da conta da movimenta��o id 1
		System.out.println(movimentacao.getConta().getTitular());

		manager.close();

	}

}
