package com.m2s10.mbean;

import com.m2s10.model.Curso;
import com.m2s10.repository.CursoRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CursoBean implements Serializable {

    @Inject
    private CursoRepository cursoRepo;

    private List<Curso> cursos = new ArrayList<>();

    private Curso curso = new Curso();

    public void onLoad() {
        this.cursos = cursoRepo.obter();
    }

    public String excluir(Curso curso) {
        cursoRepo.excluir(curso);
        return null;
    }

    public String editar(Curso curso) {
        this.curso = curso;
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        boolean novo = cursos.stream().noneMatch(c -> c.equals(curso));
        if (novo) {
            cursoRepo.inserir(curso);
        } else {
            cursoRepo.alterar(curso);
        }
        this.curso = new Curso();
        return "principal?faces-redirect=true";
    }

    public String voltar() {
        this.curso = new Curso();
        return "principal?faces-redirect=true";
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
