package cinema.app.service.impl;

import cinema.app.model.Role;
import cinema.app.model.User;
import cinema.app.service.AuthenticationService;
import cinema.app.service.RoleService;
import cinema.app.service.ShoppingCartService;
import cinema.app.service.UserService;
import java.util.HashSet;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.roleService = roleService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Role roleUser = roleService.getByName(Role.RoleName.USER.name());
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleUser);
        user.setRoles(roles);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
