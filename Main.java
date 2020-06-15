public class Main {

    public static void main(String[] args) {
        String s[][] = new String[4][4];
        s[0][0] = "1";
        s[0][1] = "2";
        s[0][2] = "0";
        s[0][3] = "4";
        s[1][0] = "1";
        s[1][1] = "0";
        s[1][2] = "5";
        s[1][3] = "1";
        s[2][0] = "7";
        s[2][1] = "3";
        s[2][2] = "3";
        s[2][3] = "1";
        s[3][0] = "0";
        s[3][1] = "7";
        s[3][2] = "5";
        s[3][3] = "0";
        try {
            checkArray(s);
        }catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }

    public static void checkArray(String mas[][])throws MyArraySizeException{
        processArray(mas);
        convertInt(mas);
    }

    public static void processArray(String mas[][]) throws MyArraySizeException{
        if (mas.length!=4||mas[0].length!=4){
            throw new MyArraySizeException("В данный метод можно внести только массив 4x4");
        }
        else{
            System.out.println("Молодец! Внес массив правильной размерности!");
            outputArray(mas);
        }
    }
    public static void outputArray(String mas[][]){
        for (int i=0;i<mas.length;i++){
            for (int j=0;j<mas.length;j++)
                System.out.print(mas[i][j]+" ");
        System.out.println();
        }
    }
    public static void convertInt(String mas[][]){
        int masInt[][] = new int[mas.length][mas[0].length];
        int s = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                        try {
                            masInt[i][j] = Integer.parseInt(mas[i][j]);
                            s = s + masInt[i][j];
                        }catch(NumberFormatException e){
                            throw new MyArrayDataException("В ячейке ["+i+"]["+j+"] неверное значение '"+mas[i][j]+"'! Будь внимателен!");
                        }

            }
        }
        System.out.println("Сумма массива = "+s);
    }
}
