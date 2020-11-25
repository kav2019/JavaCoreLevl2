public class People implements Run, Jump, Player {
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
        }else {
            return 1;
        }
    }

    @Override
    public int running() {
        if (TreadMill.getDistance() >= this.canRun){
            return 0;
        }else {
            return 1;
        }
    }

    public People(String name, int canRun, int canJump){
        this.canRun = canRun;
        this.canJump = canJump;
        this.name = name;
    }
}
