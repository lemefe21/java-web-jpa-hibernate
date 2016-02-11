package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta("Felipe", "123457", "Banco Real", "9999-1");

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin(); //cuida da transacao

		//at� aqui o objeto conta est� em estado transient
		manager.persist(conta);
		//entidade passa a ser managed pelo m�todo persist
		manager.getTransaction().commit();
		manager.close();

		double fim = System.currentTimeMillis();
		System.out.println("Execu��o em: " + (fim - inicio)/1000 + " segundos.");

	}

}
