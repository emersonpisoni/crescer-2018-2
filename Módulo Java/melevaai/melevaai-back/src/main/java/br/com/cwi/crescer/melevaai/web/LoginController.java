package br.com.cwi.crescer.melevaai.web;

import br.com.cwi.crescer.melevaai.domain.pessoa.request.LoginRequest;
import br.com.cwi.crescer.melevaai.domain.pessoa.response.LoginResponse;
import br.com.cwi.crescer.melevaai.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationService service;

    @PostMapping
    public LoginResponse login(@RequestBody @Valid LoginRequest request){

        String username = request.getEmail();
        String password = request.getSenha();

        String token = service.authenticate(username, password);

        return new LoginResponse(token);

    }
}
