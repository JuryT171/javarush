package com.javarush.task.jdk13.task17.task1701;

import java.util.ArrayList;
import java.util.List;

/* 
Заметки
*/

public class Solution {

    public static class NoteThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) { //  цикл на 100 итераций
            String noteName = getName() + "-Note"+i;  //  формируем имя
            Note.addNote(noteName); //  добавляем заметку в список
            try{
                Thread.sleep(1);  // минимальная задержка
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Note.removeNote(getName()); // удаляем заметку
            }
        }
    }
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class Note {

        public static final List<String> NOTES = new ArrayList<>();

        public static void addNote(String note) {
            NOTES.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = NOTES.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }
}
