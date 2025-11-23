package app.netlify.celso_portfolio.Gerador.Qrcode.service;
import app.netlify.celso_portfolio.Gerador.Qrcode.dto.QrCodeGenerateResponse;
import app.netlify.celso_portfolio.Gerador.Qrcode.ports.StoragePort;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service // Marca como camada de serviço (lógica de negócio)
public class QrCodeGeneratorService {

    //Injeção de Dependência: O Spring automaticamente injeta a implementação de StoragePort (no caso, S3StorageAdapter)
    private final StoragePort storage;

    public QrCodeGeneratorService(StoragePort storage){
        this.storage = storage;
    }
    //Método principal: Recebe um texto, gera o QR Code e faz upload.
    public QrCodeGenerateResponse generateAndUploadQrCode(String text) throws WriterException, IOException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200,200);

        //Converte para imagem PNG:
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngQrCodeData = pngOutputStream.toByteArray();

        String url = storage.uploadFile(pngQrCodeData, UUID.randomUUID().toString(), "image/png");
                return new QrCodeGenerateResponse(url);
    }
}
