import java.util.ArrayDeque;

public class LearnArrayDeque {
    public static void main(String[] args) {

        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.offer(12);
        adq.offer(13);
        adq.offer(15);
        System.out.println(adq);
        adq.offerFirst(11);
        System.out.println(adq);
        adq.offerLast(17);
        System.out.println(adq);

        System.out.println(adq.peek());
        System.out.println(adq.peekFirst());
        System.out.println(adq.peekLast());
        System.out.println("--------------");
        System.out.println(adq.poll());
        System.out.println(adq.pollFirst());
        System.out.println(adq.pollLast());

        System.out.println(adq);

    }
}
