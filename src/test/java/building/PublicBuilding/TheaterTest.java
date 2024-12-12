
package building.PublicBuilding;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Acer
 */
@DisplayName("theater test")
public class TheaterTest {
    
    public static Stream<Arguments> testingTimes(){

        return Stream.of(
            Arguments.of(LocalTime.parse("10:00:00"), false),
            Arguments.of(LocalTime.parse("16:00:00"), true),
            Arguments.of(LocalTime.parse("20:00:00"), true),
            Arguments.of(LocalTime.parse("23:59:59"), false)
            );
    }

    @ParameterizedTest
    @MethodSource("testingTimes")
    @DisplayName("is opened at specific time test")
    public void isOpenedTest(LocalTime time, boolean expectedd){
        
        var theater = new Theater();
        
        assertThat(theater.isOpenedAt(DayOfWeek.MONDAY, time)).isEqualTo(expectedd);
    }
}
