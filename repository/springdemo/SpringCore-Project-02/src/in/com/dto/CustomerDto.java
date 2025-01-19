package in.com.dto;

public class CustomerDto {
	
	private String customerName;
	private String customerAddress;

	private Float pamt;
	private Float rate;
	private Float time;

	static {
		System.out.println("CustomerDTO.class file is loading...");
	}

	public CustomerDto() {
		System.out.println("CustomerDTO object is instantiated...");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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

	@Override
	public String toString() {
		return "CustomerDto [customerName=" + customerName + ", customerAddress=" + customerAddress + ", pamt=" + pamt
				+ ", rate=" + rate + ", time=" + time + "]";
	}
 
}
