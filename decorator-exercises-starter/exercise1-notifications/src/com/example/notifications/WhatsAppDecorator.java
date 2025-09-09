public class WhatsAppDecorator extends NotifierDecorator {
    private final String userId;

    public WhatsAppDecorator(Notifier wrappee, String userId) {
        super(wrappee);
        this.userId = userId;
    }

    @Override
    public void notify(String text) {
        System.out.println("[WHATSAPP -> " + userId + "]: " + text);
        super.notify(text);
    }
}
