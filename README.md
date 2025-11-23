🎯 Gerador de QR Code


🚀 API REST profissional para geração de QR Codes com upload automático na AWS S3 e retorno de URL pública. Construída com Spring Boot 3.4.12 e Java 21, seguindo arquitetura hexagonal e boas práticas de desenvolvimento.


🎯 Sobre o Projeto
Este projeto é uma API REST robusta e escalável desenvolvida para demonstrar habilidades em:

✅ Desenvolvimento de APIs com Spring Boot e boas práticas RESTful <br>
✅ Integração Cloud com serviços AWS (S3) <br>
✅ Arquitetura Limpa seguindo padrão Hexagonal (Ports and Adapters)  <br>
✅ DevOps com containerização Docker  <br> 
✅ Geração de QR Codes usando biblioteca ZXing


💡 Por que este projeto?  <br>
Prático: Resolução de problema real (geração e hospedagem de QR Codes)  <br>
Moderno: Stack atual do mercado (Java 21, Spring Boot 3.x, AWS)  <br>
Escalável: Arquitetura que facilita manutenção e expansão  <br>
Profissional: Código limpo, documentado e testável  <br>
 


✨ Funcionalidades

 📱 Geração de QR Code a partir de texto ou URL  <br>
 ☁️ Upload automático para AWS S3  <br>
 🔗 URL pública para acesso imediato  <br>
 🎨 QR Code personalizável (tamanho, formato)  <br>
 🐳 Docker Ready para deploy rápido  <br>
 🏗️ Arquitetura Hexagonal para fácil manutenção  <br>
 📝 Logs estruturados para monitoramento  <br>
 ⚡ Performance otimizada com processamento assíncrono  <br>


📦 Pré-requisitos
Antes de começar, você precisa ter instalado:  <br>
✅ Java JDK 21 ou superior  <br>
✅ Maven 3.8+  <br>
✅ Docker (opcional, mas recomendado)  <br>
✅ Conta AWS ativa  <br>
✅ Bucket S3 configurado  <br>
✅ AWS CLI configurado (opcional)  <br>

Verificar instalações:
bashjava -version    # Deve mostrar Java 21  <br>
mvn -version     # Deve mostrar Maven 3.8+  <br>
docker --version # Deve mostrar Docker 20+  <br>

🚀 Instalação
1️⃣ Clonar o Repositório <br>
bashgit clone https://github.com/CelsoAntunesNogueira/gerador-qrcode.git  <br>
cd gerador-qrcode  <br>
2️⃣ Configurar application.properties  <br>
Crie ou edite o arquivo em src/main/resources/application.properties:  <br>
properties# Configurações da Aplicação  <br>
spring.application.name=Gerador.Qrcode  <br>
server.port=8080  <br>

# Configurações AWS S3  <br>
aws.s3.region=us-east-1  <br>
aws.s3.bucket-name=seu-bucket-name  <br>

# Configurações do QR Code (opcional)  <br>
qrcode.width=300  <br>
qrcode.height=300  <br>
qrcode.format=PNG  <br>

3️⃣ Configurar Credenciais AWS  <br>
Opção 1: Variáveis de Ambiente (Recomendado)  <br>
bashexport AWS_ACCESS_KEY_ID=sua-access-key-id  <br>
export AWS_SECRET_ACCESS_KEY=sua-secret-access-key  <br>
export AWS_REGION=us-east-1  <br>

Opção 2: AWS CLI Profile  <br>
bashaws configure --profile qrcode  <br>

# Digite suas credenciais quando solicitado
Opção 3: Arquivo .env (Desenvolvimento local)
Crie um arquivo .env na raiz:
AWS_ACCESS_KEY_ID=sua-access-key-id
AWS_SECRET_ACCESS_KEY=sua-secret-access-key
AWS_REGION=us-east-1

⚠️ IMPORTANTE: Nunca commite credenciais no Git! Adicione .env ao .gitignore


🎮 Como Usar
🔨 Build do Projeto
bash# Compilar e gerar o JAR
mvn clean install

# Pular testes (para build mais rápido)
mvn clean install -DskipTests
▶️ Executar Localmente
bash# Modo 1: Via Maven
mvn spring-boot:run

# Modo 2: Via JAR gerado
java -jar target/Gerador.Qrcode-0.0.1-SNAPSHOT.jar

# Modo 3: Com variáveis de ambiente inline  <br>
AWS_ACCESS_KEY_ID=xxx AWS_SECRET_ACCESS_KEY=yyy mvn spring-boot:run  <br>
✅ Aplicação rodando em: http://localhost:8080 ** <br>**

