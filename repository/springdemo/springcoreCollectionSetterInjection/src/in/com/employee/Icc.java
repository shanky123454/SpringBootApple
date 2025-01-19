package in.com.employee;

import java.util.Properties;

public class Icc {
	
	public Properties playerList;


	static {
		System.out.println("Employee.static block method()");
	}
	
	public Icc()
	{
		System.out.println("using zero-param constructor");
	}

	public Properties getPlayerList() {
		return playerList;
	}

	public void setPlayerList(Properties playerList) {
		this.playerList = playerList;
	}

	@Override
	public String toString() {
		return "Icc [playerList=" + playerList + "]";
	}
	
	
}
