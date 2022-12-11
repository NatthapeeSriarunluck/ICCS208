import java.util.function.BiFunction;

interface HasIsLarger<T> {
    boolean isLargerThan(T that);
}
interface isLargerThanFunc<T> {
    boolean apply(T a, T b);
}
class LargerThanByName implements isLargerThanFunc<Cat> {
    public boolean apply(Cat a, Cat b) {
        return a.name.length() > b.name.length();
    }
}

class Cat implements HasIsLarger<Cat> {
    Cat(int w, double h, String name){
        this.weight = w;
        this.height = h;
        this.name = name;
    }
    int weight;
    double height;
    String name;

    public boolean isLargerThan(Cat that) {
        return this.weight > that.weight;
    }
}


public class MaxDemo<T> {
    Cat[] fls = {
            new Cat(2, 3.5, "Feline 1"),
            new Cat(1, 2.5, "Feline 2"),
            new Cat(3, 1.5, "Feline 3"),
    };

    static<T> T maxValue(T[] items, BiFunction<T, T, Boolean> isLargerThanFunc){
        int max = 0;
        for (int i = 1; i < items.length; i++) {
            if (isLargerThanFunc.apply(items[i], items[max]))
                max= i;
        }
        return items[max];
    }

    static <T extends HasIsLarger<T>> T maxValue(T[] items){
        int max = 0;
        for (int i = 1; i < items.length; i++) {
            if (items[i].isLargerThan(items[max]))
                max = i;
        }
        return items[max];
    }
}

