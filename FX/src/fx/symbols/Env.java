package fx.symbols;
import java.util.*;

import fx.inter.*;
import fx.lexer.*;

public class Env {
	
	private Hashtable table;
	
	protected Env prev;
	
	public Env(Env n){
		table = new Hashtable(); prev = n;
	}
	
	public void put(Token w,Id i){
		table.put(w, i);
	}
	
	public Id get(Token w){
		for(Env e = this; e!=null; e = e.prev){
			Id found = (Id)table.get(w);
			if(found != null) return found;
		}
		return null;
	}
	
}
