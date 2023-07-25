package com.yduqs.dslistgamesbackend.conttrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yduqs.dslistgamesbackend.dto.GameListDTO;
import com.yduqs.dslistgamesbackend.dto.GameMinDTO;
import com.yduqs.dslistgamesbackend.services.GameListService;
import com.yduqs.dslistgamesbackend.services.GameService;

@RestController
@RequestMapping(value = "/gamelist")
public class GameListConttroller {

	@Autowired
	GameListService gameListService;
	
	@Autowired
	GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAllGameList();
		
		return result;

	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		
		return result;
	}
}