package br.com.AppControleContatos.AppContatos.service.interfaces;

import br.com.AppControleContatos.AppContatos.model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {
    Contato save(Contato contato);
    Optional<Contato> getById(Long id);
    List<Contato> getAll();
    Contato update(Contato contato);
    void delete(Long id);
}

