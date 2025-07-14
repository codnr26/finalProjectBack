package com.example.finalprojectback.service;

import com.example.finalprojectback.entity.User;
import com.example.finalprojectback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

        private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Read (tous les utilisateurs)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read (un utilisateur par ID)
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Utilisateur non trouvé avec l'ID : " + id));
    }

    // Update
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
    }

    // Delete
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("Utilisateur non trouvé avec l'ID : " + id);
        }
        userRepository.deleteById(id);
    }
}
