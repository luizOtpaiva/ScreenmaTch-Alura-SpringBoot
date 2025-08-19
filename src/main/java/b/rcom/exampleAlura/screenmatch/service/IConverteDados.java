package b.rcom.exampleAlura.screenmatch.service;

public interface IConverteDados { // ele vai obterdados

    <T> T obterDados( String json, Class<T> classe); // isso quer dizer que nao sabemos qual vai ser a entidade devovida, mas alguma coisa
    // com isso tambem passamos uma classe genrica, para ja poder converter sem precisar cirar varias depois de cada dado
}
