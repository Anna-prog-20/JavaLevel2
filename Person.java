public class Person implements Members {
    private String name;
    private int age;
    private int maxlength;
    private int maxheight;

    public Person(String name, int age, int maxlength, int maxheight) {
        this.name = name;
        this.age = age;
        this.maxlength = maxlength;
        this.maxheight = maxheight;
    }

    public void run(int length){
        if (length>maxlength||maxlength<=0)
            System.out.println(String.format("%s в свои %d лет, не может пробежать такую дистанцию",name,age));
        else
            System.out.println(String.format("%s бежит...",name));
    }
    public void jump(int height){
        if (height>maxheight||maxheight<=0)
            System.out.println(String.format("%s в свои %d лет, не может прыгать так высоко",name,age));
        else
            System.out.println(String.format("%s прыгает...",name));
    }
}
