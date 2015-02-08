package com.cy.web.action.uploadfile;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cy.bean.Paging;
import com.cy.bean.uploadfile.UploadFile;
import com.cy.service.uploadfile.UploadFileService;
import com.cy.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 上传文件列表控制器
 * @author CY
 *
 */
@Controller
@Scope("prototype")
public class UploadFileAction extends BaseAction {

	@Resource
	private UploadFileService uploadFileService;
	
	/**
	 * 文件列表
	 * @return
	 */
	public String execute() {
		Paging<UploadFile> paging = new Paging<>(getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		orderby.put("id", "desc");
		paging.setQueryResult(uploadFileService.getScrollData(paging.getfirstResult(),paging.getMaxResult(),orderby));
		ActionContext.getContext().put("paging", paging);
		return "success";
	}

}
