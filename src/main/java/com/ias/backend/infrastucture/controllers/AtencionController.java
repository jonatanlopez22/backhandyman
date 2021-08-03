package com.ias.backend.infrastucture.controllers;

import com.ias.backend.domain.Atencion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ias.backend.repository.AtencionRepository;

@RestController
public class AtencionController {
    
    private AtencionRepository atencionRepository;

    public AtencionController(AtencionRepository _atencionRepository){
        this.atencionRepository = _atencionRepository;
    }


    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<Iterable<Atencion>> readAtencion(){
        return new ResponseEntity<Iterable<Atencion>>(atencionRepository.findAll(), HttpStatus.ACCEPTED);
    }


    @PostMapping
    @RequestMapping("/registrar")
    public ResponseEntity<Atencion> createAtencion(@RequestBody Atencion atencion){
        return new ResponseEntity<Atencion>(atencionRepository.save(atencion), HttpStatus.CREATED);
    }


    @GetMapping
    @RequestMapping("/consultar")
    public ResponseEntity<Iterable<Atencion>> getAtencionByIdEmpleadoAndSemana(int idEmpleado,int semana) {
        
        return new ResponseEntity<Iterable<Atencion>>(atencionRepository.findByIdEmpleadoAndSemana(idEmpleado,semana), HttpStatus.ACCEPTED);
    }

}
