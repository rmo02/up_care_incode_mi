package com.mirante.upcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mirante.upcare.dto.response.AntenaResponse;
import com.mirante.upcare.mappers.AntenaMapper;
import com.mirante.upcare.repository.AntenaRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@AllArgsConstructor
@RequestMapping("antenas")
public class AntenaController {
    private final AntenaRepository antenaRepository;

    @GetMapping()
    public List<AntenaResponse> buscarTodos() {
        return AntenaMapper.INSTANCE.toResponseList (
            antenaRepository.findAll()
        );
    }
    
}
