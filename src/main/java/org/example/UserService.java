package org.example;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf).orElse(null);
    }
}
