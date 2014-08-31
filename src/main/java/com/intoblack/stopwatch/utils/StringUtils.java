package com.intoblack.stopwatch.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtils {

	private StringUtils() {

	}

	/**
	 * 判断字符串是否为空
	 * 
	 * 
	 * @param words
	 *            字符串
	 * @return 如果字符串为null 或者 length == 0 时 ， 返回true ， 否则false
	 */
	public static boolean isEmpty(String words) {
		return words == null || words.length() == 0;
	}

	/**
	 * 
	 * 判断字符串是否为有用的字符串（不为空 ， 字符串长度不为0 ， 字符串都为实际意义的字符串）
	 * 
	 * @param words
	 *            字符串
	 * @return
	 */
	public static boolean isValueableString(String words) {
		if (isEmpty(words)) {
			return true;
		}
		for (int i = 0; i < words.length(); i++) {
			if (!Character.isWhitespace(words.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static List<String> splits(String value, Character... splitWords) {
		if (isEmpty(value) || splitWords.length == 0) {
			throw new IllegalArgumentException();
		}
		List<String> words = new ArrayList<String>();
		Set<Character> splitWordSet = new HashSet<Character>();
		Collections.addAll(splitWordSet, splitWords);
		int last = 0;
		for (int i = 0; i < value.length(); i++) {
			if (splitWordSet.contains(value.charAt(i))) {
				if (last != i) {
					words.add(value.substring(last+ 1, i));
				}
				last = i;
			}
		}
		return words;
	}
	
	public static void main(String[] args) {
		System.out.println(splits("  a b c d ", ' '));
	}

}
