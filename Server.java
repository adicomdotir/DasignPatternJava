/**
 * Created by Yashar.P on 4/22/2017.
 */

public class Server extends Computer {
    private String ram;
    private String hdd;
    private String cpu;
	
	public Server(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }
}
