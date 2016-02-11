package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {

	public static void main(String[] args) {

		//JPQL
		//Java Persistence Query Language

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(2);

		//Seleciona todas as movimentações da conta com id = 2, tipo saida e order por valor

		//Positional parameter notation
		//Query query = manager.createQuery("select m from Movimentacao m where m.conta = ?1");
		//query.setParameter(1, conta);

		//Named parameter notation
		Query query = manager.createQuery("select m from Movimentacao m where m.conta = :pConta"
				+ " and m.tipoMovimentacao = :pTipo order by m.valor desc");

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println(movimentacao);
		}

	}

}
