package com.cy.bean.search;

import java.util.HashSet;
import java.util.Set;

import com.cy.bean.bus.BusLine;
import com.cy.bean.bus.Station;

/**
 * 换乘的查询结果
 * 
 * @author CY
 * 
 */
public class Transfer {
	// 第一次乘坐的公交车
	private BusLine firstBusLine;
	// 第二次乘坐的公交车
	private BusLine secondBusLine;
	// 中转车站
	private Station transferStation;
	// 中转车站的集合
	private Set<Station> transferStations = new HashSet<>();
	
	public Transfer(BusLine firstBusLine, BusLine secondBusLine,
			Station transferStation) {
		super();
		this.firstBusLine = firstBusLine;
		this.secondBusLine = secondBusLine;
		this.transferStation = transferStation;
		this.transferStations.add(transferStation);
	}

	public BusLine getFirstBusLine() {
		return firstBusLine;
	}

	public void setFirstBusLine(BusLine firstBusLine) {
		this.firstBusLine = firstBusLine;
	}

	public BusLine getSecondBusLine() {
		return secondBusLine;
	}

	public void setSecondBusLine(BusLine secondBusLine) {
		this.secondBusLine = secondBusLine;
	}
	
	public Station getTransferStation() {
		return transferStation;
	}

	public void setTransferStation(Station transferStation) {
		this.transferStation = transferStation;
	}

	public Set<Station> getTransferStations() {
		return transferStations;
	}

	public void setTransferStations(Set<Station> transferStations) {
		this.transferStations = transferStations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstBusLine == null) ? 0 : firstBusLine.hashCode());
		result = prime * result
				+ ((secondBusLine == null) ? 0 : secondBusLine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean temp = equals_(obj);
		if(temp) {
			/*
			 * 在往Set集合中添加对象的时候。会调用equals方法判断是否存在。
			 * 那么我们存在的依据： firstBusLine、secondBusLine组成的一对，是否存在。
			 * 如果不存在则添加到Set集合。如果存在则将中转车站添加到，Set集合对应元素的transferStations集合中。
			 */
			// 注意：经过测试。这个obj对象是从Set集合中取出的对象。
			// 换句话说：Set.add(object) 这个方法，执行的时候会调用这个equals(Object obj)方法。是object.equals(set集合中的元素);
			((Transfer)obj).getTransferStations().add(this.transferStation);
		}
		return temp;
	}

	private boolean equals_(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		if (firstBusLine == null) {
			if (other.firstBusLine != null)
				return false;
		} else if (!firstBusLine.equals(other.firstBusLine))
			return false;
		if (secondBusLine == null) {
			if (other.secondBusLine != null)
				return false;
		} else if (!secondBusLine.equals(other.secondBusLine))
			return false;
		return true;
	}
	
	/*
	 * 测试代码
	 */
	public static void main(String[] args) {
		Set<Transfer> transfers = new HashSet<>();
		BusLine firstBusLine = new BusLine(1);
		BusLine secondBusLine = new BusLine(2);
		Station transferStation = new Station(1);
		transfers.add(new Transfer(firstBusLine, secondBusLine, transferStation));
		
		BusLine firstBusLine_ = new BusLine(1);
		BusLine secondBusLine_ = new BusLine(2);
		Station transferStation_ = new Station(1);
		transfers.add(new Transfer(firstBusLine_, secondBusLine_, transferStation_));
		
		for(Transfer transfer : transfers) {
			System.out.println(transfer.getFirstBusLine().getId());
			System.out.println(transfer.getSecondBusLine().getId());
			System.out.println("-----");
			for(Station station : transfer.getTransferStations()) {
				System.out.println(station.getId());
			}
			System.out.println();
		}
	}
}
