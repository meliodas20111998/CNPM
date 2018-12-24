
public class ExNumberFormatException  extends NumberFormatException {

	private int errorPost;
	
	public ExNumberFormatException (int post) {
		
		super ("Vi tri thu: ");
		this.errorPost = post;
		
	}
	@Override
    public String getMessage() {
        return "Vi tri thu: " + (errorPost + "");
    }
	
}
