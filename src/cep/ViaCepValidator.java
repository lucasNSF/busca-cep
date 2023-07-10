package cep;

public class ViaCepValidator implements CepValidator {
  @Override
  public boolean validate(String cep) {
    if (cep.length() != 8 || !cep.matches("\\d+")) {
      return false;
    }
    return true;
  }
}
