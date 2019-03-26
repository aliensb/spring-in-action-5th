package win.ccav.tacmal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import win.ccav.tacmal.domain.User;
import win.ccav.tacmal.domain.vo.RegistrationForm;
import win.ccav.tacmal.reponsitory.UserReponsitory;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userReponsitory.findByUsername(username);
       if(user!=null){
           return user;
       }else{
           throw new UsernameNotFoundException("User '" + username + "' not found");
       }
    }


}
