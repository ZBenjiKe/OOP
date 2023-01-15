package Exercise0;

import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;


class USBtest {
	
	//	UndoableStringBuilder usb = new UndoableStringBuilder();
	
	@Test
	public void appendStringToNewUsb() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append("test");
		assertEquals("t", usb.stb.toString());
	}

	@Test
	void appendNullStringToUsb() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append(null);
		System.out.println(usb.stb.toString().equals("null"));
	}
	
	@Test
	void appendEmptyString() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append("");
		System.out.println(usb.stb.toString().equals(""));
	}
	
	@Test
	void appendStringToUsb() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append("test");
		usb.append(" appended string");
		System.out.println(usb.stb.toString().equals("test appended string"));
	}
	
	@Test
	void deleteStringFromExisitingStringInUsb() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append("test me please");
		usb.delete(4, 6);
		System.out.println(usb.stb.toString().equals("test appended string"));
	}

	@Test
	public void reverseString() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append("test me");
		usb.reverse();
		assertEquals("em tset", usb.stb.toString());
	}
	
	@Test
	public void reverseEmptyString() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.reverse();
		assertEquals("", usb.stb.toString());
	}
	
	@Test
	public void undoOnce() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append("undo this");
		usb.undo();
		assertEquals("", usb.stb.toString());
	}
	
	@Test
	public void undoThrice() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.append("undo this");
		usb.delete(0, 2);
		usb.reverse();
		usb.undo();
		usb.undo();
		usb.undo();
		assertEquals("", usb.stb.toString());
	}
	
	@Test
	public void undoNothingToUndo() {
		UndoableStringBuilder usb = new UndoableStringBuilder();
		usb.undo();
		assertEquals("", usb.stb.toString());
	}

}
