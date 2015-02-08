package junit.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cy.bean.bus.BusLine;
import com.cy.service.bus.BusLineService;

public class BusLineServiceTest {

	private static BusLineService busLineService;
	
	@BeforeClass
	public static void beforeClass() {
		busLineService = (BusLineService) new ClassPathXmlApplicationContext("beans.xml").getBean("busLineServiceBean");
	}
	
	@Test
	public void test() {
		List<BusLine> buslines = busLineService.getBusLinesByName("1");
		for(BusLine busLine : buslines) {
			System.out.println(busLine.getName());
		}
	}

}
