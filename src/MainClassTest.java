import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassString()
    {
        MainClass main = new MainClass();
        String class_string = main.getClassString();
        Assert.assertTrue("text doesnt contain 'hello' or 'Hello'",
                class_string.contains("hello")||class_string.contains("Hello"));
    }
}