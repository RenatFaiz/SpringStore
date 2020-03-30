package cosmonaut.service;

import cosmonaut.entity.Product;
import cosmonaut.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        return null;
    }

    public Product getProductByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // In future releases
    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
