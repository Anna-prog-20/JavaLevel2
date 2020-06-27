public class StreamPaste implements Runnable{
    private StreamSynch streamSynch;

    public StreamPaste(StreamSynch streamSynch) {
        this.streamSynch = streamSynch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            streamSynch.paste();
        }catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
