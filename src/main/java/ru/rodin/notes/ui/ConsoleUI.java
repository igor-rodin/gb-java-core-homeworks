package ru.rodin.notes.ui;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * Класс содержит методы для взаимодействия с консолью
 */
public class ConsoleUI {
    Scanner scanner = new Scanner(System.in);

    /**
     * Выводит основное меню приложения
     * @return Выбор, сделанный пользователем
     */
    public MenuAction showNotesMenu() {
        String menuMessage = MessageFormat.format(
                "Добавить заметку - нажмите {0}\nПоказать все - нажмите {1}\nВыйти - {2}",
                MenuAction.ADD.ordinal(),
                MenuAction.SHOW_ALL.ordinal(),
                MenuAction.EXIT.ordinal());
        System.out.println("---------------------------------------------");
        System.out.println(menuMessage);
        System.out.println("---------------------------------------------");

        while (true) {
            try {
                System.out.printf("%s (%d - %d): ", "Выберите действие: ", MenuAction.ADD.ordinal(),
                        MenuAction.EXIT.ordinal());
                scanner = new Scanner(System.in);
                return MenuAction.values()[scanner.nextInt()];
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Некорректное действие!");
            }
        }
    }

    /**
     * Запрашивает у пользователя текст заметки
     * @return Текст заметки
     */
    public String getNoteDescription() {
        System.out.println("Введите текст заметки: ");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Выводит сохраненные в файл заметки на консоль
     * @param noteBookItems Список заметок в файле
     */
    public void showNotes(List<String> noteBookItems) {
        if (noteBookItems == null) {
            System.out.println("Заметок еще нет!");
            return;
        }
        System.out.println("Все заметки");
        for (int i = 0; i < noteBookItems.size(); i++) {
            System.out.println(MessageFormat.format("{0}: {1}", i, noteBookItems.get(i)));
        }
    }

    /**
     * Перечисление содержит действия, доступные для пользователя
     */
    public enum MenuAction {
        /**
         * Добавить заметку
         */
        ADD,
        /**
         * Показать все заметки
         */
        SHOW_ALL,

        /**
         * Выйти из приложения
         */
        EXIT
    }
}
