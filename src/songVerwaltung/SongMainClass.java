package songVerwaltung;

import java.awt.EventQueue;

public class SongMainClass {

    public static void main(String[] agrs) {
        // Erstelle das erste Songs Objekt
        Song.songListe.add(new Song());

        System.out.println("First song added");

        // Aktiviere das GUI
        EventQueue.invokeLater(() -> {
            try {
                SongGUI frame = new SongGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("GUI started");
    }

}
