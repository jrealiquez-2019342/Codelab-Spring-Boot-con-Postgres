package com.realiquez.postgres;

import com.realiquez.postgres.data.dto.UserDto;
import com.realiquez.postgres.data.entity.User;
import com.realiquez.postgres.data.exception.UserNotFoundException;
import com.realiquez.postgres.data.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping
    User createuser(@RequestBody UserDto userDto){
        User user = new User(userDto);
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) throw new UserNotFoundException();
        return optionalUser.get();
    }

}
