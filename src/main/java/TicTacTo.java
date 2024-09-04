import java.util.*;

public class TicTacTo {

    public static void main(String[] args) {
        String[][] arr = {{" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};
        List<Interval> set = new ArrayList<>();
        int row = -1, col = -1;
        int count = 9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(arr[i][j], " ")) {
                    set.add(new Interval(i, j));
                }
            }
        }
        boolean flag=false;
        while (count >= 0) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Make your move & specify location btn 1 - 9");
            String ch = sc.nextLine();
            int place = sc.nextInt();
            //System.out.println(ch +" "+ place);
            switch (place) {
                case 1:
                    row = 0;
                    col = 0;
                    break;
                case 2:
                    row = 0;
                    col = 1;
                    break;
                case 3:
                    row = 0;
                    col = 2;
                    break;
                case 4:
                    row = 1;
                    col = 0;
                    break;
                case 5:
                    row = 1;
                    col = 1;
                    break;
                case 6:
                    row = 1;
                    col = 2;
                    break;
                case 7:
                    row = 2;
                    col = 0;
                    break;
                case 8:
                    row = 2;
                    col = 1;
                    break;
                case 9:
                    row = 2;
                    col = 2;
                    break;
                default:
                    System.out.println("Invalid location");
                    break;
            }
            //loc = new Interval(row, col);
            if (!Objects.equals(arr[row][col], " ")) {
                System.out.println("Occupied, select other spot");
            } else {
                arr[row][col] = ch.toUpperCase();
                Interval tmp = new Interval(row, col);
                set.remove(tmp);
            }
            /*
            * Check column
            */
            for (int i = 0; i < 3; i++) {
                String a = arr[i][0];
                String b = arr[i][1];
                String c = arr[i][2];
                if (!Objects.equals(a, " ") && Objects.equals(a, b) && Objects.equals(b, c)) {
                    System.out.println("You've WON!!");
                    flag = true;
                    break;
                }
            }
            for (int j = 0; j < 3; j++) {
                String a = arr[0][j];
                String b = arr[1][j];
                String c = arr[2][j];
                if (!Objects.equals(a, " ") && Objects.equals(a, b) && Objects.equals(b, c)) {
                    System.out.println("You've WON!!");
                    flag = true;
                    break;
                }
            }
            if (!Objects.equals(arr[0][0], " ") && Objects.equals(arr[0][0], arr[1][1]) && Objects.equals(arr[1][1], arr[2][2])) {
                System.out.println("You've WON!!");
                flag = true;
                break;
            }
            if (!Objects.equals(arr[0][2], " ") && Objects.equals(arr[0][2], arr[1][1]) && Objects.equals(arr[1][1], arr[2][0])) {
                System.out.println("You've WON!!");
                flag = true;
                break;
            }

            Interval comp = rand(set);
            arr[comp.i][comp.j] = "O";

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Objects.equals(arr[i][j], " ")) {
                        System.out.print("_ ");
                    } else {
                        System.out.print(arr[i][j] + " ");
                    }
                }

                System.out.println();
            }
            count--;
        }
        if(!flag){
            String val ="";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Objects.equals(arr[i][j], " ")) {
                        val = "Undefined";
                        break;
                    }
                }
            }
            if(!val.equals("Undefined")){
                val = "Draw";
            }
            System.out.println(val);
        }
    }

    public static Interval rand(List<Interval> set) {
        Random random = new Random();
        int randidx = random.nextInt(set.size());
        return set.remove(randidx);
    }
}




















