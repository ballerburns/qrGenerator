/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookboot.services.qrcode;

import bookboot.model.Qrrequests;
import bookboot.model.qrRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author FP51User
 */
public class qrcode {
    
    
    
    
    public static String createQrCode(String link){
        
        String image_uid;
        
        /************** QR-Code zeichnen ******************/
        image_uid=paintQrCode(link);

        
        /**************************************************/
        
        return image_uid;
        
    }
    
    private static String paintQrCode(String link){
        
        
        String uniqueID = UUID.randomUUID().toString();
        
        
        
        String myCodeText = link;
        
        String currentPath = new File(".").getAbsolutePath();
    
        
        
        
		String filePath = currentPath.substring(0, currentPath.length()-1)+uniqueID+".png";
                
                System.out.print("BBBBBBBBBBBBBBBBBBBBBBBBBBBB"+filePath);
		int size = 250;
		String fileType = "png";
		File myFile = new File(filePath);
		try {
			
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			
			// Now with zxing version 3.2.1 you could change border size (white border size to just 1)
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
 
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size,
					size, hintMap);
			int CrunchifyWidth = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
					BufferedImage.TYPE_INT_RGB);
			image.createGraphics();
 
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.BLACK);
			graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
			//graphics.setColor(Color.WHITE);
                        graphics.setColor(new Color(255,255,0));
 
			for (int i = 0; i < CrunchifyWidth; i++) {
				for (int j = 0; j < CrunchifyWidth; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			ImageIO.write(image, fileType, myFile);
                        
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
        
        return uniqueID;
        
    }    
    
    
}
