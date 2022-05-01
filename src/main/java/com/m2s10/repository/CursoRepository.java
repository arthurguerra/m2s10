package com.m2s10.repository;

import com.m2s10.model.Curso;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class CursoRepository {

    private List<Curso> cursos = new ArrayList<>();

    public CursoRepository() {
        cursos.add(new Curso("C01", "Curso de Java", LocalDate.of(2023, Month.JANUARY, 1), LocalDate.of(2000, Month.FEBRUARY, 3)));
        cursos.add(new Curso("C02", "Curso de JSF", LocalDate.of(2023, Month.FEBRUARY, 19), LocalDate.of(2000, Month.MARCH, 30)));
        cursos.add(new Curso("C03", "Curso de Primefaces", LocalDate.of(2023, Month.APRIL, 25), LocalDate.of(2000, Month.MAY, 5)));
    }

    public List<Curso> obter() {
        cursos.sort(Comparator.comparing(Curso::getDataInicio));
        return new ArrayList<>(cursos);
    }

    public List<Curso> obterCursos() {
        return cursos;
    }

    public Curso obterPor(String codigo) {
        return cursos.stream()
                .filter(curso -> Objects.equals(curso.getCodigo(), codigo))
                .findFirst()
                .orElse(null);
    }

    public void inserir(Curso curso) {
        cursos.add(curso);
    }

    public void excluir(Curso curso) {
        cursos.remove(curso);
    }

    public void alterar(Curso cursoAlterado) {
        cursos.replaceAll(c -> c.equals(cursoAlterado) ? cursoAlterado : c);
    }
}
