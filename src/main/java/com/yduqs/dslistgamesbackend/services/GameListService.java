package com.yduqs.dslistgamesbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yduqs.dslistgamesbackend.dto.GameListDTO;
import com.yduqs.dslistgamesbackend.entities.GameList;
import com.yduqs.dslistgamesbackend.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAllGameList(){
		List<GameList> result = gameListRepository.findAll();
		
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		
		return dto;
	}
}
