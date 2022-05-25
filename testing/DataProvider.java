package testing;

import java.util.ArrayList;
import java.util.RandomAccess;

public class DataProvider {
    ArrayList<Monitor> MonitorData = new ArrayList<Monitor>();

    public void DataProvider() {
        MonitorData.add(new GamingMonitor("Vital Strats 120", false, 0, 592, "AOC", 24, "16:9", "1920x1080", 8, 120, false));
        MonitorData.add(new GamingMonitor("Edge Gaming 27Z", false, 0, 978, "AOC", 27, "16:9", "1920x1080", 1, 144, false));
        MonitorData.add(new GamingMonitor("UltraGear27", false, 0, 966, "AOC", 27, "16:9", "1920x1080", 1, 144, false));
        MonitorData.add(new GamingMonitor("UltraGear34", false, 0, 1369, "AOC", 34, "16:9", "1920x1080", 1, 144, true));
        MonitorData.add(new GamingMonitor("SlimPro24", false, 0, 430, "Titan Army", 24, "16:9", "1920x1080", 5, 120, false));
        MonitorData.add(new GamingMonitor("Edge Gaming 27S", false, 0, 826, "AOC", 27, "16:9", "1920x1080", 1, 144, false));
        MonitorData.add(new GamingMonitor("Samsung Odyssey", false, 0, 1508, "Samsung", 34, "16:9", "2560x1440", 1, 144, true));
        MonitorData.add(new GamingMonitor("Adventure Gamer 9", false, 0, 1437, "Samsung", 34, "16:9", "2560x1440", 1, 144, false));
        MonitorData.add(new GamingMonitor("Vital Strats 144", false, 0, 593, "AOC", 24, "16:9", "1920x1080", 1, 144, false));
        MonitorData.add(new GamingMonitor("TUF VG24", false, 0, 404, "Titan Army", 24, "16:9", "1920x1080", 8, 120, false));

        MonitorData.add(new DesignMonitor("LG Technik", false, 0, 1170, "LG", 27, "16:9", "3840x2160", "IPS"));
        MonitorData.add(new DesignMonitor("ASUS Revolution Mini", false, 0, 1138, "ASUS", 27, "16:9", "1920x1080", "VA"));
        MonitorData.add(new DesignMonitor("ASUS Designer", false, 0, 1286, "ASUS", 27, "16:9", "3840x2160", "IPS"));
        MonitorData.add(new DesignMonitor("LG Technik Pro", false, 0, 1807, "LG", 34, "16:9", "1920x1080", "IPS"));
        MonitorData.add(new DesignMonitor("ASUS L96 Create", false, 0, 1176, "ASUS", 27, "21:9", "3440x1440", "IPS"));
        MonitorData.add(new DesignMonitor("ASUS L100 Create+", false, 0, 1786, "ASUS", 27, "21:9", "5120x2160", "IPS"));
        MonitorData.add(new DesignMonitor("LG Pro Workstation", false, 0, 1517, "LG", 27, "21:9", "5120x2160", "IPS"));
        MonitorData.add(new DesignMonitor("ASUS Revolution", false, 0, 1883, "ASUS", 34, "21:9", "5120x2160", "IPS"));
        MonitorData.add(new DesignMonitor("LG Mini Designer", false, 0, 852, "LG", 27, "21:9", "3440x1440", "VA"));
        MonitorData.add(new DesignMonitor("ASUS Designer Mega", false, 0, 2233, "ASUS", 34, "21:9", "5120x2160", "IPS"));

        MonitorData.add(new BusinessMonitor("Dell", false, 0, 241, "Dell", 24, "16:9", 100, false));
        MonitorData.add(new BusinessMonitor("LG Ultrafine 24", false, 0, 824, "LG", 24, "16:9", 100, true));
        MonitorData.add(new BusinessMonitor("Dell Super Optic", false, 0, 645, "Dell", 24, "16:9", 120, true));
        MonitorData.add(new BusinessMonitor("LG Ultrafine 27", false, 0, 663, "LG", 27, "16:9", 100, true));
        MonitorData.add(new BusinessMonitor("Dell Super Optic 27", false, 0, 619, "Dell", 27, "16:9", 120, false));
        MonitorData.add(new BusinessMonitor("Dell SuperFine27", false, 0, 283, "Dell", 27, "16:9", 100, false));
        MonitorData.add(new BusinessMonitor("LG Micro", false, 0, 211, "Dell", 24, "5:4", 100, false));
        MonitorData.add(new BusinessMonitor("LG Mini", false, 0, 233, "Dell", 24, "5:4", 120, false));
        MonitorData.add(new BusinessMonitor("Dell SuperFine24", false, 0, 436, "Dell", 24, "5:4", 100, false));
        MonitorData.add(new BusinessMonitor("LG Macro 24", false, 0, 866, "LG", 24, "5:4", 100, true));
    }
    public ArrayList<Monitor> returnCategory(String category) {
        ArrayList<Monitor> TempResults = new ArrayList<Monitor>();

        switch (category){
            case "Gaming":
                for (Monitor temp : MonitorData){
                    if (temp instanceof GamingMonitor) {
                        TempResults.add((GamingMonitor) temp);
                    }
                }
                return TempResults;

            case "Business":
                for (Monitor temp : MonitorData){
                    if (temp instanceof BusinessMonitor) {
                        TempResults.add(temp);
                    }
                }
                return TempResults;

            case "Design":
                for (Monitor temp : MonitorData){
                    if (temp instanceof DesignMonitor) {
                        TempResults.add(temp);
                    }
                }
                return TempResults;

            default:
                return null;
        }
    }

    public ArrayList<Monitor> returnAll() {
        return MonitorData;
    }
}
