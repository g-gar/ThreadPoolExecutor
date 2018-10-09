package com.ggar.thread;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class EnumUtils {

	public static <E extends Enum<E>, R> R iterate(E enumeration, Function<E, R> function) {		
		return EnumUtils.iterate(enumeration, function, Comparator.naturalOrder());
	}
	
	public static <E extends Enum<E>, R> R iterate(E enumeration, Function<E, R> function, Comparator<E> comparator) {
		E[] values = (E[]) enumeration.getClass().getEnumConstants();
		Arrays.sort(values, comparator);
		
		R result = null;
		for (E value : values) {
			result = function.apply(value);
			if (result != null) {
				break;
			}
		}
		
		return result;
	}
	
}
