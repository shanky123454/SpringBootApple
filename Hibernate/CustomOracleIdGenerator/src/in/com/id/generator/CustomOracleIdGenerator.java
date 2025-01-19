package in.com.id.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomOracleIdGenerator implements IdentifierGenerator {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res =null;
	String id="";

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object arg1) throws HibernateException {
		
		con =si.connection();
		try {
			pstmt =con.prepareStatement("select sid_seq.nextval from dual");
			res=pstmt.executeQuery();
			while (res.next()) {
				int i = res.getInt(1);

				if (i <= 9)
					id = "C00" + i;
				else if (i > 9 && i <= 99)
					id = "C0" + i;
				else
					id = "C" + i;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return id;
	}

}


