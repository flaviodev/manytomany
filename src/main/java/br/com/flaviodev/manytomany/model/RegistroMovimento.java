package br.com.flaviodev.manytomany.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_registro_movimento")
public class RegistroMovimento implements Serializable {

	private static final long serialVersionUID = -2875674544565333361L;

		
	@Id
	@Column(name = "id_registro_movimento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "anexo_fk")  // nome da coluna na tabela meio
	private Anexo anexo;
	
	@ManyToOne
	@JoinColumn(name = "correspondencia_fk") // nome da coluna na tabela meio
	private Correspondencia correspondencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Anexo getAnexo() {
		return anexo;
	}

	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}

	public Correspondencia getCorrespondencia() {
		return correspondencia;
	}

	public void setCorrespondencia(Correspondencia correspondencia) {
		this.correspondencia = correspondencia;
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
		RegistroMovimento other = (RegistroMovimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistroMovimento [id=" + id + ", anexo=" + anexo + ", correspondencia=" + correspondencia + "]";
	}


	
	
}
