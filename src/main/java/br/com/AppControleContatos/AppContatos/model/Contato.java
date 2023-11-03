package br.com.AppControleContatos.AppContatos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Table(name = "Contatos")
public class Contato implements Serializable {

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Contato() {}
    public Contato(String nome, String telefone, Long id) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
