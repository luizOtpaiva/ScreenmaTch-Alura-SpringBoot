package b.rcom.exampleAlura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {

    private final ObjectMapper mapper;

    // construtor default → usado na aplicação real
    public ConverteDados() {
        this.mapper = new ObjectMapper();
    }

    // construtor alternativo → usado nos testes com mock
    public ConverteDados(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
