package lesson1;

public class Robot implements Player {
    private String name;
    private int endurance;
    private int heightjump;

    public Robot(String name, int endurance, int heightjump) {
        this.name = name;
        this.endurance = endurance;
        this.heightjump = heightjump;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (this.endurance > treadmill.getLength()) {
            System.out.println("Робот модели - " + this.name + " преодолел препядствие " +
                    treadmill.getLength() + " метров беговой дорожки.");
        } else {
            System.out.println("Дистанция беговой дорожки в " + treadmill.getLength() + " метров не под" +
                    " силу роботу " + this.name + ".");
        }
    }


    @Override
    public void jump(Wall wall) {
        if (this.heightjump > wall.getHeight()) {
            System.out.println("Робот " + this.name + " с легкостью  перепрыгнул стену "
                    + wall.getHeight() + " метров.");
        } else {
            System.out.println(this.name + "  не может перепрыгнуть стену " + wall.getHeight() +
                    " метров.");
        }
    }


}
