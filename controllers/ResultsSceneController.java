package controllers;

/**
 * Controller used to display user data in the results scene of the GUI
 *
 * Last updated April 14 2020
 *
 * @Author Alejandro
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ResultsSceneController implements Initializable {

    // counters for use within the restaurant for loops
    private int restaurantCounter = 0;
    private int restaurantNum = 1;

    // label used to display the temperature
    @FXML
    private Label cityTemp;

    // label used to display the weather description
    @FXML
    private Label weatherDescription;

    // label used to display partner ones name
    @FXML
    private Label partnerOneNameLabel;

    // label used to display partner twos name
    @FXML
    private Label partnerTwoNameLabel;

    // text area used to append restaurant data for partner one
    @FXML
    private TextArea partnerOneTextArea;

    // text area used to append restaurant data for partner two
    @FXML
    private TextArea partnerTwoTextArea;

    /**
     * Starts the program over
     *
     * @param _event
     * @throws java.lang.Exception
     */
    public void changeToHomeScreen(ActionEvent _event) throws Exception {

        System.out.println("Starting over...");

        //new FXML loader and scene for new screen
        Parent root = FXMLLoader.load(getClass().getResource("/Views/HomeScene.fxml"));
        Scene HomeScene = new Scene(root);

        //Get information from primary stage
        Stage appStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        appStage.setScene(HomeScene);
        appStage.show();
    }

    /**
     * Quits the program when the quit button is pressed
     */
    public void quitButtonPressed() {
        System.exit(0);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // N/A
    }

    //======================== SETTERS ========================
    /**
     * Sets the temperature
     *
     * @param _temperature
     */
    public void setTemperatureLabel(String _temperature) {
        this.cityTemp.setText(_temperature);
    }

    /**
     * Sets the weather description
     *
     * @param _weatherDesc
     */
    public void setWeatherDescription(String _weatherDesc) {
        this.weatherDescription.setText(_weatherDesc);
    }

    /**
     * Sets partner 1 name
     *
     * @param _name
     */
    public void setPartnerOneName(String _name) {
        this.partnerOneNameLabel.setText(_name);
    }

    /**
     * Sets partner 2 name
     *
     * @param _name
     */
    public void setPartnerTwoName(String _name) {
        this.partnerTwoNameLabel.setText(_name);
    }

    /**
     * Fills the text area with the restaurant info for partner 1
     *
     * @param _restaurants
     */
    public void setPartnerOneRestaurants(String[] _restaurants) {

        // iterates through the restaurants to output each one and its information
        for (int i = 0; i < _restaurants.length; i++) {
            // Base case where it appends 1)----------------
            if (i == 0) {
                this.partnerOneTextArea.appendText(restaurantNum + ")------------------------------- \n");
                restaurantNum++;
            } // case that appends the restaurant number the for loop is on and resets the restaurant counter
            else if (restaurantCounter == apis.FoodAPI.numberOfValuesForEachRestaurant) {
                restaurantCounter = 0;
                this.partnerOneTextArea.appendText(restaurantNum + ")------------------------------- \n");
                restaurantNum++;
            }
            // appending the information to the text area
            this.partnerOneTextArea.appendText(_restaurants[i] + "\n");
            restaurantCounter++;
        }
        // Resetting the restaurant counter and num to allow for multiple uses
        restaurantCounter = 0;
        restaurantNum = 1;
    }

    /**
     * Fills the text area with the restaurant info for partner 2
     *
     * @param _restaurants
     */
    public void setPartnerTwoRestaurants(String[] _restaurants) {

        // iterates through the restaurants to output each one and its information
        for (int i = 0; i < _restaurants.length; i++) {

            // Base case where it appends 1)----------------
            if (i == 0) {
                this.partnerTwoTextArea.appendText(restaurantNum + ")------------------------------- \n");
                restaurantNum++;
            } // case that appends the restaurant number the for loop is on and resets the restaurant counter
            else if (restaurantCounter == apis.FoodAPI.numberOfValuesForEachRestaurant) {
                restaurantCounter = 0;
                this.partnerTwoTextArea.appendText(restaurantNum + ")------------------------------- \n");
                restaurantNum++;
            }
            // appending the information to the text area
            this.partnerTwoTextArea.appendText(_restaurants[i] + "\n");
            restaurantCounter++;
        }
        // Resetting the restaurant counter and num to allow for multiple uses
        restaurantCounter = 0;
        restaurantNum = 1;
    }
}
