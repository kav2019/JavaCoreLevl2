public class Wall implements Barrier{
    private static int height ;

    public Wall(int height){
        this.height = height;
    }

    public static int getHeight(){
        return height;
    }

}
