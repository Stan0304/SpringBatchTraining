package sopra.springbatch.training1.part2.item.processor;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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
public class PassThroughItemProcessorTest extends ProcessorTestHelper {
	
}
