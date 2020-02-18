package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//圖片檔案,與 byte[] 互轉
public class TestFile {

	static byte[] bytes;

	public static void main(String[] args) throws Exception {
		File img = new File("C:\\Users\\User\\Pictures\\Saved Pictures\\111.jpg");
		fileToByte(img);
		ByteToFile(bytes);
		System.out.println("fileToByte(img)="+img);
		System.out.println("ByteToFile(bytes)="+bytes);
	}

	public static void fileToByte(File img) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			BufferedImage bi;
			bi = ImageIO.read(img);
			ImageIO.write(bi, "jpg", baos);
			bytes = baos.toByteArray();
			System.err.println(bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			baos.close();
		}
	}
	
	static void ByteToFile(byte[] bytes)throws Exception{ 
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);   
        BufferedImage bi1 =ImageIO.read(bais); 
        try {   
            File w2 = new File("C:\\Users\\User\\Pictures\\Saved Pictures\\111.jpg");//可以是jpg,png,gif格式   
            ImageIO.write(bi1, "jpg", w2);//不管輸出什麼格式圖片,此處不需改動   
        } catch (IOException e) {   
            e.printStackTrace();   
        }finally{
        	bais.close();
        }
    }  

}