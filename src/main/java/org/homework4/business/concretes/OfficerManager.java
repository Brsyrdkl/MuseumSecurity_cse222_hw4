package org.homework4.business.concretes;

import org.homework4.business.abstracts.Password1Service;
import org.homework4.business.abstracts.Password2Service;
import org.homework4.business.abstracts.UsernameService;
import org.homework4.entities.Officer;
import org.homework4.repository.abstracts.OfficerRepository;

public class OfficerManager {

    private final OfficerRepository repository;

    private UsernameService usernameService;
    private Password1Service password1Service;
    private Password2Service password2Service;


    public OfficerManager(OfficerRepository repository) {
        this.repository = repository;
        this.usernameService = new UsernameManager(repository);
        this.password1Service = new Password1Manager(repository);
        this.password2Service = new Password2Manager(repository);
    }

    public void checkAllValidations(Officer officer){

        System.out.println("Checking all validations for "+ officer.getUsername());
        if(!usernameService.checkIfValidUsername(officer.getUsername())){
            throw new RuntimeException("The username is invalid due to " +
                    "not contains only letter or length is less than 1.Try again...");
        }
        if(!password1Service.isValidPassword(officer.getPassword1())){
            throw new RuntimeException("The string password is invalid due to " +
                    "password is not at least 8 characters long or\n" +
                    "password not contains only letter and bracket or\n" +
                    "password not contains at least 2 brackets.Try again...");
        }
        if(!password2Service.isValidPassword(officer.getPassword2())){
            throw new RuntimeException("The integer password is invalid due to " +
                    "the password is not between 10 and 10000.Try again...");
        }
        if(!password1Service.containsUserNameSpirit(officer.getUsername(), officer.getPassword1())){
            throw new RuntimeException("The string password is invalid due to " +
                    "password not contains at least one letter of the username.Try again...");
        }
        if(!password1Service.isBalancedPassword(officer.getPassword1())){
            throw new RuntimeException("The string password is invalid due to " +
                    "two brackets are not matching.Try again...");
        }
        if(!password1Service.isPalindromePossible(officer.getPassword1())){
            throw new RuntimeException("The string password is invalid due to " +
                    "there is no palindrome");
        }
        if(!password2Service.isExactDivision(officer.getPassword2(), new int[]{4, 17, 29})){
            throw new RuntimeException("The integer password is invalid due to " +
                    "there is no exact denominations.Try again...");
        }

        System.out.println("The username and passwords are valid. The door is opening, please wait...");;
    }

}
