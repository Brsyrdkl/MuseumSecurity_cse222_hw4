package org.homework4.business.concretes;

import org.homework4.business.abstracts.Password2Service;
import org.homework4.repository.abstracts.OfficerRepository;

import java.util.Stack;

public class Password2Manager implements Password2Service {

    private final OfficerRepository repository;
    private Stack<Integer> passwords2;

    public Password2Manager(OfficerRepository repository) {
        this.repository = repository;
        passwords2 = new Stack<Integer>();

        for(int i = 0; i < repository.getOfficers().size() ; i++) {
            passwords2.push(repository.getOfficers().get(i).getPassword2());
        }

    }

    /**
     * Checks password2 is between 10 and 10000
     * @param password
     * @return true if password2 is valid
     */

    public boolean isValidPassword(int password) {
        // Check if the password is between 10 and 10000
        if (password < 10 || password > 10000) {
            System.out.println("It should be between 10 and 10,000.");
            return false;
        }

        // All checks passed, so the password is valid
        return true;
    }

    /**
     * Calls recursion method
     * @param password2
     * @param denominations
     * @return false if solution not found
     */
    public boolean isExactDivision(int password2, int[] denominations) {
        return isExactDivisionRecursion(password2, denominations, 0);
    }

    /**
     * Checks if it is possible to obtain the password by the summation of denominations along with arbitrary coefficients,
     * which are non-negative integers
     * @param password2
     * @param denominations
     * @param index
     * @return false if solution not found
     */

    private boolean isExactDivisionRecursion(int password2, int[] denominations, int index) {
        // Base cases
        if (password2 == 0) {
            return true; // password2 has been achieved
        }
        if (index == denominations.length) {
            return false; // no more denominations left to try
        }
        // Recursive cases
        for (int i = 0; i <= password2 / denominations[index]; i++) {
            if (isExactDivisionRecursion(password2 - i * denominations[index], denominations, index + 1)) {
                return true; // solution found
            }
        }
        return false; // solution not found
    }





}
