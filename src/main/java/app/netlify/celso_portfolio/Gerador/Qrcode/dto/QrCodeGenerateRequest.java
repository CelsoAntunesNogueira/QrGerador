package app.netlify.celso_portfolio.Gerador.Qrcode.dto;

//Record: Tipo especial do Java (desde Java 14) que cria automaticamente:​
//Construtor
//Getters
//equals(), hashCode(), toString()
//É imutável e serve para transportar dados (DTO). Nesse caso, carrega apenas o texto que será convertido em QR Code

public record QrCodeGenerateRequest(String text) {
}
