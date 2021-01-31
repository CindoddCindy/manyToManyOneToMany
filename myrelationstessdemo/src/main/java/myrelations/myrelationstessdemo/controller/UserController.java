package myrelations.myrelationstessdemo.controller;

import myrelations.myrelationstessdemo.entity.User;
import myrelations.myrelationstessdemo.model.UserModel;
import myrelations.myrelationstessdemo.repository.LibraryRepository;
import myrelations.myrelationstessdemo.repository.UserRepository;
import myrelations.myrelationstessdemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    private LibraryRepository libraryRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //test mapping one to one
    public UserController(UserService userService, UserRepository userRepository, LibraryRepository libraryRepository){
        this.userService=userService;
        this.userRepository=userRepository;
        this.libraryRepository=libraryRepository;
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
