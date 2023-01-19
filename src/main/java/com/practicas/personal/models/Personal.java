package com.practicas.personal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idPersonal", referencedColumnName = "id")
    private Cuenta cuenta;
}
