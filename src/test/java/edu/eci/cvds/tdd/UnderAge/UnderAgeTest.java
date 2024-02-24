package edu.eci.cvds.tdd.UnderAge;
import edu.eci.cvds.tdd.registry.Person;
import org.junit.Assert;
import org.junit.Test;


public class UnderAgeTest {
    private boolean underAge;
    @Test
    public void validAge() throws Exception {
        PersonUnderAge p = new PersonUnderAge();
        underAge = p.isUnderAge(17);
        Assert.assertTrue("underAge",underAge);
        underAge = p.isUnderAge(1);
        Assert.assertTrue(underAge);
    }
    @Test
    public void invalidAge() throws Exception {
        PersonUnderAge p = new PersonUnderAge();
        underAge = p.isUnderAge(18);
        Assert.assertFalse(underAge);
        underAge = p.isUnderAge(150);
        Assert.assertFalse(underAge);
    }

    @Test(expected = java.lang.Exception.class)
    public void errorAge() throws Exception {
        PersonUnderAge p = new PersonUnderAge();
        p.isUnderAge(-1);
        p.isUnderAge(-1000);
        p.isUnderAge(151);

    }
}
