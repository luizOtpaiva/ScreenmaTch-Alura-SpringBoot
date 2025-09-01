package b.rcom.exampleAlura.screenmatch;

import b.rcom.exampleAlura.screenmatch.model.DadosSerie;
import b.rcom.exampleAlura.screenmatch.service.ConverteDados;
import b.rcom.exampleAlura.screenmatch.service.IConverteDados;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IConverteDadosTest {

    private final IConverteDados conversor = new ConverteDados();

    @Test
    void deveConverterAnoDeGilmoreGirls() {
        String json = """
            {"Title":"Gilmore Girls","Year":"2000–2007"}
        """;
        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
        assertEquals("2000–2007", serie.ano());
    }

    @Test
    void deveConverterDuracaoDeGilmoreGirls() {
        String json = """
            {"Title":"Gilmore Girls","Runtime":"44 min"}
        """;
        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
        assertEquals("44 min", serie.duracao());
    }
}
