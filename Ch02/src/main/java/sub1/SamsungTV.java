package sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV {
	
	@Autowired
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("SamsungTV powerOn...");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV powerOff...");
	}
	
	public void SoundUp() {
		spk.soundUp();
	}
	
	public void SoundDown() {
		spk.soundDown();
	}
}
