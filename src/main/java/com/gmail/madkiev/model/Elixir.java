package com.gmail.madkiev.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Elixir implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	private int id;
	private String name;
	private Date createdDate;
	//input
	private double currentVolume;
	private double aromaVolume;
	private double necessaryVolumeOfBottle;
	//process
	private double volumeInMl = aromaVolume/currentVolume;
	private int drops = 33;
	//outPut
	private double necessaryAroma = volumeInMl * necessaryVolumeOfBottle;
	private double dropsOfAroma = necessaryAroma * drops ;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(double currentVolume) {
		this.currentVolume = currentVolume;
	}

	public double getAromaVolume() {
		return aromaVolume;
	}

	public void setAromaVolume(double aromaVolume) {
		this.aromaVolume = aromaVolume;
	}

	public double getNecessaryVolumeOfBottle() {
		return necessaryVolumeOfBottle;
	}

	public void setNecessaryVolumeOfBottle(double necessaryVolumeOfBottle) {
		this.necessaryVolumeOfBottle = necessaryVolumeOfBottle;
	}

	public double getVolumeInMl() {
		return volumeInMl;
	}

	public void setVolumeInMl(double volumeInMl) {
		this.volumeInMl = volumeInMl;
	}

	public int getDrops() {
		return drops;
	}

	public void setDrops(int drops) {
		this.drops = drops;
	}

	public double getNecessaryAroma() {
		return necessaryAroma;
	}

	public void setNecessaryAroma(double necessaryAroma) {
		this.necessaryAroma = necessaryAroma;
	}

	public double getDropsOfAroma() {
		return dropsOfAroma;
	}

	public void setDropsOfAroma(double dropsOfAroma) {
		this.dropsOfAroma = dropsOfAroma;
	}

	@JsonSerialize(using=DateSerializer.class)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
