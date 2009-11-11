package dbox2;
/**
 * Preferences.java
 *
 * Created on 8. juni 2007, 16:39
 * @author Truben
 **/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class NewPreferences implements Serializable {
    
    private String DosBoxPath = "";
    private String[] Genres;
    private String LastUsedPath = "";
    private String KeyBoardCode = "us";
    private String Theme = "";
    private boolean KeepOpen = false;
    private boolean FullScreen = false;
    private boolean BuiltInDosBox = false;
    private boolean ShowIcons = true;
    private boolean FirstStart = true;
    private int IconWidth = 22;
    private int IconHeight = 22;
    private boolean IconResize = true;
    private boolean NoConcole = true;
    private int TypeOfFileDialog = 0;
    private int NumerOfColumnsInGameList = 1;

    public void setNoConcole(boolean NoConcole) {
        this.NoConcole = NoConcole;
    }

    public boolean isNoConcole() {
        return NoConcole;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String Theme) {
        this.Theme = Theme;
    }



    public boolean isBuiltInDosBox() {
        return BuiltInDosBox;
    }

    public void setBuiltInDosBox(boolean BuiltInDosBox) {
        this.BuiltInDosBox = BuiltInDosBox;
    }

    public boolean isFirstStart() {
        return FirstStart;
    }

    public void setFirstStart(boolean FirstStart) {
        this.FirstStart = FirstStart;
    }

    public void writeConfig(String filename) throws IOException {
        FileWriter fstream = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(this.toString());
        //Close the output stream
        out.close();
    }

    public String[] getGenres() {
        return Genres;
    }

    public void setGenres(String[] Genres) {
        this.Genres = Genres;
    }

    public void readConfig(String filename) {
        Scanner s = new Scanner("");
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException ex) {
            
        }
        while(s.hasNextLine()) {
            String io = s.nextLine();
            if(io.trim().startsWith("#") || io.trim().equals(""))
                continue; // Comment or blank line

            String parts[] = io.split(":=");
            parts[0] = parts[0].toLowerCase().trim();
            if(parts[0].equals("dosboxpath"))
                DosBoxPath = parts[1].trim();
            else if(parts[0].equals("iconwidth"))
                IconWidth = Integer.parseInt(parts[1].trim());
            else if(parts[0].equals("iconheight"))
                IconHeight = Integer.parseInt(parts[1].trim());
            else if(parts[0].equals("iconresize"))
                IconResize = Boolean.parseBoolean(parts[1].trim());
            else if(parts[0].equals("showicons"))
                ShowIcons = Boolean.parseBoolean(parts[1].trim());
            else if(parts[0].equals("fullscreen"))
                FullScreen = Boolean.parseBoolean(parts[1].trim());
            else if(parts[0].equals("genres"))
                stringToGenres(parts[1].trim());
            else if(parts[0].equals("keepopen"))
                KeepOpen = Boolean.parseBoolean(parts[1].trim());
            else if(parts[0].equals("typeoffiledialog"))
                TypeOfFileDialog = Integer.parseInt(parts[1].trim());
            else if(parts[0].equals("numberofcolumns"))
                NumerOfColumnsInGameList = Integer.parseInt(parts[1].trim());
            else if(parts[0].equals("lastusedpath"))
                LastUsedPath = parts[1].trim();
            else if(parts[0].equals("keyboardcode"))
                KeyBoardCode = parts[1].trim();
            else if(parts[0].equals("firststart"))
                FirstStart = Boolean.parseBoolean(parts[1].trim());
            else if(parts[0].equals("usebuiltindosbox"))
                BuiltInDosBox = Boolean.parseBoolean(parts[1].trim());
            else if(parts[0].equals("noconcole"))
                NoConcole = Boolean.parseBoolean(parts[1].trim());
            else if(parts[0].equals("theme"))
                Theme = parts[1].trim();
        }
    }

    @Override
    public String toString() {
        return       "########################################################################\n" +
                     "###                        D-Box' config file                        ###\n" +
                     "###         If it contains errors, D-Box will overwrite it!          ###\n" +
                     "### If you want to reset settings, simply delete the file or a line. ###\n" +
                     "########################################################################\n\n" +
                     "DosBoxPath       := " + DosBoxPath + "\n" +
                     "UseBuiltInDosBox := " + BuiltInDosBox + "\n" +
                     "KeepOpen         := " + KeepOpen + "\n" +
                     "FullScreen       := " + FullScreen + "\n" +
                     "ShowIcons        := " + ShowIcons + "\n" +
                     "IconWidth        := " + IconWidth + "\n" +
                     "IconHeight       := " + IconHeight + "\n" +
                     "IconResize       := " + IconResize + "\n" +
                     "Genres           := " + genresToString() + "\n" +
                     "LastUsedPath     := " + LastUsedPath + "\n" +
                     "KeyBoardCode     := " + KeyBoardCode + "\n" +
                     "FirstStart       := " + FirstStart + "\n" +
                     "Theme            := " + Theme + "\n" +
                     "NumberOfColumns  := " + NumerOfColumnsInGameList + "\n" +
                     "NoConcole        := " + NoConcole + "\n" +
                     "TypeOfFileDialog := " + TypeOfFileDialog;
    }

    private String genresToString() {
        String out = "";
        for (String string : Genres)
            out += string + ", ";
        return out.substring(0, out.length()-2);
    }

    private void stringToGenres(String s) {
        if(s.equals(""))
            return;
        else {
            String[] splitt = s.split(",");
            for (int i =0;i<splitt.length;i++)
                splitt[i] = splitt[i].trim();
            setGenres(splitt);
        }
    }

    public boolean isFullScreen() {
        return FullScreen;
    }

    public void setFullScreen(boolean FullScreen) {
        this.FullScreen = FullScreen;
    }

    public boolean isKeepOpen() {
        return KeepOpen;
    }

    public void setKeepOpen(boolean KeepOpen) {
        this.KeepOpen = KeepOpen;
    }
    
    /** Creates a new instance of Preferences */
    public NewPreferences() {
        DosBoxPath = "";
        Genres = new String[] { "Action", "Adventure", "Arcade", "Board", "Platform", "Puzzle",
                                "Racing", "RPG", "Simulation", "Sports", "Strategy", "Text Based",
                                "Utility", "Unsorted" };
    }

    public String getDosBoxPath() {
        return DosBoxPath;
    }

    public void setDosBoxPath(String DosBoxPath) {
        this.DosBoxPath = DosBoxPath;
    }

    /**
     * @return the ShowIcons
     */
    public boolean isShowIcons() {
        return ShowIcons;
    }

    /**
     * @param ShowIcons the ShowIcons to set
     */
    public void setShowIcons(boolean ShowIcons) {
        this.ShowIcons = ShowIcons;
    }

    /**
     * @return the IconWidth
     */
    public int getIconWidth() {
        return IconWidth;
    }

    /**
     * @param IconWidth the IconWidth to set
     */
    public void setIconWidth(int IconWidth) {
        this.IconWidth = IconWidth;
    }

    /**
     * @return the IconHeight
     */
    public int getIconHeight() {
        return IconHeight;
    }

    /**
     * @param IconHeight the IconHeight to set
     */
    public void setIconHeight(int IconHeight) {
        this.IconHeight = IconHeight;
    }

    /**
     * @return the IconResize
     */
    public boolean isIconResize() {
        return IconResize;
    }

    /**
     * @param IconResize the IconResize to set
     */
    public void setIconResize(boolean IconResize) {
        this.IconResize = IconResize;
    }

    /**
     * @return the TypeOfFileDialog
     */
    public int getTypeOfFileDialog() {
        return TypeOfFileDialog;
    }

    /**
     * @param TypeOfFileDialog the TypeOfFileDialog to set
     */
    public void setTypeOfFileDialog(int TypeOfFileDialog) {
        this.TypeOfFileDialog = TypeOfFileDialog;
    }

    /**
     * @return the LastUsedPath
     */
    public String getLastUsedPath() {
        return LastUsedPath;
    }

    /**
     * @param LastUsedPath the LastUsedPath to set
     */
    public void setLastUsedPath(String LastUsedPath) {
        this.LastUsedPath = LastUsedPath;
    }

    public void setKeyboardCountry(String country) {
        this.KeyBoardCode = translateLanguage(country, true);
    }
    public void setKeyboardCode(String country) {
        this.KeyBoardCode = country;
    }
    public int getKeyboardIndex() {
        String[] code    = new String[] {"be","br","cf","cz","dk","su","fr",
                                         "gr","hu","it","la","nl","no","pl",
                                         "po","sl","sp","sv","sf","sg","uk",
                                         "us","dv103","yu"};
        for(int i = 0; i < code.length; i++)
            if(code[i].toLowerCase().equals(KeyBoardCode.toLowerCase()))
                return i;
        return 0;
    }
    public String getKeyboardCountry() {
        return translateLanguage(KeyBoardCode, false);
    }
    public String getKeyboardCode() {
        return KeyBoardCode;
    }

    public void setIconSize(String s) {
        final int[]    size = {16,22,32,48};
        final String[] name = {"Small","Medium","Large", "X-Large"};

        for(int i = 0; i < size.length; i++) {
            if(name[i].equals(s)) {
                setIconHeight(size[i]);
                setIconWidth(size[i]);
                return;
            }
        }
    }
    
    public int getIconSizeIndex() {
        final int[]    size = {16,22,32,48};

        for(int i = 0; i < size.length; i++)
            if(Main.pref.getIconWidth() == size[i])
                return i;
        
        return -1;
    }



    /**
     * @param name The name of language or country
     * @param type true for from country to code, or false code to country
     * @return the right country or abbr
     */
    private String translateLanguage(String name, boolean type) {
        String[] country = new String[] { "Belgium", "Brazil", "Canadian-French", "Czech Republic", "Denmark", "Finland", "France", "Germany", "Hungary", "Italy", "Latin America", "Netherlands", "Norway", "Poland", "Portugal", "Slovak Republic", "Spain", "Sweden", "Switzerland (French)", "Switzerland (German)", "United Kingdom", "United States", "United States (Dvorak)", "Yugoslavia (Serbo-Croatian)" };
        String[] code    = new String[] { "be"     , "br"    , "cf"             , "cz"            , "dk"     , "su"     , "fr"    , "gr"     , "hu"     , "it"   , "la"           , "nl"         , "no"    , "pl"    , "po"      , "sl"             , "sp"   , "sv"    , "sf"                  , "sg"                  , "uk"            , "us"           , "dv103"                 , "yu"                          };
        if(type) {
            for(int i = 0; i < country.length; i++) {
                if(name.toLowerCase().equals(country[i].toLowerCase()))
                    return code[i];
            }
        }
        else {
            for(int i = 0; i < code.length; i++) {
                if(name.toLowerCase().equals(code[i].toLowerCase()))
                    return country[i];
            }
        }
        return name;

    }

    public int getNumerOfColumnsInGameList() {
        return NumerOfColumnsInGameList;
    }

    public void setNumerOfColumnsInGameList(int NumerOfColumnsInGameList) {
        this.NumerOfColumnsInGameList = NumerOfColumnsInGameList;
    }

    

}
