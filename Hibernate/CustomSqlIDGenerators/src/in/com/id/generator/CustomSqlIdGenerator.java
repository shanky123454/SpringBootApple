package in.com.id.generator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomSqlIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object arg1) throws HibernateException {
		
		String Date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		 int num = new Random().nextInt(1000);
		 String prefix="socgen";
		 String suffix = "pritech";
		 
		return prefix+Date+suffix+"-"+num;
	}

}


