package ru.radion.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.radion.entity.User;
import ru.radion.resolver.UserServiceResolver;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(
        UserServiceResolver.class
)
public class UserServiceTest {
    private UserService service;
    private static final User RADION = new User(1, "Radion", "123");
    private static final User OLYA = new User(2, "Olya", "321");

    @BeforeEach
    void prepare(UserService service) {
        this.service = service;
        service.add(RADION, OLYA);
    }
    @Test
    void loginSuccessIfUserExist() {
        Optional<User> mayBeUser = service.login(RADION.getName(), RADION.getPassword());

        assertTrue(mayBeUser.isPresent());
        mayBeUser.ifPresent(user -> assertEquals(RADION, user));
    }

    @Test
    void loginFailIfPasswordIsNotCorrect() {
        Optional<User> mayBeUser = service.login(RADION.getName(), "dummy");

        assertFalse(mayBeUser.isPresent());
    }

    @Test
    void getAllIsNotEmpty() {
        List<User> users = service.getAll();

        assertThat(users).hasSize(2);
        assertThat(users).contains(RADION, OLYA);
    }

    @Test
    void ConvertedToMapById() {
        Map<Integer, User> usersMap = service.getUsersConvertedById();
        assertThat(usersMap).containsKeys(RADION.getId(), OLYA.getId());
        assertThat(usersMap).containsValues(RADION, OLYA);
    }

    @Test
    void throwIllegalArgumentExceptionIfNameOrPasswordIsNull() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> service.login("dummy", null)),
                () -> assertThrows(IllegalArgumentException.class, () -> service.login(null, "dummy"))
        );
    }

}
