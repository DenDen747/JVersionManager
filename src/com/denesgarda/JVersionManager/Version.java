package com.denesgarda.JVersionManager;

public class Version {
    public static Version VERSION = new Version("1.0");

    private int[] version;

    public Version(String version) {
        setVersion(version);
    }

    public Version(int[] version) {
        this.version = version;
    }

    public void setVersion(String version) {
        String[] split = version.split("\\.");
        this.version = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            this.version[i] = Integer.parseInt(split[i]);
        }
    }

    public void setVersion(int[] version) {
        this.version = version;
    }

    public int[] getVersion() {
        return version;
    }

    @Override
    public String toString() {
        StringBuilder version = new StringBuilder();
        for (int digit : this.version) {
            version.append(digit).append(".");
        }
        return version.substring(0, version.length() - 1);
    }
}
