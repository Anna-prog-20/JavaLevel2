public class Cat implements Members{
    private String name;
    private String color;
    private int maxlength;
    private int maxheight;

    public Cat(String name, String color, int maxlength, int maxheight) {
        this.name = name;
        this.color = color;
        this.maxlength = maxlength;
        this.maxheight = maxheight;
    }


    public void run(int length){
        if (length>maxlength||maxlength<=0)
            System.out.println(String.format("%s кот %s, не может пробежать такую дистанцию",color,name));
        else
            System.out.println(String.format("%s кот %s бежит...",color,name));
    }
    public void jump(int height){
        if (height>maxheight||maxheight<=0)
            System.out.println(String.format("%s кот %s, не может прыгнуть так высоко",color,name));
        else
            System.out.println(String.format("%s кот %s прыгает...",color,name));
    }
}
