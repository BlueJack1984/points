package com.tianbao.points.admin.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;


/**
 * 
 * 图片base64转换utils
 * @author mr.yang
 *
 */
public class ImageBase64Util {
	
	

	
	public static String getImageStr(MultipartFile img) throws IOException{
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(img.getBytes());
	}
	/**
	 * 图片转为base64字符串
	 * 
	 * @param imgFile
	 * @return
	 */
	public static String getImageStr(String imgFile) {

		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//base64 sss:
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 将字符串转为图片
	 * 
	 * @param imgStr
	 * @return
	 */
	public static boolean generateImage(String imgStr, String imgFile)
			throws Exception {// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			imgStr = imgStr.split(",")[1];
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = imgFile;// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
}
