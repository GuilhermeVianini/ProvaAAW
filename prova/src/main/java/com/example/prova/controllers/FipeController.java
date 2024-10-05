package com.example.prova.controllers;

import com.example.prova.services.FipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FipeController {

    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/fipe/marcas")
    public List<?> getMarcas() {
        return fipeService.getMarcas();
    }

    @GetMapping("/fipe/marcas/{id}/modelos")
    public List<?> getModelos(@PathVariable String id) {
        return fipeService.getModelos(id);
    }

    @GetMapping("/fipe/marcas/{marcaId}/modelos/{modeloId}/anos/{ano}")
    public List<?> getAnos(@PathVariable String marcaId, @PathVariable String modeloId, @PathVariable String ano) {
        return fipeService.getAnos(marcaId, modeloId, ano);
    }
}
