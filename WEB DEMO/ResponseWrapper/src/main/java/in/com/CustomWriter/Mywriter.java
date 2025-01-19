package in.com.CustomWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Mywriter extends PrintWriter {
          PrintWriter out;
          
	public Mywriter(PrintWriter out) throws FileNotFoundException {
		super(out);
		this.out=out;
	}
	@Override
	public void println(String data) {
		if(!data.startsWith("<"))
		{
			StringBuffer str = new StringBuffer(data);
			out.println(str.reverse());
		}
		else
		 {
		    out.println(data);

	     }
	
	}	

}
