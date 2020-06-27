public class StreamSynch {
    private long a,copy;
    private float[] arr,a1,a2;
    private int half;

    public StreamSynch(float[] arr, float[] a1, float[] a2, int half) {
        this.arr = arr;
        this.a1 = a1;
        this.a2 = a2;
        this.half = half;
    }


    public synchronized void copy(){
            a = System.currentTimeMillis();
            System.arraycopy(arr, 0, a1, 0, half);
            System.arraycopy(arr, half, a2, 0, half);
            System.currentTimeMillis();
            copy = System.currentTimeMillis() - a;
            System.out.println("Копируем: " + copy);
    }

    public synchronized void thread(){
            System.out.println("Запускаемся");
            Thread thread1=new Thread(new CalculationStream(a1, "1"));
            thread1.start();
            Thread thread2=new Thread(new CalculationStream(a2, "2"));
            thread2.start();
    }

    public synchronized void paste(){
            a = System.currentTimeMillis();
            System.arraycopy(a1, 0, arr, 0, half);
            System.arraycopy(a2, 0, arr, half, half);
            System.currentTimeMillis();
            copy = System.currentTimeMillis() - a;
            System.out.println("Склеиваем: " + copy);
    }
}
