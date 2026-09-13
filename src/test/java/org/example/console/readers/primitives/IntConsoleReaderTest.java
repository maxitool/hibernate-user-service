package org.example.console.readers.primitives;

import org.example.console.readers.primitives.responses.IntResponse;
import org.example.console.readers.primitives.responses.StringResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IntConsoleReaderTest extends AbstractConsoleReaderTest {

    @Test
    public void when_getInt_then_returnResponseWithOkState() {
        provideInput("123");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.OK, response.state);
        assertEquals(123, response.intData);
    }

    @Test
    public void when_getNegativeInt_then_returnResponseWithOkState() {
        provideInput("-123");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.OK, response.state);
        assertEquals(-123, response.intData);
    }

    @Test
    public void when_getIntAndSpaces_then_returnResponseWithOkState() {
        provideInput(" 100 000 000 ");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.OK, response.state);
        assertEquals(100000000, response.intData);
    }

    @Test
    public void when_getBeyondRangeInt_then_returnResponseWithCantConvertState() {
        provideInput("1232834823482394823948923");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.CANT_CONVERT, response.state);
        assertFalse(response.errorMessage.isEmpty());
    }

    @Test
    public void when_getDouble_then_returnResponseWithCantConvertState() {
        provideInput("123.43");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.CANT_CONVERT, response.state);
        assertFalse(response.errorMessage.isEmpty());
    }

    @Test
    public void when_getEmpty_then_returnResponseWithBadResponseState() {
        provideInput("");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.BAD_RESPONSE, response.state);
        assertFalse(response.errorMessage.isEmpty());
    }

    @Test
    public void when_getString_then_returnResponseWithCantConvertState() {
        provideInput("data");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.CANT_CONVERT, response.state);
        assertFalse(response.errorMessage.isEmpty());
    }

    @Test
    public void when_getBoolean_then_returnResponseWithCantConvertState() {
        provideInput("true");

        IntResponse response = IntConsoleReader.getIntData();

        assertEquals(StringResponse.States.CANT_CONVERT, response.state);
        assertFalse(response.errorMessage.isEmpty());
    }
}
