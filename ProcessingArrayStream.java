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
        System.out.println("Второй метод: ");
        arr=setData(arr);
        new Thread(new StreamThread(arr,a1,0,half,"1")).start();
        new Thread(new StreamThread(arr,a2,half,half,"2")).start();
    }

    static public float[] setData(float arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=1;
        }
        return arr;
    }
}
