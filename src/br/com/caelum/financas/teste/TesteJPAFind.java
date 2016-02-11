package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPAFind {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();


		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		Conta conta = manager.find(Conta.class, 1);
		System.out.println(conta);

		//o JPA verifica se houve alguma altera��o na entidade e executa um update
		//objeto em estado managed (gerenciavel) sempre sincronizada com o bd
		conta.setTitular("Felipe Leme");

		manager.getTransaction().commit();
		manager.close();

		System.out.println(conta);

		double fim = System.currentTimeMillis();
		System.out.println("Execu��o em: " + (fim - inicio)/1000 + " segundos.");

	}

}
