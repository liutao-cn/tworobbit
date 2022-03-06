package cn.t18.est.controller;

import cn.t18.est.config.OssProperties;
import cn.t18.est.constants.Result_CodeInfo;
import cn.t18.est.dto.Result;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * 测试文件上传到阿里云oss对象存储
 */
@RestController
public class FileUploadTest {

    @Resource
    private OssProperties ossProperties;


    @ApiOperation("文件上传和文件下载到本地的方法")
     @ApiImplicitParams({
             @ApiImplicitParam(name = "multipartFile",value = "上传的文件内容")
     })
    @PostMapping("/api/fileupload")
    public Result fileUpload(/*MultipartFile multipartFile*/) throws IOException {
  /*      // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。关于其他Region对应的Endpoint信息，请参见访问域名和数据中心。
        String endpoint =ossProperties.getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId =ossProperties.getAccessKeyId();
        String accessKeySecret = ossProperties.getAccessKeySecret();
        // 填写Bucket名称，例如examplebucket。
        String bucketName =ossProperties.getBucketName();
        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
        //String objectName = ossProperties.getFilepath();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String originalFilename = multipartFile.getOriginalFilename();//获取文件的名字
        String uuid = IdUtil.simpleUUID();  //通过uuid获取替换原文件文件名
        int suffixIndex = multipartFile.getOriginalFilename().lastIndexOf(".");   //获取文件的后缀名下标.
        String suffix = multipartFile.getOriginalFilename().substring(suffixIndex);  //截取后缀名包含.
        String objectName =ossProperties.getFilepath()+uuid + suffix;     //将新的文件名和后缀进行拼接

        try {
            //上传的文件要为输入流
            InputStream inputStream = multipartFile.getInputStream();
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName,inputStream);
            //上传文件名
            ossClient.putObject(putObjectRequest);
        }finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }*/


        // Endpoint以北京为例，其它Region请按实际情况填写。
        String endpoint = ossProperties.getEndpoint();
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ossProperties.getAccessKeyId();
        String accessKeySecret = ossProperties.getAccessKeySecret();
        // 填写Bucket名称。
        String bucketName = ossProperties.getBucketName();
        // 填写Object的完整路径。Object完整路径中不能包含Bucket名称。 文件必须在oss中在在
        String objectName = "tworabbit/picture/291fe4db52114d6abfd817fb75300b3d.txt";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 下载Object到本地文件，并保存到指定的本地路径中。如果指定的本地文件存在会覆盖，不存在则新建。
        // 如果未指定本地路径，则下载后的文件默认保存到示例程序所属项目对应本地路径中。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File("D:\\Java\\downloadFile.txt"));

        // 关闭OSSClient。
        ossClient.shutdown();

     return Result.success(Result_CodeInfo.ERROR_CODE,Result_CodeInfo.SUCCESS_MSG);
    }

}
