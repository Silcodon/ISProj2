package servicos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import common.Institution;
import common.Publication;
import common.Researcher;


public class LoadDatabaseSQL {
	
	private final static String name = "postgres";
	private final static String password = "Antoniomaria2";
	private final static String tablenameresearcher = "researcher";
	private final static String tablenameinstitution = "institution";
	private final static String tablenameresearch = "research";
	private final static String tablenameresearcherinstitution = "researcher_institution";
	private final static String tablenameresearcherresearch = "researcher_research";
	private final static String url = "jdbc:postgresql://localhost/postgres";
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = (Connection) DriverManager.getConnection (url , name , password );
		Statement stmt = (Statement) conn.createStatement();
		//Researchers SQL
		String sql = "CREATE TABLE IF NOT EXISTS " + tablenameresearcher + "(id SERIAL NOT NULL , Name VARCHAR(254), Introduction VARCHAR(500), PRIMARY KEY (id))";
		stmt.executeUpdate(sql);
		Set<Researcher> myset = GetResearcherInfo.getinfo();
		int rows = 0;
		for (Researcher st : myset){
			sql = "INSERT INTO " + tablenameresearcher + "(Name, Introduction)" + "VALUES" + "('" + st.getPersonName() + "')";
			rows += stmt.executeUpdate(sql);
		}
		System.out .println("Added " + rows + " researchers.");
		
		
		
		//Institutions
		sql = "CREATE TABLE IF NOT EXISTS " + tablenameinstitution + "(id SERIAL NOT NULL , Name VARCHAR(254), Location VARCHAR(254), Department VARCHAR(254), PRIMARY KEY (id))";
		stmt.executeUpdate(sql);
		Set<Institution> myset2 = GetInstitutionInfo.getinfo();
		rows = 0;
		for (Institution st : myset2){
			sql = "INSERT INTO " + tablenameinstitution + "(Name, Location, Department)" + "VALUES" + "('" + st.getName() + "','" + st.getLocation() + "','" + st.getDepartment() + "')";
			rows += stmt.executeUpdate(sql);
		}
		System.out .println("Added " + rows + " institutions.");
		
		
		
		//Researches
		sql = "CREATE TABLE IF NOT EXISTS " + tablenameresearch + "(id SERIAL NOT NULL , Name VARCHAR(254), Type VARCHAR(254), Date VARCHAR(254), Description VARCHAR(500), PRIMARY KEY (id))";
		stmt.executeUpdate(sql);
		Set<Publication> myset3 = GetPublicationInfo.getinfo();
		rows = 0;
		for (Publication st : myset3){
			sql = "INSERT INTO " + tablenameresearch + "(Name, Type, Date, Description)" + "VALUES" + "('" + st.getName() + "','" + st.getType() + "','" + st.getDate() + "')";
			rows += stmt.executeUpdate(sql);
		}
		System.out .println("Added " + rows + " researches.");
		
		
		/*
		//Researcher_Institution
		sql = "CREATE TABLE IF NOT EXISTS " + tablenameresearcherinstitution + "(id SERIAL NOT NULL , Name VARCHAR(254), Location VARCHAR(254), Department VARCHAR(254), PRIMARY KEY (id))";
		stmt.executeUpdate(sql);
		Set<Institution> myset2 = GetInstitutionInfo.getinfo();
		rows = 0;
		for (Institution st : myset2){
			sql = "INSERT INTO " + tablenameinstitution + "(Name, Location, Department)" + "VALUES" + "('" + st.getName() + "','" + st.getLocation() + "','" + st.getDepartment() + "')";
			rows += stmt.executeUpdate(sql);
		}
		System.out .println("Added " + rows + " institutions.");
		*/
	}
}
