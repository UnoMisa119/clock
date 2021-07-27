import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 */

/**
 * @author ekusi
 *
 */
public class zaikokanri {
	public static Connection connect() throws SQLException,
	InstantiationException {

	                Connection cnx = null;
	                String url,username = null,password = null;


	                url = "jdbc:mysql://localhost:3306/item";
	                username = "root";
	                password = "";

	                try{
	         Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	                 cnx =DriverManager.getConnection(url, username, password);
	                 //System.out.println("connected");
	                }
	                catch (ClassNotFoundException e) {
	                e.printStackTrace();

	        } catch (IllegalAccessException e) {
	                        // TODO 自動生成された catch ブロック
	                        e.printStackTrace();
	                }

	                return cnx;
	        }


	        public static void FetchData() throws Exception{
	                Connection cnx = connect();
	                String sql = "select*from shouhin;";

	                try {
	                java.sql.Statement st= cnx.createStatement();
	                ResultSet rs = st.executeQuery(sql);

	                while(rs.next()){
	                	System.out.println("商品番号 = " + rs.getInt(1) + "\t" + " " + "商品名 = " + rs.getString(2) + "\n" + "在庫数 = "
	    						+ rs.getInt(4) + "個" + "\t" + " " + "価格 = " + rs.getInt(3) + "円" + "\n"+"売り上げ"+rs.getInt(5)+"円");

	                }
	                }catch (SQLException e) {

	                        e.printStackTrace();
	                }
	        }
	        public static void zaikokanri(int KKK, int LLL ) throws Exception {

				Vector vec = new Vector();
	                        Connection cnx = connect();
	                        cnx.setAutoCommit(false);
		                String sql;
				ResultSet rs;
				PreparedStatement st = null;

		          try {


				sql = "select*from shouhin;";
		                st= cnx.prepareStatement(sql);
		                rs = st.executeQuery(sql);

				int bbb = 0;
		                while(rs.next()){

					vec.add(rs.getInt(1)) ;
					bbb++;
					vec.add(rs.getString(2)) ;
					bbb++;
					vec.add(rs.getInt(3)) ;
					bbb++;
					vec.add(rs.getInt(4)) ;
					bbb++;

		                }

		    		int a = 0;
		    		int b = 0;
		    		if (KKK == 1) {


		    			a = (int) vec.get(3)+LLL;
		    			b = (int) vec.get(0);


		    			}
		    		else if (KKK == 2) {
		    			a = (int) vec.get(7)+LLL;
		    			b = (int) vec.get(4);
		    		} else if (KKK == 3) {
		    			a = (int) vec.get(11)+LLL;
		    			b = (int) vec.get(8);
		    		} else if (KKK == 4) {
		    			a = (int) vec.get(15)+LLL;
		    			b = (int) vec.get(12);
		    		} else if (KKK == 5) {
		    			a = (int) vec.get(19)+LLL;
		    			b = (int) vec.get(16);
		    		}



		    			sql = "UPDATE shouhin SET zaiko = ? where number=?";
		    			st = cnx.prepareStatement(sql);

			    		st.setInt(1,a);
			    		st.setInt(2,b);

			    		st.executeUpdate();
			    		cnx.commit();








		    	    }catch (SQLException e) {

		    		e.printStackTrace();
		    	    }
	        }





	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ


		while(true)LAVER9:{

			try {
				FetchData();


				System.out.println("補充する商品番号を入力して下さい。");
				System.out.print("==>");
				BufferedReader kosuu = new BufferedReader(new InputStreamReader(System.in));
				String Kosuu = kosuu.readLine();
				int KKK = Integer.parseInt(Kosuu);
				BufferedReader kosuu1 = new BufferedReader(new InputStreamReader(System.in));

				if (KKK == 1) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String Kosu = kosuu1.readLine();
					int LLL = Integer.parseInt(Kosu);
					System.out.println(LLL+"個補充されました。");
					zaikokanri(KKK, LLL);


				} else if (KKK == 2) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String Kosu = kosuu1.readLine();
					int LLL = Integer.parseInt(Kosu);
					zaikokanri(KKK, LLL);
				} else if (KKK == 3) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String Kosu = kosuu1.readLine();
					int LLL = Integer.parseInt(Kosu);
					zaikokanri(KKK, LLL);
				} else if (KKK == 4) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String Kosu = kosuu1.readLine();
					int LLL = Integer.parseInt(Kosu);
					zaikokanri(KKK, LLL);
				} else if (KKK == 5) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String Kosu = kosuu1.readLine();
					int LLL = Integer.parseInt(Kosu);
					zaikokanri(KKK, LLL);

				} else {
					System.out.println("番号が違います。もう一度入力して下さい。");
                    break LAVER9;
				}
			}catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("不正入力です。");
				 break LAVER9;
		}


while(true){
					try{

						zaikokanri.FetchData();
						System.out.println("もう一度補充しますか？Y:補充N:終了");
						System.out.print("==>");
						BufferedReader aaa1 = new BufferedReader(new InputStreamReader(System.in));
						String Kan = aaa1.readLine();
						char Kakunin=Kan.charAt(0);
						if(Kakunin=='Y'||Kakunin=='y'){
							System.out.println("補充をもう一度行います。");
							break LAVER9;
						}else if(Kakunin=='N'||Kakunin=='n'){
							System.out.println("補充を終了します");
							maina.main(args);

						}else{
							System.out.println("不正入力です。");
							continue;
						}

					}catch (Exception e) {
						// TODO 自動生成された catch ブロック
						System.out.println("不正入力です。");
				}
break;
				}
	break;}

}
}




