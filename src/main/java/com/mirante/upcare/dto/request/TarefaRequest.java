package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.Manutencao;
import com.mirante.upcare.models.enums.StatusTarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaRequest(

        @NotNull
        Manutencao manutencao,

        @NotNull
        StatusTarefa statusTarefa,

        @NotBlank
        String descricao

){}
