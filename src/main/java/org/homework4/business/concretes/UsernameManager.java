package org.homework4.business.concretes;

import org.homework4.business.abstracts.UsernameService;
import org.homework4.repository.abstracts.OfficerRepository;

import java.util.Stack;

public class UsernameManager implements UsernameService {

    private final OfficerRepository repository;
    public UsernameManager(OfficerRepository repository) {
        this.repository = repository;
    }


    /*----------------------------------------------------------------*/

    /**
     * Recursion method
     * Checks if username is empty
     * Checks if username have only letters
     * @param username
     * @return true if username is valid
     */
    public boolean checkIfValidUsername(String username) {

        if (username.isEmpty()){
            System.out.println("It should have at least 1 character");
            return false;
        }
        // if the first character is not a letter, return false
        if (!Character.isLetter(username.charAt(0))) {
            System.out.println("It should have letters only.");
            return false;
        }

        if (username.length() == 1) {
            return true;
        }

        // check the rest of the string
        return checkIfValidUsername(username.substring(1));
    }









}
