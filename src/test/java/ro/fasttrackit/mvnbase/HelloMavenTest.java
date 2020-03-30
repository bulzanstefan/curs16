package ro.fasttrackit.mvnbase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for Hello Maven")
class HelloMavenTest {

    @Test
    @DisplayName("WHEN we call sayHello method THEN Hello Maven is returned")
    public void whenWeCallSayHelloThenHelloMavenIsReturned() {
        //SETUP
        var helloMaven = new HelloMaven();

        //RUN
        var result = helloMaven.sayHello();

        //ASSERT
        assertNotNull(result);
        assertEquals("Hello Maven!", result);
        assertTrue(result.equals("Hello Maven!"));
        assertThat(result)
                .isEqualTo("Hello Maven!");
    }
}
