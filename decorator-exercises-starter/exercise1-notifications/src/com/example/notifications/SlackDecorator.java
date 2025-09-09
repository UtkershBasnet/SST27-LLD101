public class SlackDecorator extends NotifierDecorator{
    private final String channel;

    public SlackDecorator(Notifier wrappee , String channel){
        super(wrappee);
        this.channel = channel;

    }

    @Override
    public void notify(String text) {
        System.out.println("[SLACK #" + channel + "]: " + text);
        super.notify(text);
    }


}
