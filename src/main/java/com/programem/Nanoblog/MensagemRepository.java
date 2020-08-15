package com.programem.Nanoblog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MensagemRepository extends CrudRepository<Mensagem, Integer> {
    
    @Query(
    value = "SELECT * FROM mensagem Mensagem WHERE Mensagem.texto >= :texto", 
    nativeQuery = true)
    Iterable<Mensagem> findMensagem(@Param("texto")Integer id);

}
