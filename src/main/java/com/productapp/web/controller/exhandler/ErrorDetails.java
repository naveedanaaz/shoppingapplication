package com.productapp.web.controller.exhandler;

import java.time.LocalDateTime;

public class ErrorDetails {
private String message;
private LocalDateTime timeStamp;
private String detail;
private String contactTo;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public String getContactTo() {
	return contactTo;
}
public void setContactTo(String contactTo) {
	this.contactTo = contactTo;
}
public ErrorDetails(String message, LocalDateTime timeStamp, String detail, String contactTo) {
	super();
	this.message = message;
	this.timeStamp = timeStamp;
	this.detail = detail;
	this.contactTo = contactTo;
}
@Override
public String toString() {
	return "ErrorDetails [message=" + message + ", timeStamp=" + timeStamp + ", detail=" + detail + ", contactTo="
			+ contactTo + "]";
}
public ErrorDetails() {
}

}
