public class Player {
    private Frame last;
    Decoder decoder;
    Cache cache;
    public Player(Decoder decoder, Cache cache){ 
        this.decoder = decoder;
        this.cache = cache;
    }
    void play(byte[] fileBytes){
        // decode
        Frame f = decoder.decode(fileBytes); // pretend decoding
        cache.store(f);
        // draw UI
        System.out.println("\u25B6 Playing " + fileBytes.length + " bytes");
        // cache
        System.out.println("Cached last frame? " + (cache.getLast() != null) );
    }
}