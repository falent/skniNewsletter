
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail 
{  
public static void main(String[] args) throws InterruptedException {
	

	
      String from = "strona@skni.org";
      final String username = "strona@skni.org";     
      final String password = "***";  

      String host = "smtp.gmail.com";  
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true"); 
      props.put("mail.smtp.host", host);   
      props.put("mail.smtp.port", "25");  
      Session session = Session.getInstance(props,new javax.mail.Authenticator() 
                    {             
                        protected PasswordAuthentication getPasswordAuthentication() 
                        {                
                            return new PasswordAuthentication(username, password);     
                        }          
                    }
                                            );  


	    Database.getNameMailList();
		
		
		
		int i =0;
		while (i<Database.getNameMailList().size()) {
			
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			String dateString = dateFormat.format(currentDate);
			System.out.println(dateString);
            String mail = Database.getNameMailList().get(i);
            String imie = Database.getNameMailList().get(i+1);

            System.out.println(i);
            System.out.println(imie);
            System.out.println(mail);
			try 
			{   
	          Message message = new MimeMessage(session);            
	          message.setFrom(new InternetAddress(from));       
	          message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail));        
	          message.setSubject("Excel Week, Nowe wydarzenie SKNI SGH 06-12.03.2017. Poszerz swoja� wiedze na temat excela! "+ dateString);
			  String emailBody = "</p> <table border='0' width='100%' cellspacing='0' cellpadding='0'> <tbody> <tr> <td bgcolor='#ffffff'>&nbsp;</td> </tr> </tbody> </table> <!-- ONE COLUMN SECTION --> <table border='0' width='100%' cellspacing='0' cellpadding='0'> <tbody> <tr> <td class='section-padding' style='padding: 70px 15px 70px 15px;' align='center' bgcolor='#ffffff'> <table class='responsive-table' border='0' width='500' cellspacing='0' cellpadding='0'> <tbody> <tr> <td> <table border='0' width='100%' cellspacing='0' cellpadding='0'> <tbody> <tr> <td><!-- HERO IMAGE --> <table border='0' width='100%' cellspacing='0' cellpadding='0'> <tbody> <tr> <td class='padding-copy'>&nbsp;<img style='display: block; font-family: Helvetica, Arial, sans-serif; color: #666666; font-size: 16px; margin-left: auto; margin-right: auto;' src='http://skni.org/sites/default/files/Unbenannt1.png' width='95%' alt='Logo' border='0' /></td> </tr> </tbody> </table> </td> </tr> <tr> <td><!-- COPY --> <table border='0' width='100%' cellspacing='0' cellpadding='0'> <tbody> <tr> <td class='padding-copy' style='font-size: 25px; font-family: Helvetica, Arial, sans-serif; color: #333333; padding-top: 30px;' align='center'>Cześć "+imie+" !<br /> <strong>W sobotę 4 marca</strong> wystartowała rejestracja na Excel Week, czyli tydzień intensywnych kurs&oacute;w i wykład&oacute;w z Excela!<br /><br /> Więcej informacji na:<br /> <a href='http://skni.org/pl/excel-week/excel-week' target='_blank'>stronie skni.org</a> <br /> oraz<br /> <a href='https://www.facebook.com/events/1276533869092182/?active_tab=discussion' target='_blank'>facebooku</a> <br /><br /> Mamy jeszcze kilka wolnych miejsc. <br>Do zobaczenia! <br /> Zesp&oacute;ł Excel Week</td> </tr> <tr> <td class='padding-copy' style='padding: 20px 0 0 0; font-size: 16px; line-height: 25px; font-family: Helvetica, Arial, sans-serif; color: #666666;' align='center'>Ilość miejsc na bezpłatnych warsztatch jest ograniczona. Wykorzystaj swoją szansę i zdobądź bezcenne umiejętności wyr&oacute;żniające Cię na rynku pracy!</td> </tr> </tbody> </table> </td> </tr> <tr> <td><!-- BULLETPROOF BUTTON --> <table class='mobile-button-container' border='0' width='100%' cellspacing='0' cellpadding='0'> <tbody> <tr> <td class='padding-copy' style='padding: 25px 0 0 0;' align='center'> <table class='responsive-table' border='0' cellspacing='0' cellpadding='0'> <tbody> <tr> <td align='center'><a class='mobile-button' style='font-size: 16px; font-family: Helvetica, Arial, sans-serif; font-weight: normal; color: #ffffff; text-decoration: none; background-color: #436743; border-top: 15px solid #436743; border-bottom: 15px solid #436743; border-left: 25px solid #436743; border-right: 25px solid #436743; border-radius: 3px; -webkit-border-radius: 3px; -moz-border-radius: 3px; display: inline-block;' href='http://skni.org/pl/uzytkownik' target='_blank'>Zarezerwuj swoje miejsce</a></td> </tr> </tbody> </table> <p>&nbsp;</p> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> <!-- FOOTER --> <table border='0' width='100%' cellspacing='0' cellpadding='0'> <tbody> <tr> <td align='center' bgcolor='#ffffff'> <table border='0' width='100%' cellspacing='0' cellpadding='0' align='center'> <tbody> <tr> <td style='padding: 20px 0px 20px 0px;'><!-- UNSUBSCRIBE COPY --> <table class='responsive-table' border='0' width='500' cellspacing='0' cellpadding='0' align='center'> <tbody> <tr> <td style='font-size: 12px; line-height: 18px; font-family: Helvetica, Arial, sans-serif; color: #666666;' align='center' valign='middle'><a>Wiadomość została wysłana na twoją skrzynkę, ponieważ zarejestrowałeś/aś się na stronie www.skni.org. a tym samym zostało zaakceptowane oświadczenie o możliwości informowania o naszych wydarzeniach. Skasuj swoje konto, jeśli nie chcesz otrzymywać powiadomień na temat najnowszych event&oacute;w koła. Pamiętaj, że SKNI SGH jest studencką organizacją nonprofit. Wygenerowano "+dateString+" </a></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> <p>'</p>";		
				
				
			  message.setContent(emailBody, "text/html; charset=UTF-8");
	
		      Transport.send(message);  
		      System.out.println("Sent message successfully...."); 
		      System.out.println(i);
		    
	
			  Thread.sleep(120500);

      }
      catch (MessagingException e) { 
         throw new RuntimeException(e); 
      }
			i=i+2;
			
       }			
			
			


}

}
