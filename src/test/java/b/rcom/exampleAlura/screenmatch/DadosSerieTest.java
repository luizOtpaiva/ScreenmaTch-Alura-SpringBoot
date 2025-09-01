package b.rcom.exampleAlura.screenmatch;

import b.rcom.exampleAlura.screenmatch.model.DadosSerie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DadosSerieTest {

    @Test
    void deveCriarDadosSerieCorretamente() {
        DadosSerie serie = new DadosSerie("Gilmore Girls", 7, "8.2", "2000–2007", "44 min", "Comedy, Drama");
        assertEquals("Gilmore Girls", serie.titulo());
        assertEquals(7, serie.totalTemporadas());
        assertEquals("8.2", serie.avaliacao());
    }

    @Test
    void deveRetornarAnoCorreto() {
        DadosSerie serie = new DadosSerie("Gilmore Girls", 7, "8.2", "2000–2007", "44 min", "Comedy, Drama");
        assertEquals("2000–2007", serie.ano());
    }

    @Test
    void deveRetornarGeneroCorreto() {
        DadosSerie serie = new DadosSerie("Gilmore Girls", 7, "8.2", "2000–2007", "44 min", "Comedy, Drama");
        assertEquals("Comedy, Drama", serie.genero());
    }

    @Test
    void deveRetornarDuracaoCorreta() {
        DadosSerie serie = new DadosSerie("Gilmore Girls", 7, "8.2", "2000–2007", "44 min", "Comedy, Drama");
        assertEquals("44 min", serie.duracao());
    }

    @Test
    void deveAceitarValoresNulos() {
        DadosSerie serie = new DadosSerie(null, null, null, null, null, null);
        assertNull(serie.titulo());
        assertNull(serie.totalTemporadas());
    }
}
