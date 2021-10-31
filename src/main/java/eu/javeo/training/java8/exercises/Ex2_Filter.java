package eu.javeo.training.java8.exercises;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class Ex2_Filter {

    private List<Integer> onlyEven(List<Integer> ints) {
        // TODO: Przefiltruj listę liczb zwracając wyłącznie parzyste // Done!
        return ints.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = onlyEven(ints);
        assertThat(result, is(Arrays.asList(2, 4, 6, 8, 10)));
    }
}
