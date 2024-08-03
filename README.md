# Inventory Spring Boot Project
Procedure-TypeA

Create Entity Class
- @Entity
- @Table
- @Id
- @GeneratedValue
- @GenerationType
- Declare colum names
- Getter and Setter methods
- Constructor no argument
- Constructor all fields

Create Repo Interface
- extends JpaRepository<EntityClass,Long>
 
Create Controller Class
-@RestController
-@PostMapping
    -@Autowired
    -RepoInterface RepoObject
    -@RequestBody EntityClass EntityObject
    -RepoObject.save(EntityObject)
-@GetMapping
    -RepoInterface.findAll()
-@GetMapping
    -@PathVariable long id
    -RepoInterface.findById(id)
    

# Procedure-TypeB (foreign key references primary key)

Create Entity Class (Primary)
- @Entity
- @Table
- @Id
- @GeneratedValue
- @GenerationType

- @ManyToOne(cascade=CascadeType.ALL)
- @JoinColumn(name="ColumnName")
- FKEntity fkentityobject

- Declare colum names
- Getter and Setter methods
- Constructor no argument
- Constructor all fields

Create Entity Class (Foreign)
- @Entity
- @Table
- @Id
- @GeneratedValue
- @GenerationType

- @OneToMany(mappedBy="fkentityobject"
- List<PKEntity> list1

- Declare colum names
- Getter and Setter methods
- Constructor no argument
- Constructor all fields


Create PKDto Class 
- Fields
    - PKEntity pkentityobject
    - FK field long

Create Repo Interface
- extends JpaRepository<EntityClass,Long>
 
Create Controller Class
-@RestController
-@PostMapping
    -@Autowired
    -RepoInterface RepoObject
    -@RequestBody EntityClass EntityObject
    -RepoObject.save(EntityObject)
-@GetMapping
    -RepoInterface.findAll()
-@GetMapping
    -@PathVariable long id
    -RepoInterface.findById(id)





branches/views/id ----------ID is coming in the URL

branches/views/add -----------ID is coming in the RequestBody
- create an empty object
- set fields(Field1, FK1, FK2)into object using Setters 
- save the object




Inv_BranchEntity saved_branch=new Inv_BranchEntity();

saved_branch.setBranch_name(inv_branchdto.getInv_BranchEntity().getBranch_name());

long cid=inv_branchdto.getCompany_id();
Optional<Inv_CompanyEntity> company_obj=inv_companyrepo.findById(cid);
saved_branch.setInv_CompanyEntity(company_obj.get());

long lid=inv_branchdto.getLocation_id();
Optional<LocationsEntity> location_obj=locationsrepo.findById(lid);
saved_branch.setLocationEntity(location_obj.get());

inv_branchrepo.save(saved_branch);
