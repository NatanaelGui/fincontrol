# Roteiro de Estudos Prático

* **Ecossistema Spring e Injeção de Dependências:** Aprenda como o Spring gerencia objetos (*Beans*) e como funciona a Injeção de Dependências (DI) e Inversão de Controle (IoC).
* **Spring Web (APIs REST):** Crie controladores (`@RestController`), receba parâmetros na URL ou no corpo da requisição e devolva respostas padronizadas usando DTOs (*Data Transfer Objects*).
* **Banco de Dados e Spring Data JPA:** Aprenda a conectar sua aplicação a um banco relacional (como PostgreSQL ou MySQL) usando Hibernate e Spring Data JPA. Estude mapeamento de entidades, relacionamentos (`1:N`, `N:N`) e *migrations* com Flyway ou Liquibase.
* **Validação e Tratamento de Exceções:** Use o Bean Validation (`@Valid`) para validar dados de entrada e crie um manipulador global de erros (`@ControllerAdvice`) para devolver mensagens claras quando algo falhar.
* **Segurança Básica:** Estude Spring Security focado em autenticação *stateless* utilizando tokens JWT.
* **Testes Automatizados:** Escreva testes unitários com JUnit 5 e Mockito para validar suas regras de negócio.

---

# Arquitetura Inicial: Sistema de Controle Financeiro (Semana 1)

Para você começar hoje mesmo, aqui está o desenho exato do seu projeto **FinControl API**. Na Semana 1, tudo funcionará em memória (usando `ArrayList`), mas a estrutura de pacotes já segue o padrão de mercado.

## 1. Configuração no `start.spring.io`

* **Project:** Maven | **Language:** Java | **Spring Boot:** 3.4+ (ou a versão estável mais recente)
* **Java:** 21
* **Dependencies:** Spring Web e Spring Validation

## 2. Estrutura de Pacotes

Organize seus arquivos dentro de `src/main/java/com/seuusuario/fincontrol` da seguinte forma:

* **`domain` (ou `model`):** Contém as entidades principais do negócio.
  * `Transacao.java`: Classe com atributos `UUID id`, `String descricao`, `BigDecimal valor`, `TipoTransacao tipo` (Enum: `RECEITA`, `DESPESA`), `String categoria` e `LocalDate data`. *(Dica: nunca use `double` ou `float` para dinheiro em Java, use sempre `BigDecimal`)*.
* **`dto`:** Contém os objetos de transferência de dados (use *Java Records* aqui).
  * `TransacaoRequestDTO.java`: Recebe os dados do cliente (`descricao`, `valor`, `tipo`, `categoria`, `data`).
  * `TransacaoResponseDTO.java`: Devolve os dados formatados para o cliente (incluindo o `id` gerado).
  * `ResumoFinanceiroDTO.java`: Devolve o saldo total, total de receitas e total de despesas.
* **`repository`:** Simula o banco de dados nesta primeira semana.
  * `TransacaoRepository.java`: Anotada com `@Repository`. Terá uma `private final List<Transacao> bancoEmMemoria = new ArrayList<>();` e métodos como `salvar()`, `listarTodas()`, `buscarPorId()` e `deletar()`.
* **`service`:** Contém as regras de negócio.
  * `TransacaoService.java`: Anotada com `@Service`. Recebe o `TransacaoRepository` via construtor (Injeção de Dependência). É aqui que você calcula o saldo ou valida se o valor da transação é maior que zero.
* **`controller`:** Expõe os *endpoints* REST.
  * `TransacaoController.java`: Anotada com `@RestController` e `@RequestMapping("/api/transacoes")`. Recebe o `TransacaoService` via construtor.

## 3. Endpoints para Construir na Semana 1

* `POST /api/transacoes`: Cadastra uma nova receita ou despesa e retorna status `201 Created`.
* `GET /api/transacoes`: Lista todas as transações cadastradas e retorna status `200 OK`.
* `GET /api/transacoes/resumo`: Calcula e retorna o saldo atual (`Receitas - Despesas`).
* `DELETE /api/transacoes/{id}`: Remove uma transação pelo ID e retorna status `204 No Content`.
