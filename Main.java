public class Main {

    public static void main(String[] args) {
        System.out.println("Односвязный список:");
        DirectionalList directionalList = new OneDirectionalList();
        directionalList.add("val1");
        directionalList.add("val2");
        directionalList.add("val3");
        directionalList.add("val4");
        directionalList.print();
        System.out.println("Size: " + directionalList.size());

        System.out.println("Removed? - " + directionalList.remove("val6"));
        System.out.println("Removed? - " + directionalList.remove("val3"));
        directionalList.print();

        System.out.println("Односвязный список (массив):");
        String[] arr={"1","2","9","5","9","3"};
        DirectionalList directionalListArray = new OneDirectionalList(arr);
        directionalListArray.print();

        System.out.println("Двухсвязный список:");
        System.out.println("Пред|Знач|След");
        DirectionalList directionalList1 = new TwoDirectionalList();
        directionalList1.add("val1");
        directionalList1.add("val2");
        directionalList1.add("val3");
        directionalList1.add("val4");

        directionalList1.print();
        System.out.println("Size: " + directionalList1.size());

        System.out.println("Удаление элементов:");
        System.out.println("Removed? - " + directionalList1.remove("val6"));
        System.out.println("Removed? - " + directionalList1.remove("val3"));
        directionalList1.print();

        System.out.println("Двухсвязный список (массив):");
        DirectionalList directionalListArray1 = new TwoDirectionalList(arr);
        directionalListArray1.print();
    }
}
