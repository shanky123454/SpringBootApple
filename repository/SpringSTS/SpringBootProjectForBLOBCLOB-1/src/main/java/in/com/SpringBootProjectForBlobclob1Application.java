package in.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.bo.MarriageSeeker;
import in.com.service.MarriageSeekerImplClass;

@SpringBootApplication
public class SpringBootProjectForBlobclob1Application {

	public static void main(String[] args) throws IOException {
	ApplicationContext applicationContext =	SpringApplication.run(SpringBootProjectForBlobclob1Application.class, args);
	
	 Scanner sc = new Scanner(System.in);

	// System.out.println("enter the id");
	// Integer id = sc.nextInt();
	 
	 System.out.println("enter the name");
	 String name = sc.nextLine();
	 
	 System.out.println("enter the age");
	 Integer age = sc.nextInt();
	 
	 System.out.println("enter the address");
	 String address= sc.nextLine();
	 
	 System.out.println("enterthe location of biodata");
	 String location1 = sc.nextLine();
	 
	 System.out.println("enter the location of photocontent");
	 String location2 = sc.nextLine();
	 
	 System.out.println("enter whether he/she is indian");
	 Boolean bool = sc.nextBoolean();
	 
	 java.io.File f2 = new File(location1);
	 java.io.Reader reader = new FileReader(f2);
	 char[] biodatacontent = new char[(int) f2.length()];
	 reader.read(biodatacontent);
	 
	 java.io.File f1 = new File(location2);
	java.io.InputStream ips = new FileInputStream(f1);
	 byte[] photocontent = new byte[ips.available()];
	 ips.read(photocontent);
	 
		MarriageSeekerImplClass implClass =applicationContext.getBean(MarriageSeekerImplClass.class);
		 MarriageSeeker marriageSeeker = new MarriageSeeker();
		 
//
//	marriageSeeker.setName(name);
//	marriageSeeker.setAge(age);
//	marriageSeeker.setAddress(address);
//	marriageSeeker.setBiodata(biodatacontent);
//	marriageSeeker.setPhoto(photocontent);
//	marriageSeeker.setDateTime(LocalDateTime.now());
//	marriageSeeker.setIndian(true);
//
//	 MarriageSeeker marriageSeeker2 = implClass.registerMarriage(marriageSeeker);
//	 System.out.println(marriageSeeker2.getId());

	MarriageSeeker seeker = implClass.getRegisteredMarriage(1);
	
	java.io.File f = new File("retrieve_boidata.txt");
	java.io.Writer writer = new FileWriter(f);
	writer.write(seeker.getBiodata());
	writer.flush();
	
	 java.io.File f3 = new File("retrieve_image.png");
	 java.io.OutputStream ops = new FileOutputStream(f3);
	 ops.write(seeker.getPhoto());
	 ops.flush();
	}

}
