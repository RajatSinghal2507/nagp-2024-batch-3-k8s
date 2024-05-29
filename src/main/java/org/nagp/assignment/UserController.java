package org.nagp.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public @ResponseBody String test() {
        logger.info("inside test");
        return "TEST COMPLETED";
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        logger.info("inside get all users");
        return userRepository.findAll();
    }

    @GetMapping(path = "/fib")
    public @ResponseBody String getFibNumber(@RequestParam(defaultValue = "10") int number) {
        return "fibonacci of " + number + "is " + fibonacci(number);
    }

    private static long fibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
