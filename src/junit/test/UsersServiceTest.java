package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cy.bean.user.Users;
import com.cy.service.user.UsersService;
import com.cy.utils.MD5;

public class UsersServiceTest {

	private static UsersService usersService;
	
	@BeforeClass
	public static void beforeClass() {
		usersService = (UsersService) new ClassPathXmlApplicationContext("beans.xml").getBean("usersServiceBean");
	}
	
	@Test
	public void save() {
		Users users = new Users("admin",MD5.MD5Encode("admin"));
		usersService.save(users);
	}
	
	@Test
	public void loginTest() {
		Users users = new Users("admin","admin");
		Users user = usersService.login(users);
		System.out.println(user.getUsername()+user.getPassword());
	}
}
