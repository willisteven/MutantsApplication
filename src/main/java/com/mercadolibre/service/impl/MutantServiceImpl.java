package com.mercadolibre.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mercadolibre.exception.CharacterNotAllowedException;
import com.mercadolibre.service.MutantService;

@Service
public class MutantServiceImpl implements MutantService {

	private int countSequence = 0;
	private static final int MUTANT_SEQUENCE_RESTRICTION = 1;

	@Override
	public Boolean isMutant(String dna[]) throws CharacterNotAllowedException {
		validateAdn(dna);
		char matrizAdn[][] = createTableAdn(dna);
		isMutantByHorizontalSequence(matrizAdn);
		isMutantByVerticalSequence(matrizAdn);
		isMutantByObliqueSequence(matrizAdn);
		isMutantByObliqueInvertedSequence(matrizAdn);
		return countSequence > MUTANT_SEQUENCE_RESTRICTION ? true : false;
	}

	private void validateAdn(String dna[]) throws CharacterNotAllowedException {
		for (String dnaValue : dna) {
			long count = dnaValue.chars().filter(ch -> ch == 'A' || ch == 'T' || ch == 'C' || ch == 'G').count();

			if (dnaValue.chars().count() != dna.length) {
				throw new CharacterNotAllowedException(
						"La longitud de la cadena debe ser igual a la cantidad de registros");
			}
			if (dnaValue.length() != count) {
				throw new CharacterNotAllowedException("No se permiten letras diferentes de A,T,C,G");
			}
		}
	}

	private char[][] createTableAdn(String[] dna) {
		char matrizAdn[][] = new char[dna.length][dna.length];
		for (int x = 0; x < dna.length; x++) {
			for (int y = 0; y < matrizAdn[x].length; y++) {
				matrizAdn[x][y] = dna[x].charAt(y);
			}
		}
		return matrizAdn;
	}

	private void isMutantByHorizontalSequence(char dna[][]) {
		for (int i = 0; i < dna.length; i++) {
			for (int j = 0; j < dna[0].length - 3; j++) {
				if (dna[i][j] == dna[i][j + 1] && dna[i][j] == dna[i][j + 2] && dna[i][j] == dna[i][j + 3]) {
					countSequence++;
				}
			}
		}
	}

	private void isMutantByVerticalSequence(char matriz[][]) {
		for (int j = 0; j < matriz.length; j++) {
			for (int i = 0; i < matriz[0].length - 3; i++) {
				if (matriz[i][j] == matriz[i + 1][j] && matriz[i][j] == matriz[i + 2][j]
						&& matriz[i][j] == matriz[i + 3][j]) {
					countSequence++;
				}
			}
		}
	}

	private void isMutantByObliqueSequence(char matriz[][]) {
		for (int i = 0; i < matriz[0].length - 3; i++) {
			for (int j = 0; j < matriz[0].length - 3; j++) {
				if (matriz[i][j] == matriz[i + 1][j + 1] && matriz[i][j] == matriz[i + 2][j + 2]
						&& matriz[i][j] == matriz[i + 3][j + 3]) {
					countSequence++;
				}
			}
		}
	}

	private void isMutantByObliqueInvertedSequence(char matriz[][]) {
		for (int i = 0; i < matriz[0].length - 3; i++) {
			for (int j = matriz[0].length - 1; j >= matriz[0].length - 3; j--) {
				if (matriz[i][j] == matriz[i + 1][j - 1] && matriz[i][j] == matriz[i + 2][j - 2]
						&& matriz[i][j] == matriz[i + 3][j - 3]) {
					countSequence++;
				}
			}
		}
	}
}
