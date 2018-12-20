
public class MyBigNumber {
	public String sum(final String s1, final String s2) {
		
		String result="";
		String step = "";
		
		int tong = 0;
		int temp =0;
		int remember = 0;
		
		int nums1 = 0;
		int nums2 = 0;
		
		
		int len1 = s1.length();
		int len2 = s2.length();
		
		int length = len1 <len2 ? len2:len1;
		
		for (int i = 0;i <length; i++) {
			
			nums1 = i <len1 ? (s1.charAt(len1 - i -1) - '0'): 0 ;
			nums2 = i <len2 ? (s2.charAt(len2 - i -1) - '0'): 0 ;	
			
			tong = nums2 + nums1 +remember;
			temp = tong % 10;
			
			if(length == 1) {
				step += "\n" + "Lay" + nums1
					 + " cong " + nums2
					 + " bang " + tong + "\n";
			} else {
				step += "\n" + "Buoc" + (i +1)+ ": "
					 + "lay " + nums1	
					 + "cong " + nums2
					 + "nho " + remember
					 + "bang " + tong
					 + "viet " + temp
					 + "nho " + remember+"\n";
			}
			
			remember = tong /10;
			result 	 = temp + result ;
		
		}
		if(remember >0) {
			result =remember + result;
		}
		return result;
	}
	
}
