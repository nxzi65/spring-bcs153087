package com.example.springcontinue.service;

import com.example.springcontinue.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {
    @Autowired
    private ApplicationUserRepository applicationUserRepositoryuserRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username);
        return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }
    public void save(ApplicationUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
