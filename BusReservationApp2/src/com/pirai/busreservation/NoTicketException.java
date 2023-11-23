package com.pirai.busreservation;

public class NoTicketException extends Exception{
	@Override
	public String getMessage() {
		return "Sorry! Bus is full. Try another bus or date";
	}

}
