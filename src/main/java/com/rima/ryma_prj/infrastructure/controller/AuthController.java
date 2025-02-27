package com.rima.ryma_prj.infrastructure.controller;

import com.rima.ryma_prj.application.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200") // Remplacez par l'URL de votre application Angular

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String email = payload.get("email");
        String password = payload.get("password");

        System.out.println("🔹 Requête reçue pour signup avec : " + email);
        return authService.signup(username, email, password);
    }


    @PostMapping("/signin")
    public ResponseEntity<Map<String, Object>> signin(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");

        Map<String, Object> result = authService.signin(email, password);

        if (result.containsKey("error")) {
            return ResponseEntity.status(401).body(Map.of("status", "error", "message", result.get("error")));
        }
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "token", result.get("token"),
                "role", result.get("role"),
                "name", result.get("name"),
                "id", result.get("id")
        ));


        //return ResponseEntity.ok(result);
    }



    //@PostMapping("/forgot-password")
    //public void forgotPassword(@RequestParam String email) {
      //  authService.forgotPassword(email);
    //}

    @PostMapping("/forgot-password")
    public ResponseEntity<Map<String, Object>> forgotPassword(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        return authService.forgotPassword(email);
    }







    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, Object>> resetPassword(@RequestBody Map<String, String> payload) {
        String token = payload.get("token");
        String newPassword = payload.get("newPassword");
        String confirmPassword = payload.get("confirmPassword");

        return authService.resetPasswordWithToken(token, newPassword, confirmPassword);
    }





    //@PostMapping("/forgot-password")
    //public void forgotPassword(@RequestParam String email) {
    //  authService.forgotPassword(email);
    //}
}

