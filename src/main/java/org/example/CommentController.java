package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String name, @RequestParam String cpf) {
        User user = userService.findByCpf(cpf);
        if (user != null && user.getName().equals(name)) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/products/{productId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long productId, @RequestBody Comment comment) {
        Product product = productService.findById(productId);
        if (product != null) {
            comment.setProduct(product);
            commentService.addComment(comment);
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        Comment existingComment = commentService.findById(commentId);
        if (existingComment != null) {
            existingComment.setText(comment.getText());
            commentService.updateComment(existingComment);
            return ResponseEntity.ok(existingComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        Comment existingComment = commentService.findById(commentId);
        if (existingComment != null) {
            commentService.deleteComment(commentId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
