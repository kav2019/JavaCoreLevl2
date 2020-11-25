public class Cat implements Jump, Run, Player {
    private int canRun;
    private int canJump;
    private String name;

    public String getName(){
        return name;
    }

    @Override
    public int jumping() {
        if (Wall.getHeight() >= this.canJump) {
            return 0;
//            System.out.println("Кот не перепрыгнул...");
        }else {
            return 1;
//            System.out.println("Кот перепрыгнул!");
        }
    }

    @Override
    public int running() {
        if (TreadMill.getDistance() >= this.canRun){
            return 0;
//            System.out.println("Кот не пробежал...");
        }else {
            return 1;
//            System.out.println("Кот пробежал!");
        }
    }

    public Cat(String name, int canRun, int canJump){
        this.canRun = canRun;
        this.canJump = canJump;
        this.name = name;
    }

}
