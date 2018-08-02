package com.dhruv.util;

public class Singleton {

	private static Singleton INSTANCE = null;

	private Singleton() {

	}

	public static Singleton getInstance() {

		if (INSTANCE == null) {

			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}

		}
		return INSTANCE;
	}

	public void printme() {
		System.out.println("test");
	}
}
