package net.sgl.simplemanageoa.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "T_PRODUCT")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;

}
