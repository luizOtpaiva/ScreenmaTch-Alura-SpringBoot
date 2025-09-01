package b.rcom.exampleAlura.screenmatch;

import b.rcom.exampleAlura.screenmatch.model.DadosSerie;
import b.rcom.exampleAlura.screenmatch.service.ConverteDados;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConverteDadosTest {

    private final ConverteDados conversor = new ConverteDados();

    @Test
    void deveConverterJsonDeGilmoreGirls() {
        String json = """
            {"Title":"Gilmore Girls","Year":"2000–2007","Runtime":"44 min","Genre":"Comedy, Drama","imdbRating":"8.2","totalSeasons":7}
        """;
        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
        assertEquals("Gilmore Girls", serie.titulo());
    }

    @Test
    void deveConverterTotalSeasonsCorretamente() {
        String json = """
            {"Title":"Gilmore Girls","totalSeasons":7}
        """;
        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
        assertEquals(7, serie.totalTemporadas());
    }

    @Test
    void deveConverterAvaliacaoCorretamente() {
        String json = """
            {"Title":"Gilmore Girls","imdbRating":"8.2"}
        """;
        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
        assertEquals("8.2", serie.avaliacao());
    }

    @Test
    void deveLancarExcecaoComJsonInvalido() {
        String json = "{Titulo:SemAspas}";
        assertThrows(RuntimeException.class,
                () -> conversor.obterDados(json, DadosSerie.class));
    }

    @Test
    void deveConverterGeneroCorretamente() {
        String json = """
            {"Title":"Gilmore Girls","Genre":"Comedy, Drama"}
        """;
        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
        assertEquals("Comedy, Drama", serie.genero());
    }
}
