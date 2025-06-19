package com.undercloud.application.controller;

import com.undercloud.application.config.security.TokenService;
import com.undercloud.application.dto.AuthenticationDTO;
import com.undercloud.application.dto.LoginResponseDTO;
import com.undercloud.application.dto.RegisterDTO;
import com.undercloud.application.entity.UsersEntity;
import com.undercloud.application.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    // REMOVIDO: @Autowired private RegisterDTO registerDTO; (DTOs não são autowirados)

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository usersRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){ // Corrigido para @RequestBody
        var userNamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        var token = tokenService.generateToken((UsersEntity) auth.getPrincipal());
        return  ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if (this.usersRepository.existsByLogin(registerDTO.login())) {
            return ResponseEntity.badRequest().body("Usuário com este login já existe.");
        }

        // Use o PasswordEncoder que o Spring injeta (se você quiser)
        // Mas a forma atual também funciona se não tiver outro PasswordEncoder injetado
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        // Se você quisesse injetar:
        // @Autowired private PasswordEncoder passwordEncoder;
        // String encryptedPassword = this.passwordEncoder.encode(registerDTO.senha());

        UsersEntity newUser = new UsersEntity(registerDTO.login(), encryptedPassword);

        this.usersRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}