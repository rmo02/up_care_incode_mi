package com.mirante.upcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("antenas")
public class AntenaController {
    // private final AntenaMapper antenaMapper;
    // private final AntenaService antenaService;

    // @PostMapping
    // public ResponseEntity<UUID> salvar(@Valid @RequestBody AntenaRequest dto) {

    //     Antena antena = antenaMapper.toEntity(dto);

    //     UUID id = antenaService.salvar(antena);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(id);
    // }
    
    // @GetMapping()
    // public List<AntenaResponse> buscarTodos() {
    //     return AntenaMapper.INSTANCE.toResponseList (
    //         antenaRepository.findAll()
    //     );
    // }
    
}
