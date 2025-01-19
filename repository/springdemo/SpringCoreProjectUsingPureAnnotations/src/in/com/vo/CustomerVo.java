package in.com.vo;

public class CustomerVo {

	public String cname;
	public String caddress;
	public String pamt;
	public String rate;
	public String time;
	public String intersetamount;  
	
	static {
		System.out.println("inside customervo .class");
	}
	
	public CustomerVo()
	{
		System.out.println("CustomerVo.CustomerVo()");
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

	public String getPamt() {
		return pamt;
	}

	public void setPamt(String pamt) {
		this.pamt = pamt;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIntersetamount() {
		return intersetamount;
	}

	public void setIntersetamount(String intersetamount) {
		this.intersetamount = intersetamount;
	}

	@Override
	public String toString() {
		return "CustomerVo [cname=" + cname + ", caddress=" + caddress + ", pamt=" + pamt + ", rate=" + rate + ", time="
				+ time + ", intersetamount=" + intersetamount + "]";
	}

}


