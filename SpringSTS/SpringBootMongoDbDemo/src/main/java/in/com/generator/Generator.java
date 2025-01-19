package in.com.generator;

import java.util.UUID;

public class Generator {

	public static String generateId()
	{
		return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	}
}
