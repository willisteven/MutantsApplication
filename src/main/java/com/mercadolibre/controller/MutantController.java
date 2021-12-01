package com.mercadolibre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.exception.CharacterNotAllowedException;
import com.mercadolibre.service.MutantService;

@RestController
public class MutantController {

	private final MutantService mutantService;

	@Autowired
	public MutantController(MutantService mutantService) {
		this.mutantService = mutantService;
	}

	@GetMapping
	public ResponseEntity<String> isMutant() {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		try {
			return ResponseEntity.ok(mutantService.isMutant(dna) ? "Es mutante" : "No es mutante");
		} catch (CharacterNotAllowedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());

		}
	}
}
