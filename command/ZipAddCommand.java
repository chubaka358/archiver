package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
	@Override
	public void execute() throws Exception {
		try {
			ConsoleHelper.writeMessage("Добавление файла в архив.");

			ZipFileManager zipFileManager = getZipFileManager();

			ConsoleHelper.writeMessage("Введите полный путь файла.");
			Path path = Paths.get(ConsoleHelper.readString());
			zipFileManager.addFile(path);
		} catch (PathIsNotFoundException e){
			ConsoleHelper.writeMessage("Путь не найден.");
		}
	}
}
