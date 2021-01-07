package com.cg.rest.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name= "Vehicle")
public class Vehicle  {
	
	@Id
	@Column(name="vehicleId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  int vehicleId;
	
	@NotNull
	@Size(min=3, message="Name Should have atleast 3 characters")
	@Column(name="vehicleBrand")
	private String vehicleBrand;
	
	@NotNull
	@Column(name="vehicleNumber")
	private String vehicleNumber;
	
	@NotNull
	@Size(min=1, message="Name Should have atleast 1 characters")
	@Column(name="vehicleType")
	private String vehicleType;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleBrand=" + vehicleBrand + ", vehicleNumber=" + vehicleNumber
				+ ", vehicleType=" + vehicleType + "]";
	}
}