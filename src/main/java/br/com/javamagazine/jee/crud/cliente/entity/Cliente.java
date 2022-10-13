package br.com.javamagazine.jee.crud.cliente.entity;

import br.com.javamagazine.jee.crud.common.validation.Email;

import java.io.Serializable;
import java.util.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "cliente")
public class Cliente  implements Serializable {

    private static final long serialVersionUID = 7549185160123293775L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50)
    private String nome;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Email
    @Column(unique = true)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cliente_telefone", joinColumns =
    @JoinColumn(name = "id_cliente"))
    private Set<ClienteTelefone> telefones;

    public Cliente() {

    }

    public Cliente(String nome, Date dataNascimento, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }
    public boolean addTelefone(ClienteTelefone clienteTelefone) {
        if (telefones == null) {
            telefones = new HashSet<ClienteTelefone>();
        }
        return telefones.add(clienteTelefone);
    }
    public Set<ClienteTelefone> getTelefones() {
        if (telefones == null) {
            telefones = new HashSet<ClienteTelefone>();
        }
        return telefones;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
