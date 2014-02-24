package common
import java.awt.image.BufferedImage 
import javax.imageio.*
import javax.imageio.stream.ImageOutputStream;
import org.imgscalr.*;

class ImageModiService {

    def ByteArrayOutputStream sizeNormal(InputStream uploaded) {
        return scale(uploaded, 720)
    }

    def ByteArrayOutputStream sizeThumbnail(InputStream uploaded) {
        return scale(uploaded, 240)
    }

    def private ByteArrayOutputStream scale (InputStream uploaded, Integer pix){
    	BufferedImage image = ImageIO.read(uploaded)

		BufferedImage scaledImg = Scalr.resize(image, pix);
    	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	ImageIO.write(scaledImg, "jpg", byteArrayOutputStream);

		return byteArrayOutputStream
    }
}
