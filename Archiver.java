package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Operation operation = null;
		do{
			try {
				operation = askOperation();
				CommandExecutor.execute(operation);
			} catch (WrongZipFileException exception){
				ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
			} catch (Exception exception){
				ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
			}
		} while	(operation != operation.EXIT);
	}

	public static Operation askOperation() throws IOException {
		ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - упаковать файлы в архив");
		ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - добавить файл в архив");
		ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - удалить файл из архива");
		ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - распаковать архив");
		ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - просмотреть содержимое архива");
		ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - выход");
		int operationNumber = ConsoleHelper.readInt();
		return Operation.values()[operationNumber];
	}
}
