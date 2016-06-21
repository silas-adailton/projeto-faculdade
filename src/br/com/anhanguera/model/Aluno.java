package br.com.anhanguera.model;

import java.time.LocalDate;

public class Aluno{

    private int codAluno;

    private int codAtividade;

    private String nome;

    private LocalDate dataNasc;

    private int idade;

    private String rua;

    private String bairro;

    private String cidade;

    private String uf;

    private String tel;

    private String cel;

    private String rg;

    private String cpf;
    
    //Construtores

    public Aluno() {
        
    }

    public Aluno(int codAluno, int codAtividade, String nome, LocalDate dataNasc, int idade, String rua, String bairro, String cidade, String uf, String tel, String cel, String rg, String cpf) {
        this.codAluno = codAluno;
        this.codAtividade = codAtividade;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.idade = idade;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.tel = tel;
        this.cel = cel;
        this.rg = rg;
        this.cpf = cpf;
    }
    
    
    
    //getters e setters

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }   

    

}
