package b.rcom.exampleAlura.screenmatch;

import b.rcom.exampleAlura.screenmatch.model.DadosSerie;
import b.rcom.exampleAlura.screenmatch.service.ConsumoApi;
import b.rcom.exampleAlura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	// CommandRuner permite que executemos alguma ação logo após a inicialização de nossa aplicação
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override // run acaba sendo um metodo main
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi(); // instanciando para poder usar ela
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=3&apikey=6585022c"); // joga esse endereco na variavel json
		System.out.println(json); // chama o endereco da serie, lembrando que esta usando a OMDB que na gratuito tem limites de requests

		// json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json"); // dando um exemplo de uma imagem de cafe
		// System.out.println(json); // chama e depois quando clicar abre uma imagem de cafe aleatoria

		ConverteDados conversor = new ConverteDados(); // isntanciando para poder usar o conversor
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class); // cria para poder representar como um dados serie e passo os valores no conversor
		System.out.println(dados);
	}

}
