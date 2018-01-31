package edu.neu.agronauts.ui.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fmr_serv_req_crop")
public class FarmerServiceRequestCrop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "request_id")
	private FarmerServiceRequest request;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "crop_id")
	private Crop crop;

	@Column(name = "season")
	private String season;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FarmerServiceRequest getRequest() {
		return request;
	}

	public void setRequest(FarmerServiceRequest request) {
		this.request = request;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

}
