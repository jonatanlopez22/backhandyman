package com.ias.backend.repository;

import com.ias.backend.domain.Atencion;
import org.springframework.data.repository.CrudRepository;


public interface AtencionRepository extends CrudRepository<Atencion,Integer> {

 
    Iterable<Atencion>  findByIdEmpleadoAndSemana(int idEmpleado,int semana);
}