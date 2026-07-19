package com.javarush.task.jdk13.task41.task4105.facade;

import com.javarush.task.jdk13.task41.task4105.alchemy_library.*;

public class PotionConversionFacade {
    public String convertPotion(String potionName, String convertTo){
        System.out.println("PotionConversionFacade: conversion started.");

        //  Создаём исходное зелье
        Potion potion = new Potion(potionName);

        //Определяем целевой тип
        Type targetType = Type.valueOf(convertTo.toUpperCase());

        //Извлекаем сущность исходного зелья
        Essence sourceEssence = EssenceFactory.extract(potion);
        // Выбираем конвертер для целевой сущности
        Essence destinationEssence;
        if (targetType == Type.MANA) {
            destinationEssence = new ManaEssenceConverter();
        } else if (targetType == Type.STAMINA) {
            destinationEssence = new StaminaEssenceConverter();
        } else {
            destinationEssence = new HealingEssenceConverter();
        }

        // Извлекаем порцию зелья
        Potion portion = Extractor.extractPortion(potion, sourceEssence);
        // Преобразуем порцию в нужную сущность
        Potion intermediateResult = Extractor.convert(portion, destinationEssence);
        // Финализируем результат
        Potion result = new Finalizator().fix(intermediateResult);

        System.out.println("PotionConversionFacade: conversion completed.");

        // Возвращаем название полученного зелья
        return result.getName();
    }
}
