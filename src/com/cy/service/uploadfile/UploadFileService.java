package com.cy.service.uploadfile;

import java.io.Serializable;

import com.cy.bean.uploadfile.UploadFile;
import com.cy.service.base.DAO;

/**
 * 上传文件Service接口
 * @author CY
 *
 */
public interface UploadFileService extends DAO<UploadFile> {
	
	/**
	 * 保存上传的文件<br/>
	 * 可以保证文件信息在数据库,以及磁盘同时存储在
	 * @param uploadPath 保存的位置
	 * @param uploadFile 被保存的文件实体
	 */
	public void save(String uploadPath, UploadFile uploadFile);
	
	@Override
	@Deprecated
	public void save(UploadFile uploadFile);

	/**
	 * 从磁盘以及数据库中删除此文件
	 * @param uploadPath 文件存放的路径
	 * @param entityID 被删除的文件id
	 */
	public void delete(String uploadPath, Serializable... entityID);
	
	@Override
	@Deprecated
	public void delete(Serializable... entityID);
}
