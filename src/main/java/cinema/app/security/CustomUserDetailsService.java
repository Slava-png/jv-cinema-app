package cinema.app.security;

import cinema.app.model.User;
import cinema.app.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(username);

        if (user.isPresent()) {
            org.springframework.security.core.userdetails.User.UserBuilder builder =
                    org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.get().getPassword());
            builder.roles(user.get().getRoles().stream()
                                                .map(e -> e.getRoleName().name())
                                                .toArray(String[]::new));
            return builder.build();
        }
        throw new UsernameNotFoundException("User with username: " + username + " not found");
    }
}
