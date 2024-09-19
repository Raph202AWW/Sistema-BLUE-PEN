module ProjetBluePen {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	exports packController;
	opens packController to javafx.fxml;
	exports pack_Controlle;
	opens pack_Controlle to javafx.fxml;
	exports pack_Model;
	opens pack_Model to javafx.fxml;
	
	
	opens application to javafx.graphics, javafx.fxml;
}
