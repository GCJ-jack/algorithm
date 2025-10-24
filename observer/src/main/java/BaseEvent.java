public abstract class BaseEvent implements Event{

    private final long timeStamp;

    protected BaseEvent(){
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public long timeStamp() {
        return timeStamp;
    }
}
