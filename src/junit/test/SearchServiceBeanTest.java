package junit.test;


import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cy.bean.bus.BusLine;
import com.cy.bean.bus.Station;
import com.cy.bean.search.Transfer;
import com.cy.service.search.SearchService;
import com.cy.service.search.impl.SearchServiceBean;

public class SearchServiceBeanTest {

	private static SearchService searchService;
	
	@BeforeClass
	public static void beforeClass() {
		searchService = (SearchService) new ClassPathXmlApplicationContext("beans.xml").getBean("searchServiceBean");
	}
	
	@Test
	public void searchTransfer2Test() {
		Set<Transfer> lists = searchService.searchTransfer2(new String[]{"重大","茶山"});
		for(Transfer s : lists) {
			System.out.println(s.getFirstBusLine().getName()+"---"+s.getSecondBusLine().getName());
			for(Station st : s.getTransferStations()) {
				System.out.println(st.getName());
			}
		}
	}
	
	@Test
	public void searchTransferTest() {
		@SuppressWarnings("rawtypes")
		List lists = searchService.searchTransfer(new String[]{"渝西","重大"});
		for(Object s : lists) {
			System.out.println(((BusLine)s).getName());
		}
	}
	
	@Test
	public void searchStationsTest() {
		@SuppressWarnings("unchecked")
		List<Station> lists = searchService.searchStations("大");
		for(Station s : lists) {
			System.out.println(s.getName());
		}
	}
	
	@Test
	public void isTransferTest() {
		System.out.println(SearchServiceBean.isTransfer("faads fds fdsa")[0]);
	}
	
	@Test
	public void searchHotStationsTest() {
		@SuppressWarnings("unchecked")
		List<Object[]> rs = searchService.searchHotStations();
		for(Object[] str : rs) {
			System.out.println(str[1]+" "+str[2]);
		}
	}
	
	@Test
	public void searchTest() {
		@SuppressWarnings("unchecked")
		List<BusLine> lines = searchService.searchBusLines("永川2公交站");
		for(BusLine busLine : lines) {
			System.out.println(busLine.getName());
		}
	}

}
