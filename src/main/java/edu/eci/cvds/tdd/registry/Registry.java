package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Registry {
    HashSet<Integer> voters = new HashSet<Integer>();
    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
        if(!p.isAlive()){
            return RegisterResult.DEAD;
        } else if (0<=p.getAge()&& p.getAge()<18) {
            return  RegisterResult.UNDERAGE;
        }else if(0>p.getAge()||p.getAge()>135){
            return  RegisterResult.INVALID_AGE;
        }else if(voters.contains(p.getId())){
            return RegisterResult.DUPLICATED;
        }else {
            voters.add(p.getId());
            return RegisterResult.VALID;
        }
    }

}