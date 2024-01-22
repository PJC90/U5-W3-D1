package pierpaolo.colasante.u5w2d5project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pierpaolo.colasante.u5w2d5project.payloads.UserLoginDTO;
import pierpaolo.colasante.u5w2d5project.payloads.UserLoginResponseDTO;
import pierpaolo.colasante.u5w2d5project.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO body){
        String accessToken = authService.authenticateUser(body);
        return new UserLoginResponseDTO(accessToken);
    }
}
