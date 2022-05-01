package com.example.androidphotos86.fotoTools;

import java.io.Serializable;

public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	public String type, value;

	public Tag(String type, String value) {
		this.type=type;
		this.value=value;
	}

	public String toString() {
		return this.type+ "=" + this.value+ " ";
	}

	public boolean equals (Object o) {
		if (o == null || !(o instanceof Tag))
			return false;
		Tag other = (Tag) o;
		return type.equalsIgnoreCase(other.type) && value.equalsIgnoreCase(other.value);
	}
}
