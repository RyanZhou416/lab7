package com.example.lab7;

public class ValidateName {

    public boolean isNameLengthValid(String name) {
        for(char c: name.toCharArray()) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return name.length() <= 10;
    }

}