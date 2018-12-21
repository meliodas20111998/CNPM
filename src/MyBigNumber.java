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

    public String sum(final String s1, final String s2) {
    	if(s1.contains("-")) {
    		throw new NumberFormatException("So thu nhat phai la so nguyen duong");
    		
    	}
    	if(s2.contains("-")) {
    		throw new NumberFormatException("So thu hai phai la so nguyen duong");
    		
    	}

        String result = "";
        String step = "";

        int tong = 0;
        int temp = 0;
        int remember = 0;

        int nums1 = 0;
        int nums2 = 0;

        int len1 = s1.length();
        int len2 = s2.length();
        
        char kts1;  // biến kiểm tra từng vị trí trong s1
        char kts2;  // biến kiểm tra từng vị trí trong s2
        int length = len1 < len2 ? len2 : len1;

        for (int i = 0; i < length; i++) {
        	
        	kts1 = i < len1 ? s1.charAt(i) : '0';
        	kts2 = i < len2 ? s2.charAt(i) : '0';
        	
        	if (!(kts1>='0' && kts1<='9')) {
        		throw new NumberFormatException ("Vi tri thu"
        				  + (s1.indexOf(kts1) + 1)
        				  + " cua so thu 1 khong phai la so");
        	}
        	if (!(kts2>='0' && kts2<='9')) {
        		throw new NumberFormatException ("Vi tri thu"
      				  + (s2.indexOf(kts2) + 1)
      				  + " cua so thu 1 khong phai la so");
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
