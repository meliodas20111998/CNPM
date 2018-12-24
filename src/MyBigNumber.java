/**
 * Tác giả: Nguyễn Văn Quay
 * DesCription.
 * Class MyBigNumber là lớp chứa 2 thuộc tính là 2 chuỗi đại diện cho 2 số.
 * Hàm sum là hàm để thực hiện phép cộng 2 chuỗi số
 */
public class MyBigNumber {
	
    private IReceiver receiver;

    public MyBigNumber(){}

    public MyBigNumber(final IReceiver receiver) {
        this.receiver = receiver;
    }
/**
 * Sum two string function 
 */
    public String sum(final String s1, final String s2) {
    	
    	String str1 = s1;
    	String str2 = s2;
    	
    	if ((s1 == null ) || (s1.trim().isEmpty())){
    		str1 = "0";
    		
    	}
    	if ((s2 == null ) || (s2.trim().isEmpty())){
    		str2 = "0";
    		
    	}
    	if (str1.charAt(0)=='-') {
    		throw new NumberFormatException ("Khong ho tro so am: " + s1);
    	}
    	if (str2.charAt(0)=='-') {
    		throw new NumberFormatException ("Khong ho tro so am: " + s2);
    	}
    	

        String result = ""; // chuỗi chứa kết quả
        String step = ""; // chuỗi chứa các bước làm trong quá trình cộng

        int tong = 0;   // biến lấy tổng
        int temp = 0; // biến lấy hàng đơn vị
        int remember = 0; // biến nhớ

        int nums1 = 0; // biến chứa số trong chuỗi 1
        int nums2 = 0; // biến chứa số trong chuỗi 2
        int len1 = s1.length();// biến chứa độ dài chuỗi 1
        int len2 = s2.length();// biến chứa độ dài chuỗi 2
        
        char kts1;  // biến kiểm tra từng vị trí trong s1
        char kts2;  // biến kiểm tra từng vị trí trong s2
        int length = len1 < len2 ? len2 : len1; // biến chứa độ dài lớn nhất trong 2 chuỗi s1, s2

        for (int i = 0; i < length; i++) {
        	
        	kts1 = i < len1 ? s1.charAt(i) : '0';
        	kts2 = i < len2 ? s2.charAt(i) : '0';
        	
        	if (!(kts1>='0' && kts1<='9')) {
        		this.receiver.sendMessage("\n Vui long khong duoc dien ki tu dac biet hoac chu trong s1: " + s1);
        		throw new ExNumberFormatException((s1.indexOf(kts1) + 1));
        				  	  
        	}
        	if (!(kts2>='0' && kts2<='9')) {
        		this.receiver.sendMessage("\n Vui long khong duoc dien ki tu dac biet hoac chu trong s2: " + s1);
        		throw new ExNumberFormatException((s2.indexOf(kts2) + 1));
        				  	  
        	}
        	
        	nums1 = i < len1 ? (s1.charAt(len1 - i - 1) - '0') : 0;
        	nums2 = i < len2 ? (s2.charAt(len2 - i - 1) - '0') : 0;
        	
        	tong = nums2  + nums1 + remember;
        	temp = tong % 10;
        	
        	if(remember ==0) {
        		step += "\n" + "Buoc " + (i + 1) + ": "
        			 + "lay " + nums1
        			 + ", cong  " + nums2
        			 + ", bang  " + tong
        			 + ", viet "+ temp
        			 + ", nho " + tong / 10 + "\n";

        	}else {
        		step += "\n" + "Buoc " + (i + 1) + ": "
           			 + "lay " + nums1
           			 + ", cong  " + nums2
           			+ ", nho  " + remember
           			 + ", bang  " + tong
           			 + ", viet "+ temp
           			 + ", nho " + tong / 10 + "\n";
        	}
        	
        	remember = tong /10;
        	result = temp + result;
       
     
        }

        if (remember > 0) {
            result = remember + result;
        }
        receiver.sendMessage(step);

        return result;
    }

}
