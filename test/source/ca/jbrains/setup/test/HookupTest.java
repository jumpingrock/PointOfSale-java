package ca.jbrains.setup.test;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HookupTest {

    @Test
    public void isThisThingOn() {
        assertEquals("abc", "abc");
        assertEquals("bb", "bb");
    }
    @Test
    public void isThisThingOnish() {
        assertEquals("1", "1");

    }
}
