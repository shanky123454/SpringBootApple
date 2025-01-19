package in.com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student2", catalog = "student_info")
public class Student2 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int sid;
	private String saddress;
	private int sage;
	private String sname;

	public Student2() {
		System.out.println("inside student2 class");
	}

	@Id
	@Column(name = "sid", unique = true, nullable = false)
	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Column(name = "saddress")
	public String getSaddress() {
		return this.saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Column(name = "sage", nullable = false)
	public int getSage() {
		return this.sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	@Column(name = "sname")
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student2 [sid=" + sid + ", saddress=" + saddress + ", sage=" + sage + ", sname=" + sname + "]";
	}

}
