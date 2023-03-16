package dev.wcs.nad.tariffmanager.adapter.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.wcs.nad.tariffmanager.identity.entity.User;
import dev.wcs.nad.tariffmanager.identity.user.UserRepository;
import dev.wcs.nad.tariffmanager.identity.user.UserService;

@Controller
@RequestMapping("/public/admin")
public class AdminView {

    @Autowired UserRepository userRepository;
    @Autowired UserService userService;
    
    public record UserDto (String username, String userRole) { }


    // DEJA FAIRE AVEC REPO, PUIS AVEC SERVICE PUIS AVEC DTO


    @GetMapping("/")
    public String editview(Model model) {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user.getUsername(), user.securityUser().getAuthorities().toString());
            userDtos.add(userDto);
        }
        model.addAttribute("userDtos", userDtos);
        
        return "admin";
    }

}
