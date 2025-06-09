package com.zyloapp.service;

import com.zyloapp.dto.ClimaRequest;
import com.zyloapp.repository.ClimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.zyloapp.model.Clima;

@Service
public class ClimaService {

    @Autowired
    private ClimaRepository climaRepository;

    public void salvarClima(ClimaRequest dto) {
        Clima clima = new Clima();
        clima.setLocalizacao(dto.getLocalizacao());
        clima.setTemperatura(dto.getTemperatura());
        clima.setProbabilidadeChuva(dto.getProbabilidadeChuva());
        clima.setVelocidadeVento(dto.getVelocidadeVento());
        clima.setDataHora(LocalDateTime.now());
        climaRepository.save(clima);
    }
}
