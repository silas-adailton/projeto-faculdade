package br.com.anhanguera.model;


import java.time.LocalDate;

public class Atividade {

    private int codAtividade;

    private String nome;

    private LocalDate data;

    private String diaSemana;

    private String horaInicio;

    private String horaFim;

    private int codProf;
    
    //Construtores
    
    public Atividade(){
        
    }

    public Atividade(int codAtividade, String nome, LocalDate data, String diaSemana, String horaInicio, String horaFim, int codProf) {
        this.codAtividade = codAtividade;
        this.nome = nome;
        this.data = data;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.codProf = codProf;
    }
    
        
    //getters e setters

    public int getCodAtividade() {
        return codAtividade;
    }

    public void setCodAtividade(int codAtividade) {
        this.codAtividade = codAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public int getCodProf() {
        return codProf;
    }

    public void setCodProf(int codProf) {
        this.codProf = codProf;
    }
    
    

}
