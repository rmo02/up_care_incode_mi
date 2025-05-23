package com.mirante.upcare.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mirante.upcare.dto.response.TransmissorResponse;
import com.mirante.upcare.mappers.TransmissorMapper;
import com.mirante.upcare.repository.TransmissorRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("transmissores")
public class TransmissorController {
     private final TransmissorRepository transmissorRepository;

    @GetMapping
     public List<TransmissorResponse> buscarTodos() {
        return TransmissorMapper.INSTANCE.toResponseList (
            transmissorRepository.findAll()
        );
    }

}
