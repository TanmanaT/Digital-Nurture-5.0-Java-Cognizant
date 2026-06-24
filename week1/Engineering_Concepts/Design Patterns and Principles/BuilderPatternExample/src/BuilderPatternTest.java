public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create a basic office Computer configuration
        Computer officePC = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        // Create a premium gaming Computer configuration
        Computer gamingPC = new Computer.Builder()
                .setCPU("AMD Ryzen 9")
                .setRAM("32GB")
                .setStorage("2TB NVMe SSD")
                .setGPU(true)
                .setWiFi(true)
                .build();

        System.out.println("Office PC Configuration:");
        System.out.println(officePC);
        
        System.out.println("\nGaming PC Configuration:");
        System.out.println(gamingPC);
    }
}
