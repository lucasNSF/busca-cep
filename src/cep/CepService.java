package cep;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepService {
  
  public ViaCepWS getAddress(String cep, CepValidator validator) throws InvalidCepException {
    if (!validator.validate(cep)) {
      throw new InvalidCepException("Formato de CEP inválido!");
    }
    
    return this.connectCepService(cep);
  }
  
  public ViaCepWS getAddress(String cep) {
    return this.connectCepService(cep);
  }
  
  private ViaCepWS connectCepService(String cep) {
    final String apiKey = "http://viacep.com.br/ws/";
    
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(apiKey + cep + "/json/"))
      .build();
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      String json = response.body();
      Gson gson = new Gson();
      return gson.fromJson(json, ViaCepWS.class);
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
