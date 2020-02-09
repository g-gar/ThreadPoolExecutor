package com.ggar.framework.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class EnumUtils {

	public static <E extends Enum<E>, R> R iterate(Class<E> enumeration, Function<E, R> function) {		
		return EnumUtils.iterate(enumeration, function, Comparator.naturalOrder());
	}
	
	public static <E extends Enum<E>, R> R iterate(Class<E> enumeration, Function<E, R> function, Comparator<E> comparator) {
		E[] values = (E[]) enumeration.getEnumConstants();
		Arrays.sort(values, comparator);
		
		R result = null;
		out:
		for (E value : values) {
			result = function.apply(value);
			if (result != null) {
				break out;
			}
		}
		
		return result;
	}
	
}
