package com.javarush.task.jdk13.task41.task4112;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Bowling {
    private final Queue<Track> tracks;
    private final Queue<PairOfShoes> shoesShelf;

    public Bowling(int tracksNumber) {
        tracks = new LinkedList<>();
        for (int i = 1; i <= tracksNumber; i++) {
            tracks.add(new Track(i));
        }

        // Инициализация пула обуви (50 пар с размерами от 38 до 45)
        shoesShelf = new LinkedList<>();
        int[] sizes = {38, 39, 40, 41, 42, 43, 44, 45};
        int baseCount = 50 / sizes.length;      // 6
        int extra = 50 % sizes.length;          // 2
        for (int size : sizes) {
            int count = baseCount + (extra > 0 ? 1 : 0);
            if (extra > 0) extra--;
            for (int j = 0; j < count; j++) {
                shoesShelf.add(new PairOfShoes(size));
            }
        }
    }

    public synchronized Track acquireTrack() {
        Track track = tracks.poll();
        if (track != null) {
            // Цена зависит от количества оставшихся дорожек
            int price = 100 - tracks.size() * 10;
            track.setPrice(price);
        }
        return track;
    }

    public synchronized void releaseTrack(Track track) {
        if (track != null) {
            System.out.printf("C дорожки №%d сняли бронь\n", track.getNumber());
            tracks.offer(track);
        }
    }

    public synchronized Set<PairOfShoes> acquireShoes(int number) {
        if (shoesShelf.size() < number) {
            return null;   // недостаточно обуви – ничего не забираем
        }
        Set<PairOfShoes> shoes = new HashSet<>();
        for (int i = 0; i < number; i++) {
            shoes.add(shoesShelf.poll());
        }
        return shoes;
    }

    public synchronized void releaseShoes(Set<PairOfShoes> shoes) {
        if (shoes != null) {
            System.out.printf("В гардероб вернули %d пар обуви\n", shoes.size());
            for (PairOfShoes shoe : shoes) {
                shoesShelf.offer(shoe);
            }
        }
    }
}

