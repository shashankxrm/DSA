package SegmentTree;

class Main {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        segmentTree tree = new segmentTree(arr);
        // tree.display();

        System.out.println(tree.query(1, 6));
    }
}