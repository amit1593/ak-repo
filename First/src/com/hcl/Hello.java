package com.hcl;

import java.util.HashMap;

public class Hello<K, V> {

	public static void main(String[] args) {
		Hello<String, Boolean> h = new Hello<String, Boolean>();
		System.out.println(h.put("d", false));
		Boolean v=h.put("d", false);
		System.out.println(v);
	}

	public V put(K key, V value) {
		return new HashMap<K, V>().put(key, value);
	}
}
