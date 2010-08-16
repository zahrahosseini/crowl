import org.crow.utils.*;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.crow.data.*;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String imgUrl ="http://www.zeenews.com/Img/2010/5/2/01-AP10050119038.jpg";
//		ImageThumbs it = new ImageThumbs();
//		FileOps fo = new FileOps();
//		fo.downloadFile(imgUrl);
//		try {
//			it.createThumbnail(Constants.TempImageDir+"/img.jpg", "C:/thumb.jpg", 120, 100);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//fo.deleteFile();
		SelectOps so = new SelectOps();
		Map<String,String> k= so.getCategorizedData();

	}

	
	

}
