public class CommandPatternTest {
    public static void main(String[] args) {
        // Create receiver
        Light livingRoomLight = new Light();

        // Create command instances
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        System.out.println("--- Scenario 1: Turning Light On ---");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\n--- Scenario 2: Turning Light Off ---");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
