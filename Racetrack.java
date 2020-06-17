public class Racetrack implements Obstacle{
    private int length;

    public int getLength() {
        return length;
    }
    public Racetrack(int length) {
        this.length = length;
    }

    @Override
    public void doObstcle(Members members) {
        run(members);
    }

    public void run(Members members){
        members.run(length);
    }

}
