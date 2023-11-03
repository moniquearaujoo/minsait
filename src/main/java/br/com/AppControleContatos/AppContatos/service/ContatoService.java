package br.com.AppControleContatos.AppContatos.service;

import br.com.AppControleContatos.AppContatos.model.Contato;
import br.com.AppControleContatos.AppContatos.repository.ContatoRepository;
import br.com.AppControleContatos.AppContatos.service.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService implements ContatoServiceInterface {

    private ContatoRepository contatoRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Contato> getById(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public List<Contato> getAll() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato update(Contato contato) {
        Optional<Contato> upContato = contatoRepository.findById(contato.getId());

        if(upContato.isPresent()) {
            Contato newContato = upContato.get();
            newContato.setId(contato.getId());
            newContato.setNome(contato.getNome());
            newContato.setTelefone(contato.getTelefone());
            newContato.setPessoa(contato.getPessoa());
            return contatoRepository.save(newContato);
        }
        return contato;
    }

    @Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }

}
