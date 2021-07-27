import java.util.Scanner;

public class maneg {
	public static void main(String[] args) {
	 //Mode変数（モード選択に入力する値）
	int Mode5;
	int end = 0; //while分を抜け出す時に使用
	int pas; //暗証番号
	int i = 1;//暗証番号が違うときにループする際に使用

	while (true)LAVER1: {
		try{


		System.out.println("暗証番号を入力して下さい。(3ケタ)");
		System.out.print("-->");

		Scanner mode1= new Scanner(System.in);
	    pas = mode1.nextInt();

		if (pas != 777){  //暗証番号が777以外だったら
			System.out.println("暗証番号が違います。モード選択に戻ります。");




maina.main(args);
break;



		}else{System.out.println("認証しました\n");
		}






		}catch (Exception e) {
			System.out.println("不正入力です。もう一度やり直してください。");
			break LAVER1;
	}









			while (true)LAVER: {
				try{
				System.out.println("-------------------------------\n");
				System.out.println("1:→商品補充\n");
				System.out.println("2:→金銭補充\n");
				System.out.println("3:→戻る(モード選択画面）\n");
				System.out.println("数字を選択して下さい。\n");
				System.out.println("-------------------------------\n");
				System.out.print("選択-->");




			Scanner mode4= new Scanner(System.in);
		    Mode5 = mode4.nextInt();

				switch (Mode5) {

					case 1: //'1'と入力されたとき
						System.out.println("商品補充");
						zaikokanri.main(args);
						end=1;
						break;

					case 2: //'2'と入力されたとき
						System.out.println("金銭補充");
						kinnsenkanri.main(args);
						end=1;
						break;

				case 3: //'3'と入力されたとき
					maina.main(args);
					//モード選択画面に戻る
					break;

				default:
					System.out.println("\n不正入力です。もう一度選択してください。\n\n");
					break LAVER;
				}
				if (end == 1) //end=1なら
					break; //while文を抜け出す
			}catch (Exception e) {
				System.out.println("不正入力です。もう一度やり直してください。");
				break LAVER;

			}
				break;
		}
break;
	}
}
}
