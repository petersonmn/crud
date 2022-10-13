package br.com.javamagazine.jee.crud.cliente.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ClienteTelefone implements Serializable {

    private static final long serialVersionUID = 1768448193870878261L;

    @NotNull
    private String telefone;

    @NotNull
    private String descricao;

    public ClienteTelefone() {

    }
    public ClienteTelefone(String telefone, String descricao) {
        this.telefone = telefone;
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
