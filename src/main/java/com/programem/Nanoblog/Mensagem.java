package com.programem.Nanoblog;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity /*Indica que o banco de dados deve criar uma tabela para esse objeto*/
public class Mensagem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    String titulo;
    String texto;
    
    //ID
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }

    //TITULO
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }

    //TEXTO
    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return this.texto;
    }
}