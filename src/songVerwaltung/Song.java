package songVerwaltung;

import java.util.ArrayList;

class Song {

    static int index = 0;

    static ArrayList<Song> songListe = new ArrayList<>();

    private String titel, interpret, album, dauer, label, source, version, originalInterpret;

    // Konstruktor
    Song() {
        titel = "";
        interpret = "";
        album = "";
        dauer = "";
        label = "";
        source = "";
        version = "";
        originalInterpret = "";
    }

    String getTitel() {
        return titel;
    }



    void setTitel(String titel) {
        this.titel = titel;
    }



    String getInterpret() {
        return interpret;
    }



    void setInterpret(String interpret) {
        this.interpret = interpret;
    }



    String getAlbum() {
        return album;
    }



    void setAlbum(String album) {
        this.album = album;
    }



    String getDauer() {
        return dauer;
    }



    void setDauer(String dauer) {
        this.dauer = dauer;
    }



    String getLabel() {
        return label;
    }



    void setLabel(String label) {
        this.label = label;
    }



    String getSource() {
        return source;
    }



    void setSource(String source) {
        this.source = source;
    }



    String getVersion() {
        return version;
    }



    void setVersion(String version) {
        this.version = version;
    }



    String getOriginalInterpret() {
        return originalInterpret;
    }



    void setOriginalInterpret(String originalInterpret) {
        this.originalInterpret = originalInterpret;
    }

    // Check ob alle Felder leer sind
    boolean istLeer() {
        return titel.equals("") && interpret.equals("") && album.equals("") && label.equals("") && dauer.equals("") && originalInterpret.equals("") && version.equals("") && source.equals("");
    }
}
