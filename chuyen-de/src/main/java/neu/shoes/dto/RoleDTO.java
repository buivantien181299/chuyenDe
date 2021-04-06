/**
 * 
 */
package neu.shoes.dto;

/**
 * @author TienBV
 *
 */
public class RoleDTO extends AbstractDTO<RoleDTO>{
	
	// Ma chuc nang
	private String code;
	 
	// Ten chuc nang
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
