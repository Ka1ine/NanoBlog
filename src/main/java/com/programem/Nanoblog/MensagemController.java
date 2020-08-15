package com.programem.Nanoblog;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Mensagem")
public class MensagemController {
    
    @Autowired
    private MensagemRepository MensagemRepository;
    private MensagemLista MensagemLista = new MensagemLista();

    @GetMapping("/")
    
    public String MensagemForm(){
        return "MensagemForm";
    }

    @PostMapping(path="/MensagemInsere") 
    
    public @ResponseBody String addNewMensagem (@RequestParam String titulo, @RequestParam String texto, @RequestParam Integer id)
    {
      Mensagem Mensagem = new Mensagem();
      Mensagem.setTitulo(titulo);
      Mensagem.setTexto(texto);
      Mensagem.setId(id);
      MensagemRepository.save(Mensagem);
      return titulo + " " + texto + " " + id;
    } 
    
    //LISTA
    @GetMapping(path="/MensagemLista")
    
    public @ResponseBody String getAllMensagem() {
        Iterable <Mensagem> resultado = MensagemRepository.findAll();
        return MensagemLista.mensagemLista(resultado);
    }

    //UPDATE
    @GetMapping(path="/MensagemUpdate")
    
    public String MensagemUpdateForm(){
        return "MensagemUpdate";
    } 

    @PostMapping(path="/Update")
    
    public @ResponseBody String MensagemUpdate(@RequestParam String texto,@RequestParam Integer id){
        Optional <Mensagem> o = MensagemRepository.findById(id);
            if(o.isPresent()){
                Mensagem Mensagem = o.get();
                Mensagem.setTexto(texto);
                MensagemRepository.save(Mensagem);
            }
        return "MensagemUpdate";
    } 
   
    //DELETE
    @GetMapping(path="/MensagemDelete")

    public String MensagemDelete() {
        return "MensagemDelete";
    } 

    @PostMapping(path="/Delete")
   
    public @ResponseBody String MensagemDelete(@RequestParam Integer id){
        MensagemRepository.deleteById(id);
        return "MensagemUpdate";
    } 
}

