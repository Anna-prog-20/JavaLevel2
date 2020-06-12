public class Robot implements Members {
    private String name;
    private int maxlength;
    private int maxheight;

    public Robot(String name, int maxlength, int maxheight) {
        this.name = name;
        this.maxlength = maxlength;
        this.maxheight = maxheight;
    }


    public void run(int length){
        if (length>maxlength||maxlength<=0)
            System.out.println(String.format("Робот %s, не может пробежать такую дистанцию",name));
        else
            System.out.println(String.format("Робот %s бежит...",name));
    }
    public void jump(int height){
        if (height>maxheight||maxheight<=0)
            System.out.println(String.format("Робот %s, не может прыгнуть так высоко",name));
        else
            System.out.println(String.format("Робот %s прыгает...",name));
    }
}
