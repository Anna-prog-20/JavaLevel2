public class Main {

    public static void main(String[] args) {
        int size=10000000;
        new ProcessingArray(size).processingArray();
        new ProcessingArrayStream(size).processingArray();
    }

}
