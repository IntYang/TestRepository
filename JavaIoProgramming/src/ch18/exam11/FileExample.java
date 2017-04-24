package ch18.exam11;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) throws IOException{
        //파일 디렉토리 정보 얻기
        File file = new File("src\\ch18\\exam10\\ConsoleExample.java");
        System.out.println(file.exists());
        System.out.println(file.length());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        System.out.println("-----------------");

        File dir = new File("C:/Windows");

        System.out.println(dir.exists());
        System.out.println(dir.length());
        System.out.println(dir.isFile());
        System.out.println(dir.isDirectory());

//        String[] content1 = dir.list();
        File[] content2 = dir.listFiles();
        System.out.println("-----------------");
//           System.out.println(content1);
        for (File file1 : content2) {
            String info = "";

            info += file1.getName();
            info += "\t\t";
            info += (file1.isDirectory()) ? "<dir>" : "";
            info += file1.length();

            System.out.println(info);
        }
        
        
        //파일 및 디렉토리의 생성과 삭제
        
        File file2 = new File("C:/Temp/test.txt");
        file2.createNewFile();
        file2.delete();
        
        File dir2 = new File("C:/Temp/dir2");
        dir2.mkdirs();
        dir2.delete(); // 디렉토리 지울 때 안에 내용있는 파일 있으면 안 지워짐.
        
        File dir3 = new File("C:/Temp/dir3/dir4/dir5");
        dir3.mkdirs();
        
        

    }
}
