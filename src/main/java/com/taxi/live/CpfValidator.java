package com.taxi.live;

public class CpfValidator {

  private static final int CPF_VALID_LENGTH = 11;
  private static final int FIRST_DIGIT_FACTOR = 10;
  private static final int SECOND_DIGIT_FACTOR = 11;

  public boolean validateCpf(String cpf) {
    cpf = cpf.replaceAll("\\D", "");
    if (cpf.length() != CPF_VALID_LENGTH) {
      return false;
    }
    if (allDigitsTheSame(cpf)) {
      return false;
    }
    int digit1 = calculateDigit(cpf, FIRST_DIGIT_FACTOR);
    int digit2 = calculateDigit(cpf, SECOND_DIGIT_FACTOR);
    return String.format("%d%d", digit1, digit2).equals(extractDigit(cpf));
  }

  private boolean allDigitsTheSame(String cpf) {
    char firstDigit = cpf.charAt(0);
    for (char digit : cpf.toCharArray()) {
      if (digit != firstDigit) {
        return false;
      }
    }
    return true;
  }

  private int calculateDigit(String cpf, int factor) {
    int total = 0;
    for (char digit : cpf.toCharArray()) {
      if (factor > 1) {
        total += Character.getNumericValue(digit) * factor--;
      }
    }
    int remainder = total % 11;
    return (remainder < 2) ? 0 : 11 - remainder;
  }

  private String extractDigit(String cpf) {
    return cpf.substring(9);
  }
}
