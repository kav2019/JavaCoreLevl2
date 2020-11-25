public class TreadMill implements Barrier{
    private static int distance;

    public TreadMill(int distance){
        this.distance = distance;
    }

    public static int getDistance(){
        return distance;
    }
}
