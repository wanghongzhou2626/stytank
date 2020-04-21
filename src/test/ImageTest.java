package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		try {
			BufferedImage image_1 = ImageIO.read(new File("D:/git/tank/tank/src/images/square1.jpg"));
			assertNotNull(image_1);
		
			BufferedImage image_2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/square1.jpg"));
			assertNotNull(image_2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
