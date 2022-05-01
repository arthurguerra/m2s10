package com.m2s10.repository;

import com.m2s10.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepo {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepo() {
        usuarios.add(new Usuario("admin", "Administrador do Sistema", "admin"));
    }

    public List<Usuario> obter() {
        usuarios.sort(Comparator.comparing(Usuario::getNome));
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> obterPor(String login, String senha) {
        return obter().stream()
                .filter(u -> u.getLogin().equals(login))
                .filter(u -> u.getSenha().equals(senha))
                .findFirst();
    }
}
