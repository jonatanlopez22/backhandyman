package com.ias.backend.domain;
import lombok.Data;
import java.time.LocalDate;
import javax.persistence.*;


@Entity
@Table(name = "servicios")
@Data
public class Atencion {
  
@Id 
@GeneratedValue(strategy = GenerationType.AUTO) 
private int id;
@Column(nullable = false)
private int idEmpleado;
@Column(nullable = false)
private int idServicio;
@Column(nullable = false)
private int horaI;
@Column(nullable = false)
private int horaF;
@Column(nullable = false)
private int horasDiurnas;
@Column(nullable = false)
private int horasNocturnas;
@Column(nullable = false)
private int horasDominicales;
@Column(nullable = false)
private int semana;
@Column(nullable = false)
private LocalDate fechaI;
@Column(nullable = false)
private LocalDate fechaF;


public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public int getIdEmpleado() {
    return idEmpleado;
}
public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
}
public int getIdServicio() {
    return idServicio;
}
public void setIdServicio(int idServicio) {
    this.idServicio = idServicio;
}
public int getHoraI() {
    return horaI;
}
public void setHoraI(int horaI) {
    this.horaI = horaI;
}
public int getHoraF() {
    return horaF;
}
public void setHoraF(int horaF) {
    this.horaF = horaF;
}
public int getSemana() {
    return semana;
}
public void setSemana(int semana) {
    this.semana = semana;
}
 public LocalDate getFechaI() {
    return fechaI;
} 
public void setFechaI(LocalDate fechaI) {
    this.fechaI = fechaI;
}
public LocalDate getFechaF() {
    return fechaF;
}
public void setFechaF(LocalDate fechaF) {
    this.fechaF = fechaF;
}
public int getHorasDiurnas() {
    return horasDiurnas;
}
public void setHorasDiurnas(int horasDiurnas) {
    this.horasDiurnas = horasDiurnas;
}
public int getHorasNocturnas() {
    return horasNocturnas;
}
public void setHorasNocturnas(int horasNocturnas) {
    this.horasNocturnas = horasNocturnas;
}
public int getHorasDominicales() {
    return horasDominicales;
}
public void setHorasDominicales(int horasDominicales) {
    this.horasDominicales = horasDominicales;
}

}
