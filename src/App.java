import cep.CepService;
import cep.InvalidCepException;
import cep.ViaCepValidator;
import cep.ViaCepWS;

public class App {
  public static void main(String[] args) {
    CepService myCepService = new CepService();

    try {
      ViaCepWS address = myCepService.getAddress("12345678", new ViaCepValidator());
      if (address.cep() == null) {
        System.out.println("Este CEP não existe na base de dados!");
      } else {
        System.out.println(address);
      }
    } catch (InvalidCepException e) {
      System.out.println(e.getMessage());
    }
  }
}
