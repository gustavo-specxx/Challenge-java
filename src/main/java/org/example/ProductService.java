package org.example;

@Service
public class ProductService {
    @Autowired
    private CommentRepository.ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
