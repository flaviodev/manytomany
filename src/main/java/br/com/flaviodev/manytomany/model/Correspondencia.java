package br.com.flaviodev.manytomany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tab_correspondencia")
public class Correspondencia implements Serializable {

	private static final long serialVersionUID = -2875674544565312161L;
		
	@Id
	@Column(name = "id_correspondencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "text_destinatario")
	private String destinatario;

	//relacionamento utilizando a classe que mapeia a tabela meio
	@OneToMany(mappedBy = "correspondencia") // nome do atributo na entidade da tabela meio	
	private List<RegistroMovimento> registrosMovimentos = new ArrayList<RegistroMovimento>();	
	
	// Mapeando diretamente a tabela anexo usar a entidade da tabela meio
    @ManyToMany(targetEntity = Anexo.class, fetch=FetchType.LAZY)
	@JoinTable(name = "tab_registro_movimento",
	joinColumns = @JoinColumn(name = "correspondencia_fk"), // nome da coluna na tabela meio
	inverseJoinColumns = @JoinColumn(name = "anexo_fk")) 
	private List<Anexo> anexos = new ArrayList<Anexo>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	
	public List<RegistroMovimento> getRegistrosMovimentos() {
		return registrosMovimentos;
	}

	public void setRegistrosMovimentos(List<RegistroMovimento> registrosMovimentos) {
		this.registrosMovimentos = registrosMovimentos;
	}

	
	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Correspondencia other = (Correspondencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Correspondencia [id=" + id + ", destinatario=" + destinatario + "]";
	}
	
}
