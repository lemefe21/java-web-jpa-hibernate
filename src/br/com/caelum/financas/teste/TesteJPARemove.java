package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARemove {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta("Felipe", "1212", "Banco Ultra", "9988-1");
		conta.setId(2);

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin(); //cuida da transacao

		//quando está como detached não podemos remover, precisa estar managed
		Conta contaARemover = manager.find(Conta.class, 2);

		//JPA executa > select > delete
		manager.remove(contaARemover);

		//o objeto continua na memoria como removed

		manager.getTransaction().commit();
		manager.close();

		double fim = System.currentTimeMillis();
		System.out.println("Execução em: " + (fim - inicio)/1000 + " segundos.");

	}

}
