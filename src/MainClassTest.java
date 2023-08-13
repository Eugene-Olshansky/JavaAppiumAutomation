import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber();
        if (a == 14)
        {
            System.out.println("Pass");
        } else System.out.println("Your number isn't equal 14");

    }
}
