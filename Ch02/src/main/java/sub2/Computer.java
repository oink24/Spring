package sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")
public class Computer {

	private CPU cpu;
	private RAM ram;
	
	// DI - 3) Field Inject
	@Autowired
	private HDD hdd;
	
	// DI - 1) Constructor Inject(생성자 주입)
	@Autowired
	public Computer(CPU cpu) {
		this.cpu = cpu;
	}
	
	// DI - 2) setter Inject
	@Autowired
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	
	public void show() {
		cpu.show();
		ram.show();
		hdd.show();
	}
}
