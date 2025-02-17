package com.estudos.listaJogo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudos.listaJogo.dto.GameDTO;
import com.estudos.listaJogo.dto.GameMinDTO;
import com.estudos.listaJogo.entities.Game;
import com.estudos.listaJogo.repositories.GameRepositories;;

@Service
public class GameService {
	
	@Autowired
	private GameRepositories gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
  