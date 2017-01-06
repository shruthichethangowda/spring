import org.springframework.stereotype.Controller;
import org.springframework.aop.aspectj.annotation.RequestMapping;
//This class we have to convert into a controller(MVC)
//we have to simple annotion
@Controller
public class HomeController {

	//want to navigate to home page
	///http://localhost:8080/ShoppingCart/
	@RequestMapping ("/")
	public String homepage()
	{
		System.out.println("executing the main page");
		return "home";	
	}
}
