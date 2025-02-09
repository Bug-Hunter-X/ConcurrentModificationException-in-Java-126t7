public class ConcurrentModificationExceptionSolution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

        // Solution 1: Use an iterator with remove() method
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("B")) {
                iterator.remove();
            }
        }
        System.out.println("Solution 1:" + list);

        //Solution 2: Iterate over a copy of the list
        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> listToRemove = new ArrayList<>();
        for(String item: list2){
            if(item.equals("B")){
                listToRemove.add(item);
            }
        }
        list2.removeAll(listToRemove);
        System.out.println("Solution 2:" + list2);
    }
}