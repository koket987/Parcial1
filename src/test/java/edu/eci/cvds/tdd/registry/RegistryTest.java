package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Santiago",10,20,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        person.setId(1);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateDeadResult() {
        Person person = new Person("Santiago",10,20,Gender.MALE,true);
        person.setAlive(false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
        person.setAlive(true);
        person.setId(1);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }


    @Test
    public void validateUnderageResult() {
        Person person = new Person("Santiago",10,20,Gender.MALE,true);
        person.setAge(17);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        person.setAge(18);
        person.setId(1);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        person.setId(2);
        person.setAge(19);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateInvalidAGEResult() {
        Person person = new Person("Santiago", 10, 20, Gender.MALE, true);
        person.setAge(-100);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        person.setId(1);
        person.setAge(0);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        person.setId(2);
        person.setAge(134);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        person.setId(3);
        person.setAge(135);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        person.setId(4);
        person.setAge(136);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        person.setId(5);
        person.setAge(20000);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateIdEqualsResult() {
        Person person = new Person("Santiago",10,20,Gender.MALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
        Person person1 = new Person("Juan",11,22,Gender.MALE,true);
        result = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result);
        result = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }



    // TODO Complete with more test cases
}