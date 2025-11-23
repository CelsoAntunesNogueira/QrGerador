package app.netlify.celso_portfolio.Gerador.Qrcode.controller;

import app.netlify.celso_portfolio.Gerador.Qrcode.dto.QrCodeGenerateRequest;
import app.netlify.celso_portfolio.Gerador.Qrcode.dto.QrCodeGenerateResponse;
import app.netlify.celso_portfolio.Gerador.Qrcode.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Marca como controlador REST (retorna JSON)
@RequestMapping("/qrcode") // Todas as rotas começam com /qrcode

public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeService){
        this.qrCodeGeneratorService = qrCodeService;
    }
    @PostMapping // Recebe requisições POST em /qrcode
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request) {
                                                            //Converte o JSON recebido em objeto QrCodeGenerateRequest.
        try {
            //Lógica principal: Chama o service, gera o QR Code e retorna HTTP 200 (OK) com a resposta.
            QrCodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            //Tratamento de erro: Se algo der errado, retorna HTTP 500 (Internal Server Error).
            return ResponseEntity.internalServerError().build();
        }
    }
}
