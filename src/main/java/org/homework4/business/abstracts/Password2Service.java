package org.homework4.business.abstracts;


public interface Password2Service {

    boolean isValidPassword(int password);

    boolean isExactDivision(int password2, int[] denominations);
}
