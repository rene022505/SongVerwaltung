package songVerwaltung;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
class SongGUI extends JFrame {

    private JTextField txtTitel;
    private JTextField txtInterpret;
    private JTextField txtAlbum;
    private JTextField txtLabel;
    private JTextField textTitel;
    private JTextField textInterpret;
    private JTextField textAlbum;
    private JTextField textLabel;
    private JTextField textDauer;
    private JTextField textOriginalInterpret;
    private JTextField textVersion;
    private JTextField textSource;
    private JTextField txtDauer;
    private JTextField txtOriginalInterpret;
    private JTextField txtVersion;
    private JTextField txtSource;
    private JButton buttonRemove;

    /**
     *  Custom Methods
     */

    // Ändert die Sichtbarkeit des Label(Titel/Interpret/...) je nachdem ob etwas eingetragen wurde oder nicht
    private void changeLabel(JTextField label, JTextField text) {
        if(text.getText().equals("")) {
            label.setEnabled(false);
        } else {
            label.setEnabled(true);
        }
    }

    // Aktualisiert die ProgressBar
    private void updateProgressBar(JProgressBar progressBar) {
        progressBar.setMaximum(Song.songListe.size());
        progressBar.setValue(Song.index + 1);
        progressBar.setString((Song.index + 1) + " / " + Song.songListe.size());
        progressBar.setForeground(Color.magenta);
    }

    // Setzt die Werte in die Textfelder sollte ein Objekt bereits Werte beinhalten
    //Verwendungszweck: Blättern zu vorherigen oder kommenden Songs
    private void setWerte(int index) {
        textTitel.setText(Song.songListe.get(index).getTitel());
        textInterpret.setText(Song.songListe.get(index).getInterpret());
        textAlbum.setText(Song.songListe.get(index).getAlbum());
        textLabel.setText(Song.songListe.get(index).getLabel());
        textDauer.setText(Song.songListe.get(index).getDauer());
        textOriginalInterpret.setText(Song.songListe.get(index).getOriginalInterpret());
        textVersion.setText(Song.songListe.get(index).getVersion());
        textSource.setText(Song.songListe.get(index).getSource());
    }

    // Leert alle Textfelder
    // Verwendungszweck: Beim erstellen eines neuen Songs sollten alle Felder leer sein
    private void clear() {
        textTitel.setText("");
        textInterpret.setText("");
        textAlbum.setText("");
        textLabel.setText("");
        textDauer.setText("");
        textOriginalInterpret.setText("");
        textVersion.setText("");
        textSource.setText("");
    }

