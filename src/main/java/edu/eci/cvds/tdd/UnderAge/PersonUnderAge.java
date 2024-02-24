package edu.eci.cvds.tdd.UnderAge;

public class PersonUnderAge {
    public boolean isUnderAge(int age) throws Exception {
        if(0 <= age && age <= 17){
            return true;
        }else if( 18 <= age && age <= 150){
            return false;
        }else {
            throw new Exception("Edad invalida");
        }
    }
}
