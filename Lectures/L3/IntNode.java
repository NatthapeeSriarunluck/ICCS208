public class IntNode{
    static class Intnode {
        int head;
        Intnode next;
        public Intnode(int head, Intnode next){
            this.head = head;
            this.next = next;
        }
        public String iterativeToString(){
            Intnode current = this;
            StringBuilder ans = new StringBuilder();
            while (current!= null){
                ans.append(Integer.toString(current.head)).append(", ");
                current = current.next;
            }
            return ans.toString();
        }
        public int get(int i) {
            Intnode current = this;
            int index = 0;
            while (index != i){
                current = current.next;
                index ++;
            }
            return current.head;
        }

        public void set(int i, int newValue) {
            Intnode current = this;
            int index = 0;
            while (index != i) {
                current = current.next;
                index++;
            }
            current.head = newValue;
        }
        public Intnode incrList(int delta) {
            if (this.next == null)
                return new Intnode(this.head + delta, null);
            else
                return new Intnode(this.head + delta, this.next.incrList(delta));
        }
    }
}