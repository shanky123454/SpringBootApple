package in.com.DTO;

public class StudentDTO {

	private Integer sid;
	private String sname;
	private String saddress;
	private Integer sage;
	
	public StudentDTO() {
		System.out.println("StudentDTO.StudentDTO()");
	}
	
	public StudentDTO(Integer sid, String sname, String saddress, Integer sage) {
		this.sid = sid;
		this.sname = sname;
		this.saddress = saddress;
		this.sage = sage;
	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}

}
