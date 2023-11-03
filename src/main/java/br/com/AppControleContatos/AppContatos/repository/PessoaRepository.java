package br.com.AppControleContatos.AppContatos.repository;

import br.com.AppControleContatos.AppContatos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}

