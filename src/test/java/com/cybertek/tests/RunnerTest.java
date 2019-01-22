package com.cybertek.tests;

public class RunnerTest {
    public static void main(String[] args) throws InterruptedException {

        ErrorValidation e1 = new ErrorValidation();
        e1.wrongUserNameTest();
        e1.wrongPasswordtest();
        e1.noUsernameTest();
        e1.noPasswordTest();
        e1.test();
    }
}
