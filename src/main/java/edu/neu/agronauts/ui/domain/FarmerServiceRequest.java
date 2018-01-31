package edu.neu.agronauts.ui.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "field")
public class FarmerServiceRequest {
	@Id
	@Column(name = "Field_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "Area")
	private Double area;

	@Column(name = "GPS_Coordinates_P1_x1")
	private double x1;

	@Column(name = "GPS_Coordinates_P2_x2")
	private double x2;

	@Column(name = "GPS_Coordinates_P1_y1")
	private double y1;

	@Column(name = "GPS_Coordinates_P2_y2")
	private double y2;

	@Column(name = "GPS_Coordinates_P3_x3")
	private double x3;

	@Column(name = "GPS_Coordinates_P3_y3")
	private double y3;

	@Column(name = "GPS_Coordinates_P4_x4")
	private double x4;

	@Column(name = "GPS_Coordinates_P4_y4")
	private double y4;

	@Column(name = "status")
	private String status;

	@Column(name = "req_date")
	String requestDate;
	
	@Column(name = "inserted_by")
	private String insertedBy;

	@Column(name = "inserted_date")
	private String insertedDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private String modifiedDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Farmer_ID")
	private Farmer farmer;

	@Transient
	private List<FarmerServiceRequestCrop> crops;

	public FarmerServiceRequest() {
		/** Default constructor **/
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getX3() {
		return x3;
	}

	public void setX3(double x3) {
		this.x3 = x3;
	}

	public double getY3() {
		return y3;
	}

	public void setY3(double y3) {
		this.y3 = y3;
	}

	public double getX4() {
		return x4;
	}

	public void setX4(double x4) {
		this.x4 = x4;
	}

	public double getY4() {
		return y4;
	}

	public void setY4(double y4) {
		this.y4 = y4;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<FarmerServiceRequestCrop> getCrops() {
		return crops;
	}

	public void setCrops(List<FarmerServiceRequestCrop> crops) {
		this.crops = crops;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String myDateString) {
		this.requestDate = myDateString;
	}

	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public String getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(String insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
