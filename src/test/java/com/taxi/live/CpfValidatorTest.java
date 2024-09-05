package com.taxi.live;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CpfValidatorTest {

  private final CpfValidator cpfValidator = new CpfValidator();

  @Test
  void shouldValidateCpfWithNonZeroDigit() {
    String cpf = "97456321558";
    boolean isValid = cpfValidator.validateCpf(cpf);
    assertTrue(isValid);
  }

  @Test
  void shouldValidateCpfWithSecondDigitZero() {
    String cpf = "71428793860";
    boolean isValid = cpfValidator.validateCpf(cpf);
    assertTrue(isValid);
  }

  @Test
  void shouldValidateCpfWithFirstDigitZero() {
    String cpf = "87748248800";
    boolean isValid = cpfValidator.validateCpf(cpf);
    assertTrue(isValid);
  }

  @Test
  void shouldNotValidateCpfWithLessThan11Characters() {
    String cpf = "9745632155";
    boolean isValid = cpfValidator.validateCpf(cpf);
    assertFalse(isValid);
  }

  @Test
  void shouldNotValidateCpfWithAllSameDigits() {
    String cpf = "11111111111";
    boolean isValid = cpfValidator.validateCpf(cpf);
    assertFalse(isValid);
  }

  @Test
  void shouldNotValidateCpfWithLetters() {
    String cpf = "97a56321558";
    boolean isValid = cpfValidator.validateCpf(cpf);
    assertFalse(isValid);
  }
}