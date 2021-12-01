package com.mercadolibre.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.mercadolibre.exception.CharacterNotAllowedException;

import org.mockito.InjectMocks;

@RunWith(MockitoJUnitRunner.class)
public class MutantServiceImplTest {

	@InjectMocks
	private MutantServiceImpl mutantServiceImpl;

	@Test
	public void shouldGetMutantByHorizontalAndVerticalSequence() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGA", "CGGTGC", "TTGTGT", "AGAAGG", "CCCCTA", "TCACTG" };
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		assertEquals(true, isMutant);
	}

	@Test
	public void shouldGetMutantByHorizontalAndOblicuaSequence() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACGCTA", "AAAATG" };
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		assertEquals(true, isMutant);
	}

	@Test
	public void shouldGetMutantByVerticalAndOblicuaSequence() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGC", "CAGTCC", "TTATGC", "AGAAGC", "ACGCTA", "TCACTG" };
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		assertEquals(true, isMutant);
	}

	@Test
	public void shouldGetMutantByOblicuaAndOblicuaInvertedSequence() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGA", "CCGGCC", "TTGTGT", "AGAAGG", "ACGCTA", "TCACTG" };
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		assertEquals(true, isMutant);
	}

	@Test
	public void shouldGetMutantForAllCases() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		assertEquals(true, isMutant);
	}

	@Test(expected = CharacterNotAllowedException.class)
	public void shouldGetExceptionCharacterNotAllowedException() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGA", "CAGTGK", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		mutantServiceImpl.isMutant(dna);
	}

	@Test
	public void shouldNotMutant() throws CharacterNotAllowedException {
		String[] dna = { "ATGCTA", "CCGTGC", "TTATGT", "AGAAGG", "CACCTA", "TCACTG" };
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		assertEquals(false, isMutant);
	}

	@Test
	public void shouldGetMutantForAllCasesMoreInfo() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGAATGCGA", "CAGTGCCAGTGC", "TTATGTTTATGT", "AGAAGGAGAAGG", "CCCCTACCCCTA", "TCACTGTCACTG",
				"ATGCGAATGCGA", "CAGTGCCAGTGC", "TTATGTTTATGT", "AGAAGGAGAAGG", "CCCCTACCCCTA", "TCACTGTCACTG" };
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		assertEquals(true, isMutant);
	}

	@Test(expected = CharacterNotAllowedException.class)
	public void shouldGetExceptionCharacterNotAllowedExceptionByLength() throws CharacterNotAllowedException {
		String[] dna = { "ATGCGAATGCGA", "CAGTGCCAGTGC", "TTATGTTTATGT", "AGAAGGAGAAG", "CCCCTACCCCTA", "TCACTGTCACTG",
				"ATGCGAATGCGA", "CAGTGCCAGTGC", "TTATGTTTATGT", "AGAAGGAGAAGG", "CCCCTACCCCTA", "TCACTGTCACTG" };
		mutantServiceImpl.isMutant(dna);
	}

}
