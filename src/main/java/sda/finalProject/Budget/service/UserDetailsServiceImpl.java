package sda.finalProject.Budget.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sda.finalProject.Budget.entity.UserEntity;
import sda.finalProject.Budget.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(login));
        List<GrantedAuthority> roles =  mapToRole("ADMIN") ;
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
    }

    private List<GrantedAuthority> mapToRole(String... roles){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }
}