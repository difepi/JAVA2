package lesson1;

public class Human implements Player {
    private String name;

    private int endurance;
    private int heightjump;

    public Human(String name, int endurance, int heightjump) {
        this.name = name;
        this.endurance = endurance;
        this.heightjump = heightjump;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (this.endurance > treadmill.getLength()) {
            System.out.println("Человек по имени " + this.name + " преодолел препядствие " +
                    treadmill.getLength() + " метров беговой дорожки.");
        } else {
            System.out.println("Беговая дорожка " + treadmill.getLength() + " метров не по зубам" +
                    " человеческому существу, которого зовут " + this.name + ".");
        }
    }

    @Override
    public void jump(Wall wall) {
        if (this.heightjump > wall.getHeight()) {
            System.out.println("Человек" + this.name + " перепрыгнул стену"
                    + wall.getHeight() + " метров.");
        } else {
            System.out.println("Человек по имени " + this.name + " не справится с стеной " + wall.getHeight() + " метров.");
        }
    }

}




