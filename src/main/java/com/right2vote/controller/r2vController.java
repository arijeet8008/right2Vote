package com.right2vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.right2vote.exception.instrumentException;
import com.right2vote.model.Instrumnets;
import com.right2vote.service.r2vService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/right2vote")
public class r2vController {

	@Autowired
	private r2vService service;
	
	@PostMapping("/addInfo")
	public ResponseEntity<Instrumnets> addDetailsHandler(@RequestBody @Valid Instrumnets instrumnets) throws instrumentException{
		
		return new ResponseEntity<Instrumnets>(service.addDetails(instrumnets), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteData/{id}")
	public ResponseEntity<Instrumnets> deleteDataHandler(@PathVariable Integer id) throws instrumentException{
		
		Instrumnets instrumnets = service.deleteData(id);
		
		return new ResponseEntity<Instrumnets>(instrumnets, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("")
	public ResponseEntity<String> optimalInstrumentHandler() throws instrumentException{
		
		String str = service.optimalInstruments();
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
		
	}
	
}
