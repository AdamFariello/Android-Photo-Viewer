package com.example.androidphotos86;
/**
 * 
 * @author Edison & Adam
 *
 */
public class lock {
	private static boolean lock;
	/** methods to lock / unlock photos */
	public static void init() {
		//false := it is not locked
		//true 	:= it is locked
		lock = false;
	}
	
	//Originally I used xOR, but I thought
	//this would look better 
	/** sets lock to true */
	public static void lock() {
		lock = true;
	}
	/** sets lock to false */
	public static void unlock() {
		lock = false;
	}
	/** getter for lock, @return */
	public static boolean isLocked() {
		return lock;
	}
}