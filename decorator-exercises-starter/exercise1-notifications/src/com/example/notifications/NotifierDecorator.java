public class NotifierDecorator implements Notifier{
    protected final Notifier wrappee;  // this is the "wrapped" Notifier

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void notify(String text) {
        // by default, just call the wrapped notifier
        wrappee.notify(text);
    }
}