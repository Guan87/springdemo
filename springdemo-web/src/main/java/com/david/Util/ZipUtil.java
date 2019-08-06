package com.david.Util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by GW on 2019/7/1.
 */
public class ZipUtil {

    /*
    * 递归压缩文件
    * @param locationPath 要压缩的源文件(目录或单个文件)
    * */
    public static File copress(String locationPath) throws IOException {
        String source = locationPath;
        String destinct = locationPath+".zip";
        File zipFile = new File(destinct);

        List fileList = loadFileName(new File(source));

        //压缩后的zip文件
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));


        byte[] buffer = new byte[8192];
        int length;
        BufferedInputStream bis ;

        for (int i=0;i<fileList.size();i++){
            File file = (File)fileList.get(i);
            // 定位到该压缩条目位置，开始写入文件到压缩包中
            zos.putNextEntry(new ZipEntry(getEntryName(source,file)));
            bis = new BufferedInputStream(new FileInputStream(file));
            while(true){
                length = bis.read(buffer);
                if(length == -1){
                    break;
                }
                zos.write(buffer,0,length);
            }
            bis.close();
            zos.close();
        }

        zos.close();
        return zipFile;
    }

    /*
    * 递归获取该文件下所有文件的文件名（不包括目录名）
    * */
    private static List loadFileName(File file){
        List filenameList = new ArrayList();
        if(file.isFile()){
            filenameList.add(file);
        }
        if(file.isDirectory()){
            for(File f : file.listFiles()){
                filenameList.addAll(loadFileName(f));//递归获取
            }
        }

        return  filenameList;
    }

    // 压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样
    private static String getEntryName(String baseFileName, File file){
        File baseFile = new File(baseFileName);
        String fileName = file.getPath();
        //判断是不是根目录下面的二级目录
        //File.getParent()将此抽象路径名转换为一个路径名字符串
        if (baseFile.getParentFile().getParentFile() == null){
             //baseFile="D:\PDF"  fileName="D:PDF\temp\temp.doc"  vbaseFile.getParent()为 "D:\" 结果:"PDF\temp\temp.doc"
            return fileName.substring(baseFile.getParent().length());

        }else{
            //baseFile="D:PDF/temp" fileName="D:PDF\temp\temp.doc" baseFile.getParent()为 "D:\PDF"  结果："temp\temp.doc"
            return fileName.substring(baseFile.getParent().length()+1);
        }

    }

    /**
     * 递归删除文件
     *
     * @param file
     * @return
     */
    private static void deleteFile(File file) {

        if (file.isFile()) {
            file.delete();
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteFile(f);
            }
            file.delete();
        }


    }

}
