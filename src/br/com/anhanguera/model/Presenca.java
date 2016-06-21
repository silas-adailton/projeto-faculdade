
package br.com.anhanguera.model;


import java.time.LocalDate;


public class Presenca {
    
    private Aluno a;
    private LocalDate data;
    
    //Construtores 
    public Presenca() {
        
    }

    public Presenca(Aluno a, LocalDate data) {
        this.a = a;
        this.data = data;
    }
    
    //getter/setter    
    
    public Aluno getA() {
        return a;
    }

    public void setA(Aluno a) {
        this.a = a;
    }

    public LocalDate getData() {
               
        return data;
    }

    public void setData(LocalDate data) {
        
        this.data = data;
    }
    
    
    
}
