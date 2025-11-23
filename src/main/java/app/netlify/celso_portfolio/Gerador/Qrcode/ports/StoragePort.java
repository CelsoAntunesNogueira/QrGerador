package app.netlify.celso_portfolio.Gerador.Qrcode.ports;

//Interface (Porta): Define um "contrato" - qualquer classe que implementar deve ter esse método.
//Isso permite trocar a implementação facilmente (hoje é S3, amanhã pode ser Google Cloud Storage).

public interface StoragePort {

    String uploadFile(byte[] fileData,String fileName, String contentType);
}
