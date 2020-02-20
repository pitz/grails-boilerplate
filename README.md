#### Boilerplate para projetos Grails 3.3.10

Um simples boilerplate para ser usado em projetos Grails 3.3.10.

#### Banco de dados
Este projeto utiliza o MySQL para conexão com o banco de dados. Para a sua utilização, altere as definições existentes no arquivo `application.yml`

![carbon (17)](https://user-images.githubusercontent.com/42384045/74953722-ca4c5000-53e0-11ea-8a5c-a1736c653bec.png)

#### API-KEY
Para barrar utilizações mal intencionadas na API, um interceptor foi criado. O arquivo `boilerplate.controller.interceptor.BoilerplateInterceptor` contém a lógica mais básica necessária para habilitar uma chave fixa de utilização da API. O arquivo `application.yml` contém a configuração desta chave e pode ser modificada quando você desejar.

![carbon (18)](https://user-images.githubusercontent.com/42384045/74953925-10a1af00-53e1-11ea-8404-f348378e176b.png)

Eu ressalto que não é uma boa prática manter informações sigilosas (informações de base de produção) neste arquivo de configuração. 

#### Como executar
O primeiro passo para executar este projeto é criar um schema no seu banco de dados conforme você configurou as informações de dataSource no arquivo `application.yml`
 
