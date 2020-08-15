package com.programem.Nanoblog;

public class MensagemLista {
    String mensagemLista (Iterable <Mensagem> lista){
        String html = "";
            for(Mensagem Mensagem : lista){
                html = html +
                "<h1>" + 
                Mensagem.getTitulo() + "</h1>" +
                Mensagem.getTexto() + "<br>" +
                Mensagem.getId() + "<br>" +
                "<br>";
            }
        return html;
    }
}