    /**
     * Create the frame.
     */
    SongGUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 376);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtTitel = new JTextField();
        txtTitel.setEnabled(false);
        txtTitel.setEditable(false);
        txtTitel.setText("Titel");
        txtTitel.setBounds(12, 13, 116, 22);
        contentPane.add(txtTitel);
        txtTitel.setColumns(10);

        txtInterpret = new JTextField();
        txtInterpret.setEnabled(false);
        txtInterpret.setEditable(false);
        txtInterpret.setText("Interpret");
        txtInterpret.setColumns(10);
        txtInterpret.setBounds(12, 48, 116, 22);
        contentPane.add(txtInterpret);

        txtAlbum = new JTextField();
        txtAlbum.setEnabled(false);
        txtAlbum.setText("Album");
        txtAlbum.setEditable(false);
        txtAlbum.setColumns(10);
        txtAlbum.setBounds(12, 83, 116, 22);
        contentPane.add(txtAlbum);

        txtLabel = new JTextField();
        txtLabel.setEnabled(false);
        txtLabel.setText("Label");
        txtLabel.setEditable(false);
        txtLabel.setColumns(10);
        txtLabel.setBounds(12, 118, 116, 22);
        contentPane.add(txtLabel);

        // Knopf um neue Songs hinzuzufügen
        JButton buttonAdd = new JButton("add");

        textTitel = new JTextField();
        textTitel.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtTitel, textTitel);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setTitel(textTitel.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtTitel, textTitel);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setTitel(textTitel.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textTitel.setBounds(140, 13, 293, 22);
        contentPane.add(textTitel);
        textTitel.setColumns(10);

        textInterpret = new JTextField();
        textInterpret.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtInterpret, textInterpret);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setInterpret(textInterpret.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtInterpret, textInterpret);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setInterpret(textInterpret.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textInterpret.setColumns(10);
        textInterpret.setBounds(140, 48, 293, 22);
        contentPane.add(textInterpret);

        textAlbum = new JTextField();
        textAlbum.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtAlbum, textAlbum);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setAlbum(textAlbum.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtAlbum, textAlbum);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setAlbum(textAlbum.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textAlbum.setColumns(10);
        textAlbum.setBounds(140, 83, 293, 22);
        contentPane.add(textAlbum);

        textLabel = new JTextField();
        textLabel.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtLabel, textLabel);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setLabel(textLabel.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtLabel, textLabel);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setLabel(textLabel.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textLabel.setColumns(10);
        textLabel.setBounds(140, 118, 293, 22);
        contentPane.add(textLabel);

        textDauer = new JTextField();
        textDauer.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtDauer, textDauer);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setDauer(textDauer.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtDauer, textDauer);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setDauer(textDauer.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textDauer.setColumns(10);
        textDauer.setBounds(140, 153, 293, 22);
        contentPane.add(textDauer);

        textOriginalInterpret = new JTextField();
        textOriginalInterpret.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtOriginalInterpret, textOriginalInterpret);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setOriginalInterpret(textOriginalInterpret.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtOriginalInterpret, textOriginalInterpret);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setOriginalInterpret(textOriginalInterpret.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textOriginalInterpret.setColumns(10);
        textOriginalInterpret.setBounds(140, 188, 293, 22);
        contentPane.add(textOriginalInterpret);

        textVersion = new JTextField();
        textVersion.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtVersion, textVersion);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setVersion(textVersion.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtVersion, textVersion);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setVersion(textVersion.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textVersion.setColumns(10);
        textVersion.setBounds(140, 223, 293, 22);
        contentPane.add(textVersion);

        textSource = new JTextField();
        textSource.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeLabel(txtSource, textSource);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setSource(textSource.getText());
                if(Song.songListe.get(Song.index).istLeer()) {
                    buttonAdd.setEnabled(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changeLabel(txtSource, textSource);

                // Überschreibt die Variable des Objekts mit der aktuellen Eingabe
                Song.songListe.get(Song.index).setSource(textSource.getText());
                buttonAdd.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        textSource.setColumns(10);
        textSource.setBounds(140, 258, 293, 22);
        contentPane.add(textSource);

        txtDauer = new JTextField();
        txtDauer.setEnabled(false);
        txtDauer.setText("Dauer");
        txtDauer.setEditable(false);
        txtDauer.setColumns(10);
        txtDauer.setBounds(12, 153, 116, 22);
        contentPane.add(txtDauer);

        txtOriginalInterpret = new JTextField();
        txtOriginalInterpret.setEnabled(false);
        txtOriginalInterpret.setText("Original Interpret");
        txtOriginalInterpret.setEditable(false);
        txtOriginalInterpret.setColumns(10);
        txtOriginalInterpret.setBounds(12, 188, 116, 22);
        contentPane.add(txtOriginalInterpret);

        txtVersion = new JTextField();
        txtVersion.setEnabled(false);
        txtVersion.setText("Version");
        txtVersion.setEditable(false);
        txtVersion.setColumns(10);
        txtVersion.setBounds(12, 223, 116, 22);
        contentPane.add(txtVersion);

        txtSource = new JTextField();
        txtSource.setEnabled(false);
        txtSource.setText("Source");
        txtSource.setEditable(false);
        txtSource.setColumns(10);
        txtSource.setBounds(12, 258, 116, 22);
        contentPane.add(txtSource);

        JButton buttonBefore = new JButton("<");
        JButton buttonFirst = new JButton("<<");
        JButton buttonLast = new JButton(">>");
        JButton buttonNext = new JButton(">");

        JProgressBar progressBar = new JProgressBar(0, 1);

        // Aktiviert die Option Text anzuzeigen
        progressBar.setStringPainted(true);
        progressBar.setString("1 / 1");

        // Knöpfe standardmäßig deaktivieren da es beim starten nur einen Song gibt
        buttonBefore.setEnabled(false);
        buttonFirst.setEnabled(false);
        buttonLast.setEnabled(false);
        buttonNext.setEnabled(false);

        // Zurückknopf Logik
        buttonBefore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(buttonBefore.isEnabled()) { // Mache nur etwas wenn du aktiviert bist
                    Song.index -= 1; // Verringere den Index um 1
                    setWerte(Song.index);

                    // Wenn man den Song wechseln will aber der aktuelle Song noch leer ist
                    if(Song.songListe.get(Song.index + 1).istLeer()) {
                        Song.songListe.remove(Song.index + 1);
                    }

                    if(Song.index == 0 && Song.songListe.size() != 1) { // Wenn der Index 0 ist deaktiviere Zurück/Erster und aktiviere Letzter
                        buttonBefore.setEnabled(false);
                        buttonFirst.setEnabled(false);
                        buttonLast.setEnabled(true);
                        buttonNext.setEnabled(true);
                    } else if(Song.index != 0 && Song.songListe.size() != 1){ // Ansonsten aktiviere nur Letzter
                        buttonLast.setEnabled(true);
                        buttonNext.setEnabled(true);
                    } else {
                        buttonBefore.setEnabled(false);
                        buttonFirst.setEnabled(false);
                        buttonLast.setEnabled(false);
                        buttonNext.setEnabled(false);
                    }

                    // Verändert den maximalen Wert, setzt den neuen Wert und ändert den Text dementsprechend
                    updateProgressBar(progressBar);
                }
            }
        });
        buttonBefore.setBounds(175, 293, 41, 22);

        contentPane.add(buttonBefore);

        // Erster-Knopf standardmäßig deaktivieren da es beim starten nur einen Song gibt

        buttonFirst.setEnabled(false);

        // Erster-Knopf logik
        buttonFirst.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(buttonFirst.isEnabled()) { // Mache nur etwas wenn du aktiviert bist
                    int prevIndex = Song.index;
                    Song.index = 0; // Setze den Index auf 0
                    buttonBefore.setEnabled(false);
                    buttonFirst.setEnabled(false);

                    // Wenn man den Song wechseln will aber der aktuelle Song noch leer ist
                    if(Song.songListe.get(prevIndex).istLeer()) {
                        Song.songListe.remove(prevIndex);
                    }

                    if(Song.songListe.size() == 1) {
                        buttonLast.setEnabled(false);
                        buttonNext.setEnabled(false);
                    } else {
                        buttonLast.setEnabled(true);
                        buttonNext.setEnabled(true);
                    }

                    setWerte(Song.index); // Lade die Werte des ertsen Soongs

                    // Verändert den maximalen Wert, setzt den neuen Wert und ändert den Text dementsprechend
                    updateProgressBar(progressBar);
                }
            }
        });
        buttonFirst.setBounds(111, 293, 51, 22);
        contentPane.add(buttonFirst);

        buttonLast.setEnabled(false);
        buttonLast.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(buttonLast.isEnabled()) { // Mache nur etwas wenn du aktiviert bist
                    int prevIndex = Song.index;
                    Song.index = Song.songListe.size() - 1; // Setze den Index auf den letzen Song
                    buttonBefore.setEnabled(true); // Passe die Knöpfe an das sie Sinn machen
                    buttonFirst.setEnabled(true);
                    buttonLast.setEnabled(false);
                    buttonNext.setEnabled(false);
                    setWerte(Song.songListe.size() - 1); // Lade die Werte des letzten Songs

                    // Wenn man den Song wechseln will aber der aktuelle Song noch leer ist
                    if(Song.songListe.get(prevIndex).istLeer()) {
                        Song.songListe.remove(prevIndex);
                        Song.index -= 1;
                    }

                    // Verändert den maximalen Wert, setzt den neuen Wert und ändert den Text dementsprechend
                    updateProgressBar(progressBar);
                }
            }
        });
        buttonLast.setBounds(283, 293, 51, 22);
        contentPane.add(buttonLast);

        // Vor-Knopf Logik
        buttonNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(buttonNext.isEnabled()) {
                    Song.index += 1; // Erhöhe den Index um 1
                    buttonBefore.setEnabled(true);
                    buttonFirst.setEnabled(true);

                    // Wenn der nächste Song nicht der letzte ist, lade in
                    if(Song.songListe.size() - 1 > Song.index) {
                        setWerte(Song.index);

                        // Wenn der nächste Song der letzte ist, lade in UND deaktiviere Letzter
                    } else if(Song.index == Song.songListe.size() - 1 ){
                        setWerte(Song.index);
                        buttonLast.setEnabled(false);
                        buttonNext.setEnabled(false);
                    }

                    // Wenn man den Song wechseln will aber der aktuelle Song noch leer ist
                    if(Song.songListe.get(Song.index - 1).istLeer()) {
                        Song.songListe.remove(Song.index - 1);
                        Song.index -= 1;
                    }

                    // Verändert den maximalen Wert, setzt den neuen Wert und ändert den Text dementsprechend
                    updateProgressBar(progressBar);
                }
            }
        });
        buttonNext.setBounds(229, 293, 41, 22);
        contentPane.add(buttonNext);

        progressBar.setBounds(111, 319, 223, 21);
        contentPane.add(progressBar);

        JButton buttonShowList = new JButton("Show all");
        buttonShowList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(1687254762);
            }
        });
        buttonShowList.setBounds(341, 293, 92, 47);
        contentPane.add(buttonShowList);

        buttonAdd.setEnabled(false);
        buttonAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(buttonAdd.isEnabled()) {
                    // Erstelle einen neuen Song und leere alle Felder
                    Song.index++;
                    Song.songListe.add(Song.index, new Song());
                    buttonFirst.setEnabled(true);
                    buttonBefore.setEnabled(true);
                    if(Song.index != Song.songListe.size() - 1) {
                        buttonNext.setEnabled(true);
                        buttonLast.setEnabled(true);
                    } else {
                        buttonNext.setEnabled(false);
                        buttonLast.setEnabled(false);
                    }
                    clear();

                    // Aktiviere den Löschen-Knopf
                    buttonRemove.setEnabled(true);

                    // Verändert den maximalen Wert, setzt den neuen Wert und ändert den Text dementsprechend
                    updateProgressBar(progressBar);

                    buttonAdd.setEnabled(false);
                }
            }
        });
        buttonAdd.setBounds(12, 293, 92, 22);
        contentPane.add(buttonAdd);

        buttonRemove = new JButton("remove");
        buttonRemove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(buttonRemove.isEnabled()) { // Logik des Knopfes
                    if(Song.songListe.size() - 1 == Song.index) {
                        buttonNext.setEnabled(false);
                        buttonLast.setEnabled(false);
                        Song.songListe.remove(Song.index);
                        Song.index -= 1;
                        setWerte(Song.index);
                    } else if (Song.index == 0){
                        buttonBefore.setEnabled(false);
                        buttonFirst.setEnabled(false);
                        Song.songListe.remove(Song.index);
                        setWerte(Song.index);
                    } else {
                        Song.songListe.remove(Song.index);
                        setWerte(Song.index);

                        if(Song.songListe.size() - 1 == Song.index) {
                            buttonNext.setEnabled(false);
                            buttonLast.setEnabled(false);
                        }
                    }

                    // Verändert den maximalen Wert, setzt den neuen Wert und ändert den Text dementsprechend
                    updateProgressBar(progressBar);

                    // Wenn nur noch ein Song übrig deaktiviere den Knopf
                    if(Song.songListe.size() == 1) {
                        buttonRemove.setEnabled(false);
                        buttonAdd.setEnabled(true);
                        buttonBefore.setEnabled(false);
                        buttonFirst.setEnabled(false);
                        buttonLast.setEnabled(false);
                        buttonNext.setEnabled(false);
                    }
                }
            }
        });
        buttonRemove.setEnabled(false);
        buttonRemove.setBounds(12, 319, 92, 22);
        contentPane.add(buttonRemove);
    }
}
