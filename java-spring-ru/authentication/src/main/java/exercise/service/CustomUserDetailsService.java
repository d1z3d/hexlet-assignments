package exercise.service;

import exercise.exception.ResourceNotFoundException;
import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

// BEGIN
@Service
public class CustomUserDetailsService implements UserDetailsManager {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void createUser(UserDetails userData) {
        var user = new User();
        user.setEmail(userData.getUsername());
        var hashedPassword = passwordEncoder.encode(userData.getPassword());
        user.setPasswordDigest(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByEmail(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        var user = userRepository.findByEmail(username);
        return user.isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return user;
    }
}
// END