📡 Endpoints da API  <br>
POST /qrcode - Gerar QR Code  <br>
Gera um QR Code, faz upload para S3 e retorna URL pública.  <br>
Request  <br>
bashcurl -X POST http://localhost:8080/qrcode \ <br>
  -H "Content-Type: application/json" \  <br>
  -d '{ <br>
    "text": "https://github.com/CelsoAntunesNogueira"  <br>
  }' <br>
Request Body <br>
json{ <br>
  "text": "string"  // Texto ou URL para gerar o QR Code <br>
} <br>
Response - Sucesso (200)  <br>
json{ <br>
  "url": "https://seu-bucket.s3.us-east-1.amazonaws.com/a7f3b2c1-4d5e-6f7g-8h9i-0j1k2l3m4n5o.png", <br>
  "message": "QR Code gerado com sucesso", <br>
  "timestamp": "2025-01-20T15:30:00Z" <br>
} <br>
Response - Erro (400/500) <br>
json{ <br>
  "error": "Texto não pode ser vazio", <br>
  "status": 400, <br>
  "timestamp": "2025-01-20T15:30:00Z" <br>
} <br>
Exemplos Práticos <br>
bash# Gerar QR Code com URL <br>
curl -X POST http://localhost:8080/qrcode \ <br>
  -H "Content-Type: application/json" \ <br>
  -d '{"text":"https://celso-portfolio.netlify.app"}' <br>
 <br>
# Gerar QR Code com texto <br>
curl -X POST http://localhost:8080/qrcode \ <br>
  -H "Content-Type: application/json" \ <br>
  -d '{"text":"Contato: +55 21 99999-9999"}' <br>
 <br>
# Gerar QR Code com WiFi (formato especial) <br>
curl -X POST http://localhost:8080/qrcode \ <br>
  -H "Content-Type: application/json" \ <br>
  -d '{"text":"WIFI:T:WPA;S:MinhaRede;P:SenhaSegura123;;"}' <br>

## 🏗️ Arquitetura  <br>

### Padrão Hexagonal (Ports and Adapters)
```
📦 src/main/java/app/netlify/celso_portfolio/Gerador/Qrcode/
├── 🎮 controller/          # Camada de apresentação (API REST) <br>
│   └── QrCodeController.java  <br>
│ <br>
├── 📋 dto/                 # Data Transfer Objects  <br>
│   ├── QrCodeRequest.java <br>
│   └── QrCodeResponse.java <br>
│ <br>
├── 🔧 service/             # Lógica de negócio (Use Cases) <br>
│   └── QrCodeService.java <br>
│ <br>
├── 🔌 ports/               # Interfaces (Contratos) <br>
│   ├── QrCodeGeneratorPort.java <br>
│   └── StoragePort.java <br>
│ <br>
└── 🏭 infrastructure/      # Adaptadores (Implementações) <br>
    ├── ZXingQrCodeAdapter.java <br>
    └── S3StorageAdapter.java <br>
``` <br>

