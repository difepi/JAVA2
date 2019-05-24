package lesson1;

public class Cat implements Player {
    private String name;

    private int endurance;
    private int heightjump;

    public Cat(String name, int endurance, int heightjump) {
        this.name = name;
        this.endurance = endurance;
        this.heightjump = heightjump;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (this.endurance > treadmill.getLength()) {
            System.out.println("Кот по кличке  " + this.name + " преодолел препядствие " +
                    treadmill.getLength() + " метров " + " беговой дорожки.");
        } else {
            System.out.println(treadmill.getLength() + " метров слишком большая беговая " +
                    " дистанция для котеечки по имени " + this.name + ".");
        }
    }


    @Override
    public void jump(Wall wall) {
        if (this.heightjump > wall.getHeight()) {
            System.out.println("Кот с именем " + this.name + "  перепрыгнул стену " + wall.getHeight() + " метров.");
        } else {
            System.out.println("Стена " + wall.getHeight() + " метров высокая для котейки по " +
                    "кличке " + this.name + ".");
        }
    }


}
