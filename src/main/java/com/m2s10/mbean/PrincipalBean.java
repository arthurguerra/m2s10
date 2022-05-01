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
public class PrincipalBean implements Serializable {

    @Inject
    private CursoRepository cursoRepo;

    @Inject
    private CadastroBean cadastroBean;

    private List<Curso> cursos = new ArrayList<>();

    public void onload() {
        this.cursos = cursoRepo.obter();
    }

    public String editar(Curso cursoSelecionado) {
        cadastroBean.setCurso(cursoSelecionado);
        return "cadastro?faces-redirect=true";
    }

    public String remove(Curso curso) {
        cursoRepo.excluir(curso);
        this.cursos = cursoRepo.obterCursos();
        return null;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
