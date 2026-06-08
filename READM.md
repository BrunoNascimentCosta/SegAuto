# 🚗 SegAuto API — Módulo Cliente & Pedidos

O **SegAuto** é uma plataforma inovadora baseada no modelo de economia compartilhada (estilo Uber), focada na **validação, segurança financeira e logística de transporte** de veículos particulares adquiridos entre estados diferentes no Brasil.

Esta API representa o coração do sistema (Back-End), construída com tecnologia de alta escalabilidade para conectar compradores a avaliadores automotivos locais e caminhoneiros de frota de retorno.

## 🛠️ Tecnologias Utilizadas
* **Java 21** & **Spring Boot 3.4.x** (Core da aplicação)
* **Spring Data JPA** & **Hibernate** (Persistência e mapeamento de dados)
* **PostgreSQL** (Banco de dados relacional de produção)
* **Lombok** (Automação de código boilerplate)
* **Padrão DTO (Data Transfer Object)** (Segurança na camada de transporte)

## 🗺️ Arquitetura do Sistema (Escopo Atual)
O projeto está estruturado seguindo as melhores práticas de mercado (Camadas de Responsabilidade):
* `model`: Entidades mapeadas diretamente no PostgreSQL (`Cliente`, `PedidoAvaliacao`).
* `dto`: Objetos de transporte seguro de dados (`ClienteLoginDTO`, `PedidoRequestDTO`).
* `repository`: Interfaces de comunicação direta com o banco de dados.
* `controller`: Endpoints versionados (`/api/v1/...`) que recebem as requisições do App.

## 📡 Endpoints Disponíveis (v1)

### 👤 Clientes
* `POST /api/v1/segauto/clientes/login`: Realiza o cadastro automático ou login do comprador utilizando os dados retornados pela autenticação do Google.

### 📋 Pedidos de Avaliação
* `POST /api/v1/segauto/pedidos`: Recebe o link do anúncio veicular colado pelo cliente, valida a existência do usuário e gera um pedido com status inicial `AGUARDANDO_LANCES`.

## ⚙️ Como Executar o Projeto Localmente
1. Certifique-se de ter o **PostgreSQL** ativo e crie a base de dados: `CREATE DATABASE "db_SegAuto";`
2. Configure suas credenciais locais no arquivo `src/main/resources/application-dev.properties`.
3. Execute o comando na raiz do projeto:
   ```cmd
   mvnw.cmd spring-boot:run
   ```
4. A API estará disponível em `http://localhost:8080`.
