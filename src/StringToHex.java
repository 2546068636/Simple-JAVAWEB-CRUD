public class StringToHex{
 
      public String convertStringToHex(String str){
 
      char[] chars = str.toCharArray();
 
      StringBuffer hex = new StringBuffer();
      for(int i = 0; i < chars.length; i++){
        hex.append(Integer.toHexString((int)chars[i]));
      }
 
      return hex.toString();
      }
 
      public String convertHexToString(String hex){
 
      StringBuilder sb = new StringBuilder();
      StringBuilder temp = new StringBuilder();
 
      //49204c6f7665204a617661 split into two characters 49, 20, 4c...
      for( int i=0; i<hex.length()-1; i+=2 ){
 
          //grab the hex in pairs
          String output = hex.substring(i, (i + 2));
          //convert hex to decimal
          int decimal = Integer.parseInt(output, 16);
          //convert the decimal to character
          sb.append((char)decimal);
 
          temp.append(decimal);
      }
 
      return sb.toString();
      }
 
      //504F533838383834  POS88884
      public static void main(String[] args) {
 
      StringToHex strToHex = new StringToHex();
      System.out.println("\n-----ASCII码转换为16进制 -----");
      String str = "我是你爹"; 
      System.out.println("字符串: " + str);
      String hex = strToHex.convertStringToHex(str);
     // String hex="0x0000D";
      String hex2="0x00003600000000000000000000000000000000000000070B01000000010000004000000025000000A8000000060002003B07010000000000";
      String hex1=hex2.replace("0x", "");
      System.out.println("转换为16进制 : " + hex2);
      
      System.out.println("\n***** 16进制转换为ASCII *****");
      System.out.println("Hex : " + hex2);
      System.out.println("ASCII : " + strToHex.convertHexToString(hex1));
      }
    }