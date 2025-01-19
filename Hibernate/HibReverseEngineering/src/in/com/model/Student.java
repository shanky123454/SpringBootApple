package in.com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "student_info")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer sid;
	private int count;
	private String saddress;
	private int sage;
	private String sname;

	public Student() {
		System.out.println("inside student class");
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "count", nullable = false)
	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
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
		return "Student [sid=" + sid + ", count=" + count + ", saddress=" + saddress + ", sage=" + sage + ", sname="
				+ sname + "]";
	}

}
