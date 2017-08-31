package br.com.flaviodev.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.flaviodev.manytomany.model.RegistroMovimento;

public interface RegistroMovimentoRepository extends JpaRepository<RegistroMovimento, Long> {

}
