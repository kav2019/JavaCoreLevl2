public class Main {
    public static void main(String[] args) {
        People people = new People("Человек",9, 11);
        Cat cat = new Cat("Кот",11, 5);
        Robot robot = new Robot("Робот",15, 14);
        Wall wall = new Wall(10);
        TreadMill treadMill = new TreadMill(10);

        Barrier[] barrier = {wall, treadMill};
        Player[] players = {people, cat, robot};

        for (Player p : players){
            for (int i = 0; i < barrier.length; i++){
                if (p.running() == 1){
                    System.out.println(p.getName() + " пробежал!!!");
                }else {
                    System.out.println(p.getName() + " не пробежал и сходит с дистанции....");
                    break;
                }
                if (p.jumping() == 1){
                    System.out.println(p.getName() + " перепрыгнул!!!");
                }else {
                    System.out.println(p.getName() + " не перепрыгнул и сходит с дистанции....");
                    break;
                }
                break;
            }
        }
    }
}
