package com.pushkar.ekomm.product.controller;

import com.pushkar.ekomm.constant.AppConstant;
import com.pushkar.ekomm.product.dto.ProductDTO;
import com.pushkar.ekomm.product.model.Product;
import com.pushkar.ekomm.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody ProductDTO productDTO){
        if (null != productDTO){
            return ResponseEntity.ok(productService.saveProduct(productDTO));
        }
        return ResponseEntity.badRequest().body(AppConstant.EMPTY_PRODUCT_PASSED);
    }
}
