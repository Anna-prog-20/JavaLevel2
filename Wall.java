public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void doObstcle(Members members) {
        jump(members);
    }

    public void jump(Members members){
        members.jump(height);
    }

}
