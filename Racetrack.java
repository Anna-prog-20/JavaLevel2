public class Racetrack implements Obstacle{
    private int length;

    public int getLength() {
        return length;
    }
    public Racetrack(int length) {
        this.length = length;
    }

    public void run(Members members){
        members.run(length);
    }
    public void jump(Members members){
    }
}
