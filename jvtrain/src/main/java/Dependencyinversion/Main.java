package Dependencyinversion;

// Usage
public class Main {
    public static void main(String[] args) {
        // Can work with any TV - just plug it in!
        RemoteControl sonyRemote = new RemoteControl(new SonyTV());
        RemoteControl lgRemote = new RemoteControl(new LGTV());
        RemoteControl samsungRemote = new RemoteControl(new SamsungTV());

        sonyRemote.powerOn(); // Sony TV turning on
        lgRemote.powerOn(); // LG TV turning on
        samsungRemote.powerOn(); // Samsung TV turning on
    }
}