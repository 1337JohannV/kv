package kv.toimkond.logiraamat.controllers;

import kv.toimkond.logiraamat.models.Response;
import kv.toimkond.logiraamat.user.UserService;
import kv.toimkond.logiraamat.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody UserModel userModel) {
        return userService.registerUser(userModel);
    }
    @PostMapping("/login")
    public Response login(@RequestBody UserModel userModel) {
        return userService.login(userModel);
    }
}
