package com.quizzai.quizzai_api.users;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {
    


    @GetMapping()
    @Operation(summary = "Get all users")
    public ResponseEntity<String> getUsersExample() {
        return ResponseEntity.ok().body("salve");
    }
    
}
