# Desafio DIO: Padrões de Projeto em Java

## Descrição
Este projeto é um exemplo de aplicação em Java que demonstra o uso de padrões de projeto para criar um sistema de pedidos com clientes, endereços e produtos. Ele foi desenvolvido como parte de um desafio do Bootcamp da Digital Innovation One (DIO).

## Funcionalidades
- Cadastro de clientes com nome e endereço.
- Cadastro de produtos com nome e preço.
- Criação de pedidos associando um cliente e uma lista de produtos.
- Cálculo do valor total do pedido com base nos produtos selecionados.

## Padrões de Projeto Utilizados
- **Singleton:** Utilizado na classe `ClienteService` para garantir que haja apenas uma instância da classe `ClienteService` no sistema.
- **Builder:** Utilizado nas classes `Cliente`, `Endereco` e `Produto` para criar objetos complexos de forma fluente.
- **Factory Method:** Utilizado nas classes `Cliente` e `Produto` para criar instâncias de objetos.

## Como Funciona
O sistema permite cadastrar clientes, endereços e produtos. Em seguida, os clientes podem criar pedidos, associando-os a um cliente e a uma lista de produtos. O valor total do pedido é calculado com base nos produtos selecionados.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- H2 Database (para fins de demonstração)

## Executando o Projeto
1. Clone o repositório para a sua máquina.
2. Importe o projeto em sua IDE favorita.
3. Execute a aplicação Spring Boot.
4. Acesse a API por meio dos endpoints disponíveis.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas (issues) e enviar pull requests para melhorar o projeto.

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

