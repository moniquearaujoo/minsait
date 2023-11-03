package br.com.AppControleContatos.AppContatos.Resource;

import br.com.AppControleContatos.AppContatos.service.ContatoService;
import br.com.AppControleContatos.AppContatos.model.Contato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contato")
public class ContatoResource {

    private ContatoService contatoService;

    public ContatoResource(ContatoService contatoService) {

        this.contatoService = contatoService;
    }

    @GetMapping
        public ResponseEntity<List<Contato>> getAll(){
        List<Contato> contato = contatoService.getAll();
        if(contato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id){
        Optional<Contato> contato = contatoService.getById(id);
        if(contato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contato);
    }

    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contato){
        return new ResponseEntity<>(contatoService.save(contato), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Contato> update(@RequestBody Contato contato){
        return new ResponseEntity<>(contatoService.update(contato), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
