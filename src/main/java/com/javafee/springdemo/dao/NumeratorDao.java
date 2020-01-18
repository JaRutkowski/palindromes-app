package com.javafee.springdemo.dao;

import com.javafee.springdemo.entity.Numerator;

import java.util.List;

public interface NumeratorDao {
	List<Numerator> getNumerators();

	List<Numerator> searchNumeratorsByValue(String value);

	Numerator getNumeratorById(int id);

	void deleteNumerator(Numerator numerator);

	void deleteNumeratorById(int id);

	void saveNumerator(Numerator numerator);
}
