package b.rcom.exampleAlura.screenmatch;

import b.rcom.exampleAlura.screenmatch.model.DadosSerie;
import b.rcom.exampleAlura.screenmatch.service.ConverteDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConverteDadosTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ConverteDados conversor;

    @Test
    void deveConverterJsonParaObjeto() throws Exception {
        String json = "{\"Title\":\"Gilmore Girls\",\"totalSeasons\":7}";

        DadosSerie serieMock = new DadosSerie("Gilmore Girls", 7, "8.3", "2000–2007", "44 min", "Comedy, Drama");

        when(objectMapper.readValue(json, DadosSerie.class)).thenReturn(serieMock);

        DadosSerie result = conversor.obterDados(json, DadosSerie.class);

        assertEquals("Gilmore Girls", result.titulo());
        assertEquals(7, result.totalTemporadas());
        verify(objectMapper, times(1)).readValue(json, DadosSerie.class);
    }

    @Test
    void deveLancarExcecaoComJsonInvalido() throws Exception {
        String json = "{Titulo:SemAspas}";

        when(objectMapper.readValue(json, DadosSerie.class))
                .thenThrow(new com.fasterxml.jackson.core.JsonProcessingException("Erro") {});

        assertThrows(RuntimeException.class, () -> conversor.obterDados(json, DadosSerie.class));
    }
}
