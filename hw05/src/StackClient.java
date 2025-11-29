public class StackClient {
    public static Stack flipped(Stack s) {
        Stack saveS = new Stack();
        Stack flippedS = new Stack();

        int count = s.size();
        for(int i = 0;i < count; i += 1) {
            saveS.push(s.pop());
        }

        for(int i = 0;i < count;i += 1) {
            int val = saveS.pop();
            s.push(val);
            flippedS.push(val);
        }

        return flippedS;
    }
}
