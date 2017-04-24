package ch18.exam10;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleExample {

    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
//        int keycode = is.read();

//how1 : 이 코드 알아둘 것
        byte[] keycode = new byte[10];
        int readBytes = is.read(keycode);
        System.out.println(Arrays.toString(keycode));
        // String str = new String(keycode, 0, readBytes-1); // 13번이 안들어감
        String str = new String(keycode, 0, readBytes - 2); // 콘솔의 문제 있을 수 잇으므로 캐리지 리턴 라인피드 때문에

        System.out.println(str);

//how2
        Scanner scanner = new Scanner(System.in);
        String str2 = scanner.nextLine();
        System.out.println(str2);
//how3
    
    Console console = System.console();
    String str3 = console.readLine();
        System.out.println(str3);
    

    
    }
}
