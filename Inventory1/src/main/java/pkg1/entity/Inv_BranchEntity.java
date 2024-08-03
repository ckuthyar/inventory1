package pkg1.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="branches")
public class Inv_BranchEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String branch_name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="location_id")
	private LocationsEntity locationEntity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Inv_CompanyEntity inv_CompanyEntity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public LocationsEntity getLocationEntity() {
		return locationEntity;
	}

	public void setLocationEntity(LocationsEntity locationEntity) {
		this.locationEntity = locationEntity;
	}

	public Inv_CompanyEntity getInv_CompanyEntity() {
		return inv_CompanyEntity;
	}

	public void setInv_CompanyEntity(Inv_CompanyEntity inv_CompanyEntity) {
		this.inv_CompanyEntity = inv_CompanyEntity;
	}

	public Inv_BranchEntity() {
		super();
	}

	public Inv_BranchEntity(long id, String branch_name, LocationsEntity locationEntity,
			Inv_CompanyEntity inv_CompanyEntity) {
		super();
		this.id = id;
		this.branch_name = branch_name;
		this.locationEntity = locationEntity;
		this.inv_CompanyEntity = inv_CompanyEntity;
	}
	
	
}