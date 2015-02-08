package com.cy.bean.bus;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 公交站
 * @author CY
 *
 */
@Entity
public class Station implements Serializable {

	private static final long serialVersionUID = -435108012105793594L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 公交站名称
	 */
	@Column(length=20,nullable=false,unique=true)
	private String name;
	
	/**
	 * 经过该公交站的公交路线
	 */
	@OneToMany(cascade=CascadeType.ALL,mappedBy="station")
	private Set<Line_Station> line_Stations;

	public Station() {
	}
	
	public Station(String name) {
		this.name = name;
	}
	
	public Station(Integer id) {
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

	public Set<Line_Station> getLine_Stations() {
		return line_Stations;
	}

	public void setLine_Stations(Set<Line_Station> line_Stations) {
		this.line_Stations = line_Stations;
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
		Station other = (Station) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
