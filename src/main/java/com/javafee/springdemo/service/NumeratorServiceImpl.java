package com.javafee.springdemo.service;

import com.javafee.springdemo.dao.NumeratorDao;
import com.javafee.springdemo.entity.Numerator;
import com.javafee.springdemo.exception.NumberRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NumeratorServiceImpl implements NumeratorService {
    @Autowired
    private NumeratorDao numeratorDao;

    @Transactional
    @Override
    public List<Numerator> getNumerators() {
        return numeratorDao.getNumerators();
    }

    @Transactional
    @Override
    public List<Numerator> searchNumeratorsByValue(String value) {
        return numeratorDao.searchNumeratorsByValue(value);
    }

    @Transactional
    @Override
    public Numerator getNumeratorById(int id) {
        return numeratorDao.getNumeratorById(id);
    }

    @Transactional
    @Override
    public void deleteNumerator(Numerator numerator) {
        numeratorDao.deleteNumerator(numerator);
    }

    @Transactional
    @Override
    public void deleteNumeratorById(int id) {
        numeratorDao.deleteNumeratorById(id);
    }

    @Transactional
    @Override
    public void saveNumerator(Numerator numerator) {
        numeratorDao.saveNumerator(numerator);
    }

    @Override
    public boolean checkNumberIsPalindrome(int nr) {
        int reverseNumber = 0;
        int tmp = nr;
        while (tmp != 0) {
            reverseNumber = reverseNumber * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return nr == reverseNumber;
    }

    @Override
    public void checkNumberCorrectness(int value) throws NumberRangeException {
        if (value < 0) {
            throw new NumberRangeException("The given number is incorrect because it's negative.");
        }
    }
    @Override
    public Set<Numerator> generatePalindromesFromSpecificInterval(int interval[]) {
        Set<Numerator> nrs = new HashSet<>();
        for (int number = interval[0]; number <= interval[1]; number++) {
             if (checkNumberIsPalindrome(number)) {
                Numerator n = new Numerator(null, number, new Date(), true);
                nrs.add(n);
            }
        }
        return nrs;
    }
}
