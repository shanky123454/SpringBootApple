package in.com.bo;

public class CustomerBo {

	private String cname;
	private String caddress;

	private Float pamt;
	private Float rate;
	private Float time;
	private Float intersetamount;

	static {
		System.out.println("CustomerBo.class file is loading...");
	}

	public CustomerBo() {
		System.out.println("CustomerBo object is instantiated...");
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public Float getPamt() {
		return pamt;
	}

	public void setPamt(Float pamt) {
		this.pamt = pamt;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public Float getIntersetamount() {
		return intersetamount;
	}

	public void setIntersetamount(Float intersetamount) {
		this.intersetamount = intersetamount;
	}

	@Override
	public String toString() {
		return "CustomerBo [cname=" + cname + ", caddress=" + caddress + ", pamt=" + pamt + ", rate=" + rate + ", time="
				+ time + ", intersetamount=" + intersetamount + "]";
	}


	
}
