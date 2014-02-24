package motoranger;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class QRCodeScriptlet extends JRDefaultScriptlet {
    public void afterPageInit() throws JRScriptletException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = null;

        try {

            matrix = writer.encode("http://motoranger.net/", BarcodeFormat.QR_CODE, 256, 256);
            this.setVariableValue("index_qrcode", MatrixToImageWriter.toBufferedImage(matrix) );


        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
    public void afterDetailEval() throws JRScriptletException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = null;

        try {
            matrix = writer.encode("http://motoranger.net/event/show/"+getFieldValue("event_id").toString(), BarcodeFormat.QR_CODE, 256, 256);
            this.setVariableValue("event_qrcode", MatrixToImageWriter.toBufferedImage(matrix) );

            matrix = writer.encode("http://motoranger.net/product/show/"+getFieldValue("product_id").toString(), BarcodeFormat.QR_CODE, 256, 256);
            this.setVariableValue("product_qrcode", MatrixToImageWriter.toBufferedImage(matrix) );

            if(getFieldValue("user_id")!=null){
                matrix = writer.encode("http://motoranger.net/user/show/"+getFieldValue("user_id").toString(), BarcodeFormat.QR_CODE, 256, 256);
                this.setVariableValue("user_qrcode", MatrixToImageWriter.toBufferedImage(matrix) );
            }

            matrix = writer.encode("http://motoranger.net/", BarcodeFormat.QR_CODE, 256, 256);
            this.setVariableValue("index_qrcode", MatrixToImageWriter.toBufferedImage(matrix) );


        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}