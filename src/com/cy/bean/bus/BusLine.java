package com.cy.bean.bus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 公交路线
 * @author CY
 *
 */
@Entity
public class BusLine implements Serializable {

	private static final long serialVersionUID = -2058593452398084133L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 路线名称
	 */
	@Column(length=10,nullable=false,unique=true)
	private String name;
	
	/**
	 * 开始时间
	 */
	@Temporal(TemporalType.TIME)
	@Column(nullable=false)
	private Date startTime;
	
	/**
	 * 结束时间
	 */
	@Temporal(TemporalType.TIME)
	@Column(nullable=false)
	private Date endTime;
	
	/**
	 * 现金价格
	 */
	@Column(length=2,nullable=false)
	private Integer price;
	
	/**
	 * 刷卡价格
	 */
	@Column(length=2,nullable=false)
	private Integer card;
	
	/**
	 * 说明
	 */
	@Column(length=100)
	private String description;
	
	/**
	 * 最新更新时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate = new Date();

	/**
	 * 该路线上的所有车站
	 */
	@OneToMany(cascade=CascadeType.ALL,mappedBy="busLine")
	private List<Line_Station> line_Stations = new ArrayList<>();
	
	public BusLine() {
	}
	
	public BusLine(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCard() {
		return card;
	}

	public void setCard(Integer card) {
		this.card = card;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public List<Line_Station> getLine_Stations() {
		return line_Stations;
	}

	public void setLine_Stations(List<Line_Station> line_Stations) {
		this.line_Stations = line_Stations;
	}
	
	public void addLine_Station(Line_Station line_Station) {
		this.line_Stations.add(line_Station);
	}
	
	public void removeLine_Station(Line_Station line_Station) {
		this.line_Stations.remove(line_Station);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusLine other = (BusLine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
