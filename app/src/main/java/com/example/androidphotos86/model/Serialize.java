package com.example.androidphotos86.model;

import android.app.Activity;
import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize <T> extends Activity implements Serializable {
	private static final long serialVersionUID = 3438982363426716349L;
	private final String fileName = ".serialize";
	private Context context;

	public Serialize (Context context){
		//Maybe one day we won't need this;
		this.context = context;
	}

	public void serialize(T t) {
		while (lock.isLocked());
		lock.lock();
		try {
			//context = getApplicationContext();
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
		//TODO figure out if catch should actually catch errors
		while(lock.isLocked());
		lock.lock();
		T t = null;
		try {
			FileInputStream fis = context.openFileInput(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			t = (T) ois.readObject();
		} catch (Exception e) {
			//Catches bad serialization
		}

		lock.unlock();
		return t;
	}
}