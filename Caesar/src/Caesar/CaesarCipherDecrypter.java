package Caesar;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CaesarCipherDecrypter implements Callable<String> {
	private String decryptedMessage;
	private String originalMessage;
	private int shift;
	static String[] arr = new String[26];

	

	CaesarCipherDecrypter() {
	}

	public CaesarCipherDecrypter(String message, int shift) {
		this.shift = shift;
		this.originalMessage = message;
		decryptedMessage = decryptText(message);
	}

	public String decryptText(String text) {
		this.originalMessage = text;
		char[] decodedText = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			decodedText[i] = decryptCharacter(text.charAt(i));
		}
		this.decryptedMessage = new String(decodedText);
		return this.decryptedMessage;
	}

	public char decryptCharacter(char originalChar) {
		int decodedChar;
		if (originalChar >= 'A' && originalChar <= 'Z') {
			decodedChar = originalChar - shift;
			if (decodedChar < 'A') {
				decodedChar = decodedChar + 26;
			}
		} else if (originalChar >= 'a' && originalChar <= 'z') {
			decodedChar = originalChar - shift;
			if (decodedChar < 'a') {
				decodedChar = decodedChar + 26;
			}
		} else {
			decodedChar = originalChar;
		}
		return (char) decodedChar;
	}

	String getOriginalMessage() {
		return originalMessage;
	}

	void setOriginalMessage(String originalMessage) {
		this.originalMessage = originalMessage;
	}

	int getShift() {
		return shift;
	}

	void setShift(int shift) {
		this.shift = shift;
	}

	public String getDecryptedMessage() {
		return decryptedMessage;
	}

	@Override
	public String call() throws Exception {
		return  getShift() + ": " + getDecryptedMessage();
	}
}