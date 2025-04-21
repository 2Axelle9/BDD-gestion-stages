package admin_sql_tp2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
public class MyController {


    @FXML
    private TextField modifyTextField;

    @FXML
    private TextField newValueTextField;

    @FXML
    private TextField nomUpdateEtuTextField;

    @FXML
    private TextField prenomUpdateEtuTextField;
    @FXML
    private TextField adrEtuTextField;

    @FXML
    private TextField mailEtuTextField;

    @FXML
    private TextField prenomInsertEtuTextField;
    @FXML
    private TextField nomInsertEtuTextField;

    @FXML
    private TextField numEtuTextField;

    @FXML
    private Label myConnexionLabel;

    @FXML
    private TextField myIdentityTextField;

    @FXML
    private TextField myPasswordTextField;

    @FXML
    private TextField nomEtuTextField;

    @FXML
    private TextField prenomEtuTextField;

    @FXML
    private TextField myQueryTextField;

    @FXML
    private Label myResultLabel;

    private MyJDBC myJDBC=new MyJDBC("com.microsoft.sqlserver.jdbc.SQLServerDriver","jdbc:sqlserver://172.30.4.243\\LHAMON;databaseName=cloetmDB");

    private boolean connected=false;

    //le id nous permet de créer des identifiants différent car nous n'avons pas integrer d'auto_Increment
    int Id = 12;

    @FXML
    void modifyButton(ActionEvent event) throws SQLException {
        String result = myJDBC.executeWriteQuery
                ("UPDATE infoEleve SET " + modifyTextField.getText() +" = '" + newValueTextField.getText() + "' WHERE Nom_Etudiant = '" + nomUpdateEtuTextField.getText() +"' AND Prenom_Etudiant = '" + prenomUpdateEtuTextField.getText()+"';");
        myResultLabel.setText(result);
        System.out.println("UPDATE infoEleve SET " + modifyTextField.getText() +" = '" + newValueTextField.getText() + "' WHERE Nom_Etudiant = '" + nomInsertEtuTextField.getText() +"' AND Prenom_Etudiant = '" + prenomInsertEtuTextField.getText()+"';");
    }
    @FXML
    void InsertEtuButton(ActionEvent event) throws SQLException {
        Id++;
        System.out.println("add");
        String result =myJDBC.executeWriteQuery
                ("INSERT INTO infoEleve VALUES ("+Id+", '"+nomInsertEtuTextField.getText()+"','"+prenomInsertEtuTextField.getText()+"','" + adrEtuTextField.getText() +"','"+mailEtuTextField.getText()+"','"+numEtuTextField+"'," + null+";");
        myResultLabel.setText(result);
    }

    @FXML
    void searchAttestationButton(ActionEvent event) throws SQLException {
        System.out.println("SELECT * FROM infoAttestation WHERE Nom_Etudiant = '" + nomEtuTextField.getText() + "' AND Prenom_Etudiant = '" + prenomEtuTextField.getText() + "';");
        String result=myJDBC.executeReadQuery
                ("SELECT * FROM infoAttestation WHERE Nom_Etudiant = '" + nomEtuTextField.getText() + "'AND Prenom_Etudiant = '" + prenomEtuTextField.getText() + "'");
        myResultLabel.setText(result);
    }

    @FXML
    void searchFormulaireButton(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery
                ("SELECT * FROM etatForm WHERE Nom_Etudiant = '" + nomEtuTextField.getText() + "'AND Prenom_Etudiant = '" + prenomEtuTextField.getText() + "'");
        myResultLabel.setText(result);
    }

    @FXML
    void searchEtuButton(ActionEvent event) throws SQLException {
        String result= myJDBC.executeReadQuery
                ("SELECT * FROM infoEleve WHERE Nom_Etudiant = '" + nomEtuTextField.getText() + "'AND Prenom_Etudiant = '" + prenomEtuTextField.getText() + "'");
        myResultLabel.setText(result);
    }

    @FXML
    void searchNoteButton(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery
                ("SELECT * FROM noteEtu WHERE Nom_Etudiant = '" + nomEtuTextField.getText() + "'AND Prenom_Etudiant = '" + prenomEtuTextField.getText() + "'");
        myResultLabel.setText(result);
    }

    @FXML
    void searchStageButton(ActionEvent event) {

    }

    @FXML
    void AttestationPressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM infoAttestation");
        myResultLabel.setText(result);
    }

    @FXML
    void EnseignantPressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM infoTuteur");
        myResultLabel.setText(result);
    }

    @FXML
    void EntreprisePressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM infoEntreprise");
        myResultLabel.setText(result);
    }

    @FXML
    void EtudiantPressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM infoEleve");
        myResultLabel.setText(result);
    }

    @FXML
    void FormulairePressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM etatForm");
        myResultLabel.setText(result);
    }

    @FXML
    void NotePressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM noteEtu");
        myResultLabel.setText(result);
    }

    @FXML
    void StagePressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM infoStage");
        myResultLabel.setText(result);
    }

    @FXML
    void SuperviseurPressEvent(ActionEvent event) throws SQLException {
        String result=myJDBC.executeReadQuery("SELECT * FROM infoSuperviseur");
        myResultLabel.setText(result);
    }



    @FXML
    void connexionPressEvent(ActionEvent event) throws ClassNotFoundException, SQLException {
                if(!connected){
                    myJDBC.connect(myIdentityTextField.getText(),myPasswordTextField.getText());
                    myConnexionLabel.setText("Connecté");
                    connected=true;
                 }
                else{
                    myJDBC.disconnect();
                    myConnexionLabel.setText("Pas connecté");
                    connected=false;
                }
    }

    @FXML
    void executionPressEvent(ActionEvent event)
            throws SQLException {
        String result=myJDBC.executeReadQuery(myQueryTextField.getText());
        myResultLabel.setText(result);
    }
}
