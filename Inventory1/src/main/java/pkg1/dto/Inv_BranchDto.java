package pkg1.dto;
import pkg1.entity.Inv_BranchEntity;

public class Inv_BranchDto {
	private Inv_BranchEntity inv_BranchEntity;
	private long company_id;
	private long location_id;
	public Inv_BranchEntity getInv_BranchEntity() {
		return inv_BranchEntity;
	}
	public void setInv_BranchEntity(Inv_BranchEntity inv_BranchEntity) {
		this.inv_BranchEntity = inv_BranchEntity;
	}
	public long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}
	public long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(long location_id) {
		this.location_id = location_id;
	}

}
