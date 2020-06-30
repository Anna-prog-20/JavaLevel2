public class CalculationStream implements Runnable{
    private float[] arr;
    private String name;

    public CalculationStream(float[] arr, String name) {
        this.arr = arr;
        this.name = name;
    }

    @Override
    public synchronized void run() {
        long a = System.currentTimeMillis();
        for(int i=0;i<arr.length;i++){
                arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Поток "+name+": "+(System.currentTimeMillis() - a));
    }

}
