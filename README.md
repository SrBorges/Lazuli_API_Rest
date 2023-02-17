# Lazuli_API_Rest

![logo](https://user-images.githubusercontent.com/96485637/219801840-976c87dd-093e-43db-9af0-ad27916af748.png)

O Lazuli se trata de uma API Rest para controle de estoque de uma ótica mais voltada para restaurante.
Essa API permite que você cadastre funcionários onde será pedido os dados principais; Logo em seguida vamos poder cadastrar 
os fornecedores no qual tem um vínculo com o restaurante e por fim o controle e a organização do estoque,
onde iremos poder informar p toṕ do produto, sua quantidade seguido do KG ou do Litro. E com auxílio de um enumerador 
informar se é Seco, Congelado ou Resfriado.

# Token

Podemos enviar um Login e uma Senha já registrados no banco de dados para a aplicação
onde ela irá receber e devolver um token que será utilizado para realizar outras ações da 
aplicação. 

![Captura de tela de 2023-02-17 18-27-21](https://user-images.githubusercontent.com/96485637/219803305-b2d749d3-7504-4a87-8792-2f6d1a36b3a3.png)

![Captura de tela de 2023-02-17 18-32-06](https://user-images.githubusercontent.com/96485637/219803653-c231a00f-abf5-4a95-8df6-ccdb62114de0.png)

Caso o token esteja errado ou não seja enviado, a aplicação irá devolver o erro 403.

![Captura de tela de 2023-02-17 18-40-53](https://user-images.githubusercontent.com/96485637/219803979-ae006896-95b4-469e-a17d-6126e00ba19b.png)


O Banco de Dados terá o login e para boa prática a senha esta criptografada, onde a aplicação irá decriptar e ler 
a mesma.

![Captura de tela de 2023-02-17 18-40-36](https://user-images.githubusercontent.com/96485637/219803480-8aba8378-6387-41b8-9628-6cfcfb9297b7.png)

# Funcionalidade

O programa irá retornar o código 201 representando sucesso 

![Captura de tela de 2023-02-17 18-31-28](https://user-images.githubusercontent.com/96485637/219804117-dbc4578b-955f-4ee7-8d48-28db97ed4979.png)


Em seguida podemos ver pela URI o Header indicado o endereço exato da URL.

![Captura de tela de 2023-02-17 18-31-44](https://user-images.githubusercontent.com/96485637/219804260-947694e8-37bd-4cc1-98c7-a52804e43094.png)

Já o Read irá retornar o código 200 por padrão e retornar toda a tabela de cadastros e a paginação.

![Captura de tela de 2023-02-17 18-32-40](https://user-images.githubusercontent.com/96485637/219804853-c4f1664b-3a8b-4463-b55a-fb4433f4bded.png)

No update ele irá retornar a tabela e o que foi alterado nela.

![Captura de tela de 2023-02-17 18-33-19](https://user-images.githubusercontent.com/96485637/219804999-6decb276-92fd-4f0a-a782-e2a2b2cca3ff.png)


O delete irá retornar o código 204 após a ação ser realizada com exito 

![Captura de tela de 2023-02-17 18-34-25](https://user-images.githubusercontent.com/96485637/219805190-2ead82fc-4d8b-4007-a25d-4f9c32b77890.png)

Também foi criado um GET pronto paara ler um Header em especifíco.

![Captura de tela de 2023-02-17 18-34-11](https://user-images.githubusercontent.com/96485637/219805376-5174f860-5c91-430f-946f-6e99690bfb13.png)

# Restição 

Caso você jogue a URL da Api no google, por causa do JWT, ela estará bloqueada e não irá mostrar os dados que foram cadastrados.

![Captura de tela de 2023-02-17 18-33-38](https://user-images.githubusercontent.com/96485637/219805574-40d93518-93de-480b-a8e7-4b2a2ef43599.png)

# Bad Request

Caso você não informe nem um valor ou deixe em branco será retornado o código 400.

![Captura de tela de 2023-02-17 18-38-23](https://user-images.githubusercontent.com/96485637/219808582-d99dcc35-4fdd-4c7f-9940-22bd485eb376.png)

# Insomnia e DBeaver

![Captura de tela de 2023-02-17 18-41-14](https://user-images.githubusercontent.com/96485637/219808873-7149cb7d-7856-4bd5-a819-74f349863fca.png)


![Captura de tela de 2023-02-17 18-42-04](https://user-images.githubusercontent.com/96485637/219808903-ec080a5e-5923-460b-a963-92ae963db74b.png)

# Requisitos

- Spring Boot DevTools
- Lombok
- Spring Web
- Validation
- MySQL Driver
- Flyway Migration
- Spring Data JPA
- Spring Security


