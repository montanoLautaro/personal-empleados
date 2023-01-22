package com.practicas.personal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @Temporal(TemporalType.TIME)
    private Date horaSalida;

    public Cuenta(Date horaEntrada, Date horaSalida) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }
}
