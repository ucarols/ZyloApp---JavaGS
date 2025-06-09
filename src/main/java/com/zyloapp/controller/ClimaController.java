package com.zyloapp.controller;

import com.zyloapp.dto.ClimaRequest;
import com.zyloapp.service.ClimaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clima")
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @PostMapping
    public ResponseEntity<Void> receberClima(@Valid @RequestBody ClimaRequest request) {
        climaService.salvarClima(request);
        return ResponseEntity.ok().build();
    }
}
