package Dependencyinversion;

interface TV {
    void turnOn();
}

class SonyTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Sony TV turning on");
    }
}

class LGTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("LG TV turning on");
    }
}

class SamsungTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("Samsung TV turning on");
    }
}

class RemoteControl {
    private TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public void powerOn() {
        tv.turnOn();
    }
}
