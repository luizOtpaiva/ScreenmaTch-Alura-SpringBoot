package b.rcom.exampleAlura.screenmatch.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper(); // para conseguimos converter os dados, no c aso do Jackson
    // mapper é o objeto do jackson que faz a conversao

    @Override // metodo da interface
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);// ele pega do json le, e tenta transformar na classe que a pessoa passou
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