### Fluxo de Dados <br>
```
Cliente → Controller → Service → Ports → Infrastructure → AWS S3 <br>
   ↓                                                          ↓ <br>
Request                                                   Upload <br>
   ↓                                                          ↓ <br>
Response ← Controller ← Service ← Ports ← Infrastructure ← URL <br>
Vantagens da Arquitetura <br>
 <br>
✅ Desacoplamento: Lógica de negócio independente de frameworks <br>
✅ Testabilidade: Fácil criar mocks e testes unitários <br>
✅ Manutenibilidade: Mudanças isoladas em camadas específicas <br>
✅ Extensibilidade: Adicionar novos adaptadores sem alterar o core <br>
 <br>

🐳 Docker  <br>
Build da Imagem  <br>
bash# Build básico   <br> 
docker build -t gerador-qrcode .  <br>

# Build com credenciais AWS (build-time)  <br>
docker build -t gerador-qrcode \  <br>
  --build-arg AWS_ACCESS_KEY_ID=sua-key \  <br>
  --build-arg AWS_SECRET_ACCESS_KEY=sua-secret \ <br>
  --build-arg AWS_REGION=us-east-1 . <br>
Executar Container <br>
bash# Rodar com credenciais via variáveis de ambiente (runtime) <br>
docker run -p 8080:8080 \ <br>
  -e AWS_ACCESS_KEY_ID=sua-key \ <br>
  -e AWS_SECRET_ACCESS_KEY=sua-secret \ <br>
  -e AWS_REGION=us-east-1 \ <br>
  gerador-qrcode <br>

# Rodar em background (detached) <br>
docker run -d -p 8080:8080 \ <br>
  --name qrcode-api \ <br>
  -e AWS_ACCESS_KEY_ID=sua-key \ <br>
  -e AWS_SECRET_ACCESS_KEY=sua-secret \ <br>
  gerador-qrcode <br>

# Rodar com arquivo .env <br>
docker run -p 8080:8080 --env-file .env gerador-qrcode <br>
Docker Compose (Recomendado) <br>
Crie um arquivo docker-compose.yml: <br>
yamlversion: '3.8' <br>

services: <br>
  qrcode-api: <br>
    build: . <br>
    ports:  <br>
      - "8080:8080" <br>
    environment:<br>
      - AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID} <br>
      - AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY} <br>
      - AWS_REGION=us-east-1 <br>
    restart: unless-stopped<br>
Executar:<br>
bashdocker-compose up -d<br>

☁️ Configuração AWS S3<br>
1️⃣ Criar Bucket S3<br>
bash# Via AWS CLI<br>
aws s3 mb s3://seu-bucket-qrcode --region us-east-1<br>
<br>
# Ou via Console AWS:<br>
# S3 → Create bucket → Nome único → Região → Create<br>
2️⃣ Configurar Permissões (Acesso Público de Leitura)<br>
Política do Bucket (Bucket Policy):<br>
json{<br>
  "Version": "2012-10-17",<br>
  "Statement": [<br>
    {<br>
      "Sid": "PublicReadGetObject",<br>
      "Effect": "Allow",<br>
      "Principal": "*",<br>
      "Action": "s3:GetObject",<br>
      "Resource": "arn:aws:s3:::seu-bucket-qrcode/*"<br>
    }<br>
  ]<br>
}<br>
Aplicar via CLI:<br>
bashaws s3api put-bucket-policy \<br>
  --bucket seu-bucket-qrcode \<br>
  --policy file://bucket-policy.json<br>
3️⃣ Desbloquear Acesso Público<br>
bashaws s3api put-public-access-block \<br>
  --bucket seu-bucket-qrcode \<br>
  --public-access-block-configuration \<br>
  "BlockPublicAcls=false,IgnorePublicAcls=false,BlockPublicPolicy=false,RestrictPublicBuckets=false"<br>
4️⃣ Configurar CORS (Se necessário)<br>
json[<br>
  {<br>
    "AllowedHeaders": ["*"],<br>
    "AllowedMethods": ["GET", "HEAD"],<br>
    "AllowedOrigins": ["*"],<br>
    "ExposeHeaders": []<br>
  }<br>
]<br>

🧪 Testes<br>
Executar Testes<br>
bash# Todos os testes<br>
mvn test<br>

# Testes com relatório de cobertura<br>
mvn test jacoco:report<br>

# Testes de integração<br>
mvn verify<br>

# Teste específico<br>
mvn test -Dtest=QrCodeServiceTest<br>
```

### Estrutura de Testes<br>
```
src/test/java/<br>
├── controller/<br>
│   └── QrCodeControllerTest.java<br>
├── service/<br>
│   └── QrCodeServiceTest.java<br>
└── infrastructure/<br>
    ├── ZXingQrCodeAdapterTest.java<br>
    └── S3StorageAdapterTest.java<br>

### ✅ Implementado<br>
- [x] Geração básica de QR Code<br>
- [x] Upload para AWS S3<br>
- [x] API REST funcional<br>
- [x] Docker support<br>
- [x] Arquitetura hexagonal<br>

### 🚧 Em Desenvolvimento
- [ ] Testes unitários completos (cobertura 80%+)
- [ ] Testes de integração
- [ ] Documentação Swagger/OpenAPI
- [ ] CI/CD com GitHub Actions

### 🔮 Futuro
- [ ] Autenticação JWT
- [ ] Rate limiting
- [ ] Cache com Redis
- [ ] Personalização avançada de QR Code (cores, logos)
- [ ] Suporte a múltiplos formatos (SVG, PDF)
- [ ] Histórico de QR Codes gerados
- [ ] Dashboard administrativo
- [ ] Métricas e monitoramento (Prometheus/Grafana)
- [ ] Deploy em Kubernetes

---

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! 

### Como Contribuir

1. **Fork** o projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/MinhaFeature`)
3. **Commit** suas mudanças (`git commit -m 'feat: Adiciona nova feature'`)
4. **Push** para a branch (`git push origin feature/MinhaFeature`)
5. Abra um **Pull Request**



⭐ Suporte
Se este projeto foi útil para você, considere dar uma ⭐️ no repositório!
