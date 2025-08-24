public class CurrentDecoder implements Decoder{
    public Frame decode(byte[] fileBytes){
        return new Frame(fileBytes); // pretend decoding
    }
}