# Projeto `Pandemia Simulator`

# Descrição Resumida do Projeto/Jogo

> O Pandemia Simulator consiste em um mapa quadriculado de tamanho variável que representa
uma cidade em um momento de pandemia. O agente principal é o prefeito, que caminha pela cidade a fim
de gerir os recursos necessários para a imunização da população, que é o objetivo principal do jogo. Para
isso, o jogador deve lidar com eventos como o investimento em vacinas, a aglomeração nas casas, a
paralisação das empresas/indústrias e, consequentemente, manejar os recursos monetários necessários
para conter o vírus de maneira que este não contamine a população inteira, que a cidade não colapse
economicamente ou que este não seja destituído por uma aprovação baixa.

# Equipe
* `<Leonardo de Queiroz Borges>` - `<177829>`
* `<Lucas Eduardo Ramos De Oliveira>` - `<182333>`

# Vídeos do Projeto

## Vídeo da Prévia
> [Link para o vídeo](https://drive.google.com/file/d/1Jy8ckKvVrpeEhBOrAJIAfLVy8HdCP8GC/view?usp=sharing)

# Slides do Projeto

## Slides da Prévia
> [Link para os slides](https://drive.google.com/file/d/1ruOlYLg5hwbdd_i3FqVQaLBlXTQcqdt0/view?usp=sharing)

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto

> <Apresente um diagrama geral de organização da organização do seu sistema. O formato é livre. A escolha de um ou mais estilos arquiteturais será considerado um diferencial.>

> <Faça uma breve descrição do diagrama.>

## Diagrama Geral de Componentes

Este é o diagrama compondo os componentes do jogo:

![Diagrama Componentes](assets/diagrama-componentes.png)

## Componente `GameBuilder`

> Esse componente é responsável por gerar os objetos que compõem o fluxo do jogo, solicitar a criação das instituições necessárias na componente City
> de acordo com um arquivo .csv e conectar as interfaces.

![Componente](assets/componente-gamebuilder.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Pacote | `game.gameBuilder`
Autores | `Lucas e Leonardo`
Interfaces | `IRConnectComponents`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

## Detalhamento das Interfaces

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.


## Componente `GameController`

> <Esse componente é responsável por controlar as ações e o fluxo do jogo, contém o Timer e o KeyboardListener.>

![Componente](assets/componente-gamecontroller.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `game.game.gameController`
Autores | `Lucas e Leonardo`
Interfaces | `IConnectComponents` <br>

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

## Detalhamento das Interfaces

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.


## Componente `City`

> <Esse componente é responsavel por guarda o tabuleiro do jogo, contém os controllers de cada instituição.>

![Componente](assets/componente-city.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `game.game.city`
Autores | `Lucas e Leonardo`
Interfaces | `IRPauseTimer` <br> `IActionListener` <br> `IRUpdateBar` <br> `IRUpdateView` <br> `IActionPanel` 

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

## Detalhamento das Interfaces

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.


## Componente `Mayor`

> <Esse componente é responsavel por guardar tudo o que interessa do nosso ator principal, é estudado a parte.>

![Componente](assets/componente-mayor.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `game.game.mayor`
Autores | `Lucas e Leonardo`
Interfaces | `IRMayorAction` <br> `IMove` <br> 

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

## Detalhamento das Interfaces

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.


## Componente `View`

> <Esse componente é responsavel por toda parte gráfica do código, possui um tabuleiro de views especificos, além de um BarView e Prefeito game.view.>

![Componente](assets/componente-view.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `game.game.view`
Autores | `Lucas e Leonardo`
Interfaces | `IUpdateBar` <br> `IUpdateView` <br> `IRActionPanel` <br> `IMayorAction` 

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

## Detalhamento das Interfaces

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.

# Plano de Exceções

## Diagrama da hierarquia de exceções
`O diagrama abaixo mostra a hierarquia do plano de exceções montado para o projeto.`

![Hierarquia Exceções](assets/diagrama-excecoes.png)

## Descrição das classes de exceção

Classe | Descrição
----- | -----
FileRead | Engloba todas as exceções de leitura não aceitas.
FileNotFound | Indica que o arquivo nao foi achado.
InvalidFormat | Indica que o arquivo esta no formato inválido.
IconRead | Engloba todas as exceções de leitura de imagens.
NameRead | Engloba todas as exceções de nomes nao aceitas.
InvalidCharacter | Indica um caracter inválido.
NameTooLong | Indica um nome muito grande.
NullName | Indica um nome vazio.
GameBuilder | Engloba todas as exceções de construção.
InvalidPosition | Indica uma posição inválida.
TwoOnSamePosition | Indica que há a tentativa dois objetos numa posição.
InvalidInstitution | Indica uma instituição inexistente.
InvalidInstitutionQuantity | Indica uma quantidade de instituição inválida.
