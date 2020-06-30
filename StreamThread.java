public class StreamThread implements Runnable{
    private long a,copy;
    private float[] arr,a1,a2;
    private int half1,half2;
    private String name;

    public StreamThread(float[] arr, float[] a1, int half1, int half2,String name) {
        this.arr = arr;
        this.a1 = a1;
        this.half1 = half1;
        this.half2 = half2;
        this.name=name;
    }

    @Override
    public void run() {
        copy();
        thread();
        paste();
    }
    public void copy(){
        a = System.currentTimeMillis();
        System.arraycopy(arr, half1, a1, 0, half2);
        copy = System.currentTimeMillis() - a;
        System.out.println("Копируем: " + copy);
    }

    public void thread(){

        Thread thread=new Thread(new CalculationStream(a1, name));
        thread.start();
        try{
            thread.join();
        }catch (InterruptedException e){e.printStackTrace();}
       }

    public void paste(){
        a = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, half1, half2);
        copy = System.currentTimeMillis() - a;
        System.out.println("Склеиваем: " + copy);
    }
}
