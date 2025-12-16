# 🐶 Testes Automatizados da Dog API  
Projeto de automação de testes para a API pública **Dog CEO** utilizando:

- Java 21
- RestAssured  
- JUnit 5  
- Gradle  
- Allure Reports  
- GitHub Actions  

Este projeto segue o padrão **API Object Model**, garantindo organização, escalabilidade e fácil manutenção.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Uso |
|-----------|-----|
| **Java 17** | Linguagem principal |
| **RestAssured** | Requisições HTTP |
| **JUnit 5** | Framework de testes |
| **Gradle** | Build e gerenciamento de dependências |
| **Allure** | Relatórios profissionais |
| **GitHub Actions** | CI/CD |

---

## 📁 Estrutura do Projeto
<img width="325" height="320" alt="image" src="https://github.com/user-attachments/assets/dee8d24c-f4af-4222-b6ba-66e468aebf21" />


---

# 🐶 Como Rodar o Projeto de Testes da Dog API no Windows

Este guia explica passo a passo como executar os testes automatizados da Dog API em um ambiente Windows utilizando **Java + Gradle + RestAssured + JUnit 5 + Allure**.

---

## ✅ 1. Pré-requisitos


### ✔️ Git (opcional, mas recomendado)
https://git-scm.com/downloads

### ✔️ Allure (opcional para abrir relatórios localmente)
Se quiser abrir relatórios Allure no navegador:

1. Instale o **Scoop** (gerenciador de pacotes):
 iwr -useb get.scoop.sh | iex

2. Instale o Allure:
 scoop install allure

---

## ✅ 2. Clonar o repositório

Abra o **PowerShell** ou **CMD** e execute:
git clone https://github.com/RafaelMissio/DogCeoTest.git

## ✅ 3. Executar os testes

No Windows, o comando correto é:

### **PowerShell**
.\gradlew test


### **CMD**
gradlew test

Isso irá:

- Baixar dependências  
- Compilar o projeto  
- Executar todos os testes  
- Gerar relatórios padrão do Gradle  

---
## ✅ 4. Gerar relatório Allure

### Gerar o relatório:
.\gradlew allureReport


### Abrir o relatório no navegador:
.\gradlew allureServe


O Allure abrirá automaticamente no navegador padrão.

---

## ✅ 5. Onde encontrar os relatórios

### Relatório padrão do Gradle:
build/reports/tests/test/index.html


### Resultados do Allure:
build/allure-results/

### Relatório HTML do Allure:
build/reports/allure-report/

---

## ✅ 6. Problemas comuns no Windows

### ❗ Erro: "gradlew não é reconhecido"
Use:
\gradlew test

### ❗ Erro de permissão no PowerShell
Execute:
Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy RemoteSigned

### ❗ Java não encontrado
Verifique:
java -version

---

## 🎉 Pronto!













