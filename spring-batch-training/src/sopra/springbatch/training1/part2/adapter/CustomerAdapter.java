package sopra.springbatch.training1.part2.adapter;

import sopra.springbatch.training1.dto.CustomerDTO;

public class CustomerAdapter {
	
	/**
	 * Adapter 
	 * @param customerDTO
	 * @return
	 */
	public CustomerDTO map(CustomerDTO customerDTO){

		CustomerDTO newCustomerDTO = new CustomerDTO();
		
		// Mapping Stuff
		newCustomerDTO.setFirstName(customerDTO.getFirstName());
		newCustomerDTO.setLastName(customerDTO.getLastName());
		newCustomerDTO.setAge(customerDTO.getAge());
		newCustomerDTO.setGender(customerDTO.getGender());
		
		return newCustomerDTO;
	}
}
