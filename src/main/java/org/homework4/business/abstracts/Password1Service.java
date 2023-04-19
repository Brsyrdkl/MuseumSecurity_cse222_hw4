package org.homework4.business.abstracts;

public interface Password1Service {

    boolean isValidPassword(String password);

    boolean containsUserNameSpirit(String username, String password1);

    boolean isBalancedPassword(String password1);

    boolean isPalindromePossible(String password1);
}
