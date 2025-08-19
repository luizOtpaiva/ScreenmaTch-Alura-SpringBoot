package b.rcom.exampleAlura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true) // para poder ignorar aquilo que agente nao pediu aqui em baixo
public record DadosSerie(@JsonAlias({"Title", "Titulo"}) String titulo,// sabemos que ele nao consegue transformar title em titulo direto, por isso usamos
                         @JsonAlias("totalSeasons") Integer totalTemporadas,// JsonAlias para poder mostrar esse 'apelido', caso usamos outra API, poderiamos colocar outro nome para ele poder procurar tambem
                         @JsonAlias("imdbRating") String avaliacao) // // digitar na frente dele o nome certo escrito aonde quer ler
// @JsonProperty("imdbVotes") String votos) { // ele serve tanto para ler o imdbvotes e escever o imdbvotes tambem, diferente do JsonAlias
// {

}
