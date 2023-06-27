package pl.as.lista;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller

public class UsersController {
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    @ResponseBody
    String printUsers() {
        List<User> userList = userRepository.getAll();

        String result = "Lista uzytkownikow: <br>";
        for (User user : userList) {
            result += user.getFirstName() + " " + user.getLastName() + ", wiek: " + user.getAge() + "<br>";
        }
        return result;
    }

    @RequestMapping("/add")
    String add(@RequestParam() String imie, @RequestParam() String nazwisko, @RequestParam() Integer wiek) {
        if (imie.isEmpty() && nazwisko.isEmpty() && wiek != null) {
            return "redirect:/err.html";
        } else {
            userRepository.add(new User(imie, nazwisko, wiek));
            return "redirect:/success.html";
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        return "redirect:/err.html";
    }
}



