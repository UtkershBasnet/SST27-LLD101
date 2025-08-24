public interface Cache {
    void store(Frame frame);
    Frame getLast();
}
