import org.example.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    interface ProductRepository extends JpaRepository<Product, Long> {
    }
}
