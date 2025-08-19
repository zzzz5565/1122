package com.huitong.common.utils;

import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

public class FileZipUtil {

    private static String zipPassword="HT@dmin2022";//默认密码， 可更改

    public static void zipFile(String docFilePaths, String zipFilePath, HttpServletResponse response) throws Exception {

        ArrayList filesToAdd = new ArrayList();
        if(StringUtils.isNotEmpty(docFilePaths)){
            String docFilePathArry[] = docFilePaths.split(",");
            for (String docFilePath :docFilePathArry) {
                filesToAdd.add(new File(docFilePath));
            }
        }

        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream;charset=UTF-8");
        // inline在浏览器中直接显示，不提示用户下载
        // attachment弹出对话框，提示用户进行下载保存本地
        // 默认为inline方式
        zipFilePath = zipFilePath + ".zip";
        // 处理中文文件名的问题
        zipFilePath = URLEncoder.encode(zipFilePath, "UTF-8");
        zipFilePath = new String(zipFilePath.getBytes("UTF-8"), "GBK");
        response.setHeader("Content-Disposition", "attachment;filename=" + zipFilePath);

        ZipOutputStream outputStream = new ZipOutputStream(response.getOutputStream());

        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);//压缩
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);//压缩
        parameters.setEncryptFiles(true);//加密
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);//加密
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);//加密
        parameters.setPassword(zipPassword);//加密

        for (int i = 0; i < filesToAdd.size(); i++) {

            File file = (File)filesToAdd.get(i);
            outputStream.putNextEntry(file,parameters);
            if (file.isDirectory()) {
                outputStream.closeEntry();
                continue;
            }

            InputStream inputStream = new FileInputStream(file);
            byte[] readBuff = new byte[4096];
            int readLen = -1;
            while ((readLen = inputStream.read(readBuff)) != -1) {
                outputStream.write(readBuff, 0, readLen);
            }
            outputStream.closeEntry();
            inputStream.close();
        }
        outputStream.finish();
        outputStream.close();
    }

    public static void zipFilePwd(String docFilePath,String zipFilePath,String password) throws Exception {

        if(StringUtils.isEmpty(password)){
            password = zipPassword;
        }

        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);//压缩
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);//压缩
        parameters.setEncryptFiles(true);//加密
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);//加密
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);//加密
        parameters.setPassword(password);//加密

        ArrayList filesToAdd = new ArrayList();
        filesToAdd.add(new File(docFilePath));
        ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(new File(zipFilePath)));
        for (int i = 0; i < filesToAdd.size(); i++) {

            File file = (File)filesToAdd.get(i);
            outputStream.putNextEntry(file,parameters);
            if (file.isDirectory()) {
                outputStream.closeEntry();
                continue;
            }

            InputStream inputStream = new FileInputStream(file);
            byte[] readBuff = new byte[4096];
            int readLen = -1;
            while ((readLen = inputStream.read(readBuff)) != -1) {
                outputStream.write(readBuff, 0, readLen);
            }
            outputStream.closeEntry();
            inputStream.close();
        }
        outputStream.finish();
        outputStream.close();
    }
}
