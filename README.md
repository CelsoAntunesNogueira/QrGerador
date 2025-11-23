🔲 Gerador de QR Code

Backend para geração de QR Codes com upload automático para AWS S3.

API REST desenvolvida em Spring Boot capaz de gerar QR Codes a partir de qualquer texto, enviar o arquivo diretamente para um bucket S3 e retornar uma URL pública para acesso à imagem.

📋 Sobre o Projeto

Este projeto integra o meu portfólio backend e demonstra domínio prático em:

Construção de APIs REST com Spring Boot

Integração com serviços AWS (S3)

Arquitetura Hexagonal (Ports and Adapters)

Containerização com Docker

Boas práticas na plataforma Java

🚀 Tecnologias Utilizadas

Java 21

Spring Boot 3.4.12

Maven

ZXing (geração de QR Codes)

AWS SDK for Java 2.x

Docker

⚙️ Funcionalidades

Geração de QR Codes a partir de texto

Upload automático para bucket S3

URL pública retornada na resposta

API REST organizada e documentada

Execução via Docker

📦 Pré-requisitos

Java JDK 21

Maven 3.8+

Docker (opcional)

Conta AWS com bucket S3 configurado

🔧 Configuração
1. Clone o repositório
git clone https://github.com/seu-usuario/gerador-qrcode.git
cd gerador-qrcode

2. Configure o application.properties

Crie o arquivo em src/main/resources/:

spring.application.name=Gerador.Qrcode
aws.s3.region=us-east-1
aws.s3.bucket-name=seu-bucket-name

3. Defina as credenciais da AWS
export AWS_ACCESS_KEY_ID=sua-access-key
export AWS_SECRET_ACCESS_KEY=sua-secret-key

▶️ Como Executar
Execução local

Compilar:

mvn clean install


Rodar:

mvn spring-boot:run


Aplicação disponível em:
http://localhost:8080

Execução com Docker

Build da imagem:

docker build -t gerador-qrcode \
--build-arg AWS_ACCESS_KEY_ID=sua-key \
--build-arg AWS_SECRET_ACCESS_KEY=sua-secret .


Executar o container:

docker run -p 8080:8080 gerador-qrcode

📡 Endpoints da API
POST /qrcode

Gera um QR Code a partir de texto.

Request Body:

{
  "text": "https://seusite.com.br"
}


Response:

{
  "url": "https://seu-bucket.s3.us-east-1.amazonaws.com/uuid-gerado.png"
}


Exemplo com cURL:

curl -X POST http://localhost:8080/qrcode \
-H "Content-Type: application/json" \
-d '{"text":"https://github.com/seu-usuario"}'

🏗️ Estrutura do Projeto
src/
├── main/
│   ├── java/
│   │   └── app/netlify/celso_portfolio/Gerador/Qrcode/
│   │       ├── controller/
│   │       │   └── QrCodeController.java
│   │       ├── dto/
│   │       │   ├── QrCodeGenerateRequest.java
│   │       │   └── QrCodeGenerateResponse.java
│   │       ├── service/
│   │       │   └── QrCodeGeneratorService.java
│   │       ├── ports/
│   │       │   └── StoragePort.java
│   │       └── infrastructure/
│   │           └── S3StorageAdapter.java
│   └── resources/
│       └── application.properties
└── test/

Arquitetura

O projeto segue Hexagonal Architecture (Ports and Adapters):

Controller: recebe requisições HTTP

Service: lógica de negócio

Ports: contratos da aplicação

Infrastructure: adaptadores concretos (S3)

DTOs: objetos de transferência de dados

🔐 Configuração do S3

Acesse o console AWS

Crie um bucket

Permita acesso público

Use esta policy:

{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadGetObject",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::seu-bucket-name/*"
    }
  ]
}

🧪 Testes
mvn test

🛠️ Melhorias Futuras

 Testes unitários e de integração

 Autenticação JWT

 Customização visual do QR Code

 Documentação Swagger/OpenAPI

 Cache de QR Codes

 Suporte a outros formatos de imagem

👨‍💻 Autor

Seu Nome

Portfólio: https://celso-portfolio.netlify.app

LinkedIn: seu-linkedin

GitHub: @seu-usuario

📄 Licença

Este projeto está sob a licença MIT.

🙏 Agradecimentos

Fernanda Kipper — inspiração do projeto

ZXing

Comunidade Spring Boot
