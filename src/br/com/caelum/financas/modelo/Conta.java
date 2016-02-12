package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//mapear a classe Conta
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String numero;
	private String banco;
	private String agencia;

	@OneToMany(mappedBy="conta", fetch=FetchType.LAZY)
	private List<Movimentacao>movimentacoes;
	//O atributo conta na classe Movimentacao representa o lado forte
	//devemos escolher um dos lados para ser o dono da relação e possuir a chave estrangeira
	//nesse caso Movimentacao é a dona do relacionamento
	//mesma relação do atributo conta na classe Movimentacao

	//LAZY recupera todos os dados do relacionamento
	//default fetch=FetchType.LAZY
	//se o comportamento estiver EAGER não é possivel fazer uma consulta LAZY

	public Conta() {
	}
	public Conta(String titular, String numero, String banco, String agencia) {
		this.titular = titular;
		this.numero = numero;
		this.banco = banco;
		this.agencia = agencia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	@Override
	public String toString() {
		return "Conta [id=" + id + ", titular=" + titular + ", numero=" + numero + ", banco=" + banco + ", agencia="
				+ agencia + "]";
	}

}
