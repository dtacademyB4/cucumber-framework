package stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class DataTableDemoStepDefs {

    @Then("The result should contain this information")
    public void the_result_should_contain_this_information(List<String> dataTable) {
        System.out.println(dataTable);
    }



    @Given("The precondition is satisfied")
    public void the_precondition_is_satisfied() {


    }

    @When("The action is done")
    public void the_action_is_done() {

    }

    @Then("The result should contain this information as")
    public void the_result_should_contain_this_information_as(List<List<String>> dataTable) {
        System.out.println(dataTable);
        for (List<String> row : dataTable) {
            System.out.println(row);
        }
    }

}
