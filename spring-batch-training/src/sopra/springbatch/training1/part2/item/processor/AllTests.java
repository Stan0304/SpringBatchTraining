package sopra.springbatch.training1.part2.item.processor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CompositeProcessorTest.class,
		PassThroughItemProcessorTest.class, ProcessorAdapterTest.class,
		ValidatingItemProcessorTest.class })
public class AllTests {

}
