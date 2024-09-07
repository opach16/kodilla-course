package com.kodilla.patterns.singleton;

public enum SettingsFileEngine {
    INSTANCE;

    private String fileName = "";

    public String getFileName() {
        return fileName;
    }

    public void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the settigns file");

    }

    public void close() {
        this.fileName = "";
        System.out.println("Closing the settings file");
    }

    public boolean loadSettings() {
        System.out.println("Load settings from file");
        return true;
    }

    public boolean saveSettings() {
        System.out.println("Save settings to file");
        return true;
    }
}
