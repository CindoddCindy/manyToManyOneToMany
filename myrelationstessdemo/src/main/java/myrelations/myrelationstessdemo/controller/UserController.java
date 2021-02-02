package myrelations.myrelationstessdemo.controller;

import myrelations.myrelationstessdemo.entity.User;
import myrelations.myrelationstessdemo.model.Library;
import myrelations.myrelationstessdemo.model.UserModel;
import myrelations.myrelationstessdemo.repository.LibraryRepository;
import myrelations.myrelationstessdemo.repository.UserRepository;
import myrelations.myrelationstessdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    /*
    @Autowired
    public UserController(UserService userService, UserRepository userRepository, LibraryRepository libraryRepository){
        this.userService=userService;
        this.userRepository=userRepository;
        this.libraryRepository=libraryRepository;
    }

     */

    //tambah  metod mappng dengan library

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        Optional<Library> optionalLibrary = libraryRepository.findById(user.getLibrary().getId());
        if (!optionalLibrary.isPresent() ) {
            return ResponseEntity.unprocessableEntity().build();
        }

        user.setLibrary(optionalLibrary.get());

        User savedUser = userRepository.save(user); //ganti ke many to many
        //User savedUser = userService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    //test metod ini

    @PostMapping("/user/creates")
    public ResponseEntity<Object> createsUser(@RequestBody @Valid  User user) {
        return userService.createUsers(user);
    }

    /*
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

     */

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody Comment comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
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
