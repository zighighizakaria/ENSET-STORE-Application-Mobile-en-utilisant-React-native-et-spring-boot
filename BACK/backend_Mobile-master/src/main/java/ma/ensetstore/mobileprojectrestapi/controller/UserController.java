package ma.ensetstore.mobileprojectrestapi.controller;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.UserDTO;
import ma.ensetstore.mobileprojectrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/annonces")
    public ResponseEntity<List<AnnonceDTO>> getUserAnnonces(@PathVariable Long userId) {
        List<AnnonceDTO> annonces = userService.getUserAnnonces(userId);
        return ResponseEntity.ok(annonces);
    }
    @GetMapping("/{email}/unique")
    public ResponseEntity<Boolean> isEmailUnique(@PathVariable String email) {
        boolean isUnique = userService.isEmailUnique(email);
        return ResponseEntity.ok(isUnique);
    }

}

