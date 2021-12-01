package com.mercadolibre.service;

import com.mercadolibre.exception.CharacterNotAllowedException;

public interface MutantService {

	Boolean isMutant(String dna[]) throws CharacterNotAllowedException;
}
