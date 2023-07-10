package cep;

public class InvalidCepException extends Exception {
  private String message;
  
  public InvalidCepException(String message) {
    this.message = message;
  }
}
