package com.cy.web.action.uploadfile;

import java.io.File;
import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.uploadfile.UploadFile;
import com.cy.service.uploadfile.UploadFileService;
import com.cy.utils.SysParam;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 上传文件管理控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class UploadFileManageAction extends BaseAction {

	@Resource
	private UploadFileService uploadFileService;
	/* 上传的文件 */
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;
	/* UMEditor上传的文件 */
	private File upfile;
	private String upfileContentType;
	private String upfileFileName;

	/**
	 * 删除文件
	 * 
	 * @return
	 */
	public String del() {
		if(getIds() != null && getIds().length > 0) {
			String uploadPath = ServletActionContext.getServletContext()
					.getRealPath("/");
			uploadFileService.delete(uploadPath,(Serializable[])getIds());
			ActionContext.getContext().put("message", "文件删除成功");
		} else {
			ActionContext.getContext().put("message", "请选择要删除的文件");
		}
		ActionContext.getContext().put("url", SysParam.read("fileList"));
		return "message";
	}

	/**
	 * 处理文件上传的控制器
	 * 
	 * @return
	 */
	public String upload() {
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath("/");
		if (uploadFile != null) {
			UploadFile uploadFile = new UploadFile(uploadFileFileName,
					uploadFileContentType, this.uploadFile);
			try {
				uploadFileService.save(uploadPath, uploadFile);
				ActionContext.getContext().put("message", "文件上传成功");
			} catch (Exception e) {
				ActionContext.getContext().put("message", "文件上传失败");
			}
		} else {
			ActionContext.getContext().put("message", "文件上传失败,文件大小不得超过2M");
		}
		ActionContext.getContext().put("url", SysParam.read("uploadFileUI"));
		return "dialog";
	}
	
	/**
	 * 处理UMEditor图片上传
	 * 
	 * @return
	 */
	public String UMEditorUpload() {
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath("/");
		String message = null;
		if (upfile != null) {
			UploadFile uploadFile = new UploadFile(upfileFileName,upfileContentType, upfile);
			try {
				uploadFileService.save(uploadPath, uploadFile);
				message = "{\"name\":\""+upfileFileName+"\", \"originalName\": \""+upfileFileName+"\", \"size\": "+upfile.length()+",\"state\": \"SUCCESS\", \"type\": \""+upfileContentType+"\", \"url\": \""+uploadFile.getFilePath()+"\"}";
			} catch (Exception e) {
				message = "{\"name\":\""+upfileFileName+"\", \"originalName\": \""+upfileFileName+"\", \"size\": "+upfile.length()+",\"state\": \"文件上传失败，请检查文件大小及文件类型\", \"type\": \""+upfileContentType+"\", \"url\": \"\"}";
			}
		} else {
			message = "{\"name\":\""+upfileFileName+"\", \"originalName\": \""+upfileFileName+"\", \"size\": "+upfile.length()+",\"state\": \"文件上传失败，请检查文件大小及文件类型\", \"type\": \""+upfileContentType+"\", \"url\": \"\"}";
		}
		ActionContext.getContext().put("message", message);
		return "message";
	}
	
	public File getUpfile() {
		return upfile;
	}

	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}

	public String getUpfileContentType() {
		return upfileContentType;
	}

	public void setUpfileContentType(String upfileContentType) {
		this.upfileContentType = upfileContentType;
	}

	public String getUpfileFileName() {
		return upfileFileName;
	}

	public void setUpfileFileName(String upfileFileName) {
		this.upfileFileName = upfileFileName;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

}
