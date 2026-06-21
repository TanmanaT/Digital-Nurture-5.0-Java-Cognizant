public class Computer {
    // Attributes
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final boolean hasGPU;
    private final boolean hasWiFi;

    // Private constructor taking Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGPU = builder.hasGPU;
        this.hasWiFi = builder.hasWiFi;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean hasGPU() { return hasGPU; }
    public boolean hasWiFi() { return hasWiFi; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + 
               ", GPU=" + hasGPU + ", WiFi=" + hasWiFi + "]";
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean hasGPU;
        private boolean hasWiFi;

        // Methods to set attributes
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(boolean hasGPU) {
            this.hasGPU = hasGPU;
            return this;
        }

        public Builder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        // Build method
        public Computer build() {
            return new Computer(this);
        }
    }
}
