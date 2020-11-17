package servicos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import common.Institution;
import common.Research;
import common.Researcher;


public class LoadDatabase {
	
	private final static String name = "postgres";
	private final static String password = "Antoniomaria2";
	private final static String tablenameresearcher = "researcher";
	private final static String tablenameinstitution = "institution";
	private final static String tablenameresearch = "research";
	private final static String url = "jdbc:postgresql://localhost/postgres";
	
	public static void main(String[] args) throws SQLException {
		Researcher researcher;
		Institution institution;
		Research research;
		
		Connection conn = (Connection) DriverManager.getConnection (url , name , password );
		Statement stmt = (Statement) conn.createStatement();
		//Researchers
		String sql = "CREATE TABLE IF NOT EXISTS " + tablenameresearcher + "(id SERIAL NOT NULL , Name VARCHAR(254), Introduction VARCHAR(20), PRIMARY KEY (id))";
		stmt.executeUpdate(sql);
		Set<Researcher> myset = GetResearcherInfo.get();
		int rows = 0;
		for (Researcher st : myset){
			sql = "INSERT INTO " + tablenameresearcher + "(Name, Introduction)" + "VALUES" + "('" + st.getPersonName() + "','" + st.getIntroduction() + "')";
			rows += stmt.executeUpdate(sql);
		}
		System.out .println("Added " + rows + " researchers.");
		
		//Institutions
		
		
		
		
		//Researches
	}
}
