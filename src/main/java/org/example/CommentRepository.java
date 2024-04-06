import org.example.Product;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    interface ProductRepository extends JpaRepository<Product, Long> {
    }
}
