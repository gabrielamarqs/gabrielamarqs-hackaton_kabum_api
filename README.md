<h1 align="center" >
    Projeto Game.Her: Inclusão e Diversidade no Mundo dos Jogos
</h1>

<p align="center">
<img alt="Last commit on GitHub" src="https://img.shields.io/github/last-commit/gabrielamarqs/hackaton_kabum_api?color=E02041">
<img alt="Project top programing language" src="https://img.shields.io/github/languages/top/gabrielamarqs/hackaton_kabum_api?color=E02041">
</p>

<p align="center" >
  <a href="#sobre-o-projeto" >Sobre o Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#problematica" >Problemática</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#como-executar" >Como executar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#licença" >Licença</a>
</p>


## Sobre o Projeto 
Esse projeto foi desenvolvido tecnicamante por **Gabriela Marques**:[linkedIn](https://www.linkedin.com/in/gabriela-marques-dos-santos-899092161/)-[github](https://github.com/gabrielamarqs), **Mayara Spieker**:[linkedIn](https://www.linkedin.com/in/mayara-spieker/)-[github](https://github.com/mayspiek) e **Eliana Almeida**:[linkedIn](https://www.linkedin.com/in/elianaalmeida/)-[github](https://github.com/Eliana100) como uma solução para o hackaton .

A Designer responsável pelas interfaces foi a **Malu Gurgel**:[linkedIn](https://www.linkedin.com/in/malu-gurgel-66456a265). E a reponsável pelo Marketing é a **Rebeca Alves**-[linkedIn](https://www.linkedin.com/in/rebeca-alves-mendes-060990195/).

## Problematica:
A Pesquisa Game Brasil (PGB) 2021 revelou que 51,5% dos gamers no Brasil são mulheres. No entanto, não se fala muito sobre o cenário feminino nos campeonatos e eventos de game player. A pesquisa feita pelas desenvolvedoras do projeto em 2024 contou com 50 entrevistadas e constatou que a principal queixa é a falta de representatividade feminina, o que desmotiva e invisibiliza as jogadoras. Além disso, a descentralização das informações dificulta o acesso a oportunidades e recursos, isolando ainda mais as mulheres.
#### Solução:
Para mudar esse quadro, a plataforma Game.Her surgiu para promover eventos mais inclusivos e centralizar as informações, facilitando o acesso das jogadoras a tudo que a indústria oferece. Essas ações não só promoverão a igualdade, mas também trarão mais inovação e diversidade para o mundo dos games.
#### Objetivos: (Metas e Impacto)
Promoção da visibilidade do cenário competitivo feminino nos jogos online, com incentivo a participação de novas jogadoras e streamers.
Centralização das informações sobre os eventos femininos;
Oferta de oportunidades para patrocinadores e organizadores se conectarem com um público engajado para expandir o cenário gamer.


### Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Java](https://java.org/)
- [PostgresSQL](https://www.postgresql.com/)
- [SpringBoot](https://springboot.com/)

## Como executar
### Dependências necessárias

#### Para o backend
Para executar essa aplicação é necessário que tenha o JRE 17 instalado na sua máquina.

### Executando o backend
  **1.** Clone esse repositório para extrair o .jar 
  ```bash
  # instale o JRE versão 17
  sudo apt update
  sudo apt install openjdk-17-jdk

  # clone o repositório
  git clone https://github.com/gabrielamarqs/hackaton_kabum_api.git

  # entre na pasta hackaton_api_kabum
  cd hackaton_api_kabum

  # Instale o Maven, se ainda não estiver instalado
  sudo apt install -y maven
  
  # Execute o comando para construir o projeto e extrair o .jar, pulando os testes
  mvn package -Dmaven.test.skip=true

  # execute o .jar
  java -jar target/HackatonKabum-0.0.1-SNAPSHOT.jar &
  ```

  ***OBS:*** Por padrão o backend será executado na porta `8080` da sua máquina, ou seja, em `http://localhost:8080` ou `http://ip_local_da_sua_maquina:3333`, se por ventura essa porta estiver indisponível, siga os seguintes passos:
  
  **1.** Acesse o terminal (se for um ambiente linux)
  ```bash 
  sudo lsof -i :8080
  ```

  **2.** O output desse comando vai ser:
  ```bash
    COMMAND     PID 
    java    1222447 
  ```

  **3.** Para finalizar o processo, tem que executar um comando kill com o pid do processo que está executando naquela porta:
  ```bash
    kill 1222447 
  ```

  ***OBS:*** Para realizar login na plataforma, um usuário de teste está cadastrado como os seguintes dados: `email:teste@teste.com e senha: teste123`, ou se preferir, crie um cadastro de usuário próprio ;).
  ***OBS:*** Lembre-se de manter o backend rodando quando utilizar o frontend, caso contrário, as solicitações à API não poderão ser efetivadas.

  ## Licença
  Esse projeto está sob a propriedade intelectual da Kabum.

  
