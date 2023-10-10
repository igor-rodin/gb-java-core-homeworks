package ru.rodin.notes.app;

import ru.rodin.notes.manager.NotesManager;
import ru.rodin.notes.model.NoteBookItem;
import ru.rodin.notes.ui.ConsoleUI;

/**
 * В классе описана логика работы приложения по управлению заметками
 */
public class NotesApp {
    private final String NOTES_FILE = "notes.txt";
    private final NotesManager notesManager  = new NotesManager(NOTES_FILE);
    private final ConsoleUI consoleUI = new ConsoleUI();

    /**
     * Главный цикл обработки запросов от пользователя
     */
    public void run() {
        while (true) {
            switch (consoleUI.showNotesMenu()) {
                case EXIT -> {
                    System.out.println("Выходим");
                    return;
                }
                case ADD -> {
                    String note = consoleUI.getNoteDescription();
                    NoteBookItem newItem = notesManager.writeNote(note);
                    if (newItem != null){
                        System.out.println("Заметка добавлена в файл: " + newItem.toString());
                    }
                    else {
                        System.out.println("Заметка не была добавлена");
                    }
                }
                case SHOW_ALL -> {
                    consoleUI.showNotes(notesManager.readNotes());
                }
            };

        }
    }
}
