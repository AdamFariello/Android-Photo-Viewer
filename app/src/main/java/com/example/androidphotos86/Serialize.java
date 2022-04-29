package com.example.androidphotos86;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize <T> implements Serializable {
	private static final long serialVersionUID = 3438982363426716349L;
	//private final File file = new File(".serialize");
	private final String fileName = ".serialize";
	private Context context;

	public Serialize(Context context) {
		//This is required because you can't get the
		//context from the class calling this class
		this.context = context;
	}

	public void serialize(T t) {
		while (lock.isLocked());
		lock.lock();
		try {
			FileOutputStream fos = context.openFileOutput(
					fileName, Context.MODE_PRIVATE
			);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t);
		} catch (Exception e) {
			System.out.println("[DEBUG] serialize.serialize");
			System.out.println(e);
		}
		lock.unlock();
	}

	public T deserialize() {
		while(lock.isLocked());
		lock.lock();
		T t = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(fileName)
			);
			t = (T) ois.readObject();
		} catch (Exception e) {
			//Catc hes empty list or bad serializations
		}
		lock.unlock();
		return t;
	}
}