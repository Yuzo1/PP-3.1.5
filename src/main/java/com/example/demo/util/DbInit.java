package com.example.demo.util;

import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DbInit {

    private final RoleService roleService;
    private final UserService usersService;

    @Autowired
    public DbInit(RoleService roleService, UserService usersService) {
        this.roleService = roleService;
        this.usersService = usersService;
    }

    @PostConstruct
    public void initialization() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);
        User admin = new User("admin", "admin", 12,"admin@mail.ru", "admin");
        admin.setRoles(Set.of(roleAdmin));
//        User user = new User("user", "user", 20, "user@mail.ru", "user");
//        user.setRoles(Set.of(roleUser));
        usersService.saveUser(admin);
//        usersService.saveUser(user);

    }
}
