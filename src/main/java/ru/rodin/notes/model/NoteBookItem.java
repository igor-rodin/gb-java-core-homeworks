package ru.rodin.notes.model;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс, описывающий заметку
 */
public class NoteBookItem {
    /**
     * Дата и время записи заметки
     */
    private final LocalDateTime createdTime;

    /**
     * Текст заметки
     */
    private final String content;

    public NoteBookItem(String content) {
        this.createdTime = LocalDateTime.now();
        this.content = content;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * Возвращает дату и время записи заметки в формате "24.08.2023-12:13"
     * @return Дата и время записи заметки
     */
    public String getFormattedCreatedTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
        return  this.createdTime.format(formatter);
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Добавлена: {0} -> {1}\n", this.getFormattedCreatedTime(), this.content);
    }
}
