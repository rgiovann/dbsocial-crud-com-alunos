package com.portalsocial.portalsocial.api.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class FotoCursoInput {

    @NotNull
    MultipartFile arquivo;

    @NotBlank
    String descricao;
}
