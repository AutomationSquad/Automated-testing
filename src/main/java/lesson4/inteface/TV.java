package lesson4.inteface;

public class TV implements IChannelChangeable, IPauseable, IVolumeAdjustable {

    private int volume = 10;
    private int channel;
    private boolean isPaused;

    @Override
    public void increaseVolume() {
        volume++;
        System.out.println("Volume was increased to " + volume + " points.");
    }

    @Override
    public void decreaseVolume() {
        volume--;
        System.out.println("Volume was decreased to " + volume + " points.");
    }

    @Override
    public void nextChannel() {
        channel++;
        System.out.println("Channel was changed to " + channel + ".");
    }

    @Override
    public void previousChannel() {
        channel--;
        System.out.println("Channel was changed to " + channel + ".");
    }

    @Override
    public void enterChannelNumber(int channelNumber) {
        channel = channelNumber;
        System.out.println("Channel was changed to " + channel + ".");
    }

    @Override
    public void pause() {
        isPaused = true;
        System.out.println("TV was paused!");
    }

    @Override
    public void unpause() {
        isPaused = false;
        System.out.println("TV was unpaused!");
    }
}
