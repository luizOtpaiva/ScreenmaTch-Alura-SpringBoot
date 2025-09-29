# Hi! 👋 I'm Luiz, Seja bem Vindo ao meu Projeto!

[![CI Pipeline](https://github.com/luizOtpaiva/ScreenmaTch-Alura-SpringBoot/actions/workflows/ci.yml/badge.svg)](https://github.com/luizOtpaiva/ScreenmaTch-Alura-SpringBoot/actions/workflows/ci.yml)

### 🚀 About Project
- Este projeto trata-se de uma aplicaçao Spring Boot, que usa uma API de filmes, onde usamos packet jackson para poder fazer leitura de arquivos json, assim nas dependencias estao relevantes ao spring framework e packet jackson.
- Assim como a build esta para poder atender com o spring.

- Durante o desenvolvimento, ocorreu um conflito no arquivo ScreenmatchAplication
pois tanto o autor quanto o colaborador modificaram a mesma linha.
O conflito foi resolvido entrando no pull request que deu erro e tirando uma das escolhas feitas pelo colaborador.

### Conflito nos teste 🚀

- Meu colega mudou uma parte do meu codigo, quando fui testar o novo codigo, no caso de ConvertesDados, todos os testes falharam, assim, fui atrás do erro, alterei e coloquei para rodar novamente, assim, arrumando o problema e fazendo todos os testes voltarem a funcionar!

### Screenmatch - Spring Boot
Este repositório contém o projeto Screenmatch, uma aplicação desenvolvida em Java com Spring Boot. O foco principal deste README é detalhar o sistema de Integração Contínua e Entrega Contínua (CI/CD) implementado com GitHub Actions.

🚀 Pipeline de CI/CD

Foi configurado um pipeline automatizado utilizando GitHub Actions para garantir a qualidade e a integridade do código a cada novo commit ou pull request na branch main.

O pipeline é dividido em três estágios principais (jobs) que rodam em sequência:

Test (test): Executa todos os testes unitários da aplicação.

Empacotamento (package): Se os testes passarem, compila o código e gera o pacote .jar da aplicação.

Notificação (notify / notify_failure): Ao final do processo, envia um e-mail informando se o pipeline foi executado com sucesso ou se ocorreu alguma falha



