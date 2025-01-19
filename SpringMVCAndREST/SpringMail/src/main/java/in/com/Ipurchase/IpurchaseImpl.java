package in.com.Ipurchase;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class IpurchaseImpl implements Ipurchase {

	@Autowired
	public JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	public String fromEmail;
	
	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails) throws Exception {
		
		double amt =0.0;
		for (Double price : prices) {
			amt =amt+price;
		}
		
		String msg = Arrays.toString(items)+" with prices ::"+ Arrays.toString(prices)
		+" with total amt ::"+ amt;
		
		String status = sendEamil(msg,toEmails);
		return msg +"--->>>"+status;
	}

	private String sendEamil(String msg, String[] toEmails) throws Exception {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("open it to know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("image.jpg", new File("C:\\Users\\ASUS\\OneDrive\\Pictures\\IMG20221016171312.jpg"));
		
		
		javaMailSender.send(message);
		
		return "mail-sent";
	}

}
