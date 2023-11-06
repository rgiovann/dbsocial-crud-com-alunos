package com.portalsocial.portalsocial.service.storage;

import com.portalsocial.portalsocial.core.StorageProperties;
import com.portalsocial.portalsocial.service.FotoStorageService;
import org.springframework.util.FileCopyUtils;

import java.nio.file.Files;
import java.nio.file.Path;

public class LocalFotoStorageService implements FotoStorageService {

    private final StorageProperties storageProperties;

    public LocalFotoStorageService(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    @Override
    public void armazenar(NovaFoto novaFoto) {
        try{
            Path arquivoPath = getArquivoPath(novaFoto.getNomeArquivo());
            FileCopyUtils.copy(novaFoto.getInputStream(), Files.newOutputStream(arquivoPath));

        } catch (Exception e){

            throw new StorageException("Não foi possivel armazenar o arquivo " +
                    novaFoto.getNomeArquivo() +".",e);
        }
    }

    @Override
    public void remover(String nomeArquivo) {

        Path arquivoPath = getArquivoPath(nomeArquivo);

        try{
            Files.deleteIfExists(arquivoPath);
        } catch (Exception e){

            throw new StorageException("Não foi possivel excluir o arquivo " + nomeArquivo +".",e);
        }
    }

    @Override
    public FotoRecuperada recuperar(String nomeArquivo) {
        Path arquivoPath = getArquivoPath(nomeArquivo);

        try{
            FotoRecuperada fotoRecuperada = FotoRecuperada.builder()
                                            .inputStream(Files.newInputStream(arquivoPath))
                                            .build();
            return fotoRecuperada;

        } catch (Exception e){

            throw new StorageException("Não foi possivel recuperar o arquivo " + nomeArquivo +".",e);
        }
    }

    private Path getArquivoPath(String nomeArquivo){
        return storageProperties
                .getLocal()
                .getDiretorioFotos()
                .resolve(Path.of(nomeArquivo));
    }

}
