package com.m2s10.mbean;

import com.m2s10.model.Curso;
import com.m2s10.repository.CursoRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CadastroBean implements Serializable {

    @Inject
    private CursoRepository cursoRepo;

    private Curso curso = new Curso();

    public String salvar() {
        Curso cursoBD = cursoRepo.obterPor(this.curso.getCodigo());
        if (cursoBD == null) {
            cursoRepo.inserir(curso);
        } else {
            cursoRepo.alterar(curso);
        }
        curso = new Curso();
        return "principal?faces-redirect=true";
    }

    public String voltar() {
        this.curso = new Curso();
        return "principal?faces-redirect=true";
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
