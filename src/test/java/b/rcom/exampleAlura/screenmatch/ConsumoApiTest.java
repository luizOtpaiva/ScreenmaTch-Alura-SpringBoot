package b.rcom.exampleAlura.screenmatch;

import b.rcom.exampleAlura.screenmatch.service.ConsumoApi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConsumoApiTest {

    private final ConsumoApi consumoApi = new ConsumoApi();

    private final String URL_GILMORE = "https://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=6585022c";

    @Test
    void deveObterDadosDeGilmoreGirls() {
        String json = consumoApi.obterDados(URL_GILMORE);
        assertTrue(json.contains("Gilmore Girls"));
    }

    @Test
    void deveConterCampoTotalSeasons() {
        String json = consumoApi.obterDados(URL_GILMORE);
        assertTrue(json.contains("totalSeasons"));
    }

    @Test
    void deveConterCampoImdbRating() {
        String json = consumoApi.obterDados(URL_GILMORE);
        assertTrue(json.contains("imdbRating"));
    }

    @Test
    void deveConterCampoRuntime() {
        String json = consumoApi.obterDados(URL_GILMORE);
        assertFalse(json.contains("Runtime"));
    }

    @Test
    void deveLancarExcecaoParaUrlInvalida() {
        assertThrows(RuntimeException.class,
                () -> consumoApi.obterDados("https://urlinvalida.sem.api"));
    }
}
