package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        //напишите тут ваш код
        if(url.startsWith("http://"))    //  сравнили строку по ее началу
            return "http";
        else if(url.startsWith("https://"))
            return "https";
        else
            return "неизвестный";
    }

    public static String checkDomain(String url) {
        //напишите тут ваш код
        if(url.endsWith("com"))    //сравнили строку по ее окончанию
            return "com";
        else if(url.endsWith("net"))
            return "net";
        else if(url.endsWith("org"))
            return "org";
        else if (url.endsWith("ru"))
            return "ru";
        else
            return "неизвестный";
        }

    }

