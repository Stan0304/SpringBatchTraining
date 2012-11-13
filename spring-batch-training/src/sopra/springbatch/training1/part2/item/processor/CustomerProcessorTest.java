package sopra.springbatch.training1.part2.item.processor;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.adapter.ItemProcessorAdapter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.springbatch.training1.dto.CustomerDTO;
import sopra.springbatch.training1.part1.item.reader.ReaderTestHelper;


/**
 * Implémentations existantes de Processor (cf. CustomerProcessorTest-context.xml) :
 * <ul>
 * <li>org.springframework.batch.item.adapter.ItemProcessorAdapter</li>
 * <li>org.springframework.batch.item.support.CompositeItemProcessor</li>
 * <li>org.springframework.batch.item.support.PassThroughItemProcessor</li>
 * <li>org.springframework.batch.item.validator.ValidatingItemProcessor</li>
 * </ul>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CustomerProcessorTest {
	/** Liste de customer expected du reader */
	private List<CustomerDTO> readerExpected = new ReaderTestHelper().getExpected(); 
	
	// TEST >> ItemProcessorAdapter
	@Autowired
	ItemProcessorAdapter<CustomerDTO,CustomerDTO> itemProcessorAdapter;
	@Test
	public void itemProcessorAdapterTest() throws Exception{
		List<CustomerDTO> actual = new ArrayList<CustomerDTO>();
		
		// boucle sur les customers pour lancer le processor
		for (CustomerDTO customerDTO : readerExpected) {
			actual.add(itemProcessorAdapter.process(customerDTO));
		}
		
		Assert.assertEquals(readerExpected, actual);
	}
	
	// TEST >> CompositeItemProcessor
	@Autowired
	CompositeItemProcessor<CustomerDTO,CustomerDTO> compositeItemProcessor;
	@Test
	public void compositeItemProcessorTest() throws Exception{
		List<CustomerDTO> actual = new ArrayList<CustomerDTO>();
		
		// boucle sur les customers pour lancer le processor
		for (CustomerDTO customerDTO : readerExpected) {
			actual.add(compositeItemProcessor.process(customerDTO));
		}
		
		Assert.assertEquals(readerExpected, actual);
	}
	
	// TEST >> PassThroughItemProcessor
	@Autowired
	PassThroughItemProcessor<CustomerDTO> passThroughItemProcessor;
	@Test
	public void passThroughItemProcessor() throws Exception{
		List<CustomerDTO> actual = new ArrayList<CustomerDTO>();
		
		// boucle sur les customers pour lancer le processor
		for (CustomerDTO customerDTO : readerExpected) {
			actual.add(passThroughItemProcessor.process(customerDTO));
		}
		
		Assert.assertEquals(readerExpected, actual);
	}
	
	// TEST >> PassThroughItemProcessor
	@Autowired
	ValidatingItemProcessor<CustomerDTO> validatingItemProcessor;
	@Test
	public void validatingItemProcessor() throws Exception{
		List<CustomerDTO> actual = new ArrayList<CustomerDTO>();
		
		// boucle sur les customers pour lancer le processor
		for (CustomerDTO customerDTO : readerExpected) {
			actual.add(validatingItemProcessor.process(customerDTO));
		}
		
		Assert.assertEquals(readerExpected, actual);
	}
	@Test(expected=ValidationException.class)
	public void validatingItemProcessorLastNameMandatory(){
		// Lastname absent
		CustomerDTO customerDTO5 = new CustomerDTO();
		customerDTO5.setFirstName("fcustomer5");
		customerDTO5.setAge(50);
		customerDTO5.setGender('M');
		validatingItemProcessor.process(customerDTO5);
	}
	@Test(expected=ValidationException.class)
	public void validatingItemProcessorAge(){
		// age > 999
		CustomerDTO customerDTO6 = new CustomerDTO();
		customerDTO6.setFirstName("fcustomer6");
		customerDTO6.setLastName("lcustomer6");
		customerDTO6.setAge(1060);
		customerDTO6.setGender('F');
		validatingItemProcessor.process(customerDTO6);
	}

}
