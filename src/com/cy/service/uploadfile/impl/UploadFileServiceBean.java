package com.cy.service.uploadfile.impl;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.bean.uploadfile.UploadFile;
import com.cy.service.base.DAOSupport;
import com.cy.service.uploadfile.UploadFileService;
import com.cy.utils.FileUtils;

/**
 * 上传文件接口的实现类
 * @author CY
 *
 */
@Service
@Transactional
public class UploadFileServiceBean extends DAOSupport<UploadFile> implements UploadFileService {
	
	@Override
	public void save(String uploadPath, UploadFile uploadFile) {
		//文件名
		String fileName = UUID.randomUUID() + FileUtils.getSuffix(uploadFile.getFileName());
		//文件存放的目录
		String fileDirPath = "upload/" + new SimpleDateFormat("yyyy/MM/dd/HH").format(new Date());
		//设置文件路径
		uploadFile.setFilePath(fileDirPath+"/"+fileName);
		//文件存放的真实目录
		File fileRealDirPath = new File(uploadPath + fileDirPath);
		//如果目录不存在就创建
		if(!fileRealDirPath.exists()) fileRealDirPath.mkdirs();
		//被保存的文件
		File destFile = new File(fileRealDirPath,fileName);
		//标记文件是否上传成功 (在文件夹  , 以及数据库同时存在,才叫上传成功)
		boolean flag = true;
		try {
			org.apache.commons.io.FileUtils.copyFile(uploadFile.getTempFile()
					, destFile);
			try {
				//将上穿的文件信息保存到数据库
				super.save(uploadFile);
			} catch(RuntimeException e) {
				//上传失败
				flag = false;
				throw new RuntimeException(e.getMessage());
			}
		} catch (Exception e) {
			//上传失败
			flag = false;
			throw new RuntimeException(e.getMessage());
		} finally {
			//如果上传失败
			if(!flag) {
				//删除上传的文件以及空目录
				FileUtils.DelFiles(destFile);
			}
		}
	}

	@Override
	public void delete(String uploadPath, Serializable... entityID) {
		if(entityID != null && entityID.length > 0) {
			//参数?1,?2...
			String whereql = getParameterString(1, entityID.length);
			String jql = "select o.filePath from UploadFile o where o.id in (" + whereql + ")";
			Query query = em.createQuery(jql);
			setQueryParameter(entityID, query, 1);
			@SuppressWarnings("unchecked")
			List<String> filePaths = query.getResultList();
			for(String filePath : filePaths) {
				//从磁盘删除该文件,以及空文件夹
				FileUtils.DelFiles(new File(uploadPath+filePath));
			}
			//从数据库删除
			jql = "delete from UploadFile o where o.id in (" + whereql + ")";
			query = em.createQuery(jql);
			setQueryParameter(entityID, query, 1);
			query.executeUpdate();
		}
	}
	
}
