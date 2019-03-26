package win.ccav.tacmal.service;

import win.ccav.tacmal.domain.User;
import win.ccav.tacmal.domain.vo.RegistrationForm;

public interface UserService {
    User addUser(RegistrationForm form);
}
