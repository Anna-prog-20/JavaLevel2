public class ProcessingArray {
    private int size;

    public ProcessingArray(int size) {
        this.size = size;
    }

    public void processingArray() {
    float[] arr = new float[size];
    arr=setData(arr);
    long a = System.currentTimeMillis();
    arr=calculation(arr);
        System.currentTimeMillis();
        System.out.println("Первый метод: "+(System.currentTimeMillis()-a));
}
    static public float[] setData(float arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=1;
        }
        return arr;
    }
    static public float[] calculation(float arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=(float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }
}
