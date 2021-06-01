package kr.or.ddit.exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException() {
		super("패스워드 노일치");
	}
}
