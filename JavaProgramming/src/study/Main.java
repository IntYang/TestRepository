package study;


// 야근하다가 죽음 과로사 과로사 * 10000000000000000000000000000
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)// throws Exception
	{
		try {
			Scanner sc = new Scanner(System.in);

			String path;
			String find;
			path = sc.nextLine();
			find = sc.nextLine();

			String[] list_find = find.split(",");
			int[] ans = new int[list_find.length];
			for (int i = 0; i < list_find.length; i++)
				ans[i] = 0;

			FileReader in1 = new FileReader(path);
			BufferedReader inp = new BufferedReader(in1);

			while (true) {
				String buf;// =new String();
				if ((buf = inp.readLine()) != null) {
					String[] text = buf.split("[.]");
					System.out.println(buf + " " + text.length);

					for (int i = 0; i < text.length; i++) {

						for (int j = 0; j < list_find.length; j++) {
							if (text[i].contentEquals(list_find[j])) {

								ans[j]++;
							}

						}
					}
				} else
					break;

			}

			for (int i = 0; i < list_find.length; i++) {
				System.out.println(list_find[i] + "는 " + ans[i] + "개 ");

			}
			inp.close();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}