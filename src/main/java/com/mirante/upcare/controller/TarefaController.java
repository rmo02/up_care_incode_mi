package com.mirante.upcare.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.TarefaRequest;
import com.mirante.upcare.mappers.TarefaMapper;
import com.mirante.upcare.models.TarefaEquipamento;
import com.mirante.upcare.service.EquipamentoService;
import com.mirante.upcare.service.TarefaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("tarefas")
public class TarefaController {

    private final TarefaService tarefaService;
    private final EquipamentoService equipamentoService;
    private final TarefaMapper tarefaMapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid TarefaRequest dto){

        var tarefa = tarefaMapper.toEntity(dto);

        var tarefaEquipamentos = (dto.equipamentos().stream()
            .map(equipamentoService::buscarPorId)
            .map(equipamento -> TarefaEquipamento
                .builder()
                .tarefa(tarefa)
                .equipamento(equipamento)
                .build()
            )
            .toList()
        );

        tarefa.setTarefaEquipamentos(tarefaEquipamentos);
        tarefaService.salvar(tarefa);


        System.out.println("parei");

        return ResponseEntity.status(HttpStatus.CREATED).build();

        // return (Pipeline
        //         .from(dto)
        //         .then(tarefaMapper::toEntity)
        //         .then(tarefaService::salvar)
        //         .then(Tarefa::getId)
        //         .then(id-> ResponseEntity.status(HttpStatus.CREATED).body(id))
        //         .get()
        // );
    }





    // @GetMapping
    // public ResponseEntity<List<TarefaResponse>> buscarTodos(){
    //     return (Pipeline
    //             .from(tarefaService.buscarTodos())
    //             .then(tarefaMapper::toResponseList)
    //             .then(ResponseEntity::ok)
    //             .get()
    //     );
    // }

    // @GetMapping("{idTarefa}")
    // public ResponseEntity<TarefaResponse> buscarPorId(@PathVariable UUID idTarefa) {
    //     return (Pipeline
    //             .from(idTarefa)
    //             .then(tarefaService::buscarPorId)
    //             .then(tarefaMapper::toResponse)
    //             .then(ResponseEntity::ok)
    //             .get()
    //     );
    // }
    // @DeleteMapping("{idTarefa}")
    // public ResponseEntity<Void> deletarPorId(@PathVariable UUID idTarefa) {
    //     tarefaService.deletarPorId(idTarefa);
    //     return ResponseEntity.ok().build();
    // }




}
