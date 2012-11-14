package sopra.springbatch.training1.part1.item.reader.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import sopra.springbatch.training1.dto.CustomerDTO;

/**
 * Mapping entre enregistrement BDD et CustomerDTO
 */
public class CustomerRowMapper implements RowMapper {
	
	public static final String ID_COLUMN = "ID"; 
	public static final String VERSION_COLUMN = "VERSION"; 
	public static final String FIRSTNAME_COLUMN = "FIRSTNAME"; 
	public static final String LASTNAME_COLUMN = "LASTNAME"; 
	public static final String AGE_COLUMN = "AGE"; 
	public static final String GENDER_COLUMN = "GENDER";
	
	@Override
	public CustomerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setId(rs.getInt(ID_COLUMN));
		customerDTO.setVersion(rs.getInt(VERSION_COLUMN));
		customerDTO.setFirstName(rs.getString(FIRSTNAME_COLUMN));
		customerDTO.setLastName(rs.getString(LASTNAME_COLUMN));
		customerDTO.setAge(rs.getInt(AGE_COLUMN));
		if (StringUtils.isNotBlank(rs.getString(GENDER_COLUMN))){
			customerDTO.setGender(rs.getString(GENDER_COLUMN).charAt(0));
		}
		
		return customerDTO;
	}

}
