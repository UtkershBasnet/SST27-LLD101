public class Demo02 {
    public static void main(String[] args) {
        CurrentDecoder CurrentDecoder = new CurrentDecoder();
        MemoryCache MemoryCache = new MemoryCache();
        new Player(CurrentDecoder, MemoryCache).play(new byte[]{1,2,3,4});
    }
}
