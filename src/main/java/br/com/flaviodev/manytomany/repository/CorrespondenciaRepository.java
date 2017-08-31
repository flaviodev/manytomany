package br.com.flaviodev.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flaviodev.manytomany.model.Correspondencia;

public interface CorrespondenciaRepository extends JpaRepository<Correspondencia, Long> {

}
