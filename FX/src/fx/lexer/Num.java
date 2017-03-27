package fx.lexer;

public class Num extends Token {

	public final int value;
	
	public Num(int v) {
		super(Tag.NUM);
		// TODO Auto-generated constructor stub
		value = v;
	}
	
	public String toString(){
		return ""+value;
	}
	
}
