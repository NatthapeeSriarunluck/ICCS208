package histogram.game;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

// HINT(s):
//   To read from src/resources/<filename>
//   InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

public class WordDatabase implements IDatabase {
    private final ArrayList<String> database;

    public WordDatabase(String filename) throws FileNotFoundException {
        try {
            database = new ArrayList<>();
            InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
            assert is != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while (line != null) {
                database.add(line.toLowerCase());
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }

    @Override
    public void add(Word w) {
        database.add(w.getWord());
    }

    @Override
    public void remove(Word w) {
        database.remove(w.getWord());
    }

    @Override
    public List<Word> getWordWithLength(int l) {
        List<Word> ans = new ArrayList<>();
        for (String word : database) {
            if (word.length() == l) {
                ans.add(new Word(word));
            }
        }
        return ans;
    }

    @Override
    public List<Word> getAllSubWords(Word w, int minLen) {
        List<Word> ans = new ArrayList<>();
        for (String s : database) {
            if (new Word(s).compareTo(w) != 0 &s.length() >= minLen && w.canForm(new Word(s))) {
                ans.add(new Word(s));
            }
        }
        return ans;
    }

    @Override
    public boolean contains(Word o) {
        return database.contains(o.getWord());
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordDatabase dic = new WordDatabase("linuxwords.txt");
        Word word = new Word("snlcig");
        List<Word> list = dic.getAllSubWords(word, 0);
        for (Word i:list){
            System.out.println(i.getWord());
        }
        }
}
