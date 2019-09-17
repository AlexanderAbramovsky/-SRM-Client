package sahan.abr.network;

import javafx.collections.ObservableList;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import sahan.abr.entities.Employee;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

import static sahan.abr.Main.urlAddress;


public class ClientConnection {

    public void updateEmployee(Employee employee){
        try {
            Collection<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("id", ""+employee.getId()));
            params.add(new BasicNameValuePair("fio", employee.getFio()));
            params.add(new BasicNameValuePair("position", employee.getPosition()));
            params.add(new BasicNameValuePair("phoneNumber", employee.getPhoneNumber()));

            Content postResultForm = Request.Post(urlAddress + "/update_employee")
                    .bodyForm(params, Charset.defaultCharset())
                    .execute().returnContent();

        } catch (IOException exception) {
            System.out.println("ERROR : " + exception.getMessage());
        }
    }

    public void getEmployees(ObservableList<Employee> dataEmployeesTable){

        try {
            Content getResult = Request.Post(urlAddress + "/get_all_employees")
                    .execute().returnContent();

            JSONArray jsonArray = new JSONArray(getResult.asString());

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject json = jsonArray.getJSONObject(i);

                int id = json.getInt("id");
                String fio = json.getString("fio");
                String position = json.getString("position");
                String phoneNumber = json.getString("phoneNumber");

                dataEmployeesTable.add(new Employee(id, fio, position, phoneNumber));

                System.out.println(json);
            }

        } catch (IOException exception) {
            System.out.println("ERROR : " + exception.getMessage());
        }


    }

    public void removeEmployee(int id){
        try {
            Collection<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("id", ""+id));

            Content postResultForm = Request.Post(urlAddress + "/remove_employee")
                    .bodyForm(params, Charset.defaultCharset())
                    .execute().returnContent();

        } catch (IOException exception) {
            System.out.println("ERROR : " + exception.getMessage());
        }
    }

    public Employee addEmployee(String fio, String position, String phoneNumber){

        Employee employee = null;

        try {
            Collection<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("fio", fio));
            params.add(new BasicNameValuePair("position", position));
            params.add(new BasicNameValuePair("phoneNumber", phoneNumber));

            Content postResultForm = Request.Post(urlAddress + "/add_employee")
                    .bodyForm(params, Charset.defaultCharset())
                    .execute().returnContent();

            // Получаем ответ и вытаскиваем id нового сотрудника
            JSONObject json = new JSONObject(postResultForm.asString());
            int id = json.getInt("id");
            employee = new Employee(id, fio, position, phoneNumber);

            return employee;

        } catch (IOException exception) {
            System.out.println("ERROR : " + exception.getMessage());
        }

        return employee;
    }
}
