package Immobiliser;

import org.junit.Assert;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Test {

	@org.junit.Test
	public void tesFirstRow(){
		FileRead fr = new FileRead();
		String[] firstrow = fr.FirstRow("src\\weak.txt");
		Assert.assertEquals("Kulcs érzékelő", firstrow[0]);
		Assert.assertEquals("Riasztó", firstrow[1]);	
	}
	
	@org.junit.Test
	public void testStrong() {
		FileRead fr = new FileRead();
		String[] strong = fr.FirstRow("src\\strong.txt");
		Assert.assertEquals("Számkód", strong[0]);
	}
	
	@org.junit.Test
	public void testFileReadingException() {
		FileRead fr = new FileRead();
		try {
			fr.FirstRow("src\\test.txt");

		}catch (Exception e) {
			Assert.assertEquals("Nincs ilyen fájl", e.getMessage());
			System.err.println(e.getMessage());
		}
	}

	@org.junit.Test
	public void testFileComponentYesNo(){
		FileRead fr = new FileRead();

		Integer[] test = {0,1,0,0,0,1};
		Assert.assertEquals(test, fr.ComponentYesNo("src\\weak.txt"));
	}
	
	@org.junit.Test
	public void testCarCode() {
		SimLayeredPane SimLP = new SimLayeredPane();
		Boolean test = SimLP.getCarCode(1234);
		Assert.assertEquals(true, test);
	}
	
	@org.junit.Test
	public void testWrongStart() {
		SimLayeredPane SimLP = new SimLayeredPane();
		SimLP.WrongStartPlusOne();
	    Assert.assertEquals(1, SimLP.getWrongStart());
	}
	@org.junit.Test
	public void testWrongStartZero() {
		SimLayeredPane SimLP = new SimLayeredPane();
		SimLP.WrongStartPlusOne();
		SimLP.WrongStartZero();
	    Assert.assertEquals(0, SimLP.getWrongStart());
	}

	@org.junit.Test
	public void testsetLoad(){
		Integer[] test = {0,0,0,1,1,1};
		SimLayeredPane.setLoad(test);
		Integer[] Loaded = SimLayeredPane.Load;
		Assert.assertEquals(test, Loaded);
	}

	@org.junit.Test
	public void testAudio() {
		File EngineSoundFile = new File("test.pm3");
		AudioInputStream EngineSoundStream = null;
		{
			try {
				EngineSoundStream = AudioSystem.getAudioInputStream(EngineSoundFile);
			} catch (UnsupportedAudioFileException e) {
				Assert.assertEquals("Hibás audio fájl formátum!", e.getMessage());
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

	}

	@org.junit.Test
	public void testAudioLineMissing(){
		File EngineSoundFile = new File("motorsound.wav");
		AudioInputStream EngineSoundStream = null;
		Clip clip = null;

		{
			try {
				EngineSoundStream = AudioSystem.getAudioInputStream(EngineSoundFile);
			} catch (UnsupportedAudioFileException e) {
				System.err.println("Hibás audio fájl formátum!");
			} catch (IOException e) {
				e.getMessage();
			}
		}
		{
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				System.err.println("Nem lehet elérni az audio fájlt");
			}
		}
		try {
			clip.open(EngineSoundStream);
		} catch (LineUnavailableException e) {
			Assert.assertEquals("Nem lehet elérni az audio fájlt", e.getMessage());
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("A fájlt nem lehet lejátszani! Nincs hangszóró!");
		}
	}

}
