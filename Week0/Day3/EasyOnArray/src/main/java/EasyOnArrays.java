public class EasyOnArrays {

    public void printLargestThreeElements(int[] elements){
        int first = 0; int second = 0; int third=0;

        for (int element:elements){
            if (element > first){
               third = second;
               second = first;
               first = element;
            } else if (element>second) {
                third = second;
                second = element;
            }else if (element>third){
                third = element;
            }
        }
        System.out.println(first+" "+second+" "+third);

    }

    public static void pushZerosToEnd(int[] elements){
        {
            int n=elements.length;
            int count = 0;
            for (int i = 0; i < n; i++)
                if (elements[i] != 0)
                    elements[count++] = elements[i];
            while (count < n)
                elements[count++] = 0;
        }

    }
}
