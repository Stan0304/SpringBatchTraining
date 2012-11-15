package sopra.springbatch.training1.part2.item.processor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.springbatch.training1.dto.CustomerDTO;


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
public class ValidatingItemProcessorTest extends ProcessorTestHelper {

	@Test(expected=ValidationException.class)
	public void validatingItemProcessorLastNameMandatory() throws Exception{
		// Lastname absent
		CustomerDTO customerDTO5 = new CustomerDTO();
		customerDTO5.setFirstName("fcustomer5");
		customerDTO5.setAge(50);
		customerDTO5.setGender("M");
		itemProcessor.process(customerDTO5);
	}
	
	@Test(expected=ValidationException.class)
	public void validatingItemProcessorAge() throws Exception{
		// age > 999
		CustomerDTO customerDTO6 = new CustomerDTO();
		customerDTO6.setFirstName("fcustomer6");
		customerDTO6.setLastName("lcustomer6");
		customerDTO6.setAge(1060);
		customerDTO6.setGender("F");
		itemProcessor.process(customerDTO6);
	}

}
