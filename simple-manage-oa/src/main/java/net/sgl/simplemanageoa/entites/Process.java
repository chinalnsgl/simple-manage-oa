package net.sgl.simplemanageoa.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "T_PROCESS")
@Data
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processName;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
