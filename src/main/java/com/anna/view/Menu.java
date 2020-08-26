package com.anna.view;

public interface Menu {

    void show();

    void exit();

    default void incorrectInput() {
        System.out.println("Incorrect input please try again");
        show();
    }

    default void showButtons(String[] items) {
        String string = String.join(" ", items);
        System.out.print(string + "\nMake your choice: ");
    }
}
