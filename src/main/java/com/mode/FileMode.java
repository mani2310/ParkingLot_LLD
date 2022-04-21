package main.java.com.mode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import main.java.com.processor.CommandProcessor;

public class FileMode implements Mode{
	private String fileName;
	public FileMode(String fileName)
	{
		this.fileName = fileName;
	}

	@Override
	public void process() throws IOException {
		 File file = new File(fileName);
	     BufferedReader reader;
	    try {
	      reader = new BufferedReader(new FileReader(file));
	    } catch (FileNotFoundException e) {
	      System.out.println("Invalid File");
	      return;
	    }

	    String inputLine = reader.readLine();
	    while (inputLine != null) {
	      String[] input = inputLine.split(" ");
	      new CommandProcessor().processCommand(input);
	      inputLine = reader.readLine();;
	    }
	}

}
