package com.pushkar.ekomm.product.service;

import com.pushkar.ekomm.constant.AppConstant;
import com.pushkar.ekomm.exception.ProductNotFoundException;
import com.pushkar.ekomm.product.dto.ProductDTO;
import com.pushkar.ekomm.product.model.Product;
import com.pushkar.ekomm.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();

        if (!products.isEmpty()){
            List<ProductDTO> productList = products.stream().map(product -> modelMapper.map(product,ProductDTO.class)).toList();

            if (!productList.isEmpty()){
                return productList;
            }
        }

        throw new ProductNotFoundException("No Products Available Currently. Please reach out to admin");
    }

    public String saveProduct(ProductDTO productDTO) {
        if (null != productDTO){

            Product product = modelMapper.map(productDTO,Product.class);

            if (null != product){
                productRepository.save(product);
                return AppConstant.SAVED_SUCCESS;
            }

        }
        throw new ProductNotFoundException("Null Product Can't Be Saved");
    }

    public ProductDTO getProductById(String productId) {
        if (null != productId){
            Optional<Product> productOpt = productRepository.findById(productId);
            if (productOpt.isPresent()){
                return modelMapper.map(productOpt.get(),ProductDTO.class);
            }
            throw new ProductNotFoundException("No Products Available Currently. Please reach out to admin");
        }
        throw new ProductNotFoundException("Invalid Product ID");
    }
}
