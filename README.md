🔲 Gerador de QR Code

Aplicação backend em Spring Boot para gerar QR Codes e armazená-los automaticamente na AWS S3.

<div align="center">


</div>
📋 Sobre o Projeto

Este backend gera QR Codes a partir de texto, envia automaticamente para um bucket AWS S3 e retorna uma URL pública para consumo imediato.
O projeto foi criado como peça de portfólio para demonstrar domínio em:

Desenvolvimento de APIs REST com Spring Boot

Arquitetura Hexagonal (Ports and Adapters)

Integração com AWS S3

Containerização com Docker

Boas práticas em Java moderno

🚀 Tecnologias Utilizadas

Java 21

Spring Boot 3.4.12

Maven

ZXing (Zebra Crossing)

AWS SDK 2.x

Docker

⚙️ Funcionalidades

Gera QR Codes a partir de texto

Upload automático para AWS S3

URL pública pronta para compartilhamento

API REST simples e objetiva

Execução local ou via Docker

📦 Pré-requisitos

Java 21+

Maven 3.8+

Docker (opcional)

Conta AWS com um bucket S3 configurado

🔧 Configuração do Projeto
1. Clone o repositório
git clone https://github.com/seu-usuario/gerador-qrcode.git
cd gerador-qrcode

2. Configure o application.properties

Crie o arquivo em src/main/resources/:

spring.application.name=Gerador.Qrcode
aws.s3.region=us-east-1
aws.s3.bucket-name=seu-bucket-name

3. Configure suas credenciais AWS
export AWS_ACCESS_KEY_ID=sua-access-key
export AWS_SECRET_ACCESS_KEY=sua-secret-key

▶️ Como Executar
Rodar localmente

Compilar:

mvn clean install


Executar:

mvn spring-boot:run


A API estará disponível em:
http://localhost:8080

Rodar com Docker

Build da imagem:

docker build -t gerador-qrcode \
--build-arg AWS_ACCESS_KEY_ID=sua-key \
--build-arg AWS_SECRET_ACCESS_KEY=sua-secret .


Executar container:

docker run -p 8080:8080 gerador-qrcode

📡 Endpoints da API
POST /qrcode

Gera o QR Code e retorna a URL pública do S3.

Body:

{
  "text": "https://seusite.com.br"
}


Resposta:

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
│   │       ├── dto/
│   │       ├── service/
│   │       ├── ports/
│   │       └── infrastructure/
│   └── resources/
└── test/

Arquitetura

O projeto segue Hexagonal Architecture, separando claramente:

Controller — entrada HTTP

Service — regras de negócio

Ports — contratos externos

Adapters — integração S3

DTOs — transporte de dados

🔐 Configuração do Bucket S3

Use a política abaixo para permitir leitura pública:

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

 Customização do QR Code (cor, tamanho, logotipo)

 Documentação Swagger

 Cache de QR Codes

 Suporte a outros formatos (SVG, PDF, WebP)

👨‍💻 Autor

Seu Nome

Portfólio: https://celso-portfolio.netlify.app

LinkedIn: seu-linkedin

GitHub: @seu-usuario

📄 Licença

Distribuído sob licença MIT.

🙏 Agradecimentos

Fernanda Kipper — inspiração na arquitetura

ZXing — motor de QR Code

Comunidade Spring + AWS
