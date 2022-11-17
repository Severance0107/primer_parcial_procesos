package com.primer_parcial.SyK.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(length = 45,nullable= false)
    private String correo;
    @Column(length = 45,nullable = false)
    private String password;


}
