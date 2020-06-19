package it.dstech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "allenatore")
public class Allenatore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Digimon> lista;

	public Allenatore() {
	}

	

	protected Allenatore(Long id, String username, List<Digimon> lista) {
		super();
		this.id = id;
		this.username = username;
		this.lista = lista;
	}

 

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Digimon> getLista() {
		return lista;
	}

	public void setLista(List<Digimon> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Allenatore [username=" + username + ", lista=" + lista + "]";
	}

}
