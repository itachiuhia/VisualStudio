package TestingJava;

import java.io.*;

interface intfa{
    void m1();
}

interface intfb{
    void m2();
}

class sample implements intfa, intfb{
    @Override
    public void m1(){
        System.out.println("Inside m1");
    }

    @Override
    public void m2(){
        System.out.println("Inside m2");
    }
}

class InterfaceExp {
    public static void main(String[] args) {
        sample ob1 = new sample();

        ob1.m1();
        ob1.m2();
    }
}

