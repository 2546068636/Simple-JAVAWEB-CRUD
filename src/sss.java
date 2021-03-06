/**
 * 
 */

/**
 * @author Administrator
 *
 */
import java.io.ByteArrayOutputStream;
 
/**
 * 进制之间的转换
 * @author jwzhangjie
 *
 */
public class sss {
	
	private static String hexString="0123456789ABCDEF";
	public static String toStringHex(String s){
	  byte[] baKeyword = new byte[s.length()/2];
	  for(int i = 0; i < baKeyword.length; i++){
	   try{
	    baKeyword[i] = (byte)(0xff & Integer.parseInt(s.substring(i*2, i*2+2),16));
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	  }
	  try{
	   s = new String(baKeyword, "GB2312");
	  }catch (Exception e1){
	   e1.printStackTrace();
	  }
	  return s;
	 }
	 
	public static void main(String[] args) {
		System.out.println(decode("6211662F4F607239"));
	}
	 /**
	  * 将字符串编码成16进制数字,适用于所有字符（包括中文）
	  */
	 public static String encode(String str){
	  //根据默认编码获取字节数组
	  byte[] bytes=str.getBytes();
	  StringBuilder sb=new StringBuilder(bytes.length*2);
	  //将字节数组中每个字节拆解成2位16进制整数
	  for(int i=0;i<bytes.length;i++){
	   sb.append(hexString.charAt((bytes[i]&0xf0)>>4));
	   sb.append(hexString.charAt((bytes[i]&0x0f)>>0));
	  }
	  return sb.toString();
	 }
	 /**
	  * 将16进制数字解码成字符串,适用于所有字符（包括中文）
	  */
	 public static String decode(String bytes)
	 {
		  ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2);
		  //将每2位16进制整数组装成一个字节
		  for(int i=0;i<bytes.length();i+=2)
		  baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1))));
		  String bb = "";
		  try {
			  bb = new String(baos.toByteArray(), "UTF-8");
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  return bb;
	 }
}

