package sahan.abr.entities;

import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Client {
    private Parent parent;
    private ArrayList<Child> children;
    private VBox vBoxClient;

    public Client() {
    }

    public Client(Parent parent) {
        this.parent = parent;
    }

    public Client(Parent parent, ArrayList<Child> children) {
        this.parent = parent;
        this.children = children;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }

    public VBox getvBoxClient() {
        return vBoxClient;
    }

    public void setvBoxClient(VBox vBoxClient) {
        this.vBoxClient = vBoxClient;
    }

    public void addvBoxChildren(VBox vBox){
        vBoxClient.getChildren().add(vBox);
    }
}

