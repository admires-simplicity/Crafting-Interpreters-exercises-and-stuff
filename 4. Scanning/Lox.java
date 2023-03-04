package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
	public static void main(String[] args) throws IOException {
		if (args.length > 1) {
			System.out.println("Usage: jlox [script]");
			System.exit(64); 
		} else if (args.length == 1) {
			runFile(args[0]);
			//System.out.println("passed 1 argument");
		} else {
			runPrompt();
			//System.out.println("passed no arguments");
		}
	}

	private static void runFile(String path) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get(path)); //throws IOException if "path" does not refer to real filename
		run(new String(bytes, Charset.defaultCharset()));
	}

	private static void runPrompt() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		for (;;) {
			System.out.print("> ");
			String line = reader.readLine();
			if (line == null) break;
			run(line);
		}
	}

	private static void run(String source) {
		//Scanner scanner = new Scanner(source);
		//List<Token> tokens = scanner.scanTokens();

		////for now, just print the tokens.
		//for (Token token : tokens) {
		//	System.out.println(token);
		//}

		System.out.println("PROGRAM IS RUNNED");

	}
}
