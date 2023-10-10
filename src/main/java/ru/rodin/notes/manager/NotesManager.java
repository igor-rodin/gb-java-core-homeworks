package ru.rodin.notes.manager;

import ru.rodin.notes.model.NoteBookItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Класс содержит методы для управления заметками при их записи в файл
 */

public class NotesManager {

    /**
     * Путь к файлу с заметками
     */
    private final Path notesFile;

    /**
     * Конструктор
     * @param notesFile Имя файла для хранения заметок
     */
    public NotesManager(String notesFile) {
        this.notesFile = Path.of(System.getProperty("user.dir"), notesFile);
    }

    /**
     * Добавляет заметку в файл
     * @param contentNote Текст заметки
     * @return Созданную заметку или null
     */
    public NoteBookItem writeNote(String contentNote) {
        NoteBookItem item = new NoteBookItem(contentNote);
        try {
            Files.createFile(this.notesFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            Files.writeString(this.notesFile, item.toString(), StandardOpenOption.APPEND);
            return item;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Получает список заметок из файла
     * @return Список заметок
     */
    public List<String> readNotes() {
        List<String> notes = null;
        try {
            notes = Files.readAllLines(notesFile);
        } catch (IOException e) {
            System.out.println("Файла с заметками не существует");
        }
        return notes;
    }

}
