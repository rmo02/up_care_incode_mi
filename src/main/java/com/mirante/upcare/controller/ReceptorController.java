package com.mirante.upcare.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mirante.upcare.dto.response.ReceptorResponse;
import com.mirante.upcare.mappers.ReceptorMapper;
import com.mirante.upcare.repository.ReceptorRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("receptores")
public class ReceptorController {
    private final ReceptorRepository receptorRepository;

    @GetMapping("path")
     public List<ReceptorResponse> buscarTodos() {
        return ReceptorMapper.INSTANCE.toResponseList (
            receptorRepository.findAll()
        );
    }

}
