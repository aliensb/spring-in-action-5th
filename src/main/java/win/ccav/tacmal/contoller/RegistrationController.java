package win.ccav.tacmal.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import win.ccav.tacmal.domain.vo.RegistrationForm;
import win.ccav.tacmal.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping
    public String processRegistraion(@Valid RegistrationForm form, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("error",errors.getAllErrors());
            return "register";
        }
        userService.addUser(form);
        return "redirect:/login";
    }
}
