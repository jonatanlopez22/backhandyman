package com.ias.backend.infrastucture.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculadoraControllerTest {

    @Autowired
    CalculadoraController calculadoraController;

    @Test
    void testGetWeekNum() {
        calculadoraController = new CalculadoraController();

        String fecha = "2021-07-23";

        int semana = calculadoraController.getWeekNum(fecha);
        Assertions.assertEquals(30, semana);
    }

    @Test
    void testCalcular2() {
        calculadoraController = new CalculadoraController();

        int horaF = 19;
        int horaI = 8;

        int horast = calculadoraController.calN2(horaF, horaI);
        Assertions.assertEquals(11, horast);

    } 


}
