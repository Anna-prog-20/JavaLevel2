public class ProcessingArrayStream {
    private int size;

    public ProcessingArrayStream(int size) {
        this.size = size;
    }

    public void processingArray() {
        final int half = size / 2;
        float[] arr = new float[size];
        float[] a1=new float[half];
        float[] a2=new float[half];
        long a=0;
        long copy=0;
        long paste=0;
        System.out.println("Второй метод: ");
        arr=setData(arr);

       a = System.currentTimeMillis();
       System.arraycopy(arr, 0, a1, 0, half);
       System.arraycopy(arr, half, a2, 0, half);
       System.currentTimeMillis();
       copy = System.currentTimeMillis() - a;
       System.out.println("Копируем: " + copy);

        new Thread(new CalculationStream(a1, "1")).start();
        try {
            Thread thread2=new Thread(new CalculationStream(a2, "2"));
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
                e.printStackTrace();
            }

            a = System.currentTimeMillis();
            System.arraycopy(a1, 0, arr, 0, half);
            System.arraycopy(a2, 0, arr, half, half);
            System.currentTimeMillis();
            paste = System.currentTimeMillis() - a;
            System.out.println("Склеиваем: " + paste);

    }

    static public float[] setData(float arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=1;
        }
        return arr;
    }
}
