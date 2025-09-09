package l00Doubts;

import java.io.*;

public class ConsoleDemo {

	public static void main(String[] args) {
		
		Console console = System.console();
        
        if (console == null) {
            System.out.println("No console available (probably running inside IDE).");
            return;
        }

        String name = console.readLine("Enter your name: ");
        console.printf("Hello, %s!\n", name);
	}

}
