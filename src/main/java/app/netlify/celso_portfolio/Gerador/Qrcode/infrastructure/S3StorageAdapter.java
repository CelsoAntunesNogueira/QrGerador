package app.netlify.celso_portfolio.Gerador.Qrcode.infrastructure;
import app.netlify.celso_portfolio.Gerador.Qrcode.ports.StoragePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component  // Diz ao Spring: "gerencie essa classe como um componente"
public class S3StorageAdapter implements StoragePort {

    //final: Significa que essas variáveis não mudam depois de inicializadas , são imutáveis
    private final S3Client s3Client;
    private final String bucketName;
    private final String region;


    //@Value: Busca valores do application.properties.
    // Por exemplo, ${aws.s3.region} pega o valor de aws.s3.region=us-east-1
    public  S3StorageAdapter(@Value("${aws.s3.region}")String region,
                             @Value("${aws.s3.bucket-name}") String bucketName){
        this.bucketName = bucketName;
        this.region = region;
        //Cria o cliente AWS que vai fazer o upload dos arquivos para o S3.
        this.s3Client = S3Client.builder()
                .region(Region.of(this.region))
                .build();
    }
    @Override
    public String uploadFile(byte[] fileData, String fileName, String contentType){
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(contentType)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileData));
        return String.format("https://%s.s3.%s.amazonaws.com/%s",bucketName,region,fileName);
    }


}
