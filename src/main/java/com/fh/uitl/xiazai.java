package com.fh.uitl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.fh.common.Constant;

import java.io.InputStream;

/**
 * 
 * <pre>项目名称：   
 * 类名称：FileUtil    
 * 类描述：    文件工具类   
 * @version </pre>
 */
public class xiazai {

	public static String uploadImg(InputStream is, String imgName){
		// 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/init.html?spm=5176.docoss/sdk/java-sdk/get-start
		OSS ossClient = new OSSClientBuilder().build(Constant.endpoint,Constant.accessKeyId, Constant.accessKeySecret);
		//putobject (1,2,3)  1 bucket  2 文件名（目录/文件名） 3 输入流
		PutObjectResult putObjectResult = ossClient.putObject(Constant.bucketName, imgName, is);
		return "http://"+Constant.bucketName+".oss-cn-beijing.aliyuncs.com/"+imgName;
	}
}
