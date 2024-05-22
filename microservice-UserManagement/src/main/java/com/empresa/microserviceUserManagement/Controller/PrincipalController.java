package com.empresa.microserviceUserManagement.Controller;

import com.empresa.microserviceUserManagement.DTO.UserDTO;
import com.empresa.microserviceUserManagement.Entity.ERole;
import com.empresa.microserviceUserManagement.Entity.RoleEntity;
import com.empresa.microserviceUserManagement.Entity.UserEntity;
import com.empresa.microserviceUserManagement.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class PrincipalController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        Set<RoleEntity> roles = userDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(bCryptPasswordEncoder.encode(userDTO.getPassword())) // Encriptar la contraseña
                .roles(roles)
                .build();
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser() {
        return null;
    }
}
