package lesson4.inteface;

public interface IVolumeAdjustable extends IPauseable, IChannelChangeable {

    void increaseVolume();

    void decreaseVolume();
}
