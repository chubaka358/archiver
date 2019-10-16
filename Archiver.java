package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите полный путь к архиву");
		Path path = Paths.get(reader.readLine());
		ZipFileManager zipFileManager = new ZipFileManager(path);
		System.out.println("Введите полный путь к файлу, который необходимо архивировать");
		zipFileManager.createZip(Paths.get(reader.readLine()));
		ExitCommand exitCommand = new ExitCommand();
		exitCommand.execute();
	}
}
