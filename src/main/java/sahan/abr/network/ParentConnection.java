package sahan.abr.network;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.json.JSONArray;
import org.json.JSONObject;
import sahan.abr.entities.Employee;
import sahan.abr.entities.Parent;

import java.io.IOException;
import java.util.ArrayList;

import static sahan.abr.Main.urlAddress;

public class ParentConnection {

    public void getAllParents(ArrayList<Parent> parentsArrayList){

        try {

            Content getResult = Request.Post(urlAddress + "/parents/get_all")
                    .execute().returnContent();

            JSONArray jsonArray = new JSONArray(getResult.asString());

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject json = jsonArray.getJSONObject(i);

                int id = json.getInt("id");
                String surname = json.getString("surname");
                String name = json.getString("name");
                String middleName = json.getString("middleName");
                String phoneNumber = json.getString("phoneNumber");
                String contactPhoneNumber = json.getString("contactPhoneNumber");

                String passportSeries = json.getString("passportSeries");
                String passportID = json.getString("passportID");
                String passportIssuedBy = json.getString("passportIssuedBy");
                String passportIssueDate = json.getString("passportIssueDate");
                String unitCode = json.getString("unitCode");

                String dateContract = json.getString("dateContract");
                String contractNumber = json.getString("contractNumber");

                String childrenId = json.getString("childrenId");

                parentsArrayList.add(new Parent(id, surname, name, middleName, phoneNumber, contactPhoneNumber, passportSeries,
                        passportID, passportIssuedBy, passportIssueDate, unitCode, dateContract, contractNumber, childrenId));

                System.out.println(json);
            }

        } catch (IOException exception) {
            System.out.println("ERROR : " + exception.getMessage());
        }
    }

}
