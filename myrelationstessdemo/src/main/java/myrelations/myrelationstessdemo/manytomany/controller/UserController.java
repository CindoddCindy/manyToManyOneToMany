package myrelations.myrelationstessdemo.manytomany.controller;

import myrelations.myrelationstessdemo.manytomany.entitiy.User;
import myrelations.myrelationstessdemo.manytomany.model.UserModel;
import myrelations.myrelationstessdemo.manytomany.repository.UserRepository;
import myrelations.myrelationstessdemo.manytomany.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/details/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @GetMapping("/user/all")
    public List<UserModel> getUsers() {
        return userService.getUsers();

    }
    @PutMapping("/user/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
