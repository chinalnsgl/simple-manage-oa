package net.sgl.simplemanageoa.repository;

import net.sgl.simplemanageoa.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
