package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaTitular {

	public static void main(String[] args) {

		//JPQL
		//Java Persistence Query Language

		EntityManager manager = new JPAUtil().getEntityManager();

		Query query = manager.createQuery("select m from Movimentacao m where m.conta.titular like :pTitular"
				+ " and m.tipoMovimentacao = 'SAIDA'");

		query.setParameter("pTitular", "Maria dos Santos");

		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println(movimentacao);
		}

		manager.close();
	}

}
