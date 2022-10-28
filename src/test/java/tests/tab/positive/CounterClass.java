package tests.tab.positive;

/**
 * Counter class Singleton
 *
 */
public class CounterClass {
    private Integer index = 0;

    private static Integer instanceCount = 0;

    private CounterClass() {}

    private CounterClass(Integer start) {//20 -- 0 > 10 -- 20 > 40 > 30
        this.index = instanceCount;
        instanceCount += start;
    }

    public static CounterClass getInstance(Integer start){
        return new CounterClass(start);
    }
    public synchronized Integer getIndex() {
        return index;
    }

    public synchronized Integer increment() {
        index++;
        return index;
    }

    public synchronized Integer reset() {
        index = 0;
        return index;
    }
}
