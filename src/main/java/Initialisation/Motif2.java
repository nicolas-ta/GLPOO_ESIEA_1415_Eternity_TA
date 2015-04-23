package Initialisation;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Motif2 {

	public static BufferedImage[][] Motif_1 = load("/Motif PNG/motif 1.png", 81, 160);
	public static BufferedImage[][] Motif_2 = load("/Sprites/Enemies/Tengu.gif", 30, 30);
	public static BufferedImage[][] Motif_3 = load("/Sprites/Enemies/Megaman.gif", 25, 30);
	public static BufferedImage[][] Motif_4 = load("/Sprites/Enemies/DarkEnergy.gif", 20, 20);
	
	public static BufferedImage[][] load(String s, int w, int h) {
		BufferedImage[][] ret;
		try {
			BufferedImage spritesheet = ImageIO.read(Motif2.class.getResourceAsStream(s));
			int width = spritesheet.getWidth() / w;
			int height = spritesheet.getHeight() / h;
			ret = new BufferedImage[height][width];
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					ret[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
				}
			}
			return ret;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error loading graphics.");
			System.exit(0);
		}
		return null;
	}
	
}
