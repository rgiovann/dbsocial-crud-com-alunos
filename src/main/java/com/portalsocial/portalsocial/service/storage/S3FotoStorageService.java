package com.portalsocial.portalsocial.service.storage;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.portalsocial.portalsocial.core.StorageProperties;
import com.portalsocial.portalsocial.service.FotoStorageService;

import java.net.URL;

public class S3FotoStorageService implements FotoStorageService {

    private final AmazonS3 amazonS3;
    private final StorageProperties storageProperties;

    public S3FotoStorageService(AmazonS3 amazonS3, StorageProperties storageProperties) {
        this.amazonS3 = amazonS3;
        this.storageProperties = storageProperties;
    }

    @Override
    public void armazenar(NovaFoto novaFoto) {
        try {
            var objectMetadata = new ObjectMetadata();

            objectMetadata.setContentType(novaFoto.getContentType());

            var putObjectRequest = new PutObjectRequest(storageProperties.getS3().getBucket(),
                    getCaminhoArquivo(novaFoto.getNomeArquivo() ),
                    novaFoto.getInputStream(), objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead);
            this.amazonS3.putObject(putObjectRequest);
        } catch (Exception e) {
            throw new StorageException("Não foi possível enviar arquivo para Amazon S3", e);
        }
    }

    @Override
    public void remover(String nomeArquivo) {
        try {

            String caminhoArquivo = this.getCaminhoArquivo(nomeArquivo);
            String bucket         = this.storageProperties.getS3().getBucket();

            var deleteObjectRequest = new DeleteObjectRequest(bucket, caminhoArquivo );
            this.amazonS3.deleteObject(deleteObjectRequest);
        }
        catch (Exception e) {
            throw new StorageException("Não foi possível enviar arquivo para Amazon S3", e);
        }

    }

    @Override
    public FotoRecuperada recuperar(String nomeArquivo) {

        String caminhoArquivo = this.getCaminhoArquivo(nomeArquivo);

        String bucket = this.storageProperties.getS3().getBucket();

        URL url = this.amazonS3.getUrl(bucket, caminhoArquivo);

        return FotoRecuperada.builder()
                .url(url.toString())
                .build();
    }

    private String getCaminhoArquivo( String nomeArquivo) {
        return String.format("%s/%s", this.storageProperties.getS3().getDiretorioFotos(),nomeArquivo);
    }

}