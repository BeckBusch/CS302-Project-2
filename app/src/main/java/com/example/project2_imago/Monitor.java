package com.example.project2_imago;

abstract class Monitor {
    String name;
    boolean isBestselling;
    int viewCount;

    int screenSize, price;
    String aspectRatio, brand;

    public void Monitor(String name, boolean isBestselling, int viewCount,
                        int screenSize, int price, String aspectRatio, String brand) {
        this.name = name;
        this.isBestselling = isBestselling;
        this.viewCount = viewCount;
        this.screenSize = screenSize;
        this.price = price;
        this.aspectRatio = aspectRatio;
        this.brand = brand;
    }

    String getName() {
        return name;
    }

    boolean getBestselling() {
        return isBestselling;
    }

    int getViewCount() {
        return viewCount;
    }

    int getScreenSize() {
        return screenSize;
    }

    int getPrice() {
        return price;
    }

    String getAspectRatio() {
        return aspectRatio;
    }

    String getBrand() {
        return brand;
    }
}

class GamingMonitor extends Monitor {
    int responseTime, refreshRate;
    String resolution;
    boolean isCurved;

    GamingMonitor(String name, boolean isBestselling, int viewCount,
                  int price, String brand, int screenSize, String aspectRatio,
                  String resolution, int responseTime, int refreshRate, boolean isCurved) {
        Monitor(name, isBestselling, viewCount, screenSize, price, aspectRatio, brand);
        this.resolution = resolution;
        this.responseTime = responseTime;
        this.refreshRate = refreshRate;
        this.isCurved = isCurved;
    }

    public String getResolution() {
        return resolution;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public boolean getIsCurved() {
        return isCurved;
    }
}

class DesignMonitor extends Monitor {
    String resolution;
    String panelType;

    DesignMonitor(String name, boolean isBestselling, int viewCount,
                  int price, String brand, int screenSize, String aspectRatio,
                  String resolution, String panelType) {
        Monitor(name, isBestselling, viewCount, screenSize, price, aspectRatio, brand);
        this.panelType = panelType;
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public String getPanelType() {
        return panelType;
    }
}

class BusinessMonitor extends Monitor {
    int vesaSize;
    boolean isTouchscreen;

    BusinessMonitor(String name, boolean isBestselling, int viewCount,
                    int price, String brand, int screenSize, String aspectRatio,
                    int vesaSize, boolean isTouchscreen) {
        Monitor(name, isBestselling, viewCount, screenSize, price, aspectRatio, brand);
        this.vesaSize = vesaSize;
        this.isTouchscreen = isTouchscreen;
    }

    public int getVesaSize() {
        return vesaSize;
    }

    public boolean isTouchscreen() {
        return isTouchscreen;
    }
}