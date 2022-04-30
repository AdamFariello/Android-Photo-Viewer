package com.example.androidphotos86;

import android.media.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Photo implements Serializable {
	//Misc
	static final long serialVersionUID = 1L;
	public Date photoDate;
	public Calendar photoCalendar;

	//Strings
	private static final String storeDir = "dat";
	private static final String storeFile = "users.dat";
	private String photoCaption, photoName, photoURL;

	//Outside
	public transient Image photoImage;
	public ArrayList<Tag> photoTags;

	public Photo(Image photoImage, String photoName) {
		//TODO figure alternative (can't import javafx)
		this.photoImage = new Image(photoImage.getUrl());
		this.photoURL = photoImage.getUrl();

		/*TODO replace this
		if (photoName.compareTo("Car.jpg") == 0) {
			this.photoURL= "data/Car.jpg";
		}
		if (photoName.compareTo("Mantis.jpg") == 0) {
			this.photoURL= "data/Mantis.jpg";
		}
		if (photoName.compareTo("Matrix.jpg") == 0) {
           this.photoURL="data/Matrix.jpg";
		}
		if (photoName.compareTo("Mountains.jpg") == 0) {
			this.photoURL="data/Mountains.jpg";
		}
		if (photoName.compareTo("Sparkler.jpg") == 0) {
			this.photoURL="data/Sparkler.jpg";
		}
		if (photoName.compareTo("Wildlife.jpg") == 0) {
			this.photoURL="data/Wildlife.jpg";
		}
		*/

		this.photoTags = new ArrayList<Tag>();
		this.photoName = photoName;
		this.photoCaption = new String();
		photoCalendar = Calendar.getInstance();
		photoCalendar.set(Calendar.MILLISECOND, 0);
		this.photoDate = photoCalendar.getTime();
	}

	public String toString() {
		return this.photoName;
	}
}
