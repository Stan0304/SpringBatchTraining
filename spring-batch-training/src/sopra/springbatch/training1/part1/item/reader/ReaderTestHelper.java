package sopra.springbatch.training1.part1.item.reader;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import sopra.springbatch.training1.dto.CustomerDTO;

public class ReaderTestHelper {

	@Autowired
	ItemStreamReader<CustomerDTO> itemReader;
	
	private static Logger LOGGER = Logger.getLogger(ReaderTestHelper.class); 
	
	@Test
	public void testRead() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {
		//EXPECTED
		List<CustomerDTO> expected = getExpected(); 
		
		//ACTUAL
		List<CustomerDTO> actual = new LinkedList<CustomerDTO>();
		itemReader.open(new ExecutionContext());
		for ( CustomerDTO customer = itemReader.read() ; 
				customer != null ; 
				customer = itemReader.read() ){
			actual.add(customer);
			LOGGER.info(customer);
		}
		itemReader.close();
		//ACTUAL

		// TEST le r�sultat
		Assert.assertEquals(expected, actual);
	}
	
	public List<CustomerDTO> getExpected(){
		List<CustomerDTO> expected = new LinkedList<CustomerDTO>();
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setFirstName("fcustomer1");
		customer1.setLastName("lcustomer1");
		customer1.setAge(10);
		customer1.setGender("M");
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setFirstName("fcustomer2");
		customer2.setLastName("lcustomer2");
		customer2.setAge(20);
		customer2.setGender("F");
		CustomerDTO customer3 = new CustomerDTO();
		customer3.setFirstName("fcustomer3");
		customer3.setLastName("lcustomer3");
		customer3.setAge(30);
		customer3.setGender("F");
		CustomerDTO customer4 = new CustomerDTO();
		customer4.setFirstName("fcustomer4");
		customer4.setLastName("lcustomer4");
		customer4.setAge(40);
		customer4.setGender("M");
		
		// Construction de la liste
		expected.add(customer1);
		expected.add(customer2);
		expected.add(customer3);
		expected.add(customer4);
		
		return expected;
	}
}
