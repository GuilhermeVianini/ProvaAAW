package com.example.prova.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FipeService {

    private final RestTemplate restTemplate;

    public FipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<?> getMarcas() {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        return restTemplate.getForObject(url, List.class);
    }

    public List<?> getModelos(String id) {
        String url = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos", id);
        return restTemplate.getForObject(url, List.class);
    }

    public List<?> getAnos(String marcaId, String modeloId, String ano) {
        String url = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos/%s/anos/%s", marcaId, modeloId, ano);
        return restTemplate.getForObject(url, List.class);
    }
}
