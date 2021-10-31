package eu.javeo.training.java8.exercises;

import eu.javeo.training.java8.data.model.User;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static eu.javeo.training.java8.data.Data.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class Ex1_Comparator {

    private List<User> sortUsers(List<User> users) {
        // TODO: Posortuj użytkowników po dacie rejestracji // Done!
        return users.stream()
                .sorted((u1, u2) -> u1.getRegisterDate().compareTo(u2.getRegisterDate()))
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        List<User> users = Arrays.asList(userJaroslawPsikuta, userZygfrydWiadro, userLeopoldKozibak, userWaldemarKilof, userRomualdDzik, userAntoniSzpadel);
        List<User> result = sortUsers(users);
        assertThat(result, is(Arrays.asList(userWaldemarKilof, userAntoniSzpadel, userJaroslawPsikuta, userZygfrydWiadro, userRomualdDzik, userLeopoldKozibak)));
    }
}
