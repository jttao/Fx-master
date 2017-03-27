package fx.inter;

import fx.symbols.Type;

public class Else extends Stmt {
	
	Expr expr;Stmt stmt1,stmt2;
	
	public Else(Expr x,Stmt s1,Stmt s2){
		expr = x; stmt1 = s1; stmt2 = s2;
		if(expr.type!=Type.Bool) expr.error("bool required in else");
	}
	
	public void gen(int b,int a){
		int label1 = newlabel();//stmt的代码的标号
		int label2 = newlabel();
		expr.jumping(0, label2);//为真时控制流穿越，为假时转向a
		emitlabel(label1); stmt1.gen(label1, a);emit("goto L"+a);
		emitlabel(label2);stmt2.gen(label2, a);
	}
	
}
