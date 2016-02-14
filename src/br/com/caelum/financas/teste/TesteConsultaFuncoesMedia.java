package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoesMedia {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		TypedQuery<Double> typedQuery = manager.createQuery("select avg(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " and m.tipoMovimentacao = :pTipo", Double.class);

		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.ENTRADA);

		//utilizando TypedQuery não é necessário cast para o retorno da consulta
		Double media = typedQuery.getSingleResult();

		System.out.println("Média: " + media);

		manager.close();

	}

}
