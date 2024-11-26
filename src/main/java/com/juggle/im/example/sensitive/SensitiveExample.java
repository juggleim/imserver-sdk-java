package com.juggle.im.example.sensitive;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.sensitiveword.SensitiveWordFileReq;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SensitiveExample {

    private static final String APP_KEY = "test";
    private static final String APP_SECRET = "myn8SP70TXtSZnn7";
    private static final String PREFIX_API = "http://127.0.0.1:8082";

    public SensitiveExample() {
    }

    public static void main(String[] args) throws Exception {
        JuggleIm sdk = new JuggleIm(APP_KEY, APP_SECRET, PREFIX_API);

        // wordType 1 拦截
        // wordType 2 替换

//        // add sensitiveword
//        SensitiveAddReq addReq = new SensitiveAddReq();
//        // TODO 是否需要创建敏感词类型枚举类？
//        addReq.setItems(List.of(new SensitiveWordItem("勒塞", 2), new SensitiveWordItem("肮脏的", 2)));
//        ResponseResult addResult = sdk.sensitiveWord.add(addReq);
//        System.out.println("addResult:" + addResult.toString());

//        // del sensitiveword
//        SensitiveDelReq delReq = new SensitiveDelReq();
//        delReq.setWords(List.of("勒塞", "肮脏的"));
//        ResponseResult delResult = sdk.sensitiveWord.del(delReq);
//        System.out.println("delResult:" + delResult.toString());

//        // 分页获取数据
//        SensitiveWordReq pageReq = new SensitiveWordReq();
//        pageReq.setPage(1);
//        pageReq.setSize(10);
////        pageReq.setWord("肮脏的");
//        pageReq.setWordType(2);
//        SensitiveWordResult pageResult = sdk.sensitiveWord.page(pageReq);
//        System.out.println("pageResult:" + pageResult.toString());

//        // 导入文件
//        File file = new File("C:\\Users\\yoursname\\Desktop\\test.txt");
//        SensitiveWordFileReq fileReq = new SensitiveWordFileReq();
//        try (FileInputStream fis = new FileInputStream(file)) {
//            byte[] data = new byte[(int) file.length()];
//            fis.read(data);
//            fileReq.setData(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        fileReq.setFileName(file.getName());
//        ResponseResult fileResult = sdk.sensitiveWord.importFromFile(fileReq);
//        System.out.println("fileResult:" + fileResult.toString());

    }
}
