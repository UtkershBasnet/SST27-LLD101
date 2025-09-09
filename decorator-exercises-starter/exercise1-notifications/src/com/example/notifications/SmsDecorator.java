public class SmsDecorator extends NotifierDecorator{
    private final String phoneNumber;

    public SmsDecorator(Notifier wrappee, String phoneNumber) {
        super(wrappee);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);
        super.notify(text);
    }
}