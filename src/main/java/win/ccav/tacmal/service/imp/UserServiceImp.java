package win.ccav.tacmal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import win.ccav.tacmal.domain.User;
import win.ccav.tacmal.domain.vo.RegistrationForm;
import win.ccav.tacmal.reponsitory.UserReponsitory;
import win.ccav.tacmal.service.UserService;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(RegistrationForm form){
        return userReponsitory.save(form.toUser(passwordEncoder));
    }

}
