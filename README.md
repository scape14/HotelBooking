# HotelBooking

# Sistema de Reserva de Hotéis

## Descrição

Este projeto implementa um sistema de reserva de hotéis altamente escalável, desenvolvido com Java e Spring Boot, com MySQL como banco de dados. O sistema permite aos usuários pesquisar, comparar e reservar quartos de hotel de forma eficiente e oferece um sistema de notificações para confirmar o processamento de check-in/check-out.

## Funcionalidades

### Pesquisa de Hotéis
- Os usuários podem pesquisar hotéis com base em critérios como:
  - Destino
  - Datas de check-in e check-out
  - Número de quartos
  - Número de hóspedes

### Comparação de Opções
- Os usuários podem comparar diferentes opções de hotéis com base em:
  - Preço
  - Localização
  - Comodidades
  - Avaliações de outros usuários

### Reserva de Quartos
- Os usuários podem:
  - Selecionar um hotel
  - Reservar quartos para as datas desejadas
  - Inserir informações como nome, contato e detalhes do pagamento

### Sistema de Notificações
- O sistema envia notificações para confirmar o processamento de check-in/check-out, com status de confirmação da reserva.

## Requisitos Técnicos

- **Backend**: Java com Spring Boot
- **Banco de Dados**: MySQL
- **Escalabilidade**: O sistema foi projetado para lidar com um grande volume de acessos simultâneos.
- **Persistência de Dados**: Justificativa da escolha do MySQL devido à sua robustez e suporte a operações de leitura e escrita simultâneas.
- **Logs e Métricas**: Implementação de uma estratégia abrangente para monitoramento do desempenho e saúde do sistema.

## Testes

- **Testes Implementados**: Foram realizados testes para garantir a funcionalidade e a robustez do sistema.
- **Possíveis Melhorias**: Ideias para melhorias adicionais incluem otimização de consultas e implementação de cache para melhorar o desempenho, aplicação do Docker para containerização, Redis para Caching: Para resultados de pesquisa e outros dados temporários.
Implementação de uma estratégia abrangente para monitoramento do desempenho e saúde do sistema. Aplicação dos princípios 12 Factor para garantir que o sistema seja escalável e fácil de manter.

## Decisões Arquiteturais

- **Design SOLID**: Aplicado para garantir código limpo e modular.

## Instruções de Deploy e Instalação

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/scape14/HotelBooking.git

    ```

2. **Instale as dependências**:
    ```bash
    cd seu-repositorio
    ./mvnw install
    ```

3. **Configure o banco de dados MySQL**:
    - Crie um banco de dados chamado `hotel_reservation`.
    - Configure as credenciais no arquivo `application.properties`.

4. **Execute a aplicação**:
    ```bash
    ./mvnw spring-boot:run
    ```

## Contato

- **Nome**: João Victor Brito
- **Email**: joaobritocoelho@gmail.com

---

