package net.sgl.simplemanageoa.controller;

import lombok.extern.slf4j.Slf4j;
import net.sgl.simplemanageoa.bean.BaseResponse;
import net.sgl.simplemanageoa.entites.Product;
import net.sgl.simplemanageoa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public BaseResponse getProducts(Integer pageNo) {
        log.info(">>>>>>>pageNo : {} \n", pageNo);
        Page<Product> products = productRepository.findAll(PageRequest.of(pageNo - 1, 10));
        BaseResponse<Page> baseResponse = new BaseResponse<>();
        baseResponse.setData(products);
        return baseResponse;
    }

    @GetMapping("/remove")
    public BaseResponse removeProduct(Long id) {
        log.info(">>>>>>>>>id = {}", id);
        productRepository.deleteById(id);
        return new BaseResponse();
    }

    @GetMapping("/save")
    public BaseResponse updateProduct(Product product) {
        log.info(">>>>>>>>> {}", product);
        productRepository.save(product);
        return new BaseResponse();
    }
}
