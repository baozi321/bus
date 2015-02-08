package com.cy.bean.uploadfile;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 上传文件实体
 * @author CY
 *
 */
@Entity
public class UploadFile implements Serializable {

	private static final long serialVersionUID = 6628942279021302926L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 文件名
	 */
	@Column(length = 50,nullable=false)
	private String fileName;

	/**
	 * 文件类型
	 */
	@Column(length = 30,nullable=false)
	private String fileType;

	/**
	 * 文件路径<br/>
	 * 相对路径
	 */
	@Column(length = 128, nullable = false, unique = true)
	private String filePath;

	/**
	 * 上传时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date uploadTime = new Date();

	/**
	 * 临时文件
	 */
	@Transient
	private File tempFile;
	
	public UploadFile() {
	}

	/**
	 * 必填的三个属性
	 * @param fileName 文件名
	 * @param fileType 文件类型
	 */
	public UploadFile(String fileName, String fileType, File tempFile) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.tempFile = tempFile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	public File getTempFile() {
		return tempFile;
	}

	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
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
		UploadFile other = (UploadFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
