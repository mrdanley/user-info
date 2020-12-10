package com.demo.userinfo.api.controllers;

import com.demo.userinfo.api.UserNotFoundException;
import com.demo.userinfo.api.arguments.GetAllArguments;
import com.demo.userinfo.models.User;
import com.demo.userinfo.store.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> all(GetAllArguments args) {
        if (args.getStreet().equalsIgnoreCase("")) {
            return this.repository.findAll();
        }

        return this.repository.findAll(addressStreet(args.getStreet()));
    }

    @GetMapping("/users/{id}")
    public User one(@PathVariable Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(Optional.of(id)));
    }

    static Specification<User> addressStreet(String street) {
        return (user, cq, cb) -> cb.equal(user.get("address").get("street"), street);
    }
}
