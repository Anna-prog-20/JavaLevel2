public class StreamThread implements Runnable{
    private StreamSynch streamSynch;

    public StreamThread(StreamSynch streamSynch) {
        this.streamSynch = streamSynch;
    }


    @Override
    public void run() {
        streamSynch.thread();
    }
}
