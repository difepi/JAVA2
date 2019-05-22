package lesson1;

public class Run {
    public static void main(String[] args) {
        Player[] players = new Player[]{new Human("Владимир", 100, 1),
                new Cat("Матроскин", 200, 2),
                new Robot("Terminator", 333, 3333)};

        Obstacles[] obstacles = new Obstacles[]{new Wall(59), new Treadmill(70),
                new Wall(500), new Wall(600), new Treadmill(1000)};

        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < players.length; j++) {

                if (obstacles[i] instanceof Treadmill) players[j].run((Treadmill) obstacles[i]);
                if (obstacles[i] instanceof Wall) players[j].jump((Wall) obstacles[i]);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }


    }

}

