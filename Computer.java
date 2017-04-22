
/**
 * Created by Yashar.P on 4/22/2017.
 */

public abstract class Computer {
    public abstract String getRAM();
    public abstract String getCPU();
    public abstract String getHDD();

    @Override
    public String toString() {
        return "RAM= " + getRAM() + ", CPU= " + getCPU() + ", HDD= " + getHDD();
    }
}
