package com.javafee.springdemo.service;

import com.javafee.springdemo.entity.Numerator;
import com.javafee.springdemo.exception.NumberRangeException;

import java.util.List;
import java.util.Set;

public interface NumeratorService {
    List<Numerator> getNumerators();

    List<Numerator> searchNumeratorsByValue(String value);

    Numerator getNumeratorById(int id);

    void deleteNumerator(Numerator numerator);

    void deleteNumeratorById(int id);

    void saveNumerator(Numerator numerator);

    boolean checkNumberIsPalindrome(int nr);

    void checkNumberCorrectness(int value) throws NumberRangeException;

    Set<Numerator> generatePalindromesFromSpecificInterval(int interval[]);
}
