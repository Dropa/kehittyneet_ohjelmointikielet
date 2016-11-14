package com.tasks3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dropa on 14.11.2016.
 */
public class Task3 {
    public static void main(String[] args) {
        GraphicalObject[] go;
        go = new GraphicalObject[20];

        for (int i = 0; i < 20; i++) {
            int x = ThreadLocalRandom.current().nextInt(-200, 200);
            int y = ThreadLocalRandom.current().nextInt(-200, 200);
            if (Math.random() < 0.5) {
                float r = ThreadLocalRandom.current().nextFloat() * 100f;
                go[i] = new Circle(x,y,r);
            }
            else {
                float h = ThreadLocalRandom.current().nextFloat() * 100f;
                float w = ThreadLocalRandom.current().nextFloat() * 100f;
                go[i] = new Rectangle(x,y,h,w);
            }
        }
        int circles = 0;
        int rectangles = 0;
        for (int i = 0; i < go.length; i++) {
            if (go[i] instanceof Circle) {
                circles++;
            }
            else if (go[i] instanceof Rectangle) {
                rectangles++;
            }
            go[i].print();
        }
        System.out.printf("Circles: %s\n", Integer.toString(circles));
        System.out.printf("Rectangles: %s\n", Integer.toString(rectangles));
        System.exit(0);
    }

}
