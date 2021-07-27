import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class kinnsenkanri {

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


	        public static void KanriData() throws Exception{
	                Connection cnx = connect();
	                String sql = "select*from kinnsen;";

	                try {
	                java.sql.Statement st= cnx.createStatement();
	                ResultSet rs = st.executeQuery(sql);

	                while(rs.next()){
	                	System.out.println("金銭番号 = " + rs.getInt(1)+ "\t"+ rs.getInt(2) +"円" + "\t"+"在庫数 = "
	    						+ rs.getInt(3) + "枚");
	                }
	                }catch (SQLException e) {

	                        e.printStackTrace();
	                }
	        }
	        public static void kinsen(int PPP, int SSS ) throws Exception {

				Vector vec = new Vector();
	                        Connection cnx = connect();
	                        cnx.setAutoCommit(false);
		                String sql;
				ResultSet rs;
				PreparedStatement st = null;

		          try {


				sql = "select*from kinnsen;";
		                st= cnx.prepareStatement(sql);
		                rs = st.executeQuery(sql);

				int ccc = 0;
		                while(rs.next()){

					vec.add(rs.getInt(1)) ;
					ccc++;
					vec.add(rs.getInt(2)) ;
					ccc++;
					vec.add(rs.getInt(3)) ;
					ccc++;


		                }

		    		int a = 0;
		    		int b = 0;
		    		if (PPP == 1) {


		    			a = (int) vec.get(2)+SSS;
		    			b = (int) vec.get(0);


		    			}
		    		else if (PPP == 2) {
		    			a = (int) vec.get(5)+SSS;
		    			b = (int) vec.get(3);
		    		} else if (PPP == 3) {
		    			a = (int) vec.get(8)+SSS;
		    			b = (int) vec.get(6);
		    		} else if (PPP == 4) {
		    			a = (int) vec.get(11)+SSS;
		    			b = (int) vec.get(9);
		    		} else if (PPP == 5) {
		    			a = (int) vec.get(14)+SSS;
		    			b = (int) vec.get(12);
		    		}

		    		
		    			sql = "UPDATE kinnsen SET zaiko = ? where number=?";
		    			st = cnx.prepareStatement(sql);

			    		st.setInt(1,a);
			    		st.setInt(2,b);

			    		st.executeUpdate();
			    		cnx.commit();








		    	    }catch (SQLException e) {

		    		e.printStackTrace();
		    	    }
	        }





	public static void main(String[] args) {


		while(true)LAVER7:{

			try {
				KanriData();


				System.out.println("補充する金銭番号を入力して下さい。");
				System.out.print("==>");
				BufferedReader Uri = new BufferedReader(new InputStreamReader(System.in));
				String Uriage = Uri.readLine();
				int PPP= Integer.parseInt(Uriage);
				BufferedReader Uri1 = new BufferedReader(new InputStreamReader(System.in));

				if (PPP == 1) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String URI = Uri1.readLine();
					int SSS = Integer.parseInt(URI);
					System.out.println(PPP+"枚補充されました。");
					kinsen(PPP, SSS);

				} else if (PPP == 2) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String URI = Uri1.readLine();
					int SSS= Integer.parseInt(URI);
					System.out.println(PPP+"枚補充されました。");

				} else if (PPP == 3) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String URI = Uri1.readLine();
					int JJJ = Integer.parseInt(URI);
					System.out.println(PPP+"枚補充されました。");

				} else if (PPP == 4) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String URI = Uri1.readLine();
					int JJJ = Integer.parseInt(URI);
					System.out.println(PPP+"枚補充されました。");

				} else if (PPP == 5) {
					System.out.println("補充する数を入力して下さい。");
					System.out.print("==>");
					String URI = Uri1.readLine();
					int JJJ = Integer.parseInt(URI);
					System.out.println(PPP+"枚補充されました。");

				} else {
					System.out.println("番号が違います。もう一度入力して下さい。");
                    break LAVER7;
				}
			}catch (Exception e) {
				// TODO 自動生成された catch ブロック
				System.out.println("不正入力です。");
				 break LAVER7;
		}


while(true){
					try{
						kinnsenkanri.KanriData();


						System.out.println("もう一度補充しますか？Y:補充N:終了");
						System.out.print("==>");
						BufferedReader aaa2 = new BufferedReader(new InputStreamReader(System.in));
						String KIn = aaa2.readLine();
						char KINSEN=KIn.charAt(0);
						if(KINSEN=='Y'||KINSEN=='y'){
							System.out.println("補充をもう一度行います。");
							break LAVER7;
						}else if(KINSEN=='N'||KINSEN=='n'){
							System.out.println("補充を終了します");
							maina.main(args);

						}else{
							System.out.println("不正入力です。");
							continue;
						}

					}catch (Exception e) {

						System.out.println("不正入力です。");
						continue;
				}

					break;	}
	break;}
}
}



