package cosmonaut.service;

import cosmonaut.entity.Product;
import cosmonaut.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
       return productRepository.getOne(id);
    }

    public Product getProductByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
