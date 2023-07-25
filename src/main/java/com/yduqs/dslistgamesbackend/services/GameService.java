package com.yduqs.dslistgamesbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yduqs.dslistgamesbackend.dto.GameDTO;
import com.yduqs.dslistgamesbackend.dto.GameMinDTO;
//import com.yduqs.dslistgamesbackend.dto.GameMinDTO;
import com.yduqs.dslistgamesbackend.entities.Game;
import com.yduqs.dslistgamesbackend.projections.GameMinProjection;
import com.yduqs.dslistgamesbackend.repositories.GameRepository;

@Service	// ou @Component
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();

		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id){
		//Optional<Game> result = gameRepository.findById(id); ou
		Game result = gameRepository.findById(id).get();

		GameDTO dto = new GameDTO(result);
		
		return dto;
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);

		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto;
	}

	//	public List<Game> findAll(){
//		List<Game> result = gameRepository.findAll();
		
//		return result;
//	}
}
