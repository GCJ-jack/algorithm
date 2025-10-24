public abstract class BaseEvent implements Event{

    private long timeStamp;

    protected BaseEvent(){
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public long timestamp() {
        return timeStamp;
    }
}
