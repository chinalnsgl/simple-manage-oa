package net.sgl.simplemanageoa.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "T_Manager")
@Data
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
}
