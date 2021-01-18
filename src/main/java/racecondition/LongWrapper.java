package racecondition;

public class LongWrapper {

    private static final Object key = new Object();
    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        synchronized (key) {
            return l;
        }
    }

    /* It is not enough to make variable l volatile
     * We also put synchronized keyword.
     * Because this operation should be atomic.
     * It should not be interrupted when a thread is running it by another thread.
     *
     * Remember synchronized = atomicity
     * 			volatile = visibility
     */
    public void incrementValue() {
        synchronized (key) {
            l = l + 1;
        }
    }
}
