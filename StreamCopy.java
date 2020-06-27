public class StreamCopy implements Runnable{
    private StreamSynch streamSynch;

    public StreamCopy(StreamSynch streamSynch) {
        this.streamSynch = streamSynch;
    }

    @Override
    public void run() {
            streamSynch.copy();
    }
}
