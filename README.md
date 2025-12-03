# **Spring Boot Kafka – Produtor e Dois Consumidores**

Este projeto consiste em **três aplicações Spring Boot** integradas ao **Apache Kafka**, sendo:
- **1 aplicação produtora** de mensagens
- **2 aplicações consumidoras**
    
Todas conectadas a um **cluster Kafka com três brokers** e um tópico configurado com **cinco partições** para maior resiliência, escalabilidade e paralelismo.

---

## 🚀 **Funcionalidades**

### ✔️ **Produção de mensagens Kafka**

A aplicação produtora envia mensagens para um tópico Kafka configurado com:
- **5 partições**
- **três brokers** para tolerância a falhas

As duas aplicações consumidoras possuem **group IDs diferentes**, garantindo que:
- **cada mensagem enviada** seja **consumida pelas duas aplicações**, e não apenas por uma delas.

### ✔️ **Resiliência e Alta Disponibilidade**

- Cluster com **3 brokers Kafka**
- Tópico com **5 partições**
- Garantia de replicação, tolerância a falhas e melhor paralelismo.

---

## 🛠️ **Tecnologias Utilizadas**

- **Java 18**
- **Spring Boot**
- **Spring Kafka**
- **Apache Kafka 3.x**
- **Docker & Docker Compose**

---

## 🐳 **Docker**

### ➤ **Construir a imagem do produtor**

`docker build -t meu-usuario/kafka-producer:latest ./producer`

### ➤ **Construir a imagem dos consumidores**

`docker build -t meu-usuario/kafka-consumer1:latest ./consumer1 docker build -t meu-usuario/kafka-consumer2:latest ./consumer2`

### ➤ **Executar via Docker Compose**

O ambiente contendo:
- 3 brokers Kafka
- Producer
- Consumers

pode ser iniciado com:
`docker compose up -d`
