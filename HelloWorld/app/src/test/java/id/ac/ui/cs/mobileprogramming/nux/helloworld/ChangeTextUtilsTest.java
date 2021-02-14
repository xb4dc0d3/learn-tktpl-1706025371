package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import static org.junit.Assert.*;
import org.junit.Test;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.Utils.ChangeTextUtils;

public class ChangeTextUtilsTest {

    @Test
    public void checkIfDefaultHelloWorldText(){
        ChangeTextUtils chg = new ChangeTextUtils();
        assertEquals(String.class, chg.generateText().getClass());
    }

    @Test
    public void checkIfAnotherHelloWorldText(){
        ChangeTextUtils chg = new ChangeTextUtils();
        assertNotSame("Hello World", chg.generateText());
    }
}
