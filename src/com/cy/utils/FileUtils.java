package com.cy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件操作工具类
 * @author CY
 *
 */
public class FileUtils {

	/**
	 * 删除指定文件，如果删除该文件之后，文件夹为空则删除该文件夹，继续向上判断
	 * @param file 被删除的文件
	 */
	public static void DelFiles(File file) {
		while(file != null && file.delete()) {
			file = file.getParentFile();
		}
	}
	
	/**
	 * 获取文件的扩展名（后缀）
	 * @param fileName test.txt
	 * @return txt
	 */
	public static String getExt(String fileName){
		return fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();
	}
	
	/**
	 * 获取文件的扩展名（后缀）
	 * @param fileName test.txt
	 * @return .txt
	 */
	public static String getSuffix(String fileName) {
		return fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
	}
	
	/**
	 * 保存文件
	 * @param saveDir 存放的目录
	 * @param fileName 文件名称
	 * @param data 保存的内容
	 * @return 保存的文件
	 * @throws IOException 
	 * @throws Exception
	 */
	public static File saveFile(File saveDir, String fileName, byte[] data) throws IOException {
		if(!saveDir.exists()) saveDir.mkdirs();//如果目录不存在就创建
		File file = new File(saveDir, fileName);
		FileOutputStream fileoutstream = new FileOutputStream(file);
		fileoutstream.write(data);
		fileoutstream.close();
		return file;
	}
	
	/**
	 * 保存文件
	 * @param saveDirPath 存放的目录
	 * @param fileName 文件名称
	 * @param data 保存的内容
	 * @return 保存的文件
	 * @throws IOException 
	 * @throws Exception
	 */
	public static File saveFile(String saveDirPath, String fileName, byte[] data) throws IOException {
		return saveFile(new File(saveDirPath), fileName, data);
	}
	
	/**
	 * 保存文件
	 * @param saveFile 被保存的文件
	 * @param data 保存的内容
	 * @return 保存的文件
	 * @throws IOException
	 */
	public static File saveFile(File saveFile, byte[] data) throws IOException {
		return saveFile(saveFile.getParentFile(), saveFile.getName(), data);
	}
	
	/**
	 * @param filePath 文件的路径
	 * @param data 保存的内容
	 * @return 保存的文件
	 * @throws IOException 
	 * @throws Exception
	 */
	public static File saveFile(String filePath, byte[] data) throws IOException {
		return saveFile(new File(filePath), data);
	}
	
	
}
