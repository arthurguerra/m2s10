package com.m2s10.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Curso {

    @NotEmpty(message = "{campo.obrigatorio}")
    private String codigo;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min = 2, max = 100, message = "{campo.invalido.tamanho}")
    private String nome;

    @NotNull(message = "{campo.obrigatorio}")
    private LocalDate dataInicio;

    @NotNull(message = "{campo.obrigatorio}")
    private LocalDate dataFim;

    public Curso() {
    }

    public Curso(String codigo, String nome, LocalDate dataInicio, LocalDate dataFim) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return codigo.equals(curso.codigo) && nome.equals(curso.nome) && Objects.equals(dataInicio, curso.dataInicio) && Objects.equals(dataFim, curso.dataFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, dataInicio, dataFim);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
