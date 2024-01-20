import Utilities.ReusableMethods;

import java.awt.MouseInfo;
import java.awt.PointerInfo;

public class EkranKoordinatlari {
    public static void main(String[] args) {
        ReusableMethods.wait(5);
        // MouseInfo sınıfını kullanarak fare pozisyonunu al
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        java.awt.Point point = pointerInfo.getLocation();

        // X ve Y koordinatlarını yazdır
        System.out.println("X Koordinatı: " + (int) point.getX());
        System.out.println("Y Koordinatı: " + (int) point.getY());
    }
}