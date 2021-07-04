package com.example.restfulwebservice.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GreetingTest {

    private static final long GREETING_ID_1 = 1L;
    private static final long GREETING_ID_2 = 2L;

    private static final String GREETING_CONTENT_1 = "CONTENT_1";
    private static final String GREETING_CONTENT_2 = "CONTENT_2";

    @Nested
    class EqualsMethod {

        @Test
        void shouldBeEqualForSameObject() {
            Greeting greeting = new Greeting();

            assertThat(greeting).isEqualTo(greeting);
        }

        @Test
        void shouldNotBeEqualWhenObjectComparedIsNull() {
            Greeting greeting = new Greeting();

            assertThat(greeting).isNotEqualTo(null);
        }

        @Test
        void shouldNotBeEqualWhenClassIsDifferent() {
            Greeting greeting = new Greeting();

            assertThat(greeting).doesNotHaveSameClassAs(new Object());
        }

        @Test
        void shouldBeEqualForSameId(){
            Greeting greeting1 = new Greeting();
            greeting1.setId(GREETING_ID_1);

            Greeting greeting2 = new Greeting();
            greeting2.setId(GREETING_ID_1);

            assertThat(greeting1).isEqualTo(greeting2);
        }

        @Test
        void shouldNotBeEqualForDifferentId(){
            Greeting greeting1 = new Greeting();
            greeting1.setId(GREETING_ID_1);

            Greeting greeting2 = new Greeting();
            greeting2.setId(GREETING_ID_2);

            assertThat(greeting1).isNotEqualTo(greeting2);
        }

        @Test
        void shouldBeEqualForSameContent(){
            Greeting greeting1 = new Greeting();
            greeting1.setContent(GREETING_CONTENT_1);

            Greeting greeting2 = new Greeting();
            greeting2.setContent(GREETING_CONTENT_1);

            assertThat(greeting1).isEqualTo(greeting2);
        }

        @Test
        void shouldNotBeEqualForDifferentContent(){
            Greeting greeting1 = new Greeting();
            greeting1.setContent(GREETING_CONTENT_1);

            Greeting greeting2 = new Greeting();
            greeting2.setContent(GREETING_CONTENT_2);

            assertThat(greeting1).isNotEqualTo(greeting2);
        }
    }

    @Nested
    class Properties {

        @Test
        void shouldSetGetId() {
            Greeting greeting = new Greeting();
            greeting.setId(GREETING_ID_1);

            assertThat(greeting.getId()).isEqualTo(GREETING_ID_1);
        }

        @Test
        void shouldSetGetContent() {
            Greeting greeting = new Greeting();
            greeting.setContent(GREETING_CONTENT_1);

            assertThat(greeting.getContent()).isEqualTo(GREETING_CONTENT_1);
        }
    }
    
}
