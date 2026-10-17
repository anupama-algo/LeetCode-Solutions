import java.util.ArrayList;

class FrontMiddleBackQueue {
    private ArrayList<Integer> queue;

    public FrontMiddleBackQueue() {
        queue = new ArrayList<>();
    }

    public void pushFront(int val) {
        queue.add(0, val);
    }

    public void pushMiddle(int val) {
        queue.add(queue.size() / 2, val);
    }

    public void pushBack(int val) {
        queue.add(val);
    }

    public int popFront() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.remove(0);
    }

    public int popMiddle() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.remove((queue.size() - 1) / 2);
    }

    public int popBack() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.remove(queue.size() - 1);
    }
}