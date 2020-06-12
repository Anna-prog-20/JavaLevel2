public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    public void jump(Members members){
        members.jump(height);
    }
    public void run(Members members){

    }
}
