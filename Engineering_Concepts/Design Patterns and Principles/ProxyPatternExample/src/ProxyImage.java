public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // Lazy initialization and caching
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
