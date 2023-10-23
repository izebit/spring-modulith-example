package ru.izebit.user.ports.in.adapters;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.izebit.user.ports.in.UserService;
import ru.izebit.user.ports.models.User;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
class UserController {
    private final UserService service;

    @PostMapping("")
    User create(@RequestBody User user) {
        return service.store(user);
    }

    @DeleteMapping("/{id}")
    boolean delete(@RequestParam("id") long userId) {
        return service.deleteById(userId);
    }

    @GetMapping(path = "/{id}")
    User getUserId(@RequestParam("id") long userId) {
        return service.findById(userId);
    }
}
