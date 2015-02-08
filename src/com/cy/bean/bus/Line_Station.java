package com.cy.bean.bus;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 公交路线对应的公交站
 * @author CY
 *
 */
@Entity
public class Line_Station implements Serializable {
	
	private static final long serialVersionUID = -3058384356217703691L;
	
	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 公交路线id
	 */
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="buslineid")
	private BusLine busLine;
	
	/**
	 * 车站id
	 */
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="stationid")
	private Station station;
	
	/**
	 * 第几站
	 */
	@Column(length=2,nullable=false)
	private Integer num;
	
	public Line_Station() {
	}

	public Line_Station(Integer busLineId,Integer stationId,Integer num) {
		this.busLine = new BusLine(busLineId);
		this.station = new Station(stationId);
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BusLine getBusLine() {
		return busLine;
	}

	public void setBusLine(BusLine busLine) {
		this.busLine = busLine;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/* 重新的hashCode和equals方法是根据station和busLine来判断的 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busLine == null) ? 0 : busLine.hashCode());
		result = prime * result + ((station == null) ? 0 : station.hashCode());
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
		Line_Station other = (Line_Station) obj;
		if (busLine == null) {
			if (other.busLine != null)
				return false;
		} else if (!busLine.equals(other.busLine))
			return false;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		return true;
	}

}
