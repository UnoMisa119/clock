import java.util.Scanner;
public class maina {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int Mode;
		int end = 0;



		while (true) {
			try{

			System.out.print("-------------------------------\n");
			System.out.print("1:→商品購入\n");
			System.out.print("2:→補充\n");
			System.out.print("3:→終了\n");
			System.out.print("数字を選択して下さい。\n");
			System.out.print("-------------------------------\n");
			System.out.print("選択-->");

			Scanner mode= new Scanner(System.in);
		    Mode = mode.nextInt();


			switch (Mode) {

				case 1:
					System.out.print("商品購入が選択されました。\n\n");
					Money.money(args);
					end=1;
					break;

				case 2:
					System.out.print("在庫補充が選択されました。\n\n");
maneg.main(args);
					break;

				case 3:
					System.out.print("終了します。\nご購入いただきありがとうございました！\n\n");
					end = 1;
					break;

				default:
					System.out.print("\n不正入力です。もう一度選択してください。\n\n");
					break;
			}
			if (end == 1)
				break;


			}catch(Exception e){
				System.out.println("不正入力です。もう一度入力しなおしてください");
			}
			break;
		}



	}

}
