//package kz.iitu.alikhan.library.serivce.impl;
//
//import kz.iitu.alikhan.library.entity.User;
//import kz.iitu.alikhan.library.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.List;
//
//public class UserServiceImplementation implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public void createUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.saveAndFlush(user);
//    }
//
//    @Override
//    public void updateUser(Long id, User user) {
//        User userDb = userRepository.findById(id).orElse(null);
//
//        if (userDb != null) {
//            userDb.setUsername(user.getUsername());
//            userDb.setPassword(user.getPassword()); // plaintext password
//
//            userRepository.saveAndFlush(userDb);
//        }
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User: " + username + " not found!");
//        }
//        return user;
//    }
//}
