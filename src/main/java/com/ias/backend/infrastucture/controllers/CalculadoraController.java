package com.ias.backend.infrastucture.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class CalculadoraController {

    @RequestMapping("/calcularDias")
    public long main(String fechaI, String fechaF) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechaI);
        Date secondDate = sdf.parse(fechaF);
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);

        return diffrence;
    }

    @RequestMapping("/calcularHoraN1")

    public long calN1(int horaF, int horaI, String fechaI, String fechaF, int horaN) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechaI);
        Date secondDate = sdf.parse(fechaF);

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);

        int horasT = 0;
        long horasT2 = 0;
        long horasT3 = 0;

        diffrence = diffrence + 1;

        horasT = (horaF - horaI);
        if (horasT < 0 || horaF == horaI) {

            horasT = horaF - horaI;
            horasT = horasT + 24;

            diffrence = diffrence - 1;

            horasT2 = (horasT) * diffrence;
            horasT3 = horasT2 - horaN;

            return horasT3;
        } else {
            horasT = horaF - horaI;
            horasT2 = (horasT) * diffrence;
            horasT3 = horasT2 - horaN;

            return horasT3;
        }

    }

    @RequestMapping("/calcularHoraN2")

    public int calN2(int num1, int num2) {

        int total = 0;

        total = num1 - num2;

        if (total == 0) {
            return (Integer) null;
        } else {
            return total;
        }
    }

    @RequestMapping("/calcularHoras")

    public long test(int horaF, int horaI, String fechaI, String fechaF) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechaI);
        Date secondDate = sdf.parse(fechaF);

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);

        int horasT = 0;
        long horasT2 = 0;
        diffrence = diffrence + 1;

        horasT = (horaF - horaI);
        if (horasT < 0 || horaF == horaI) {

            horasT = horaF - horaI;
            horasT = horasT + 24;

            diffrence = diffrence - 1;

            horasT2 = (horasT) * diffrence;

            return horasT2;
        } else {
            horasT = horaF - horaI;

            horasT2 = (horasT) * diffrence;

            return horasT2;
        }

    }


    @RequestMapping("/calcularSem")

    public int getWeekNum(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);

        WeekFields wf = WeekFields.of(Locale.getDefault());
        TemporalField weekNum = wf.weekOfWeekBasedYear();
        int semana = Integer.parseInt(String.format("%02d", date.get(weekNum)));

        return semana;
    }


    @RequestMapping("/dia")

    public String dia(String fecha) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = format1.parse(fecha);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);

        String dia = finalDay;

        return dia;
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }

}