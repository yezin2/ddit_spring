package kr.or.ddit.exception;

public class NotFoundIdException extends Exception {
	public NotFoundIdException() {
		super("아이디 노존재");
	}
}
