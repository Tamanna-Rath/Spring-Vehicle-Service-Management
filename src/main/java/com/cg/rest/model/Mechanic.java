
  package com.cg.rest.model;
  
  import javax.persistence.Column; import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import
  javax.persistence.Id; import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
  
  @Entity
  
  @Table(name="Mechanics") 
  public class Mechanic {
  
  @Id
  @Column(name="mechanicId")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int mechanicId;
  
  @NotNull
  @Size(min=3, message="Name Should have atleast 3 characters")
  @Column(name="mFirstName")
  private String mFirstName;
  
  @NotNull
  @Size(min=3, message="Name Should have atleast 3 characters")
  @Column(name="mLastName")
  private String mLastName;
  
  @NotNull
  @Pattern(regexp="^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",message="Enter Phone NUmber with only 10 digit country code")
  @Column(name="mContactNumber")
  private String mContactNumber;
  
  @NotBlank(message="Email_Id is mandatory!!")
  @Email
  @Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+",message = "enter email in valid format")
  @Column(name="mEmail")
  private String mEmail;
  
  @NotNull
  @Size(min=3, message="Name Should have atleast 3 characters")
  @Column(name="mAddress")
  private String mAddress;
  
  public Mechanic() {}

  public Mechanic(int mechanicId, String mFirstName, String mLastName, String mContactNumber, String mEmail,
		String mAddress) {
	super();
	this.mechanicId = mechanicId;
	this.mFirstName = mFirstName;
	this.mLastName = mLastName;
	this.mContactNumber = mContactNumber;
	this.mEmail = mEmail;
	this.mAddress = mAddress;
  }
  
  public int getMechanicId() {
		return mechanicId;
	}

	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}

	public String getmFirstName() {
		return mFirstName;
	}

	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}

	public String getmLastName() {
		return mLastName;
	}

	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public @NotNull @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Enter Phone NUmber with only 10 digit country code") String getmContactNumber() {
		return mContactNumber;
	}

	public void setmContactNumber(@NotNull @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Enter Phone NUmber with only 10 digit country code") @NotNull @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Enter Phone NUmber with only 10 digit country code") String mContactNumber) {
		this.mContactNumber = mContactNumber;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	@Override
	public String toString() {
		return "Mechanic [mechanicId=" + mechanicId + ", mFirstName=" + mFirstName + ", mLastName=" + mLastName
				+ ", mContactNumber=" + mContactNumber + ", mEmail=" + mEmail + ", mAddress=" + mAddress + "]";
	}
	
  
  
  }
 