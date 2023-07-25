package com.yduqs.dslistgamesbackend.conttrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yduqs.dslistgamesbackend.dto.GameDTO;
import com.yduqs.dslistgamesbackend.dto.GameMinDTO;
import com.yduqs.dslistgamesbackend.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameConttroller {
	
	@Autowired
	GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		
		return result;
	}

	@GetMapping(value= "/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		
		return result;
	}
}