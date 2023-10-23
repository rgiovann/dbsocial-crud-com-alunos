package com.portalsocial.portalsocial.api.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaInput {

    @NotNull
    private Long id;
}
