package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> wrong2 = App.take(List.of(1,2,3,4,5), 10);
        assertThat(wrong2).isEqualTo(Arrays.asList(1,2,3,4,5));
        // END
    }
}
