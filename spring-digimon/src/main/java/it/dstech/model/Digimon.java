package it.dstech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "digimon")
public class Digimon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int hp;
	private int atk;
	private int def;
	private int res;
	private String evoluzione;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Allenatore> lista;

	public Digimon() {
	}

	protected Digimon(Long id, String nome, int hp, int atk, int def, int res, String evoluzione,
			List<Allenatore> lista) {
		super();
		this.id = id;
		this.nome = nome;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.res = res;
		this.evoluzione = evoluzione;
		this.lista = lista;
	}


	public List<Allenatore> getLista() {
		return lista;
	}

	public void setLista(List<Allenatore> lista) {
		this.lista = lista;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getEvoluzione() {
		return evoluzione;
	}

	public void setEvoluzione(String evoluzione) {
		this.evoluzione = evoluzione;
	}
}
