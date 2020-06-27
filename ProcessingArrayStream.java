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

        StreamSynch streamSynch=new StreamSynch(arr,a1,a2,half);

        StreamCopy streamCopy=new StreamCopy(streamSynch);
        StreamThread streamThread=new StreamThread(streamSynch);
        StreamPaste streamPaste=new StreamPaste(streamSynch);

        new Thread(streamCopy).start();
        new Thread(streamThread).start();
        new Thread(streamPaste).start();
        System.out.println(a1[a1.length-1]);

    }

    static public float[] setData(float arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=1;
        }
        return arr;
    }
}
