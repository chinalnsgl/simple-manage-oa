package net.sgl.simplemanageoa.services.impl;

import lombok.extern.slf4j.Slf4j;
import net.sgl.simplemanageoa.entites.Manager;
import net.sgl.simplemanageoa.entites.Process;
import net.sgl.simplemanageoa.entites.Product;
import net.sgl.simplemanageoa.repository.ProcessRepository;
import net.sgl.simplemanageoa.repository.ProductRepository;
import net.sgl.simplemanageoa.services.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ManagerServiceImplTest {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProcessRepository processRepository;

    @Test
    public void save() {
        Manager manager = new Manager();
        manager.setAccount("long");
        String pwd = "123";
        for (int i = 0; i < 10; i++) {
            pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        }
        manager.setPassword(pwd);
        managerService.save(manager);
    }

    @Test
    public void gen() {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Product product = new Product();
            product.setProductName("保护环品种" + i);
            products.add(product);
        }
        productRepository.saveAll(products);
    }

    @Test
    public void tes() {

    }
}