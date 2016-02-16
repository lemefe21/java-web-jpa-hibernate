package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaNamedQuery {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		TypedQuery<Double> typedQuery = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);

		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.ENTRADA);

		Double media = typedQuery.getSingleResult();

		System.out.println("Named Query Função Média: " + media);

		manager.close();

	}

}
