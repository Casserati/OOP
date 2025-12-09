package hslu.oop.sw12.javafxintro;

import hslu.oop.sw12.javafxintro.dao.PersonDao;
import hslu.oop.sw12.javafxintro.dto.PersonDto;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class HelloController {
    private static PersonDao personDao = new PersonDao(Persistence.createEntityManagerFactory("default"));


    @FXML
    private TextField idText;
    @FXML
    private TextField lastnameText;
    @FXML
    private TextField firstnameText;
    @FXML
    private DatePicker birthDateText;

    @FXML
    protected void onCreateButtonClick() {
        PersonDto personDto = new PersonDto(
                Long.parseLong(idText.getText()),
                firstnameText.getText(),
                lastnameText.getText(),
                birthDateText.getValue());

        personDao.createPerson(personDto);
        System.out.println("test");
    }
}
