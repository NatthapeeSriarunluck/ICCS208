public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> ans = new Deque<Character>() {
            @Override
            public void addFirst(Character item) {

            }

            @Override
            public void addLast(Character item) {

            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Character removeFirst() {
                return null;
            }

            @Override
            public Character removeLast() {
                return null;
            }

            @Override
            public Character get(int index) {
                return null;
            }
        };
        for (int i = 0; i < word.length(); i++) {
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        String compare = "";
        for (int i = 0; i < word.length(); i++) {
            compare += deque.removeLast();
        }
        return compare.equals(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        char char1 = ' ';
        char char2 = ' ';
        while (deque.size() > 1) {
            char1 = deque.removeFirst();
            char2 = deque.removeLast();
            if (!cc.equalChars(char1, char2)) {
                return false;
            }
        }
        return true;
    }
}