package br.com.flaviodev.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flaviodev.manytomany.model.Anexo;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {

}
