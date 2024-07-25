package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDataBase_PostgreSQL {
	
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		
	
	String url ="" ;
    String user = "";
    String password = "";

    try (Connection con = DriverManager.getConnection(url, user, password);
         FileInputStream fis = new FileInputStream("D:\\Rathna\\Team8_DataScrapers_RecipeScrapingHackathonJuly2024\\Team8_DataScraper_Allergies.xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

        createTable(con, "Allergies_SOY");
       
        
        createTable(con, "Allergies_EGG");
        
        
        createTable(con, "Allergies_MILK");
       
        
        createTable(con, "Allergies_SESAME");
    
        
        createTable(con, "Allergies_Walnut");
     
        createTable(con, "Allergies_Almond");
      
        
        createTable(con, "Allergies_Hazelnut");
       
        
        createTable(con, "Allergies_Pecan");
   
        
        createTable(con, "Allergies_Cashew");
        
        
        createTable(con, "Allergies_Pistachio");
       
        
        createTable(con, "Allergies_Shellfish");
       
        
        createTable(con, "Allergies_Seafood");
       
        
        createTable(con, "Allergies_PEANUT");
      
    	
        createTable(con, "LFV_Elimination");
     

        createTable(con, "LFV_Add");
        

        createTable(con, "LCHF_Elimination");
       

        createTable(con, "LFV_Recipes_To_Avoid");
       

        createTable(con, "LCHF_Food_Processing");
        

        createTable(con, "LFV_Add_Non_VEGAN");


        createTable(con, "LCHF_Add");
       
    }
}

private static void createTable(Connection con, String tableName) throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
            "Recipe_Id VARCHAR," +
            "Recipe_Name VARCHAR," +
            "Recipe_Category VARCHAR," +
            "Food_Category VARCHAR," +
            "Ingredients VARCHAR," +
            "Preperation_Time VARCHAR," +
            "Cooking_Time VARCHAR," +
            "Tag VARCHAR," +
            "No_Of_Servings VARCHAR," +
            "Cuisine_Category VARCHAR," +
            "Recipe_Desc VARCHAR," +
            "Preperation_Method VARCHAR," +
            "Nutrient_Values VARCHAR," +
            "Recipe_URL VARCHAR)";
    try (Statement stm = con.createStatement()) {
        stm.execute(sql);
    }
}

private static void insertData(Connection con, String tableName) throws SQLException {
   
}


}
