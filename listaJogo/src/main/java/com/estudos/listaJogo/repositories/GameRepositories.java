package com.estudos.listaJogo.repositories;

import com.estudos.listaJogo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepositories extends JpaRepository<Game, Long> { // tipo da entidade e tipo do id
}
