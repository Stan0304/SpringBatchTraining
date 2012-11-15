package sopra.springbatch.training1.part3.item.writer;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.test.AssertFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.springbatch.training1.dto.CustomerDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class StaxEventItemWriterTest extends WriterTestHelper {

	@Autowired
	StaxEventItemWriter<CustomerDTO> itemWriter;
	
	@Test
	public void testRead() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {
		Resource expected = new ClassPathResource("sopra/springbatch/training1/part3/data/StaxEventItemWriter-expected.xml");
		
		//A ECRIRE
		List<CustomerDTO> toWrite = getToWrite(); 

		//ECRITURE
		itemWriter.open(new ExecutionContext());
		itemWriter.write(toWrite);
		itemWriter.close();
		
		//ACTUAL
		Resource actual = new ClassPathResource("sopra/springbatch/training1/part3/data/StaxEventItemWriter-output.xml");
		
		AssertFile.assertFileEquals(expected, actual);
	}
}
