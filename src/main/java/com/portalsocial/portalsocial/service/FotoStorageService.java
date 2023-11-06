package com.portalsocial.portalsocial.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;
import java.util.UUID;

public interface FotoStorageService {

    void armazenar( NovaFoto novaFoto);

    void remover(String nomeArquivo);

    FotoRecuperada recuperar(String nomeArquivo);

    default String gerarNomeArquivo(String nomeOriginal){
        return UUID.randomUUID() + "-" + nomeOriginal;
    }

    @Getter
    @Setter
    class NovaFoto{
        private String nomeArquivo;
        private String contentType;
        private InputStream inputStream;
    }

    @Setter
    @Builder
    class FotoRecuperada{
        private InputStream inputStream;
        private String url;

        public boolean temUrl(){
            return this.url != null;
        }

        public boolean temInputStream(){
            return this.inputStream != null;
        }
    }

    default void substituir(String nomeArquivoAntigo, NovaFoto novaFoto){
        this.armazenar(novaFoto);
        if(nomeArquivoAntigo != null){
            this.remover(nomeArquivoAntigo);
        }
    }
}
